package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdSize;
import javax.annotation.ParametersAreNonnullByDefault;
@ParametersAreNonnullByDefault
public class MediationBannerAdConfiguration extends MediationAdConfiguration {
    private final AdSize zzdt;

    public MediationBannerAdConfiguration(Context context, String str, Bundle bundle, Bundle bundle2, boolean z, @Nullable Location location, int i, int i2, String str2, @Nullable AdSize adSize, String str3) {
        super(context, str, bundle, bundle2, z, location, i, i2, str2, str3);
        this.zzdt = adSize;
    }

    public AdSize getAdSize() {
        return this.zzdt;
    }
}
