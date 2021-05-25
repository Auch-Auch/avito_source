package com.avito.android.tariff.edit_info.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class EditInfoModule_ProvideTabsDataAwareAdapterFactory implements Factory<AdapterPresenter> {
    public final Provider<ItemBinder> a;

    public EditInfoModule_ProvideTabsDataAwareAdapterFactory(Provider<ItemBinder> provider) {
        this.a = provider;
    }

    public static EditInfoModule_ProvideTabsDataAwareAdapterFactory create(Provider<ItemBinder> provider) {
        return new EditInfoModule_ProvideTabsDataAwareAdapterFactory(provider);
    }

    public static AdapterPresenter provideTabsDataAwareAdapter(ItemBinder itemBinder) {
        return (AdapterPresenter) Preconditions.checkNotNullFromProvides(EditInfoModule.provideTabsDataAwareAdapter(itemBinder));
    }

    @Override // javax.inject.Provider
    public AdapterPresenter get() {
        return provideTabsDataAwareAdapter(this.a.get());
    }
}
