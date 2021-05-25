package com.avito.android.tariff.info.item.disclaimer;

import dagger.internal.Factory;
public final class DisclaimerItemPresenterImpl_Factory implements Factory<DisclaimerItemPresenterImpl> {

    public static final class a {
        public static final DisclaimerItemPresenterImpl_Factory a = new DisclaimerItemPresenterImpl_Factory();
    }

    public static DisclaimerItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static DisclaimerItemPresenterImpl newInstance() {
        return new DisclaimerItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public DisclaimerItemPresenterImpl get() {
        return newInstance();
    }
}
