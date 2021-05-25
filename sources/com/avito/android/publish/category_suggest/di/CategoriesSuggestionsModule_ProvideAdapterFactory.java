package com.avito.android.publish.category_suggest.di;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class CategoriesSuggestionsModule_ProvideAdapterFactory implements Factory<RecyclerView.Adapter<?>> {
    public final CategoriesSuggestionsModule a;
    public final Provider<AdapterPresenter> b;
    public final Provider<ItemBinder> c;

    public CategoriesSuggestionsModule_ProvideAdapterFactory(CategoriesSuggestionsModule categoriesSuggestionsModule, Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2) {
        this.a = categoriesSuggestionsModule;
        this.b = provider;
        this.c = provider2;
    }

    public static CategoriesSuggestionsModule_ProvideAdapterFactory create(CategoriesSuggestionsModule categoriesSuggestionsModule, Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2) {
        return new CategoriesSuggestionsModule_ProvideAdapterFactory(categoriesSuggestionsModule, provider, provider2);
    }

    public static RecyclerView.Adapter<?> provideAdapter(CategoriesSuggestionsModule categoriesSuggestionsModule, AdapterPresenter adapterPresenter, ItemBinder itemBinder) {
        return (RecyclerView.Adapter) Preconditions.checkNotNullFromProvides(categoriesSuggestionsModule.provideAdapter(adapterPresenter, itemBinder));
    }

    @Override // javax.inject.Provider
    public RecyclerView.Adapter<?> get() {
        return provideAdapter(this.a, this.b.get(), this.c.get());
    }
}
