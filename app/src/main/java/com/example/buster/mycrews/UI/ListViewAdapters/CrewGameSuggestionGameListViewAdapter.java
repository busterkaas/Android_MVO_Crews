package com.example.buster.mycrews.UI.ListViewAdapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.buster.mycrews.BE.Crew;
import com.example.buster.mycrews.BE.CrewGameSuggestion;
import com.example.buster.mycrews.BE.User;
import com.example.buster.mycrews.BLL.Manager.GenerelLogic.CrewLogic;
import com.example.buster.mycrews.BLL.Manager.ImageDownloader;
import com.example.buster.mycrews.Controller.UserController;
import com.example.buster.mycrews.R;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by RlxCw on 24-05-2016.
 */
public class CrewGameSuggestionGameListViewAdapter extends BaseAdapter {


    private Context mContext;
    private ArrayList<CrewGameSuggestion> gameSuggestions;
    CrewLogic cl;
    private static LayoutInflater inflater = null;

    public CrewGameSuggestionGameListViewAdapter(Context context, ArrayList<CrewGameSuggestion> data){
        mContext = context;
        gameSuggestions = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return gameSuggestions.size();
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
            view = inflater.inflate(R.layout.list_row_gamesug, null);
        }

        ImageView gameImage = (ImageView) view.findViewById(R.id.list_gameImg);
        TextView gameTitle = (TextView) view.findViewById(R.id.gameTitle);
        TextView gameGenre = (TextView) view.findViewById(R.id.gamePlatform);
        TextView gameExpire = (TextView) view.findViewById(R.id.gameExpireDate);
        Button btnJoin = (Button) view.findViewById(R.id.btnJoin);

        CrewGameSuggestion cgs = gameSuggestions.get(position);

        downloadImage(gameImage, cgs.getGame().getCoverUrl());
        gameTitle.setText(cgs.getGame().getTitle());
        gameGenre.setText(cgs.getPlatform().getName());
        gameExpire.setText(cgs.getExpDateString());

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Toast.makeText(mContext, "You have joined the game", Toast.LENGTH_SHORT).show();
            }
        });
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
}
