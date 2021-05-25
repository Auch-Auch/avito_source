package com.avito.android.remote;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
public @interface PasswordRestoreSourceType {
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";
}
