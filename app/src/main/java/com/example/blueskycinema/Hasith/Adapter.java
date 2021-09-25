package com.example.blueskycinema.Hasith;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blueskycinema.DB_Handler;
import com.example.blueskycinema.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

    private Context context;
    private ArrayList<Model> arrayList;
    private DB_Handler db_handler;

    public Adapter(Context context, ArrayList<Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        db_handler = new DB_Handler(context);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.test1, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        Model model = arrayList.get(position);

        //Get for view
        String id = model.getMovieId();
        String name = model.getMovieName();
        String duration = model.getDuration();
        String year = model.getYear();

        //Set view
        holder.MName.setText(name);
        holder.MDuration.setText(duration);
        holder.MYear.setText(year);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class Holder extends RecyclerView.ViewHolder {

//        ImageView profileIv;
        TextView MName, MDuration, MYear;

        public Holder(@NonNull View itemView) {
            super(itemView);

//            profileIv = itemView.findViewById(R.id.profileIv);
            MName = itemView.findViewById(R.id.MName);
            MDuration = itemView.findViewById(R.id.MDuration);
            MYear = itemView.findViewById(R.id.MYear);
        }
    }


}
