package com.avito.android.shop.detailed.item;

import dagger.internal.Factory;
public final class AdvertsCountCaptionItemPresenter_Factory implements Factory<AdvertsCountCaptionItemPresenter> {

    public static final class a {
        public static final AdvertsCountCaptionItemPresenter_Factory a = new AdvertsCountCaptionItemPresenter_Factory();
    }

    public static AdvertsCountCaptionItemPresenter_Factory create() {
        return a.a;
    }

    public static AdvertsCountCaptionItemPresenter newInstance() {
        return new AdvertsCountCaptionItemPresenter();
    }

    @Override // javax.inject.Provider
    public AdvertsCountCaptionItemPresenter get() {
        return newInstance();
    }
}
