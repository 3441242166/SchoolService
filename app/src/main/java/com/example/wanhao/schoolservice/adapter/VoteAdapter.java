package com.example.wanhao.schoolservice.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.bean.Vote;

import java.util.List;

/**
 * Created by wanhao on 2018/3/20.
 */

public class VoteAdapter extends RecyclerView.Adapter<VoteAdapter.Holder> implements View.OnClickListener{

    private List<Vote> courseList;

    private OnItemClickListener onItemClickListener;

    private View view;
    private Context context;

    public VoteAdapter(Context context){
        this.context = context;
    }

    public void setData(List<Vote> courseList){
        this.courseList = courseList;
        notifyDataSetChanged();
    }

    @Override
    public VoteAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vote, parent, false);
        Holder vh = new Holder(view);
        view.setOnClickListener(this);
        return vh;
    }

    @Override
    public void onBindViewHolder(VoteAdapter.Holder holder, int position) {
        Vote course = courseList.get(position);

        holder.name.setText(course.getTitle());
        holder.lBt.setText(course.getBlue()+"%");
        holder.ltx.setText(course.getBlueString());
        holder.rBt.setText(course.getRed()+"%");
        holder.rtx.setText(course.getRedString());
        holder.people.setText("有 "+course.getParticipant()+"人参与投票");

        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return courseList==null ? 0:courseList.size();
    }

    @Override
    public void onClick(View view) {
        if(onItemClickListener!=null){
            onItemClickListener.onItemClick(view,(int)view.getTag());
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public static class Holder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView ltx;
        public TextView rtx;
        public TextView people;
        public Button lBt;
        public Button rBt;

        public Holder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.it_vote_title);
            ltx = (TextView)view.findViewById(R.id.it_vote_ltx);
            rtx = (TextView)view.findViewById(R.id.it_vote_rtx);
            people = (TextView)view.findViewById(R.id.it_vote_totle);
            lBt = (Button) view.findViewById(R.id.it_vote_lbt);
            rBt = (Button) view.findViewById(R.id.it_vote_rbt);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}