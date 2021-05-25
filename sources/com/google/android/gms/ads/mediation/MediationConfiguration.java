package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import com.google.android.gms.ads.AdFormat;
public class MediationConfiguration {
    private final Bundle zzeqc;
    private final AdFormat zzeqg;

    public MediationConfiguration(AdFormat adFormat, Bundle bundle) {
        this.zzeqg = adFormat;
        this.zzeqc = bundle;
    }

    public AdFormat getFormat() {
        return this.zzeqg;
    }

    public Bundle getServerParameters() {
        return this.zzeqc;
    }
}
