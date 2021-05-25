package com.avito.android.remote.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
public @interface AvatarStatus {
    public static final String ACTIVE = "active";
    public static final String MISSING = "missing";
    public static final String REJECTED = "rejected";
    public static final String REVIEW = "review";
}
