package com.avito.android.abuse.details.adapter;

import dagger.internal.Factory;
public final class SendingSuccessItemPresenterImpl_Factory implements Factory<SendingSuccessItemPresenterImpl> {

    public static final class a {
        public static final SendingSuccessItemPresenterImpl_Factory a = new SendingSuccessItemPresenterImpl_Factory();
    }

    public static SendingSuccessItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static SendingSuccessItemPresenterImpl newInstance() {
        return new SendingSuccessItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public SendingSuccessItemPresenterImpl get() {
        return newInstance();
    }
}
