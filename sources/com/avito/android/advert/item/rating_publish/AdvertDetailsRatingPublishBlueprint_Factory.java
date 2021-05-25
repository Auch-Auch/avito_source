package com.avito.android.advert.item.rating_publish;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsRatingPublishBlueprint_Factory implements Factory<AdvertDetailsRatingPublishBlueprint> {
    public final Provider<AdvertDetailsRatingPublishPresenter> a;

    public AdvertDetailsRatingPublishBlueprint_Factory(Provider<AdvertDetailsRatingPublishPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsRatingPublishBlueprint_Factory create(Provider<AdvertDetailsRatingPublishPresenter> provider) {
        return new AdvertDetailsRatingPublishBlueprint_Factory(provider);
    }

    public static AdvertDetailsRatingPublishBlueprint newInstance(AdvertDetailsRatingPublishPresenter advertDetailsRatingPublishPresenter) {
        return new AdvertDetailsRatingPublishBlueprint(advertDetailsRatingPublishPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsRatingPublishBlueprint get() {
        return newInstance(this.a.get());
    }
}
