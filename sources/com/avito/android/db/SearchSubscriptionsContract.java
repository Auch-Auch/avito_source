package com.avito.android.db;

import android.provider.BaseColumns;
public class SearchSubscriptionsContract {
    public static final String TABLE_NAME = "search_subscriptions";

    public interface Columns extends BaseColumns {
        public static final String DESCRIPTION = "description";
        public static final String LAST_UPDATE_TIME = "last_update";
        public static final String SSID = "ssid";
        public static final String SUBSCRIPTION_ID = "subscription_id";
        public static final String TITLE = "title";
        public static final String UNREAD_COUNT = "unread_count";
    }

    public static String getCreateSql() {
        return "CREATE TABLE search_subscriptions (_id INTEGER PRIMARY KEY AUTOINCREMENT,subscription_id TEXT,description TEXT,title TEXT,unread_count INTEGER,last_update INTEGER,ssid TEXT)";
    }
}
