package com.avito.android.search.map.di;

import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SerpListModule_ProvideDestroyableViewHolderBuilderFactory implements Factory<DestroyableViewHolderBuilder> {
    public final Provider<ItemBinder> a;

    public SerpListModule_ProvideDestroyableViewHolderBuilderFactory(Provider<ItemBinder> provider) {
        this.a = provider;
    }

    public static SerpListModule_ProvideDestroyableViewHolderBuilderFactory create(Provider<ItemBinder> provider) {
        return new SerpListModule_ProvideDestroyableViewHolderBuilderFactory(provider);
    }

    public static DestroyableViewHolderBuilder provideDestroyableViewHolderBuilder(ItemBinder itemBinder) {
        return (DestroyableViewHolderBuilder) Preconditions.checkNotNullFromProvides(SerpListModule.provideDestroyableViewHolderBuilder(itemBinder));
    }

    @Override // javax.inject.Provider
    public DestroyableViewHolderBuilder get() {
        return provideDestroyableViewHolderBuilder(this.a.get());
    }
}
