package com.avito.android.advert.item.additionalSeller;

import dagger.internal.Factory;
public final class AdditionalSellerPresenterImpl_Factory implements Factory<AdditionalSellerPresenterImpl> {

    public static final class a {
        public static final AdditionalSellerPresenterImpl_Factory a = new AdditionalSellerPresenterImpl_Factory();
    }

    public static AdditionalSellerPresenterImpl_Factory create() {
        return a.a;
    }

    public static AdditionalSellerPresenterImpl newInstance() {
        return new AdditionalSellerPresenterImpl();
    }

    @Override // javax.inject.Provider
    public AdditionalSellerPresenterImpl get() {
        return newInstance();
    }
}
