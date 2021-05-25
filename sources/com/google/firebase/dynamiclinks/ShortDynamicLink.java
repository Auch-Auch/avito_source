package com.google.firebase.dynamiclinks;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
public interface ShortDynamicLink {

    @Retention(RetentionPolicy.SOURCE)
    public @interface Suffix {
        public static final int SHORT = 2;
        public static final int UNGUESSABLE = 1;
    }

    public interface Warning {
        @Nullable
        @Deprecated
        String getCode();

        @Nullable
        String getMessage();
    }

    @Nullable
    Uri getPreviewLink();

    @Nullable
    Uri getShortLink();

    @NonNull
    List<? extends Warning> getWarnings();
}
