package com.jadyn.contactslist.contact;

import java.util.Comparator;

/**
 * 排序类
 * #代表除了A-Z以外的其他标签
 * Created by tian on 16-1-9.
 */
public class CompareSort implements Comparator<PinyinIndexBean> {
    @Override
    public int compare(PinyinIndexBean user1, PinyinIndexBean user2) {
        if (user1.getLetter().equals("#")){
            if (user2.getLetter().equals("#")){
                return user1.getPinyin().compareTo(user2.getPinyin());
            }else {
                return 1;
            }
        }else {
            if (user2.getLetter().equals("#")){
                return -1;
            }else {
                return user1.getPinyin().compareTo(user2.getPinyin());
            }
        }
    }
}
