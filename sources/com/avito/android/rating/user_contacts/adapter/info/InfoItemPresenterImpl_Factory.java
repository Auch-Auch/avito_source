package com.avito.android.rating.user_contacts.adapter.info;

import dagger.internal.Factory;
public final class InfoItemPresenterImpl_Factory implements Factory<InfoItemPresenterImpl> {

    public static final class a {
        public static final InfoItemPresenterImpl_Factory a = new InfoItemPresenterImpl_Factory();
    }

    public static InfoItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static InfoItemPresenterImpl newInstance() {
        return new InfoItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public InfoItemPresenterImpl get() {
        return newInstance();
    }
}
