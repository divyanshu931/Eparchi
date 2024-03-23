package com.example.e_parchi_frontend;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder>{


    Context context;

    ArrayList<HistroyData> list;


    public HistoryAdapter(Context context, ArrayList<HistroyData> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.history_number,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        HistroyData user = list.get(position);

        holder.basicInfo.setText(user.getBasicInfo());
        holder.date.setText(user.getData());
        holder.ReportInfo.setText(user.getReportinfo());

        Glide.with(holder.Reporturl.getContext())
                .load(user.getReporturl())
                .placeholder(com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_dark_normal_background)
                .circleCrop()
                .error(com.google.firebase.database.R.drawable.common_google_signin_btn_icon_dark)
                .into(holder.Reporturl);

        Glide.with(holder.Billurl.getContext())
                .load(user.getBillurl())
                .placeholder(com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_dark_normal_background)
                .circleCrop()
                .error(com.google.firebase.database.R.drawable.common_google_signin_btn_icon_dark)
                .into(holder.Billurl);



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView basicInfo,date,ReportInfo;
        ImageView Reporturl, Billurl;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ReportInfo=itemView.findViewById(R.id.testinfo);
            Reporturl = itemView.findViewById(R.id.reportPhoto);
            Billurl= itemView.findViewById(R.id.post);
            date = itemView.findViewById(R.id.date);
            basicInfo=itemView.findViewById(R.id.data);


        }
    }

}
