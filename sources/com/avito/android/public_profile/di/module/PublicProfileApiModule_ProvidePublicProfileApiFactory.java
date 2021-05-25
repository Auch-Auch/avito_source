package com.avito.android.public_profile.di.module;

import com.avito.android.public_profile.remote.PublicProfileApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PublicProfileApiModule_ProvidePublicProfileApiFactory implements Factory<PublicProfileApi> {
    public final Provider<RetrofitFactory> a;

    public PublicProfileApiModule_ProvidePublicProfileApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static PublicProfileApiModule_ProvidePublicProfileApiFactory create(Provider<RetrofitFactory> provider) {
        return new PublicProfileApiModule_ProvidePublicProfileApiFactory(provider);
    }

    public static PublicProfileApi providePublicProfileApi(RetrofitFactory retrofitFactory) {
        return (PublicProfileApi) Preconditions.checkNotNullFromProvides(PublicProfileApiModule.INSTANCE.providePublicProfileApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public PublicProfileApi get() {
        return providePublicProfileApi(this.a.get());
    }
}
