package com.example.paisatracker;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private List<data_list> userlist;

    public Adapter(List<data_list> userlist){
        this.userlist = userlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int money = userlist.get(position).getMoney();
        String comment = userlist.get(position).getComment();
        holder.setdata(money , comment);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv1 , tv2;
        RelativeLayout blueprint;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.money);
            tv2 = itemView.findViewById(R.id.comment_display);
            blueprint = itemView.findViewById(R.id.blueprint);
        }
        public void setdata(int money, String comment) {
            tv1.setText(money);
            tv2.setText(comment);
        }
    }
}
