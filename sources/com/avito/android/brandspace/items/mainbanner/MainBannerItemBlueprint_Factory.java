package com.avito.android.brandspace.items.mainbanner;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class MainBannerItemBlueprint_Factory implements Factory<MainBannerItemBlueprint> {
    public final Provider<MainBannerItemPresenter> a;

    public MainBannerItemBlueprint_Factory(Provider<MainBannerItemPresenter> provider) {
        this.a = provider;
    }

    public static MainBannerItemBlueprint_Factory create(Provider<MainBannerItemPresenter> provider) {
        return new MainBannerItemBlueprint_Factory(provider);
    }

    public static MainBannerItemBlueprint newInstance(MainBannerItemPresenter mainBannerItemPresenter) {
        return new MainBannerItemBlueprint(mainBannerItemPresenter);
    }

    @Override // javax.inject.Provider
    public MainBannerItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
