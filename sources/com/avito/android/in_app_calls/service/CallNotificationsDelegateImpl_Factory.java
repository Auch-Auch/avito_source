package com.avito.android.in_app_calls.service;

import android.app.Service;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.calls.analytics.CallAnalyticsTracker;
import com.avito.android.calls_shared.CallUuidProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CallNotificationsDelegateImpl_Factory implements Factory<CallNotificationsDelegateImpl> {
    public final Provider<Service> a;
    public final Provider<ActivityIntentFactory> b;
    public final Provider<SystemCallStateProvider> c;
    public final Provider<CallAnalyticsTracker> d;
    public final Provider<CallUuidProvider> e;
    public final Provider<Features> f;

    public CallNotificationsDelegateImpl_Factory(Provider<Service> provider, Provider<ActivityIntentFactory> provider2, Provider<SystemCallStateProvider> provider3, Provider<CallAnalyticsTracker> provider4, Provider<CallUuidProvider> provider5, Provider<Features> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static CallNotificationsDelegateImpl_Factory create(Provider<Service> provider, Provider<ActivityIntentFactory> provider2, Provider<SystemCallStateProvider> provider3, Provider<CallAnalyticsTracker> provider4, Provider<CallUuidProvider> provider5, Provider<Features> provider6) {
        return new CallNotificationsDelegateImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static CallNotificationsDelegateImpl newInstance(Service service, ActivityIntentFactory activityIntentFactory, SystemCallStateProvider systemCallStateProvider, CallAnalyticsTracker callAnalyticsTracker, CallUuidProvider callUuidProvider, Features features) {
        return new CallNotificationsDelegateImpl(service, activityIntentFactory, systemCallStateProvider, callAnalyticsTracker, callUuidProvider, features);
    }

    @Override // javax.inject.Provider
    public CallNotificationsDelegateImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}
