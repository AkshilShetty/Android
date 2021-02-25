package com.example.nursetestmanagement.userinterface.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.example.nursetestmanagement.R;
import com.example.nursetestmanagement.userinterface.activities.RegisterActivity;


public class RegisterFragment extends Fragment {
    private ImageButton register_bt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_register, container, false);
        return view;
    }

    public void fragmentShow(){
        register_bt=(ImageButton)getView().findViewById(R.id.register_fragment_bt);
        register_bt.setOnClickListener(v -> {
            Intent intent=new Intent(getActivity(), RegisterActivity.class);
            startActivity(intent);
        });
    }

}