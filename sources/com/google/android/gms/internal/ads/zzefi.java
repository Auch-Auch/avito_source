package com.google.android.gms.internal.ads;
public final class zzefi extends zzefp {
    private final int zzibg;
    private final int zzibh;

    public zzefi(byte[] bArr, int i, int i2) {
        super(bArr);
        zzeff.zzi(i, i + i2, bArr.length);
        this.zzibg = i;
        this.zzibh = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzefp, com.google.android.gms.internal.ads.zzeff
    public final int size() {
        return this.zzibh;
    }

    @Override // com.google.android.gms.internal.ads.zzefp, com.google.android.gms.internal.ads.zzeff
    public final void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzibo, zzbdq() + i, bArr, i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzefp
    public final int zzbdq() {
        return this.zzibg;
    }

    @Override // com.google.android.gms.internal.ads.zzefp, com.google.android.gms.internal.ads.zzeff
    public final byte zzfu(int i) {
        zzeff.zzaa(i, size());
        return this.zzibo[this.zzibg + i];
    }

    @Override // com.google.android.gms.internal.ads.zzefp, com.google.android.gms.internal.ads.zzeff
    public final byte zzfv(int i) {
        return this.zzibo[this.zzibg + i];
    }
}
