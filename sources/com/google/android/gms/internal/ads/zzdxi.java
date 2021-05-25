package com.google.android.gms.internal.ads;

import java.util.Arrays;
public final class zzdxi<P> {
    private final P zzhrb;
    private final byte[] zzhrc;
    private final zzebu zzhrd;
    private final zzecn zzhre;
    private final int zzhrf;

    public zzdxi(P p, byte[] bArr, zzebu zzebu, zzecn zzecn, int i) {
        this.zzhrb = p;
        this.zzhrc = Arrays.copyOf(bArr, bArr.length);
        this.zzhrd = zzebu;
        this.zzhre = zzecn;
        this.zzhrf = i;
    }

    public final P zzaxz() {
        return this.zzhrb;
    }

    public final zzebu zzaya() {
        return this.zzhrd;
    }

    public final zzecn zzayb() {
        return this.zzhre;
    }

    public final byte[] zzayc() {
        byte[] bArr = this.zzhrc;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }
}
