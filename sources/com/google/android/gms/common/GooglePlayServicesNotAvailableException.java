package com.google.android.gms.common;

import androidx.annotation.RecentlyNonNull;
public final class GooglePlayServicesNotAvailableException extends Exception {
    @RecentlyNonNull
    public final int errorCode;

    public GooglePlayServicesNotAvailableException(@RecentlyNonNull int i) {
        this.errorCode = i;
    }
}
