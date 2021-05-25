package com.avito.android.tariff.fees_methods.items.description;

import dagger.internal.Factory;
public final class FeeDescriptionItemPresenter_Factory implements Factory<FeeDescriptionItemPresenter> {

    public static final class a {
        public static final FeeDescriptionItemPresenter_Factory a = new FeeDescriptionItemPresenter_Factory();
    }

    public static FeeDescriptionItemPresenter_Factory create() {
        return a.a;
    }

    public static FeeDescriptionItemPresenter newInstance() {
        return new FeeDescriptionItemPresenter();
    }

    @Override // javax.inject.Provider
    public FeeDescriptionItemPresenter get() {
        return newInstance();
    }
}
