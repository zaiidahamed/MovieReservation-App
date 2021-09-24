package com.example.blueskycinema.Zaid;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blueskycinema.DB_Handler;
import com.example.blueskycinema.R;

import java.util.ArrayList;
import java.util.List;

public class reservationListAdapter extends RecyclerView.Adapter<reservationListAdapter.ViewHolder> {

    private ArrayList<bookingModel> arrayList;
    private Context context;
    private DB_Handler db_handler;

    public reservationListAdapter(Context context, ArrayList<bookingModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        db_handler = new DB_Handler(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.booking_item_list,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final bookingModel model = arrayList.get(position);

        int id = model.getId();
        holder.bl_movieName.setText(model.getMovieName());
        holder.bl_date.setText(model.getDate());
        holder.bl_time.setText(model.getTime());
        holder.bl_amount.setText(model.getAmount());
        holder.bl_movieName.setText(model.getMovieName());

//        holder.bl_editBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                String stringName = holder.print_date2.getText().toString();
////                String stringEmail = holder.print_time2.getText().toString();
//
//                DB_Handler.updateEmployee(new EmployeeModelClass(employeeModelClass.getId(),stringName,stringEmail));
//                notifyDataSetChanged();
//                ((Activity) context).finish();
//                context.startActivity(((Activity) context).getIntent());
//            }
//        });

        holder.bl_removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db_handler.deleteBooking(model.getId());
                arrayList.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView bl_moviePoster;
        TextView bl_movieName, bl_date, bl_time, bl_amount, bl_id;
        Button bl_editBtn, bl_removeBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            bl_moviePoster = itemView.findViewById(R.id.bl_moviePoster);
            bl_movieName = itemView.findViewById(R.id.bl_movieName);
            bl_date = itemView.findViewById(R.id.bl_date);
            bl_time = itemView.findViewById(R.id.bl_time);
            bl_amount = itemView.findViewById(R.id.bl_amount);
            bl_editBtn = itemView.findViewById(R.id.bl_editBtn);
            bl_removeBtn = itemView.findViewById(R.id.bl_removeBtn);

        }
    }
}