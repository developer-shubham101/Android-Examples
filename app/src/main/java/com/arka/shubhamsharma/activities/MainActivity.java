package com.arka.shubhamsharma.activities;

import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.arka.shubhamsharma.R;

import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N_MR1) {
            ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);

            ShortcutInfo shortcut = new ShortcutInfo.Builder(this, "id1")
                    .setShortLabel("ListActivity")
                    .setLongLabel("Open the ListActivity")
                    .setIcon(Icon.createWithResource(this, R.drawable.upload))

                    .setIntent(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/")))
//                    .setIntent(new Intent(this,ListActivity.class))
                    .build();

            if (shortcutManager != null) {
                shortcutManager.setDynamicShortcuts(Collections.singletonList(shortcut));
            }
        }


    }


    public void openList(View view) {
        startActivity(new Intent(this, ListActivity.class));
    }

    public void openRecycler(View view) {
        startActivity(new Intent(this, RecyclerActivity.class));
    }

    public void openSqlite(View view) {
        startActivity(new Intent(this, DateActivity.class));
    }

    public void openImage(View view) {
        startActivity(new Intent(this, ImagesActivity.class));
    }

    public void openMap(View view) {
        startActivity(new Intent(this, AnimationActivity.class));
    }

    interface SampleOfInterFaceObject {
        void thisIsMethod();
    }
}

