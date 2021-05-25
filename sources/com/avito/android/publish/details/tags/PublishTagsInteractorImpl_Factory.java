package com.avito.android.publish.details.tags;

import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.remote.PublishApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PublishTagsInteractorImpl_Factory implements Factory<PublishTagsInteractorImpl> {
    public final Provider<PublishApi> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<PublishAnalyticsDataProvider> c;

    public PublishTagsInteractorImpl_Factory(Provider<PublishApi> provider, Provider<SchedulersFactory> provider2, Provider<PublishAnalyticsDataProvider> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static PublishTagsInteractorImpl_Factory create(Provider<PublishApi> provider, Provider<SchedulersFactory> provider2, Provider<PublishAnalyticsDataProvider> provider3) {
        return new PublishTagsInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static PublishTagsInteractorImpl newInstance(PublishApi publishApi, SchedulersFactory schedulersFactory, PublishAnalyticsDataProvider publishAnalyticsDataProvider) {
        return new PublishTagsInteractorImpl(publishApi, schedulersFactory, publishAnalyticsDataProvider);
    }

    @Override // javax.inject.Provider
    public PublishTagsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
