package com.my.target.nativeads;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
public @interface AdChoicesPlacement {
    public static final int BOTTOM_LEFT = 3;
    public static final int BOTTOM_RIGHT = 2;
    public static final int MANUAL = 4;
    public static final int TOP_LEFT = 1;
    public static final int TOP_RIGHT = 0;
}
