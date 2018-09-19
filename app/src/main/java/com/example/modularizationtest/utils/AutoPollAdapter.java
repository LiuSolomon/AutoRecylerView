package com.example.modularizationtest.utils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.modularizationtest.R;

import java.util.List;

/**
 * Author：白树 on 2018/9/18 16:57
 * <p>
 * Email:  gusumobai@163.com
 */
public class AutoPollAdapter  extends RecyclerView.Adapter<AutoPollAdapter.BaseViewHolder> {
    private final List<String> mData;

    public AutoPollAdapter(List<String> list) {
        this.mData = list;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.winuser_item, parent, false);
        BaseViewHolder holder = new BaseViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        String data = mData.get(position % mData.size());
        holder.tv.setText(data);
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    class BaseViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        public BaseViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_content);
        }
    }

}
