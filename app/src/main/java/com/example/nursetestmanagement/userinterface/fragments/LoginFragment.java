package com.example.nursetestmanagement.userinterface.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.example.nursetestmanagement.R;
import com.example.nursetestmanagement.userinterface.activities.LoginActivity;


public class LoginFragment extends Fragment {

    private ImageButton login_bt;
    private Intent intent;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);
        return view;
    }

    public void fragmentShow(){
        login_bt=(ImageButton)getView().findViewById(R.id.login_fragment_bt);
        login_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }



}