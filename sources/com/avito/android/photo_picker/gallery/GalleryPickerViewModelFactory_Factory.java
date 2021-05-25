package com.avito.android.photo_picker.gallery;

import com.avito.android.permissions.PermissionHelper;
import com.avito.android.photo_picker.gallery.data.GalleryPickerRepository;
import com.avito.android.photo_picker.gallery.gallery_list.GalleryItemPresenter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class GalleryPickerViewModelFactory_Factory implements Factory<GalleryPickerViewModelFactory> {
    public final Provider<PermissionHelper> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<GalleryPickerRepository> c;
    public final Provider<GalleryItemPresenter> d;

    public GalleryPickerViewModelFactory_Factory(Provider<PermissionHelper> provider, Provider<SchedulersFactory> provider2, Provider<GalleryPickerRepository> provider3, Provider<GalleryItemPresenter> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static GalleryPickerViewModelFactory_Factory create(Provider<PermissionHelper> provider, Provider<SchedulersFactory> provider2, Provider<GalleryPickerRepository> provider3, Provider<GalleryItemPresenter> provider4) {
        return new GalleryPickerViewModelFactory_Factory(provider, provider2, provider3, provider4);
    }

    public static GalleryPickerViewModelFactory newInstance(PermissionHelper permissionHelper, SchedulersFactory schedulersFactory, GalleryPickerRepository galleryPickerRepository, GalleryItemPresenter galleryItemPresenter) {
        return new GalleryPickerViewModelFactory(permissionHelper, schedulersFactory, galleryPickerRepository, galleryItemPresenter);
    }

    @Override // javax.inject.Provider
    public GalleryPickerViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
