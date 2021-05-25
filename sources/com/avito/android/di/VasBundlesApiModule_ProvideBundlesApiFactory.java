package com.avito.android.di;

import com.avito.android.remote.RetrofitFactory;
import com.avito.android.remote.VasBundlesApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class VasBundlesApiModule_ProvideBundlesApiFactory implements Factory<VasBundlesApi> {
    public final Provider<RetrofitFactory> a;

    public VasBundlesApiModule_ProvideBundlesApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static VasBundlesApiModule_ProvideBundlesApiFactory create(Provider<RetrofitFactory> provider) {
        return new VasBundlesApiModule_ProvideBundlesApiFactory(provider);
    }

    public static VasBundlesApi provideBundlesApi(RetrofitFactory retrofitFactory) {
        return (VasBundlesApi) Preconditions.checkNotNullFromProvides(VasBundlesApiModule.INSTANCE.provideBundlesApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public VasBundlesApi get() {
        return provideBundlesApi(this.a.get());
    }
}
