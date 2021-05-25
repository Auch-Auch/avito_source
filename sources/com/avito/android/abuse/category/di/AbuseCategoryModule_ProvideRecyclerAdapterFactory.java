package com.avito.android.abuse.category.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbuseCategoryModule_ProvideRecyclerAdapterFactory implements Factory<SimpleRecyclerAdapter> {
    public final Provider<AdapterPresenter> a;
    public final Provider<ItemBinder> b;

    public AbuseCategoryModule_ProvideRecyclerAdapterFactory(Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AbuseCategoryModule_ProvideRecyclerAdapterFactory create(Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2) {
        return new AbuseCategoryModule_ProvideRecyclerAdapterFactory(provider, provider2);
    }

    public static SimpleRecyclerAdapter provideRecyclerAdapter(AdapterPresenter adapterPresenter, ItemBinder itemBinder) {
        return (SimpleRecyclerAdapter) Preconditions.checkNotNullFromProvides(AbuseCategoryModule.provideRecyclerAdapter(adapterPresenter, itemBinder));
    }

    @Override // javax.inject.Provider
    public SimpleRecyclerAdapter get() {
        return provideRecyclerAdapter(this.a.get(), this.b.get());
    }
}
