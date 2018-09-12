package com.arka.shubhamsharma.activities;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.arka.shubhamsharma.R;
import com.arka.shubhamsharma.sqlTask.DateAndTimeContract;
import com.arka.shubhamsharma.sqlTask.DateAndTimeDbHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateActivity extends AppCompatActivity {

    private static final String TAG = "DateActivity";
    EditText enterDate;
    TextView output;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);


        enterDate = findViewById(R.id.enterDate);
        output = findViewById(R.id.output);


    }

    public String[] getAppCategoryDetail() {

        String timeList = "";
        String selectQuery = "SELECT  * FROM " + DateAndTimeContract.FeedEntry.TABLE_NAME;

        Cursor cursor = db.rawQuery(selectQuery, null);
        String[] data = null;

        int dateCoulmn = cursor.getColumnIndex(DateAndTimeContract.FeedEntry.COLUMN_NAME_DATE);

        if (cursor.moveToFirst()) {
            do {

                timeList += cursor.getString(dateCoulmn) + "\n";

                Log.d(TAG, cursor.getString(dateCoulmn));
            } while (cursor.moveToNext());
        }
        cursor.close();
        output.setText(timeList);
        return data;
    }


    public void saveDate(View view) {

        DateAndTimeDbHelper mDbHelper = new DateAndTimeDbHelper(this);


        // Gets the data repository in write mode
        db = mDbHelper.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(DateAndTimeContract.FeedEntry.COLUMN_NAME_TITLE, enterDate.getText().toString());
        values.put(DateAndTimeContract.FeedEntry.COLUMN_NAME_DATE, convertDate());

// Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(DateAndTimeContract.FeedEntry.TABLE_NAME, null, values);

        getAppCategoryDetail();


    }

    private String convertDate() {
        String S = enterDate.getText().toString();

        //convert unix epoch timestamp (seconds) to milliseconds
        long timestamp = Long.parseLong(S) * 1000L;
        return getDate(timestamp);
    }


    private String getDate(long timeStamp) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Date netDate = (new Date(timeStamp));
            return sdf.format(netDate);
        } catch (Exception ex) {
            return "xx";
        }
    }
}

