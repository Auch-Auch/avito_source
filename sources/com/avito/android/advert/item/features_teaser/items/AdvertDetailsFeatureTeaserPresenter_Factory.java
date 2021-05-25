package com.avito.android.advert.item.features_teaser.items;

import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.feature_teasers.common.FeatureTeaserResourceProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsFeatureTeaserPresenter_Factory implements Factory<AdvertDetailsFeatureTeaserPresenter> {
    public final Provider<String> a;
    public final Provider<AdvertDetailsAnalyticsInteractor> b;
    public final Provider<FeatureTeaserResourceProvider> c;

    public AdvertDetailsFeatureTeaserPresenter_Factory(Provider<String> provider, Provider<AdvertDetailsAnalyticsInteractor> provider2, Provider<FeatureTeaserResourceProvider> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AdvertDetailsFeatureTeaserPresenter_Factory create(Provider<String> provider, Provider<AdvertDetailsAnalyticsInteractor> provider2, Provider<FeatureTeaserResourceProvider> provider3) {
        return new AdvertDetailsFeatureTeaserPresenter_Factory(provider, provider2, provider3);
    }

    public static AdvertDetailsFeatureTeaserPresenter newInstance(String str, AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, FeatureTeaserResourceProvider featureTeaserResourceProvider) {
        return new AdvertDetailsFeatureTeaserPresenter(str, advertDetailsAnalyticsInteractor, featureTeaserResourceProvider);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsFeatureTeaserPresenter get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
