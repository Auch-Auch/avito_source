package com.google.android.flexbox;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
public @interface AlignItems {
    public static final int BASELINE = 3;
    public static final int CENTER = 2;
    public static final int FLEX_END = 1;
    public static final int FLEX_START = 0;
    public static final int STRETCH = 4;
}
