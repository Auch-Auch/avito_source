package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
public interface SafeParcelable extends Parcelable {
    @RecentlyNonNull
    public static final String NULL = "SAFE_PARCELABLE_NULL_STRING";

    public @interface Class {
        @RecentlyNonNull
        String creator();

        @RecentlyNonNull
        boolean validate() default false;
    }

    public @interface Constructor {
    }

    public @interface Field {
        @RecentlyNonNull
        String defaultValue() default "SAFE_PARCELABLE_NULL_STRING";

        @RecentlyNonNull
        String defaultValueUnchecked() default "SAFE_PARCELABLE_NULL_STRING";

        @RecentlyNonNull
        String getter() default "SAFE_PARCELABLE_NULL_STRING";

        @RecentlyNonNull
        int id();

        @RecentlyNonNull
        String type() default "SAFE_PARCELABLE_NULL_STRING";
    }

    public @interface Indicator {
        @RecentlyNonNull
        String getter() default "SAFE_PARCELABLE_NULL_STRING";
    }

    public @interface Param {
        @RecentlyNonNull
        int id();
    }

    public @interface Reserved {
        @RecentlyNonNull
        int[] value();
    }

    public @interface VersionField {
        @RecentlyNonNull
        String getter() default "SAFE_PARCELABLE_NULL_STRING";

        @RecentlyNonNull
        int id();

        @RecentlyNonNull
        String type() default "SAFE_PARCELABLE_NULL_STRING";
    }
}
