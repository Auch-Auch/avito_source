package com.avito.android.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import com.avito.android.db.SearchSubscriptionsContract;
import com.avito.android.remote.model.SearchSubscription;
import java.util.List;
import javax.inject.Inject;
public class SearchSubscriptionDao extends BaseDao {
    @Inject
    public SearchSubscriptionDao(DbHelper dbHelper) {
        super(dbHelper);
    }

    @NonNull
    public static ContentValues a(@NonNull ContentValues contentValues, @NonNull SearchSubscription searchSubscription) {
        contentValues.put("subscription_id", searchSubscription.getId());
        contentValues.put("title", searchSubscription.getTitle());
        contentValues.put("description", searchSubscription.getDescription());
        contentValues.put(SearchSubscriptionsContract.Columns.UNREAD_COUNT, Integer.valueOf(searchSubscription.getCount()));
        contentValues.put(SearchSubscriptionsContract.Columns.LAST_UPDATE_TIME, Long.valueOf(searchSubscription.getLastUpdateTime()));
        contentValues.put(SearchSubscriptionsContract.Columns.SSID, searchSubscription.getSsid());
        return contentValues;
    }

    @NonNull
    public static SearchSubscription fromCursor(@NonNull Cursor cursor) {
        return new SearchSubscription(cursor.getString(cursor.getColumnIndex("subscription_id")), cursor.getString(cursor.getColumnIndex("title")), cursor.getString(cursor.getColumnIndex("description")), cursor.getLong(cursor.getColumnIndex(SearchSubscriptionsContract.Columns.LAST_UPDATE_TIME)), cursor.getInt(cursor.getColumnIndex(SearchSubscriptionsContract.Columns.UNREAD_COUNT)), null, cursor.getString(cursor.getColumnIndex(SearchSubscriptionsContract.Columns.SSID)), null, null, null);
    }

    public void deleteAll() {
        getWritableDatabase().delete(SearchSubscriptionsContract.TABLE_NAME, null, null);
    }

    public void deleteSearchSubscription(@NonNull String str) {
        getWritableDatabase().delete(SearchSubscriptionsContract.TABLE_NAME, "subscription_id = ?", new String[]{str});
    }

    public Cursor getSearchSubscriptionIds() {
        return getReadableDatabase().query(SearchSubscriptionsContract.TABLE_NAME, new String[]{"subscription_id"}, null, null, null, null, null);
    }

    public int getUnreadChangesCount() {
        return DbUtils.getCount(getReadableDatabase(), SearchSubscriptionsContract.TABLE_NAME, "unread_count <> 0", null);
    }

    public boolean hasSubscription(@NonNull String str) {
        return DbUtils.getCount(getReadableDatabase(), SearchSubscriptionsContract.TABLE_NAME, "subscription_id = ?", new String[]{str}) > 0;
    }

    public void resetUnreadChangesCount(@NonNull String str) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put(SearchSubscriptionsContract.Columns.UNREAD_COUNT, (Integer) 0);
        getWritableDatabase().update(SearchSubscriptionsContract.TABLE_NAME, contentValues, "subscription_id = ?", new String[]{str});
    }

    public void saveSearchSubscription(@NonNull SearchSubscription searchSubscription) {
        ContentValues contentValues = new ContentValues();
        a(contentValues, searchSubscription);
        getWritableDatabase().replace(SearchSubscriptionsContract.TABLE_NAME, null, contentValues);
    }

    public void saveSearchSubscriptions(@NonNull List<SearchSubscription> list) {
        deleteAll();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        try {
            writableDatabase.beginTransaction();
            for (SearchSubscription searchSubscription : list) {
                contentValues.clear();
                a(contentValues, searchSubscription);
                writableDatabase.replace(SearchSubscriptionsContract.TABLE_NAME, null, contentValues);
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }
}
