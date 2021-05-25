package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;
import java.util.concurrent.atomic.AtomicBoolean;
public final class zzcvz implements zzg {
    private final zzbyw zzfoe;
    private final zzbtl zzfvu;
    private final zzbst zzfvv;
    private final zzbma zzfvw;
    private final zzbyr zzfvy;
    private AtomicBoolean zzgou = new AtomicBoolean(false);

    public zzcvz(zzbst zzbst, zzbtl zzbtl, zzbyw zzbyw, zzbyr zzbyr, zzbma zzbma) {
        this.zzfvv = zzbst;
        this.zzfvu = zzbtl;
        this.zzfoe = zzbyw;
        this.zzfvy = zzbyr;
        this.zzfvw = zzbma;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final synchronized void zzh(View view) {
        if (this.zzgou.compareAndSet(false, true)) {
            this.zzfvw.onAdImpression();
            this.zzfvy.zzv(view);
        }
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzka() {
        if (this.zzgou.get()) {
            this.zzfvv.onAdClicked();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzkb() {
        if (this.zzgou.get()) {
            this.zzfvu.onAdImpression();
            this.zzfoe.zzaki();
        }
    }
}
