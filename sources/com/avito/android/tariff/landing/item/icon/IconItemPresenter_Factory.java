package com.avito.android.tariff.landing.item.icon;

import dagger.internal.Factory;
public final class IconItemPresenter_Factory implements Factory<IconItemPresenter> {

    public static final class a {
        public static final IconItemPresenter_Factory a = new IconItemPresenter_Factory();
    }

    public static IconItemPresenter_Factory create() {
        return a.a;
    }

    public static IconItemPresenter newInstance() {
        return new IconItemPresenter();
    }

    @Override // javax.inject.Provider
    public IconItemPresenter get() {
        return newInstance();
    }
}
