package com.avito.android.publish.infomodel_request;

import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.analytics.screens.tracker.UnknownScreenTracker;
import com.avito.android.publish.PublishParametersInteractor;
import com.avito.android.publish.drafts.analytics.PublishDraftEventTracker;
import com.avito.android.publish.drafts.analytics.PublishSessionIdGenerator;
import com.avito.android.util.SchedulersFactory;
import com.google.gson.Gson;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class InfomodelRequestViewModelFactoryImpl_Factory implements Factory<InfomodelRequestViewModelFactoryImpl> {
    public final Provider<PublishParametersInteractor> a;
    public final Provider<Gson> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<PublishDraftEventTracker> d;
    public final Provider<PublishAnalyticsDataProvider> e;
    public final Provider<PublishSessionIdGenerator> f;
    public final Provider<UnknownScreenTracker> g;

    public InfomodelRequestViewModelFactoryImpl_Factory(Provider<PublishParametersInteractor> provider, Provider<Gson> provider2, Provider<SchedulersFactory> provider3, Provider<PublishDraftEventTracker> provider4, Provider<PublishAnalyticsDataProvider> provider5, Provider<PublishSessionIdGenerator> provider6, Provider<UnknownScreenTracker> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static InfomodelRequestViewModelFactoryImpl_Factory create(Provider<PublishParametersInteractor> provider, Provider<Gson> provider2, Provider<SchedulersFactory> provider3, Provider<PublishDraftEventTracker> provider4, Provider<PublishAnalyticsDataProvider> provider5, Provider<PublishSessionIdGenerator> provider6, Provider<UnknownScreenTracker> provider7) {
        return new InfomodelRequestViewModelFactoryImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static InfomodelRequestViewModelFactoryImpl newInstance(PublishParametersInteractor publishParametersInteractor, Gson gson, SchedulersFactory schedulersFactory, PublishDraftEventTracker publishDraftEventTracker, PublishAnalyticsDataProvider publishAnalyticsDataProvider, PublishSessionIdGenerator publishSessionIdGenerator, UnknownScreenTracker unknownScreenTracker) {
        return new InfomodelRequestViewModelFactoryImpl(publishParametersInteractor, gson, schedulersFactory, publishDraftEventTracker, publishAnalyticsDataProvider, publishSessionIdGenerator, unknownScreenTracker);
    }

    @Override // javax.inject.Provider
    public InfomodelRequestViewModelFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
