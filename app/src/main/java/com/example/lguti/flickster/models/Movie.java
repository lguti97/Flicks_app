package com.example.lguti.flickster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by lguti on 6/15/16.
 */
public class Movie {
    //Now we simply want the poster path, the title, and the overview from the JSON objects
    //So we bascially have to declare everything here
    public String getPosterpath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterpath); //The %s denotes that posterpath should go there
    }
    public String getOriginalTitle() {
        return originalTitle;
    }
    public String getOverview() {
        return overview;
    }
    public String getBackdroppath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdroppath); //The %s denotes that posterpath should go there
    }
    public int getPopularity(){
        return popularity;
    }

    String posterpath;
    String originalTitle;
    String overview;
    String backdroppath;
    int popularity;

    //Now we want a constructor that can take a JSON object so then we can extract the fields we want!
    public Movie (JSONObject jsonObject) throws JSONException{
        this.posterpath = jsonObject.getString("poster_path");
        this.originalTitle = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
        this.backdroppath = jsonObject.getString("backdrop_path");
        this.popularity = jsonObject.getInt("popularity");

    }

    /*
    We want a method that can accept a JSON array and convert each of them into a movie
     */
    public static ArrayList<Movie> fromJSONArray(JSONArray array){
        //So does this another ArrayList with type "Movie"
        ArrayList<Movie> results = new ArrayList<>();
        //We want to iterate through each element in that array
        for (int i = 0; i < array.length(); i++){
            //Now convert everything into a movie
            try {
                results.add(new Movie(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return results;
    }

}
