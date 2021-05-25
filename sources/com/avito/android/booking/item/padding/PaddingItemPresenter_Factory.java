package com.avito.android.booking.item.padding;

import dagger.internal.Factory;
public final class PaddingItemPresenter_Factory implements Factory<PaddingItemPresenter> {

    public static final class a {
        public static final PaddingItemPresenter_Factory a = new PaddingItemPresenter_Factory();
    }

    public static PaddingItemPresenter_Factory create() {
        return a.a;
    }

    public static PaddingItemPresenter newInstance() {
        return new PaddingItemPresenter();
    }

    @Override // javax.inject.Provider
    public PaddingItemPresenter get() {
        return newInstance();
    }
}
