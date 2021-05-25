package com.avito.android.db;

import a2.b.a.a.a;
import android.provider.BaseColumns;
public class AdvertsContract {
    public static final String DEFAULT_SORT_ORDER = "_id ASC";
    public static final String[] PROJECTION = {"_id", "timestamp", AdvertColumns.SERVER_ID, "category_id", "title", "price", "location_name", AdvertColumns.METRO_NAME, "image_url", "time", "status"};
    public static final String TIMESTAMP_ASC = "timestamp ASC";
    public static final String TIMESTAMP_DESC = "timestamp DESC";

    public interface AdvertColumns extends BaseColumns {
        public static final String CATEGORY_ID = "category_id";
        public static final String IMAGE_URL = "image_url";
        public static final String LOCATION_NAME = "location_name";
        public static final String METRO_NAME = "metro_name";
        public static final String PRICE = "price";
        public static final String SERVER_ID = "server_id";
        public static final String STATUS = "status";
        public static final String TIME = "time";
        public static final String TIMESTAMP = "timestamp";
        public static final String TITLE = "title";
    }

    public static String getCreateSql(String str) {
        StringBuilder W = a.W("CREATE TABLE ", str, " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,");
        a.n1(W, "timestamp", " INTEGER,", AdvertColumns.SERVER_ID, " TEXT,");
        a.n1(W, "category_id", " TEXT,", "title", " TEXT,");
        a.n1(W, "price", " TEXT,", "location_name", " TEXT,");
        a.n1(W, AdvertColumns.METRO_NAME, " TEXT,", "image_url", " TEXT,");
        a.n1(W, "status", " TEXT,", "time", " INTEGER");
        W.append(")");
        return W.toString();
    }
}
