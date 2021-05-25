package com.avito.android.di.module;

import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsFlushInteractor;
import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsTimer;
import com.avito.android.analytics.inhouse_transport.InHouseAnalyticsWatchDog;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AnalyticsTasksModule_ProvideInHouseAnalyticsWatchDogFactory implements Factory<InHouseAnalyticsWatchDog> {
    public final Provider<InHouseAnalyticsFlushInteractor> a;
    public final Provider<InHouseAnalyticsFlushInteractor> b;
    public final Provider<InHouseAnalyticsTimer> c;

    public AnalyticsTasksModule_ProvideInHouseAnalyticsWatchDogFactory(Provider<InHouseAnalyticsFlushInteractor> provider, Provider<InHouseAnalyticsFlushInteractor> provider2, Provider<InHouseAnalyticsTimer> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AnalyticsTasksModule_ProvideInHouseAnalyticsWatchDogFactory create(Provider<InHouseAnalyticsFlushInteractor> provider, Provider<InHouseAnalyticsFlushInteractor> provider2, Provider<InHouseAnalyticsTimer> provider3) {
        return new AnalyticsTasksModule_ProvideInHouseAnalyticsWatchDogFactory(provider, provider2, provider3);
    }

    public static InHouseAnalyticsWatchDog provideInHouseAnalyticsWatchDog(Lazy<InHouseAnalyticsFlushInteractor> lazy, Lazy<InHouseAnalyticsFlushInteractor> lazy2, Lazy<InHouseAnalyticsTimer> lazy3) {
        return (InHouseAnalyticsWatchDog) Preconditions.checkNotNullFromProvides(AnalyticsTasksModule.provideInHouseAnalyticsWatchDog(lazy, lazy2, lazy3));
    }

    @Override // javax.inject.Provider
    public InHouseAnalyticsWatchDog get() {
        return provideInHouseAnalyticsWatchDog(DoubleCheck.lazy(this.a), DoubleCheck.lazy(this.b), DoubleCheck.lazy(this.c));
    }
}
