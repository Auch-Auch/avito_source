package com.avito.android.di.module;

import com.avito.android.remote.RetrofitFactory;
import com.avito.android.remote.VerificationApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class VerificationApiModule_ProvideVerificationApiFactory implements Factory<VerificationApi> {
    public final Provider<RetrofitFactory> a;

    public VerificationApiModule_ProvideVerificationApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static VerificationApiModule_ProvideVerificationApiFactory create(Provider<RetrofitFactory> provider) {
        return new VerificationApiModule_ProvideVerificationApiFactory(provider);
    }

    public static VerificationApi provideVerificationApi(RetrofitFactory retrofitFactory) {
        return (VerificationApi) Preconditions.checkNotNullFromProvides(VerificationApiModule.INSTANCE.provideVerificationApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public VerificationApi get() {
        return provideVerificationApi(this.a.get());
    }
}
