package com.example.wanhao.schoolservice.activity;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.presenter.LodingPresenter;
import com.example.wanhao.schoolservice.view.ILodingView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class LodingActivity extends AppCompatActivity implements View.OnClickListener,ILodingView {
    private static final String TAG = "LodingActivity";

    @BindView(R.id.ac_loding_forget)
    TextView btForget;
    @BindView(R.id.ac_loding_loding)
    Button btGo;
    @BindView(R.id.ac_loding_fab)
    FloatingActionButton fab;
    @BindView(R.id.ac_loding_count)
    EditText etUsername;
    @BindView(R.id.ac_loding_password)
    EditText etPassword;

    SweetAlertDialog pDialog;

    LodingPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setContentView(R.layout.activity_loding);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initView();

        fab.setOnClickListener(this);
        btGo.setOnClickListener(this);
        btForget.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ac_loding_fab:
//                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(this,
//                        //Pair.create((View)btGo, btGo.getTransitionName()),
//                        Pair.create((View)fab, fab.getTransitionName()),
//                        Pair.create((View)cardView, cardView.getTransitionName())).toBundle();
//                startActivity(new Intent(this, RegisterActivity.class), bundle);
                startActivity(new Intent(this, RegisterActivity.class), ActivityOptions.makeSceneTransitionAnimation(this,
                        fab, fab.getTransitionName()).toBundle());
                break;
            case R.id.ac_loding_loding:
                hideKeyboard();
                presenter.login(etUsername.getText().toString(),etPassword.getText().toString());
                break;
            case R.id.ac_loding_forget:

                break;
        }
    }

    private void initView() {

        pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading");
        pDialog.setCancelable(false);

        presenter = new LodingPresenter(this,this);
    }

    @Override
    public void gotoChooseInterestedCategoryActivity(String msg) {

    }

    @Override
    public void showProgress() {
        pDialog.show();
    }

    @Override
    public void disimissProgress() {
        pDialog.hide();
    }

    @Override
    public void loadDataSuccess(Object tData) {
        startActivity(new Intent(this, MainActivity.class));
        pDialog.hide();
    }

    @Override
    public void loadDataError(String throwable) {
        Toast.makeText(this,throwable,Toast.LENGTH_SHORT).show();
        pDialog.hide();
    }

    private void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

}

