package com.avito.android.fees.refactor;

import dagger.internal.Factory;
public final class PackageItemConverterImpl_Factory implements Factory<PackageItemConverterImpl> {

    public static final class a {
        public static final PackageItemConverterImpl_Factory a = new PackageItemConverterImpl_Factory();
    }

    public static PackageItemConverterImpl_Factory create() {
        return a.a;
    }

    public static PackageItemConverterImpl newInstance() {
        return new PackageItemConverterImpl();
    }

    @Override // javax.inject.Provider
    public PackageItemConverterImpl get() {
        return newInstance();
    }
}
