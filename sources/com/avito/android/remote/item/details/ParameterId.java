package com.avito.android.remote.item.details;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
public @interface ParameterId {
    public static final String COORDS = "coords";
    public static final String DESCRIPTION = "description";
    public static final String EDIT = "wizardId";
    public static final String IMAGES = "images";
    public static final String LOCATION = "locationId";
    public static final String MANAGER = "manager";
    public static final String PHONE = "phone";
    public static final String PRICE = "price";
    public static final String TITLE = "title";
}
