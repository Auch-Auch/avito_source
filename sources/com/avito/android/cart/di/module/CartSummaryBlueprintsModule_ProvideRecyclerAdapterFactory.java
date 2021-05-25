package com.avito.android.cart.di.module;

import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CartSummaryBlueprintsModule_ProvideRecyclerAdapterFactory implements Factory<SimpleRecyclerAdapter> {
    public final Provider<DataAwareAdapterPresenter> a;
    public final Provider<ItemBinder> b;

    public CartSummaryBlueprintsModule_ProvideRecyclerAdapterFactory(Provider<DataAwareAdapterPresenter> provider, Provider<ItemBinder> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CartSummaryBlueprintsModule_ProvideRecyclerAdapterFactory create(Provider<DataAwareAdapterPresenter> provider, Provider<ItemBinder> provider2) {
        return new CartSummaryBlueprintsModule_ProvideRecyclerAdapterFactory(provider, provider2);
    }

    public static SimpleRecyclerAdapter provideRecyclerAdapter(DataAwareAdapterPresenter dataAwareAdapterPresenter, ItemBinder itemBinder) {
        return (SimpleRecyclerAdapter) Preconditions.checkNotNullFromProvides(CartSummaryBlueprintsModule.INSTANCE.provideRecyclerAdapter(dataAwareAdapterPresenter, itemBinder));
    }

    @Override // javax.inject.Provider
    public SimpleRecyclerAdapter get() {
        return provideRecyclerAdapter(this.a.get(), this.b.get());
    }
}
