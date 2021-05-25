package com.avito.android.basket.checkout.item.disclaimer;

import dagger.internal.Factory;
public final class CheckoutDisclaimerItemPresenter_Factory implements Factory<CheckoutDisclaimerItemPresenter> {

    public static final class a {
        public static final CheckoutDisclaimerItemPresenter_Factory a = new CheckoutDisclaimerItemPresenter_Factory();
    }

    public static CheckoutDisclaimerItemPresenter_Factory create() {
        return a.a;
    }

    public static CheckoutDisclaimerItemPresenter newInstance() {
        return new CheckoutDisclaimerItemPresenter();
    }

    @Override // javax.inject.Provider
    public CheckoutDisclaimerItemPresenter get() {
        return newInstance();
    }
}
