package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
public final class zzmu implements zzoy {
    private final Uri uri;
    private final zzom zzaoo;
    private final zzmt zzbdm;
    private final zzpb zzbdn;
    private final /* synthetic */ zzmn zzbeg;
    private final zzkb zzbel = new zzkb();
    private volatile boolean zzbem;
    private boolean zzben = true;
    private long zzbeo;
    private long zzcp = -1;

    public zzmu(zzmn zzmn, Uri uri2, zzom zzom, zzmt zzmt, zzpb zzpb) {
        this.zzbeg = zzmn;
        this.uri = (Uri) zzoz.checkNotNull(uri2);
        this.zzaoo = (zzom) zzoz.checkNotNull(zzom);
        this.zzbdm = (zzmt) zzoz.checkNotNull(zzmt);
        this.zzbdn = zzpb;
    }

    @Override // com.google.android.gms.internal.ads.zzoy
    public final void cancelLoad() {
        this.zzbem = true;
    }

    public final void zze(long j, long j2) {
        this.zzbel.position = j;
        this.zzbeo = j2;
        this.zzben = true;
    }

    @Override // com.google.android.gms.internal.ads.zzoy
    public final boolean zzhv() {
        return this.zzbem;
    }

    @Override // com.google.android.gms.internal.ads.zzoy
    public final void zzhw() throws IOException, InterruptedException {
        Throwable th;
        int i = 0;
        while (i == 0 && !this.zzbem) {
            zzjw zzjw = null;
            try {
                long j = this.zzbel.position;
                long zza = this.zzaoo.zza(new zzon(this.uri, j, -1, this.zzbeg.zzbdj));
                this.zzcp = zza;
                if (zza != -1) {
                    this.zzcp = zza + j;
                }
                zzjw zzjw2 = new zzjw(this.zzaoo, j, this.zzcp);
                try {
                    zzjv zza2 = this.zzbdm.zza(zzjw2, this.zzaoo.getUri());
                    if (this.zzben) {
                        zza2.zzc(j, this.zzbeo);
                        this.zzben = false;
                    }
                    while (i == 0 && !this.zzbem) {
                        this.zzbdn.block();
                        i = zza2.zza(zzjw2, this.zzbel);
                        if (zzjw2.getPosition() > this.zzbeg.zzbdk + j) {
                            j = zzjw2.getPosition();
                            this.zzbdn.zzis();
                            this.zzbeg.handler.post(this.zzbeg.zzbdp);
                        }
                    }
                    if (i == 1) {
                        i = 0;
                    } else {
                        this.zzbel.position = zzjw2.getPosition();
                    }
                    zzpq.zza(this.zzaoo);
                } catch (Throwable th2) {
                    th = th2;
                    zzjw = zzjw2;
                    this.zzbel.position = zzjw.getPosition();
                    zzpq.zza(this.zzaoo);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (!(i == 1 || zzjw == null)) {
                    this.zzbel.position = zzjw.getPosition();
                }
                zzpq.zza(this.zzaoo);
                throw th;
            }
        }
    }
}
