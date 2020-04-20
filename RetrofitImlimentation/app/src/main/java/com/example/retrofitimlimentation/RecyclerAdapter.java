package com.example.retrofitimlimentation;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ImageViewHolder> {


    private Context context;
    ArrayList<Hero> list;
    public RecyclerAdapter(Context context,ArrayList<Hero> list){
        this.list=list;
        this.context=context;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent,false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view,context);
        return imageViewHolder;
    }
    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {

        holder.image.setImageURI(Uri.parse(list.get(position).getImageurl()));
        Log.d("imageuri", list.get(position).getImageurl());
        holder.name.setText(list.get(position).getName()+"("+list.get(position).getRealname()+")");
        holder.teamName.setText(list.get(position).getTeam());
        holder.createrName.setText(list.get(position).getCreatedby());
        holder.pub.setText(list.get(position).getPublisher());
    }
    @Override
    public int getItemCount() {
       if(list!=null) {
            return list.size();
        }
        return 0;
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name,teamName,createrName,pub;
        Context context;
        public ImageViewHolder(@NonNull View itemView,Context context) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            teamName = itemView.findViewById(R.id.teamName);
            createrName= itemView.findViewById(R.id.createdBy);
            pub=itemView.findViewById(R.id.publisher);
            this.context =context;

        }


        /*public void onClick(View v) {
            n=AlbumTitle.getText().toString();
            p=phone.getText().toString();
            Intent intent = new Intent(context, DetailsActivity.class);

            intent.putExtra("image_id",images[getAdapterPosition()]);
            intent.putExtra("name",String.valueOf(name[getPosition()]));
            intent.putExtra("phone",p);
            context.startActivity(intent);
        }*/
    }
    public void setHeroList(ArrayList<Hero> movieList) {
        this.list = movieList;
        notifyDataSetChanged();
    }
}