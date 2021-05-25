package com.google.android.gms.internal.ads;

import java.io.PrintWriter;
public final class zzeet extends zzeen {
    @Override // com.google.android.gms.internal.ads.zzeen
    public final void zza(Throwable th, Throwable th2) {
        th.addSuppressed(th2);
    }

    @Override // com.google.android.gms.internal.ads.zzeen
    public final void zza(Throwable th, PrintWriter printWriter) {
        th.printStackTrace(printWriter);
    }
}
