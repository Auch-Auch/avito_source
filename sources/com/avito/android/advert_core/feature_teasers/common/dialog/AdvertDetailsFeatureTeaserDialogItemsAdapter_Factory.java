package com.avito.android.advert_core.feature_teasers.common.dialog;

import com.avito.android.IdProvider;
import com.avito.android.advert_core.feature_teasers.common.FeatureTeaserResourceProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsFeatureTeaserDialogItemsAdapter_Factory implements Factory<AdvertDetailsFeatureTeaserDialogItemsAdapter> {
    public final Provider<FeatureTeaserResourceProvider> a;
    public final Provider<IdProvider> b;

    public AdvertDetailsFeatureTeaserDialogItemsAdapter_Factory(Provider<FeatureTeaserResourceProvider> provider, Provider<IdProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdvertDetailsFeatureTeaserDialogItemsAdapter_Factory create(Provider<FeatureTeaserResourceProvider> provider, Provider<IdProvider> provider2) {
        return new AdvertDetailsFeatureTeaserDialogItemsAdapter_Factory(provider, provider2);
    }

    public static AdvertDetailsFeatureTeaserDialogItemsAdapter newInstance(FeatureTeaserResourceProvider featureTeaserResourceProvider, IdProvider idProvider) {
        return new AdvertDetailsFeatureTeaserDialogItemsAdapter(featureTeaserResourceProvider, idProvider);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsFeatureTeaserDialogItemsAdapter get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
