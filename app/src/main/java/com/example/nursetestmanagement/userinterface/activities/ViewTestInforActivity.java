package com.example.nursetestmanagement.userinterface.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.nursetestmanagement.R;
import com.example.nursetestmanagement.userinterface.fragments.TestRecyclerFragment;


public class ViewTestInforActivity extends AppCompatActivity {
    Button delete_bt,addNewTest_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_test_infor);
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        TestRecyclerFragment fragment=new TestRecyclerFragment();
        transaction.replace(R.id.testRecyclerFragLayout,fragment);
        transaction.commit();
        addNewTest_bt=(Button)findViewById(R.id.testListView_addNewTest_bt);
        addNewTest_bt.setOnClickListener(v->addNewTest());
    }

    private void addNewTest(){
        Intent intent =new Intent(this,TestActivity.class);
        startActivity(intent);
    }
}