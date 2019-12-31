package com.example.qr_code.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qr_code.Database.Assets;
import com.example.qr_code.Database.DatabaseHelper;
import com.example.qr_code.R;
import com.example.qr_code.RecyclerView.DetailsAssetsActivity;

import java.util.ArrayList;

public class ListAssetsAdapter extends RecyclerView.Adapter<ListAssetsAdapter.MyViewHolder> {

    Context context;
    ArrayList<Assets> assetsList;

    DatabaseHelper db;

    public ListAssetsAdapter(Context context, ArrayList<Assets> assets) {
        this.context = context;
        this.assetsList = assets;
        db = new DatabaseHelper(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.assets_list, parent, false);

        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Assets assets = assetsList.get(position);

        holder.tv.setText("Assets name : "+assets.getName());
        holder.tvuri.setText("Amount : "+assets.getAmount());

        holder.rl.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("id", assets.getId());

                Intent intent = new Intent(context, DetailsAssetsActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return assetsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        LinearLayout rl;
        TextView tv, tvuri;

        public MyViewHolder(View itemView) {
            super(itemView);

            rl = itemView.findViewById(R.id.rl_assets);
            tv = itemView.findViewById(R.id.assets_name);
            tvuri = itemView.findViewById(R.id.assets_description);
        }
    }
}
