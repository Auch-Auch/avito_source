package com.avito.android.tariff.fees_methods.items.tariff_package;

import dagger.internal.Factory;
public final class FeeMethodPackagePresenterImpl_Factory implements Factory<FeeMethodPackagePresenterImpl> {

    public static final class a {
        public static final FeeMethodPackagePresenterImpl_Factory a = new FeeMethodPackagePresenterImpl_Factory();
    }

    public static FeeMethodPackagePresenterImpl_Factory create() {
        return a.a;
    }

    public static FeeMethodPackagePresenterImpl newInstance() {
        return new FeeMethodPackagePresenterImpl();
    }

    @Override // javax.inject.Provider
    public FeeMethodPackagePresenterImpl get() {
        return newInstance();
    }
}
