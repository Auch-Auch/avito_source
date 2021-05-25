package com.avito.android.payment.di.module;

import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class TopUpFormModule_ProvideRecyclerAdapterFactory implements Factory<SimpleRecyclerAdapter> {
    public final TopUpFormModule a;
    public final Provider<DataAwareAdapterPresenter> b;
    public final Provider<ItemBinder> c;

    public TopUpFormModule_ProvideRecyclerAdapterFactory(TopUpFormModule topUpFormModule, Provider<DataAwareAdapterPresenter> provider, Provider<ItemBinder> provider2) {
        this.a = topUpFormModule;
        this.b = provider;
        this.c = provider2;
    }

    public static TopUpFormModule_ProvideRecyclerAdapterFactory create(TopUpFormModule topUpFormModule, Provider<DataAwareAdapterPresenter> provider, Provider<ItemBinder> provider2) {
        return new TopUpFormModule_ProvideRecyclerAdapterFactory(topUpFormModule, provider, provider2);
    }

    public static SimpleRecyclerAdapter provideRecyclerAdapter(TopUpFormModule topUpFormModule, DataAwareAdapterPresenter dataAwareAdapterPresenter, ItemBinder itemBinder) {
        return (SimpleRecyclerAdapter) Preconditions.checkNotNullFromProvides(topUpFormModule.provideRecyclerAdapter(dataAwareAdapterPresenter, itemBinder));
    }

    @Override // javax.inject.Provider
    public SimpleRecyclerAdapter get() {
        return provideRecyclerAdapter(this.a, this.b.get(), this.c.get());
    }
}
