package com.avito.android.payment.di.module;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class HistoryDetailsModule_ProviderSimpleRecyclerAdapterFactory implements Factory<SimpleRecyclerAdapter> {
    public final HistoryDetailsModule a;
    public final Provider<AdapterPresenter> b;
    public final Provider<ItemBinder> c;

    public HistoryDetailsModule_ProviderSimpleRecyclerAdapterFactory(HistoryDetailsModule historyDetailsModule, Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2) {
        this.a = historyDetailsModule;
        this.b = provider;
        this.c = provider2;
    }

    public static HistoryDetailsModule_ProviderSimpleRecyclerAdapterFactory create(HistoryDetailsModule historyDetailsModule, Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2) {
        return new HistoryDetailsModule_ProviderSimpleRecyclerAdapterFactory(historyDetailsModule, provider, provider2);
    }

    public static SimpleRecyclerAdapter providerSimpleRecyclerAdapter(HistoryDetailsModule historyDetailsModule, AdapterPresenter adapterPresenter, ItemBinder itemBinder) {
        return (SimpleRecyclerAdapter) Preconditions.checkNotNullFromProvides(historyDetailsModule.providerSimpleRecyclerAdapter(adapterPresenter, itemBinder));
    }

    @Override // javax.inject.Provider
    public SimpleRecyclerAdapter get() {
        return providerSimpleRecyclerAdapter(this.a, this.b.get(), this.c.get());
    }
}
