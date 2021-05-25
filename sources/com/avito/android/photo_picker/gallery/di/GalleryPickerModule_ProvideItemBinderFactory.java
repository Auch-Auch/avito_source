package com.avito.android.photo_picker.gallery.di;

import com.avito.android.photo_picker.gallery.gallery_list.GalleryItemBluePrint;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class GalleryPickerModule_ProvideItemBinderFactory implements Factory<ItemBinder> {
    public final Provider<GalleryItemBluePrint> a;

    public GalleryPickerModule_ProvideItemBinderFactory(Provider<GalleryItemBluePrint> provider) {
        this.a = provider;
    }

    public static GalleryPickerModule_ProvideItemBinderFactory create(Provider<GalleryItemBluePrint> provider) {
        return new GalleryPickerModule_ProvideItemBinderFactory(provider);
    }

    public static ItemBinder provideItemBinder(GalleryItemBluePrint galleryItemBluePrint) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(GalleryPickerModule.provideItemBinder(galleryItemBluePrint));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder(this.a.get());
    }
}
