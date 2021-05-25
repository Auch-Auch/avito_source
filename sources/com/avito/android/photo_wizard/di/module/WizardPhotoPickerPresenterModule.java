package com.avito.android.photo_wizard.di.module;

import com.avito.android.di.PerFragment;
import com.avito.android.photo_picker.legacy.CameraOpenInteractor;
import com.avito.android.photo_picker.legacy.CameraOpenInteractorImpl;
import com.avito.android.photo_picker.legacy.CameraSource;
import com.avito.android.photo_picker.legacy.CameraSourceImpl;
import com.avito.android.photo_wizard.PhotoWizardResourceProvider;
import com.avito.android.photo_wizard.PhotoWizardResourceProviderImpl;
import com.avito.android.util.preferences.GeoContract;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/photo_wizard/di/module/WizardPhotoPickerPresenterModule;", "", "Lcom/avito/android/photo_picker/legacy/CameraOpenInteractorImpl;", "interactor", "Lcom/avito/android/photo_picker/legacy/CameraOpenInteractor;", "bindsCameraOpenInteractor", "(Lcom/avito/android/photo_picker/legacy/CameraOpenInteractorImpl;)Lcom/avito/android/photo_picker/legacy/CameraOpenInteractor;", "Lcom/avito/android/photo_picker/legacy/CameraSourceImpl;", "cameraSource", "Lcom/avito/android/photo_picker/legacy/CameraSource;", "bindsCameraSource", "(Lcom/avito/android/photo_picker/legacy/CameraSourceImpl;)Lcom/avito/android/photo_picker/legacy/CameraSource;", "Lcom/avito/android/photo_wizard/PhotoWizardResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/photo_wizard/PhotoWizardResourceProvider;", "bindsResourceProvider", "(Lcom/avito/android/photo_wizard/PhotoWizardResourceProviderImpl;)Lcom/avito/android/photo_wizard/PhotoWizardResourceProvider;", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface WizardPhotoPickerPresenterModule {
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
    PhotoWizardResourceProvider bindsResourceProvider(@NotNull PhotoWizardResourceProviderImpl photoWizardResourceProviderImpl);
}
