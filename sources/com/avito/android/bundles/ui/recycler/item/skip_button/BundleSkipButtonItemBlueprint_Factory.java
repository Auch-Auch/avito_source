package com.avito.android.bundles.ui.recycler.item.skip_button;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class BundleSkipButtonItemBlueprint_Factory implements Factory<BundleSkipButtonItemBlueprint> {
    public final Provider<BundleSkipButtonItemPresenter> a;

    public BundleSkipButtonItemBlueprint_Factory(Provider<BundleSkipButtonItemPresenter> provider) {
        this.a = provider;
    }

    public static BundleSkipButtonItemBlueprint_Factory create(Provider<BundleSkipButtonItemPresenter> provider) {
        return new BundleSkipButtonItemBlueprint_Factory(provider);
    }

    public static BundleSkipButtonItemBlueprint newInstance(BundleSkipButtonItemPresenter bundleSkipButtonItemPresenter) {
        return new BundleSkipButtonItemBlueprint(bundleSkipButtonItemPresenter);
    }

    @Override // javax.inject.Provider
    public BundleSkipButtonItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
