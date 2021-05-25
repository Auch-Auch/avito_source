package com.avito.android.publish.select.di;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SelectModule_ProvideAdapterFactory implements Factory<RecyclerView.Adapter<?>> {
    public final SelectModule a;
    public final Provider<AdapterPresenter> b;
    public final Provider<ItemBinder> c;

    public SelectModule_ProvideAdapterFactory(SelectModule selectModule, Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2) {
        this.a = selectModule;
        this.b = provider;
        this.c = provider2;
    }

    public static SelectModule_ProvideAdapterFactory create(SelectModule selectModule, Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2) {
        return new SelectModule_ProvideAdapterFactory(selectModule, provider, provider2);
    }

    public static RecyclerView.Adapter<?> provideAdapter(SelectModule selectModule, AdapterPresenter adapterPresenter, ItemBinder itemBinder) {
        return (RecyclerView.Adapter) Preconditions.checkNotNullFromProvides(selectModule.provideAdapter(adapterPresenter, itemBinder));
    }

    @Override // javax.inject.Provider
    public RecyclerView.Adapter<?> get() {
        return provideAdapter(this.a, this.b.get(), this.c.get());
    }
}
