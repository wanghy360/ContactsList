package com.jadyn.contactslist.contact;

import com.jadyn.contactslist.R;

/**
 * Created by Administrator on 2016/1/8.
 */
public class User extends PinyinIndexBean{
    private String name;

    private int icon = R.mipmap.ic_launcher;

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
