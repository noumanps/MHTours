package com.example.nouman.mhtours.fragments;


import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nouman.mhtours.ModelAdapter;
import com.example.nouman.mhtours.ModelClass;
import com.example.nouman.mhtours.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BeachFragment extends Fragment {


    public BeachFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        final ArrayList<ModelClass> sites = new ArrayList<>();
        Resources res = getResources();
        String[] beachName = res.getStringArray(R.array.beach_names);
        TypedArray beachImage = res.obtainTypedArray(R.array.beach_images);
        String[] beachUrls = res.getStringArray(R.array.beach_urls);

        for (int i = 0; i < beachName.length; i++){
            sites.add(new ModelClass(beachName[i], beachImage.getResourceId(i, -1), beachUrls[i]));
        }

        ModelAdapter adapter = new ModelAdapter(getActivity(), sites, R.color.textContainerColor);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Uri uri = Uri.parse(sites.get(position).getmSiteInfoUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                view.getContext().startActivity(intent);
            }
        });

        return rootView;
    }
}