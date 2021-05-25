package com.google.android.gms.internal.gtm;

import com.google.android.gms.analytics.Logger;
public final class zzbr implements Logger {
    private boolean zzrv;
    private int zzyr = 2;

    @Override // com.google.android.gms.analytics.Logger
    public final void error(Exception exc) {
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void error(String str) {
    }

    @Override // com.google.android.gms.analytics.Logger
    public final int getLogLevel() {
        return this.zzyr;
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void info(String str) {
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void setLogLevel(int i) {
        this.zzyr = i;
        if (!this.zzrv) {
            zzby.zzzb.get();
            String.valueOf(zzby.zzzb.get()).length();
            this.zzrv = true;
        }
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void verbose(String str) {
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void warn(String str) {
    }
}
