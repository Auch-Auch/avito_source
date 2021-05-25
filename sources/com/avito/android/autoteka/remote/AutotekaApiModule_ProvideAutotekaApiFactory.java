package com.avito.android.autoteka.remote;

import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AutotekaApiModule_ProvideAutotekaApiFactory implements Factory<AutotekaApi> {
    public final Provider<RetrofitFactory> a;

    public AutotekaApiModule_ProvideAutotekaApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static AutotekaApiModule_ProvideAutotekaApiFactory create(Provider<RetrofitFactory> provider) {
        return new AutotekaApiModule_ProvideAutotekaApiFactory(provider);
    }

    public static AutotekaApi provideAutotekaApi(RetrofitFactory retrofitFactory) {
        return (AutotekaApi) Preconditions.checkNotNullFromProvides(AutotekaApiModule.INSTANCE.provideAutotekaApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public AutotekaApi get() {
        return provideAutotekaApi(this.a.get());
    }
}
