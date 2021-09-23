package com.example.blueskycinema.Zaid;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blueskycinema.DB_Handler;
import com.example.blueskycinema.R;

import java.util.ArrayList;
import java.util.List;

public class reservationListAdapter extends RecyclerView.Adapter<reservationListAdapter.ViewHolder> {

    List<bookingModel> booking;
    Context context;
    DB_Handler db_handler;

    public reservationListAdapter(List<bookingModel> booking, Context context) {
        this.booking = booking;
        this.context = context;
        db_handler = new DB_Handler(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.reservations_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final bookingModel bookingModel = booking.get(position);

        holder.movieName3.setText(bookingModel.getId());
        holder.print_date2.setText(bookingModel.getDate());
        holder.print_time2.setText(bookingModel.getTime());
        holder.print_tot2.setText(bookingModel.getAmount());

        holder.rv_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String stringName = holder.print_date2.getText().toString();
//                String stringEmail = holder.print_time2.getText().toString();
//
//                DB_Handler.updateEmployee(new EmployeeModelClass(employeeModelClass.getId(),stringName,stringEmail));
//                notifyDataSetChanged();
//                ((Activity) context).finish();
//                context.startActivity(((Activity) context).getIntent());
            }
        });

        holder.rv_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db_handler.deleteBooking(bookingModel.getId());
                booking.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView moviePoster1;
        TextView movieName3, print_date2, print_time2, print_tot2;
        Button rv_edit, rv_remove;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            moviePoster1 = itemView.findViewById(R.id.moviePoster1);
            movieName3 = itemView.findViewById(R.id.movieName3);
            print_date2 = itemView.findViewById(R.id.print_date2);
            print_time2 = itemView.findViewById(R.id.print_time2);
            print_tot2 = itemView.findViewById(R.id.print_tot2);
            rv_edit = itemView.findViewById(R.id.rv_edit);
            rv_remove = itemView.findViewById(R.id.rv_remove);

        }
    }
}


/*
public class RecyclerViewAdapter extends RecyclerView.ViewHolder{

        ImageView moviePoster1;
        TextView movieName3, print_date2, print_time2, print_tot2;
        Button rv_edit, rv_remove;

        public RecyclerViewAdapter(@NonNull View v) {
            super(v);

            moviePoster1 = v.findViewById(R.id.moviePoster1);
            movieName3 = v.findViewById(R.id.movieName3);
            print_date2 = v.findViewById(R.id.print_date2);
            print_time2 = v.findViewById(R.id.print_time2);
            print_tot2 = v.findViewById(R.id.print_tot2);

            rv_edit = v.findViewById(R.id.rv_edit);
            rv_remove = v.findViewById(R.id.rv_remove);
        }
    }
 */