package com.gaoyang.codebase.materialdesign.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gaoyang.codebase.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gaoyang on 16/12/21.
 */

public class MDToolbarAdapter extends RecyclerView.Adapter<MDToolbarAdapter.ViewHolder> {

    private List<String> mList;
    private Context mContext;
    public MDToolbarAdapter(List list, Context context) {
        mList = list;
        mContext = context;
    }

    @Override
    public MDToolbarAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.md_item, parent, false);
        return new MDToolbarAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MDToolbarAdapter.ViewHolder holder, int position) {
        String str = String.valueOf(mList.get(position));
        holder.setData(str);
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textview)
        TextView textview;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        void setData(String str) {
            textview.setText(""+str);
        }
    }
}