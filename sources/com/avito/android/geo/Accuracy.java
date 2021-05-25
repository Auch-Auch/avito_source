package com.avito.android.geo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
public @interface Accuracy {
    public static final int HIGH = 1;
    public static final int LOW = 0;
}
