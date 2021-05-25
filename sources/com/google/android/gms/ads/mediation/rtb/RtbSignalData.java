package com.google.android.gms.ads.mediation.rtb;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import java.util.List;
public class RtbSignalData {
    private final Bundle zzchc;
    @Nullable
    private final AdSize zzdt;
    private final List<MediationConfiguration> zzerk;
    private final Context zzvr;

    public RtbSignalData(Context context, List<MediationConfiguration> list, Bundle bundle, @Nullable AdSize adSize) {
        this.zzvr = context;
        this.zzerk = list;
        this.zzchc = bundle;
        this.zzdt = adSize;
    }

    @Nullable
    public AdSize getAdSize() {
        return this.zzdt;
    }

    @Deprecated
    public MediationConfiguration getConfiguration() {
        List<MediationConfiguration> list = this.zzerk;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.zzerk.get(0);
    }

    public List<MediationConfiguration> getConfigurations() {
        return this.zzerk;
    }

    public Context getContext() {
        return this.zzvr;
    }

    public Bundle getNetworkExtras() {
        return this.zzchc;
    }
}
