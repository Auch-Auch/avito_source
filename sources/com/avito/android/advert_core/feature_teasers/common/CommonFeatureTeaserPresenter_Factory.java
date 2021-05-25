package com.avito.android.advert_core.feature_teasers.common;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class CommonFeatureTeaserPresenter_Factory implements Factory<CommonFeatureTeaserPresenter> {
    public final Provider<FeatureTeaserResourceProvider> a;

    public CommonFeatureTeaserPresenter_Factory(Provider<FeatureTeaserResourceProvider> provider) {
        this.a = provider;
    }

    public static CommonFeatureTeaserPresenter_Factory create(Provider<FeatureTeaserResourceProvider> provider) {
        return new CommonFeatureTeaserPresenter_Factory(provider);
    }

    public static CommonFeatureTeaserPresenter newInstance(FeatureTeaserResourceProvider featureTeaserResourceProvider) {
        return new CommonFeatureTeaserPresenter(featureTeaserResourceProvider);
    }

    @Override // javax.inject.Provider
    public CommonFeatureTeaserPresenter get() {
        return newInstance(this.a.get());
    }
}
