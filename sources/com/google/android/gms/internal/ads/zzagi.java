package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
public final class zzagi extends zzafj {
    private final OnPublisherAdViewLoadedListener zzdds;

    public zzagi(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener) {
        this.zzdds = onPublisherAdViewLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final void zza(zzwu zzwu, IObjectWrapper iObjectWrapper) {
        if (zzwu != null && iObjectWrapper != null) {
            PublisherAdView publisherAdView = new PublisherAdView((Context) ObjectWrapper.unwrap(iObjectWrapper));
            AppEventListener appEventListener = null;
            try {
                if (zzwu.zzki() instanceof zzuy) {
                    zzuy zzuy = (zzuy) zzwu.zzki();
                    publisherAdView.setAdListener(zzuy != null ? zzuy.getAdListener() : null);
                }
            } catch (RemoteException e) {
                zzbbd.zzc("", e);
            }
            try {
                if (zzwu.zzkh() instanceof zzvn) {
                    zzvn zzvn = (zzvn) zzwu.zzkh();
                    if (zzvn != null) {
                        appEventListener = zzvn.getAppEventListener();
                    }
                    publisherAdView.setAppEventListener(appEventListener);
                }
            } catch (RemoteException e2) {
                zzbbd.zzc("", e2);
            }
            zzbat.zzaah.post(new zzagh(this, publisherAdView, zzwu));
        }
    }
}
