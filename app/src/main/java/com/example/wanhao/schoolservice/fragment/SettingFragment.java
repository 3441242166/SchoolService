package com.example.wanhao.schoolservice.fragment;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.example.wanhao.schoolservice.R;

/**
 * Created by wanhao on 2017/12/2.
 */

public class SettingFragment extends PreferenceFragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.setting);
    }


}
