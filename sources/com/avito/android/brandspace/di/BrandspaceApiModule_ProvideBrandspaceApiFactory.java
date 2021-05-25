package com.avito.android.brandspace.di;

import com.avito.android.brandspace.remote.BrandspaceApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class BrandspaceApiModule_ProvideBrandspaceApiFactory implements Factory<BrandspaceApi> {
    public final Provider<RetrofitFactory> a;

    public BrandspaceApiModule_ProvideBrandspaceApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static BrandspaceApiModule_ProvideBrandspaceApiFactory create(Provider<RetrofitFactory> provider) {
        return new BrandspaceApiModule_ProvideBrandspaceApiFactory(provider);
    }

    public static BrandspaceApi provideBrandspaceApi(RetrofitFactory retrofitFactory) {
        return (BrandspaceApi) Preconditions.checkNotNullFromProvides(BrandspaceApiModule.INSTANCE.provideBrandspaceApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public BrandspaceApi get() {
        return provideBrandspaceApi(this.a.get());
    }
}
