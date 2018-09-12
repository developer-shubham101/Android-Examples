package com.arka.shubhamsharma.sqlTask;

import android.provider.BaseColumns;

public final class DateAndTimeContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private DateAndTimeContract() {}

    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_TITLE = "title";
    }
}