package com.avito.android.remote.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
public @interface AdvertServiceId {
    public static final int BUMP_UP = 3;
    public static final int CONTACT_ACCESS = 13;
    public static final int HIGHLIGHT = 2;
    public static final int PREMIUM = 4;
    public static final int SINGLE_FEE = 6;
    public static final int VIP = 1;
}
