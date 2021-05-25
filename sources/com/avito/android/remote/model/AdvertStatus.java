package com.avito.android.remote.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
public @interface AdvertStatus {
    public static final String ACTIVE = "active";
    public static final String BLOCKED = "blocked";
    public static final String CLOSED = "closed";
    public static final String DELETED = "deleted";
    public static final String INACTIVE = "inactive";
    public static final String OLD = "old";
    public static final String REJECTED = "rejected";
    public static final String REMOVED = "removed";
}
