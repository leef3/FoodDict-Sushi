package com.redleefstudios.sushidictionary;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FoodListFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        Fragment fragment = new FoodListFragment();
        fragmentTransaction.add(R.id.fragmentRoot, fragment, "FOODLISTFRAG");
        fragmentTransaction.commit();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public void onSelection(int position)
    {
        Log.d("Main Activity", "Item: " + position + " Clicked");

        // Create new fragment and transaction
        Fragment newFragment = new FoodDetailFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.fragmentRoot, newFragment, "FOODDETAILFRAG");
        transaction.addToBackStack(null);

        transaction.commit();
    }
}
