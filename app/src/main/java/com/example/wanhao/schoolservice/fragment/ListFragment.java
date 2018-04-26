package com.example.wanhao.schoolservice.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.adapter.MessageItemAdapter;
import com.example.wanhao.schoolservice.base.IBaseView;
import com.example.wanhao.schoolservice.base.LazyLoadFragment;
import com.example.wanhao.schoolservice.bean.Message;
import com.example.wanhao.schoolservice.presenter.ListFragmentPresenter;
import com.yalantis.phoenix.PullToRefreshView;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by wanhao on 2018/2/6.
 */

public class ListFragment extends LazyLoadFragment implements IBaseView<List<Message>>{

    private RecyclerView recyclerView;
    private PullToRefreshView refreshView;
    private MessageItemAdapter adapter;
    private StaggeredGridLayoutManager mLayoutManager;
    private List<Message> messageList;

    private ListFragmentPresenter presenter;

    @Override
    protected int setContentView() {
        return R.layout.fragment_list;
    }

    @Override
    protected void lazyLoad() {
        initView();
        initEvent();
        presenter.getListByInternet();
    }


    private void initView(){
        recyclerView = findViewById(R.id.fg_message_recycler);
        refreshView = findViewById(R.id.fg_message_refresh);
        mLayoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
        refreshView.setNestedScrollingEnabled(false);

        messageList = new ArrayList<>();
        adapter = new MessageItemAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        presenter = new ListFragmentPresenter(this,getActivity());
    }

    private void initEvent(){
        adapter.setOnItemClickListener(new MessageItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(),""+position, Toast.LENGTH_SHORT).show();
            }
        });

        refreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        presenter.getListByInternet();
                    }
                }, 2000);
            }
        });

        adapter.setOnItemClickListener(new MessageItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(),messageList.get(position).getContantUrl(),Toast.LENGTH_SHORT).show();
            }
        });

        adapter.setOnLongItemClickListener(new MessageItemAdapter.OnLongItemClickListener() {
            @Override
            public void onLongItemClick(View view, int position) {
                Toast.makeText(getActivity(),messageList.get(position).getTime(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void setData(List<Message> data){
        messageList =data;
        adapter.setData(messageList);
    }


    @Override
    public void showProgress() {
        Log.i(TAG, "showProgress: ");
        refreshView.setRefreshing(true);
    }

    @Override
    public void disimissProgress() {
        Log.i(TAG, "disimissProgress: ");
        refreshView.setRefreshing(false);
    }

    @Override
    public void loadDataSuccess(List<Message> tData) {
        Log.i(TAG, "loadDataSuccess: ");
        messageList = tData;
        adapter.setData(messageList);
    }


    @Override
    public void loadDataError(String throwable) {
        Toast.makeText(getActivity(),throwable,Toast.LENGTH_SHORT).show();
        disimissProgress();
    }
}
