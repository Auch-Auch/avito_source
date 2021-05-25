package com.avito.android.advert.item.anonymousnumber;

import dagger.internal.Factory;
public final class AdvertDetailsAnonymousNumberPresenterImpl_Factory implements Factory<AdvertDetailsAnonymousNumberPresenterImpl> {

    public static final class a {
        public static final AdvertDetailsAnonymousNumberPresenterImpl_Factory a = new AdvertDetailsAnonymousNumberPresenterImpl_Factory();
    }

    public static AdvertDetailsAnonymousNumberPresenterImpl_Factory create() {
        return a.a;
    }

    public static AdvertDetailsAnonymousNumberPresenterImpl newInstance() {
        return new AdvertDetailsAnonymousNumberPresenterImpl();
    }

    @Override // javax.inject.Provider
    public AdvertDetailsAnonymousNumberPresenterImpl get() {
        return newInstance();
    }
}
