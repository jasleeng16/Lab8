package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * this gets size of the list
     * @return
     */
    public int getCount(){
        return cities.size();
    }

    /**
     * this adds a city object to the list
     *the second phase, you can add the
     city * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * When given a city, this returns whether or not it belongs in the list * @param city
     *  This is a city that either belongs in the list or doesn't * @return
     *  Return true or false
     */
    public boolean hasCity(City city){
        return cities.contains(city);
    }

    /**
     * This checks if a city is present in the list.
     * If it is, then it is deleted. * @param city
     *  This is a city to delete.
     */
    public void deleteCity(City city){
            cities.remove(city);

    }

    /**
     * This returns how many cities are in the list. * @return
     *  Return the size of the list/number of cities in it.
     */
    public int countCities(){
        return(cities.size());
    }

}
