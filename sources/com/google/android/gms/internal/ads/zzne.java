package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
public final class zzne implements zzmz {
    private final zzid zzaer = new zzid();
    private final zzmz[] zzbfa;
    private final ArrayList<zzmz> zzbfb;
    private zznc zzbfc;
    private zzhy zzbfd;
    private Object zzbfe;
    private int zzbff = -1;
    private zzng zzbfg;

    public zzne(zzmz... zzmzArr) {
        this.zzbfa = zzmzArr;
        this.zzbfb = new ArrayList<>(Arrays.asList(zzmzArr));
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final void zza(zzhc zzhc, boolean z, zznc zznc) {
        this.zzbfc = zznc;
        int i = 0;
        while (true) {
            zzmz[] zzmzArr = this.zzbfa;
            if (i < zzmzArr.length) {
                zzmzArr[i].zza(zzhc, false, new zznd(this, i));
                i++;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final void zzb(zzmx zzmx) {
        zznb zznb = (zznb) zzmx;
        int i = 0;
        while (true) {
            zzmz[] zzmzArr = this.zzbfa;
            if (i < zzmzArr.length) {
                zzmzArr[i].zzb(zznb.zzbet[i]);
                i++;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final void zzhx() throws IOException {
        zzng zzng = this.zzbfg;
        if (zzng == null) {
            for (zzmz zzmz : this.zzbfa) {
                zzmz.zzhx();
            }
            return;
        }
        throw zzng;
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final void zzhy() {
        for (zzmz zzmz : this.zzbfa) {
            zzmz.zzhy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final zzmx zza(int i, zzok zzok) {
        int length = this.zzbfa.length;
        zzmx[] zzmxArr = new zzmx[length];
        for (int i2 = 0; i2 < length; i2++) {
            zzmxArr[i2] = this.zzbfa[i2].zza(i, zzok);
        }
        return new zznb(zzmxArr);
    }

    /* access modifiers changed from: private */
    public final void zza(int i, zzhy zzhy, Object obj) {
        zzng zzng;
        if (this.zzbfg == null) {
            int zzfd = zzhy.zzfd();
            int i2 = 0;
            while (true) {
                if (i2 >= zzfd) {
                    if (this.zzbff == -1) {
                        this.zzbff = zzhy.zzfe();
                    } else if (zzhy.zzfe() != this.zzbff) {
                        zzng = new zzng(1);
                    }
                    zzng = null;
                } else if (zzhy.zza(i2, this.zzaer, false).zzaip) {
                    zzng = new zzng(0);
                    break;
                } else {
                    i2++;
                }
            }
            this.zzbfg = zzng;
        }
        if (this.zzbfg == null) {
            this.zzbfb.remove(this.zzbfa[i]);
            if (i == 0) {
                this.zzbfd = zzhy;
                this.zzbfe = obj;
            }
            if (this.zzbfb.isEmpty()) {
                this.zzbfc.zzb(this.zzbfd, this.zzbfe);
            }
        }
    }
}
