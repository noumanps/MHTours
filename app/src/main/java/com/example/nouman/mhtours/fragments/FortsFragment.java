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
public class FortsFragment extends Fragment {


    public FortsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        final ArrayList<ModelClass> sites = new ArrayList<>();
        Resources res = getResources();
        String[] fortName = res.getStringArray(R.array.fort_names);
        TypedArray fortImage = res.obtainTypedArray(R.array.fort_images);
        String[] fortUrls = res.getStringArray(R.array.fort_urls);

        for (int i = 0; i < fortName.length; i++){
            sites.add(new ModelClass(fortName[i], fortImage.getResourceId(i, -1), fortUrls[i]));
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