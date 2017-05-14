package com.qffweather.android.goodslist;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * StickyListHeadersAdapter:分组头信息
 * Created by qff on 2017/5/5.
 */
public class MyGroupAdapter extends BaseAdapter implements StickyListHeadersAdapter {

    private final ArrayList<MainActivity.Data> datas;
    private final MainActivity mainActivity;
    private final ArrayList<MainActivity.Head> headDatas;

    public MyGroupAdapter(MainActivity mainActivity, ArrayList<MainActivity.Data> datas, ArrayList<MainActivity.Head> headDatas) {
        this.mainActivity = mainActivity;
        this.datas = datas;
        this.headDatas = headDatas;
    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        MainActivity.Data data = datas.get(position);
        //头所在集合的下标
        MainActivity.Head head = headDatas.get(data.headIndex);
        TextView tv = new TextView(mainActivity);
        tv.setText( head.info);
        tv.setBackgroundColor(Color.GRAY);
        return tv;
    }

    @Override
    public long getHeaderId(int position) {
        //根据position获取普通条目，普通条目中存放了headId，是一组的headId就是一样的
        int headId = datas.get(position).headId;
        return headId;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv = new TextView(mainActivity);
        tv.setText( datas.get(position).info);
        return tv;
    }
}
