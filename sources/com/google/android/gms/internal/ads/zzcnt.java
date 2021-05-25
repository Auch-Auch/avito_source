package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
public final class zzcnt extends zzcnr {
    private static final Pattern zzghr = Pattern.compile("Received error HTTP response code: (.*)");
    private final ScheduledExecutorService zzflf;
    private final zzdln zzfqn;
    private final zzdvw zzgay;
    private final zzcmw zzghp;
    private final zzcqq zzghq;

    public zzcnt(zzbve zzbve, zzdln zzdln, zzcmw zzcmw, zzdvw zzdvw, ScheduledExecutorService scheduledExecutorService, zzcqq zzcqq) {
        super(zzbve);
        this.zzfqn = zzdln;
        this.zzghp = zzcmw;
        this.zzgay = zzdvw;
        this.zzflf = scheduledExecutorService;
        this.zzghq = zzcqq;
    }

    @Override // com.google.android.gms.internal.ads.zzcnr
    public final zzdvt<zzdlj> zzb(zzasp zzasp) throws zzcmt {
        zzdvt<zzdlj> zzb = zzdvl.zzb(this.zzghp.zze(zzasp), new zzduv(this) { // from class: com.google.android.gms.internal.ads.zzcnw
            private final zzcnt zzght;

            {
                this.zzght = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return this.zzght.zzd((InputStream) obj);
            }
        }, this.zzgay);
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcun)).booleanValue()) {
            zzb = zzdvl.zzb(zzdvl.zza(zzb, (long) ((Integer) zzwe.zzpu().zzd(zzaat.zzcuo)).intValue(), TimeUnit.SECONDS, this.zzflf), TimeoutException.class, zzcnv.zzbok, zzbbi.zzedz);
        }
        zzdvl.zza(zzb, new zzcny(this), zzbbi.zzedz);
        return zzb;
    }

    public final /* synthetic */ zzdvt zzd(InputStream inputStream) throws Exception {
        return zzdvl.zzaf(new zzdlj(new zzdle(this.zzfqn), zzdlh.zza(new InputStreamReader(inputStream))));
    }
}
