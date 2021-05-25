package com.avito.android.publish;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
public @interface PublishCalledFrom {
    public static final String FROM_FILTER = "filter";
    public static final String FROM_MENU = "menu";
    public static final String FROM_PROFILE = "profile";
    public static final String FROM_SEARCH = "search";
}
