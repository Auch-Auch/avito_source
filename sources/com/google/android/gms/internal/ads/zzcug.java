package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;
public final class zzcug implements zzdvi<T> {
    private final /* synthetic */ String zzgnf;
    private final /* synthetic */ long zzgng;
    private final /* synthetic */ zzdkx zzgnh;
    private final /* synthetic */ zzdkz zzgni;
    private final /* synthetic */ zzcud zzgnj;

    public zzcug(zzcud zzcud, String str, long j, zzdkx zzdkx, zzdkz zzdkz) {
        this.zzgnj = zzcud;
        this.zzgnf = str;
        this.zzgng = j;
        this.zzgnh = zzdkx;
        this.zzgni = zzdkz;
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void onSuccess(T t) {
        long elapsedRealtime = this.zzgnj.zzbpw.elapsedRealtime();
        this.zzgnj.zza(this.zzgnf, 0, elapsedRealtime - this.zzgng, this.zzgnh.zzhbd);
        if (this.zzgnj.zzgne) {
            this.zzgnj.zzgnc.zza(this.zzgni, this.zzgnh, 0, null, elapsedRealtime - this.zzgng);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    public final void zzb(Throwable th) {
        long elapsedRealtime = this.zzgnj.zzbpw.elapsedRealtime();
        int i = 6;
        if (th instanceof TimeoutException) {
            i = 2;
        } else if (th instanceof zzctt) {
            i = 3;
        } else if (th instanceof CancellationException) {
            i = 4;
        } else if (th instanceof zzdlr) {
            i = 5;
        } else if ((th instanceof zzcmt) && ((zzcmt) th).zzapd().errorCode == 3) {
            i = 1;
        }
        this.zzgnj.zza(this.zzgnf, i, elapsedRealtime - this.zzgng, this.zzgnh.zzhbd);
        if (this.zzgnj.zzgne) {
            this.zzgnj.zzgnc.zza(this.zzgni, this.zzgnh, i, th instanceof zzcri ? (zzcri) th : null, elapsedRealtime - this.zzgng);
        }
    }
}
