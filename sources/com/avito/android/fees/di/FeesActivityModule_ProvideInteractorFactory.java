package com.avito.android.fees.di;

import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.fees.FeesInteractor;
import com.avito.android.fees.remote.FeesApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FeesActivityModule_ProvideInteractorFactory implements Factory<FeesInteractor> {
    public final FeesActivityModule a;
    public final Provider<FeesApi> b;
    public final Provider<PublishAnalyticsDataProvider> c;

    public FeesActivityModule_ProvideInteractorFactory(FeesActivityModule feesActivityModule, Provider<FeesApi> provider, Provider<PublishAnalyticsDataProvider> provider2) {
        this.a = feesActivityModule;
        this.b = provider;
        this.c = provider2;
    }

    public static FeesActivityModule_ProvideInteractorFactory create(FeesActivityModule feesActivityModule, Provider<FeesApi> provider, Provider<PublishAnalyticsDataProvider> provider2) {
        return new FeesActivityModule_ProvideInteractorFactory(feesActivityModule, provider, provider2);
    }

    public static FeesInteractor provideInteractor(FeesActivityModule feesActivityModule, FeesApi feesApi, PublishAnalyticsDataProvider publishAnalyticsDataProvider) {
        return (FeesInteractor) Preconditions.checkNotNullFromProvides(feesActivityModule.provideInteractor(feesApi, publishAnalyticsDataProvider));
    }

    @Override // javax.inject.Provider
    public FeesInteractor get() {
        return provideInteractor(this.a, this.b.get(), this.c.get());
    }
}
