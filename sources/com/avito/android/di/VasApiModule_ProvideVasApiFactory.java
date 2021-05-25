package com.avito.android.di;

import com.avito.android.remote.RetrofitFactory;
import com.avito.android.vas.remote.VasApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class VasApiModule_ProvideVasApiFactory implements Factory<VasApi> {
    public final Provider<RetrofitFactory> a;

    public VasApiModule_ProvideVasApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static VasApiModule_ProvideVasApiFactory create(Provider<RetrofitFactory> provider) {
        return new VasApiModule_ProvideVasApiFactory(provider);
    }

    public static VasApi provideVasApi(RetrofitFactory retrofitFactory) {
        return (VasApi) Preconditions.checkNotNullFromProvides(VasApiModule.INSTANCE.provideVasApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public VasApi get() {
        return provideVasApi(this.a.get());
    }
}
