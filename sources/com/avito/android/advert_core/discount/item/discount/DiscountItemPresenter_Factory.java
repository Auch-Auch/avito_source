package com.avito.android.advert_core.discount.item.discount;

import dagger.internal.Factory;
public final class DiscountItemPresenter_Factory implements Factory<DiscountItemPresenter> {

    public static final class a {
        public static final DiscountItemPresenter_Factory a = new DiscountItemPresenter_Factory();
    }

    public static DiscountItemPresenter_Factory create() {
        return a.a;
    }

    public static DiscountItemPresenter newInstance() {
        return new DiscountItemPresenter();
    }

    @Override // javax.inject.Provider
    public DiscountItemPresenter get() {
        return newInstance();
    }
}
