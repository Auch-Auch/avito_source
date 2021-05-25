package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
public final class zzapm implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {
    private final /* synthetic */ zzana zzdlp;
    private final /* synthetic */ zzapf zzdlq;
    private final /* synthetic */ zzaov zzdlv;

    public zzapm(zzapf zzapf, zzaov zzaov, zzana zzana) {
        this.zzdlq = zzapf;
        this.zzdlv = zzaov;
        this.zzdlp = zzana;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final MediationRewardedAdCallback onSuccess(MediationRewardedAd mediationRewardedAd) {
        if (mediationRewardedAd == null) {
            zzbbd.zzfe("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zzdlv.zzdq("Adapter returned null.");
                return null;
            } catch (RemoteException e) {
                zzbbd.zzc("", e);
                return null;
            }
        } else {
            try {
                this.zzdlq.zzdkr = mediationRewardedAd;
                this.zzdlv.zzuh();
            } catch (RemoteException e2) {
                zzbbd.zzc("", e2);
            }
            return new zzapl(this.zzdlp);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        try {
            this.zzdlv.zzdq(str);
        } catch (RemoteException e) {
            zzbbd.zzc("", e);
        }
    }
}
