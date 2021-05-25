package com.avito.android.deep_linking.links;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
public @interface PostAction {
    public static final String ACTIVATE = "activate";
}
