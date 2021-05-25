package com.avito.android.db;

import android.provider.BaseColumns;
@Deprecated
public final class SavedSearchesContract {
    public static final String TABLE_NAME = "saved_searches";
    public static final String TIMESTAMP_ASC = "timestamp ASC";

    public interface Columns extends BaseColumns {
        public static final String DESCRIPTION = "description";
        public static final String HAS_UNREAD_CHANGES = "has_unread_changes";
        public static final String HUMAN_READABLE_PARAMS = "human_readable_params";
        public static final String LATEST_ADVERT_VALUE = "latest_advert_value";
        public static final String SEARCH_PARAMS = "search_params";
        public static final String TIMESTAMP = "timestamp";
        public static final String TITLE = "title";
    }

    public static String getCreateSql() {
        return "CREATE TABLE saved_searches (_id INTEGER PRIMARY KEY AUTOINCREMENT,timestamp INTEGER,title TEXT,description TEXT,search_params TEXT,human_readable_params TEXT,latest_advert_value INTEGER,has_unread_changes INTEGER DEFAULT 0)";
    }
}
