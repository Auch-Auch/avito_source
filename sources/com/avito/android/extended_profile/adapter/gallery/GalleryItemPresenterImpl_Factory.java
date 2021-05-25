package com.avito.android.extended_profile.adapter.gallery;

import dagger.internal.Factory;
public final class GalleryItemPresenterImpl_Factory implements Factory<GalleryItemPresenterImpl> {

    public static final class a {
        public static final GalleryItemPresenterImpl_Factory a = new GalleryItemPresenterImpl_Factory();
    }

    public static GalleryItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static GalleryItemPresenterImpl newInstance() {
        return new GalleryItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public GalleryItemPresenterImpl get() {
        return newInstance();
    }
}
