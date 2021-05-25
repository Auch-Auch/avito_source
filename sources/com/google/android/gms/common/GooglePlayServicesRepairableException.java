package com.google.android.gms.common;

import android.content.Intent;
import androidx.annotation.RecentlyNonNull;
public class GooglePlayServicesRepairableException extends UserRecoverableException {
    private final int zza;

    public GooglePlayServicesRepairableException(@RecentlyNonNull int i, @RecentlyNonNull String str, @RecentlyNonNull Intent intent) {
        super(str, intent);
        this.zza = i;
    }

    @RecentlyNonNull
    public int getConnectionStatusCode() {
        return this.zza;
    }
}
