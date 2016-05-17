package com.example.buster.mycrews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.buster.mycrews.BE.Crew;

import java.util.ArrayList;

/**
 * Created by Buster on 10-05-2016.
 */
public class FindCrewListViewAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Crew> crews;
    private static LayoutInflater inflater = null;


    public FindCrewListViewAdapter(Context context, ArrayList<Crew> data)
    {
        mContext = context;
        crews = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return crews.size();
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

        TextView crewName = (TextView) view.findViewById(R.id.crewName);
        TextView crewLeader = (TextView) view.findViewById(R.id.leaderName);

        Crew c = crews.get(position);

        crewName.setText(c.getCrewName());

        crewLeader.setText(c.getCrewLeader().getUserName());


        return view;
    }
}