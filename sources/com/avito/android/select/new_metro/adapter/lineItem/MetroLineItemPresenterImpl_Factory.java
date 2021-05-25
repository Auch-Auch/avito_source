package com.avito.android.select.new_metro.adapter.lineItem;

import dagger.internal.Factory;
public final class MetroLineItemPresenterImpl_Factory implements Factory<MetroLineItemPresenterImpl> {

    public static final class a {
        public static final MetroLineItemPresenterImpl_Factory a = new MetroLineItemPresenterImpl_Factory();
    }

    public static MetroLineItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static MetroLineItemPresenterImpl newInstance() {
        return new MetroLineItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public MetroLineItemPresenterImpl get() {
        return newInstance();
    }
}
