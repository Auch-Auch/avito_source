package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzt;
public final class zzchh implements zzo, zzt, zzagl, zzagn, zzut {
    private zzut zzcgq;
    private zzagl zzddv;
    private zzagn zzddw;
    private zzo zzdor;
    private zzt zzdov;

    private zzchh() {
    }

    @Override // com.google.android.gms.internal.ads.zzut
    public final synchronized void onAdClicked() {
        zzut zzut = this.zzcgq;
        if (zzut != null) {
            zzut.onAdClicked();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzagn
    public final synchronized void onAppEvent(String str, @Nullable String str2) {
        zzagn zzagn = this.zzddw;
        if (zzagn != null) {
            zzagn.onAppEvent(str, str2);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void onPause() {
        zzo zzo = this.zzdor;
        if (zzo != null) {
            zzo.onPause();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void onResume() {
        zzo zzo = this.zzdor;
        if (zzo != null) {
            zzo.onResume();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzagl
    public final synchronized void zza(String str, Bundle bundle) {
        zzagl zzagl = this.zzddv;
        if (zzagl != null) {
            zzagl.zza(str, bundle);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void zzui() {
        zzo zzo = this.zzdor;
        if (zzo != null) {
            zzo.zzui();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void zzuj() {
        zzo zzo = this.zzdor;
        if (zzo != null) {
            zzo.zzuj();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzt
    public final synchronized void zzuz() {
        zzt zzt = this.zzdov;
        if (zzt != null) {
            zzt.zzuz();
        }
    }

    public /* synthetic */ zzchh(zzchd zzchd) {
        this();
    }

    /* access modifiers changed from: public */
    private final synchronized void zza(zzut zzut, zzagl zzagl, zzo zzo, zzagn zzagn, zzt zzt) {
        this.zzcgq = zzut;
        this.zzddv = zzagl;
        this.zzdor = zzo;
        this.zzddw = zzagn;
        this.zzdov = zzt;
    }
}
