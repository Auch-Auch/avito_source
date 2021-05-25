package com.avito.android.brandspace.items.wideabout;

import dagger.internal.Factory;
public final class WideAboutItemPresenterImpl_Factory implements Factory<WideAboutItemPresenterImpl> {

    public static final class a {
        public static final WideAboutItemPresenterImpl_Factory a = new WideAboutItemPresenterImpl_Factory();
    }

    public static WideAboutItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static WideAboutItemPresenterImpl newInstance() {
        return new WideAboutItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public WideAboutItemPresenterImpl get() {
        return newInstance();
    }
}
