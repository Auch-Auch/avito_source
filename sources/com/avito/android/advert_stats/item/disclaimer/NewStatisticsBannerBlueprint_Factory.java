package com.avito.android.advert_stats.item.disclaimer;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class NewStatisticsBannerBlueprint_Factory implements Factory<NewStatisticsBannerBlueprint> {
    public final Provider<NewStatisticsBannerPresenter> a;

    public NewStatisticsBannerBlueprint_Factory(Provider<NewStatisticsBannerPresenter> provider) {
        this.a = provider;
    }

    public static NewStatisticsBannerBlueprint_Factory create(Provider<NewStatisticsBannerPresenter> provider) {
        return new NewStatisticsBannerBlueprint_Factory(provider);
    }

    public static NewStatisticsBannerBlueprint newInstance(NewStatisticsBannerPresenter newStatisticsBannerPresenter) {
        return new NewStatisticsBannerBlueprint(newStatisticsBannerPresenter);
    }

    @Override // javax.inject.Provider
    public NewStatisticsBannerBlueprint get() {
        return newInstance(this.a.get());
    }
}
