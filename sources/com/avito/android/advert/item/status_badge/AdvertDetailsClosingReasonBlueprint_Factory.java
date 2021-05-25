package com.avito.android.advert.item.status_badge;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsClosingReasonBlueprint_Factory implements Factory<AdvertDetailsClosingReasonBlueprint> {
    public final Provider<AdvertDetailsClosingReasonPresenter> a;

    public AdvertDetailsClosingReasonBlueprint_Factory(Provider<AdvertDetailsClosingReasonPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsClosingReasonBlueprint_Factory create(Provider<AdvertDetailsClosingReasonPresenter> provider) {
        return new AdvertDetailsClosingReasonBlueprint_Factory(provider);
    }

    public static AdvertDetailsClosingReasonBlueprint newInstance(AdvertDetailsClosingReasonPresenter advertDetailsClosingReasonPresenter) {
        return new AdvertDetailsClosingReasonBlueprint(advertDetailsClosingReasonPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsClosingReasonBlueprint get() {
        return newInstance(this.a.get());
    }
}
