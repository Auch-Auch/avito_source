package com.avito.android.advert_core.gap;

import dagger.internal.Factory;
public final class AdvertDetailsGapPresenterImpl_Factory implements Factory<AdvertDetailsGapPresenterImpl> {

    public static final class a {
        public static final AdvertDetailsGapPresenterImpl_Factory a = new AdvertDetailsGapPresenterImpl_Factory();
    }

    public static AdvertDetailsGapPresenterImpl_Factory create() {
        return a.a;
    }

    public static AdvertDetailsGapPresenterImpl newInstance() {
        return new AdvertDetailsGapPresenterImpl();
    }

    @Override // javax.inject.Provider
    public AdvertDetailsGapPresenterImpl get() {
        return newInstance();
    }
}
