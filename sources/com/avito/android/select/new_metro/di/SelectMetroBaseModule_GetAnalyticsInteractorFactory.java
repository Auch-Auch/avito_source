package com.avito.android.select.new_metro.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.select.new_metro.analytics.SelectMetroAnalytics;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SelectMetroBaseModule_GetAnalyticsInteractorFactory implements Factory<SelectMetroAnalytics> {
    public final Provider<Analytics> a;

    public SelectMetroBaseModule_GetAnalyticsInteractorFactory(Provider<Analytics> provider) {
        this.a = provider;
    }

    public static SelectMetroBaseModule_GetAnalyticsInteractorFactory create(Provider<Analytics> provider) {
        return new SelectMetroBaseModule_GetAnalyticsInteractorFactory(provider);
    }

    public static SelectMetroAnalytics getAnalyticsInteractor(Analytics analytics) {
        return (SelectMetroAnalytics) Preconditions.checkNotNullFromProvides(SelectMetroBaseModule.INSTANCE.getAnalyticsInteractor(analytics));
    }

    @Override // javax.inject.Provider
    public SelectMetroAnalytics get() {
        return getAnalyticsInteractor(this.a.get());
    }
}
