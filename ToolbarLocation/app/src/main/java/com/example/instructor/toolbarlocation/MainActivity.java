package com.example.instructor.toolbarlocation;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.customToolbar);
        //toolbar.setTitle(null);
        setSupportActionBar(toolbar);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater(); // reads XML
        inflater.inflate(R.menu.menu_main, menu); // to create
        return super.onCreateOptionsMenu(menu); // the menu


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_send) {

            LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);



            try {
                Location loc = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                Toast.makeText(MainActivity.this, loc.toString(), Toast.LENGTH_SHORT).show();

                lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {

                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {

                                // storing the location data in a variable
                                // do the database file writing
                                // include handler code to talk to the UI thread


                                


                            }
                        });

                        thread.start();

                    }

                    @Override
                    public void onStatusChanged(String provider, int status, Bundle extras) {

                    }

                    @Override
                    public void onProviderEnabled(String provider) {

                    }

                    @Override
                    public void onProviderDisabled(String provider) {

                    }
                });


            }catch (SecurityException e){
                e.printStackTrace();
            }

        }


        return super.onOptionsItemSelected(item);
    }
}
