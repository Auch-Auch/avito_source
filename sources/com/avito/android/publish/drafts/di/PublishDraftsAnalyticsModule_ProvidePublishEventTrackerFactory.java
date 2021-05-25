package com.avito.android.publish.drafts.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.publish.drafts.analytics.PublishDraftEventTracker;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublishDraftsAnalyticsModule_ProvidePublishEventTrackerFactory implements Factory<PublishDraftEventTracker> {
    public final Provider<Analytics> a;
    public final Provider<PublishAnalyticsDataProvider> b;
    public final Provider<Gson> c;

    public PublishDraftsAnalyticsModule_ProvidePublishEventTrackerFactory(Provider<Analytics> provider, Provider<PublishAnalyticsDataProvider> provider2, Provider<Gson> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static PublishDraftsAnalyticsModule_ProvidePublishEventTrackerFactory create(Provider<Analytics> provider, Provider<PublishAnalyticsDataProvider> provider2, Provider<Gson> provider3) {
        return new PublishDraftsAnalyticsModule_ProvidePublishEventTrackerFactory(provider, provider2, provider3);
    }

    public static PublishDraftEventTracker providePublishEventTracker(Analytics analytics, PublishAnalyticsDataProvider publishAnalyticsDataProvider, Gson gson) {
        return (PublishDraftEventTracker) Preconditions.checkNotNullFromProvides(PublishDraftsAnalyticsModule.providePublishEventTracker(analytics, publishAnalyticsDataProvider, gson));
    }

    @Override // javax.inject.Provider
    public PublishDraftEventTracker get() {
        return providePublishEventTracker(this.a.get(), this.b.get(), this.c.get());
    }
}
