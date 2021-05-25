package com.avito.android.service_subscription.di;

import com.avito.android.remote.RetrofitFactory;
import com.avito.android.service_subscription.remote.ServiceSubscriptionApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ServiceSubscriptionApiModule_ProvideServiceSubscriptionApiFactory implements Factory<ServiceSubscriptionApi> {
    public final Provider<RetrofitFactory> a;

    public ServiceSubscriptionApiModule_ProvideServiceSubscriptionApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static ServiceSubscriptionApiModule_ProvideServiceSubscriptionApiFactory create(Provider<RetrofitFactory> provider) {
        return new ServiceSubscriptionApiModule_ProvideServiceSubscriptionApiFactory(provider);
    }

    public static ServiceSubscriptionApi provideServiceSubscriptionApi(RetrofitFactory retrofitFactory) {
        return (ServiceSubscriptionApi) Preconditions.checkNotNullFromProvides(ServiceSubscriptionApiModule.INSTANCE.provideServiceSubscriptionApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public ServiceSubscriptionApi get() {
        return provideServiceSubscriptionApi(this.a.get());
    }
}
