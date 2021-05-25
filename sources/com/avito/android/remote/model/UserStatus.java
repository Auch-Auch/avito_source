package com.avito.android.remote.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
public @interface UserStatus {
    public static final String ACTIVE = "active";
    public static final String INCOMPLETE = "incomplete";
}
