package com.example.workit2;

import com.jjoe64.graphview.series.DataPoint;

import java.util.ArrayList;

/**
 * Created by panda_000 on 5/4/2017.
 */

public class ActivityItem {
    private String name;
    private int difficulty;
    private ArrayList<DataPoint> series;
    private boolean favorite;

    public ActivityItem(String n, int d){
        name = n;
        difficulty = d;
        series = new ArrayList<>();
        favorite = false;
    }

    public void addPoint(long datetime){
        DataPoint point = new DataPoint(getSize(),1);
        series.add(point);
    }

    public void toggleFavorite(){
        favorite=!favorite;
    }

    public String getName(){
        return name;
    }
    public int getDiff(){
        return difficulty;
    }
    public int getSize(){
        return series.size();
    }
    public boolean isFavorite(){
        return favorite;
    }
    public String toString(){
        return "["+name+" "+difficulty+" "+series.size()+"]";
    }
}
