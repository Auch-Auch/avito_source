package com.avito.android.photo_picker.camera.di;

import com.avito.android.di.PerFragment;
import com.avito.android.photo_picker.camera.FourByThreePhotoResizer;
import com.avito.android.photo_picker.legacy.CameraOpenInteractor;
import com.avito.android.photo_picker.legacy.CameraOpenInteractorImpl;
import com.avito.android.photo_picker.legacy.CameraSource;
import com.avito.android.photo_picker.legacy.CameraSourceImpl;
import com.avito.android.photo_picker.legacy.GalleryInteractor;
import com.avito.android.photo_picker.legacy.GalleryInteractorImpl;
import com.avito.android.photo_picker.legacy.PhotoResizer;
import com.avito.android.photo_picker.legacy.RotationProvider;
import com.avito.android.photo_picker.legacy.RotationProviderImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H'¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/avito/android/photo_picker/camera/di/CameraModule;", "", "Lcom/avito/android/photo_picker/legacy/GalleryInteractorImpl;", "interactor", "Lcom/avito/android/photo_picker/legacy/GalleryInteractor;", "bindsGalleryInteractor", "(Lcom/avito/android/photo_picker/legacy/GalleryInteractorImpl;)Lcom/avito/android/photo_picker/legacy/GalleryInteractor;", "Lcom/avito/android/photo_picker/camera/FourByThreePhotoResizer;", "photoResizer", "Lcom/avito/android/photo_picker/legacy/PhotoResizer;", "bindsPhotoResizer", "(Lcom/avito/android/photo_picker/camera/FourByThreePhotoResizer;)Lcom/avito/android/photo_picker/legacy/PhotoResizer;", "Lcom/avito/android/photo_picker/legacy/CameraOpenInteractorImpl;", "Lcom/avito/android/photo_picker/legacy/CameraOpenInteractor;", "bindsCameraOpenInteractor", "(Lcom/avito/android/photo_picker/legacy/CameraOpenInteractorImpl;)Lcom/avito/android/photo_picker/legacy/CameraOpenInteractor;", "Lcom/avito/android/photo_picker/legacy/CameraSourceImpl;", "cameraSource", "Lcom/avito/android/photo_picker/legacy/CameraSource;", "bindsCameraSource", "(Lcom/avito/android/photo_picker/legacy/CameraSourceImpl;)Lcom/avito/android/photo_picker/legacy/CameraSource;", "Lcom/avito/android/photo_picker/legacy/RotationProviderImpl;", "rotationProvider", "Lcom/avito/android/photo_picker/legacy/RotationProvider;", "provideRotationProvider", "(Lcom/avito/android/photo_picker/legacy/RotationProviderImpl;)Lcom/avito/android/photo_picker/legacy/RotationProvider;", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface CameraModule {
    @PerFragment
    @Binds
    @NotNull
    CameraOpenInteractor bindsCameraOpenInteractor(@NotNull CameraOpenInteractorImpl cameraOpenInteractorImpl);

    @PerFragment
    @Binds
    @NotNull
    CameraSource bindsCameraSource(@NotNull CameraSourceImpl cameraSourceImpl);

    @PerFragment
    @Binds
    @NotNull
    GalleryInteractor bindsGalleryInteractor(@NotNull GalleryInteractorImpl galleryInteractorImpl);

    @PerFragment
    @Binds
    @NotNull
    PhotoResizer bindsPhotoResizer(@NotNull FourByThreePhotoResizer fourByThreePhotoResizer);

    @PerFragment
    @Binds
    @NotNull
    RotationProvider provideRotationProvider(@NotNull RotationProviderImpl rotationProviderImpl);
}
