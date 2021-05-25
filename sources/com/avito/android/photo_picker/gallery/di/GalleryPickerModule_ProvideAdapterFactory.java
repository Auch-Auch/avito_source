package com.avito.android.photo_picker.gallery.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class GalleryPickerModule_ProvideAdapterFactory implements Factory<SimpleRecyclerAdapter> {
    public final Provider<AdapterPresenter> a;
    public final Provider<ItemBinder> b;

    public GalleryPickerModule_ProvideAdapterFactory(Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static GalleryPickerModule_ProvideAdapterFactory create(Provider<AdapterPresenter> provider, Provider<ItemBinder> provider2) {
        return new GalleryPickerModule_ProvideAdapterFactory(provider, provider2);
    }

    public static SimpleRecyclerAdapter provideAdapter(AdapterPresenter adapterPresenter, ItemBinder itemBinder) {
        return (SimpleRecyclerAdapter) Preconditions.checkNotNullFromProvides(GalleryPickerModule.provideAdapter(adapterPresenter, itemBinder));
    }

    @Override // javax.inject.Provider
    public SimpleRecyclerAdapter get() {
        return provideAdapter(this.a.get(), this.b.get());
    }
}
