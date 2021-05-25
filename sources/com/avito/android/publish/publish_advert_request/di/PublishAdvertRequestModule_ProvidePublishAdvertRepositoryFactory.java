package com.avito.android.publish.publish_advert_request.di;

import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.publish.publish_advert_request.data.PublishAdvertDataSource;
import com.avito.android.publish.publish_advert_request.data.PublishAdvertRepository;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishAdvertRequestModule_ProvidePublishAdvertRepositoryFactory implements Factory<PublishAdvertRepository> {
    public final PublishAdvertRequestModule a;
    public final Provider<PublishAdvertDataSource> b;
    public final Provider<PublishAnalyticsDataProvider> c;
    public final Provider<CategoryParametersConverter> d;
    public final Provider<TypedErrorThrowableConverter> e;

    public PublishAdvertRequestModule_ProvidePublishAdvertRepositoryFactory(PublishAdvertRequestModule publishAdvertRequestModule, Provider<PublishAdvertDataSource> provider, Provider<PublishAnalyticsDataProvider> provider2, Provider<CategoryParametersConverter> provider3, Provider<TypedErrorThrowableConverter> provider4) {
        this.a = publishAdvertRequestModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    public static PublishAdvertRequestModule_ProvidePublishAdvertRepositoryFactory create(PublishAdvertRequestModule publishAdvertRequestModule, Provider<PublishAdvertDataSource> provider, Provider<PublishAnalyticsDataProvider> provider2, Provider<CategoryParametersConverter> provider3, Provider<TypedErrorThrowableConverter> provider4) {
        return new PublishAdvertRequestModule_ProvidePublishAdvertRepositoryFactory(publishAdvertRequestModule, provider, provider2, provider3, provider4);
    }

    public static PublishAdvertRepository providePublishAdvertRepository(PublishAdvertRequestModule publishAdvertRequestModule, PublishAdvertDataSource publishAdvertDataSource, PublishAnalyticsDataProvider publishAnalyticsDataProvider, CategoryParametersConverter categoryParametersConverter, TypedErrorThrowableConverter typedErrorThrowableConverter) {
        return (PublishAdvertRepository) Preconditions.checkNotNullFromProvides(publishAdvertRequestModule.providePublishAdvertRepository(publishAdvertDataSource, publishAnalyticsDataProvider, categoryParametersConverter, typedErrorThrowableConverter));
    }

    @Override // javax.inject.Provider
    public PublishAdvertRepository get() {
        return providePublishAdvertRepository(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
