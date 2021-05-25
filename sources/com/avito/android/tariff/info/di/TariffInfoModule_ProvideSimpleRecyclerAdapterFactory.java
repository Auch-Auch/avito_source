package com.avito.android.tariff.info.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class TariffInfoModule_ProvideSimpleRecyclerAdapterFactory implements Factory<SimpleRecyclerAdapter> {
    public final Provider<AdapterPresenter> a;
    public final Provider<ItemBinder> b;

    public TariffInfoModule_ProvideSimpleRecyclerAdapterFactory(Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static TariffInfoModule_ProvideSimpleRecyclerAdapterFactory create(Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2) {
        return new TariffInfoModule_ProvideSimpleRecyclerAdapterFactory(provider, provider2);
    }

    public static SimpleRecyclerAdapter provideSimpleRecyclerAdapter(AdapterPresenter adapterPresenter, ItemBinder itemBinder) {
        return (SimpleRecyclerAdapter) Preconditions.checkNotNullFromProvides(TariffInfoModule.provideSimpleRecyclerAdapter(adapterPresenter, itemBinder));
    }

    @Override // javax.inject.Provider
    public SimpleRecyclerAdapter get() {
        return provideSimpleRecyclerAdapter(this.a.get(), this.b.get());
    }
}
