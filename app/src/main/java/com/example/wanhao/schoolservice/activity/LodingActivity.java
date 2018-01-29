package com.example.wanhao.schoolservice.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.presenter.LodingPresenter;
import com.example.wanhao.schoolservice.view.ILodingView;

public class LodingActivity extends AppCompatActivity implements ILodingView{
    private static final String TAG = "LodingActivity";

    private Button btLoding;
    private TextView txRegister;
    private TextView txForget;
    private TextInputLayout count;
    private TextInputLayout password;

    private LodingPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loding);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initView();
        initEvent();
    }

    private void initView() {

        btLoding = (Button) findViewById(R.id.ac_loding_loding);
        txRegister = (TextView) findViewById(R.id.ac_loding_register);
        txForget = (TextView) findViewById(R.id.ac_loding_forget);
        count = (TextInputLayout) findViewById(R.id.ac_loding_countlayout);
        password = (TextInputLayout) findViewById(R.id.ac_loding_passwordlayout);
        presenter = new LodingPresenter(this,this);
    }

    private void initEvent() {
        txRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        txForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btLoding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
                count.setErrorEnabled(false);
                password.setErrorEnabled(false);
                presenter.login(count.getEditText().getText().toString(),
                        password.getEditText().getText().toString());
            }
        });
    }

    @Override
    public void loginSuccess(String msg) {

    }

    @Override
    public void loginFailed(String msg) {
        count.setError("Not a valid email address!");
    }

    @Override
    public void validateError(String msg,int type) {
        if(type == 0)
            count.setError(msg);
        else
            password.setError(msg);
    }

    @Override
    public void gotoChooseInterestedCategoryActivity(String msg) {

    }

    private void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
