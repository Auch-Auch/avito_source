package com.avito.android.vas_discount.business;

import com.avito.android.remote.DiscountApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DiscountRepositoryImpl_Factory implements Factory<DiscountRepositoryImpl> {
    public final Provider<DiscountApi> a;
    public final Provider<SchedulersFactory> b;

    public DiscountRepositoryImpl_Factory(Provider<DiscountApi> provider, Provider<SchedulersFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static DiscountRepositoryImpl_Factory create(Provider<DiscountApi> provider, Provider<SchedulersFactory> provider2) {
        return new DiscountRepositoryImpl_Factory(provider, provider2);
    }

    public static DiscountRepositoryImpl newInstance(DiscountApi discountApi, SchedulersFactory schedulersFactory) {
        return new DiscountRepositoryImpl(discountApi, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public DiscountRepositoryImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
