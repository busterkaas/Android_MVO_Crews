package com.example.buster.mycrews.UI.ListViewAdapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.buster.mycrews.BE.Crew;
import com.example.buster.mycrews.BLL.Manager.ImageDownloader;
import com.example.buster.mycrews.MenuActivity;
import com.example.buster.mycrews.R;

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
        ImageView crewImage = (ImageView) view.findViewById(R.id.crew_list_image);


        Crew c = crews.get(position);

        crewName.setText(c.getCrewName());

        crewLeader.setText(c.getCrewLeader().getUserName());

        downloadImage(crewImage, c.getCrewImgUrl());


        return view;
    }

        private void downloadImage(ImageView imgView, String url) {

        ImageDownloader task = new ImageDownloader();
        Bitmap myImage;
        try {
            myImage = task.execute(url).get();
            imgView.setImageBitmap(myImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchCrewList(ArrayList<Crew> crews){
        this.crews = crews;
    }
}