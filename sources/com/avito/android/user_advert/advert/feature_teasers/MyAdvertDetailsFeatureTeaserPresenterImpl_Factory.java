package com.avito.android.user_advert.advert.feature_teasers;

import com.avito.android.advert_core.feature_teasers.common.AdvertDetailsFeatureTeaserItemsAdapter;
import com.avito.android.advert_core.feature_teasers.common.FeatureTeaserPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MyAdvertDetailsFeatureTeaserPresenterImpl_Factory implements Factory<MyAdvertDetailsFeatureTeaserPresenterImpl> {
    public final Provider<FeatureTeaserPresenter> a;
    public final Provider<AdvertDetailsFeatureTeaserItemsAdapter> b;

    public MyAdvertDetailsFeatureTeaserPresenterImpl_Factory(Provider<FeatureTeaserPresenter> provider, Provider<AdvertDetailsFeatureTeaserItemsAdapter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MyAdvertDetailsFeatureTeaserPresenterImpl_Factory create(Provider<FeatureTeaserPresenter> provider, Provider<AdvertDetailsFeatureTeaserItemsAdapter> provider2) {
        return new MyAdvertDetailsFeatureTeaserPresenterImpl_Factory(provider, provider2);
    }

    public static MyAdvertDetailsFeatureTeaserPresenterImpl newInstance(FeatureTeaserPresenter featureTeaserPresenter, AdvertDetailsFeatureTeaserItemsAdapter advertDetailsFeatureTeaserItemsAdapter) {
        return new MyAdvertDetailsFeatureTeaserPresenterImpl(featureTeaserPresenter, advertDetailsFeatureTeaserItemsAdapter);
    }

    @Override // javax.inject.Provider
    public MyAdvertDetailsFeatureTeaserPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
