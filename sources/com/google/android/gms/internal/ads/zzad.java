package com.google.android.gms.internal.ads;
public final class zzad implements Runnable {
    private final /* synthetic */ String zzbd;
    private final /* synthetic */ long zzbe;
    private final /* synthetic */ zzaa zzbf;

    public zzad(zzaa zzaa, String str, long j) {
        this.zzbf = zzaa;
        this.zzbd = str;
        this.zzbe = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaa.zzd(this.zzbf).zza(this.zzbd, this.zzbe);
        zzaa.zzd(this.zzbf).zzd(this.zzbf.toString());
    }
}
