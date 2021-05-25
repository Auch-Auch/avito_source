package com.avito.android.di;

import com.avito.android.remote.InfoApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class InfoApiModule_ProvideInfoApiFactory implements Factory<InfoApi> {
    public final Provider<RetrofitFactory> a;

    public InfoApiModule_ProvideInfoApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static InfoApiModule_ProvideInfoApiFactory create(Provider<RetrofitFactory> provider) {
        return new InfoApiModule_ProvideInfoApiFactory(provider);
    }

    public static InfoApi provideInfoApi(RetrofitFactory retrofitFactory) {
        return (InfoApi) Preconditions.checkNotNullFromProvides(InfoApiModule.INSTANCE.provideInfoApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public InfoApi get() {
        return provideInfoApi(this.a.get());
    }
}
