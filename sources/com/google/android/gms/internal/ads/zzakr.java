package com.google.android.gms.internal.ads;
public final class zzakr implements Runnable {
    private final /* synthetic */ zzalb zzdgu;
    private final /* synthetic */ zzajx zzdgv;
    private final /* synthetic */ zzakk zzdgw;

    public zzakr(zzakk zzakk, zzalb zzalb, zzajx zzajx) {
        this.zzdgw = zzakk;
        this.zzdgu = zzalb;
        this.zzdgv = zzajx;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (zzakk.zza(this.zzdgw)) {
            if (this.zzdgu.getStatus() != -1) {
                if (this.zzdgu.getStatus() != 1) {
                    this.zzdgu.reject();
                    zzdvw zzdvw = zzbbi.zzedy;
                    zzajx zzajx = this.zzdgv;
                    zzajx.getClass();
                    zzdvw.execute(zzaku.zzb(zzajx));
                    zzaxy.zzei("Could not receive loaded message in a timely manner. Rejecting.");
                }
            }
        }
    }
}
