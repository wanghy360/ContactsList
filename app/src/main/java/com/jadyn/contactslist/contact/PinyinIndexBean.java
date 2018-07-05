package com.jadyn.contactslist.contact;

/**
 * Created by Wanghy360 on 2018/7/5.
 */
public class PinyinIndexBean {
    private String pinyin;//完整拼音
    private boolean firstPosition;//是否是第一项
    private String letter;//第一个字母

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public boolean isFirstPosition() {
        return firstPosition;
    }

    public void setFirstPosition(boolean firstPosition) {
        this.firstPosition = firstPosition;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

}
