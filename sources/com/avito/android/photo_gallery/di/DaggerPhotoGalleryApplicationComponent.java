package com.avito.android.photo_gallery.di;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.photo_gallery.PhotoGalleryActivity;
import com.avito.android.photo_gallery.PhotoGalleryActivity_MembersInjector;
import com.avito.android.photo_gallery.di.PhotoGalleryApplicationComponent;
import com.avito.android.util.ImplicitIntentFactory;
import dagger.internal.Preconditions;
public final class DaggerPhotoGalleryApplicationComponent implements PhotoGalleryApplicationComponent {
    public final PhotoGalleryDependencies a;

    public static final class b implements PhotoGalleryApplicationComponent.Builder {
        public PhotoGalleryDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.photo_gallery.di.PhotoGalleryApplicationComponent.Builder
        public PhotoGalleryApplicationComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PhotoGalleryDependencies.class);
            return new DaggerPhotoGalleryApplicationComponent(this.a, null);
        }

        @Override // com.avito.android.photo_gallery.di.PhotoGalleryApplicationComponent.Builder
        public PhotoGalleryApplicationComponent.Builder photoGalleryDependencies(PhotoGalleryDependencies photoGalleryDependencies) {
            this.a = (PhotoGalleryDependencies) Preconditions.checkNotNull(photoGalleryDependencies);
            return this;
        }
    }

    public DaggerPhotoGalleryApplicationComponent(PhotoGalleryDependencies photoGalleryDependencies, a aVar) {
        this.a = photoGalleryDependencies;
    }

    public static PhotoGalleryApplicationComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.photo_gallery.di.PhotoGalleryApplicationComponent
    public void inject(PhotoGalleryActivity photoGalleryActivity) {
        PhotoGalleryActivity_MembersInjector.injectFeatures(photoGalleryActivity, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        PhotoGalleryActivity_MembersInjector.injectImplicitIntentFactory(photoGalleryActivity, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        PhotoGalleryActivity_MembersInjector.injectAnalytics(photoGalleryActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }
}
