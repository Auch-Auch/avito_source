package com.avito.android.user_advert.soa_with_price.blueprint;

import dagger.internal.Factory;
public final class CloseReasonItemPresenterImpl_Factory implements Factory<CloseReasonItemPresenterImpl> {

    public static final class a {
        public static final CloseReasonItemPresenterImpl_Factory a = new CloseReasonItemPresenterImpl_Factory();
    }

    public static CloseReasonItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static CloseReasonItemPresenterImpl newInstance() {
        return new CloseReasonItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public CloseReasonItemPresenterImpl get() {
        return newInstance();
    }
}
