package com.example.e_parchi_frontend;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class home extends Fragment {
    CardView doctor,LabTest,Therapy,Medicines,Cosmetics,Drugs_Info;

    public home() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        doctor=view.findViewById(R.id.doctor_card);
        LabTest=view.findViewById(R.id.Lab_test_card);
        Therapy=view.findViewById(R.id.Thearapy_card);
        Medicines=view.findViewById(R.id.Medicine_card);
        Cosmetics=view.findViewById(R.id.Cosmetics_card);
        Drugs_Info=view.findViewById(R.id.drugs_info_card);

        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MyApp", "Doctor card clicked");
                Intent intent = new Intent(home.this.getActivity().getApplicationContext(),Doctor.class);
                startActivity(intent);
                getActivity().finish();
            }
        });



        LabTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment newFragment = new LabTest();

                // Replace the current fragment with the new fragment

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, newFragment);
                transaction.commit();
            }
        });

        Therapy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment newFragment = new Therapy();

                // Replace the current fragment with the new fragment

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, newFragment);
                transaction.commit();
            }
        });
        Medicines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment newFragment = new Medicines();

                // Replace the current fragment with the new fragment

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, newFragment);
                transaction.commit();
            }
        });

        Cosmetics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment newFragment = new Cosmetics();

                // Replace the current fragment with the new fragment

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, newFragment);
                transaction.commit();
            }
        });

        Drugs_Info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment newFragment = new DrugsInfo();

                // Replace the current fragment with the new fragment

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, newFragment);
                transaction.commit();
            }
        });

        return  view;
    }
}