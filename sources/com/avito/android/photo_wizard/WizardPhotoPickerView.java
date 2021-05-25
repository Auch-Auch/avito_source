package com.avito.android.photo_wizard;

import android.net.Uri;
import androidx.annotation.DrawableRes;
import com.avito.android.photo_picker.camera.CameraViewport;
import com.avito.android.util.Dimension;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u00018J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH&¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0015\u001a\u00020\n2\u001a\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0018\u00010\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J;\u0010!\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\r2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b!\u0010\"J\u001f\u0010&\u001a\u00020\n2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\bH&¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\nH&¢\u0006\u0004\b(\u0010\u0012J\u000f\u0010)\u001a\u00020\nH&¢\u0006\u0004\b)\u0010\u0012J\u0017\u0010,\u001a\u00020\n2\u0006\u0010+\u001a\u00020*H&¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\nH&¢\u0006\u0004\b.\u0010\u0012J\u000f\u0010/\u001a\u00020\nH&¢\u0006\u0004\b/\u0010\u0012J\u0017\u00101\u001a\u00020\n2\u0006\u00100\u001a\u00020\bH&¢\u0006\u0004\b1\u0010\fJ\u000f\u00102\u001a\u00020\nH&¢\u0006\u0004\b2\u0010\u0012R\u001c\u00107\u001a\b\u0012\u0004\u0012\u000204038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u00106¨\u00069"}, d2 = {"Lcom/avito/android/photo_wizard/WizardPhotoPickerView;", "", "Lcom/avito/android/photo_picker/camera/CameraViewport;", "preview", "()Lcom/avito/android/photo_picker/camera/CameraViewport;", "Lcom/avito/android/util/Dimension;", "getFullPreviewSize", "()Lcom/avito/android/util/Dimension;", "", "titleText", "", "setTitle", "(Ljava/lang/String;)V", "", "iconResId", "setFlashIcon", "(I)V", "hideFlashIcon", "()V", "Lkotlin/Function2;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSurfaceMeasureListener", "(Lkotlin/jvm/functions/Function2;)V", "Lcom/avito/android/photo_wizard/WizardPhotoPickerView$Listener;", "setPhotoWizardViewListener", "(Lcom/avito/android/photo_wizard/WizardPhotoPickerView$Listener;)V", "hint", "maskResId", "", "Lcom/avito/android/photo_wizard/DocumentType;", "types", "Lcom/avito/android/photo_wizard/PictureType;", "type", "showPreview", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lcom/avito/android/photo_wizard/PictureType;)V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "actionText", "showTakenPhoto", "(Landroid/net/Uri;Ljava/lang/String;)V", "showLoading", "showError", "", "fade", "fadeTakenPhoto", "(Z)V", "enablePreviewControls", "disablePreviewControls", "buttonText", "showPermissionMessage", "hideNoPermission", "Lio/reactivex/Observable;", "Lcom/avito/android/photo_picker/camera/CameraViewport$FocusArea;", "getFocusObservable", "()Lio/reactivex/Observable;", "focusObservable", "Listener", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
public interface WizardPhotoPickerView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void showPreview$default(WizardPhotoPickerView wizardPhotoPickerView, String str, Integer num, List list, PictureType pictureType, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    num = null;
                }
                wizardPhotoPickerView.showPreview(str, num, list, pictureType);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showPreview");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u0004¨\u0006\u000f"}, d2 = {"Lcom/avito/android/photo_wizard/WizardPhotoPickerView$Listener;", "", "", "onCloseClicked", "()V", "onTakePhotoClicked", "onPhotoActionClicked", "onRetakePhotoClicked", "onFlashClicked", "onRetryClicked", "Lcom/avito/android/photo_wizard/DocumentType;", "type", "onDocumentTypeClicked", "(Lcom/avito/android/photo_wizard/DocumentType;)V", "allowAccessClicked", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void allowAccessClicked();

        void onCloseClicked();

        void onDocumentTypeClicked(@NotNull DocumentType documentType);

        void onFlashClicked();

        void onPhotoActionClicked();

        void onRetakePhotoClicked();

        void onRetryClicked();

        void onTakePhotoClicked();
    }

    void disablePreviewControls();

    void enablePreviewControls();

    void fadeTakenPhoto(boolean z);

    @NotNull
    Observable<CameraViewport.FocusArea> getFocusObservable();

    @NotNull
    Dimension getFullPreviewSize();

    void hideFlashIcon();

    void hideNoPermission();

    @NotNull
    CameraViewport preview();

    void setFlashIcon(int i);

    void setPhotoWizardViewListener(@Nullable Listener listener);

    void setSurfaceMeasureListener(@Nullable Function2<? super Integer, ? super Integer, Unit> function2);

    void setTitle(@Nullable String str);

    void showError();

    void showLoading();

    void showPermissionMessage(@NotNull String str);

    void showPreview(@Nullable String str, @DrawableRes @Nullable Integer num, @NotNull List<DocumentType> list, @NotNull PictureType pictureType);

    void showTakenPhoto(@NotNull Uri uri, @NotNull String str);
}
