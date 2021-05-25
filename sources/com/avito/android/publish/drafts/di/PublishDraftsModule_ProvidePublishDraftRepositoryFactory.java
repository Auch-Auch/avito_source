package com.avito.android.publish.drafts.di;

import android.app.Application;
import com.avito.android.app.work.PublishDraftsSyncWorkFactory;
import com.avito.android.publish.drafts.PublishDraftRepository;
import com.avito.android.remote.DeviceIdProvider;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.model.category_parameters.AttributesTreeConverter;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.preferences.PreferenceFactory;
import com.google.gson.Gson;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDraftsModule_ProvidePublishDraftRepositoryFactory implements Factory<PublishDraftRepository> {
    public final Provider<Application> a;
    public final Provider<BuildInfo> b;
    public final Provider<PreferenceFactory> c;
    public final Provider<Gson> d;
    public final Provider<PublishApi> e;
    public final Provider<CategoryParametersConverter> f;
    public final Provider<AttributesTreeConverter> g;
    public final Provider<PublishDraftsSyncWorkFactory> h;
    public final Provider<DeviceIdProvider> i;
    public final Provider<SchedulersFactory> j;
    public final Provider<PublishRelay<String>> k;

    public PublishDraftsModule_ProvidePublishDraftRepositoryFactory(Provider<Application> provider, Provider<BuildInfo> provider2, Provider<PreferenceFactory> provider3, Provider<Gson> provider4, Provider<PublishApi> provider5, Provider<CategoryParametersConverter> provider6, Provider<AttributesTreeConverter> provider7, Provider<PublishDraftsSyncWorkFactory> provider8, Provider<DeviceIdProvider> provider9, Provider<SchedulersFactory> provider10, Provider<PublishRelay<String>> provider11) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
        this.k = provider11;
    }

    public static PublishDraftsModule_ProvidePublishDraftRepositoryFactory create(Provider<Application> provider, Provider<BuildInfo> provider2, Provider<PreferenceFactory> provider3, Provider<Gson> provider4, Provider<PublishApi> provider5, Provider<CategoryParametersConverter> provider6, Provider<AttributesTreeConverter> provider7, Provider<PublishDraftsSyncWorkFactory> provider8, Provider<DeviceIdProvider> provider9, Provider<SchedulersFactory> provider10, Provider<PublishRelay<String>> provider11) {
        return new PublishDraftsModule_ProvidePublishDraftRepositoryFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static PublishDraftRepository providePublishDraftRepository(Application application, BuildInfo buildInfo, PreferenceFactory preferenceFactory, Gson gson, PublishApi publishApi, CategoryParametersConverter categoryParametersConverter, AttributesTreeConverter attributesTreeConverter, PublishDraftsSyncWorkFactory publishDraftsSyncWorkFactory, DeviceIdProvider deviceIdProvider, SchedulersFactory schedulersFactory, PublishRelay<String> publishRelay) {
        return (PublishDraftRepository) Preconditions.checkNotNullFromProvides(PublishDraftsModule.providePublishDraftRepository(application, buildInfo, preferenceFactory, gson, publishApi, categoryParametersConverter, attributesTreeConverter, publishDraftsSyncWorkFactory, deviceIdProvider, schedulersFactory, publishRelay));
    }

    @Override // javax.inject.Provider
    public PublishDraftRepository get() {
        return providePublishDraftRepository(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get());
    }
}
