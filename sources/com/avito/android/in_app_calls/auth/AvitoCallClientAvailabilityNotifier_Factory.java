package com.avito.android.in_app_calls.auth;

import com.avito.android.Features;
import com.avito.android.calls.push.PushTokenRegistrationCallback;
import com.avito.android.calls.remote.CallsApi;
import com.avito.android.calls_shared.storage.CallStorage;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AvitoCallClientAvailabilityNotifier_Factory implements Factory<AvitoCallClientAvailabilityNotifier> {
    public final Provider<Features> a;
    public final Provider<CallsApi> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<ErrorTracker> d;
    public final Provider<PushTokenRegistrationCallback> e;
    public final Provider<CallStorage> f;

    public AvitoCallClientAvailabilityNotifier_Factory(Provider<Features> provider, Provider<CallsApi> provider2, Provider<SchedulersFactory3> provider3, Provider<ErrorTracker> provider4, Provider<PushTokenRegistrationCallback> provider5, Provider<CallStorage> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static AvitoCallClientAvailabilityNotifier_Factory create(Provider<Features> provider, Provider<CallsApi> provider2, Provider<SchedulersFactory3> provider3, Provider<ErrorTracker> provider4, Provider<PushTokenRegistrationCallback> provider5, Provider<CallStorage> provider6) {
        return new AvitoCallClientAvailabilityNotifier_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static AvitoCallClientAvailabilityNotifier newInstance(Features features, CallsApi callsApi, SchedulersFactory3 schedulersFactory3, ErrorTracker errorTracker, PushTokenRegistrationCallback pushTokenRegistrationCallback, CallStorage callStorage) {
        return new AvitoCallClientAvailabilityNotifier(features, callsApi, schedulersFactory3, errorTracker, pushTokenRegistrationCallback, callStorage);
    }

    @Override // javax.inject.Provider
    public AvitoCallClientAvailabilityNotifier get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
