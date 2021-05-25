package com.avito.android.remote.di;

import com.avito.android.remote.FeaturesApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FeaturesApiModule_ProvideFeaturesApiFactory implements Factory<FeaturesApi> {
    public final Provider<RetrofitFactory> a;

    public FeaturesApiModule_ProvideFeaturesApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static FeaturesApiModule_ProvideFeaturesApiFactory create(Provider<RetrofitFactory> provider) {
        return new FeaturesApiModule_ProvideFeaturesApiFactory(provider);
    }

    public static FeaturesApi provideFeaturesApi(RetrofitFactory retrofitFactory) {
        return (FeaturesApi) Preconditions.checkNotNullFromProvides(FeaturesApiModule.INSTANCE.provideFeaturesApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public FeaturesApi get() {
        return provideFeaturesApi(this.a.get());
    }
}
