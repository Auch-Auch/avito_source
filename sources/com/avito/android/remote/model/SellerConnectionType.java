package com.avito.android.remote.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
public @interface SellerConnectionType {
    public static final String EMAIL = "email";
    public static final String FACEBOOK = "fb";
    public static final String GOOGLE = "gp";
    public static final String ODNOKLASSNIKI = "ok";
    public static final String PHONE = "phone";
    public static final String VKONTAKTE = "vk";
}
