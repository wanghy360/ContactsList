package com.jadyn.contactslist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.github.promeg.pinyinhelper.Pinyin;
import com.jadyn.contactslist.contact.CompareSort;
import com.jadyn.contactslist.contact.SideBarView;
import com.jadyn.contactslist.contact.User;
import com.jadyn.contactslist.contact.UserAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity implements SideBarView.LetterSelectListener {
    RecyclerView recyclerView;
    UserAdapter mAdapter;
    TextView mTip;
    private LinearLayoutManager linearLayoutManager;
    private Map<String, Integer> letterPositionMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        recyclerView = findViewById(R.id.listview);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        SideBarView sideBarView = findViewById(R.id.sidebarview);
        String[] contactsArray = getResources().getStringArray(R.array.data);
        mTip = findViewById(R.id.tip);

        //模拟添加数据到Arraylist
        List<User> users = new ArrayList<>();
        for (String content : contactsArray) {
            User user = new User();
            user.setName(content);
            String pinyin = Pinyin.toPinyin(content, "").toUpperCase();
            user.setPinyin(pinyin);
            String substring = pinyin.substring(0, 1);
            if (substring.matches("[A-Z]")) {
                user.setLetter(substring);
            } else {
                user.setLetter("#");
            }
            users.add(user);
        }

        //排序
        Collections.sort(users, new CompareSort());
        String firstLetter = null;
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (!user.getLetter().equals(firstLetter)) {
                user.setFirstPosition(true);
                firstLetter = user.getLetter();
                letterPositionMap.put(user.getLetter(), i);
            }
        }

        //设置数据
        mAdapter = new UserAdapter();
        mAdapter.setData(users);
        recyclerView.setAdapter(mAdapter);

        //设置回调
        sideBarView.setOnLetterSelectListen(this);

    }


    @Override
    public void onLetterSelected(String letter) {
        setListviewPosition(letter);
        mTip.setText(letter);
        mTip.setVisibility(View.VISIBLE);
    }

    @Override
    public void onLetterChanged(String letter) {
        setListviewPosition(letter);
        mTip.setText(letter);
    }

    @Override
    public void onLetterReleased(String letter) {
        mTip.setVisibility(View.GONE);
    }

    private void setListviewPosition(String letter) {
        Integer position = letterPositionMap.get(letter);
        if (position != null) {
            linearLayoutManager.scrollToPositionWithOffset(position,0);
        }
    }
}
