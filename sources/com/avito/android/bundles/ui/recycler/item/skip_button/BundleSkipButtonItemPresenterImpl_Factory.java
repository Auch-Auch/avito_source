package com.avito.android.bundles.ui.recycler.item.skip_button;

import dagger.internal.Factory;
public final class BundleSkipButtonItemPresenterImpl_Factory implements Factory<BundleSkipButtonItemPresenterImpl> {

    public static final class a {
        public static final BundleSkipButtonItemPresenterImpl_Factory a = new BundleSkipButtonItemPresenterImpl_Factory();
    }

    public static BundleSkipButtonItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static BundleSkipButtonItemPresenterImpl newInstance() {
        return new BundleSkipButtonItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public BundleSkipButtonItemPresenterImpl get() {
        return newInstance();
    }
}
