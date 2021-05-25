package com.avito.android.advert.item.price_discount;

import com.avito.android.advert_core.discount.AdvertDiscountDetailsDialog;
import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PriceWithDiscountPresenterImpl_Factory implements Factory<PriceWithDiscountPresenterImpl> {
    public final Provider<String> a;
    public final Provider<AdvertDiscountDetailsDialog> b;
    public final Provider<Analytics> c;

    public PriceWithDiscountPresenterImpl_Factory(Provider<String> provider, Provider<AdvertDiscountDetailsDialog> provider2, Provider<Analytics> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static PriceWithDiscountPresenterImpl_Factory create(Provider<String> provider, Provider<AdvertDiscountDetailsDialog> provider2, Provider<Analytics> provider3) {
        return new PriceWithDiscountPresenterImpl_Factory(provider, provider2, provider3);
    }

    public static PriceWithDiscountPresenterImpl newInstance(String str, AdvertDiscountDetailsDialog advertDiscountDetailsDialog, Analytics analytics) {
        return new PriceWithDiscountPresenterImpl(str, advertDiscountDetailsDialog, analytics);
    }

    @Override // javax.inject.Provider
    public PriceWithDiscountPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
