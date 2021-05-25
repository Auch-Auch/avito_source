package com.avito.android.user_advert.advert.feature_teasers;

import com.avito.android.advert_core.feature_teasers.common.FeatureTeaserResourceProvider;
import com.avito.android.advert_core.feature_teasers.common.dialog.FeatureTeaserDialogFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MyAdvertDetailsFeatureTeaserViewFactory_Factory implements Factory<MyAdvertDetailsFeatureTeaserViewFactory> {
    public final Provider<FeatureTeaserResourceProvider> a;
    public final Provider<FeatureTeaserDialogFactory> b;

    public MyAdvertDetailsFeatureTeaserViewFactory_Factory(Provider<FeatureTeaserResourceProvider> provider, Provider<FeatureTeaserDialogFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MyAdvertDetailsFeatureTeaserViewFactory_Factory create(Provider<FeatureTeaserResourceProvider> provider, Provider<FeatureTeaserDialogFactory> provider2) {
        return new MyAdvertDetailsFeatureTeaserViewFactory_Factory(provider, provider2);
    }

    public static MyAdvertDetailsFeatureTeaserViewFactory newInstance(FeatureTeaserResourceProvider featureTeaserResourceProvider, FeatureTeaserDialogFactory featureTeaserDialogFactory) {
        return new MyAdvertDetailsFeatureTeaserViewFactory(featureTeaserResourceProvider, featureTeaserDialogFactory);
    }

    @Override // javax.inject.Provider
    public MyAdvertDetailsFeatureTeaserViewFactory get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
