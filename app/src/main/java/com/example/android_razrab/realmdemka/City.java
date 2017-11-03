package com.example.android_razrab.realmdemka;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by android_razrab on 03/11/2017.
 */

public class City extends RealmObject {

    private String name;
    private int population;

    private RealmList<Street>streetRealmList;

    public City(String name) {
        this.name = name;
    }

    public City(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public RealmList<Street> getStreetRealmList() {
        return streetRealmList;
    }

    public void setStreetRealmList(RealmList<Street> streetRealmList) {
        this.streetRealmList = streetRealmList;
    }


}
