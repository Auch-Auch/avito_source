package com.avito.android.tariff.info.item.package_info;

import dagger.internal.Factory;
public final class PackageInfoItemPresenterImpl_Factory implements Factory<PackageInfoItemPresenterImpl> {

    public static final class a {
        public static final PackageInfoItemPresenterImpl_Factory a = new PackageInfoItemPresenterImpl_Factory();
    }

    public static PackageInfoItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static PackageInfoItemPresenterImpl newInstance() {
        return new PackageInfoItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public PackageInfoItemPresenterImpl get() {
        return newInstance();
    }
}
