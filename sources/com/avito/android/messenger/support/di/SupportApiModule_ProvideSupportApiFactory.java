package com.avito.android.messenger.support.di;

import com.avito.android.remote.RetrofitFactory;
import com.avito.android.remote.SupportApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SupportApiModule_ProvideSupportApiFactory implements Factory<SupportApi> {
    public final Provider<RetrofitFactory> a;

    public SupportApiModule_ProvideSupportApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static SupportApiModule_ProvideSupportApiFactory create(Provider<RetrofitFactory> provider) {
        return new SupportApiModule_ProvideSupportApiFactory(provider);
    }

    public static SupportApi provideSupportApi(RetrofitFactory retrofitFactory) {
        return (SupportApi) Preconditions.checkNotNullFromProvides(SupportApiModule.INSTANCE.provideSupportApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public SupportApi get() {
        return provideSupportApi(this.a.get());
    }
}
