package com.avito.android.db.entity;
@Deprecated
public class SavedSearch {
    public static final long LATEST_VALUE_NOT_FOUND = -1;
    public static final long LATEST_VALUE_NOT_INITIALIZED = -2;
    public String description;
    public boolean hasUnreadChanges;
    public String humanReadableParams;
    public long id;
    public long latestAdvertValue = -2;
    public String searchParams;
    public long timestamp;
    public String title;

    public boolean isPendingUpdate() {
        return this.latestAdvertValue == -2;
    }
}
