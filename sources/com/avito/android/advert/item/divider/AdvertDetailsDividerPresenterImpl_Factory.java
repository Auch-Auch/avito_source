package com.avito.android.advert.item.divider;

import dagger.internal.Factory;
public final class AdvertDetailsDividerPresenterImpl_Factory implements Factory<AdvertDetailsDividerPresenterImpl> {

    public static final class a {
        public static final AdvertDetailsDividerPresenterImpl_Factory a = new AdvertDetailsDividerPresenterImpl_Factory();
    }

    public static AdvertDetailsDividerPresenterImpl_Factory create() {
        return a.a;
    }

    public static AdvertDetailsDividerPresenterImpl newInstance() {
        return new AdvertDetailsDividerPresenterImpl();
    }

    @Override // javax.inject.Provider
    public AdvertDetailsDividerPresenterImpl get() {
        return newInstance();
    }
}
