package com.avito.android.di.module;

import com.avito.android.remote.CheckoutApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CheckoutApiModule_ProvideCheckoutApiFactory implements Factory<CheckoutApi> {
    public final Provider<RetrofitFactory> a;

    public CheckoutApiModule_ProvideCheckoutApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static CheckoutApiModule_ProvideCheckoutApiFactory create(Provider<RetrofitFactory> provider) {
        return new CheckoutApiModule_ProvideCheckoutApiFactory(provider);
    }

    public static CheckoutApi provideCheckoutApi(RetrofitFactory retrofitFactory) {
        return (CheckoutApi) Preconditions.checkNotNullFromProvides(CheckoutApiModule.INSTANCE.provideCheckoutApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public CheckoutApi get() {
        return provideCheckoutApi(this.a.get());
    }
}
