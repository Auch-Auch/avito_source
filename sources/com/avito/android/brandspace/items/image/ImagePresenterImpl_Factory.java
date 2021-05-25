package com.avito.android.brandspace.items.image;

import dagger.internal.Factory;
public final class ImagePresenterImpl_Factory implements Factory<ImagePresenterImpl> {

    public static final class a {
        public static final ImagePresenterImpl_Factory a = new ImagePresenterImpl_Factory();
    }

    public static ImagePresenterImpl_Factory create() {
        return a.a;
    }

    public static ImagePresenterImpl newInstance() {
        return new ImagePresenterImpl();
    }

    @Override // javax.inject.Provider
    public ImagePresenterImpl get() {
        return newInstance();
    }
}
