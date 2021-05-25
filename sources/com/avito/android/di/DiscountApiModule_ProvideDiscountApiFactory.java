package com.avito.android.di;

import com.avito.android.remote.DiscountApi;
import com.avito.android.remote.RetrofitFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DiscountApiModule_ProvideDiscountApiFactory implements Factory<DiscountApi> {
    public final Provider<RetrofitFactory> a;

    public DiscountApiModule_ProvideDiscountApiFactory(Provider<RetrofitFactory> provider) {
        this.a = provider;
    }

    public static DiscountApiModule_ProvideDiscountApiFactory create(Provider<RetrofitFactory> provider) {
        return new DiscountApiModule_ProvideDiscountApiFactory(provider);
    }

    public static DiscountApi provideDiscountApi(RetrofitFactory retrofitFactory) {
        return (DiscountApi) Preconditions.checkNotNullFromProvides(DiscountApiModule.INSTANCE.provideDiscountApi(retrofitFactory));
    }

    @Override // javax.inject.Provider
    public DiscountApi get() {
        return provideDiscountApi(this.a.get());
    }
}
