package com.avito.android.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import com.avito.android.db.SavedSearchesContract;
import com.avito.android.db.entity.SavedSearch;
@Deprecated
public class SavedSearchDao extends BaseDao {
    public SavedSearchDao(DbHelper dbHelper) {
        super(dbHelper);
    }

    public int getCount() {
        return DbUtils.getCount(getReadableDatabase(), SavedSearchesContract.TABLE_NAME);
    }

    @NonNull
    public SavedSearch readFromCursor(@NonNull Cursor cursor) {
        SavedSearch savedSearch = new SavedSearch();
        savedSearch.id = cursor.getLong(cursor.getColumnIndex("_id"));
        savedSearch.title = cursor.getString(cursor.getColumnIndex("title"));
        savedSearch.description = cursor.getString(cursor.getColumnIndex("description"));
        savedSearch.searchParams = cursor.getString(cursor.getColumnIndex("search_params"));
        savedSearch.humanReadableParams = cursor.getString(cursor.getColumnIndex(SavedSearchesContract.Columns.HUMAN_READABLE_PARAMS));
        savedSearch.timestamp = cursor.getLong(cursor.getColumnIndex("timestamp"));
        savedSearch.latestAdvertValue = cursor.getLong(cursor.getColumnIndex(SavedSearchesContract.Columns.LATEST_ADVERT_VALUE));
        savedSearch.hasUnreadChanges = cursor.getInt(cursor.getColumnIndex(SavedSearchesContract.Columns.HAS_UNREAD_CHANGES)) != 0;
        return savedSearch;
    }

    @NonNull
    public Cursor readSearches() {
        return getReadableDatabase().query(SavedSearchesContract.TABLE_NAME, DbUtils.EMPTY_COLUMNS, DbUtils.EMPTY_SELECTION, DbUtils.EMPTY_SELECTION_ARGS, DbUtils.EMPTY_GROUP_BY, DbUtils.EMPTY_HAVING, "timestamp ASC");
    }

    public boolean remove(SavedSearch savedSearch) {
        return removeById(savedSearch.id);
    }

    public boolean removeById(long j) {
        if (getWritableDatabase().delete(SavedSearchesContract.TABLE_NAME, "_id=?", new String[]{String.valueOf(j)}) > 0) {
            return true;
        }
        return false;
    }

    public boolean update(SavedSearch savedSearch) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SavedSearchesContract.Columns.LATEST_ADVERT_VALUE, Long.valueOf(savedSearch.latestAdvertValue));
        contentValues.put(SavedSearchesContract.Columns.HAS_UNREAD_CHANGES, Integer.valueOf(savedSearch.hasUnreadChanges ? 1 : 0));
        if (writableDatabase.update(SavedSearchesContract.TABLE_NAME, contentValues, "_id=?", new String[]{String.valueOf(savedSearch.id)}) > 0) {
            return true;
        }
        return false;
    }
}
