package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
public final class zzaxz extends zzaxu {
    private Context zzvr;

    public zzaxz(Context context) {
        this.zzvr = context;
    }

    @Override // com.google.android.gms.internal.ads.zzaxu
    public final void zzuy() {
        boolean z;
        try {
            z = AdvertisingIdClient.getIsAdIdFakeForDebugLogging(this.zzvr);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            zzbbd.zzc("Fail to get isAdIdFakeForDebugLogging", e);
            z = false;
        }
        zzbax.zzar(z);
        StringBuilder sb = new StringBuilder(43);
        sb.append("Update ad debug logging enablement as ");
        sb.append(z);
        zzbbd.zzfe(sb.toString());
    }
}
