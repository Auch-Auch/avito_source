package com.avito.android.tariff.info.item.package_title;

import dagger.internal.Factory;
public final class PackageTitleItemPresenterImpl_Factory implements Factory<PackageTitleItemPresenterImpl> {

    public static final class a {
        public static final PackageTitleItemPresenterImpl_Factory a = new PackageTitleItemPresenterImpl_Factory();
    }

    public static PackageTitleItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static PackageTitleItemPresenterImpl newInstance() {
        return new PackageTitleItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public PackageTitleItemPresenterImpl get() {
        return newInstance();
    }
}
