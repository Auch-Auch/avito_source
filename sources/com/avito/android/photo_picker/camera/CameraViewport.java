package com.avito.android.photo_picker.camera;

import a2.b.a.a.a;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Dimension;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001!J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/avito/android/photo_picker/camera/CameraViewport;", "", "Landroid/graphics/Matrix;", "matrix", "", "transformViewport", "(Landroid/graphics/Matrix;)V", "startPhotoCaptureAnimation", "()V", "", "xNormalized", "yNormalized", "startClickAnimation", "(FF)V", "Lcom/avito/android/util/Dimension;", "getDimensions", "()Lcom/avito/android/util/Dimension;", "Landroid/view/TextureView$SurfaceTextureListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSurfaceTextureListener", "(Landroid/view/TextureView$SurfaceTextureListener;)V", "", "isTextureAvailable", "()Z", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "surfaceTexture", "Lio/reactivex/Observable;", "Lcom/avito/android/photo_picker/camera/CameraViewport$FocusArea;", "getFocusObservable", "()Lio/reactivex/Observable;", "focusObservable", "FocusArea", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface CameraViewport {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/avito/android/photo_picker/camera/CameraViewport$FocusArea;", "", "Landroid/graphics/RectF;", "component1", "()Landroid/graphics/RectF;", "component2", "focusRect", "meteringRect", "copy", "(Landroid/graphics/RectF;Landroid/graphics/RectF;)Lcom/avito/android/photo_picker/camera/CameraViewport$FocusArea;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Landroid/graphics/RectF;", "getMeteringRect", AuthSource.SEND_ABUSE, "getFocusRect", "<init>", "(Landroid/graphics/RectF;Landroid/graphics/RectF;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class FocusArea {
        @NotNull
        public final RectF a;
        @NotNull
        public final RectF b;

        public FocusArea(@NotNull RectF rectF, @NotNull RectF rectF2) {
            Intrinsics.checkNotNullParameter(rectF, "focusRect");
            Intrinsics.checkNotNullParameter(rectF2, "meteringRect");
            this.a = rectF;
            this.b = rectF2;
        }

        public static /* synthetic */ FocusArea copy$default(FocusArea focusArea, RectF rectF, RectF rectF2, int i, Object obj) {
            if ((i & 1) != 0) {
                rectF = focusArea.a;
            }
            if ((i & 2) != 0) {
                rectF2 = focusArea.b;
            }
            return focusArea.copy(rectF, rectF2);
        }

        @NotNull
        public final RectF component1() {
            return this.a;
        }

        @NotNull
        public final RectF component2() {
            return this.b;
        }

        @NotNull
        public final FocusArea copy(@NotNull RectF rectF, @NotNull RectF rectF2) {
            Intrinsics.checkNotNullParameter(rectF, "focusRect");
            Intrinsics.checkNotNullParameter(rectF2, "meteringRect");
            return new FocusArea(rectF, rectF2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FocusArea)) {
                return false;
            }
            FocusArea focusArea = (FocusArea) obj;
            return Intrinsics.areEqual(this.a, focusArea.a) && Intrinsics.areEqual(this.b, focusArea.b);
        }

        @NotNull
        public final RectF getFocusRect() {
            return this.a;
        }

        @NotNull
        public final RectF getMeteringRect() {
            return this.b;
        }

        public int hashCode() {
            RectF rectF = this.a;
            int i = 0;
            int hashCode = (rectF != null ? rectF.hashCode() : 0) * 31;
            RectF rectF2 = this.b;
            if (rectF2 != null) {
                i = rectF2.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("FocusArea(focusRect=");
            L.append(this.a);
            L.append(", meteringRect=");
            L.append(this.b);
            L.append(")");
            return L.toString();
        }
    }

    @NotNull
    Dimension getDimensions();

    @NotNull
    Observable<FocusArea> getFocusObservable();

    @NotNull
    SurfaceTexture getSurfaceTexture();

    boolean isTextureAvailable();

    void setSurfaceTextureListener(@NotNull TextureView.SurfaceTextureListener surfaceTextureListener);

    void startClickAnimation(float f, float f2);

    void startPhotoCaptureAnimation();

    void transformViewport(@NotNull Matrix matrix);
}
