package com.arp.app.adaptadores;

import android.content.Context;
import android.database.Cursor;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.arp.app.R;
import com.arp.app.bd.Contrato;
import com.arp.app.pojo.ClienteComida;
import com.arp.app.pojo.Comida;
import com.arp.app.pojo.Hora;

import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by pc-aromero on 03/05/2016.
 */
public class AdaptadorComida extends BaseExpandableListAdapter {
    private Context c;
    private List<Hora> cabecera;
    private LayoutInflater i;
    private HashMap<Hora,List<ClienteComida>> contenido;

    public AdaptadorComida(Context c, List<Hora> cabecera, HashMap<Hora, List<ClienteComida>> contenido) {
        this.c = c;
        this.cabecera = cabecera;
        this.contenido = contenido;

    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.contenido.get(this.cabecera.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ClienteComida cc=(ClienteComida)getChild(groupPosition,childPosition);
        if(convertView==null){
            i=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = i.inflate(R.layout.lista_comida, null);
        }
        TextView tvComida=(TextView)convertView.findViewById(R.id.tvComida);
        TextView tvCantidad=(TextView)convertView.findViewById(R.id.tvCantidad);
        Cursor cursor=c.getContentResolver().query(Contrato.TablaComida.CONTENT_URI,null,Contrato.TablaComida._ID+" = ?",new String[]{cc.getIdcomida()+""},null);
        cursor.moveToFirst();
        tvComida.setText(cursor.getString(cursor.getColumnIndex(Contrato.TablaComida.NOMBRE)));
        tvCantidad.setText(cc.getCantidad());
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.contenido.get(this.cabecera.get(groupPosition)).size();
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        Hora headerTitle = (Hora) getGroup(groupPosition);
        if(convertView==null){
            i=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = i.inflate(R.layout.lista_comida_cabecera, null);
        }
        TextView tvCabecera=(TextView)convertView.findViewById(R.id.tvCabecera);
        tvCabecera.setText(headerTitle.getHora());
        return convertView;
    }

    @Override
    public int getGroupCount() {
        return this.cabecera.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.cabecera.get(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

}
