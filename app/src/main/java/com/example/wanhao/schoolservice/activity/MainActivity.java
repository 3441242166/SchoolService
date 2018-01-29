package com.example.wanhao.schoolservice.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.customizeview.NoScrollViewPager;
import com.example.wanhao.schoolservice.fragment.BBSFagment;
import com.example.wanhao.schoolservice.fragment.MainFragment;
import com.example.wanhao.schoolservice.fragment.MessageFragment;
import com.example.wanhao.schoolservice.fragment.UserFragment;
import com.example.wanhao.schoolservice.myview.BottomView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    BottomView bottomUser;
    BottomView bottomMain;
    BottomView bottomMessage;
    BottomView bottomMarket;
    NoScrollViewPager viewPager;

    private UserFragment userFragment;
    private MessageFragment messageFragment;
    private BBSFagment BBSFagment;
    private MainFragment mainFragment;
    private List<Fragment> fragmentList;
    private FragmentPagerAdapter adapter;

    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        initView();
        initEvent();
        changeState(0);
    }

    private void initEvent() {
        viewPager.setNoScroll(true);

        bottomMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeState(0);
            }
        });

        bottomUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeState(3);
            }
        });

        bottomMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeState(1);
            }
        });

        bottomMarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeState(2);
            }
        });

    }

    private void initView() {
        viewPager = (NoScrollViewPager) findViewById(R.id.ac_main_viewpager);
        bottomUser = (BottomView) findViewById(R.id.ac_main_user);
        bottomMain = (BottomView) findViewById(R.id.ac_main_main);
        bottomMessage = (BottomView) findViewById(R.id.ac_main_message);
        bottomMarket = (BottomView) findViewById(R.id.ac_main_market);

        fragmentList = new ArrayList<>();
        mainFragment = new MainFragment();
        messageFragment = new MessageFragment();
        BBSFagment = new BBSFagment();
        userFragment = new UserFragment();
        fragmentList.add(mainFragment);
        fragmentList.add(messageFragment);
        fragmentList.add(BBSFagment);
        fragmentList.add(userFragment);

        adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };
        viewPager.setAdapter(adapter);

    }

    private void changeState(int position){
        bottomUser.setImage(R.drawable.mainicon_3);
        bottomMain.setImage(R.drawable.mainicon_0);
        bottomMessage.setImage(R.drawable.mainicon_1);
        bottomMarket.setImage(R.drawable.mainicon_2);

        bottomUser.setTextColor(false);
        bottomMain.setTextColor(false);
        bottomMessage.setTextColor(false);
        bottomMarket.setTextColor(false);

        viewPager.setCurrentItem(position);

        switch (position){
            case 0:
                bottomMain.setTextColor(true);
                bottomMain.setImage(R.drawable.mainicon_click_0);
                break;
            case 1:
                bottomMessage.setTextColor(true);
                bottomMessage.setImage(R.drawable.mainicon_click_1);
                break;
            case 2:
                bottomMarket.setTextColor(true);
                bottomMarket.setImage(R.drawable.mainicon_click_2);
                break;
            case 3:
                bottomUser.setTextColor(true);
                bottomUser.setImage(R.drawable.mainicon_click_3);
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
