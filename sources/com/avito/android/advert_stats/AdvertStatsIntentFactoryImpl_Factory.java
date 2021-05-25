package com.avito.android.advert_stats;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertStatsIntentFactoryImpl_Factory implements Factory<AdvertStatsIntentFactoryImpl> {
    public final Provider<Application> a;

    public AdvertStatsIntentFactoryImpl_Factory(Provider<Application> provider) {
        this.a = provider;
    }

    public static AdvertStatsIntentFactoryImpl_Factory create(Provider<Application> provider) {
        return new AdvertStatsIntentFactoryImpl_Factory(provider);
    }

    public static AdvertStatsIntentFactoryImpl newInstance(Application application) {
        return new AdvertStatsIntentFactoryImpl(application);
    }

    @Override // javax.inject.Provider
    public AdvertStatsIntentFactoryImpl get() {
        return newInstance(this.a.get());
    }
}
