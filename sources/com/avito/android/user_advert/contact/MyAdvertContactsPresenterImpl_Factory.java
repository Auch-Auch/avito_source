package com.avito.android.user_advert.contact;

import dagger.internal.Factory;
public final class MyAdvertContactsPresenterImpl_Factory implements Factory<MyAdvertContactsPresenterImpl> {

    public static final class a {
        public static final MyAdvertContactsPresenterImpl_Factory a = new MyAdvertContactsPresenterImpl_Factory();
    }

    public static MyAdvertContactsPresenterImpl_Factory create() {
        return a.a;
    }

    public static MyAdvertContactsPresenterImpl newInstance() {
        return new MyAdvertContactsPresenterImpl();
    }

    @Override // javax.inject.Provider
    public MyAdvertContactsPresenterImpl get() {
        return newInstance();
    }
}
