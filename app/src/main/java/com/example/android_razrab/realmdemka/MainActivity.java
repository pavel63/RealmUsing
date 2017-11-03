package com.example.android_razrab.realmdemka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmAsyncTask;

public class MainActivity extends AppCompatActivity {


    RealmAsyncTask transaction;


    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm =Realm.getInstance(this);


        inhabitants();

       // executeTransaction();

       // relations();

       // createObject2();

        //List <Street> streetList = city.getStreetRealmList();

        // список жителей на этой улице в этом городе
      // List <Inhabitant> sjitel =streetList.get(0).getInhabitantRealmList();


    }

    // работает!
    void createObject1 (){

        realm .beginTransaction();

        City city = realm.createObject( City.class );
        city.setName( "Moscow" );
        city .setPopulation(12_000_000);

        realm.commitTransaction();

    }






    void createObject2 () {

        City city2 = new City( "Moscow2" );

        city2.setPopulation(13_000_000);

        realm .beginTransaction();

        // вставляет если не существует еще
         realm.copyToRealm(city2);

        // и апдейт если существует
       // realm.copyToRealmOrUpdate(city2);

        realm .commitTransaction();
    }



   void executeTransaction (){

    realm .executeTransaction( new Realm.Transaction(){
        @Override
        public void execute(Realm realm) {

            City city =realm .createObject( City.class );
            city .setName( "Mosc" );
            city .setPopulation( 15_000_000 );

        }
    } , new Realm.Transaction.Callback() {
                                   @Override
                                   public void onSuccess() {
                                       super.onSuccess();
                                   }

                                   @Override
                                   public void onError(Exception e) {
                                       super.onError(e);
                                   }
                               }

    );

   }



   void cancelTransaction(){

       transaction =realm .executeTransaction(new Realm.Transaction(){

           @Override
           public void execute(Realm realm) {

               City city =realm .createObject( City.class );
               city .setName( "Mosc" );
               city .setPopulation( 15_000_000 );
           }
       } ,null);

   }


    @Override
    protected void onStop() {
        super.onStop();

        if ( transaction !=null && !transaction .isCancelled() ) {

            transaction .cancel();

        }
    }



    void relations (){

        realm .beginTransaction();
        City city =realm.createObject(City.class);
       // city .setName( "Moscow" );

      //  Street street =realm .createObject( Street.class );
      //  street .setName( "Ordynka" );
        // вот так ставим улицу к горооду one-to-many
      //  city.getStreetRealmList().add(street);

        Street street2 =realm .createObject( Street.class );
        street2 .setName( "Arbat" );


        // вторую улицу
        city .getStreetRealmList().add(street2);

        realm.commitTransaction();
    }


    void inhabitants(){

        realm .executeTransaction( new Realm.Transaction(){
                                       @Override
                                       public void execute(Realm realm) {

                                           // создаем город
                                           City city =realm.createObject(City.class);
                                           city .setName( "London" );

                                           // улицу
                                           Street street2 =realm .createObject( Street.class );
                                           street2 .setName( "Baker" );

                                           // жителя
                                           Inhabitant inhabitant1 = realm.createObject(Inhabitant.class);
                                           inhabitant1.setName("Holmes");

                                           // прибавляем улицу к городу
                                           city.getStreetRealmList().add(street2);
                                           // жителя к улице
                                           street2.getInhabitantRealmList().add(inhabitant1);

                                       }

                                       // в базе есть ,но коллбеки не отработали почему -то пока
                                   } , new Realm.Transaction.Callback() {
                                       @Override
                                       public void onSuccess() {
                                           super.onSuccess();

                                           Log .d("SUCESS","");

                                       }

                                       @Override
                                       public void onError(Exception e) {
                                           super.onError(e);

                                           Log.d("FAILURE","");
                                       }
                                   }

        );



    }



}
