package com.avito.android.booking.item.subtitle;

import dagger.internal.Factory;
public final class SubtitleItemPresenter_Factory implements Factory<SubtitleItemPresenter> {

    public static final class a {
        public static final SubtitleItemPresenter_Factory a = new SubtitleItemPresenter_Factory();
    }

    public static SubtitleItemPresenter_Factory create() {
        return a.a;
    }

    public static SubtitleItemPresenter newInstance() {
        return new SubtitleItemPresenter();
    }

    @Override // javax.inject.Provider
    public SubtitleItemPresenter get() {
        return newInstance();
    }
}
