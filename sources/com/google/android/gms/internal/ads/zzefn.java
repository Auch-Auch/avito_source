package com.google.android.gms.internal.ads;
public final class zzefn {
    private final byte[] buffer;
    private final zzefz zzibi;

    private zzefn(int i) {
        byte[] bArr = new byte[i];
        this.buffer = bArr;
        this.zzibi = zzefz.zzw(bArr);
    }

    public final zzeff zzbdr() {
        this.zzibi.zzbeu();
        return new zzefp(this.buffer);
    }

    public final zzefz zzbds() {
        return this.zzibi;
    }

    public /* synthetic */ zzefn(int i, zzefe zzefe) {
        this(i);
    }
}
