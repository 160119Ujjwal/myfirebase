package com.example.myfirebase.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myfirebase.Post.Post;
import com.example.myfirebase.R;

import java.util.List;

public class Noticelist extends ArrayAdapter<Post> {

    private Activity context;
    private List<Post> noticeList;

    public Noticelist(Activity context, List<Post> noticeList){
        super(context, R.layout.list_layout, noticeList);
        this.context=context;
        this.noticeList=noticeList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();

        View listViewItem=inflater.inflate(R.layout.list_layout, null, true);
        TextView textViewNotice=listViewItem.findViewById(R.id.textViewNotice);
        Post notice=noticeList.get(position);
        textViewNotice.setText(notice.getPost());
        return listViewItem;
    }
}
