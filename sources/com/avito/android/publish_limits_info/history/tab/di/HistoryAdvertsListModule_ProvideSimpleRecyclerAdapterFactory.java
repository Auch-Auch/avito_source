package com.avito.android.publish_limits_info.history.tab.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class HistoryAdvertsListModule_ProvideSimpleRecyclerAdapterFactory implements Factory<SimpleRecyclerAdapter> {
    public final Provider<AdapterPresenter> a;
    public final Provider<ItemBinder> b;

    public HistoryAdvertsListModule_ProvideSimpleRecyclerAdapterFactory(Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static HistoryAdvertsListModule_ProvideSimpleRecyclerAdapterFactory create(Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2) {
        return new HistoryAdvertsListModule_ProvideSimpleRecyclerAdapterFactory(provider, provider2);
    }

    public static SimpleRecyclerAdapter provideSimpleRecyclerAdapter(AdapterPresenter adapterPresenter, ItemBinder itemBinder) {
        return (SimpleRecyclerAdapter) Preconditions.checkNotNullFromProvides(HistoryAdvertsListModule.provideSimpleRecyclerAdapter(adapterPresenter, itemBinder));
    }

    @Override // javax.inject.Provider
    public SimpleRecyclerAdapter get() {
        return provideSimpleRecyclerAdapter(this.a.get(), this.b.get());
    }
}
