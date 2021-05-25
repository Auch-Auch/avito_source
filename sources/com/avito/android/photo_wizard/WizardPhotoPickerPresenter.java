package com.avito.android.photo_wizard;

import com.avito.android.photo_wizard.WizardPhotoPickerView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u001dJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H&¢\u0006\u0004\b\u0017\u0010\bJ\u000f\u0010\u0018\u001a\u00020\u0004H&¢\u0006\u0004\b\u0018\u0010\bJ\u0019\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H&¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/avito/android/photo_wizard/WizardPhotoPickerPresenter;", "Lcom/avito/android/photo_wizard/WizardPhotoPickerView$Listener;", "Lcom/avito/android/photo_wizard/WizardPhotoPickerView;", "view", "", "attachView", "(Lcom/avito/android/photo_wizard/WizardPhotoPickerView;)V", "detachView", "()V", "Lcom/avito/android/photo_wizard/WizardPhotoPickerPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/photo_wizard/WizardPhotoPickerPresenter$Router;)V", "detachRouter", "onPermissionsResult", "Lcom/avito/android/photo_wizard/PhotoWizardViewModel;", "viewModel", "setViewModel", "(Lcom/avito/android/photo_wizard/PhotoWizardViewModel;)V", "Lcom/avito/android/photo_wizard/PhotoWizardViewState;", "state", "resolveViewState", "(Lcom/avito/android/photo_wizard/PhotoWizardViewState;)V", "openCamera", "closeCamera", "", "title", "updateTitle", "(Ljava/lang/String;)V", "Router", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
public interface WizardPhotoPickerPresenter extends WizardPhotoPickerView.Listener {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/photo_wizard/WizardPhotoPickerPresenter$Router;", "", "", "toAppSettings", "()V", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void toAppSettings();
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull WizardPhotoPickerView wizardPhotoPickerView);

    void closeCamera();

    void detachRouter();

    void detachView();

    void onPermissionsResult();

    void openCamera();

    void resolveViewState(@NotNull PhotoWizardViewState photoWizardViewState);

    void setViewModel(@NotNull PhotoWizardViewModel photoWizardViewModel);

    void updateTitle(@Nullable String str);
}
