package com.example.lguti.flickster.adapters;

import android.app.VoiceInteractor;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lguti.flickster.R;
import com.example.lguti.flickster.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by lguti on 6/15/16.
 */
public class MovieArrayAdapter extends ArrayAdapter<Movie> {



    private static class ViewHolder{
        ImageView ivImage;
        TextView tvTitle;
        TextView tvOverview;
        TextView tvPopularity;

    }

    public MovieArrayAdapter (Context context, List<Movie> movies){
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the data item for position
        Movie movie = getItem(position);
        //check the existing view being reused


        ViewHolder viewHolder;


        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
            viewHolder.ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);
            //viewHolder.tvPopularity = (TextView) convertView.findViewById(R.id.tvPopularity);
            Typeface font1 = Typeface.createFromAsset(getContext().getAssets(), "PortLligatSans-Regular.ttf");
            //Typeface font2 = Typeface.createFromAsset(getContext().getAssets(), "true-crimes.tff");



            viewHolder.tvOverview.setTypeface(font1);
           // viewHolder.tvTitle.setTypeface(font1);

            convertView.setTag(viewHolder);

        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //Find the imageView

        //clear our image from convertView
        viewHolder.ivImage.setImageResource(0);




        //populate data
        viewHolder.tvTitle.setText(movie.getOriginalTitle());
        viewHolder.tvOverview.setText(movie.getOverview());
        //viewHolder.tvPopularity.setText(movie.getPopularity());

        int orientation = getContext().getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            Picasso.with(getContext()).load(movie.getPosterpath()).placeholder(R.drawable.loading).error(R.drawable.loading).into(viewHolder.ivImage);

        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE){
            Picasso.with(getContext()).load(movie.getBackdroppath()).placeholder(R.drawable.loading).error(R.drawable.loading).into(viewHolder.ivImage);
        }


        return convertView;
    }
}

