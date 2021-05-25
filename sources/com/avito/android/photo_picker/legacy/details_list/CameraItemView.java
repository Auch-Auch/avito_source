package com.avito.android.photo_picker.legacy.details_list;

import android.graphics.Bitmap;
import android.view.TextureView;
import com.avito.android.util.Dimension;
import com.avito.android.util.Rotation;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u00018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\tJ\u000f\u0010\u0012\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\tJ\u000f\u0010\u0013\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\tJ\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0004H&¢\u0006\u0004\b\u001c\u0010\tJ\u000f\u0010\u001d\u001a\u00020\u0004H&¢\u0006\u0004\b\u001d\u0010\tJ\u000f\u0010\u001e\u001a\u00020\u0004H&¢\u0006\u0004\b\u001e\u0010\tJ\u0017\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b#\u0010\u0006J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b$\u0010\u0017J-\u0010$\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u00142\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040&H&¢\u0006\u0004\b$\u0010(J\u0017\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0002H&¢\u0006\u0004\b*\u0010\u0006J\u0017\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0002H&¢\u0006\u0004\b,\u0010\u0006J\u0017\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0014H&¢\u0006\u0004\b.\u0010\u0017J\u000f\u0010/\u001a\u00020\u0004H&¢\u0006\u0004\b/\u0010\tJ\u000f\u00100\u001a\u00020\u0004H&¢\u0006\u0004\b0\u0010\tR\u0016\u00104\u001a\u0002018&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0016\u00107\u001a\u00020\u001f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u00106¨\u00069"}, d2 = {"Lcom/avito/android/photo_picker/legacy/details_list/CameraItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "isAvailable", "", "setFlashToggleAvailability", "(Z)V", "setCameraToggleAvailability", "setFlashToggleButtonSrcAuto", "()V", "setFlashToggleButtonSrcOff", "setFlashToggleButtonSrcOn", "setTakeShotButtonAvailability", "Lcom/avito/android/util/Rotation;", "rotation", "rotateUi", "(Lcom/avito/android/util/Rotation;)V", "showNoCameraPermissionPlaceholder", "showNoCameraPlaceHolder", "hideCameraPlaceholders", "", "text", "setEnablePermissionsButtonText", "(Ljava/lang/String;)V", "Landroid/graphics/Bitmap;", "bitmap", "setGalleryButtonSrc", "(Landroid/graphics/Bitmap;)V", "setGalleryButtonHidden", "startCameraShotAnimation", "showNoImagesFromGalleryAvailable", "Lcom/avito/android/util/Dimension;", "previewSize", "setPreviewSize", "(Lcom/avito/android/util/Dimension;)V", "setPlaceholdersBackground", "showMessage", "actionTitle", "Lkotlin/Function0;", "action", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "visible", "setCameraControlsVisible", "previewIsVisible", "setPreviewStubImageVisibility", "description", "setDescription", "hideDescription", "ensureKeyboardHidden", "Landroid/view/TextureView;", "getPreviewSurface", "()Landroid/view/TextureView;", "previewSurface", "getDesiredPreviewSize", "()Lcom/avito/android/util/Dimension;", "desiredPreviewSize", "Presenter", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface CameraItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull CameraItemView cameraItemView) {
            ItemView.DefaultImpls.onUnbind(cameraItemView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/avito/android/photo_picker/legacy/details_list/CameraItemView$Presenter;", "", "", "onTakeShotClicked", "()V", "onFlashToggleClicked", "onCameraToggleClicked", "onGalleryClicked", "onAllowCameraAccessClicked", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public interface Presenter {
        void onAllowCameraAccessClicked();

        void onCameraToggleClicked();

        void onFlashToggleClicked();

        void onGalleryClicked();

        void onTakeShotClicked();
    }

    void ensureKeyboardHidden();

    @NotNull
    Dimension getDesiredPreviewSize();

    @NotNull
    TextureView getPreviewSurface();

    void hideCameraPlaceholders();

    void hideDescription();

    void rotateUi(@NotNull Rotation rotation);

    void setCameraControlsVisible(boolean z);

    void setCameraToggleAvailability(boolean z);

    void setDescription(@NotNull String str);

    void setEnablePermissionsButtonText(@NotNull String str);

    void setFlashToggleAvailability(boolean z);

    void setFlashToggleButtonSrcAuto();

    void setFlashToggleButtonSrcOff();

    void setFlashToggleButtonSrcOn();

    void setGalleryButtonHidden();

    void setGalleryButtonSrc(@NotNull Bitmap bitmap);

    void setPlaceholdersBackground(boolean z);

    void setPreviewSize(@NotNull Dimension dimension);

    void setPreviewStubImageVisibility(boolean z);

    void setTakeShotButtonAvailability(boolean z);

    void showMessage(@NotNull String str);

    void showMessage(@NotNull String str, @NotNull String str2, @NotNull Function0<Unit> function0);

    void showNoCameraPermissionPlaceholder();

    void showNoCameraPlaceHolder();

    void showNoImagesFromGalleryAvailable();

    void startCameraShotAnimation();
}
