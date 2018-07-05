package com.jadyn.contactslist.contact;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jadyn.contactslist.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jadyn on 2016/1/8.
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private ArrayList<User> users;

    public UserAdapter() {
        users = new ArrayList<>();
    }

    public void setData(List<User> data) {
        this.users.clear();
        this.users.addAll(data);
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.bindView(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvTitle;
        LinearLayout tvItem;
        private User user;

        public UserViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.title);
            tvName = itemView.findViewById(R.id.name);
            tvItem = itemView.findViewById(R.id.item);
            tvItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), user.getName(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void bindView(User user) {
            this.user = user;
            tvName.setText(user.getName());

            //当前的item的title与上一个item的title不同的时候回显示title(A,B,C......)
            if (user.isFirstPosition()) {
                tvTitle.setVisibility(View.VISIBLE);
                tvTitle.setText(user.getLetter());
            } else {
                tvTitle.setVisibility(View.GONE);
            }
        }
    }
}