package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpd;
import java.util.LinkedList;
import javax.annotation.concurrent.GuardedBy;
public final class zzdnp<AdT extends zzbpd> {
    private final zzdna zzgyr;
    private final zzdmt zzhfn;
    @GuardedBy("this")
    private zzdnv zzhfo;
    @GuardedBy("this")
    private zzdwe<zzdnh<AdT>> zzhfp;
    @GuardedBy("this")
    private zzdvt<zzdnh<AdT>> zzhfq;
    @GuardedBy("this")
    private int zzhfr = zzdnf.zzhez;
    private final zzdnw<AdT> zzhfs;
    private final LinkedList<zzdnv> zzhft;
    private final zzdvi<zzdnh<AdT>> zzhfu = new zzdnu(this);

    public zzdnp(zzdna zzdna, zzdmt zzdmt, zzdnw<AdT> zzdnw) {
        this.zzgyr = zzdna;
        this.zzhfn = zzdmt;
        this.zzhfs = zzdnw;
        this.zzhft = new LinkedList<>();
        zzdmt.zza(new zzdmw(this) { // from class: com.google.android.gms.internal.ads.zzdnr
            private final zzdnp zzhfw;

            {
                this.zzhfw = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzdmw
            public final void execute() {
                this.zzhfw.zzatz();
            }
        });
    }

    private final boolean zzaty() {
        zzdvt<zzdnh<AdT>> zzdvt = this.zzhfq;
        return zzdvt == null || zzdvt.isDone();
    }

    /* access modifiers changed from: private */
    public final void zzd(zzdnv zzdnv) {
        while (zzaty()) {
            if (zzdnv != null || !this.zzhft.isEmpty()) {
                if (zzdnv == null) {
                    zzdnv = this.zzhft.remove();
                }
                if (zzdnv.zzasd() == null || !this.zzgyr.zzb(zzdnv.zzasd())) {
                    zzdnv = null;
                } else {
                    this.zzhfo = zzdnv.zzase();
                    this.zzhfp = zzdwe.zzaxn();
                    zzdvt<zzdnh<AdT>> zza = this.zzhfs.zza(this.zzhfo);
                    this.zzhfq = zza;
                    zzdvl.zza(zza, this.zzhfu, zzdnv.getExecutor());
                    return;
                }
            } else {
                return;
            }
        }
        if (zzdnv != null) {
            this.zzhft.add(zzdnv);
        }
    }

    public final /* synthetic */ void zzatz() {
        synchronized (this) {
            zzd(this.zzhfo);
        }
    }

    public final void zzb(zzdnv zzdnv) {
        this.zzhft.add(zzdnv);
    }

    public final synchronized zzdvt<zzdnt<AdT>> zzc(zzdnv zzdnv) {
        if (zzaty()) {
            return null;
        }
        this.zzhfr = zzdnf.zzhfb;
        if (this.zzhfo.zzasd() == null || zzdnv.zzasd() == null || !this.zzhfo.zzasd().equals(zzdnv.zzasd())) {
            return null;
        }
        this.zzhfr = zzdnf.zzhfa;
        return zzdvl.zzb(this.zzhfp, new zzduv(this) { // from class: com.google.android.gms.internal.ads.zzdns
            private final zzdnp zzhfw;

            {
                this.zzhfw = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return this.zzhfw.zzc((zzdnh) obj);
            }
        }, zzdnv.getExecutor());
    }

    public final /* synthetic */ zzdvt zzc(zzdnh zzdnh) throws Exception {
        zzdvt zzaf;
        synchronized (this) {
            zzaf = zzdvl.zzaf(new zzdnt(zzdnh, this.zzhfo));
        }
        return zzaf;
    }
}
