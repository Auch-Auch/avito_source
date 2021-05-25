package com.avito.android.advert_details.remote;

import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AdvertDetailsApiModule_ProvideAdvertDetailsApiFactory implements Factory<AdvertDetailsApi> {
    public final Provider<RetrofitFactory> a;

    public AdvertDetailsApiModule_ProvideAdvertDetailsApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static AdvertDetailsApiModule_ProvideAdvertDetailsApiFactory create(Provider<RetrofitFactory> provider) {
        return new AdvertDetailsApiModule_ProvideAdvertDetailsApiFactory(provider);
    }

    public static AdvertDetailsApi provideAdvertDetailsApi(RetrofitFactory retrofitFactory) {
        return (AdvertDetailsApi) Preconditions.checkNotNullFromProvides(AdvertDetailsApiModule.INSTANCE.provideAdvertDetailsApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public AdvertDetailsApi get() {
        return provideAdvertDetailsApi(this.a.get());
    }
}
