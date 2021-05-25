package com.avito.android.subscriptions.remote;

import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SubscriptionsApiModule_ProvideSubscriptionsApiFactory implements Factory<SubscriptionsApi> {
    public final Provider<RetrofitFactory> a;

    public SubscriptionsApiModule_ProvideSubscriptionsApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static SubscriptionsApiModule_ProvideSubscriptionsApiFactory create(Provider<RetrofitFactory> provider) {
        return new SubscriptionsApiModule_ProvideSubscriptionsApiFactory(provider);
    }

    public static SubscriptionsApi provideSubscriptionsApi(RetrofitFactory retrofitFactory) {
        return (SubscriptionsApi) Preconditions.checkNotNullFromProvides(SubscriptionsApiModule.INSTANCE.provideSubscriptionsApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public SubscriptionsApi get() {
        return provideSubscriptionsApi(this.a.get());
    }
}
