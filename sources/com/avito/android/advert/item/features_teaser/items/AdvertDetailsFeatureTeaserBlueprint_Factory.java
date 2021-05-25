package com.avito.android.advert.item.features_teaser.items;

import com.avito.android.advert.item.features_teaser.AdvertDetailsFeatureTeaserResourceProvider;
import com.avito.android.advert_core.feature_teasers.common.dialog.FeatureTeaserDialogFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsFeatureTeaserBlueprint_Factory implements Factory<AdvertDetailsFeatureTeaserBlueprint> {
    public final Provider<AdvertDetailsFeatureTeaserPresenter> a;
    public final Provider<FeatureTeaserDialogFactory> b;
    public final Provider<AdvertDetailsFeatureTeaserResourceProvider> c;

    public AdvertDetailsFeatureTeaserBlueprint_Factory(Provider<AdvertDetailsFeatureTeaserPresenter> provider, Provider<FeatureTeaserDialogFactory> provider2, Provider<AdvertDetailsFeatureTeaserResourceProvider> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AdvertDetailsFeatureTeaserBlueprint_Factory create(Provider<AdvertDetailsFeatureTeaserPresenter> provider, Provider<FeatureTeaserDialogFactory> provider2, Provider<AdvertDetailsFeatureTeaserResourceProvider> provider3) {
        return new AdvertDetailsFeatureTeaserBlueprint_Factory(provider, provider2, provider3);
    }

    public static AdvertDetailsFeatureTeaserBlueprint newInstance(AdvertDetailsFeatureTeaserPresenter advertDetailsFeatureTeaserPresenter, FeatureTeaserDialogFactory featureTeaserDialogFactory, AdvertDetailsFeatureTeaserResourceProvider advertDetailsFeatureTeaserResourceProvider) {
        return new AdvertDetailsFeatureTeaserBlueprint(advertDetailsFeatureTeaserPresenter, featureTeaserDialogFactory, advertDetailsFeatureTeaserResourceProvider);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsFeatureTeaserBlueprint get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
