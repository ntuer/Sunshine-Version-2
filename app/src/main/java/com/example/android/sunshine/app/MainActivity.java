package com.example.android.sunshine.app;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {


        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            ArrayList<String> forecastStrings = new ArrayList<String>();
            forecastStrings.add("Today--Cloudy--22/32");
            forecastStrings.add("Thursday--Sunny--21/34");
            forecastStrings.add("Friday--Rainy--19/30");
            forecastStrings.add("Saturday--Cloudy--22/32");
            forecastStrings.add("Sunday--Cloudy--22/32");
            forecastStrings.add("Moday--Cloudy--21/30");
            forecastStrings.add("Tuesday--Sunny--20/34");

            ArrayAdapter<String> forecastArrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_forecast_item, R.id.textView, forecastStrings);

            ListView forecastListView = (ListView)rootView.findViewById(R.id.list_forecast_item_listview);
            forecastListView.setAdapter(forecastArrayAdapter);
            return rootView;
        }
    }
}
