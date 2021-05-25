package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
public final class zzajf {
    private final zzvh zzacs;
    private final zzwm zzact;
    private final Context zzvr;

    public zzajf(Context context, zzwm zzwm) {
        this(context, zzwm, zzvh.zzchm);
    }

    private final void zza(zzyo zzyo) {
        try {
            this.zzact.zzb(zzvh.zza(this.zzvr, zzyo));
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(AdRequest adRequest) {
        zza(adRequest.zzdp());
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        zza(publisherAdRequest.zzdp());
    }

    private zzajf(Context context, zzwm zzwm, zzvh zzvh) {
        this.zzvr = context;
        this.zzact = zzwm;
        this.zzacs = zzvh;
    }
}
