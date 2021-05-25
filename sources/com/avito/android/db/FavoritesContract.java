package com.avito.android.db;

import a2.b.a.a.a;
import com.avito.android.db.AdvertsContract;
public class FavoritesContract extends AdvertsContract {
    public static final String TABLE_NAME = "favorites";

    public interface FavoriteAdvertColumns extends AdvertsContract.AdvertColumns {
        @Deprecated
        public static final String MARKED_FOR_REMOVE_FLAG = "marked_for_remove";
        @Deprecated
        public static final String PAGE_NUM = "page";
        public static final int SYNC_DONE = 1;
        public static final String SYNC_FLAG = "sync_flag";
        public static final int SYNC_PENDING = 0;
    }

    public static String getCreateSql() {
        return getCreateSql(TABLE_NAME);
    }

    public static String getCreateSql(String str) {
        StringBuilder W = a.W("CREATE TABLE ", str, " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,");
        a.n1(W, "timestamp", " INTEGER,", AdvertsContract.AdvertColumns.SERVER_ID, " TEXT,");
        a.n1(W, "category_id", " TEXT,", "title", " TEXT,");
        a.n1(W, "price", " TEXT,", "location_name", " TEXT,");
        a.n1(W, AdvertsContract.AdvertColumns.METRO_NAME, " TEXT,", "image_url", " TEXT,");
        a.n1(W, "status", " TEXT,", "time", " INTEGER,");
        a.n1(W, "page", " INTEGER DEFAULT 0,", FavoriteAdvertColumns.SYNC_FLAG, " INTEGER DEFAULT 0,");
        return a.u(W, FavoriteAdvertColumns.MARKED_FOR_REMOVE_FLAG, " INTEGER DEFAULT 0", ")");
    }
}
