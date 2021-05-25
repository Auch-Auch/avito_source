package com.avito.android.di;

import com.avito.android.epress_cv.remote.ExpressCvApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ExpressCsApiModule_ProvideExpressCvApiFactory implements Factory<ExpressCvApi> {
    public final Provider<RetrofitFactory> a;

    public ExpressCsApiModule_ProvideExpressCvApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static ExpressCsApiModule_ProvideExpressCvApiFactory create(Provider<RetrofitFactory> provider) {
        return new ExpressCsApiModule_ProvideExpressCvApiFactory(provider);
    }

    public static ExpressCvApi provideExpressCvApi(RetrofitFactory retrofitFactory) {
        return (ExpressCvApi) Preconditions.checkNotNullFromProvides(ExpressCsApiModule.INSTANCE.provideExpressCvApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public ExpressCvApi get() {
        return provideExpressCvApi(this.a.get());
    }
}
