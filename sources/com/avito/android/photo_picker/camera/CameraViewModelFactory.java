package com.avito.android.photo_picker.camera;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.permissions.PermissionHelper;
import com.avito.android.photo_picker.ExifExtraDataSerializer;
import com.avito.android.photo_picker.legacy.CameraOpenInteractor;
import com.avito.android.photo_picker.legacy.GalleryInteractor;
import com.avito.android.photo_picker.legacy.PhotoResizer;
import com.avito.android.photo_picker.legacy.RotationProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BI\b\u0007\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b(\u0010)J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/avito/android/photo_picker/camera/CameraViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/util/SchedulersFactory;", "c", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/photo_picker/ExifExtraDataSerializer;", "f", "Lcom/avito/android/photo_picker/ExifExtraDataSerializer;", "exifExtraDataSerializer", "Lcom/avito/android/photo_picker/legacy/RotationProvider;", "e", "Lcom/avito/android/photo_picker/legacy/RotationProvider;", "rotationProvider", "Lcom/avito/android/permissions/PermissionHelper;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/permissions/PermissionHelper;", "permissionHelper", "Lcom/avito/android/photo_picker/legacy/PhotoResizer;", "h", "Lcom/avito/android/photo_picker/legacy/PhotoResizer;", "photoResizer", "Lcom/avito/android/photo_picker/legacy/CameraOpenInteractor;", "d", "Lcom/avito/android/photo_picker/legacy/CameraOpenInteractor;", "interactor", "Lcom/avito/android/photo_picker/legacy/GalleryInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/photo_picker/legacy/GalleryInteractor;", "galleryInteractor", "Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", g.a, "Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "sharedPhotosStorage", "<init>", "(Lcom/avito/android/photo_picker/legacy/GalleryInteractor;Lcom/avito/android/permissions/PermissionHelper;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/photo_picker/legacy/CameraOpenInteractor;Lcom/avito/android/photo_picker/legacy/RotationProvider;Lcom/avito/android/photo_picker/ExifExtraDataSerializer;Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;Lcom/avito/android/photo_picker/legacy/PhotoResizer;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class CameraViewModelFactory implements ViewModelProvider.Factory {
    public final GalleryInteractor a;
    public final PermissionHelper b;
    public final SchedulersFactory c;
    public final CameraOpenInteractor d;
    public final RotationProvider e;
    public final ExifExtraDataSerializer f;
    public final SharedPhotosStorage g;
    public final PhotoResizer h;

    @Inject
    public CameraViewModelFactory(@NotNull GalleryInteractor galleryInteractor, @NotNull PermissionHelper permissionHelper, @NotNull SchedulersFactory schedulersFactory, @NotNull CameraOpenInteractor cameraOpenInteractor, @NotNull RotationProvider rotationProvider, @NotNull ExifExtraDataSerializer exifExtraDataSerializer, @NotNull SharedPhotosStorage sharedPhotosStorage, @NotNull PhotoResizer photoResizer) {
        Intrinsics.checkNotNullParameter(galleryInteractor, "galleryInteractor");
        Intrinsics.checkNotNullParameter(permissionHelper, "permissionHelper");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(cameraOpenInteractor, "interactor");
        Intrinsics.checkNotNullParameter(rotationProvider, "rotationProvider");
        Intrinsics.checkNotNullParameter(exifExtraDataSerializer, "exifExtraDataSerializer");
        Intrinsics.checkNotNullParameter(sharedPhotosStorage, "sharedPhotosStorage");
        Intrinsics.checkNotNullParameter(photoResizer, "photoResizer");
        this.a = galleryInteractor;
        this.b = permissionHelper;
        this.c = schedulersFactory;
        this.d = cameraOpenInteractor;
        this.e = rotationProvider;
        this.f = exifExtraDataSerializer;
        this.g = sharedPhotosStorage;
        this.h = photoResizer;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(CameraViewModel.class)) {
            return cls.cast(new CameraViewModel(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
