package com.avito.android.analytics.interactor;

import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SnippetScrollDepthAnalyticsInteractorImpl_Factory implements Factory<SnippetScrollDepthAnalyticsInteractorImpl> {
    public final Provider<Analytics> a;

    public SnippetScrollDepthAnalyticsInteractorImpl_Factory(Provider<Analytics> provider) {
        this.a = provider;
    }

    public static SnippetScrollDepthAnalyticsInteractorImpl_Factory create(Provider<Analytics> provider) {
        return new SnippetScrollDepthAnalyticsInteractorImpl_Factory(provider);
    }

    public static SnippetScrollDepthAnalyticsInteractorImpl newInstance(Analytics analytics) {
        return new SnippetScrollDepthAnalyticsInteractorImpl(analytics);
    }

    @Override // javax.inject.Provider
    public SnippetScrollDepthAnalyticsInteractorImpl get() {
        return newInstance(this.a.get());
    }
}
