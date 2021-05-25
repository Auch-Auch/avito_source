package com.avito.android.bundles.ui.recycler.item.bundle;

import dagger.internal.Factory;
public final class VasBundleItemPresenterImpl_Factory implements Factory<VasBundleItemPresenterImpl> {

    public static final class a {
        public static final VasBundleItemPresenterImpl_Factory a = new VasBundleItemPresenterImpl_Factory();
    }

    public static VasBundleItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static VasBundleItemPresenterImpl newInstance() {
        return new VasBundleItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public VasBundleItemPresenterImpl get() {
        return newInstance();
    }
}
