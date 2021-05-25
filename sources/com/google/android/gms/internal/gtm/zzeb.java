package com.google.android.gms.internal.gtm;

import android.util.Log;
public final class zzeb implements zzew {
    private boolean zzani = true;
    private int zzyr = 5;

    private final boolean isLoggable(int i) {
        if (!this.zzani || !Log.isLoggable("GoogleTagManager", i)) {
            return !this.zzani && this.zzyr <= i;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.gtm.zzew
    public final void zza(String str, Throwable th) {
        isLoggable(6);
    }

    @Override // com.google.android.gms.internal.gtm.zzew
    public final void zzab(String str) {
        isLoggable(2);
    }

    @Override // com.google.android.gms.internal.gtm.zzew
    public final void zzac(String str) {
        isLoggable(5);
    }

    @Override // com.google.android.gms.internal.gtm.zzew
    public final void zzav(String str) {
        isLoggable(6);
    }

    @Override // com.google.android.gms.internal.gtm.zzew
    public final void zzaw(String str) {
        isLoggable(4);
    }

    @Override // com.google.android.gms.internal.gtm.zzew
    public final void zzb(String str, Throwable th) {
        isLoggable(5);
    }
}
