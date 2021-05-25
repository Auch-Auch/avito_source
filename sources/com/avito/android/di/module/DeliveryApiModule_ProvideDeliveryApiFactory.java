package com.avito.android.di.module;

import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DeliveryApiModule_ProvideDeliveryApiFactory implements Factory<DeliveryApi> {
    public final Provider<RetrofitFactory> a;

    public DeliveryApiModule_ProvideDeliveryApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static DeliveryApiModule_ProvideDeliveryApiFactory create(Provider<RetrofitFactory> provider) {
        return new DeliveryApiModule_ProvideDeliveryApiFactory(provider);
    }

    public static DeliveryApi provideDeliveryApi(RetrofitFactory retrofitFactory) {
        return (DeliveryApi) Preconditions.checkNotNullFromProvides(DeliveryApiModule.INSTANCE.provideDeliveryApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public DeliveryApi get() {
        return provideDeliveryApi(this.a.get());
    }
}
