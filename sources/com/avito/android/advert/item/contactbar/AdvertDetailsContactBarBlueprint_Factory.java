package com.avito.android.advert.item.contactbar;

import com.avito.android.Features;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsContactBarBlueprint_Factory implements Factory<AdvertDetailsContactBarBlueprint> {
    public final Provider<AdvertDetailsContactBarPresenter> a;
    public final Provider<Features> b;

    public AdvertDetailsContactBarBlueprint_Factory(Provider<AdvertDetailsContactBarPresenter> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdvertDetailsContactBarBlueprint_Factory create(Provider<AdvertDetailsContactBarPresenter> provider, Provider<Features> provider2) {
        return new AdvertDetailsContactBarBlueprint_Factory(provider, provider2);
    }

    public static AdvertDetailsContactBarBlueprint newInstance(AdvertDetailsContactBarPresenter advertDetailsContactBarPresenter, Features features) {
        return new AdvertDetailsContactBarBlueprint(advertDetailsContactBarPresenter, features);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsContactBarBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
