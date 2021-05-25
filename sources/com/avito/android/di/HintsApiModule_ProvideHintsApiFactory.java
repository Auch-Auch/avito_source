package com.avito.android.di;

import com.avito.android.hints.remote.HintsApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class HintsApiModule_ProvideHintsApiFactory implements Factory<HintsApi> {
    public final Provider<RetrofitFactory> a;

    public HintsApiModule_ProvideHintsApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static HintsApiModule_ProvideHintsApiFactory create(Provider<RetrofitFactory> provider) {
        return new HintsApiModule_ProvideHintsApiFactory(provider);
    }

    public static HintsApi provideHintsApi(RetrofitFactory retrofitFactory) {
        return (HintsApi) Preconditions.checkNotNullFromProvides(HintsApiModule.INSTANCE.provideHintsApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public HintsApi get() {
        return provideHintsApi(this.a.get());
    }
}
