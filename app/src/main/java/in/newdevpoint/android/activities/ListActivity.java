package in.newdevpoint.android.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import in.newdevpoint.android.R;
import in.newdevpoint.android.adapter.CustomExpandableListAdapter;
import in.newdevpoint.android.model.Result;
import in.newdevpoint.android.viewModel.ListActivityViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private LinkedHashMap<String, List<String>> sortedCountries = new LinkedHashMap<>();
    private ArrayList<String> expandableListTitle;
    private ListActivityViewModel listActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listActivityViewModel = ViewModelProviders.of(this).get(ListActivityViewModel.class);
        subscribe();
    }

    private void subscribe() {
        final Observer<List<Result>> elapsedTimeObserver = results -> {
            HashMap<String, List<String>> tmpSortedCountries = new HashMap<>();
            if (results != null) {
                for (Result country : results) {
                    List<String> tmp = tmpSortedCountries.get(Character.toString(country.getName().charAt(0)));
                    if (tmp == null)
                        tmp = new ArrayList<>();
                    tmp.add(country.getName());
                    tmpSortedCountries.put(Character.toString(country.getName().charAt(0)), tmp);
                }


                String[] keys = tmpSortedCountries.keySet().toArray(new String[0]);
                Arrays.sort(keys);
                for (String key : keys) {
                    sortedCountries.put(key, tmpSortedCountries.get(key));
                }
                list();
                Log.d(TAG, "Number of countries received: " + results.size());
            }
        };

        listActivityViewModel.getElapsedTime().observe(this, elapsedTimeObserver);
    }
    private void list() {
        ExpandableListView expandableListView = findViewById(R.id.countriesListView);
        expandableListTitle = new ArrayList<>(sortedCountries.keySet());

        ExpandableListAdapter expandableListAdapter = new CustomExpandableListAdapter(this, expandableListTitle, sortedCountries);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(groupPosition -> Toast.makeText(getApplicationContext(),
                expandableListTitle.get(groupPosition) + " List Expanded.",
                Toast.LENGTH_SHORT).show());

        expandableListView.setOnGroupCollapseListener(groupPosition -> Toast.makeText(getApplicationContext(),
                expandableListTitle.get(groupPosition) + " List Collapsed.",
                Toast.LENGTH_SHORT).show());

        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            Toast.makeText(
                    getApplicationContext(),
                    expandableListTitle.get(groupPosition)
                            + " -> "
                            + sortedCountries.get(
                            expandableListTitle.get(groupPosition)).get(
                            childPosition), Toast.LENGTH_SHORT
            ).show();
            return false;
        });
    }
}

