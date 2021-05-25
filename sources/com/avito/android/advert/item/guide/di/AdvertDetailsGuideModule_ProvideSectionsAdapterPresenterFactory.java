package com.avito.android.advert.item.guide.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AdvertDetailsGuideModule_ProvideSectionsAdapterPresenterFactory implements Factory<AdapterPresenter> {
    public final Provider<ItemBinder> a;

    public AdvertDetailsGuideModule_ProvideSectionsAdapterPresenterFactory(Provider<ItemBinder> provider) {
        this.a = provider;
    }

    public static AdvertDetailsGuideModule_ProvideSectionsAdapterPresenterFactory create(Provider<ItemBinder> provider) {
        return new AdvertDetailsGuideModule_ProvideSectionsAdapterPresenterFactory(provider);
    }

    public static AdapterPresenter provideSectionsAdapterPresenter(ItemBinder itemBinder) {
        return (AdapterPresenter) Preconditions.checkNotNullFromProvides(AdvertDetailsGuideModule.INSTANCE.provideSectionsAdapterPresenter(itemBinder));
    }

    @Override // javax.inject.Provider
    public AdapterPresenter get() {
        return provideSectionsAdapterPresenter(this.a.get());
    }
}
