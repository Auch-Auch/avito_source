package com.avito.android.in_app_calls.analytics;

import android.content.Context;
import com.avito.android.analytics.Analytics;
import com.avito.android.calls_shared.tracker.events.CallEventTracker;
import com.avito.android.util.RandomKeyProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CallPushHandlingTrackerImpl_Factory implements Factory<CallPushHandlingTrackerImpl> {
    public final Provider<Analytics> a;
    public final Provider<RandomKeyProvider> b;
    public final Provider<CallEventTracker> c;
    public final Provider<Context> d;

    public CallPushHandlingTrackerImpl_Factory(Provider<Analytics> provider, Provider<RandomKeyProvider> provider2, Provider<CallEventTracker> provider3, Provider<Context> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static CallPushHandlingTrackerImpl_Factory create(Provider<Analytics> provider, Provider<RandomKeyProvider> provider2, Provider<CallEventTracker> provider3, Provider<Context> provider4) {
        return new CallPushHandlingTrackerImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static CallPushHandlingTrackerImpl newInstance(Analytics analytics, RandomKeyProvider randomKeyProvider, CallEventTracker callEventTracker, Context context) {
        return new CallPushHandlingTrackerImpl(analytics, randomKeyProvider, callEventTracker, context);
    }

    @Override // javax.inject.Provider
    public CallPushHandlingTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
