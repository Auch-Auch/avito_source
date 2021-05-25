package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;
import javax.annotation.concurrent.GuardedBy;
public final class zzcwm implements zzg {
    @GuardedBy("this")
    private zzg zzgpf;

    public final synchronized void zza(zzg zzg) {
        this.zzgpf = zzg;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final synchronized void zzh(View view) {
        zzg zzg = this.zzgpf;
        if (zzg != null) {
            zzg.zzh(view);
        }
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final synchronized void zzka() {
        zzg zzg = this.zzgpf;
        if (zzg != null) {
            zzg.zzka();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final synchronized void zzkb() {
        zzg zzg = this.zzgpf;
        if (zzg != null) {
            zzg.zzkb();
        }
    }
}
