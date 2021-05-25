package com.avito.android.in_app_calls;

import android.app.Application;
import com.avito.android.calls.analytics.CallAnalyticsTracker;
import com.avito.android.calls_shared.tracker.events.CallEventTracker;
import com.avito.android.service.SafeServiceStarter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class IncomingCallHandler_Factory implements Factory<IncomingCallHandler> {
    public final Provider<Application> a;
    public final Provider<CallRegistry> b;
    public final Provider<CallAnalyticsTracker> c;
    public final Provider<SafeServiceStarter> d;
    public final Provider<CallEventTracker> e;

    public IncomingCallHandler_Factory(Provider<Application> provider, Provider<CallRegistry> provider2, Provider<CallAnalyticsTracker> provider3, Provider<SafeServiceStarter> provider4, Provider<CallEventTracker> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static IncomingCallHandler_Factory create(Provider<Application> provider, Provider<CallRegistry> provider2, Provider<CallAnalyticsTracker> provider3, Provider<SafeServiceStarter> provider4, Provider<CallEventTracker> provider5) {
        return new IncomingCallHandler_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static IncomingCallHandler newInstance(Application application, CallRegistry callRegistry, CallAnalyticsTracker callAnalyticsTracker, SafeServiceStarter safeServiceStarter, CallEventTracker callEventTracker) {
        return new IncomingCallHandler(application, callRegistry, callAnalyticsTracker, safeServiceStarter, callEventTracker);
    }

    @Override // javax.inject.Provider
    public IncomingCallHandler get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
