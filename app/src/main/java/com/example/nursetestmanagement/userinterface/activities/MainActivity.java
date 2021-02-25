package com.example.nursetestmanagement.userinterface.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nursetestmanagement.R;
import com.example.nursetestmanagement.userinterface.fragments.LoginFragment;
import com.example.nursetestmanagement.userinterface.fragments.RegisterFragment;


public class MainActivity extends AppCompatActivity {
private LoginFragment loginFragment;
private RegisterFragment registerFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginFragment=(LoginFragment)getSupportFragmentManager().findFragmentById(R.id.login_fragment);
        registerFragment=(RegisterFragment)getSupportFragmentManager().findFragmentById(R.id.register_fragment);
        loginFragment.fragmentShow();
        registerFragment.fragmentShow();
    }
}