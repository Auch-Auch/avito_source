package com.avito.android.tariff.fees_methods.items;

import dagger.internal.Factory;
public final class FeeMethodPresenter_Factory implements Factory<FeeMethodPresenter> {

    public static final class a {
        public static final FeeMethodPresenter_Factory a = new FeeMethodPresenter_Factory();
    }

    public static FeeMethodPresenter_Factory create() {
        return a.a;
    }

    public static FeeMethodPresenter newInstance() {
        return new FeeMethodPresenter();
    }

    @Override // javax.inject.Provider
    public FeeMethodPresenter get() {
        return newInstance();
    }
}
