package com.avito.android.analytics.screens.tracker;

import com.avito.android.analytics.screens.ScreenTimeProvider;
import com.avito.android.analytics.screens.tracker.SessionResolver;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SessionResolver_Impl_Factory implements Factory<SessionResolver.Impl> {
    public final Provider<ScreenTimeProvider> a;

    public SessionResolver_Impl_Factory(Provider<ScreenTimeProvider> provider) {
        this.a = provider;
    }

    public static SessionResolver_Impl_Factory create(Provider<ScreenTimeProvider> provider) {
        return new SessionResolver_Impl_Factory(provider);
    }

    public static SessionResolver.Impl newInstance(ScreenTimeProvider screenTimeProvider) {
        return new SessionResolver.Impl(screenTimeProvider);
    }

    @Override // javax.inject.Provider
    public SessionResolver.Impl get() {
        return newInstance(this.a.get());
    }
}
