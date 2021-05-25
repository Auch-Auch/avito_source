package com.avito.android.publish.di;

import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.publish.SubmissionPresenter;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.drafts.PublishDraftDataHolder;
import com.avito.android.publish.drafts.PublishDraftRepository;
import com.avito.android.publish.drafts.PublishDraftWiper;
import com.avito.android.publish.drafts.PublishMessageHandler;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishModule_ProvideSubmissionPresenterFactory implements Factory<SubmissionPresenter> {
    public final PublishModule a;
    public final Provider<PublishEventTracker> b;
    public final Provider<PublishAnalyticsDataProvider> c;
    public final Provider<SchedulersFactory> d;
    public final Provider<PublishDraftRepository> e;
    public final Provider<PublishDraftDataHolder> f;
    public final Provider<PublishDraftWiper> g;
    public final Provider<BuildInfo> h;
    public final Provider<Gson> i;
    public final Provider<PublishMessageHandler> j;

    public PublishModule_ProvideSubmissionPresenterFactory(PublishModule publishModule, Provider<PublishEventTracker> provider, Provider<PublishAnalyticsDataProvider> provider2, Provider<SchedulersFactory> provider3, Provider<PublishDraftRepository> provider4, Provider<PublishDraftDataHolder> provider5, Provider<PublishDraftWiper> provider6, Provider<BuildInfo> provider7, Provider<Gson> provider8, Provider<PublishMessageHandler> provider9) {
        this.a = publishModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
        this.i = provider8;
        this.j = provider9;
    }

    public static PublishModule_ProvideSubmissionPresenterFactory create(PublishModule publishModule, Provider<PublishEventTracker> provider, Provider<PublishAnalyticsDataProvider> provider2, Provider<SchedulersFactory> provider3, Provider<PublishDraftRepository> provider4, Provider<PublishDraftDataHolder> provider5, Provider<PublishDraftWiper> provider6, Provider<BuildInfo> provider7, Provider<Gson> provider8, Provider<PublishMessageHandler> provider9) {
        return new PublishModule_ProvideSubmissionPresenterFactory(publishModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static SubmissionPresenter provideSubmissionPresenter(PublishModule publishModule, PublishEventTracker publishEventTracker, PublishAnalyticsDataProvider publishAnalyticsDataProvider, SchedulersFactory schedulersFactory, PublishDraftRepository publishDraftRepository, PublishDraftDataHolder publishDraftDataHolder, PublishDraftWiper publishDraftWiper, BuildInfo buildInfo, Gson gson, PublishMessageHandler publishMessageHandler) {
        return (SubmissionPresenter) Preconditions.checkNotNullFromProvides(publishModule.provideSubmissionPresenter(publishEventTracker, publishAnalyticsDataProvider, schedulersFactory, publishDraftRepository, publishDraftDataHolder, publishDraftWiper, buildInfo, gson, publishMessageHandler));
    }

    @Override // javax.inject.Provider
    public SubmissionPresenter get() {
        return provideSubmissionPresenter(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get());
    }
}
