package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
public final class zzaxh implements Runnable {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzbbq zzdxl;

    public zzaxh(zzaxe zzaxe, Context context, zzbbq zzbbq) {
        this.val$context = context;
        this.zzdxl = zzbbq;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzdxl.set(AdvertisingIdClient.getAdvertisingIdInfo(this.val$context));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            this.zzdxl.setException(e);
            zzbbd.zzc("Exception while getting advertising Id info", e);
        }
    }
}
