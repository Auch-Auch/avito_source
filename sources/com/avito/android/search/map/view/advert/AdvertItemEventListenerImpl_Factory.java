package com.avito.android.search.map.view.advert;

import dagger.internal.Factory;
public final class AdvertItemEventListenerImpl_Factory implements Factory<AdvertItemEventListenerImpl> {

    public static final class a {
        public static final AdvertItemEventListenerImpl_Factory a = new AdvertItemEventListenerImpl_Factory();
    }

    public static AdvertItemEventListenerImpl_Factory create() {
        return a.a;
    }

    public static AdvertItemEventListenerImpl newInstance() {
        return new AdvertItemEventListenerImpl();
    }

    @Override // javax.inject.Provider
    public AdvertItemEventListenerImpl get() {
        return newInstance();
    }
}
