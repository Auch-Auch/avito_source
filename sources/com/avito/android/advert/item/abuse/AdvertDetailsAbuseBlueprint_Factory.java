package com.avito.android.advert.item.abuse;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsAbuseBlueprint_Factory implements Factory<AdvertDetailsAbuseBlueprint> {
    public final Provider<AdvertDetailsAbusePresenter> a;

    public AdvertDetailsAbuseBlueprint_Factory(Provider<AdvertDetailsAbusePresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsAbuseBlueprint_Factory create(Provider<AdvertDetailsAbusePresenter> provider) {
        return new AdvertDetailsAbuseBlueprint_Factory(provider);
    }

    public static AdvertDetailsAbuseBlueprint newInstance(AdvertDetailsAbusePresenter advertDetailsAbusePresenter) {
        return new AdvertDetailsAbuseBlueprint(advertDetailsAbusePresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsAbuseBlueprint get() {
        return newInstance(this.a.get());
    }
}
