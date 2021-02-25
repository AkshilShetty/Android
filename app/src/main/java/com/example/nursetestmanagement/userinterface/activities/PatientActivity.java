package com.example.nursetestmanagement.userinterface.activities;

import android.os.Bundle;
import android.widget.Button;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.nursetestmanagement.R;
import com.example.nursetestmanagement.userinterface.fragments.AddPatientFragment;
import com.example.nursetestmanagement.userinterface.fragments.PatientListOfNurseFragment;


public class PatientActivity extends FragmentActivity {

    private Button addNewPatient_bt;
    private PatientListOfNurseFragment patientListOfNurseFragment;
    private AddPatientFragment addPatientFragment;
    private FragmentTransaction mFragmentTransaction;
    private FragmentManager mFragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        mFragmentManager = getSupportFragmentManager();

        addPatientFragment= new AddPatientFragment();
        patientListOfNurseFragment = new PatientListOfNurseFragment();

        fragmentInitialDisplay();

        patientListOfNurseFragment.communicateWithAddPatientFragment(addPatientFragment);
        addPatientFragment.communicateWithPatientListViewFrag(patientListOfNurseFragment);


    }

    private void fragmentInitialDisplay(){
        if(!patientListOfNurseFragment.isAdded()){
            mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.add(R.id.patientLayout, patientListOfNurseFragment).commit();
        }
    }


}