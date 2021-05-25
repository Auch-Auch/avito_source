package com.google.android.gms.common.api;

import a2.b.a.a.a;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
public final class UnsupportedApiCallException extends UnsupportedOperationException {
    private final Feature zza;

    @KeepForSdk
    public UnsupportedApiCallException(@RecentlyNonNull Feature feature) {
        this.zza = feature;
    }

    @Override // java.lang.Throwable
    @RecentlyNonNull
    public final String getMessage() {
        String valueOf = String.valueOf(this.zza);
        return a.r2(valueOf.length() + 8, "Missing ", valueOf);
    }
}
