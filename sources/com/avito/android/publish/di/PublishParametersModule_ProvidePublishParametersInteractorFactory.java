package com.avito.android.publish.di;

import com.avito.android.Features;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.photo_picker.legacy.api.UploadConverter;
import com.avito.android.publish.PublishParametersInteractor;
import com.avito.android.publish.drafts.PublishDraftRepository;
import com.avito.android.publish.drafts.PublishDraftWiper;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.model.category_parameters.AttributesTreeConverter;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishParametersModule_ProvidePublishParametersInteractorFactory implements Factory<PublishParametersInteractor> {
    public final PublishParametersModule a;
    public final Provider<PublishApi> b;
    public final Provider<PublishAnalyticsDataProvider> c;
    public final Provider<PublishDraftRepository> d;
    public final Provider<UploadConverter> e;
    public final Provider<CategoryParametersConverter> f;
    public final Provider<AttributesTreeConverter> g;
    public final Provider<PublishDraftWiper> h;
    public final Provider<Features> i;

    public PublishParametersModule_ProvidePublishParametersInteractorFactory(PublishParametersModule publishParametersModule, Provider<PublishApi> provider, Provider<PublishAnalyticsDataProvider> provider2, Provider<PublishDraftRepository> provider3, Provider<UploadConverter> provider4, Provider<CategoryParametersConverter> provider5, Provider<AttributesTreeConverter> provider6, Provider<PublishDraftWiper> provider7, Provider<Features> provider8) {
        this.a = publishParametersModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
        this.i = provider8;
    }

    public static PublishParametersModule_ProvidePublishParametersInteractorFactory create(PublishParametersModule publishParametersModule, Provider<PublishApi> provider, Provider<PublishAnalyticsDataProvider> provider2, Provider<PublishDraftRepository> provider3, Provider<UploadConverter> provider4, Provider<CategoryParametersConverter> provider5, Provider<AttributesTreeConverter> provider6, Provider<PublishDraftWiper> provider7, Provider<Features> provider8) {
        return new PublishParametersModule_ProvidePublishParametersInteractorFactory(publishParametersModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static PublishParametersInteractor providePublishParametersInteractor(PublishParametersModule publishParametersModule, PublishApi publishApi, PublishAnalyticsDataProvider publishAnalyticsDataProvider, PublishDraftRepository publishDraftRepository, UploadConverter uploadConverter, CategoryParametersConverter categoryParametersConverter, AttributesTreeConverter attributesTreeConverter, PublishDraftWiper publishDraftWiper, Features features) {
        return (PublishParametersInteractor) Preconditions.checkNotNullFromProvides(publishParametersModule.providePublishParametersInteractor(publishApi, publishAnalyticsDataProvider, publishDraftRepository, uploadConverter, categoryParametersConverter, attributesTreeConverter, publishDraftWiper, features));
    }

    @Override // javax.inject.Provider
    public PublishParametersInteractor get() {
        return providePublishParametersInteractor(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get());
    }
}
