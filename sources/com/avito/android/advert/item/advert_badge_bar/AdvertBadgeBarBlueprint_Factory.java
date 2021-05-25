package com.avito.android.advert.item.advert_badge_bar;

import com.avito.android.advert_core.advert_badge_bar.AdvertBadgeBarPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertBadgeBarBlueprint_Factory implements Factory<AdvertBadgeBarBlueprint> {
    public final Provider<AdvertBadgeBarPresenter> a;

    public AdvertBadgeBarBlueprint_Factory(Provider<AdvertBadgeBarPresenter> provider) {
        this.a = provider;
    }

    public static AdvertBadgeBarBlueprint_Factory create(Provider<AdvertBadgeBarPresenter> provider) {
        return new AdvertBadgeBarBlueprint_Factory(provider);
    }

    public static AdvertBadgeBarBlueprint newInstance(AdvertBadgeBarPresenter advertBadgeBarPresenter) {
        return new AdvertBadgeBarBlueprint(advertBadgeBarPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertBadgeBarBlueprint get() {
        return newInstance(this.a.get());
    }
}
