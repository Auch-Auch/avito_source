package com.avito.android.advert.item.advertnumber;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsAdvertNumberBlueprint_Factory implements Factory<AdvertDetailsAdvertNumberBlueprint> {
    public final Provider<AdvertDetailsAdvertNumberPresenter> a;

    public AdvertDetailsAdvertNumberBlueprint_Factory(Provider<AdvertDetailsAdvertNumberPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsAdvertNumberBlueprint_Factory create(Provider<AdvertDetailsAdvertNumberPresenter> provider) {
        return new AdvertDetailsAdvertNumberBlueprint_Factory(provider);
    }

    public static AdvertDetailsAdvertNumberBlueprint newInstance(AdvertDetailsAdvertNumberPresenter advertDetailsAdvertNumberPresenter) {
        return new AdvertDetailsAdvertNumberBlueprint(advertDetailsAdvertNumberPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsAdvertNumberBlueprint get() {
        return newInstance(this.a.get());
    }
}
