package com.arp.app.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.arp.app.R;

import java.util.List;

/**
 * Created by pc-aromero on 29/04/2016.
 */
public class Adaptador extends ArrayAdapter<String>{

    private String[] dias;
    private LayoutInflater i;

    public Adaptador(Context context, String[] dias) {
        super(context, R.layout.lista_detalle,dias);
        this.dias=dias;
        i=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh=null;
        if(vh==null){
            vh=new ViewHolder();
            convertView=i.inflate(R.layout.lista_detalle,null);
            vh.tv=(TextView)convertView.findViewById(R.id.tvDia);
            convertView.setTag(vh);
        }else {
            vh=(ViewHolder)convertView.getTag();
        }
        vh.tv.setText(dias[position]);
        return convertView;
    }

    private class ViewHolder{
        private TextView tv;
    }
}
