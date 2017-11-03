package com.example.android_razrab.realmdemka;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by android_razrab on 03/11/2017.
 */

public class Street extends RealmObject {

    private String name;

    private RealmList<Inhabitant>inhabitantRealmList;

    public RealmList<Inhabitant> getInhabitantRealmList() {
        return inhabitantRealmList;
    }

    public void setInhabitantRealmList(RealmList<Inhabitant> inhabitantRealmList) {
        this.inhabitantRealmList = inhabitantRealmList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
