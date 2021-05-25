package com.avito.android.remote.di;

import com.avito.android.remote.ExtendedProfileApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ExtendedProfileApiModule_ProvideExtendedProfileApiFactory implements Factory<ExtendedProfileApi> {
    public final Provider<RetrofitFactory> a;

    public ExtendedProfileApiModule_ProvideExtendedProfileApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static ExtendedProfileApiModule_ProvideExtendedProfileApiFactory create(Provider<RetrofitFactory> provider) {
        return new ExtendedProfileApiModule_ProvideExtendedProfileApiFactory(provider);
    }

    public static ExtendedProfileApi provideExtendedProfileApi(RetrofitFactory retrofitFactory) {
        return (ExtendedProfileApi) Preconditions.checkNotNullFromProvides(ExtendedProfileApiModule.INSTANCE.provideExtendedProfileApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public ExtendedProfileApi get() {
        return provideExtendedProfileApi(this.a.get());
    }
}
