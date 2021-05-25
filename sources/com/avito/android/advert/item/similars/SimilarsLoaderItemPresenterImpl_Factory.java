package com.avito.android.advert.item.similars;

import dagger.internal.Factory;
public final class SimilarsLoaderItemPresenterImpl_Factory implements Factory<SimilarsLoaderItemPresenterImpl> {

    public static final class a {
        public static final SimilarsLoaderItemPresenterImpl_Factory a = new SimilarsLoaderItemPresenterImpl_Factory();
    }

    public static SimilarsLoaderItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static SimilarsLoaderItemPresenterImpl newInstance() {
        return new SimilarsLoaderItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public SimilarsLoaderItemPresenterImpl get() {
        return newInstance();
    }
}
