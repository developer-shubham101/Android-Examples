package in.newdevpoint.android.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import in.newdevpoint.android.R;
import in.newdevpoint.android.adapter.MyAdapter;
import in.newdevpoint.android.viewModel.RecyclerActivityViewModel;
import in.newdevpoint.android.model.Result;

import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerActivityViewModel mRecyclerActivityViewModel;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        mRecyclerActivityViewModel = ViewModelProviders.of(this).get(RecyclerActivityViewModel.class);
        list();
        subscribe();
    }

    private void subscribe() {
        final Observer<List<Result>> elapsedTimeObserver = aLong ->
                mAdapter.addAll(aLong);

        mRecyclerActivityViewModel.getElapsedTime().observe(this, elapsedTimeObserver);
    }

    private void list() {
        RecyclerView mRecyclerView = findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter();
        mRecyclerView.setAdapter(mAdapter);


    }
}

