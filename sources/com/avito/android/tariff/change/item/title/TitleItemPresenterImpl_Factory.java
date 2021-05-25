package com.avito.android.tariff.change.item.title;

import dagger.internal.Factory;
public final class TitleItemPresenterImpl_Factory implements Factory<TitleItemPresenterImpl> {

    public static final class a {
        public static final TitleItemPresenterImpl_Factory a = new TitleItemPresenterImpl_Factory();
    }

    public static TitleItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static TitleItemPresenterImpl newInstance() {
        return new TitleItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public TitleItemPresenterImpl get() {
        return newInstance();
    }
}
