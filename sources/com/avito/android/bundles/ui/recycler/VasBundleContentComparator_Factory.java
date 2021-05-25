package com.avito.android.bundles.ui.recycler;

import dagger.internal.Factory;
public final class VasBundleContentComparator_Factory implements Factory<VasBundleContentComparator> {

    public static final class a {
        public static final VasBundleContentComparator_Factory a = new VasBundleContentComparator_Factory();
    }

    public static VasBundleContentComparator_Factory create() {
        return a.a;
    }

    public static VasBundleContentComparator newInstance() {
        return new VasBundleContentComparator();
    }

    @Override // javax.inject.Provider
    public VasBundleContentComparator get() {
        return newInstance();
    }
}
