package com.avito.android.di;

import com.avito.android.remote.RetrofitFactory;
import com.avito.android.remote.VasUnionApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class VasUnionApiModule_ProvideUnionApiFactory implements Factory<VasUnionApi> {
    public final Provider<RetrofitFactory> a;

    public VasUnionApiModule_ProvideUnionApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static VasUnionApiModule_ProvideUnionApiFactory create(Provider<RetrofitFactory> provider) {
        return new VasUnionApiModule_ProvideUnionApiFactory(provider);
    }

    public static VasUnionApi provideUnionApi(RetrofitFactory retrofitFactory) {
        return (VasUnionApi) Preconditions.checkNotNullFromProvides(VasUnionApiModule.INSTANCE.provideUnionApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public VasUnionApi get() {
        return provideUnionApi(this.a.get());
    }
}
