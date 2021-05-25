package com.avito.android.serp.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShortcutBannerBlueprint_Factory implements Factory<ShortcutBannerBlueprint> {
    public final Provider<ShortcutBannerItemPresenter> a;

    public ShortcutBannerBlueprint_Factory(Provider<ShortcutBannerItemPresenter> provider) {
        this.a = provider;
    }

    public static ShortcutBannerBlueprint_Factory create(Provider<ShortcutBannerItemPresenter> provider) {
        return new ShortcutBannerBlueprint_Factory(provider);
    }

    public static ShortcutBannerBlueprint newInstance(ShortcutBannerItemPresenter shortcutBannerItemPresenter) {
        return new ShortcutBannerBlueprint(shortcutBannerItemPresenter);
    }

    @Override // javax.inject.Provider
    public ShortcutBannerBlueprint get() {
        return newInstance(this.a.get());
    }
}
