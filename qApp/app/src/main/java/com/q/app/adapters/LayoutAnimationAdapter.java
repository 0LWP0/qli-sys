package com.q.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.q.app.R;

import java.util.ArrayList;

/**
 * Created by qli on 16/7/10.
 */
public class LayoutAnimationAdapter extends BaseAdapter {


    private Context mContext;
    private ArrayList<String> mList;


    public LayoutAnimationAdapter(Context context, ArrayList<String> list) {

        this.mContext = context;
        this.mList = list;
    }

    @Override
    public int getCount() {
        if (mList.isEmpty()) {
            return 0;
        }
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutAnimationViewholder layoutAnimationViewholder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_layout_animation, parent, false);
            layoutAnimationViewholder = new LayoutAnimationViewholder();
            layoutAnimationViewholder.mTextView = (TextView) convertView.findViewById(R.id.text_item_animation);
            convertView.setTag(layoutAnimationViewholder);
        } else {
            layoutAnimationViewholder = (LayoutAnimationViewholder) convertView.getTag();
        }
        layoutAnimationViewholder.mTextView.setText(mList.get(position));
        return convertView;
    }

    class LayoutAnimationViewholder {
        TextView mTextView;
    }
}
