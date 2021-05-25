package com.avito.android.in_app_calls.auth;

import com.avito.android.calls.CredentialsStorage;
import com.avito.android.calls.remote.CallsApi;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AvitoUsernameProvider_Factory implements Factory<AvitoUsernameProvider> {
    public final Provider<CallsApi> a;
    public final Provider<CredentialsStorage> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<ErrorTracker> d;

    public AvitoUsernameProvider_Factory(Provider<CallsApi> provider, Provider<CredentialsStorage> provider2, Provider<SchedulersFactory3> provider3, Provider<ErrorTracker> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static AvitoUsernameProvider_Factory create(Provider<CallsApi> provider, Provider<CredentialsStorage> provider2, Provider<SchedulersFactory3> provider3, Provider<ErrorTracker> provider4) {
        return new AvitoUsernameProvider_Factory(provider, provider2, provider3, provider4);
    }

    public static AvitoUsernameProvider newInstance(CallsApi callsApi, CredentialsStorage credentialsStorage, SchedulersFactory3 schedulersFactory3, ErrorTracker errorTracker) {
        return new AvitoUsernameProvider(callsApi, credentialsStorage, schedulersFactory3, errorTracker);
    }

    @Override // javax.inject.Provider
    public AvitoUsernameProvider get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
