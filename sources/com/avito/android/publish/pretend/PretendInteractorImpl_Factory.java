package com.avito.android.publish.pretend;

import com.avito.android.Features;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.validate_advert.remote.ValidateAdvertApi;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PretendInteractorImpl_Factory implements Factory<PretendInteractorImpl> {
    public final Provider<ValidateAdvertApi> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<CategoryParametersConverter> c;
    public final Provider<PublishAnalyticsDataProvider> d;
    public final Provider<Features> e;

    public PretendInteractorImpl_Factory(Provider<ValidateAdvertApi> provider, Provider<SchedulersFactory> provider2, Provider<CategoryParametersConverter> provider3, Provider<PublishAnalyticsDataProvider> provider4, Provider<Features> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static PretendInteractorImpl_Factory create(Provider<ValidateAdvertApi> provider, Provider<SchedulersFactory> provider2, Provider<CategoryParametersConverter> provider3, Provider<PublishAnalyticsDataProvider> provider4, Provider<Features> provider5) {
        return new PretendInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static PretendInteractorImpl newInstance(ValidateAdvertApi validateAdvertApi, SchedulersFactory schedulersFactory, CategoryParametersConverter categoryParametersConverter, PublishAnalyticsDataProvider publishAnalyticsDataProvider, Features features) {
        return new PretendInteractorImpl(validateAdvertApi, schedulersFactory, categoryParametersConverter, publishAnalyticsDataProvider, features);
    }

    @Override // javax.inject.Provider
    public PretendInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
