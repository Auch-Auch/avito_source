package com.avito.android.tariff.landing.item.icon;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class IconItemBlueprint_Factory implements Factory<IconItemBlueprint> {
    public final Provider<IconItemPresenter> a;

    public IconItemBlueprint_Factory(Provider<IconItemPresenter> provider) {
        this.a = provider;
    }

    public static IconItemBlueprint_Factory create(Provider<IconItemPresenter> provider) {
        return new IconItemBlueprint_Factory(provider);
    }

    public static IconItemBlueprint newInstance(IconItemPresenter iconItemPresenter) {
        return new IconItemBlueprint(iconItemPresenter);
    }

    @Override // javax.inject.Provider
    public IconItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
