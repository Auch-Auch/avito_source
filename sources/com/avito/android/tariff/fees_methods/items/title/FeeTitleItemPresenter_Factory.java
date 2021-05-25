package com.avito.android.tariff.fees_methods.items.title;

import dagger.internal.Factory;
public final class FeeTitleItemPresenter_Factory implements Factory<FeeTitleItemPresenter> {

    public static final class a {
        public static final FeeTitleItemPresenter_Factory a = new FeeTitleItemPresenter_Factory();
    }

    public static FeeTitleItemPresenter_Factory create() {
        return a.a;
    }

    public static FeeTitleItemPresenter newInstance() {
        return new FeeTitleItemPresenter();
    }

    @Override // javax.inject.Provider
    public FeeTitleItemPresenter get() {
        return newInstance();
    }
}
