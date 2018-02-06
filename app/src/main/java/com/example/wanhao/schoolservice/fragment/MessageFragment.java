package com.example.wanhao.schoolservice.fragment;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.adapter.MessageItemAdapter;
import com.example.wanhao.schoolservice.base.LazyLoadFragment;
import com.example.wanhao.schoolservice.bean.MessageImage;
import com.example.wanhao.schoolservice.bean.MessageNormal;
import com.example.wanhao.schoolservice.bean.RecycleViewItemData;
import com.example.wanhao.schoolservice.bean.UserMessage;
import com.example.wanhao.schoolservice.view.IMainMessageView;
import com.yalantis.phoenix.PullToRefreshView;

import java.util.ArrayList;
import java.util.List;

import static com.example.wanhao.schoolservice.config.Constant.AD_MESSAGE;
import static com.example.wanhao.schoolservice.config.Constant.AD_MESSAGE_IMAGE;

/**
 * Created by wanhao on 2017/11/18.
 */

public class MessageFragment extends LazyLoadFragment implements IMainMessageView{

    private TextView txNext;
    private RecyclerView recyclerView;
    private PullToRefreshView refreshView;

    private MessageItemAdapter adapter;
    private StaggeredGridLayoutManager mLayoutManager;
    private List<RecycleViewItemData> messageList;

    @Override
    protected int setContentView() {
        return R.layout.fragment_message;
    }

    @Override
    protected void lazyLoad() {
        initView();
        initData();
        initEvent();
    }


    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.fg_message_recycler);
        refreshView = (PullToRefreshView) findViewById(R.id.fg_message_refresh);


        mLayoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
        //refreshView.setNestedScrollingEnabled(false);
    }

    private void initData() {
        messageList = new ArrayList<>();
        RecycleViewItemData data;

        for(int x=0;x<5;x++) {
            if(x%2==0){
                MessageNormal message = new MessageNormal();
                UserMessage userMessage = new UserMessage();
                userMessage.setName("冰与火之歌");
                userMessage.setHead(getActivity().getDrawable(R.drawable.ceshi_head));
                message.setContant("ACM程序设计大赛是大学级别最高的脑力竞赛，素来被冠以\"程序设计的奥林匹克\"的尊称。大赛至今已有近40年的历史，是世界范围内历史最悠久、规模最大的程序设计竞赛。比赛形式是：从各大洲区域预赛出线的参赛队伍，于指定的时间、地点参加世界级的决赛，由1个教练、3个成员组成的小组应用一台计算机解决7到13个生活中的实际问题。");
                message.setTitle("西科大程序设计大赛开始啦，快来报名！！！");
                message.setSendUser(userMessage);
                data = new RecycleViewItemData(message,AD_MESSAGE);
            }else{
                MessageImage message = new MessageImage();
                UserMessage userMessage = new UserMessage();
                userMessage.setName("冰与火之歌");
                userMessage.setHead(getActivity().getDrawable(R.drawable.ceshi_head));
                message.setContant("ACM程序设计大赛是大学级别最高的脑力竞赛，素来被冠以\"程序设计的奥林匹克\"的尊称。大赛至今已有近40年的历史，是世界范围内历史最悠久、规模最大的程序设计竞赛。比赛形式是：从各大洲区域预赛出线的参赛队伍，于指定的时间、地点参加世界级的决赛，由1个教练、3个成员组成的小组应用一台计算机解决7到13个生活中的实际问题。");
                message.setTitle("西科大程序设计大赛开始啦，快来报名！！！");
                message.setSendUser(userMessage);
                message.setImage(ContextCompat.getDrawable(getActivity(),R.drawable.ceshi_head));
                data = new RecycleViewItemData(message,AD_MESSAGE_IMAGE);
            }

            messageList.add(data);
        }

        adapter = new MessageItemAdapter(messageList);

        recyclerView.setAdapter(adapter);
    }

    private void initEvent() {
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
                        refreshView.setRefreshing(false);
                    }
                }, 2000);
            }
        });

    }

    @Override
    public void showData(List<RecycleViewItemData> list) {
        messageList = list;
        adapter = new MessageItemAdapter(messageList);

        recyclerView.setAdapter(adapter);
    }
}
