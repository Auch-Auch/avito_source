package com.avito.android.advert.item.features_teaser;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsFeatureTeaserResourceProvider_Factory implements Factory<AdvertDetailsFeatureTeaserResourceProvider> {
    public final Provider<Resources> a;
    public final Provider<Boolean> b;

    public AdvertDetailsFeatureTeaserResourceProvider_Factory(Provider<Resources> provider, Provider<Boolean> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdvertDetailsFeatureTeaserResourceProvider_Factory create(Provider<Resources> provider, Provider<Boolean> provider2) {
        return new AdvertDetailsFeatureTeaserResourceProvider_Factory(provider, provider2);
    }

    public static AdvertDetailsFeatureTeaserResourceProvider newInstance(Resources resources, boolean z) {
        return new AdvertDetailsFeatureTeaserResourceProvider(resources, z);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsFeatureTeaserResourceProvider get() {
        return newInstance(this.a.get(), this.b.get().booleanValue());
    }
}
