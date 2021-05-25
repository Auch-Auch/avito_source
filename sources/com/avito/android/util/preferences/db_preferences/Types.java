package com.avito.android.util.preferences.db_preferences;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
public @interface Types {
    public static final String BOOLEAN = "boolean";
    public static final String FLOAT = "float";
    public static final String INT = "int";
    public static final String LONG = "long";
    public static final String STRING = "string";
    public static final String STRING_SET = "string_set";
    public static final String UNKNOWN = "unknown";
}
