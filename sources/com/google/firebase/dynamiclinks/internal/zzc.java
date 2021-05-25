package com.google.firebase.dynamiclinks.internal;

import a2.j.e.f.a.a;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.util.VisibleForTesting;
public final class zzc extends GoogleApi<Api.ApiOptions.NoOptions> {
    public static final Api.ClientKey<zzd> a;
    public static final Api.AbstractClientBuilder<zzd, Api.ApiOptions.NoOptions> b;
    public static final Api<Api.ApiOptions.NoOptions> c;

    static {
        Api.ClientKey<zzd> clientKey = new Api.ClientKey<>();
        a = clientKey;
        a aVar = new a();
        b = aVar;
        c = new Api<>("DynamicLinks.API", aVar, clientKey);
    }

    @VisibleForTesting
    public zzc(@NonNull Context context) {
        super(context, c, (Api.ApiOptions) null, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
