package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.PublisherAdView;
public final class zzagh implements Runnable {
    private final /* synthetic */ PublisherAdView zzddp;
    private final /* synthetic */ zzwu zzddq;
    private final /* synthetic */ zzagi zzddr;

    public zzagh(zzagi zzagi, PublisherAdView publisherAdView, zzwu zzwu) {
        this.zzddr = zzagi;
        this.zzddp = publisherAdView;
        this.zzddq = zzwu;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzddp.zza(this.zzddq)) {
            this.zzddr.zzdds.onPublisherAdViewLoaded(this.zzddp);
        } else {
            zzbbd.zzfe("Could not bind.");
        }
    }
}
