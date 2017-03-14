package com.arp.app.adaptadores;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.CycleInterpolator;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.arp.app.R;
import com.arp.app.bd.Contrato;
import com.arp.app.pojo.ClienteEjercicio;
import com.arp.app.pojo.Ejercicio;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

/**
 * Created by pc-aromero on 03/05/2016.
 */
public class AdaptadorEjercicio  extends ArrayAdapter<ClienteEjercicio> {

    private List<ClienteEjercicio> ejercicios;
    private LayoutInflater i;
    private Context c;

    public AdaptadorEjercicio(Context c, List<ClienteEjercicio> ejercicios) {
        super(c, R.layout.lista_ejercicio,ejercicios);
        this.c=c;
        this.ejercicios=ejercicios;
        i=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh=null;
        if(vh==null){

            vh=new ViewHolder();
            convertView=i.inflate(R.layout.lista_ejercicio,null);
            vh.tvEjer=(TextView)convertView.findViewById(R.id.tvEjer);
            vh.tvRep=(TextView)convertView.findViewById(R.id.tvRep);
            vh.img=(ImageView) convertView.findViewById(R.id.img);
            convertView.setTag(vh);
        }else {
            vh=(ViewHolder)convertView.getTag();
        }
        String select=ejercicios.get(position).getIdejercicio()+"";
        Cursor cursor=c.getContentResolver().query(Contrato.TablaEjercicio.CONTENT_URI,null,Contrato.TablaEjercicio._ID+" =?",new String[]{select},null);
        cursor.moveToFirst();
        vh.tvEjer.setText(cursor.getString(cursor.getColumnIndex(Contrato.TablaEjercicio.NOMBRE)));
        vh.tvRep.setText(ejercicios.get(position).getDuracion());
        File f=new File(c.getExternalFilesDir(Environment.DIRECTORY_PICTURES),cursor.getString(cursor.getColumnIndex(Contrato.TablaEjercicio.IMAGEN)));
        Picasso.with(c).load(f).into(vh.img);
        return convertView;
    }

    private class ViewHolder{
        private TextView tvEjer,tvRep;
        private ImageView img;
    }
}
