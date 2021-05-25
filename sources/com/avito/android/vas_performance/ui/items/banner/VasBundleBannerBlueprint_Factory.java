package com.avito.android.vas_performance.ui.items.banner;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class VasBundleBannerBlueprint_Factory implements Factory<VasBundleBannerBlueprint> {
    public final Provider<VasBundleBannerItemPresenter> a;

    public VasBundleBannerBlueprint_Factory(Provider<VasBundleBannerItemPresenter> provider) {
        this.a = provider;
    }

    public static VasBundleBannerBlueprint_Factory create(Provider<VasBundleBannerItemPresenter> provider) {
        return new VasBundleBannerBlueprint_Factory(provider);
    }

    public static VasBundleBannerBlueprint newInstance(VasBundleBannerItemPresenter vasBundleBannerItemPresenter) {
        return new VasBundleBannerBlueprint(vasBundleBannerItemPresenter);
    }

    @Override // javax.inject.Provider
    public VasBundleBannerBlueprint get() {
        return newInstance(this.a.get());
    }
}
