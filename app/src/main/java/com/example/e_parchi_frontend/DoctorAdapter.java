package com.example.e_parchi_frontend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

// This is the DoctorAdapter class that extends the RecyclerView.Adapter class
public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.MyViewHolder> {

    // Instance variables to store the context and list of doctor_ objects
    Context context;
    ArrayList<doctor_> list;

    // Constructor that takes in a Context and an ArrayList of doctor_ objects
    public DoctorAdapter(Context context, ArrayList<doctor_> list) {
        this.context = context;
        this.list = list;
    }

    // Method to create a new ViewHolder for each item in the RecyclerView
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each item
        View v = LayoutInflater.from(context).inflate(R.layout.items, parent, false);
        // Return a new instance of the MyViewHolder inner class
        return new MyViewHolder(v);
    }

    // Method to bind the data from the doctor_ object at the given position to the views in the ViewHolder
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Get the doctor_ object at the given position
        doctor_ user = list.get(position);
        // Set the text for each view in the ViewHolder using the getter methods from the doctor_ class
        holder.Name_.setText(user.getName());
        holder.Post.setText(user.getPost());
        holder.Hospital.setText(user.getHospital());
        holder.experience.setText(user.getExperience());
        holder.specification.setText(user.getSpecification());

        // Use Glide to load the image from the surl instance variable into the CircleImageView
        Glide.with(holder.Surl.getContext())
                .load(user.getSurl())
                .placeholder(com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_dark_normal_background)
                .circleCrop()
                .error(com.google.firebase.database.R.drawable.common_google_signin_btn_icon_dark)
                .into(holder.Surl);
    }

    // Method to return the number of items in the list
    @Override
    public int getItemCount() {
        return list.size();
    }

    // Inner class that extends RecyclerView.ViewHolder
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // Instance variables for each view in the ViewHolder
        TextView Name_, Post, Hospital, experience, specification;
        CircleImageView Surl;

        // Constructor that takes in an itemView and initializes each view by calling findViewById on it
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Surl = itemView.findViewById(R.id.doctorPhoto);
            Name_ = itemView.findViewById(R.id.Name);
            Post = itemView.findViewById(R.id.post);
            Hospital = itemView.findViewById(R.id.hospital);
            experience = itemView.findViewById(R.id.experience);
            specification = itemView.findViewById(R.id.specification);
        }
    }
}
