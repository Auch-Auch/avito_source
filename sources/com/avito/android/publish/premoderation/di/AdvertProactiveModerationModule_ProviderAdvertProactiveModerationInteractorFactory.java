package com.avito.android.publish.premoderation.di;

import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.publish.premoderation.AdvertProactiveModerationInteractor;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AdvertProactiveModerationModule_ProviderAdvertProactiveModerationInteractorFactory implements Factory<AdvertProactiveModerationInteractor> {
    public final AdvertProactiveModerationModule a;
    public final Provider<PublishApi> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<CategoryParametersConverter> d;
    public final Provider<PublishAnalyticsDataProvider> e;

    public AdvertProactiveModerationModule_ProviderAdvertProactiveModerationInteractorFactory(AdvertProactiveModerationModule advertProactiveModerationModule, Provider<PublishApi> provider, Provider<SchedulersFactory> provider2, Provider<CategoryParametersConverter> provider3, Provider<PublishAnalyticsDataProvider> provider4) {
        this.a = advertProactiveModerationModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    public static AdvertProactiveModerationModule_ProviderAdvertProactiveModerationInteractorFactory create(AdvertProactiveModerationModule advertProactiveModerationModule, Provider<PublishApi> provider, Provider<SchedulersFactory> provider2, Provider<CategoryParametersConverter> provider3, Provider<PublishAnalyticsDataProvider> provider4) {
        return new AdvertProactiveModerationModule_ProviderAdvertProactiveModerationInteractorFactory(advertProactiveModerationModule, provider, provider2, provider3, provider4);
    }

    public static AdvertProactiveModerationInteractor providerAdvertProactiveModerationInteractor(AdvertProactiveModerationModule advertProactiveModerationModule, PublishApi publishApi, SchedulersFactory schedulersFactory, CategoryParametersConverter categoryParametersConverter, PublishAnalyticsDataProvider publishAnalyticsDataProvider) {
        return (AdvertProactiveModerationInteractor) Preconditions.checkNotNullFromProvides(advertProactiveModerationModule.providerAdvertProactiveModerationInteractor(publishApi, schedulersFactory, categoryParametersConverter, publishAnalyticsDataProvider));
    }

    @Override // javax.inject.Provider
    public AdvertProactiveModerationInteractor get() {
        return providerAdvertProactiveModerationInteractor(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
