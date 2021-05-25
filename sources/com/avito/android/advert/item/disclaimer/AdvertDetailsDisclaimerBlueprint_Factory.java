package com.avito.android.advert.item.disclaimer;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsDisclaimerBlueprint_Factory implements Factory<AdvertDetailsDisclaimerBlueprint> {
    public final Provider<AdvertDetailsDisclaimerPresenter> a;

    public AdvertDetailsDisclaimerBlueprint_Factory(Provider<AdvertDetailsDisclaimerPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsDisclaimerBlueprint_Factory create(Provider<AdvertDetailsDisclaimerPresenter> provider) {
        return new AdvertDetailsDisclaimerBlueprint_Factory(provider);
    }

    public static AdvertDetailsDisclaimerBlueprint newInstance(AdvertDetailsDisclaimerPresenter advertDetailsDisclaimerPresenter) {
        return new AdvertDetailsDisclaimerBlueprint(advertDetailsDisclaimerPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsDisclaimerBlueprint get() {
        return newInstance(this.a.get());
    }
}
