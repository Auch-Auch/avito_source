package com.avito.android.photo_picker.camera.di;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import com.avito.android.analytics.Analytics;
import com.avito.android.permissions.PermissionHelper;
import com.avito.android.photo_picker.ExifExtraDataSerializer;
import com.avito.android.photo_picker.camera.CameraFragment;
import com.avito.android.photo_picker.camera.CameraFragment_MembersInjector;
import com.avito.android.photo_picker.camera.CameraViewModelFactory;
import com.avito.android.photo_picker.camera.FourByThreePhotoResizer;
import com.avito.android.photo_picker.camera.FourByThreePhotoResizer_Factory;
import com.avito.android.photo_picker.camera.di.CameraComponent;
import com.avito.android.photo_picker.legacy.CameraOpenInteractor;
import com.avito.android.photo_picker.legacy.CameraOpenInteractorImpl;
import com.avito.android.photo_picker.legacy.CameraOpenInteractorImpl_Factory;
import com.avito.android.photo_picker.legacy.CameraSource;
import com.avito.android.photo_picker.legacy.CameraSourceImpl_Factory;
import com.avito.android.photo_picker.legacy.GalleryInteractor;
import com.avito.android.photo_picker.legacy.GalleryInteractorImpl;
import com.avito.android.photo_picker.legacy.GalleryInteractorImpl_Factory;
import com.avito.android.photo_picker.legacy.RotationProvider;
import com.avito.android.photo_picker.legacy.RotationProviderImpl;
import com.avito.android.photo_picker.legacy.RotationProviderImpl_Factory;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerCameraComponent implements CameraComponent {
    public final CameraDependencies a;
    public Provider<ContentResolver> b;
    public Provider<GalleryInteractorImpl> c;
    public Provider<GalleryInteractor> d;
    public Provider<CameraSource> e;
    public Provider<Analytics> f;
    public Provider<CameraOpenInteractorImpl> g;
    public Provider<CameraOpenInteractor> h;
    public Provider<Display> i;
    public Provider<RotationProviderImpl> j;
    public Provider<RotationProvider> k;
    public Provider<FourByThreePhotoResizer> l = DoubleCheck.provider(FourByThreePhotoResizer_Factory.create());

    public static final class b implements CameraComponent.Builder {
        public CameraDependencies a;
        public ContentResolver b;
        public Point c;
        public Display d;
        public Context e;

        public b(a aVar) {
        }

        @Override // com.avito.android.photo_picker.camera.di.CameraComponent.Builder
        public CameraComponent build() {
            Preconditions.checkBuilderRequirement(this.a, CameraDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, ContentResolver.class);
            Preconditions.checkBuilderRequirement(this.c, Point.class);
            Preconditions.checkBuilderRequirement(this.d, Display.class);
            Preconditions.checkBuilderRequirement(this.e, Context.class);
            return new DaggerCameraComponent(this.a, this.b, this.c, this.d, this.e, null);
        }

        @Override // com.avito.android.photo_picker.camera.di.CameraComponent.Builder
        public CameraComponent.Builder dependencies(CameraDependencies cameraDependencies) {
            this.a = (CameraDependencies) Preconditions.checkNotNull(cameraDependencies);
            return this;
        }

        @Override // com.avito.android.photo_picker.camera.di.CameraComponent.Builder
        public CameraComponent.Builder withContentResolver(ContentResolver contentResolver) {
            this.b = (ContentResolver) Preconditions.checkNotNull(contentResolver);
            return this;
        }

        @Override // com.avito.android.photo_picker.camera.di.CameraComponent.Builder
        public CameraComponent.Builder withContext(Context context) {
            this.e = (Context) Preconditions.checkNotNull(context);
            return this;
        }

        @Override // com.avito.android.photo_picker.camera.di.CameraComponent.Builder
        public CameraComponent.Builder withDisplay(Display display) {
            this.d = (Display) Preconditions.checkNotNull(display);
            return this;
        }

        @Override // com.avito.android.photo_picker.camera.di.CameraComponent.Builder
        public CameraComponent.Builder withDisplaySize(Point point) {
            this.c = (Point) Preconditions.checkNotNull(point);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final CameraDependencies a;

        public c(CameraDependencies cameraDependencies) {
            this.a = cameraDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public DaggerCameraComponent(CameraDependencies cameraDependencies, ContentResolver contentResolver, Point point, Display display, Context context, a aVar) {
        this.a = cameraDependencies;
        Factory create = InstanceFactory.create(contentResolver);
        this.b = create;
        GalleryInteractorImpl_Factory create2 = GalleryInteractorImpl_Factory.create(create);
        this.c = create2;
        this.d = DoubleCheck.provider(create2);
        Provider<CameraSource> provider = DoubleCheck.provider(CameraSourceImpl_Factory.create());
        this.e = provider;
        c cVar = new c(cameraDependencies);
        this.f = cVar;
        CameraOpenInteractorImpl_Factory create3 = CameraOpenInteractorImpl_Factory.create(provider, cVar);
        this.g = create3;
        this.h = DoubleCheck.provider(create3);
        Factory create4 = InstanceFactory.create(display);
        this.i = create4;
        RotationProviderImpl_Factory create5 = RotationProviderImpl_Factory.create(create4);
        this.j = create5;
        this.k = DoubleCheck.provider(create5);
    }

    public static CameraComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.photo_picker.camera.di.CameraComponent
    public void inject(CameraFragment cameraFragment) {
        CameraFragment_MembersInjector.injectViewModelFactory(cameraFragment, new CameraViewModelFactory(this.d.get(), (PermissionHelper) Preconditions.checkNotNullFromComponent(this.a.permissionHelper()), (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory()), this.h.get(), this.k.get(), (ExifExtraDataSerializer) Preconditions.checkNotNullFromComponent(this.a.exifExtraDataSerializer()), (SharedPhotosStorage) Preconditions.checkNotNullFromComponent(this.a.sharedPhotosStorage()), this.l.get()));
    }
}
