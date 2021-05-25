package com.avito.android.in_app_calls.auth;

import com.avito.android.calls.remote.CallsApi;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AvitoOneTimeLoginCredentialsProvider_Factory implements Factory<AvitoOneTimeLoginCredentialsProvider> {
    public final Provider<CallsApi> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<ErrorTracker> c;

    public AvitoOneTimeLoginCredentialsProvider_Factory(Provider<CallsApi> provider, Provider<SchedulersFactory3> provider2, Provider<ErrorTracker> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AvitoOneTimeLoginCredentialsProvider_Factory create(Provider<CallsApi> provider, Provider<SchedulersFactory3> provider2, Provider<ErrorTracker> provider3) {
        return new AvitoOneTimeLoginCredentialsProvider_Factory(provider, provider2, provider3);
    }

    public static AvitoOneTimeLoginCredentialsProvider newInstance(CallsApi callsApi, SchedulersFactory3 schedulersFactory3, ErrorTracker errorTracker) {
        return new AvitoOneTimeLoginCredentialsProvider(callsApi, schedulersFactory3, errorTracker);
    }

    @Override // javax.inject.Provider
    public AvitoOneTimeLoginCredentialsProvider get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
