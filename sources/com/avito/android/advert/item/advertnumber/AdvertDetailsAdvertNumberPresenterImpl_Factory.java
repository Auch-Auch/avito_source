package com.avito.android.advert.item.advertnumber;

import dagger.internal.Factory;
public final class AdvertDetailsAdvertNumberPresenterImpl_Factory implements Factory<AdvertDetailsAdvertNumberPresenterImpl> {

    public static final class a {
        public static final AdvertDetailsAdvertNumberPresenterImpl_Factory a = new AdvertDetailsAdvertNumberPresenterImpl_Factory();
    }

    public static AdvertDetailsAdvertNumberPresenterImpl_Factory create() {
        return a.a;
    }

    public static AdvertDetailsAdvertNumberPresenterImpl newInstance() {
        return new AdvertDetailsAdvertNumberPresenterImpl();
    }

    @Override // javax.inject.Provider
    public AdvertDetailsAdvertNumberPresenterImpl get() {
        return newInstance();
    }
}
