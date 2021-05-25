package com.avito.android.advert.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AdvertFragmentModule_ProvideRecyclerAdapter$advert_details_releaseFactory implements Factory<SimpleRecyclerAdapter> {
    public final Provider<AdapterPresenter> a;
    public final Provider<ItemBinder> b;

    public AdvertFragmentModule_ProvideRecyclerAdapter$advert_details_releaseFactory(Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdvertFragmentModule_ProvideRecyclerAdapter$advert_details_releaseFactory create(Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2) {
        return new AdvertFragmentModule_ProvideRecyclerAdapter$advert_details_releaseFactory(provider, provider2);
    }

    public static SimpleRecyclerAdapter provideRecyclerAdapter$advert_details_release(AdapterPresenter adapterPresenter, ItemBinder itemBinder) {
        return (SimpleRecyclerAdapter) Preconditions.checkNotNullFromProvides(AdvertFragmentModule.INSTANCE.provideRecyclerAdapter$advert_details_release(adapterPresenter, itemBinder));
    }

    @Override // javax.inject.Provider
    public SimpleRecyclerAdapter get() {
        return provideRecyclerAdapter$advert_details_release(this.a.get(), this.b.get());
    }
}
