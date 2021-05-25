package com.avito.android.account;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SessionChangeTrackerImpl_Factory implements Factory<SessionChangeTrackerImpl> {
    public final Provider<Features> a;
    public final Provider<Analytics> b;

    public SessionChangeTrackerImpl_Factory(Provider<Features> provider, Provider<Analytics> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SessionChangeTrackerImpl_Factory create(Provider<Features> provider, Provider<Analytics> provider2) {
        return new SessionChangeTrackerImpl_Factory(provider, provider2);
    }

    public static SessionChangeTrackerImpl newInstance(Features features, Analytics analytics) {
        return new SessionChangeTrackerImpl(features, analytics);
    }

    @Override // javax.inject.Provider
    public SessionChangeTrackerImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
