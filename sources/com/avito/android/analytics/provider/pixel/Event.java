package com.avito.android.analytics.provider.pixel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
public @interface Event {
    public static final String PASS_BACK = "p";
    public static final String REQUEST = "r";
}
