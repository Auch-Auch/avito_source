package com.avito.android.tariff.edit_info.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class EditInfoModule_ProvideTabsRecyclerAdapterFactory implements Factory<SimpleRecyclerAdapter> {
    public final Provider<AdapterPresenter> a;
    public final Provider<ItemBinder> b;

    public EditInfoModule_ProvideTabsRecyclerAdapterFactory(Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static EditInfoModule_ProvideTabsRecyclerAdapterFactory create(Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2) {
        return new EditInfoModule_ProvideTabsRecyclerAdapterFactory(provider, provider2);
    }

    public static SimpleRecyclerAdapter provideTabsRecyclerAdapter(AdapterPresenter adapterPresenter, ItemBinder itemBinder) {
        return (SimpleRecyclerAdapter) Preconditions.checkNotNullFromProvides(EditInfoModule.provideTabsRecyclerAdapter(adapterPresenter, itemBinder));
    }

    @Override // javax.inject.Provider
    public SimpleRecyclerAdapter get() {
        return provideTabsRecyclerAdapter(this.a.get(), this.b.get());
    }
}
