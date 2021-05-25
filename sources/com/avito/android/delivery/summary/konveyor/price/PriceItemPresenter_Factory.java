package com.avito.android.delivery.summary.konveyor.price;

import dagger.internal.Factory;
public final class PriceItemPresenter_Factory implements Factory<PriceItemPresenter> {

    public static final class a {
        public static final PriceItemPresenter_Factory a = new PriceItemPresenter_Factory();
    }

    public static PriceItemPresenter_Factory create() {
        return a.a;
    }

    public static PriceItemPresenter newInstance() {
        return new PriceItemPresenter();
    }

    @Override // javax.inject.Provider
    public PriceItemPresenter get() {
        return newInstance();
    }
}
