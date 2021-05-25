package com.avito.android.safedeal.delivery_courier.summary.konveyor.image;

import dagger.internal.Factory;
public final class ImageItemPresenter_Factory implements Factory<ImageItemPresenter> {

    public static final class a {
        public static final ImageItemPresenter_Factory a = new ImageItemPresenter_Factory();
    }

    public static ImageItemPresenter_Factory create() {
        return a.a;
    }

    public static ImageItemPresenter newInstance() {
        return new ImageItemPresenter();
    }

    @Override // javax.inject.Provider
    public ImageItemPresenter get() {
        return newInstance();
    }
}
