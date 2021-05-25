package com.avito.android.analytics.screens.fps;

import android.app.Application;
import com.avito.android.analytics.screens.fps.RefreshRateProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class RefreshRateProvider_Impl_Factory implements Factory<RefreshRateProvider.Impl> {
    public final Provider<Application> a;

    public RefreshRateProvider_Impl_Factory(Provider<Application> provider) {
        this.a = provider;
    }

    public static RefreshRateProvider_Impl_Factory create(Provider<Application> provider) {
        return new RefreshRateProvider_Impl_Factory(provider);
    }

    public static RefreshRateProvider.Impl newInstance(Application application) {
        return new RefreshRateProvider.Impl(application);
    }

    @Override // javax.inject.Provider
    public RefreshRateProvider.Impl get() {
        return newInstance(this.a.get());
    }
}
