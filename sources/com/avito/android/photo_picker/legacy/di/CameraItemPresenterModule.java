package com.avito.android.photo_picker.legacy.di;

import a2.g.r.g;
import android.app.Application;
import android.content.ContentResolver;
import android.content.res.Resources;
import android.view.Display;
import com.avito.android.analytics.Analytics;
import com.avito.android.permissions.PermissionHelper;
import com.avito.android.photo_picker.legacy.CameraOpenInteractor;
import com.avito.android.photo_picker.legacy.CameraOpenInteractorImpl;
import com.avito.android.photo_picker.legacy.CameraPresenterResourceProvider;
import com.avito.android.photo_picker.legacy.CameraPresenterResourcesProviderImpl;
import com.avito.android.photo_picker.legacy.CameraPresenterState;
import com.avito.android.photo_picker.legacy.CameraSource;
import com.avito.android.photo_picker.legacy.CameraSourceImpl;
import com.avito.android.photo_picker.legacy.CameraType;
import com.avito.android.photo_picker.legacy.DescriptionProvider;
import com.avito.android.photo_picker.legacy.GalleryInteractor;
import com.avito.android.photo_picker.legacy.GalleryInteractorImpl;
import com.avito.android.photo_picker.legacy.PhotoResizer;
import com.avito.android.photo_picker.legacy.RotationInteractor;
import com.avito.android.photo_picker.legacy.RotationProvider;
import com.avito.android.photo_picker.legacy.RotationProviderImpl;
import com.avito.android.photo_picker.legacy.details_list.CameraItemPermissionHandler;
import com.avito.android.photo_picker.legacy.details_list.CameraItemPermissionHandlerImpl;
import com.avito.android.photo_picker.legacy.details_list.CameraItemPresenter;
import com.avito.android.photo_picker.legacy.details_list.CameraItemPresenterImpl;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Dimension;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010O\u001a\u00020L\u0012\u0006\u0010?\u001a\u00020<\u0012\u0006\u0010K\u001a\u00020H\u0012\u0006\u0010S\u001a\u00020P\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u0010C\u001a\u00020@\u0012\b\u0010W\u001a\u0004\u0018\u00010T¢\u0006\u0004\bX\u0010YJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u001c\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010 \u001a\u00020\u001dH\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010$\u001a\u00020!H\u0001¢\u0006\u0004\b\"\u0010#J}\u0010;\u001a\u0002082\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020'2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u00020!2\u0006\u00103\u001a\u0002022\u0006\u00105\u001a\u0002042\u0006\u00107\u001a\u000206H\u0001¢\u0006\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010V¨\u0006Z"}, d2 = {"Lcom/avito/android/photo_picker/legacy/di/CameraItemPresenterModule;", "", "Lcom/avito/android/photo_picker/legacy/CameraSource;", "cameraSource", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/photo_picker/legacy/CameraOpenInteractor;", "provideCameraOpenInteractor$photo_picker_release", "(Lcom/avito/android/photo_picker/legacy/CameraSource;Lcom/avito/android/analytics/Analytics;)Lcom/avito/android/photo_picker/legacy/CameraOpenInteractor;", "provideCameraOpenInteractor", "provideCameraSource$photo_picker_release", "()Lcom/avito/android/photo_picker/legacy/CameraSource;", "provideCameraSource", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/photo_picker/legacy/GalleryInteractor;", "provideGalleryInteractor$photo_picker_release", "(Landroid/app/Application;)Lcom/avito/android/photo_picker/legacy/GalleryInteractor;", "provideGalleryInteractor", "Lcom/avito/android/permissions/PermissionHelper;", "permissionHelper", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPermissionHandler;", "providePermissionHandler$photo_picker_release", "(Lcom/avito/android/permissions/PermissionHelper;)Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPermissionHandler;", "providePermissionHandler", "Lcom/avito/android/photo_picker/legacy/CameraPresenterResourceProvider;", "provideCameraPresenterResourceProvider$photo_picker_release", "()Lcom/avito/android/photo_picker/legacy/CameraPresenterResourceProvider;", "provideCameraPresenterResourceProvider", "Lcom/avito/android/photo_picker/legacy/RotationProvider;", "provideRotationProvider$photo_picker_release", "()Lcom/avito/android/photo_picker/legacy/RotationProvider;", "provideRotationProvider", "Lcom/avito/android/photo_picker/legacy/DescriptionProvider;", "provideDescriptionProvider$photo_picker_release", "()Lcom/avito/android/photo_picker/legacy/DescriptionProvider;", "provideDescriptionProvider", "cameraOpenInteractor", "galleryInteractor", "Lcom/avito/android/photo_picker/legacy/RotationInteractor;", "rotationInteractor", "Ldagger/Lazy;", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter$Listener;", "listenerProxy", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "permissionHandler", "resourceProvider", "rotationProvider", "descriptionProvider", "Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;", "registry", "Lcom/avito/android/photo_picker/legacy/PhotoResizer;", "photoResizer", "Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "sharedPhotosStorage", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter;", "provideCameraPresenter$photo_picker_release", "(Lcom/avito/android/photo_picker/legacy/CameraOpenInteractor;Lcom/avito/android/photo_picker/legacy/GalleryInteractor;Lcom/avito/android/photo_picker/legacy/RotationInteractor;Ldagger/Lazy;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPermissionHandler;Lcom/avito/android/photo_picker/legacy/CameraPresenterResourceProvider;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/photo_picker/legacy/RotationProvider;Lcom/avito/android/photo_picker/legacy/DescriptionProvider;Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;Lcom/avito/android/photo_picker/legacy/PhotoResizer;Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;)Lcom/avito/android/photo_picker/legacy/details_list/CameraItemPresenter;", "provideCameraPresenter", "Landroid/content/res/Resources;", AuthSource.BOOKING_ORDER, "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/photo_picker/legacy/di/DescriptionProviderFactory;", "f", "Lcom/avito/android/photo_picker/legacy/di/DescriptionProviderFactory;", "descriptionProviderFactory", "", "e", "Z", "allowMultipleSelection", "Lcom/avito/android/util/Dimension;", "c", "Lcom/avito/android/util/Dimension;", "pictureSize", "Landroid/view/Display;", AuthSource.SEND_ABUSE, "Landroid/view/Display;", "display", "Lcom/avito/android/photo_picker/legacy/CameraType;", "d", "Lcom/avito/android/photo_picker/legacy/CameraType;", "startCamera", "Lcom/avito/android/photo_picker/legacy/CameraPresenterState;", g.a, "Lcom/avito/android/photo_picker/legacy/CameraPresenterState;", "cameraPresenterState", "<init>", "(Landroid/view/Display;Landroid/content/res/Resources;Lcom/avito/android/util/Dimension;Lcom/avito/android/photo_picker/legacy/CameraType;ZLcom/avito/android/photo_picker/legacy/di/DescriptionProviderFactory;Lcom/avito/android/photo_picker/legacy/CameraPresenterState;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class CameraItemPresenterModule {
    public final Display a;
    public final Resources b;
    public final Dimension c;
    public final CameraType d;
    public final boolean e;
    public final DescriptionProviderFactory f;
    public final CameraPresenterState g;

    public CameraItemPresenterModule(@NotNull Display display, @NotNull Resources resources, @NotNull Dimension dimension, @NotNull CameraType cameraType, boolean z, @NotNull DescriptionProviderFactory descriptionProviderFactory, @Nullable CameraPresenterState cameraPresenterState) {
        Intrinsics.checkNotNullParameter(display, "display");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(dimension, "pictureSize");
        Intrinsics.checkNotNullParameter(cameraType, "startCamera");
        Intrinsics.checkNotNullParameter(descriptionProviderFactory, "descriptionProviderFactory");
        this.a = display;
        this.b = resources;
        this.c = dimension;
        this.d = cameraType;
        this.e = z;
        this.f = descriptionProviderFactory;
        this.g = cameraPresenterState;
    }

    @Provides
    @Reusable
    @NotNull
    public final CameraOpenInteractor provideCameraOpenInteractor$photo_picker_release(@NotNull CameraSource cameraSource, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(cameraSource, "cameraSource");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        return new CameraOpenInteractorImpl(cameraSource, analytics);
    }

    @Provides
    @Reusable
    @NotNull
    public final CameraItemPresenter provideCameraPresenter$photo_picker_release(@NotNull CameraOpenInteractor cameraOpenInteractor, @NotNull GalleryInteractor galleryInteractor, @NotNull RotationInteractor rotationInteractor, @NotNull Lazy<CameraItemPresenter.Listener> lazy, @NotNull SchedulersFactory schedulersFactory, @NotNull CameraItemPermissionHandler cameraItemPermissionHandler, @NotNull CameraPresenterResourceProvider cameraPresenterResourceProvider, @NotNull Analytics analytics, @NotNull RotationProvider rotationProvider, @NotNull DescriptionProvider descriptionProvider, @NotNull CallableResponsiveItemPresenterRegistry callableResponsiveItemPresenterRegistry, @NotNull PhotoResizer photoResizer, @NotNull SharedPhotosStorage sharedPhotosStorage) {
        Intrinsics.checkNotNullParameter(cameraOpenInteractor, "cameraOpenInteractor");
        Intrinsics.checkNotNullParameter(galleryInteractor, "galleryInteractor");
        Intrinsics.checkNotNullParameter(rotationInteractor, "rotationInteractor");
        Intrinsics.checkNotNullParameter(lazy, "listenerProxy");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(cameraItemPermissionHandler, "permissionHandler");
        Intrinsics.checkNotNullParameter(cameraPresenterResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(rotationProvider, "rotationProvider");
        Intrinsics.checkNotNullParameter(descriptionProvider, "descriptionProvider");
        Intrinsics.checkNotNullParameter(callableResponsiveItemPresenterRegistry, "registry");
        Intrinsics.checkNotNullParameter(photoResizer, "photoResizer");
        Intrinsics.checkNotNullParameter(sharedPhotosStorage, "sharedPhotosStorage");
        return new CameraItemPresenterImpl(cameraOpenInteractor, galleryInteractor, rotationInteractor, rotationProvider, lazy, schedulersFactory, cameraItemPermissionHandler, this.c, this.d, this.e, cameraPresenterResourceProvider, analytics, callableResponsiveItemPresenterRegistry, descriptionProvider, photoResizer, sharedPhotosStorage, this.g);
    }

    @Provides
    @Reusable
    @NotNull
    public final CameraPresenterResourceProvider provideCameraPresenterResourceProvider$photo_picker_release() {
        return new CameraPresenterResourcesProviderImpl(this.b);
    }

    @Provides
    @Reusable
    @NotNull
    public final CameraSource provideCameraSource$photo_picker_release() {
        return new CameraSourceImpl();
    }

    @Provides
    @Reusable
    @NotNull
    public final DescriptionProvider provideDescriptionProvider$photo_picker_release() {
        return this.f.create(this.b);
    }

    @Provides
    @Reusable
    @NotNull
    public final GalleryInteractor provideGalleryInteractor$photo_picker_release(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        ContentResolver contentResolver = application.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "application.contentResolver");
        return new GalleryInteractorImpl(contentResolver);
    }

    @Provides
    @Reusable
    @NotNull
    public final CameraItemPermissionHandler providePermissionHandler$photo_picker_release(@NotNull PermissionHelper permissionHelper) {
        Intrinsics.checkNotNullParameter(permissionHelper, "permissionHelper");
        return new CameraItemPermissionHandlerImpl(permissionHelper);
    }

    @Provides
    @Reusable
    @NotNull
    public final RotationProvider provideRotationProvider$photo_picker_release() {
        return new RotationProviderImpl(this.a);
    }
}
