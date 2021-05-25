package com.avito.android.advert.item.flats;

import com.avito.android.advert_core.advert.AdvertDetailsFlatsListener;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsFlatsBlueprint_Factory implements Factory<AdvertDetailsFlatsBlueprint> {
    public final Provider<AdvertDetailsFlatsPresenter> a;
    public final Provider<AdvertDetailsFlatsListener> b;

    public AdvertDetailsFlatsBlueprint_Factory(Provider<AdvertDetailsFlatsPresenter> provider, Provider<AdvertDetailsFlatsListener> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdvertDetailsFlatsBlueprint_Factory create(Provider<AdvertDetailsFlatsPresenter> provider, Provider<AdvertDetailsFlatsListener> provider2) {
        return new AdvertDetailsFlatsBlueprint_Factory(provider, provider2);
    }

    public static AdvertDetailsFlatsBlueprint newInstance(AdvertDetailsFlatsPresenter advertDetailsFlatsPresenter, AdvertDetailsFlatsListener advertDetailsFlatsListener) {
        return new AdvertDetailsFlatsBlueprint(advertDetailsFlatsPresenter, advertDetailsFlatsListener);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsFlatsBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
