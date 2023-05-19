package com.moutamid.simpleaircraftandroidapp.ui.featured;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FeatureViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public FeatureViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}