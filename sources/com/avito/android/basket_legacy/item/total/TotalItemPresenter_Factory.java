package com.avito.android.basket_legacy.item.total;

import dagger.internal.Factory;
public final class TotalItemPresenter_Factory implements Factory<TotalItemPresenter> {

    public static final class a {
        public static final TotalItemPresenter_Factory a = new TotalItemPresenter_Factory();
    }

    public static TotalItemPresenter_Factory create() {
        return a.a;
    }

    public static TotalItemPresenter newInstance() {
        return new TotalItemPresenter();
    }

    @Override // javax.inject.Provider
    public TotalItemPresenter get() {
        return newInstance();
    }
}
