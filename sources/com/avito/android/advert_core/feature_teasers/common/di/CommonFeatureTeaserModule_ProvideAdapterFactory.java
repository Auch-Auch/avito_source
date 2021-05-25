package com.avito.android.advert_core.feature_teasers.common.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CommonFeatureTeaserModule_ProvideAdapterFactory implements Factory<SimpleAdapterPresenter> {
    public final Provider<ItemBinder> a;

    public CommonFeatureTeaserModule_ProvideAdapterFactory(Provider<ItemBinder> provider) {
        this.a = provider;
    }

    public static CommonFeatureTeaserModule_ProvideAdapterFactory create(Provider<ItemBinder> provider) {
        return new CommonFeatureTeaserModule_ProvideAdapterFactory(provider);
    }

    public static SimpleAdapterPresenter provideAdapter(ItemBinder itemBinder) {
        return (SimpleAdapterPresenter) Preconditions.checkNotNullFromProvides(CommonFeatureTeaserModule.provideAdapter(itemBinder));
    }

    @Override // javax.inject.Provider
    public SimpleAdapterPresenter get() {
        return provideAdapter(this.a.get());
    }
}
