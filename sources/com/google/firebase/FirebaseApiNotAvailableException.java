package com.google.firebase;

import androidx.annotation.RecentlyNonNull;
public class FirebaseApiNotAvailableException extends FirebaseException {
    public FirebaseApiNotAvailableException(@RecentlyNonNull String str) {
        super(str);
    }
}
