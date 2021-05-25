package com.avito.android.di;

import com.avito.android.advert_stats.remote.AdvertStatsApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AdvertStatsApiModule_ProvideAdvertStatsApiFactory implements Factory<AdvertStatsApi> {
    public final Provider<RetrofitFactory> a;

    public AdvertStatsApiModule_ProvideAdvertStatsApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static AdvertStatsApiModule_ProvideAdvertStatsApiFactory create(Provider<RetrofitFactory> provider) {
        return new AdvertStatsApiModule_ProvideAdvertStatsApiFactory(provider);
    }

    public static AdvertStatsApi provideAdvertStatsApi(RetrofitFactory retrofitFactory) {
        return (AdvertStatsApi) Preconditions.checkNotNullFromProvides(AdvertStatsApiModule.INSTANCE.provideAdvertStatsApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public AdvertStatsApi get() {
        return provideAdvertStatsApi(this.a.get());
    }
}
