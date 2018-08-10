package com.example.nouman.mhtours;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ModelAdapter extends ArrayAdapter<ModelClass> {

    private int mColorResourceId;

    public ModelAdapter(Context context, ArrayList<ModelClass> ModelClass, int colorResourceId) {
        super(context, 0, ModelClass);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        ModelClass currentItem = getItem(position);

        ImageView image = listItemView.findViewById(R.id.image);
        image.setImageResource(currentItem.getmSiteImage());

        TextView nameTextView = listItemView.findViewById(R.id.name_text_view);
        nameTextView.setText(currentItem.getmSiteName());

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}