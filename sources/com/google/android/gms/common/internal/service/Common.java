package com.google.android.gms.common.internal.service;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
public final class Common {
    @RecentlyNonNull
    @KeepForSdk
    public static final Api<Api.ApiOptions.NoOptions> API;
    @RecentlyNonNull
    @KeepForSdk
    public static final Api.ClientKey<zaj> CLIENT_KEY;
    public static final zad zaa = new zac();
    private static final Api.AbstractClientBuilder<zaj, Api.ApiOptions.NoOptions> zab;

    static {
        Api.ClientKey<zaj> clientKey = new Api.ClientKey<>();
        CLIENT_KEY = clientKey;
        zab zab2 = new zab();
        zab = zab2;
        API = new Api<>("Common.API", zab2, clientKey);
    }
}
