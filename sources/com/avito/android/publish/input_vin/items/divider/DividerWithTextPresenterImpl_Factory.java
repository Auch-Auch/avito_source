package com.avito.android.publish.input_vin.items.divider;

import dagger.internal.Factory;
public final class DividerWithTextPresenterImpl_Factory implements Factory<DividerWithTextPresenterImpl> {

    public static final class a {
        public static final DividerWithTextPresenterImpl_Factory a = new DividerWithTextPresenterImpl_Factory();
    }

    public static DividerWithTextPresenterImpl_Factory create() {
        return a.a;
    }

    public static DividerWithTextPresenterImpl newInstance() {
        return new DividerWithTextPresenterImpl();
    }

    @Override // javax.inject.Provider
    public DividerWithTextPresenterImpl get() {
        return newInstance();
    }
}
