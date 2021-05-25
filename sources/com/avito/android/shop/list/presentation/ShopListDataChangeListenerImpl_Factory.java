package com.avito.android.shop.list.presentation;

import dagger.internal.Factory;
public final class ShopListDataChangeListenerImpl_Factory implements Factory<ShopListDataChangeListenerImpl> {

    public static final class a {
        public static final ShopListDataChangeListenerImpl_Factory a = new ShopListDataChangeListenerImpl_Factory();
    }

    public static ShopListDataChangeListenerImpl_Factory create() {
        return a.a;
    }

    public static ShopListDataChangeListenerImpl newInstance() {
        return new ShopListDataChangeListenerImpl();
    }

    @Override // javax.inject.Provider
    public ShopListDataChangeListenerImpl get() {
        return newInstance();
    }
}
