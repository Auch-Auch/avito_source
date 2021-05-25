package com.google.android.gms.ads.query;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzarh;
import com.google.android.gms.internal.ads.zzyo;
import com.google.android.gms.internal.ads.zzzb;
@KeepForSdk
public class QueryInfo {
    private final zzzb zzhih;

    public QueryInfo(zzzb zzzb) {
        this.zzhih = zzzb;
    }

    @KeepForSdk
    public static void generate(Context context, AdFormat adFormat, @Nullable AdRequest adRequest, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzyo zzyo;
        if (adRequest == null) {
            zzyo = null;
        } else {
            zzyo = adRequest.zzdp();
        }
        new zzarh(context, adFormat, zzyo).zza(queryInfoGenerationCallback);
    }

    @KeepForSdk
    public String getQuery() {
        return this.zzhih.getQuery();
    }

    @KeepForSdk
    public Bundle getQueryBundle() {
        return this.zzhih.getQueryBundle();
    }

    @KeepForSdk
    public String getRequestId() {
        return zzzb.zza(this);
    }
}
