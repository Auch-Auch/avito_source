package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zztw;
import javax.annotation.ParametersAreNonnullByDefault;
public final class zzcbf implements zzbsu, zzbyh {
    @Nullable
    private final View view;
    private final zzawb zzbqm;
    private final zzavy zzfpr;
    private final zztw.zza.EnumC0204zza zzfvf;
    private String zzfvh;
    private final Context zzvr;

    public zzcbf(zzavy zzavy, Context context, zzawb zzawb, @Nullable View view2, zztw.zza.EnumC0204zza zza) {
        this.zzfpr = zzavy;
        this.zzvr = context;
        this.zzbqm = zzawb;
        this.view = view2;
        this.zzfvf = zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onAdClosed() {
        this.zzfpr.zzam(false);
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onAdOpened() {
        View view2 = this.view;
        if (!(view2 == null || this.zzfvh == null)) {
            this.zzbqm.zzh(view2.getContext(), this.zzfvh);
        }
        this.zzfpr.zzam(true);
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onRewardedVideoCompleted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onRewardedVideoStarted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbyh
    public final void zzaix() {
    }

    @Override // com.google.android.gms.internal.ads.zzbyh
    public final void zzaiz() {
        String zzae = this.zzbqm.zzae(this.zzvr);
        this.zzfvh = zzae;
        String valueOf = String.valueOf(zzae);
        String str = this.zzfvf == zztw.zza.EnumC0204zza.REWARD_BASED_VIDEO_AD ? "/Rewarded" : "/Interstitial";
        this.zzfvh = str.length() != 0 ? valueOf.concat(str) : new String(valueOf);
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    @ParametersAreNonnullByDefault
    public final void zzb(zzatj zzatj, String str, String str2) {
        if (this.zzbqm.zzac(this.zzvr)) {
            try {
                zzawb zzawb = this.zzbqm;
                Context context = this.zzvr;
                zzawb.zza(context, zzawb.zzah(context), this.zzfpr.getAdUnitId(), zzatj.getType(), zzatj.getAmount());
            } catch (RemoteException e) {
                zzbbd.zzd("Remote Exception to get reward item.", e);
            }
        }
    }
}
