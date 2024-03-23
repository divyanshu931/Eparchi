package com.example.e_parchi_frontend;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import static android.app.Activity.RESULT_OK;

public class Upload_photo extends Fragment {

    private ImageView imageView;
    private Button upload;
    private ProgressBar progressBar;

    //vars


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.upload_photo, container, false);

        imageView = view.findViewById(R.id.scenery);
        upload = view.findViewById(R.id.uploadBtn);
        progressBar = view.findViewById(R.id.progressBar);


        progressBar.setVisibility(View.INVISIBLE);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return view;
    }
}







