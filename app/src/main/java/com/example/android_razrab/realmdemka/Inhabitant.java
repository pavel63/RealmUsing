package com.example.android_razrab.realmdemka;

import io.realm.RealmObject;

/**
 * Created by android_razrab on 03/11/2017.
 */

public class Inhabitant extends RealmObject {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
