package com.avito.android.bundles.ui.recycler.item.skip_button;

import android.view.View;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BundleSkipButtonItemViewImpl_Factory implements Factory<BundleSkipButtonItemViewImpl> {
    public final Provider<View> a;

    public BundleSkipButtonItemViewImpl_Factory(Provider<View> provider) {
        this.a = provider;
    }

    public static BundleSkipButtonItemViewImpl_Factory create(Provider<View> provider) {
        return new BundleSkipButtonItemViewImpl_Factory(provider);
    }

    public static BundleSkipButtonItemViewImpl newInstance(View view) {
        return new BundleSkipButtonItemViewImpl(view);
    }

    @Override // javax.inject.Provider
    public BundleSkipButtonItemViewImpl get() {
        return newInstance(this.a.get());
    }
}
