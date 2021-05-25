package com.avito.android.db;

import android.provider.BaseColumns;
public final class SubscriptionsContract {
    public static final String TABLE_NAME = "subscriptions";

    public interface Columns extends BaseColumns {
        public static final String COUNT = "count";
        public static final String DESCRIPTION = "description";
        public static final String LAST_UPDATE_TIME = "last_update_time";
        public static final String LAST_VIEW_TIME = "last_view_time";
        public static final String SEARCH_PARAMS = "search_params";
        public static final String SUBSCRIPTION_ID = "subscription_id";
        public static final String TITLE = "title";
    }

    public static String getCreateSql() {
        return "CREATE TABLE IF NOT EXISTS subscriptions (_id INTEGER PRIMARY KEY AUTOINCREMENT, subscription_id INTEGER DEFAULT 0, title TEXT, description TEXT, search_params TEXT, count INTEGER DEFAULT 0, last_update_time INTEGER DEFAULT 0, last_view_time INTEGER DEFAULT 0)";
    }
}
