package com.qffweather.android.goodslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

public class MainActivity extends AppCompatActivity {

    private StickyListHeadersListView sh1;
    private MyGroupAdapter groupAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sh1 = (StickyListHeadersListView) findViewById(R.id.sh1);
        testData();
        groupAdapter = new MyGroupAdapter(this, datas,headDatas);
        sh1.setAdapter(groupAdapter);
    }

    /**
     * 普通条目
     */
    class Data {
        String info;
        int headId;
        int headIndex;//当前条目对于的头数据所在集合的下标
    }

    /**
     * 头条目
     */
    class Head {
        String info;
    }

    private ArrayList<Data> datas = new ArrayList<>();
    private ArrayList<Head> headDatas = new ArrayList<>();

    private void testData() {
        //分组:0-9位一个组
        for (int i = 0; i < 9; i++) {
            Head head = new Head();
            head.info="头："+i;
            headDatas.add(head);
        }
//        //普通条目
//        for (int i = 0; i < 100; i++) {
//            Data data = new Data();
//            data.info = "info" + i;
//            datas.add(data);
//        }
        for (int i = 0; i < headDatas.size(); i++) { //根据嵌套循环，建立两种数据间的联系
            //普通条目
        for (int j = 0; j < 10; j++) {
            Data data = new Data();
            data.headId = i;
            data.info = "普通条目：第"+i+"组,条目数"+j ;
            data.headIndex = i;
            datas.add(data);
        }
        }
    }
}
