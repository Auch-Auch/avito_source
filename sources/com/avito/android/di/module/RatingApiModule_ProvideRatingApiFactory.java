package com.avito.android.di.module;

import com.avito.android.rating.remote.RatingApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class RatingApiModule_ProvideRatingApiFactory implements Factory<RatingApi> {
    public final Provider<RetrofitFactory> a;

    public RatingApiModule_ProvideRatingApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static RatingApiModule_ProvideRatingApiFactory create(Provider<RetrofitFactory> provider) {
        return new RatingApiModule_ProvideRatingApiFactory(provider);
    }

    public static RatingApi provideRatingApi(RetrofitFactory retrofitFactory) {
        return (RatingApi) Preconditions.checkNotNullFromProvides(RatingApiModule.INSTANCE.provideRatingApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public RatingApi get() {
        return provideRatingApi(this.a.get());
    }
}
