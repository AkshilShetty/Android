package com.example.nursetestmanagement.userinterface.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.example.nursetestmanagement.databases.NurseRepository;
import com.example.nursetestmanagement.models.Nurse;

import java.util.List;
import java.util.Optional;

public class NurseViewModel extends AndroidViewModel {

    private LiveData<Long> _insertNurseIdResult;
    private LiveData<Integer> _updateResult;
    private LiveData<List<Nurse>> _getAllNurse;
    private LiveData<Nurse> _getLoginNurse;
    private NurseRepository nurseRepository;


    public NurseViewModel(@NonNull Application application) {
        super(application);
        nurseRepository = new NurseRepository(application);
        _insertNurseIdResult = nurseRepository.getNurseInsertNurseIdResult();
        _updateResult = nurseRepository.getNurseUpdateResult();
    }

    public void insertNurse(Nurse nurse) {
        nurseRepository.insertNurse(nurse);
    }

    public LiveData<Optional<Nurse>> getLoginNurseInfor(Long nurseId) {
        return nurseRepository.getLoginNurseInfor(nurseId);
    }

    public LiveData<List<Nurse>> getAllNurse() {
        return nurseRepository.getNurseList();
    }

    public LiveData<Long> get_insertNurseIdResult() {
        return _insertNurseIdResult;
    }

    public LiveData<Integer> get_updateResult() {
        return _updateResult;
    }
}


