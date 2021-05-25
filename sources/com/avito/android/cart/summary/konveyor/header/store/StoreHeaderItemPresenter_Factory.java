package com.avito.android.cart.summary.konveyor.header.store;

import dagger.internal.Factory;
public final class StoreHeaderItemPresenter_Factory implements Factory<StoreHeaderItemPresenter> {

    public static final class a {
        public static final StoreHeaderItemPresenter_Factory a = new StoreHeaderItemPresenter_Factory();
    }

    public static StoreHeaderItemPresenter_Factory create() {
        return a.a;
    }

    public static StoreHeaderItemPresenter newInstance() {
        return new StoreHeaderItemPresenter();
    }

    @Override // javax.inject.Provider
    public StoreHeaderItemPresenter get() {
        return newInstance();
    }
}
