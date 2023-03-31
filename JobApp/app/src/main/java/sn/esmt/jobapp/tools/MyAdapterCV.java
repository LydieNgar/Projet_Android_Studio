package sn.esmt.jobapp.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import sn.esmt.jobapp.R;
import sn.esmt.jobapp.httpconfig.CVResponse;


public class MyAdapterCV extends BaseAdapter{

    private ArrayList<CVResponse> cvs;
    private LayoutInflater myInflater;

    public MyAdapterCV(Context context, ArrayList<CVResponse> cvs){
        this.myInflater = LayoutInflater.from(context);
        this.cvs = cvs;
    }

    @Override
    public int getCount() {
        return this.cvs.size();
    }

    @Override
    public Object getItem(int arg0) {
        return this.cvs.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        TextView textid;

        TextView textemail;
        TextView texttelephone;
        TextView textprenom;
        TextView textnom;
        TextView textage;
        TextView textspecialite;
        TextView textexperienceprofessionnelle;
        TextView textadresse;
        TextView textniveauetude;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;

        if(convertView == null){
            convertView = myInflater.inflate(R.layout.listitem_cv, null);
            holder = new ViewHolder();
            holder.textid = (TextView) convertView.findViewById(R.id.txtid);
            holder.textnom = (TextView) convertView.findViewById(R.id.txtnom);
            holder.textprenom = (TextView) convertView.findViewById(R.id.txtprenom);
            holder.textage = (TextView) convertView.findViewById(R.id.txtage);
            holder.textemail = (TextView) convertView.findViewById(R.id.txtemail);
            holder.texttelephone = (TextView) convertView.findViewById(R.id.txttelephone);
            holder.textadresse = (TextView) convertView.findViewById(R.id.txtadresse);
            holder.textniveauetude = (TextView) convertView.findViewById(R.id.txtniveauetude);
            holder.textspecialite = (TextView) convertView.findViewById(R.id.txtspecialite);
            holder.textexperienceprofessionnelle = (TextView) convertView.findViewById(R.id.txtexperienceprofessionnelle);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textid.setText(cvs.get(position).getId()+"");
        holder.textnom.setText(cvs.get(position).getNom());
        holder.textprenom.setText(cvs.get(position).getPrenom());
        holder.textage.setText(cvs.get(position).getAge());
        holder.textemail.setText(cvs.get(position).getEmail());
        holder.texttelephone.setText(cvs.get(position).getTelephone());
        holder.textadresse.setText(cvs.get(position).getAdresse());
        holder.textniveauetude.setText(cvs.get(position).getNiveauEtude());
        holder.textspecialite.setText(cvs.get(position).getSpecialite());
        holder.textexperienceprofessionnelle.setText(cvs.get(position).getExperienceProfessionnelle());

        return convertView;
    }
}



