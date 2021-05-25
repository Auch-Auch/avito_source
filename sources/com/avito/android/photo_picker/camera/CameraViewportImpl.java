package com.avito.android.photo_picker.camera;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import com.avito.android.photo_picker.R;
import com.avito.android.photo_picker.camera.CameraViewport;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Dimension;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R:\u0010)\u001a&\u0012\f\u0012\n &*\u0004\u0018\u00010%0% &*\u0012\u0012\f\u0012\n &*\u0004\u0018\u00010%0%\u0018\u00010$0$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\"\u00102\u001a\b\u0012\u0004\u0012\u00020%0-8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101¨\u00067"}, d2 = {"Lcom/avito/android/photo_picker/camera/CameraViewportImpl;", "Lcom/avito/android/photo_picker/camera/CameraViewport;", "Landroid/graphics/Matrix;", "matrix", "", "transformViewport", "(Landroid/graphics/Matrix;)V", "startPhotoCaptureAnimation", "()V", "", "x", "y", "startClickAnimation", "(FF)V", "Lcom/avito/android/util/Dimension;", "getDimensions", "()Lcom/avito/android/util/Dimension;", "Landroid/view/TextureView$SurfaceTextureListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSurfaceTextureListener", "(Landroid/view/TextureView$SurfaceTextureListener;)V", "", "isTextureAvailable", "()Z", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "surfaceTexture", "Lcom/avito/android/photo_picker/camera/CameraAnimationCanvas;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/photo_picker/camera/CameraAnimationCanvas;", "cameraAnimationCanvas", "Landroid/view/TextureView;", "c", "Landroid/view/TextureView;", "textureView", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/photo_picker/camera/CameraViewport$FocusArea;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "touchRelay", "d", "F", "focusAreaSize", "Lio/reactivex/Observable;", "e", "Lio/reactivex/Observable;", "getFocusObservable", "()Lio/reactivex/Observable;", "focusObservable", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class CameraViewportImpl implements CameraViewport {
    public final PublishRelay<CameraViewport.FocusArea> a;
    public final CameraAnimationCanvas b;
    public final TextureView c;
    public final float d;
    @NotNull
    public final Observable<CameraViewport.FocusArea> e;

    public static final class a implements View.OnTouchListener {
        public final /* synthetic */ CameraViewportImpl a;

        public a(CameraViewportImpl cameraViewportImpl) {
            this.a = cameraViewportImpl;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            PublishRelay publishRelay = this.a.a;
            CameraViewportImpl cameraViewportImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(motionEvent, "event");
            publishRelay.accept(new CameraViewport.FocusArea(CameraViewportImpl.access$toFocusRectF(cameraViewportImpl, motionEvent, 1.0f), CameraViewportImpl.access$toFocusRectF(this.a, motionEvent, 1.5f)));
            return false;
        }
    }

    public CameraViewportImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        PublishRelay<CameraViewport.FocusArea> create = PublishRelay.create();
        this.a = create;
        View findViewById = view.findViewById(R.id.cameraAnimationCanvas);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.cameraAnimationCanvas)");
        CameraAnimationCanvas cameraAnimationCanvas = (CameraAnimationCanvas) findViewById;
        this.b = cameraAnimationCanvas;
        View findViewById2 = view.findViewById(R.id.texture);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.texture)");
        this.c = (TextureView) findViewById2;
        this.d = a2.b.a.a.a.u1(view, "view.context").getDimension(R.dimen.photo_picker_focus_area_size);
        Intrinsics.checkNotNullExpressionValue(create, "touchRelay");
        this.e = create;
        cameraAnimationCanvas.setOnTouchListener(new a(this));
    }

    public static final RectF access$toFocusRectF(CameraViewportImpl cameraViewportImpl, MotionEvent motionEvent, float f) {
        float f2 = (cameraViewportImpl.d / 2.0f) * f;
        return new RectF(Math.max(0.0f, motionEvent.getX() - f2), Math.max(0.0f, motionEvent.getY() - f2), Math.min((float) cameraViewportImpl.c.getWidth(), motionEvent.getX() + f2), Math.min((float) cameraViewportImpl.c.getHeight(), motionEvent.getY() + f2));
    }

    @Override // com.avito.android.photo_picker.camera.CameraViewport
    @NotNull
    public Dimension getDimensions() {
        return new Dimension(this.c.getWidth(), this.c.getHeight());
    }

    @Override // com.avito.android.photo_picker.camera.CameraViewport
    @NotNull
    public Observable<CameraViewport.FocusArea> getFocusObservable() {
        return this.e;
    }

    @Override // com.avito.android.photo_picker.camera.CameraViewport
    @NotNull
    public SurfaceTexture getSurfaceTexture() {
        SurfaceTexture surfaceTexture = this.c.getSurfaceTexture();
        Intrinsics.checkNotNullExpressionValue(surfaceTexture, "textureView.surfaceTexture");
        return surfaceTexture;
    }

    @Override // com.avito.android.photo_picker.camera.CameraViewport
    public boolean isTextureAvailable() {
        return this.c.isAvailable();
    }

    @Override // com.avito.android.photo_picker.camera.CameraViewport
    public void setSurfaceTextureListener(@NotNull TextureView.SurfaceTextureListener surfaceTextureListener) {
        Intrinsics.checkNotNullParameter(surfaceTextureListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.c.setSurfaceTextureListener(surfaceTextureListener);
    }

    @Override // com.avito.android.photo_picker.camera.CameraViewport
    public void startClickAnimation(float f, float f2) {
        this.b.startClickAnimation(f, f2);
    }

    @Override // com.avito.android.photo_picker.camera.CameraViewport
    public void startPhotoCaptureAnimation() {
        this.b.startPhotoCaptureAnimation();
    }

    @Override // com.avito.android.photo_picker.camera.CameraViewport
    public void transformViewport(@NotNull Matrix matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        this.c.setTransform(matrix);
    }
}
