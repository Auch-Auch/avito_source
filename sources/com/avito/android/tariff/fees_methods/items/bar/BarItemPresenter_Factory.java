package com.avito.android.tariff.fees_methods.items.bar;

import dagger.internal.Factory;
public final class BarItemPresenter_Factory implements Factory<BarItemPresenter> {

    public static final class a {
        public static final BarItemPresenter_Factory a = new BarItemPresenter_Factory();
    }

    public static BarItemPresenter_Factory create() {
        return a.a;
    }

    public static BarItemPresenter newInstance() {
        return new BarItemPresenter();
    }

    @Override // javax.inject.Provider
    public BarItemPresenter get() {
        return newInstance();
    }
}
