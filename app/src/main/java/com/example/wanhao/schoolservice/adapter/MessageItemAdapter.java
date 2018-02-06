package com.example.wanhao.schoolservice.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.bean.Message;
import com.example.wanhao.schoolservice.config.Constant;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;



/**
 * Created by wanhao on 2017/11/26.
 */

public class MessageItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private static final String TAG = "MessageItemAdapter";

    private List<Message> list;
    private OnItemClickListener mOnItemClickListener = null;
    View view;
    Context context;

    public MessageItemAdapter(Context context){
        list = new ArrayList<>();
        this.context = context;
    }

    public void setData(List<Message> list) {
        this.list = list;
        this.notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        if(viewType== Constant.AD_MESSAGE_IMAGE){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_news_image, viewGroup, false);
            HolderImage vh = new HolderImage(view);
            view.setOnClickListener(this);
            return vh;
        }
        if(viewType==Constant.AD_MESSAGE){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_news, viewGroup, false);
            HolderNormal vh = new HolderNormal(view);
            view.setOnClickListener(this);
            return vh;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof HolderImage){
            Message message =list.get(position);

            ((HolderImage)holder).name.setText(message.getUser());
            ((HolderImage)holder).time.setText(message.getTime());
            ((HolderImage)holder).title.setText(message.getTitle());
            Glide.with(context).load(message.getImageUrl()).into(((HolderImage)holder).image);
        }
        if(holder instanceof HolderNormal){
            Message message =list.get(position);

            ((HolderNormal)holder).title.setText(message.getTitle());
            ((HolderNormal)holder).name.setText(message.getUser());
            ((HolderNormal)holder).time.setText(message.getTime());
        }
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemViewType (int position) {
        return list.get(position).getType();
    }
    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(v, (int) v.getTag());
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class HolderNormal extends RecyclerView.ViewHolder {
        public CircleImageView head;
        public TextView time;
        public TextView name;
        public TextView title;
        public TextView contant;

        public HolderNormal(View view) {
            super(view);
            time = (TextView) view.findViewById(R.id.ad_message_time);
            head = (CircleImageView) view.findViewById(R.id.ad_message_head);
            name = (TextView) view.findViewById(R.id.ad_message_name);
            title = (TextView) view.findViewById(R.id.ad_message_title);
            contant = (TextView) view.findViewById(R.id.ad_message_contant);

        }
    }

    public static class HolderImage extends RecyclerView.ViewHolder {
        public CircleImageView head;
        public TextView name;
        public TextView time;
        public TextView title;
        public TextView contant;
        public ImageView image;

        public HolderImage(View view) {
            super(view);
            time = (TextView) view.findViewById(R.id.ad_message_image_time);
            head = (CircleImageView) view.findViewById(R.id.ad_message_image_head);
            name = (TextView) view.findViewById(R.id.ad_message_image_name);
            title = (TextView) view.findViewById(R.id.ad_message_image_title);
            contant = (TextView) view.findViewById(R.id.ad_message_image_contant);
            image = (ImageView) view.findViewById(R.id.ad_message_image_image);
        }
    }
}