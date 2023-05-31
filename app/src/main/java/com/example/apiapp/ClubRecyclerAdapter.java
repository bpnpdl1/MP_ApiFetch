package com.example.apiapp;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ClubRecyclerAdapter extends RecyclerView.Adapter<ClubRecyclerAdapter.ViewHolder>{
    Activity context;
    ArrayList<ClubModal> data;

    public ClubRecyclerAdapter(Activity context,ArrayList<ClubModal> data){
      this.context=context;
      this.data=data;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=(context).getLayoutInflater().inflate(R.layout.clubitems,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ClubModal current=data.get(position);
      holder.tvClubName.setText(current.getName());
      holder.tvClubAddress.setText(current.getAddress());
      holder.tvClubType.setText(current.getType());
      holder.tvClubEntryFee.setText(current.getType());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvClubName,tvClubAddress,tvClubType,tvClubEntryFee;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
             tvClubName=itemView.findViewById(R.id.tvClubName);
             tvClubAddress=itemView.findViewById(R.id.tvCLubAddress);
             tvClubType=itemView.findViewById(R.id.tvClubType);
             tvClubEntryFee=itemView.findViewById(R.id.tvClubEntryFee);




        }
    }

}
