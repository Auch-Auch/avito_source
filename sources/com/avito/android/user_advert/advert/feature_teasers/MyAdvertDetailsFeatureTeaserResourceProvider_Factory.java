package com.avito.android.user_advert.advert.feature_teasers;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MyAdvertDetailsFeatureTeaserResourceProvider_Factory implements Factory<MyAdvertDetailsFeatureTeaserResourceProvider> {
    public final Provider<Resources> a;

    public MyAdvertDetailsFeatureTeaserResourceProvider_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static MyAdvertDetailsFeatureTeaserResourceProvider_Factory create(Provider<Resources> provider) {
        return new MyAdvertDetailsFeatureTeaserResourceProvider_Factory(provider);
    }

    public static MyAdvertDetailsFeatureTeaserResourceProvider newInstance(Resources resources) {
        return new MyAdvertDetailsFeatureTeaserResourceProvider(resources);
    }

    @Override // javax.inject.Provider
    public MyAdvertDetailsFeatureTeaserResourceProvider get() {
        return newInstance(this.a.get());
    }
}
