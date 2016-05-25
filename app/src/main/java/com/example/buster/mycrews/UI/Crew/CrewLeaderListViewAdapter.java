package com.example.buster.mycrews.UI.Crew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.buster.mycrews.BE.Crew;
import com.example.buster.mycrews.BE.User;
import com.example.buster.mycrews.R;

import java.util.ArrayList;

/**
 * Created by Kennie on 24-05-2016.
 */
public class CrewLeaderListViewAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<User> users;
    private static LayoutInflater inflater = null;


    public CrewLeaderListViewAdapter(Context context, ArrayList<User> data)
    {
        mContext = context;
        users = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if(convertView==null){
            view = inflater.inflate(R.layout.list_row, null);
        }

        TextView userName = (TextView) view.findViewById(R.id.userName);

        User c = users.get(position);

        userName.setText(c.getUserName());


        return view;
    }
}