package com.avito.android.shop.awards.item.title;

import dagger.internal.Factory;
public final class TitleItemPresenter_Factory implements Factory<TitleItemPresenter> {

    public static final class a {
        public static final TitleItemPresenter_Factory a = new TitleItemPresenter_Factory();
    }

    public static TitleItemPresenter_Factory create() {
        return a.a;
    }

    public static TitleItemPresenter newInstance() {
        return new TitleItemPresenter();
    }

    @Override // javax.inject.Provider
    public TitleItemPresenter get() {
        return newInstance();
    }
}
