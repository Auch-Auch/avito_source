package com.avito.android.advert_core.feature_teasers.common.dialog;

import com.avito.android.advert_core.feature_teasers.common.FeatureTeaserResourceProvider;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CommonFeatureTeaserDialogFactory_Factory implements Factory<CommonFeatureTeaserDialogFactory> {
    public final Provider<ItemBinder> a;
    public final Provider<SimpleAdapterPresenter> b;
    public final Provider<FeatureTeaserResourceProvider> c;
    public final Provider<AdvertDetailsFeatureTeaserDialogItemsAdapter> d;

    public CommonFeatureTeaserDialogFactory_Factory(Provider<ItemBinder> provider, Provider<SimpleAdapterPresenter> provider2, Provider<FeatureTeaserResourceProvider> provider3, Provider<AdvertDetailsFeatureTeaserDialogItemsAdapter> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static CommonFeatureTeaserDialogFactory_Factory create(Provider<ItemBinder> provider, Provider<SimpleAdapterPresenter> provider2, Provider<FeatureTeaserResourceProvider> provider3, Provider<AdvertDetailsFeatureTeaserDialogItemsAdapter> provider4) {
        return new CommonFeatureTeaserDialogFactory_Factory(provider, provider2, provider3, provider4);
    }

    public static CommonFeatureTeaserDialogFactory newInstance(ItemBinder itemBinder, SimpleAdapterPresenter simpleAdapterPresenter, FeatureTeaserResourceProvider featureTeaserResourceProvider, AdvertDetailsFeatureTeaserDialogItemsAdapter advertDetailsFeatureTeaserDialogItemsAdapter) {
        return new CommonFeatureTeaserDialogFactory(itemBinder, simpleAdapterPresenter, featureTeaserResourceProvider, advertDetailsFeatureTeaserDialogItemsAdapter);
    }

    @Override // javax.inject.Provider
    public CommonFeatureTeaserDialogFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
