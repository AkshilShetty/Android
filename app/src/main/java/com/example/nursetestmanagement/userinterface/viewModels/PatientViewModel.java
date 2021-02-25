package com.example.nursetestmanagement.userinterface.viewModels;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.example.nursetestmanagement.R;
import com.example.nursetestmanagement.databases.PatientRepository;
import com.example.nursetestmanagement.models.Patient;

import java.util.List;

public class PatientViewModel extends AndroidViewModel {
    private PatientRepository patientRepository;
    private Long nurseId;
    private SharedPreferences getNurseIdSharedPreference;
    public PatientViewModel(@NonNull Application application) {
        super(application);
        getNurseIdSharedPreference=application.getSharedPreferences(String.valueOf(R.string.nurseSharedReference), Context.MODE_PRIVATE);
        nurseId=Long.parseLong(getNurseIdSharedPreference.getString(String.valueOf(R.string.autherizedNurseId), String.valueOf(nurseId)));
        patientRepository=new PatientRepository(application);
    }

    public LiveData<List<Patient>> getAllPatientsByNurse(){
        return patientRepository.getPatientList(nurseId);
    }
    public void insertPatient(Patient patient){
        patientRepository.insert(patient);
    }
    public void updatePatient(Patient patient){
        patientRepository.update(patient);
    }
    public LiveData<Patient> getPatientInfor(Long patientId){
        return patientRepository.getPatientInfor(patientId);
    }

    public LiveData<Integer> getUpdateResult(){
        return patientRepository.getUpdateResult();
    }
}
