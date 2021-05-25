package com.google.firebase.installations;

import androidx.annotation.NonNull;
import com.google.firebase.FirebaseException;
public class FirebaseInstallationsException extends FirebaseException {
    @NonNull
    public final Status a;

    public enum Status {
        BAD_CONFIG,
        UNAVAILABLE
    }

    public FirebaseInstallationsException(@NonNull Status status) {
        this.a = status;
    }

    @NonNull
    public Status getStatus() {
        return this.a;
    }

    public FirebaseInstallationsException(@NonNull String str, @NonNull Status status) {
        super(str);
        this.a = status;
    }

    public FirebaseInstallationsException(@NonNull String str, @NonNull Status status, @NonNull Throwable th) {
        super(str, th);
        this.a = status;
    }
}
