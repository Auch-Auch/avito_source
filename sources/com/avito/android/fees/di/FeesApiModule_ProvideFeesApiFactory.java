package com.avito.android.fees.di;

import com.avito.android.fees.remote.FeesApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FeesApiModule_ProvideFeesApiFactory implements Factory<FeesApi> {
    public final Provider<RetrofitFactory> a;

    public FeesApiModule_ProvideFeesApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static FeesApiModule_ProvideFeesApiFactory create(Provider<RetrofitFactory> provider) {
        return new FeesApiModule_ProvideFeesApiFactory(provider);
    }

    public static FeesApi provideFeesApi(RetrofitFactory retrofitFactory) {
        return (FeesApi) Preconditions.checkNotNullFromProvides(FeesApiModule.INSTANCE.provideFeesApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public FeesApi get() {
        return provideFeesApi(this.a.get());
    }
}
