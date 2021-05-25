package com.avito.android.conveyor_shared_item.bottom_sheet.title;

import dagger.internal.Factory;
public final class TitlePresenter_Factory implements Factory<TitlePresenter> {

    public static final class a {
        public static final TitlePresenter_Factory a = new TitlePresenter_Factory();
    }

    public static TitlePresenter_Factory create() {
        return a.a;
    }

    public static TitlePresenter newInstance() {
        return new TitlePresenter();
    }

    @Override // javax.inject.Provider
    public TitlePresenter get() {
        return newInstance();
    }
}
