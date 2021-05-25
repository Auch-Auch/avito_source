package com.google.android.gms.internal.ads;

import java.util.Arrays;
public final class zzoq implements zzok {
    private final boolean zzbir;
    private final int zzbis;
    private final byte[] zzbit;
    private final zzoh[] zzbiu;
    private int zzbiv;
    private int zzbiw;
    private int zzbix;
    private zzoh[] zzbiy;

    public zzoq(boolean z, int i) {
        this(true, 65536, 0);
    }

    public final synchronized void reset() {
        if (this.zzbir) {
            zzbi(0);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzok
    public final synchronized void zza(zzoh zzoh) {
        zzoh[] zzohArr = this.zzbiu;
        zzohArr[0] = zzoh;
        zza(zzohArr);
    }

    public final synchronized void zzbi(int i) {
        boolean z = i < this.zzbiv;
        this.zzbiv = i;
        if (z) {
            zzn();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzok
    public final synchronized zzoh zzil() {
        zzoh zzoh;
        this.zzbiw++;
        int i = this.zzbix;
        if (i > 0) {
            zzoh[] zzohArr = this.zzbiy;
            int i2 = i - 1;
            this.zzbix = i2;
            zzoh = zzohArr[i2];
            zzohArr[i2] = null;
        } else {
            zzoh = new zzoh(new byte[this.zzbis], 0);
        }
        return zzoh;
    }

    @Override // com.google.android.gms.internal.ads.zzok
    public final int zzim() {
        return this.zzbis;
    }

    public final synchronized int zzip() {
        return this.zzbiw * this.zzbis;
    }

    @Override // com.google.android.gms.internal.ads.zzok
    public final synchronized void zzn() {
        int max = Math.max(0, zzpq.zzf(this.zzbiv, this.zzbis) - this.zzbiw);
        int i = this.zzbix;
        if (max < i) {
            Arrays.fill(this.zzbiy, max, i, (Object) null);
            this.zzbix = max;
        }
    }

    private zzoq(boolean z, int i, int i2) {
        zzoz.checkArgument(true);
        zzoz.checkArgument(true);
        this.zzbir = true;
        this.zzbis = 65536;
        this.zzbix = 0;
        this.zzbiy = new zzoh[100];
        this.zzbit = null;
        this.zzbiu = new zzoh[1];
    }

    @Override // com.google.android.gms.internal.ads.zzok
    public final synchronized void zza(zzoh[] zzohArr) {
        boolean z;
        int i = this.zzbix;
        int length = zzohArr.length + i;
        zzoh[] zzohArr2 = this.zzbiy;
        if (length >= zzohArr2.length) {
            this.zzbiy = (zzoh[]) Arrays.copyOf(zzohArr2, Math.max(zzohArr2.length << 1, i + zzohArr.length));
        }
        for (zzoh zzoh : zzohArr) {
            byte[] bArr = zzoh.data;
            if (bArr != null) {
                if (bArr.length != this.zzbis) {
                    z = false;
                    zzoz.checkArgument(z);
                    zzoh[] zzohArr3 = this.zzbiy;
                    int i2 = this.zzbix;
                    this.zzbix = i2 + 1;
                    zzohArr3[i2] = zzoh;
                }
            }
            z = true;
            zzoz.checkArgument(z);
            zzoh[] zzohArr3 = this.zzbiy;
            int i2 = this.zzbix;
            this.zzbix = i2 + 1;
            zzohArr3[i2] = zzoh;
        }
        this.zzbiw -= zzohArr.length;
        notifyAll();
    }
}
