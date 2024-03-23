package com.example.e_parchi_frontend;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class RecordsFragment extends Fragment {

    ImageView Uploadbygallery;
    ImageView getUploadcamera;




    public RecordsFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_record,container,false);
        getUploadcamera=view.findViewById(R.id.Upload_from_Camera);
        Uploadbygallery=view.findViewById(R.id.Upload_from_Gallery);

        getUploadcamera.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Fragment newFragment = new Upload_photo();

                // Replace the current fragment with the new fragment
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        Uploadbygallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment newFragment = new Upload_photo();

                // Replace the current fragment with the new fragment

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
                Intent galleryIntent = new Intent();
                galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent , 2);

            }
        });



        return  view;

    }
}