package com.avito.android.advert.item.rating_publish;

import dagger.internal.Factory;
public final class AdvertDetailsRatingPublishPresenterImpl_Factory implements Factory<AdvertDetailsRatingPublishPresenterImpl> {

    public static final class a {
        public static final AdvertDetailsRatingPublishPresenterImpl_Factory a = new AdvertDetailsRatingPublishPresenterImpl_Factory();
    }

    public static AdvertDetailsRatingPublishPresenterImpl_Factory create() {
        return a.a;
    }

    public static AdvertDetailsRatingPublishPresenterImpl newInstance() {
        return new AdvertDetailsRatingPublishPresenterImpl();
    }

    @Override // javax.inject.Provider
    public AdvertDetailsRatingPublishPresenterImpl get() {
        return newInstance();
    }
}
