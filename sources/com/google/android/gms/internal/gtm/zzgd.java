package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
import android.os.Bundle;
public final class zzgd implements Runnable {
    private boolean zzaqc = false;
    private final /* synthetic */ String zzaqd;
    private final /* synthetic */ Bundle zzaqe;
    private final /* synthetic */ String zzaqf;
    private final /* synthetic */ long zzaqg;
    private final /* synthetic */ String zzaqh;
    private final /* synthetic */ zzgc zzaqj;

    public zzgd(zzgc zzgc, String str, Bundle bundle, String str2, long j, String str3) {
        this.zzaqj = zzgc;
        this.zzaqd = str;
        this.zzaqe = bundle;
        this.zzaqf = str2;
        this.zzaqg = j;
        this.zzaqh = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzaqj.zzaqb.zzapx == 3) {
            this.zzaqj.zzaqb.zzaps.zza(this.zzaqd, this.zzaqe, this.zzaqf, this.zzaqg, false);
        } else if (this.zzaqj.zzaqb.zzapx == 1 || this.zzaqj.zzaqb.zzapx == 2) {
            if (!this.zzaqc) {
                zzev.zzab(String.format("Container not loaded yet: deferring event listener by enqueuing the event: name = %s, origin = %s, params = %s.", this.zzaqd, this.zzaqh, this.zzaqe));
                this.zzaqc = true;
                this.zzaqj.zzaqb.zzapy.add(this);
                return;
            }
            zzev.zzac("Invalid state - not expecting to see a deferred event during container loading.");
        } else if (this.zzaqj.zzaqb.zzapx == 4) {
            zzev.zzab(String.format("Container failed to load: skipping event listener by ignoring the event: name = %s, origin = %s, params = %s.", this.zzaqd, this.zzaqh, this.zzaqe));
        } else {
            zzea.zzb(a.m2(28, "Unexpected state:", this.zzaqj.zzaqb.zzapx), this.zzaqj.zzaqb.zzrm);
        }
    }
}
