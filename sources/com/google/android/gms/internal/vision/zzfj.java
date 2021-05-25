package com.google.android.gms.internal.vision;
public final class zzfj extends zzfg {
    @Override // com.google.android.gms.internal.vision.zzfg
    public final void zza(Throwable th, Throwable th2) {
        th.addSuppressed(th2);
    }

    @Override // com.google.android.gms.internal.vision.zzfg
    public final void zza(Throwable th) {
        th.printStackTrace();
    }
}
