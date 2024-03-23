package com.example.e_parchi_frontend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

// This is the Doctor class that extends the AppCompatActivity class
public class Doctor extends AppCompatActivity {

    // Instance variables for the RecyclerView, database reference, adapter, and list of doctor_ objects
    RecyclerView recyclerView;
    DatabaseReference database;
    DoctorAdapter myAdapter;
    ArrayList<doctor_> list;

    // Method called when the activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content view for the activity
        setContentView(R.layout.fragment_doctor);

        // Initialize the RecyclerView, database reference, and list of doctor_ objects
        recyclerView = findViewById(R.id.userList);
        database = FirebaseDatabase.getInstance().getReference("doctor");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdapter = new DoctorAdapter(this, list);
        recyclerView.setAdapter(myAdapter);

        // Add a ValueEventListener to the database reference to listen for changes in the data
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Loop through each child in the snapshot
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    // Get a doctor_ object from the dataSnapshot and add it to the list
                    doctor_ user = dataSnapshot.getValue(doctor_.class);
                    list.add(user);
                }
                // Notify the adapter that the data has changed
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // This method is called if there is an error reading data from the database
            }
        });
    }
}
