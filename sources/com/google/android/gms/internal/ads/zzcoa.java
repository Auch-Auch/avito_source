package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
public final class zzcoa implements zzcox {
    private static final Pattern zzghr = Pattern.compile("Received error HTTP response code: (.*)");
    private final ScheduledExecutorService zzflf;
    private final zzdln zzfqn;
    private final zzdvw zzgay;
    private final zzcmw zzghp;
    private final zzcqq zzghq;

    public zzcoa(zzdln zzdln, zzcmw zzcmw, zzdvw zzdvw, ScheduledExecutorService scheduledExecutorService, zzcqq zzcqq) {
        this.zzfqn = zzdln;
        this.zzghp = zzcmw;
        this.zzgay = zzdvw;
        this.zzflf = scheduledExecutorService;
        this.zzghq = zzcqq;
    }

    public final /* synthetic */ zzdvt zze(InputStream inputStream) throws Exception {
        return zzdvl.zzaf(new zzdlj(new zzdle(this.zzfqn), zzdlh.zza(new InputStreamReader(inputStream))));
    }

    @Override // com.google.android.gms.internal.ads.zzcox
    public final zzdvt<zzdlj> zzh(zzasp zzasp) {
        zzdvt<zzdlj> zzb = zzdvl.zzb(this.zzghp.zze(zzasp), new zzduv(this) { // from class: com.google.android.gms.internal.ads.zzcnz
            private final zzcoa zzghv;

            {
                this.zzghv = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return this.zzghv.zze((InputStream) obj);
            }
        }, this.zzgay);
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcun)).booleanValue()) {
            zzb = zzdvl.zzb(zzdvl.zza(zzb, (long) ((Integer) zzwe.zzpu().zzd(zzaat.zzcuo)).intValue(), TimeUnit.SECONDS, this.zzflf), TimeoutException.class, zzcoc.zzbok, zzbbi.zzedz);
        }
        zzdvl.zza(zzb, new zzcob(this), zzbbi.zzedz);
        return zzb;
    }
}
