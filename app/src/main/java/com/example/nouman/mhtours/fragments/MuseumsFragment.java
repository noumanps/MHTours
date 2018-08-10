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
public class MuseumsFragment extends Fragment {


    public MuseumsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        final ArrayList<ModelClass> sites = new ArrayList<>();
        Resources res = getResources();
        String[] museumName = res.getStringArray(R.array.museum_names);
        TypedArray museumImage = res.obtainTypedArray(R.array.museum_images);
        String[] museumUrls = res.getStringArray(R.array.museum_urls);

        for (int i = 0; i < museumName.length; i++){
            sites.add(new ModelClass(museumName[i], museumImage.getResourceId(i, -1), museumUrls[i]));
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