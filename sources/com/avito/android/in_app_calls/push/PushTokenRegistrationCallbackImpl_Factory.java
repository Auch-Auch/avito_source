package com.avito.android.in_app_calls.push;

import com.avito.android.calls.remote.CallsApi;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PushTokenRegistrationCallbackImpl_Factory implements Factory<PushTokenRegistrationCallbackImpl> {
    public final Provider<CallsApi> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<ErrorTracker> c;

    public PushTokenRegistrationCallbackImpl_Factory(Provider<CallsApi> provider, Provider<SchedulersFactory3> provider2, Provider<ErrorTracker> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static PushTokenRegistrationCallbackImpl_Factory create(Provider<CallsApi> provider, Provider<SchedulersFactory3> provider2, Provider<ErrorTracker> provider3) {
        return new PushTokenRegistrationCallbackImpl_Factory(provider, provider2, provider3);
    }

    public static PushTokenRegistrationCallbackImpl newInstance(CallsApi callsApi, SchedulersFactory3 schedulersFactory3, ErrorTracker errorTracker) {
        return new PushTokenRegistrationCallbackImpl(callsApi, schedulersFactory3, errorTracker);
    }

    @Override // javax.inject.Provider
    public PushTokenRegistrationCallbackImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
