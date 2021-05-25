package com.google.android.gms.internal.gtm;
public final class zznd implements Runnable {
    private final /* synthetic */ String zzatf;
    private final /* synthetic */ zzmz zzath;
    private final /* synthetic */ byte[] zzatj;

    public zznd(zzmz zzmz, String str, byte[] bArr) {
        this.zzath = zzmz;
        this.zzatf = str;
        this.zzatj = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzath.zzb(this.zzatf, this.zzatj);
    }
}
