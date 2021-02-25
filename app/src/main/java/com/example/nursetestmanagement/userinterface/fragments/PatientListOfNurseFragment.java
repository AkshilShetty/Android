package com.example.nursetestmanagement.userinterface.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;


import com.example.nursetestmanagement.R;
import com.example.nursetestmanagement.models.Patient;
import com.example.nursetestmanagement.userinterface.adapters.PatientListViewAdapter;
import com.example.nursetestmanagement.userinterface.viewModels.PatientViewModel;

import java.util.List;

public class PatientListOfNurseFragment extends Fragment {

    private FragmentTransaction mFragmentTransaction;
    private FragmentManager mFragmentManager;
    private ListView patientListView;
    List<Patient> patients;
    private AddPatientFragment addPatientFragment;
    private Button addNewPatient_bt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_patient_list_of_nurse, container, false);
        patientListView=(ListView)view.findViewById(R.id.patientListOfNurse_ListView);
        addNewPatient_bt=view.findViewById(R.id.goToAddNewPatient_bt);
        addNewPatient_bt.setOnClickListener(v -> addPatientButtonOnClick());
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mFragmentManager = this.getActivity().getSupportFragmentManager();

        PatientViewModel patientViewModel= ViewModelProviders.of(this.getActivity()).get(PatientViewModel.class);
        patientViewModel.getAllPatientsByNurse().observe(this,result->{
            patients=result;
            PatientListViewAdapter patientListViewAdapter=
                    new PatientListViewAdapter(this.getActivity(),patients);
            patientListView.setAdapter(patientListViewAdapter);
        });
    }

    public void communicateWithAddPatientFragment(AddPatientFragment addPatientFragment){
        this.addPatientFragment=addPatientFragment;
    }

    private void addPatientButtonOnClick(){
        mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.patientLayout,addPatientFragment);
        mFragmentTransaction.commit();
    }

}