package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
public final class zzddg implements zzdek<Bundle> {
    private String zzdqg;

    public zzddg(String str) {
        this.zzdqg = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdek
    public final /* synthetic */ void zzs(Bundle bundle) {
        bundle.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, this.zzdqg);
    }
}
