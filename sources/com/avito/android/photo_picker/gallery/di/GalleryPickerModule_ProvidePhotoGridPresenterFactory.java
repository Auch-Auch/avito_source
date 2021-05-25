package com.avito.android.photo_picker.gallery.di;

import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class GalleryPickerModule_ProvidePhotoGridPresenterFactory implements Factory<AdapterPresenter> {
    public final Provider<ItemBinder> a;

    public GalleryPickerModule_ProvidePhotoGridPresenterFactory(Provider<ItemBinder> provider) {
        this.a = provider;
    }

    public static GalleryPickerModule_ProvidePhotoGridPresenterFactory create(Provider<ItemBinder> provider) {
        return new GalleryPickerModule_ProvidePhotoGridPresenterFactory(provider);
    }

    public static AdapterPresenter providePhotoGridPresenter(ItemBinder itemBinder) {
        return (AdapterPresenter) Preconditions.checkNotNullFromProvides(GalleryPickerModule.providePhotoGridPresenter(itemBinder));
    }

    @Override // javax.inject.Provider
    public AdapterPresenter get() {
        return providePhotoGridPresenter(this.a.get());
    }
}
