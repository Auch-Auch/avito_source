package com.avito.android.booking.item.picture;

import dagger.internal.Factory;
public final class PictureItemPresenter_Factory implements Factory<PictureItemPresenter> {

    public static final class a {
        public static final PictureItemPresenter_Factory a = new PictureItemPresenter_Factory();
    }

    public static PictureItemPresenter_Factory create() {
        return a.a;
    }

    public static PictureItemPresenter newInstance() {
        return new PictureItemPresenter();
    }

    @Override // javax.inject.Provider
    public PictureItemPresenter get() {
        return newInstance();
    }
}
