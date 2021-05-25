package com.avito.android.remote.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
public @interface Case {
    public static final int DATIVE = 3;
    public static final int GENITIVE = 2;
    public static final int NOMINATIVE = 1;
    public static final int PREPOSITIONAL = 6;
}
