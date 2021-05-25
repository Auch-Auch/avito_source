package com.google.firebase;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Preconditions;
public class FirebaseException extends Exception {
    @Deprecated
    public FirebaseException() {
    }

    public FirebaseException(@RecentlyNonNull String str) {
        super(Preconditions.checkNotEmpty(str, "Detail message must not be empty"));
    }

    public FirebaseException(@RecentlyNonNull String str, @RecentlyNonNull Throwable th) {
        super(Preconditions.checkNotEmpty(str, "Detail message must not be empty"), th);
    }
}
