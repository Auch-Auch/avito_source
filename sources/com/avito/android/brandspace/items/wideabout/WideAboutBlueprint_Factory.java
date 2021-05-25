package com.avito.android.brandspace.items.wideabout;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class WideAboutBlueprint_Factory implements Factory<WideAboutBlueprint> {
    public final Provider<WideAboutItemPresenter> a;

    public WideAboutBlueprint_Factory(Provider<WideAboutItemPresenter> provider) {
        this.a = provider;
    }

    public static WideAboutBlueprint_Factory create(Provider<WideAboutItemPresenter> provider) {
        return new WideAboutBlueprint_Factory(provider);
    }

    public static WideAboutBlueprint newInstance(WideAboutItemPresenter wideAboutItemPresenter) {
        return new WideAboutBlueprint(wideAboutItemPresenter);
    }

    @Override // javax.inject.Provider
    public WideAboutBlueprint get() {
        return newInstance(this.a.get());
    }
}
