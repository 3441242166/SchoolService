package com.example.wanhao.schoolservice.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wanhao.schoolservice.R;
import com.example.wanhao.schoolservice.bean.MessageImage;
import com.example.wanhao.schoolservice.bean.MessageNormal;
import com.example.wanhao.schoolservice.bean.RecycleViewItemData;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.wanhao.schoolservice.config.Constant.AD_MESSAGE;
import static com.example.wanhao.schoolservice.config.Constant.AD_MESSAGE_IMAGE;

/**
 * Created by wanhao on 2017/11/26.
 */

public class MessageItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private static final String TAG = "MessageItemAdapter";

    private List<RecycleViewItemData> list;
    private OnItemClickListener mOnItemClickListener = null;
    View view;

    public MessageItemAdapter(List<RecycleViewItemData> list) {
        this.list = list;
    }

    public void setData(List<RecycleViewItemData> list) {
        this.list = list;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        if(viewType==AD_MESSAGE){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_news, viewGroup, false);
            HolderNormal vh = new HolderNormal(view);
            view.setOnClickListener(this);
            return vh;
        }
        if(viewType==AD_MESSAGE_IMAGE){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_news_image, viewGroup, false);
            HolderImage vh = new HolderImage(view);
            view.setOnClickListener(this);
            return vh;
        }
        return null;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HolderNormal) {
            MessageNormal message =(MessageNormal) list.get(position).getT();

            ((HolderNormal) holder).head.setImageDrawable(message.getSendUser().getHead());
            ((HolderNormal) holder).name.setText(message.getSendUser().getName());
            ((HolderNormal) holder).messageTitle.setText(message.getTitle());
            ((HolderNormal) holder).messageContant.setText(message.getContant().get(0));
        }
        if (holder instanceof HolderImage) {
            MessageImage message =(MessageImage) list.get(position).getT();

            ((HolderImage) holder).head.setImageDrawable(message.getSendUser().getHead());
            ((HolderImage) holder).name.setText(message.getSendUser().getName());
            ((HolderImage) holder).messageTitle.setText(message.getTitle());
            ((HolderImage) holder).messageContant.setText(message.getContant().get(0));
            ((HolderImage) holder).image.setImageDrawable(message.getImage());
        }
        holder.itemView.setTag(position);
    }
    @Override
    public int getItemViewType (int position) {
        return list.get(position).getDataType();
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
        public TextView name;
        public TextView messageTitle;
        public TextView messageContant;

        public HolderNormal(View view) {
            super(view);
            head = (CircleImageView) view.findViewById(R.id.ad_message_head);
            name = (TextView) view.findViewById(R.id.ad_message_name);
            messageTitle = (TextView) view.findViewById(R.id.ad_message_title);
            messageContant = (TextView) view.findViewById(R.id.ad_message_contant);

        }
    }

    public static class HolderImage extends RecyclerView.ViewHolder {
        public CircleImageView head;
        public TextView name;
        public TextView messageTitle;
        public TextView messageContant;
        public ImageView image;

        public HolderImage(View view) {
            super(view);
            head = (CircleImageView) view.findViewById(R.id.ad_message_image_head);
            name = (TextView) view.findViewById(R.id.ad_message_image_name);
            messageTitle = (TextView) view.findViewById(R.id.ad_message_image_title);
            messageContant = (TextView) view.findViewById(R.id.ad_message_image_contant);
            image = (ImageView) view.findViewById(R.id.ad_message_image_image);
        }
    }
}