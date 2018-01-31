package com.example.wanhao.schoolservice.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.wanhao.schoolservice.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "RegisterActivity";

    Button btGo;
    FloatingActionButton fab;
    EditText etUsername;
    EditText etPassword;
    EditText etSchoolId;
    EditText etSchool;
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        InitView();
        InitEvent();
    }

    private void InitView() {
        etPassword = (EditText) findViewById(R.id.ac_register_password);
        etUsername = (EditText) findViewById(R.id.ac_register_count);
        etSchoolId = (EditText) findViewById(R.id.ac_register_schoolid);
        etSchool = (EditText) findViewById(R.id.ac_register_school);
        btGo = (Button) findViewById(R.id.ac_register_loding);
        fab = (FloatingActionButton) findViewById(R.id.ac_register_fab);
        cardView = (CardView) findViewById(R.id.ac_register_cardview);

        btGo.setOnClickListener(this);
        fab.setOnClickListener(this);

    }

    private void InitEvent() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ac_register_loding:

                break;
            case R.id.ac_register_fab:
                finish();
                break;
        }
    }

}
