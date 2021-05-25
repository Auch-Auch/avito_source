package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
public final class zzceu implements zzcdd {
    private final zzbbg zzbpa;
    private final zzdkx zzfpf;
    private final zzdln zzfqn;
    private final zzbtl zzfvu;
    private final zzbst zzfvv;
    private boolean zzfvz = false;
    private boolean zzfwc = false;
    @Nullable
    private final zzand zzgaq;
    @Nullable
    private final zzani zzgar;
    @Nullable
    private final zzanj zzgas;
    private final Context zzvr;

    public zzceu(@Nullable zzand zzand, @Nullable zzani zzani, @Nullable zzanj zzanj, zzbtl zzbtl, zzbst zzbst, Context context, zzdkx zzdkx, zzbbg zzbbg, zzdln zzdln) {
        this.zzgaq = zzand;
        this.zzgar = zzani;
        this.zzgas = zzanj;
        this.zzfvu = zzbtl;
        this.zzfvv = zzbst;
        this.zzvr = context;
        this.zzfpf = zzdkx;
        this.zzbpa = zzbbg;
        this.zzfqn = zzdln;
    }

    private final void zzad(View view) {
        try {
            zzanj zzanj = this.zzgas;
            if (zzanj == null || zzanj.getOverrideClickHandling()) {
                zzand zzand = this.zzgaq;
                if (zzand == null || zzand.getOverrideClickHandling()) {
                    zzani zzani = this.zzgar;
                    if (zzani != null && !zzani.getOverrideClickHandling()) {
                        this.zzgar.zzu(ObjectWrapper.wrap(view));
                        this.zzfvv.onAdClicked();
                        return;
                    }
                    return;
                }
                this.zzgaq.zzu(ObjectWrapper.wrap(view));
                this.zzfvv.onAdClicked();
                return;
            }
            this.zzgas.zzu(ObjectWrapper.wrap(view));
            this.zzfvv.onAdClicked();
        } catch (RemoteException e) {
            zzbbd.zzd("Failed to call handleClick", e);
        }
    }

    private static HashMap<String, View> zzb(Map<String, WeakReference<View>> map) {
        HashMap<String, View> hashMap = new HashMap<>();
        if (map == null) {
            return hashMap;
        }
        synchronized (map) {
            for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                View view = entry.getValue().get();
                if (view != null) {
                    hashMap.put(entry.getKey(), view);
                }
            }
        }
        return hashMap;
    }

    @Override // com.google.android.gms.internal.ads.zzcdd
    public final void cancelUnconfirmedClick() {
    }

    @Override // com.google.android.gms.internal.ads.zzcdd
    public final void destroy() {
    }

    @Override // com.google.android.gms.internal.ads.zzcdd
    public final boolean isCustomClickGestureEnabled() {
        return this.zzfpf.zzdjh;
    }

    @Override // com.google.android.gms.internal.ads.zzcdd
    public final void setClickConfirmingView(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzcdd
    public final void zza(View view, MotionEvent motionEvent, @Nullable View view2) {
    }

    @Override // com.google.android.gms.internal.ads.zzcdd
    public final void zza(View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            HashMap<String, View> zzb = zzb(map);
            HashMap<String, View> zzb2 = zzb(map2);
            zzanj zzanj = this.zzgas;
            if (zzanj != null) {
                zzanj.zzc(wrap, ObjectWrapper.wrap(zzb), ObjectWrapper.wrap(zzb2));
                return;
            }
            zzand zzand = this.zzgaq;
            if (zzand != null) {
                zzand.zzc(wrap, ObjectWrapper.wrap(zzb), ObjectWrapper.wrap(zzb2));
                this.zzgaq.zzv(wrap);
                return;
            }
            zzani zzani = this.zzgar;
            if (zzani != null) {
                zzani.zzc(wrap, ObjectWrapper.wrap(zzb), ObjectWrapper.wrap(zzb2));
                this.zzgar.zzv(wrap);
            }
        } catch (RemoteException e) {
            zzbbd.zzd("Failed to call trackView", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdd
    public final void zza(zzafr zzafr) {
    }

    @Override // com.google.android.gms.internal.ads.zzcdd
    public final void zzalc() {
    }

    @Override // com.google.android.gms.internal.ads.zzcdd
    public final void zzald() {
        zzbbd.zzfe("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzcdd
    public final void zzale() {
    }

    @Override // com.google.android.gms.internal.ads.zzcdd
    public final void zzfz(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzcdd
    public final void zzg(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzcdd
    public final void zzh(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzcdd
    public final boolean zzi(Bundle bundle) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcdd
    public final void zzsr() {
        this.zzfwc = true;
    }

    @Override // com.google.android.gms.internal.ads.zzcdd
    public final void zza(View view, @Nullable Map<String, WeakReference<View>> map) {
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            zzanj zzanj = this.zzgas;
            if (zzanj != null) {
                zzanj.zzw(wrap);
                return;
            }
            zzand zzand = this.zzgaq;
            if (zzand != null) {
                zzand.zzw(wrap);
                return;
            }
            zzani zzani = this.zzgar;
            if (zzani != null) {
                zzani.zzw(wrap);
            }
        } catch (RemoteException e) {
            zzbbd.zzd("Failed to call untrackView", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdd
    public final void zza(View view, @Nullable View view2, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.zzfwc || !this.zzfpf.zzdjh) {
            zzad(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdd
    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.zzfwc) {
            zzbbd.zzfe("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (!this.zzfpf.zzdjh) {
            zzbbd.zzfe("Custom click reporting for 3p ads failed. Ad unit id not whitelisted.");
        } else {
            zzad(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdd
    public final void zza(@Nullable View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2) {
        try {
            boolean z = this.zzfvz;
            if (!z && this.zzfpf.zzhat != null) {
                this.zzfvz = z | zzp.zzkz().zzb(this.zzvr, this.zzbpa.zzbra, this.zzfpf.zzhat.toString(), this.zzfqn.zzhbv);
            }
            zzanj zzanj = this.zzgas;
            if (zzanj == null || zzanj.getOverrideImpressionRecording()) {
                zzand zzand = this.zzgaq;
                if (zzand == null || zzand.getOverrideImpressionRecording()) {
                    zzani zzani = this.zzgar;
                    if (zzani != null && !zzani.getOverrideImpressionRecording()) {
                        this.zzgar.recordImpression();
                        this.zzfvu.onAdImpression();
                        return;
                    }
                    return;
                }
                this.zzgaq.recordImpression();
                this.zzfvu.onAdImpression();
                return;
            }
            this.zzgas.recordImpression();
            this.zzfvu.onAdImpression();
        } catch (RemoteException e) {
            zzbbd.zzd("Failed to call recordImpression", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdd
    public final void zza(@Nullable zzxv zzxv) {
        zzbbd.zzfe("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzcdd
    public final void zza(zzxr zzxr) {
        zzbbd.zzfe("Mute This Ad is not supported for 3rd party ads");
    }
}
