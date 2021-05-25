package com.avito.android.brandspace.items.marketplace.banner;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class BannerBlueprint_Factory implements Factory<BannerBlueprint> {
    public final Provider<BannerPresenter> a;

    public BannerBlueprint_Factory(Provider<BannerPresenter> provider) {
        this.a = provider;
    }

    public static BannerBlueprint_Factory create(Provider<BannerPresenter> provider) {
        return new BannerBlueprint_Factory(provider);
    }

    public static BannerBlueprint newInstance(BannerPresenter bannerPresenter) {
        return new BannerBlueprint(bannerPresenter);
    }

    @Override // javax.inject.Provider
    public BannerBlueprint get() {
        return newInstance(this.a.get());
    }
}
