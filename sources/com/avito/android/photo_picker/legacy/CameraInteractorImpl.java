package com.avito.android.photo_picker.legacy;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.NonFatalError;
import com.avito.android.photo.CamerasKt;
import com.avito.android.photo_picker.legacy.CameraType;
import com.avito.android.photo_picker.legacy.FlashMode;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Dimension;
import com.avito.android.util.DimensionsKt;
import com.avito.android.util.Logs;
import com.avito.android.util.NormalizedRect;
import com.avito.android.util.Rotation;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.DebugKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010=\u001a\u00020:\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u00105\u001a\u000202¢\u0006\u0004\bV\u0010WJ1\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b!\u0010\"J\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00192\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u000bH\u0016¢\u0006\u0004\b'\u0010\rJ\u0017\u0010*\u001a\u00020\u00172\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b*\u0010+J\u001f\u0010.\u001a\u00020 2\u0006\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020\u0017H\u0002¢\u0006\u0004\b.\u0010/R\u0016\u00101\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00020#0A8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u001c\u0010H\u001a\u00020\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bE\u00100\u001a\u0004\bF\u0010GR\u001c\u0010K\u001a\u00020\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bI\u00100\u001a\u0004\bJ\u0010GR\u001c\u0010N\u001a\u00020\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bL\u00100\u001a\u0004\bM\u0010GR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u00100R\u0016\u0010U\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u00100¨\u0006X"}, d2 = {"Lcom/avito/android/photo_picker/legacy/CameraInteractorImpl;", "Lcom/avito/android/photo_picker/legacy/CameraInteractor;", "Landroid/graphics/SurfaceTexture;", "surface", "Lcom/avito/android/util/Dimension;", "desiredSize", "Lcom/avito/android/util/Rotation;", "rotation", "previewSize", "startPreview", "(Landroid/graphics/SurfaceTexture;Lcom/avito/android/util/Dimension;Lcom/avito/android/util/Rotation;Lcom/avito/android/util/Dimension;)Lcom/avito/android/util/Dimension;", "", "stopPreview", "()V", "Lcom/avito/android/util/NormalizedRect;", "rect", "focusContinuous", "(Lcom/avito/android/util/NormalizedRect;)V", "Landroid/graphics/RectF;", "focusRect", "meteringRect", "focusAuto", "(Landroid/graphics/RectF;Landroid/graphics/RectF;)V", "", "focusOnShot", "Lio/reactivex/Observable;", "", "takeShot", "(Z)Lio/reactivex/Observable;", "size", "prepareCamera", "(Lcom/avito/android/util/Rotation;Lcom/avito/android/util/Dimension;)V", "", "calculatePictureRotationDegree", "(Lcom/avito/android/util/Rotation;)I", "Lcom/avito/android/photo_picker/legacy/FlashMode;", "mode", "setFlashMode", "(Lcom/avito/android/photo_picker/legacy/FlashMode;)Lio/reactivex/Observable;", "destroy", "", "focusMode", AuthSource.BOOKING_ORDER, "(Ljava/lang/String;)Z", "desiredDegree", "cameraIsMirrored", AuthSource.SEND_ABUSE, "(IZ)I", "Z", "isFocusAreasAvailable", "Lcom/avito/android/analytics/Analytics;", "k", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/photo_picker/legacy/CameraType;", "j", "Lcom/avito/android/photo_picker/legacy/CameraType;", "type", "Landroid/hardware/Camera;", "i", "Landroid/hardware/Camera;", "camera", "d", "I", "cameraOrientation", "", "getAvailableFlashModes", "()Ljava/util/List;", "availableFlashModes", "f", "getHasContinuousFocus", "()Z", "hasContinuousFocus", "h", "getHasFocusAreas", "hasFocusAreas", a2.g.r.g.a, "getHasAutoFocus", "hasAutoFocus", "Landroid/graphics/Matrix;", "e", "Landroid/graphics/Matrix;", "previewTransitionMatrix", "c", "isContinuousFocusAvailable", "isAutoFocusAvailable", "<init>", "(Landroid/hardware/Camera;Lcom/avito/android/photo_picker/legacy/CameraType;Lcom/avito/android/analytics/Analytics;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class CameraInteractorImpl implements CameraInteractor {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final int d;
    public Matrix e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final Camera i;
    public final CameraType j;
    public final Analytics k;

    public static final class a extends Lambda implements Function1<Camera.Parameters, Unit> {
        public final /* synthetic */ CameraInteractorImpl a;
        public final /* synthetic */ RectF b;
        public final /* synthetic */ RectF c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CameraInteractorImpl cameraInteractorImpl, RectF rectF, RectF rectF2) {
            super(1);
            this.a = cameraInteractorImpl;
            this.b = rectF;
            this.c = rectF2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Camera.Parameters parameters) {
            Camera.Parameters parameters2 = parameters;
            Intrinsics.checkNotNullParameter(parameters2, "$receiver");
            parameters2.setFocusMode(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
            if (parameters2.getMaxNumFocusAreas() > 0) {
                this.a.e.mapRect(this.b);
                parameters2.setFocusAreas(t6.n.d.listOf(new Camera.Area(CameraInteractorKt.access$toCameraRect(this.b), 1000)));
            }
            if (parameters2.getMaxNumMeteringAreas() > 0 && this.c != null) {
                this.a.e.mapRect(this.c);
                parameters2.setMeteringAreas(t6.n.d.listOf(new Camera.Area(CameraInteractorKt.access$toCameraRect(this.c), 1000)));
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b implements Camera.AutoFocusCallback {
        public static final b a = new b();

        @Override // android.hardware.Camera.AutoFocusCallback
        public final void onAutoFocus(boolean z, Camera camera) {
        }
    }

    public static final class c extends Lambda implements Function1<Camera.Parameters, Unit> {
        public final /* synthetic */ Rect a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Rect rect) {
            super(1);
            this.a = rect;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Camera.Parameters parameters) {
            Camera.Parameters parameters2 = parameters;
            Intrinsics.checkNotNullParameter(parameters2, "$receiver");
            parameters2.setFocusMode("continuous-picture");
            parameters2.setFocusAreas(t6.n.d.listOf(new Camera.Area(this.a, 1000)));
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<Camera.Parameters, Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Dimension b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(int i, Dimension dimension) {
            super(1);
            this.a = i;
            this.b = dimension;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Camera.Parameters parameters) {
            Camera.Parameters parameters2 = parameters;
            Intrinsics.checkNotNullParameter(parameters2, "$receiver");
            parameters2.setRotation(this.a);
            Dimension dimension = this.b;
            if (dimension != null) {
                parameters2.setPictureSize(dimension.getWidth(), this.b.getHeight());
            }
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<Camera.Parameters, Unit> {
        public final /* synthetic */ FlashMode a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(FlashMode flashMode) {
            super(1);
            this.a = flashMode;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Camera.Parameters parameters) {
            Camera.Parameters parameters2 = parameters;
            Intrinsics.checkNotNullParameter(parameters2, "$receiver");
            parameters2.setFlashMode(this.a.getValue());
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function1<Camera.Parameters, Unit> {
        public final /* synthetic */ Dimension a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Dimension dimension) {
            super(1);
            this.a = dimension;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Camera.Parameters parameters) {
            Camera.Parameters parameters2 = parameters;
            Intrinsics.checkNotNullParameter(parameters2, "$receiver");
            parameters2.setPreviewSize(this.a.getWidth(), this.a.getHeight());
            return Unit.INSTANCE;
        }
    }

    public static final class g<T, R> implements Function<Boolean, ObservableSource<? extends byte[]>> {
        public final /* synthetic */ CameraInteractorImpl a;

        public g(CameraInteractorImpl cameraInteractorImpl) {
            this.a = cameraInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends byte[]> apply(Boolean bool) {
            Intrinsics.checkNotNullParameter(bool, "it");
            return CamerasKt.takeShotObservable(this.a.i);
        }
    }

    public CameraInteractorImpl(@NotNull Camera camera, @NotNull CameraType cameraType, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(camera, "camera");
        Intrinsics.checkNotNullParameter(cameraType, "type");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.i = camera;
        this.j = cameraType;
        this.k = analytics;
        boolean b2 = b(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
        this.a = b2;
        Camera.Parameters parameters = camera.getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "camera.parameters");
        boolean z = parameters.getMaxNumFocusAreas() > 0;
        this.b = z;
        boolean b3 = b("continuous-picture");
        this.c = b3;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(cameraType.getIndex(), cameraInfo);
        this.d = cameraInfo.orientation;
        this.e = new Matrix();
        this.f = b3;
        this.g = b2;
        this.h = z;
    }

    public final int a(int i2, boolean z) {
        if (z) {
            return (360 - ((this.d + i2) % 360)) % 360;
        }
        return ((this.d - i2) + 360) % 360;
    }

    public final boolean b(String str) {
        List<String> supportedFocusModes;
        Camera.Parameters parameters = this.i.getParameters();
        if (parameters == null || (supportedFocusModes = parameters.getSupportedFocusModes()) == null) {
            return false;
        }
        return supportedFocusModes.contains(str);
    }

    @Override // com.avito.android.photo_picker.legacy.CameraInteractor
    public int calculatePictureRotationDegree(@NotNull Rotation rotation) {
        Intrinsics.checkNotNullParameter(rotation, "rotation");
        int a3 = a(rotation.getDegree(), false);
        if (Intrinsics.areEqual(this.j, CameraType.FrontCamera.INSTANCE)) {
            return (!Intrinsics.areEqual(rotation, new Rotation.Rotation_90()) && !Intrinsics.areEqual(rotation, new Rotation.Rotation_270())) ? a3 : (a3 + 180) % 360;
        }
        return a3;
    }

    @Override // com.avito.android.photo_picker.legacy.CameraInteractor
    public void destroy() {
        this.i.release();
    }

    @Override // com.avito.android.photo_picker.legacy.CameraInteractor
    public void focusAuto(@NotNull RectF rectF, @Nullable RectF rectF2) {
        Intrinsics.checkNotNullParameter(rectF, "focusRect");
        try {
            this.i.cancelAutoFocus();
            CameraInteractorKt.access$changeParams(this.i, new a(this, rectF, rectF2));
            this.i.autoFocus(b.a);
        } catch (RuntimeException e2) {
            Logs.debug("Can't focus on rect " + rectF, e2);
        }
    }

    @Override // com.avito.android.photo_picker.legacy.CameraInteractor
    public void focusContinuous(@NotNull NormalizedRect normalizedRect) {
        Intrinsics.checkNotNullParameter(normalizedRect, "rect");
        CameraInteractorKt.access$changeParams(this.i, new c(CameraInteractorKt.access$toCameraRect(normalizedRect)));
        this.i.cancelAutoFocus();
    }

    @Override // com.avito.android.photo_picker.legacy.CameraInteractor
    @NotNull
    public List<FlashMode> getAvailableFlashModes() {
        List<String> supportedFlashModes;
        Camera.Parameters parameters = this.i.getParameters();
        if (parameters == null || (supportedFlashModes = parameters.getSupportedFlashModes()) == null) {
            return t6.n.d.listOf(FlashMode.Off.INSTANCE);
        }
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(supportedFlashModes, 10));
        for (T t : supportedFlashModes) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            arrayList.add(FlashModeKt.getFlashModeByValue(t));
        }
        List<FlashMode> filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(arrayList);
        return (filterNotNull == null || filterNotNull.isEmpty()) ? t6.n.d.listOf(FlashMode.Off.INSTANCE) : filterNotNull;
    }

    @Override // com.avito.android.photo_picker.legacy.CameraInteractor
    public boolean getHasAutoFocus() {
        return this.g;
    }

    @Override // com.avito.android.photo_picker.legacy.CameraInteractor
    public boolean getHasContinuousFocus() {
        return this.f;
    }

    @Override // com.avito.android.photo_picker.legacy.CameraInteractor
    public boolean getHasFocusAreas() {
        return this.h;
    }

    @Override // com.avito.android.photo_picker.legacy.CameraInteractor
    public void prepareCamera(@NotNull Rotation rotation, @NotNull Dimension dimension) {
        Intrinsics.checkNotNullParameter(rotation, "rotation");
        Intrinsics.checkNotNullParameter(dimension, "size");
        int calculatePictureRotationDegree = calculatePictureRotationDegree(rotation);
        Dimension rotate = DimensionsKt.rotate(dimension, calculatePictureRotationDegree);
        Camera.Parameters parameters = this.i.getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "camera.parameters");
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        Intrinsics.checkNotNullExpressionValue(supportedPictureSizes, "camera.parameters.supportedPictureSizes");
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(supportedPictureSizes, 10));
        for (T t : supportedPictureSizes) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            arrayList.add(CameraInteractorKt.access$toDimension(t));
        }
        CameraInteractorKt.access$changeParams(this.i, new d(calculatePictureRotationDegree, DimensionsKt.findBestMatchByRatio(arrayList, rotate, 1)));
    }

    @Override // com.avito.android.photo_picker.legacy.CameraInteractor
    @NotNull
    public Observable<Unit> setFlashMode(@NotNull FlashMode flashMode) {
        Intrinsics.checkNotNullParameter(flashMode, "mode");
        return CameraInteractorKt.access$changeParamsObservable(this.i, new e(flashMode));
    }

    @Override // com.avito.android.photo_picker.legacy.CameraInteractor
    @Nullable
    public Dimension startPreview(@NotNull SurfaceTexture surfaceTexture, @NotNull Dimension dimension, @NotNull Rotation rotation, @NotNull Dimension dimension2) {
        Camera.Size previewSize;
        Dimension access$toDimension;
        Intrinsics.checkNotNullParameter(surfaceTexture, "surface");
        Intrinsics.checkNotNullParameter(dimension, "desiredSize");
        Intrinsics.checkNotNullParameter(rotation, "rotation");
        Intrinsics.checkNotNullParameter(dimension2, "previewSize");
        int a3 = a(rotation.getDegree(), Intrinsics.areEqual(this.j, CameraType.FrontCamera.INSTANCE));
        this.i.setDisplayOrientation(a3);
        this.e.postRotate((float) a3);
        this.e.postScale(((float) dimension2.getWidth()) / 2000.0f, ((float) dimension2.getHeight()) / 2000.0f);
        this.e.postTranslate(((float) dimension2.getWidth()) / 2.0f, ((float) dimension2.getHeight()) / 2.0f);
        Matrix matrix = this.e;
        matrix.invert(matrix);
        Dimension rotate = DimensionsKt.rotate(dimension, this.d);
        Camera.Parameters parameters = this.i.getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "camera.parameters");
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        Intrinsics.checkNotNullExpressionValue(supportedPreviewSizes, "camera.parameters.supportedPreviewSizes");
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(supportedPreviewSizes, 10));
        for (T t : supportedPreviewSizes) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            arrayList.add(CameraInteractorKt.access$toDimension(t));
        }
        Dimension findBestMatchByRatio = DimensionsKt.findBestMatchByRatio(arrayList, rotate, 2);
        if (findBestMatchByRatio != null) {
            CameraInteractorKt.access$changeParams(this.i, new f(findBestMatchByRatio));
        }
        Camera.Parameters parameters2 = this.i.getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters2, "camera.parameters");
        Camera.Size previewSize2 = parameters2.getPreviewSize();
        if (previewSize2 != null) {
            surfaceTexture.setDefaultBufferSize(previewSize2.width, previewSize2.height);
        }
        this.i.setPreviewTexture(surfaceTexture);
        this.i.startPreview();
        Camera.Parameters parameters3 = this.i.getParameters();
        if (parameters3 == null || (previewSize = parameters3.getPreviewSize()) == null || (access$toDimension = CameraInteractorKt.access$toDimension(previewSize)) == null) {
            return null;
        }
        return DimensionsKt.rotate(access$toDimension, a3);
    }

    @Override // com.avito.android.photo_picker.legacy.CameraInteractor
    public void stopPreview() {
        try {
            this.i.stopPreview();
        } catch (Exception e2) {
            this.k.track(new NonFatalError("error", e2, null, 4, null));
        }
    }

    @Override // com.avito.android.photo_picker.legacy.CameraInteractor
    @NotNull
    public Observable<byte[]> takeShot(boolean z) {
        Observable<Boolean> observable;
        if (z) {
            observable = CamerasKt.focusObservable(this.i).take(1);
        } else {
            observable = Observable.just(Boolean.TRUE);
        }
        Observable<byte[]> concatMap = observable.concatMap(new g(this));
        Intrinsics.checkNotNullExpressionValue(concatMap, "if (focusOnShot) {\n     …ra.takeShotObservable() }");
        return concatMap;
    }
}
