package com.avito.android.bundles;

import dagger.internal.Factory;
public final class VasBundlesConverterImpl_Factory implements Factory<VasBundlesConverterImpl> {

    public static final class a {
        public static final VasBundlesConverterImpl_Factory a = new VasBundlesConverterImpl_Factory();
    }

    public static VasBundlesConverterImpl_Factory create() {
        return a.a;
    }

    public static VasBundlesConverterImpl newInstance() {
        return new VasBundlesConverterImpl();
    }

    @Override // javax.inject.Provider
    public VasBundlesConverterImpl get() {
        return newInstance();
    }
}
