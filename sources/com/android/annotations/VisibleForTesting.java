package com.android.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Deprecated
@Retention(RetentionPolicy.SOURCE)
public @interface VisibleForTesting {

    public enum Visibility {
        PROTECTED,
        PACKAGE,
        PRIVATE
    }

    Visibility visibility() default Visibility.PRIVATE;
}
