package com.avito.android.vas_discount;

import com.avito.android.util.SchedulersFactory;
import com.avito.android.vas_discount.business.DiscountRepository;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DiscountActivityViewModelFactory_Factory implements Factory<DiscountActivityViewModelFactory> {
    public final Provider<String> a;
    public final Provider<DiscountRepository> b;
    public final Provider<SchedulersFactory> c;

    public DiscountActivityViewModelFactory_Factory(Provider<String> provider, Provider<DiscountRepository> provider2, Provider<SchedulersFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static DiscountActivityViewModelFactory_Factory create(Provider<String> provider, Provider<DiscountRepository> provider2, Provider<SchedulersFactory> provider3) {
        return new DiscountActivityViewModelFactory_Factory(provider, provider2, provider3);
    }

    public static DiscountActivityViewModelFactory newInstance(String str, DiscountRepository discountRepository, SchedulersFactory schedulersFactory) {
        return new DiscountActivityViewModelFactory(str, discountRepository, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public DiscountActivityViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
