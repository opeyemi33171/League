package com.example.opeyemi.league;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by opeyemi on 26/05/2016.
 */
public class Adapter extends ArrayAdapter<Champion> {

    public Adapter(Context context, ArrayList<Champion>champions){
        super(context, 0, champions);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Champion champ = getItem(position);

        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.champion, parent, false);
        }

        return convertView;
    }
}
