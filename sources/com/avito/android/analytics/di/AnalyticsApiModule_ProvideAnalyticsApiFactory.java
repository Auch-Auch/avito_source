package com.avito.android.analytics.di;

import com.avito.android.analytics.remote.AnalyticsApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AnalyticsApiModule_ProvideAnalyticsApiFactory implements Factory<AnalyticsApi> {
    public final Provider<RetrofitFactory> a;

    public AnalyticsApiModule_ProvideAnalyticsApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static AnalyticsApiModule_ProvideAnalyticsApiFactory create(Provider<RetrofitFactory> provider) {
        return new AnalyticsApiModule_ProvideAnalyticsApiFactory(provider);
    }

    public static AnalyticsApi provideAnalyticsApi(RetrofitFactory retrofitFactory) {
        return (AnalyticsApi) Preconditions.checkNotNullFromProvides(AnalyticsApiModule.INSTANCE.provideAnalyticsApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public AnalyticsApi get() {
        return provideAnalyticsApi(this.a.get());
    }
}
