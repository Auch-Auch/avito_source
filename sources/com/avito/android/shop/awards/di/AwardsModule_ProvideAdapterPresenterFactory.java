package com.avito.android.shop.awards.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AwardsModule_ProvideAdapterPresenterFactory implements Factory<AdapterPresenter> {
    public final Provider<ItemBinder> a;

    public AwardsModule_ProvideAdapterPresenterFactory(Provider<ItemBinder> provider) {
        this.a = provider;
    }

    public static AwardsModule_ProvideAdapterPresenterFactory create(Provider<ItemBinder> provider) {
        return new AwardsModule_ProvideAdapterPresenterFactory(provider);
    }

    public static AdapterPresenter provideAdapterPresenter(ItemBinder itemBinder) {
        return (AdapterPresenter) Preconditions.checkNotNullFromProvides(AwardsModule.provideAdapterPresenter(itemBinder));
    }

    @Override // javax.inject.Provider
    public AdapterPresenter get() {
        return provideAdapterPresenter(this.a.get());
    }
}
