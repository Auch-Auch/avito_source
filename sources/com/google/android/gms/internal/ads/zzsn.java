package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.appopen.AppOpenAd;
public final class zzsn {
    @AppOpenAd.AppOpenAdOrientation
    private final int orientation;
    private final zzvh zzacs;
    private final zzyo zzacu;
    private zzwu zzbun;
    private final String zzbuo;
    private final AppOpenAd.AppOpenAdLoadCallback zzbup;
    private final zzamr zzbuq = new zzamr();
    private final Context zzvr;

    public zzsn(Context context, String str, zzyo zzyo, @AppOpenAd.AppOpenAdOrientation int i, AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.zzvr = context;
        this.zzbuo = str;
        this.zzacu = zzyo;
        this.orientation = i;
        this.zzbup = appOpenAdLoadCallback;
        this.zzacs = zzvh.zzchm;
    }

    public final void zzms() {
        try {
            this.zzbun = zzwe.zzpr().zza(this.zzvr, zzvj.zzpk(), this.zzbuo, this.zzbuq);
            this.zzbun.zza(new zzvm(this.orientation));
            this.zzbun.zza(new zzsb(this.zzbup));
            this.zzbun.zza(zzvh.zza(this.zzvr, this.zzacu));
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }
}
