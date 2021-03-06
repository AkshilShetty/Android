package com.example.nursetestmanagement.userinterface.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.nursetestmanagement.R;
import com.example.nursetestmanagement.models.Test;
import com.example.nursetestmanagement.userinterface.viewModels.TestViewModel;


public class TestActivity extends AppCompatActivity {
    Button addNewTest_bt;
    EditText bplTest_et;
    EditText bphTest_et;
    EditText temperatureTest_et;
    EditText cbcTest_et;
    TestViewModel testViewModel;
    EditText nurseId_et;
    SharedPreferences getPatientIdPre;
    String selectedPatientIdStirng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        bphTest_et=(EditText)findViewById(R.id.test_bph_et);
        bplTest_et=(EditText)findViewById(R.id.test_bpl_et);
        temperatureTest_et=(EditText)findViewById(R.id.test_temperature_et);
        addNewTest_bt=(Button)findViewById(R.id.test_submit_bt);
        nurseId_et=(EditText)findViewById(R.id.test_nurseId_et);
        cbcTest_et=(EditText)findViewById(R.id.test_cbc_et);
        testViewModel= ViewModelProviders.of(this).get(TestViewModel.class);

        getPatientIdPre=getSharedPreferences(String.valueOf(R.string.patientSharedPreference),MODE_PRIVATE);
        selectedPatientIdStirng=getPatientIdPre.getString(String.valueOf(R.string.selectedPatientId),
                               selectedPatientIdStirng);
        addNewTest_bt.setOnClickListener(v->addNewTest());
    }

    private void addNewTest(){
        Test test=new Test();
        test.set_nurseId(Long.parseLong(nurseId_et.getText().toString()));
        test.set_BPH(bphTest_et.getText().toString());
        test.set_BPL(bplTest_et.getText().toString());
        test.set_patientId(Long.parseLong(selectedPatientIdStirng));
        if(temperatureTest_et.getText().toString().equals("")) {test.set_temperature(0); }
        else {test.set_temperature(Double.parseDouble(temperatureTest_et.getText().toString()));}
        if(cbcTest_et.getText().toString().equals("")) {test.set_cbc(0); }
        else {test.set_cbc(Double.parseDouble(cbcTest_et.getText().toString()));}

        testViewModel.insert(test);
        //Go back to test list page
        Intent intent =new Intent(TestActivity.this,ViewTestInforActivity.class);
        startActivity(intent);
    }
}