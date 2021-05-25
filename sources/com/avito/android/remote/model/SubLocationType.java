package com.avito.android.remote.model;

import android.annotation.SuppressLint;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
@SuppressLint({"ShiftFlags"})
public @interface SubLocationType {
    public static final int DIRECTION = 2;
    public static final int DISTRICT = 4;
    public static final int METRO = 1;
    public static final int NONE = 0;
}
