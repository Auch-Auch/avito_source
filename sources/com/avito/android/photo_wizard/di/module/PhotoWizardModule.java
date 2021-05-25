package com.avito.android.photo_wizard.di.module;

import com.avito.android.di.PerFragment;
import com.avito.android.photo_wizard.PhotoWizardImageResizer;
import com.avito.android.photo_wizard.PhotoWizardImageResizerImpl;
import com.avito.android.photo_wizard.UploadPicturesInteractor;
import com.avito.android.photo_wizard.UploadPicturesInteractorImpl;
import com.avito.android.photo_wizard.WizardPhotoPickerPresenter;
import com.avito.android.photo_wizard.WizardPhotoPickerPresenterImpl;
import com.avito.android.photo_wizard.converter.DocumentTypesConverter;
import com.avito.android.photo_wizard.converter.DocumentTypesConverterImpl;
import com.avito.android.photo_wizard.converter.WizardStepsConverter;
import com.avito.android.photo_wizard.converter.WizardStepsConverterImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/photo_wizard/di/module/PhotoWizardModule;", "", "Lcom/avito/android/photo_wizard/converter/WizardStepsConverterImpl;", "impl", "Lcom/avito/android/photo_wizard/converter/WizardStepsConverter;", "provideWizardStepsConverter", "(Lcom/avito/android/photo_wizard/converter/WizardStepsConverterImpl;)Lcom/avito/android/photo_wizard/converter/WizardStepsConverter;", "Lcom/avito/android/photo_wizard/converter/DocumentTypesConverterImpl;", "Lcom/avito/android/photo_wizard/converter/DocumentTypesConverter;", "provideDocumentTypesConverter", "(Lcom/avito/android/photo_wizard/converter/DocumentTypesConverterImpl;)Lcom/avito/android/photo_wizard/converter/DocumentTypesConverter;", "Lcom/avito/android/photo_wizard/WizardPhotoPickerPresenterImpl;", "Lcom/avito/android/photo_wizard/WizardPhotoPickerPresenter;", "providePhotoWizardPresenter", "(Lcom/avito/android/photo_wizard/WizardPhotoPickerPresenterImpl;)Lcom/avito/android/photo_wizard/WizardPhotoPickerPresenter;", "Lcom/avito/android/photo_wizard/UploadPicturesInteractorImpl;", "Lcom/avito/android/photo_wizard/UploadPicturesInteractor;", "provideUploadPicturesInteractor", "(Lcom/avito/android/photo_wizard/UploadPicturesInteractorImpl;)Lcom/avito/android/photo_wizard/UploadPicturesInteractor;", "Lcom/avito/android/photo_wizard/PhotoWizardImageResizerImpl;", "Lcom/avito/android/photo_wizard/PhotoWizardImageResizer;", "providePhotoWizardImageSaver", "(Lcom/avito/android/photo_wizard/PhotoWizardImageResizerImpl;)Lcom/avito/android/photo_wizard/PhotoWizardImageResizer;", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface PhotoWizardModule {
    @PerFragment
    @Binds
    @NotNull
    DocumentTypesConverter provideDocumentTypesConverter(@NotNull DocumentTypesConverterImpl documentTypesConverterImpl);

    @PerFragment
    @Binds
    @NotNull
    PhotoWizardImageResizer providePhotoWizardImageSaver(@NotNull PhotoWizardImageResizerImpl photoWizardImageResizerImpl);

    @PerFragment
    @Binds
    @NotNull
    WizardPhotoPickerPresenter providePhotoWizardPresenter(@NotNull WizardPhotoPickerPresenterImpl wizardPhotoPickerPresenterImpl);

    @PerFragment
    @Binds
    @NotNull
    UploadPicturesInteractor provideUploadPicturesInteractor(@NotNull UploadPicturesInteractorImpl uploadPicturesInteractorImpl);

    @PerFragment
    @Binds
    @NotNull
    WizardStepsConverter provideWizardStepsConverter(@NotNull WizardStepsConverterImpl wizardStepsConverterImpl);
}
