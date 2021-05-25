package com.avito.android.photo_picker.legacy;

import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import com.avito.android.util.Dimension;
import com.avito.android.util.NormalizedRect;
import com.avito.android.util.Rotation;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0015H&¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\b\b\u0002\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b!\u0010\"J\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\u001c2\u0006\u0010$\u001a\u00020#H&¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0006H&¢\u0006\u0004\b'\u0010\u0010R\u0016\u0010*\u001a\u00020\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010)R\u0016\u0010.\u001a\u00020\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010)R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020#0/8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00063"}, d2 = {"Lcom/avito/android/photo_picker/legacy/CameraInteractor;", "", "Lcom/avito/android/util/Rotation;", "rotation", "Lcom/avito/android/util/Dimension;", "size", "", "prepareCamera", "(Lcom/avito/android/util/Rotation;Lcom/avito/android/util/Dimension;)V", "Landroid/graphics/SurfaceTexture;", "surface", "desiredSize", "previewSize", "startPreview", "(Landroid/graphics/SurfaceTexture;Lcom/avito/android/util/Dimension;Lcom/avito/android/util/Rotation;Lcom/avito/android/util/Dimension;)Lcom/avito/android/util/Dimension;", "stopPreview", "()V", "Lcom/avito/android/util/NormalizedRect;", "rect", "focusContinuous", "(Lcom/avito/android/util/NormalizedRect;)V", "Landroid/graphics/RectF;", "focusRect", "meteringRect", "focusAuto", "(Landroid/graphics/RectF;Landroid/graphics/RectF;)V", "", "focusOnShot", "Lio/reactivex/Observable;", "", "takeShot", "(Z)Lio/reactivex/Observable;", "", "calculatePictureRotationDegree", "(Lcom/avito/android/util/Rotation;)I", "Lcom/avito/android/photo_picker/legacy/FlashMode;", "mode", "setFlashMode", "(Lcom/avito/android/photo_picker/legacy/FlashMode;)Lio/reactivex/Observable;", "destroy", "getHasAutoFocus", "()Z", "hasAutoFocus", "getHasFocusAreas", "hasFocusAreas", "getHasContinuousFocus", "hasContinuousFocus", "", "getAvailableFlashModes", "()Ljava/util/List;", "availableFlashModes", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface CameraInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void focusAuto$default(CameraInteractor cameraInteractor, RectF rectF, RectF rectF2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    rectF2 = null;
                }
                cameraInteractor.focusAuto(rectF, rectF2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: focusAuto");
        }

        public static /* synthetic */ Observable takeShot$default(CameraInteractor cameraInteractor, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = true;
                }
                return cameraInteractor.takeShot(z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeShot");
        }
    }

    int calculatePictureRotationDegree(@NotNull Rotation rotation);

    void destroy();

    void focusAuto(@NotNull RectF rectF, @Nullable RectF rectF2);

    void focusContinuous(@NotNull NormalizedRect normalizedRect);

    @NotNull
    List<FlashMode> getAvailableFlashModes();

    boolean getHasAutoFocus();

    boolean getHasContinuousFocus();

    boolean getHasFocusAreas();

    void prepareCamera(@NotNull Rotation rotation, @NotNull Dimension dimension);

    @NotNull
    Observable<Unit> setFlashMode(@NotNull FlashMode flashMode);

    @Nullable
    Dimension startPreview(@NotNull SurfaceTexture surfaceTexture, @NotNull Dimension dimension, @NotNull Rotation rotation, @NotNull Dimension dimension2);

    void stopPreview();

    @NotNull
    Observable<byte[]> takeShot(boolean z);
}
