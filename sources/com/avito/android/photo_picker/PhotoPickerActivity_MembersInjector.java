package com.avito.android.photo_picker;

import com.avito.android.analytics.Analytics;
import com.avito.android.photo_picker.legacy.GalleryResultsExtractor;
import com.avito.android.photo_picker.legacy.PhotoDragAndDrop;
import com.avito.android.photo_picker.legacy.PhotoPickerInteractor;
import com.avito.android.photo_picker.legacy.PhotoPickerPresenter;
import com.avito.android.photo_picker.legacy.StoppableRotationInteractor;
import com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter;
import com.avito.android.photo_picker.legacy.details_list.DisplayAnalyzer;
import com.avito.android.photo_picker.legacy.di.PhotoPickerModule;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class PhotoPickerActivity_MembersInjector implements MembersInjector<PhotoPickerActivity> {
    public final Provider<ImplicitIntentFactory> a;
    public final Provider<PhotoPickerPresenter> b;
    public final Provider<PhotoDragAndDrop> c;
    public final Provider<PhotoPickerInteractor> d;
    public final Provider<CameraItemPresenter> e;
    public final Provider<StoppableRotationInteractor> f;
    public final Provider<DisplayAnalyzer> g;
    public final Provider<GalleryResultsExtractor> h;
    public final Provider<PhotoPickerViewModelFactory> i;
    public final Provider<SimpleRecyclerAdapter> j;
    public final Provider<SimpleRecyclerAdapter> k;
    public final Provider<Analytics> l;

    public PhotoPickerActivity_MembersInjector(Provider<ImplicitIntentFactory> provider, Provider<PhotoPickerPresenter> provider2, Provider<PhotoDragAndDrop> provider3, Provider<PhotoPickerInteractor> provider4, Provider<CameraItemPresenter> provider5, Provider<StoppableRotationInteractor> provider6, Provider<DisplayAnalyzer> provider7, Provider<GalleryResultsExtractor> provider8, Provider<PhotoPickerViewModelFactory> provider9, Provider<SimpleRecyclerAdapter> provider10, Provider<SimpleRecyclerAdapter> provider11, Provider<Analytics> provider12) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
        this.k = provider11;
        this.l = provider12;
    }

    public static MembersInjector<PhotoPickerActivity> create(Provider<ImplicitIntentFactory> provider, Provider<PhotoPickerPresenter> provider2, Provider<PhotoDragAndDrop> provider3, Provider<PhotoPickerInteractor> provider4, Provider<CameraItemPresenter> provider5, Provider<StoppableRotationInteractor> provider6, Provider<DisplayAnalyzer> provider7, Provider<GalleryResultsExtractor> provider8, Provider<PhotoPickerViewModelFactory> provider9, Provider<SimpleRecyclerAdapter> provider10, Provider<SimpleRecyclerAdapter> provider11, Provider<Analytics> provider12) {
        return new PhotoPickerActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    @InjectedFieldSignature("com.avito.android.photo_picker.PhotoPickerActivity.analytics")
    public static void injectAnalytics(PhotoPickerActivity photoPickerActivity, Analytics analytics) {
        photoPickerActivity.analytics = analytics;
    }

    @PhotoPickerModule.DetailsAdapter
    @InjectedFieldSignature("com.avito.android.photo_picker.PhotoPickerActivity.cameraAdapter")
    public static void injectCameraAdapter(PhotoPickerActivity photoPickerActivity, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        photoPickerActivity.cameraAdapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.photo_picker.PhotoPickerActivity.cameraPresenter")
    public static void injectCameraPresenter(PhotoPickerActivity photoPickerActivity, CameraItemPresenter cameraItemPresenter) {
        photoPickerActivity.cameraPresenter = cameraItemPresenter;
    }

    @InjectedFieldSignature("com.avito.android.photo_picker.PhotoPickerActivity.displayAnalyzer")
    public static void injectDisplayAnalyzer(PhotoPickerActivity photoPickerActivity, DisplayAnalyzer displayAnalyzer) {
        photoPickerActivity.displayAnalyzer = displayAnalyzer;
    }

    @InjectedFieldSignature("com.avito.android.photo_picker.PhotoPickerActivity.galleryResultsExtractor")
    public static void injectGalleryResultsExtractor(PhotoPickerActivity photoPickerActivity, GalleryResultsExtractor galleryResultsExtractor) {
        photoPickerActivity.galleryResultsExtractor = galleryResultsExtractor;
    }

    @InjectedFieldSignature("com.avito.android.photo_picker.PhotoPickerActivity.intentFactory")
    public static void injectIntentFactory(PhotoPickerActivity photoPickerActivity, ImplicitIntentFactory implicitIntentFactory) {
        photoPickerActivity.intentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.photo_picker.PhotoPickerActivity.interactor")
    public static void injectInteractor(PhotoPickerActivity photoPickerActivity, PhotoPickerInteractor photoPickerInteractor) {
        photoPickerActivity.interactor = photoPickerInteractor;
    }

    @InjectedFieldSignature("com.avito.android.photo_picker.PhotoPickerActivity.photoDragAndDrop")
    public static void injectPhotoDragAndDrop(PhotoPickerActivity photoPickerActivity, PhotoDragAndDrop photoDragAndDrop) {
        photoPickerActivity.photoDragAndDrop = photoDragAndDrop;
    }

    @InjectedFieldSignature("com.avito.android.photo_picker.PhotoPickerActivity.presenter")
    public static void injectPresenter(PhotoPickerActivity photoPickerActivity, PhotoPickerPresenter photoPickerPresenter) {
        photoPickerActivity.presenter = photoPickerPresenter;
    }

    @InjectedFieldSignature("com.avito.android.photo_picker.PhotoPickerActivity.rotationInteractor")
    public static void injectRotationInteractor(PhotoPickerActivity photoPickerActivity, StoppableRotationInteractor stoppableRotationInteractor) {
        photoPickerActivity.rotationInteractor = stoppableRotationInteractor;
    }

    @PhotoPickerModule.ThumbnailsAdapter
    @InjectedFieldSignature("com.avito.android.photo_picker.PhotoPickerActivity.thumbnailsAdapter")
    public static void injectThumbnailsAdapter(PhotoPickerActivity photoPickerActivity, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        photoPickerActivity.thumbnailsAdapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.photo_picker.PhotoPickerActivity.viewModelFactory")
    public static void injectViewModelFactory(PhotoPickerActivity photoPickerActivity, PhotoPickerViewModelFactory photoPickerViewModelFactory) {
        photoPickerActivity.viewModelFactory = photoPickerViewModelFactory;
    }

    public void injectMembers(PhotoPickerActivity photoPickerActivity) {
        injectIntentFactory(photoPickerActivity, this.a.get());
        injectPresenter(photoPickerActivity, this.b.get());
        injectPhotoDragAndDrop(photoPickerActivity, this.c.get());
        injectInteractor(photoPickerActivity, this.d.get());
        injectCameraPresenter(photoPickerActivity, this.e.get());
        injectRotationInteractor(photoPickerActivity, this.f.get());
        injectDisplayAnalyzer(photoPickerActivity, this.g.get());
        injectGalleryResultsExtractor(photoPickerActivity, this.h.get());
        injectViewModelFactory(photoPickerActivity, this.i.get());
        injectCameraAdapter(photoPickerActivity, this.j.get());
        injectThumbnailsAdapter(photoPickerActivity, this.k.get());
        injectAnalytics(photoPickerActivity, this.l.get());
    }
}
