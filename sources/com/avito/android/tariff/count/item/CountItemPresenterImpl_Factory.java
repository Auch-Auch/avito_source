package com.avito.android.tariff.count.item;

import dagger.internal.Factory;
public final class CountItemPresenterImpl_Factory implements Factory<CountItemPresenterImpl> {

    public static final class a {
        public static final CountItemPresenterImpl_Factory a = new CountItemPresenterImpl_Factory();
    }

    public static CountItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static CountItemPresenterImpl newInstance() {
        return new CountItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public CountItemPresenterImpl get() {
        return newInstance();
    }
}
