package com.avito.android.photo_picker.gallery;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class GalleryPickerFragment_MembersInjector implements MembersInjector<GalleryPickerFragment> {
    public final Provider<GalleryPickerViewModelFactory> a;
    public final Provider<AdapterPresenter> b;
    public final Provider<SimpleRecyclerAdapter> c;
    public final Provider<Analytics> d;
    public final Provider<Features> e;

    public GalleryPickerFragment_MembersInjector(Provider<GalleryPickerViewModelFactory> provider, Provider<AdapterPresenter> provider2, Provider<SimpleRecyclerAdapter> provider3, Provider<Analytics> provider4, Provider<Features> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<GalleryPickerFragment> create(Provider<GalleryPickerViewModelFactory> provider, Provider<AdapterPresenter> provider2, Provider<SimpleRecyclerAdapter> provider3, Provider<Analytics> provider4, Provider<Features> provider5) {
        return new GalleryPickerFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.photo_picker.gallery.GalleryPickerFragment.adapter")
    public static void injectAdapter(GalleryPickerFragment galleryPickerFragment, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        galleryPickerFragment.adapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.photo_picker.gallery.GalleryPickerFragment.analytics")
    public static void injectAnalytics(GalleryPickerFragment galleryPickerFragment, Analytics analytics) {
        galleryPickerFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.photo_picker.gallery.GalleryPickerFragment.features")
    public static void injectFeatures(GalleryPickerFragment galleryPickerFragment, Features features) {
        galleryPickerFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.photo_picker.gallery.GalleryPickerFragment.photoGridPresenter")
    public static void injectPhotoGridPresenter(GalleryPickerFragment galleryPickerFragment, AdapterPresenter adapterPresenter) {
        galleryPickerFragment.photoGridPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.photo_picker.gallery.GalleryPickerFragment.viewModelFactory")
    public static void injectViewModelFactory(GalleryPickerFragment galleryPickerFragment, GalleryPickerViewModelFactory galleryPickerViewModelFactory) {
        galleryPickerFragment.viewModelFactory = galleryPickerViewModelFactory;
    }

    public void injectMembers(GalleryPickerFragment galleryPickerFragment) {
        injectViewModelFactory(galleryPickerFragment, this.a.get());
        injectPhotoGridPresenter(galleryPickerFragment, this.b.get());
        injectAdapter(galleryPickerFragment, this.c.get());
        injectAnalytics(galleryPickerFragment, this.d.get());
        injectFeatures(galleryPickerFragment, this.e.get());
    }
}
