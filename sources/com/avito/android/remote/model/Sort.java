package com.avito.android.remote.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
public @interface Sort {
    public static final String DATE = "date";
    public static final String DISTANCE = "distance";
    public static final String PRICE_ASCENDING = "priceAsc";
    public static final String PRICE_DESCENDING = "priceDesc";
}
