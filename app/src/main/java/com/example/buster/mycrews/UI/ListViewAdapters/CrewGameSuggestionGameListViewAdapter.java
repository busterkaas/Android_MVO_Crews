package com.example.buster.mycrews.UI.ListViewAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.buster.mycrews.BE.CrewGameSuggestion;
import com.example.buster.mycrews.R;

import java.util.ArrayList;

/**
 * Created by RlxCw on 24-05-2016.
 */
public class CrewGameSuggestionGameListViewAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<CrewGameSuggestion> gameSuggestions;
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

        TextView gameTitle = (TextView) view.findViewById(R.id.gameTitle);

        CrewGameSuggestion cgs = gameSuggestions.get(position);

        gameTitle.setText(cgs.getGame().getTitle());

        return view;
    }
}
