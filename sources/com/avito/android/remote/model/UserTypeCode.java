package com.avito.android.remote.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
public @interface UserTypeCode {
    public static final String COMPANY = "company";
    public static final String PRIVATE = "private";
}
