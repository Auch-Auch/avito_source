package com.otaliastudios.cameraview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.location.Location;
import android.media.MediaActionSound;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.facebook.internal.AnalyticsEvents;
import com.otaliastudios.cameraview.PictureResult;
import com.otaliastudios.cameraview.VideoResult;
import com.otaliastudios.cameraview.controls.Audio;
import com.otaliastudios.cameraview.controls.AudioCodec;
import com.otaliastudios.cameraview.controls.Control;
import com.otaliastudios.cameraview.controls.ControlParser;
import com.otaliastudios.cameraview.controls.Engine;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Grid;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.Mode;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.controls.Preview;
import com.otaliastudios.cameraview.controls.VideoCodec;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import com.otaliastudios.cameraview.engine.Camera1Engine;
import com.otaliastudios.cameraview.engine.Camera2Engine;
import com.otaliastudios.cameraview.engine.CameraEngine;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import com.otaliastudios.cameraview.filter.Filter;
import com.otaliastudios.cameraview.filter.FilterParser;
import com.otaliastudios.cameraview.filter.NoFilter;
import com.otaliastudios.cameraview.filter.OneParameterFilter;
import com.otaliastudios.cameraview.filter.TwoParameterFilter;
import com.otaliastudios.cameraview.frame.Frame;
import com.otaliastudios.cameraview.frame.FrameProcessor;
import com.otaliastudios.cameraview.gesture.Gesture;
import com.otaliastudios.cameraview.gesture.GestureAction;
import com.otaliastudios.cameraview.gesture.GestureFinder;
import com.otaliastudios.cameraview.gesture.GestureParser;
import com.otaliastudios.cameraview.gesture.PinchGestureFinder;
import com.otaliastudios.cameraview.gesture.ScrollGestureFinder;
import com.otaliastudios.cameraview.gesture.TapGestureFinder;
import com.otaliastudios.cameraview.internal.CropHelper;
import com.otaliastudios.cameraview.internal.GridLinesLayout;
import com.otaliastudios.cameraview.internal.OrientationHelper;
import com.otaliastudios.cameraview.markers.AutoFocusMarker;
import com.otaliastudios.cameraview.markers.AutoFocusTrigger;
import com.otaliastudios.cameraview.markers.MarkerLayout;
import com.otaliastudios.cameraview.markers.MarkerParser;
import com.otaliastudios.cameraview.metering.MeteringRegions;
import com.otaliastudios.cameraview.overlay.OverlayLayout;
import com.otaliastudios.cameraview.preview.CameraPreview;
import com.otaliastudios.cameraview.preview.FilterCameraPreview;
import com.otaliastudios.cameraview.preview.GlCameraPreview;
import com.otaliastudios.cameraview.preview.SurfaceCameraPreview;
import com.otaliastudios.cameraview.preview.TextureCameraPreview;
import com.otaliastudios.cameraview.size.AspectRatio;
import com.otaliastudios.cameraview.size.Size;
import com.otaliastudios.cameraview.size.SizeSelector;
import com.otaliastudios.cameraview.size.SizeSelectorParser;
import java.io.File;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
public class CameraView extends FrameLayout implements LifecycleObserver {
    public static final String D;
    public static final CameraLogger E;
    public static final int PERMISSION_REQUEST_CODE = 16;
    public boolean A;
    public boolean B;
    @VisibleForTesting
    public OverlayLayout C;
    public boolean a;
    public boolean b;
    public boolean c;
    public HashMap<Gesture, GestureAction> d = new HashMap<>(4);
    public Preview e;
    public Engine f;
    public Filter g;
    public int h;
    public Handler i;
    public Executor j;
    @VisibleForTesting
    public f k;
    public CameraPreview l;
    public OrientationHelper m;
    public CameraEngine n;
    public Size o;
    public MediaActionSound p;
    public AutoFocusMarker q;
    @VisibleForTesting
    public List<CameraListener> r = new CopyOnWriteArrayList();
    @VisibleForTesting
    public List<FrameProcessor> s = new CopyOnWriteArrayList();
    public Lifecycle t;
    @VisibleForTesting
    public PinchGestureFinder u;
    @VisibleForTesting
    public TapGestureFinder v;
    @VisibleForTesting
    public ScrollGestureFinder w;
    @VisibleForTesting
    public GridLinesLayout x;
    @VisibleForTesting
    public MarkerLayout y;
    public boolean z;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraView cameraView = CameraView.this;
            cameraView.z = cameraView.getKeepScreenOn();
            CameraView cameraView2 = CameraView.this;
            if (!cameraView2.z) {
                cameraView2.setKeepScreenOn(true);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraView cameraView = CameraView.this;
            cameraView.z = cameraView.getKeepScreenOn();
            CameraView cameraView2 = CameraView.this;
            if (!cameraView2.z) {
                cameraView2.setKeepScreenOn(true);
            }
        }
    }

    public class c extends CameraListener {
        public final /* synthetic */ int a;

        public c(int i) {
            this.a = i;
        }

        @Override // com.otaliastudios.cameraview.CameraListener
        public void onCameraError(@NonNull CameraException cameraException) {
            super.onCameraError(cameraException);
            if (cameraException.getReason() == 5) {
                CameraView.this.setVideoMaxDuration(this.a);
                CameraView.this.removeCameraListener(this);
            }
        }

        @Override // com.otaliastudios.cameraview.CameraListener
        public void onVideoTaken(@NonNull VideoResult videoResult) {
            CameraView.this.setVideoMaxDuration(this.a);
            CameraView.this.removeCameraListener(this);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean keepScreenOn = CameraView.this.getKeepScreenOn();
            CameraView cameraView = CameraView.this;
            boolean z = cameraView.z;
            if (keepScreenOn != z) {
                cameraView.setKeepScreenOn(z);
            }
        }
    }

    public class e implements ThreadFactory {
        public final AtomicInteger a = new AtomicInteger(1);

        public e(CameraView cameraView) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            StringBuilder L = a2.b.a.a.a.L("FrameExecutor #");
            L.append(this.a.getAndIncrement());
            return new Thread(runnable, L.toString());
        }
    }

    @VisibleForTesting
    public class f implements CameraEngine.Callback, OrientationHelper.Callback, GestureFinder.Controller {
        public final String a;
        public final CameraLogger b;

        public class a implements Runnable {
            public final /* synthetic */ float a;
            public final /* synthetic */ PointF[] b;

            public a(float f, PointF[] pointFArr) {
                this.a = f;
                this.b = pointFArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                for (CameraListener cameraListener : CameraView.this.r) {
                    cameraListener.onZoomChanged(this.a, new float[]{0.0f, 1.0f}, this.b);
                }
            }
        }

        public class b implements Runnable {
            public final /* synthetic */ float a;
            public final /* synthetic */ float[] b;
            public final /* synthetic */ PointF[] c;

            public b(float f, float[] fArr, PointF[] pointFArr) {
                this.a = f;
                this.b = fArr;
                this.c = pointFArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                for (CameraListener cameraListener : CameraView.this.r) {
                    cameraListener.onExposureCorrectionChanged(this.a, this.b, this.c);
                }
            }
        }

        public class c implements Runnable {
            public final /* synthetic */ Frame a;

            public c(Frame frame) {
                this.a = frame;
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.b.v("dispatchFrame: executing. Passing", Long.valueOf(this.a.getTime()), "to processors.");
                for (FrameProcessor frameProcessor : CameraView.this.s) {
                    try {
                        frameProcessor.process(this.a);
                    } catch (Exception e) {
                        f.this.b.w("Frame processor crashed:", e);
                    }
                }
                this.a.release();
            }
        }

        public class d implements Runnable {
            public final /* synthetic */ CameraException a;

            public d(CameraException cameraException) {
                this.a = cameraException;
            }

            @Override // java.lang.Runnable
            public void run() {
                for (CameraListener cameraListener : CameraView.this.r) {
                    cameraListener.onCameraError(this.a);
                }
            }
        }

        public class e implements Runnable {
            public e() {
            }

            @Override // java.lang.Runnable
            public void run() {
                for (CameraListener cameraListener : CameraView.this.r) {
                    cameraListener.onVideoRecordingStart();
                }
            }
        }

        /* renamed from: com.otaliastudios.cameraview.CameraView$f$f  reason: collision with other inner class name */
        public class RunnableC0308f implements Runnable {
            public RunnableC0308f() {
            }

            @Override // java.lang.Runnable
            public void run() {
                for (CameraListener cameraListener : CameraView.this.r) {
                    cameraListener.onVideoRecordingEnd();
                }
            }
        }

        public class g implements Runnable {
            public final /* synthetic */ CameraOptions a;

            public g(CameraOptions cameraOptions) {
                this.a = cameraOptions;
            }

            @Override // java.lang.Runnable
            public void run() {
                for (CameraListener cameraListener : CameraView.this.r) {
                    cameraListener.onCameraOpened(this.a);
                }
            }
        }

        public class h implements Runnable {
            public h() {
            }

            @Override // java.lang.Runnable
            public void run() {
                for (CameraListener cameraListener : CameraView.this.r) {
                    cameraListener.onCameraClosed();
                }
            }
        }

        public class i implements Runnable {
            public i() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CameraView.this.requestLayout();
            }
        }

        public class j implements Runnable {
            public j() {
            }

            @Override // java.lang.Runnable
            public void run() {
                for (CameraListener cameraListener : CameraView.this.r) {
                    cameraListener.onPictureShutter();
                }
            }
        }

        public class k implements Runnable {
            public final /* synthetic */ PictureResult.Stub a;

            public k(PictureResult.Stub stub) {
                this.a = stub;
            }

            @Override // java.lang.Runnable
            public void run() {
                PictureResult pictureResult = new PictureResult(this.a);
                for (CameraListener cameraListener : CameraView.this.r) {
                    cameraListener.onPictureTaken(pictureResult);
                }
            }
        }

        public class l implements Runnable {
            public final /* synthetic */ VideoResult.Stub a;

            public l(VideoResult.Stub stub) {
                this.a = stub;
            }

            @Override // java.lang.Runnable
            public void run() {
                VideoResult videoResult = new VideoResult(this.a);
                for (CameraListener cameraListener : CameraView.this.r) {
                    cameraListener.onVideoTaken(videoResult);
                }
            }
        }

        public class m implements Runnable {
            public final /* synthetic */ PointF a;
            public final /* synthetic */ Gesture b;

            public m(PointF pointF, Gesture gesture) {
                this.a = pointF;
                this.b = gesture;
            }

            @Override // java.lang.Runnable
            public void run() {
                CameraView.this.y.onEvent(1, new PointF[]{this.a});
                AutoFocusMarker autoFocusMarker = CameraView.this.q;
                if (autoFocusMarker != null) {
                    autoFocusMarker.onAutoFocusStart(this.b != null ? AutoFocusTrigger.GESTURE : AutoFocusTrigger.METHOD, this.a);
                }
                for (CameraListener cameraListener : CameraView.this.r) {
                    cameraListener.onAutoFocusStart(this.a);
                }
            }
        }

        public class n implements Runnable {
            public final /* synthetic */ boolean a;
            public final /* synthetic */ Gesture b;
            public final /* synthetic */ PointF c;

            public n(boolean z, Gesture gesture, PointF pointF) {
                this.a = z;
                this.b = gesture;
                this.c = pointF;
            }

            @Override // java.lang.Runnable
            public void run() {
                CameraView cameraView;
                boolean z;
                if (this.a && (z = (cameraView = CameraView.this).a) && z) {
                    if (cameraView.p == null) {
                        cameraView.p = new MediaActionSound();
                    }
                    cameraView.p.play(1);
                }
                AutoFocusMarker autoFocusMarker = CameraView.this.q;
                if (autoFocusMarker != null) {
                    autoFocusMarker.onAutoFocusEnd(this.b != null ? AutoFocusTrigger.GESTURE : AutoFocusTrigger.METHOD, this.a, this.c);
                }
                for (CameraListener cameraListener : CameraView.this.r) {
                    cameraListener.onAutoFocusEnd(this.a, this.c);
                }
            }
        }

        public class o implements Runnable {
            public final /* synthetic */ int a;

            public o(int i) {
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                for (CameraListener cameraListener : CameraView.this.r) {
                    cameraListener.onOrientationChanged(this.a);
                }
            }
        }

        public f() {
            String simpleName = f.class.getSimpleName();
            this.a = simpleName;
            this.b = CameraLogger.create(simpleName);
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public void dispatchError(CameraException cameraException) {
            this.b.i("dispatchError", cameraException);
            CameraView.this.i.post(new d(cameraException));
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public void dispatchFrame(@NonNull Frame frame) {
            this.b.v("dispatchFrame:", Long.valueOf(frame.getTime()), "processors:", Integer.valueOf(CameraView.this.s.size()));
            if (CameraView.this.s.isEmpty()) {
                frame.release();
            } else {
                CameraView.this.j.execute(new c(frame));
            }
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public void dispatchOnCameraClosed() {
            this.b.i("dispatchOnCameraClosed");
            CameraView.this.i.post(new h());
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public void dispatchOnCameraOpened(@NonNull CameraOptions cameraOptions) {
            this.b.i("dispatchOnCameraOpened", cameraOptions);
            CameraView.this.i.post(new g(cameraOptions));
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public void dispatchOnExposureCorrectionChanged(float f, @NonNull float[] fArr, @Nullable PointF[] pointFArr) {
            this.b.i("dispatchOnExposureCorrectionChanged", Float.valueOf(f));
            CameraView.this.i.post(new b(f, fArr, pointFArr));
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public void dispatchOnFocusEnd(@Nullable Gesture gesture, boolean z, @NonNull PointF pointF) {
            this.b.i("dispatchOnFocusEnd", gesture, Boolean.valueOf(z), pointF);
            CameraView.this.i.post(new n(z, gesture, pointF));
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public void dispatchOnFocusStart(@Nullable Gesture gesture, @NonNull PointF pointF) {
            this.b.i("dispatchOnFocusStart", gesture, pointF);
            CameraView.this.i.post(new m(pointF, gesture));
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public void dispatchOnPictureShutter(boolean z) {
            CameraView cameraView;
            boolean z2;
            if (z && (z2 = (cameraView = CameraView.this).a) && z2) {
                if (cameraView.p == null) {
                    cameraView.p = new MediaActionSound();
                }
                cameraView.p.play(0);
            }
            CameraView.this.i.post(new j());
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public void dispatchOnPictureTaken(@NonNull PictureResult.Stub stub) {
            this.b.i("dispatchOnPictureTaken", stub);
            CameraView.this.i.post(new k(stub));
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public void dispatchOnVideoRecordingEnd() {
            this.b.i("dispatchOnVideoRecordingEnd");
            CameraView.this.i.post(new RunnableC0308f());
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public void dispatchOnVideoRecordingStart() {
            this.b.i("dispatchOnVideoRecordingStart");
            CameraView.this.i.post(new e());
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public void dispatchOnVideoTaken(@NonNull VideoResult.Stub stub) {
            this.b.i("dispatchOnVideoTaken", stub);
            CameraView.this.i.post(new l(stub));
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public void dispatchOnZoomChanged(float f, @Nullable PointF[] pointFArr) {
            this.b.i("dispatchOnZoomChanged", Float.valueOf(f));
            CameraView.this.i.post(new a(f, pointFArr));
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback, com.otaliastudios.cameraview.gesture.GestureFinder.Controller
        @NonNull
        public Context getContext() {
            return CameraView.this.getContext();
        }

        @Override // com.otaliastudios.cameraview.gesture.GestureFinder.Controller
        public int getHeight() {
            return CameraView.this.getHeight();
        }

        @Override // com.otaliastudios.cameraview.gesture.GestureFinder.Controller
        public int getWidth() {
            return CameraView.this.getWidth();
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public void onCameraPreviewStreamSizeChanged() {
            Size previewStreamSize = CameraView.this.n.getPreviewStreamSize(Reference.VIEW);
            if (previewStreamSize == null) {
                throw new RuntimeException("Preview stream size should not be null here.");
            } else if (previewStreamSize.equals(CameraView.this.o)) {
                this.b.i("onCameraPreviewStreamSizeChanged:", "swallowing because the preview size has not changed.", previewStreamSize);
            } else {
                this.b.i("onCameraPreviewStreamSizeChanged: posting a requestLayout call.", "Preview stream size:", previewStreamSize);
                CameraView.this.i.post(new i());
            }
        }

        @Override // com.otaliastudios.cameraview.internal.OrientationHelper.Callback
        public void onDeviceOrientationChanged(int i2) {
            this.b.i("onDeviceOrientationChanged", Integer.valueOf(i2));
            int lastDisplayOffset = CameraView.this.m.getLastDisplayOffset();
            CameraView cameraView = CameraView.this;
            if (!cameraView.b) {
                cameraView.n.getAngles().setDeviceOrientation((360 - lastDisplayOffset) % 360);
            } else {
                cameraView.n.getAngles().setDeviceOrientation(i2);
            }
            CameraView.this.i.post(new o((i2 + lastDisplayOffset) % 360));
        }

        @Override // com.otaliastudios.cameraview.internal.OrientationHelper.Callback
        public void onDisplayOffsetChanged(int i2, boolean z) {
            this.b.i("onDisplayOffsetChanged", Integer.valueOf(i2), "recreate:", Boolean.valueOf(z));
            if (CameraView.this.isOpened() && !z) {
                this.b.w("onDisplayOffsetChanged", "restarting the camera.");
                CameraView.this.close();
                CameraView.this.open();
            }
        }
    }

    static {
        String simpleName = CameraView.class.getSimpleName();
        D = simpleName;
        E = CameraLogger.create(simpleName);
    }

    public CameraView(@NonNull Context context) {
        super(context, null);
        b(context, null);
    }

    public final void a() {
        CameraLogger cameraLogger = E;
        cameraLogger.w("doInstantiateEngine:", "instantiating. engine:", this.f);
        CameraEngine instantiateCameraEngine = instantiateCameraEngine(this.f, this.k);
        this.n = instantiateCameraEngine;
        cameraLogger.w("doInstantiateEngine:", "instantiated. engine:", instantiateCameraEngine.getClass().getSimpleName());
        this.n.setOverlay(this.C);
    }

    public void addCameraListener(@NonNull CameraListener cameraListener) {
        this.r.add(cameraListener);
    }

    public void addFrameProcessor(@Nullable FrameProcessor frameProcessor) {
        if (frameProcessor != null) {
            this.s.add(frameProcessor);
            if (this.s.size() == 1) {
                this.n.setHasFrameProcessors(true);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (this.B || !this.C.isOverlay(layoutParams)) {
            super.addView(view, i2, layoutParams);
        } else {
            this.C.addView(view, layoutParams);
        }
    }

    public final void b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        boolean isInEditMode = isInEditMode();
        this.B = isInEditMode;
        if (!isInEditMode) {
            setWillNotDraw(false);
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.CameraView, 0, 0);
            ControlParser controlParser = new ControlParser(context, obtainStyledAttributes);
            boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.CameraView_cameraPlaySounds, true);
            boolean z3 = obtainStyledAttributes.getBoolean(R.styleable.CameraView_cameraUseDeviceOrientation, true);
            this.A = obtainStyledAttributes.getBoolean(R.styleable.CameraView_cameraExperimental, false);
            this.c = obtainStyledAttributes.getBoolean(R.styleable.CameraView_cameraRequestPermissions, true);
            this.e = controlParser.getPreview();
            this.f = controlParser.getEngine();
            int color = obtainStyledAttributes.getColor(R.styleable.CameraView_cameraGridColor, GridLinesLayout.DEFAULT_COLOR);
            long j2 = (long) obtainStyledAttributes.getFloat(R.styleable.CameraView_cameraVideoMaxSize, 0.0f);
            int integer = obtainStyledAttributes.getInteger(R.styleable.CameraView_cameraVideoMaxDuration, 0);
            int integer2 = obtainStyledAttributes.getInteger(R.styleable.CameraView_cameraVideoBitRate, 0);
            int integer3 = obtainStyledAttributes.getInteger(R.styleable.CameraView_cameraAudioBitRate, 0);
            float f2 = obtainStyledAttributes.getFloat(R.styleable.CameraView_cameraPreviewFrameRate, 0.0f);
            boolean z4 = obtainStyledAttributes.getBoolean(R.styleable.CameraView_cameraPreviewFrameRateExact, false);
            long integer4 = (long) obtainStyledAttributes.getInteger(R.styleable.CameraView_cameraAutoFocusResetDelay, 3000);
            boolean z5 = obtainStyledAttributes.getBoolean(R.styleable.CameraView_cameraPictureMetering, true);
            boolean z7 = obtainStyledAttributes.getBoolean(R.styleable.CameraView_cameraPictureSnapshotMetering, false);
            int integer5 = obtainStyledAttributes.getInteger(R.styleable.CameraView_cameraSnapshotMaxWidth, 0);
            int integer6 = obtainStyledAttributes.getInteger(R.styleable.CameraView_cameraSnapshotMaxHeight, 0);
            int integer7 = obtainStyledAttributes.getInteger(R.styleable.CameraView_cameraFrameProcessingMaxWidth, 0);
            int integer8 = obtainStyledAttributes.getInteger(R.styleable.CameraView_cameraFrameProcessingMaxHeight, 0);
            int integer9 = obtainStyledAttributes.getInteger(R.styleable.CameraView_cameraFrameProcessingFormat, 0);
            int integer10 = obtainStyledAttributes.getInteger(R.styleable.CameraView_cameraFrameProcessingPoolSize, 2);
            int integer11 = obtainStyledAttributes.getInteger(R.styleable.CameraView_cameraFrameProcessingExecutors, 1);
            SizeSelectorParser sizeSelectorParser = new SizeSelectorParser(obtainStyledAttributes);
            GestureParser gestureParser = new GestureParser(obtainStyledAttributes);
            MarkerParser markerParser = new MarkerParser(obtainStyledAttributes);
            FilterParser filterParser = new FilterParser(obtainStyledAttributes);
            obtainStyledAttributes.recycle();
            this.k = new f();
            this.i = new Handler(Looper.getMainLooper());
            this.u = new PinchGestureFinder(this.k);
            this.v = new TapGestureFinder(this.k);
            this.w = new ScrollGestureFinder(this.k);
            this.x = new GridLinesLayout(context);
            this.C = new OverlayLayout(context);
            this.y = new MarkerLayout(context);
            addView(this.x);
            addView(this.y);
            addView(this.C);
            a();
            setPlaySounds(z2);
            setUseDeviceOrientation(z3);
            setGrid(controlParser.getGrid());
            setGridColor(color);
            setFacing(controlParser.getFacing());
            setFlash(controlParser.getFlash());
            setMode(controlParser.getMode());
            setWhiteBalance(controlParser.getWhiteBalance());
            setHdr(controlParser.getHdr());
            setAudio(controlParser.getAudio());
            setAudioBitRate(integer3);
            setAudioCodec(controlParser.getAudioCodec());
            setPictureSize(sizeSelectorParser.getPictureSizeSelector());
            setPictureMetering(z5);
            setPictureSnapshotMetering(z7);
            setPictureFormat(controlParser.getPictureFormat());
            setVideoSize(sizeSelectorParser.getVideoSizeSelector());
            setVideoCodec(controlParser.getVideoCodec());
            setVideoMaxSize(j2);
            setVideoMaxDuration(integer);
            setVideoBitRate(integer2);
            setAutoFocusResetDelay(integer4);
            setPreviewFrameRateExact(z4);
            setPreviewFrameRate(f2);
            setSnapshotMaxWidth(integer5);
            setSnapshotMaxHeight(integer6);
            setFrameProcessingMaxWidth(integer7);
            setFrameProcessingMaxHeight(integer8);
            setFrameProcessingFormat(integer9);
            setFrameProcessingPoolSize(integer10);
            setFrameProcessingExecutors(integer11);
            mapGesture(Gesture.TAP, gestureParser.getTapAction());
            mapGesture(Gesture.LONG_TAP, gestureParser.getLongTapAction());
            mapGesture(Gesture.PINCH, gestureParser.getPinchAction());
            mapGesture(Gesture.SCROLL_HORIZONTAL, gestureParser.getHorizontalScrollAction());
            mapGesture(Gesture.SCROLL_VERTICAL, gestureParser.getVerticalScrollAction());
            setAutoFocusMarker(markerParser.getAutoFocusMarker());
            setFilter(filterParser.getFilter());
            this.m = new OrientationHelper(context, this.k);
        }
    }

    public final boolean c() {
        return this.n.getState() == CameraState.OFF && !this.n.isChangingState();
    }

    @SuppressLint({"NewApi"})
    public boolean checkPermissions(@NonNull Audio audio) {
        if (audio == Audio.ON || audio == Audio.MONO || audio == Audio.STEREO) {
            try {
                for (String str : getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 4096).requestedPermissions) {
                    if (!str.equals("android.permission.RECORD_AUDIO")) {
                    }
                }
                throw new IllegalStateException(E.e("Permission error: when audio is enabled (Audio.ON) the RECORD_AUDIO permission should be added to the app manifest file."));
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        Context context = getContext();
        boolean z2 = audio == Audio.ON || audio == Audio.MONO || audio == Audio.STEREO;
        boolean z3 = context.checkSelfPermission("android.permission.CAMERA") != 0;
        boolean z4 = z2 && context.checkSelfPermission("android.permission.RECORD_AUDIO") != 0;
        if (!(z3 || z4)) {
            return true;
        }
        if (this.c) {
            Activity activity = null;
            for (Context context2 = getContext(); context2 instanceof ContextWrapper; context2 = ((ContextWrapper) context2).getBaseContext()) {
                if (context2 instanceof Activity) {
                    activity = (Activity) context2;
                }
            }
            ArrayList arrayList = new ArrayList();
            if (z3) {
                arrayList.add("android.permission.CAMERA");
            }
            if (z4) {
                arrayList.add("android.permission.RECORD_AUDIO");
            }
            if (activity != null) {
                activity.requestPermissions((String[]) arrayList.toArray(new String[0]), 16);
            }
        }
        return false;
    }

    public void clearCameraListeners() {
        this.r.clear();
    }

    public void clearFrameProcessors() {
        boolean z2 = this.s.size() > 0;
        this.s.clear();
        if (z2) {
            this.n.setHasFrameProcessors(false);
        }
    }

    public void clearGesture(@NonNull Gesture gesture) {
        mapGesture(gesture, GestureAction.NONE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void close() {
        if (!this.B) {
            this.m.disable();
            this.n.stop(false);
            CameraPreview cameraPreview = this.l;
            if (cameraPreview != null) {
                cameraPreview.onPause();
            }
        }
    }

    public final String d(int i2) {
        if (i2 == Integer.MIN_VALUE) {
            return "AT_MOST";
        }
        if (i2 == 0) {
            return "UNSPECIFIED";
        }
        if (i2 != 1073741824) {
            return null;
        }
        return "EXACTLY";
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void destroy() {
        if (!this.B) {
            clearCameraListeners();
            clearFrameProcessors();
            this.n.destroy(true);
            CameraPreview cameraPreview = this.l;
            if (cameraPreview != null) {
                cameraPreview.onDestroy();
            }
        }
    }

    public final void e(@NonNull GestureFinder gestureFinder, @NonNull CameraOptions cameraOptions) {
        Gesture gesture = gestureFinder.getGesture();
        PointF[] points = gestureFinder.getPoints();
        switch (this.d.get(gesture).ordinal()) {
            case 1:
                this.n.startAutoFocus(gesture, MeteringRegions.fromPoint(new Size(getWidth(), getHeight()), points[0]), points[0]);
                return;
            case 2:
                takePicture();
                return;
            case 3:
                takePictureSnapshot();
                return;
            case 4:
                float zoomValue = this.n.getZoomValue();
                float computeValue = gestureFinder.computeValue(zoomValue, 0.0f, 1.0f);
                if (computeValue != zoomValue) {
                    this.n.setZoom(computeValue, points, true);
                    return;
                }
                return;
            case 5:
                float exposureCorrectionValue = this.n.getExposureCorrectionValue();
                float exposureCorrectionMinValue = cameraOptions.getExposureCorrectionMinValue();
                float exposureCorrectionMaxValue = cameraOptions.getExposureCorrectionMaxValue();
                float computeValue2 = gestureFinder.computeValue(exposureCorrectionValue, exposureCorrectionMinValue, exposureCorrectionMaxValue);
                if (computeValue2 != exposureCorrectionValue) {
                    this.n.setExposureCorrection(computeValue2, new float[]{exposureCorrectionMinValue, exposureCorrectionMaxValue}, points, true);
                    return;
                }
                return;
            case 6:
                if (getFilter() instanceof OneParameterFilter) {
                    OneParameterFilter oneParameterFilter = (OneParameterFilter) getFilter();
                    float parameter1 = oneParameterFilter.getParameter1();
                    float computeValue3 = gestureFinder.computeValue(parameter1, 0.0f, 1.0f);
                    if (computeValue3 != parameter1) {
                        oneParameterFilter.setParameter1(computeValue3);
                        return;
                    }
                    return;
                }
                return;
            case 7:
                if (getFilter() instanceof TwoParameterFilter) {
                    TwoParameterFilter twoParameterFilter = (TwoParameterFilter) getFilter();
                    float parameter2 = twoParameterFilter.getParameter2();
                    float computeValue4 = gestureFinder.computeValue(parameter2, 0.0f, 1.0f);
                    if (computeValue4 != parameter2) {
                        twoParameterFilter.setParameter2(computeValue4);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void f(@Nullable File file, @Nullable FileDescriptor fileDescriptor) {
        VideoResult.Stub stub = new VideoResult.Stub();
        if (file != null) {
            this.n.takeVideo(stub, file, null);
        } else if (fileDescriptor != null) {
            this.n.takeVideo(stub, null, fileDescriptor);
        } else {
            throw new IllegalStateException("file and fileDescriptor are both null.");
        }
        this.i.post(new a());
    }

    @NonNull
    public <T extends Control> T get(@NonNull Class<T> cls) {
        if (cls == Audio.class) {
            return getAudio();
        }
        if (cls == Facing.class) {
            return getFacing();
        }
        if (cls == Flash.class) {
            return getFlash();
        }
        if (cls == Grid.class) {
            return getGrid();
        }
        if (cls == Hdr.class) {
            return getHdr();
        }
        if (cls == Mode.class) {
            return getMode();
        }
        if (cls == WhiteBalance.class) {
            return getWhiteBalance();
        }
        if (cls == VideoCodec.class) {
            return getVideoCodec();
        }
        if (cls == AudioCodec.class) {
            return getAudioCodec();
        }
        if (cls == Preview.class) {
            return getPreview();
        }
        if (cls == Engine.class) {
            return getEngine();
        }
        if (cls == PictureFormat.class) {
            return getPictureFormat();
        }
        throw new IllegalArgumentException("Unknown control class: " + cls);
    }

    @NonNull
    public Audio getAudio() {
        return this.n.getAudio();
    }

    public int getAudioBitRate() {
        return this.n.getAudioBitRate();
    }

    @NonNull
    public AudioCodec getAudioCodec() {
        return this.n.getAudioCodec();
    }

    public long getAutoFocusResetDelay() {
        return this.n.getAutoFocusResetDelay();
    }

    @Nullable
    public CameraOptions getCameraOptions() {
        return this.n.getCameraOptions();
    }

    @NonNull
    public Engine getEngine() {
        return this.f;
    }

    public float getExposureCorrection() {
        return this.n.getExposureCorrectionValue();
    }

    @NonNull
    public Facing getFacing() {
        return this.n.getFacing();
    }

    @NonNull
    public Filter getFilter() {
        CameraPreview cameraPreview = this.l;
        if (cameraPreview == null) {
            return this.g;
        }
        if (cameraPreview instanceof FilterCameraPreview) {
            return ((FilterCameraPreview) cameraPreview).getCurrentFilter();
        }
        StringBuilder L = a2.b.a.a.a.L("Filters are only supported by the GL_SURFACE preview. Current:");
        L.append(this.e);
        throw new RuntimeException(L.toString());
    }

    @NonNull
    public Flash getFlash() {
        return this.n.getFlash();
    }

    public int getFrameProcessingExecutors() {
        return this.h;
    }

    public int getFrameProcessingFormat() {
        return this.n.getFrameProcessingFormat();
    }

    public int getFrameProcessingMaxHeight() {
        return this.n.getFrameProcessingMaxHeight();
    }

    public int getFrameProcessingMaxWidth() {
        return this.n.getFrameProcessingMaxWidth();
    }

    public int getFrameProcessingPoolSize() {
        return this.n.getFrameProcessingPoolSize();
    }

    @NonNull
    public GestureAction getGestureAction(@NonNull Gesture gesture) {
        return this.d.get(gesture);
    }

    @NonNull
    public Grid getGrid() {
        return this.x.getGridMode();
    }

    public int getGridColor() {
        return this.x.getGridColor();
    }

    @NonNull
    public Hdr getHdr() {
        return this.n.getHdr();
    }

    @Nullable
    public Location getLocation() {
        return this.n.getLocation();
    }

    @NonNull
    public Mode getMode() {
        return this.n.getMode();
    }

    @NonNull
    public PictureFormat getPictureFormat() {
        return this.n.getPictureFormat();
    }

    public boolean getPictureMetering() {
        return this.n.getPictureMetering();
    }

    @Nullable
    public Size getPictureSize() {
        return this.n.getPictureSize(Reference.OUTPUT);
    }

    public boolean getPictureSnapshotMetering() {
        return this.n.getPictureSnapshotMetering();
    }

    public boolean getPlaySounds() {
        return this.a;
    }

    @NonNull
    public Preview getPreview() {
        return this.e;
    }

    public float getPreviewFrameRate() {
        return this.n.getPreviewFrameRate();
    }

    public boolean getPreviewFrameRateExact() {
        return this.n.getPreviewFrameRateExact();
    }

    public int getSnapshotMaxHeight() {
        return this.n.getSnapshotMaxHeight();
    }

    public int getSnapshotMaxWidth() {
        return this.n.getSnapshotMaxWidth();
    }

    @Nullable
    public Size getSnapshotSize() {
        Size size = null;
        if (!(getWidth() == 0 || getHeight() == 0)) {
            CameraEngine cameraEngine = this.n;
            Reference reference = Reference.VIEW;
            Size uncroppedSnapshotSize = cameraEngine.getUncroppedSnapshotSize(reference);
            if (uncroppedSnapshotSize == null) {
                return null;
            }
            Rect computeCrop = CropHelper.computeCrop(uncroppedSnapshotSize, AspectRatio.of(getWidth(), getHeight()));
            size = new Size(computeCrop.width(), computeCrop.height());
            if (this.n.getAngles().flip(reference, Reference.OUTPUT)) {
                return size.flip();
            }
        }
        return size;
    }

    public boolean getUseDeviceOrientation() {
        return this.b;
    }

    public int getVideoBitRate() {
        return this.n.getVideoBitRate();
    }

    @NonNull
    public VideoCodec getVideoCodec() {
        return this.n.getVideoCodec();
    }

    public int getVideoMaxDuration() {
        return this.n.getVideoMaxDuration();
    }

    public long getVideoMaxSize() {
        return this.n.getVideoMaxSize();
    }

    @Nullable
    public Size getVideoSize() {
        return this.n.getVideoSize(Reference.OUTPUT);
    }

    @NonNull
    public WhiteBalance getWhiteBalance() {
        return this.n.getWhiteBalance();
    }

    public float getZoom() {
        return this.n.getZoomValue();
    }

    @NonNull
    public CameraEngine instantiateCameraEngine(@NonNull Engine engine, @NonNull CameraEngine.Callback callback) {
        if (this.A && engine == Engine.CAMERA2) {
            return new Camera2Engine(callback);
        }
        this.f = Engine.CAMERA1;
        return new Camera1Engine(callback);
    }

    @NonNull
    public CameraPreview instantiatePreview(@NonNull Preview preview, @NonNull Context context, @NonNull ViewGroup viewGroup) {
        int ordinal = preview.ordinal();
        if (ordinal == 0) {
            return new SurfaceCameraPreview(context, viewGroup);
        }
        if (ordinal == 1 && isHardwareAccelerated()) {
            return new TextureCameraPreview(context, viewGroup);
        }
        this.e = Preview.GL_SURFACE;
        return new GlCameraPreview(context, viewGroup);
    }

    public boolean isOpened() {
        CameraState state = this.n.getState();
        CameraState cameraState = CameraState.ENGINE;
        return state.isAtLeast(cameraState) && this.n.getTargetState().isAtLeast(cameraState);
    }

    public boolean isTakingPicture() {
        return this.n.isTakingPicture();
    }

    public boolean isTakingVideo() {
        return this.n.isTakingVideo();
    }

    public boolean mapGesture(@NonNull Gesture gesture, @NonNull GestureAction gestureAction) {
        GestureAction gestureAction2 = GestureAction.NONE;
        boolean z2 = false;
        if (gesture.isAssignableTo(gestureAction)) {
            this.d.put(gesture, gestureAction);
            int ordinal = gesture.ordinal();
            if (ordinal == 0) {
                PinchGestureFinder pinchGestureFinder = this.u;
                if (this.d.get(Gesture.PINCH) != gestureAction2) {
                    z2 = true;
                }
                pinchGestureFinder.setActive(z2);
            } else if (ordinal == 1 || ordinal == 2) {
                TapGestureFinder tapGestureFinder = this.v;
                if (!(this.d.get(Gesture.TAP) == gestureAction2 && this.d.get(Gesture.LONG_TAP) == gestureAction2)) {
                    z2 = true;
                }
                tapGestureFinder.setActive(z2);
            } else if (ordinal == 3 || ordinal == 4) {
                ScrollGestureFinder scrollGestureFinder = this.w;
                if (!(this.d.get(Gesture.SCROLL_HORIZONTAL) == gestureAction2 && this.d.get(Gesture.SCROLL_VERTICAL) == gestureAction2)) {
                    z2 = true;
                }
                scrollGestureFinder.setActive(z2);
            }
            return true;
        }
        mapGesture(gesture, gestureAction2);
        return false;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.B && this.l == null) {
            CameraLogger cameraLogger = E;
            cameraLogger.w("doInstantiateEngine:", "instantiating. preview:", this.e);
            CameraPreview instantiatePreview = instantiatePreview(this.e, getContext(), this);
            this.l = instantiatePreview;
            cameraLogger.w("doInstantiateEngine:", "instantiated. preview:", instantiatePreview.getClass().getSimpleName());
            this.n.setPreview(this.l);
            Filter filter = this.g;
            if (filter != null) {
                setFilter(filter);
                this.g = null;
            }
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onDetachedFromWindow() {
        this.o = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.B) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), 1073741824));
            return;
        }
        Size previewStreamSize = this.n.getPreviewStreamSize(Reference.VIEW);
        this.o = previewStreamSize;
        if (previewStreamSize == null) {
            E.w("onMeasure:", "surface is not ready. Calling default behavior.");
            super.onMeasure(i2, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        float width = (float) this.o.getWidth();
        float height = (float) this.o.getHeight();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (!this.l.supportsCropping()) {
            if (mode == 1073741824) {
                mode = Integer.MIN_VALUE;
            }
            if (mode2 == 1073741824) {
                mode2 = Integer.MIN_VALUE;
            }
        } else {
            if (mode == Integer.MIN_VALUE && layoutParams.width == -1) {
                mode = 1073741824;
            }
            if (mode2 == Integer.MIN_VALUE && layoutParams.height == -1) {
                mode2 = 1073741824;
            }
        }
        CameraLogger cameraLogger = E;
        StringBuilder M = a2.b.a.a.a.M("requested dimensions are (", size, "[");
        M.append(d(mode));
        M.append("]x");
        M.append(size2);
        M.append("[");
        M.append(d(mode2));
        M.append("])");
        cameraLogger.i("onMeasure:", M.toString());
        cameraLogger.i("onMeasure:", "previewSize is", "(" + width + "x" + height + ")");
        if (mode == 1073741824 && mode2 == 1073741824) {
            cameraLogger.i("onMeasure:", "both are MATCH_PARENT or fixed value. We adapt.", "This means CROP_CENTER.", a2.b.a.a.a.S2("(", size, "x", size2, ")"));
            super.onMeasure(i2, i3);
        } else if (mode == 0 && mode2 == 0) {
            cameraLogger.i("onMeasure:", "both are completely free.", "We respect that and extend to the whole preview size.", "(" + width + "x" + height + ")");
            super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) width, 1073741824), View.MeasureSpec.makeMeasureSpec((int) height, 1073741824));
        } else {
            float f2 = height / width;
            if (mode == 0 || mode2 == 0) {
                if (mode == 0) {
                    size = Math.round(((float) size2) / f2);
                } else {
                    size2 = Math.round(((float) size) * f2);
                }
                cameraLogger.i("onMeasure:", "one dimension was free, we adapted it to fit the ratio.", a2.b.a.a.a.S2("(", size, "x", size2, ")"));
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            } else if (mode == 1073741824 || mode2 == 1073741824) {
                if (mode == Integer.MIN_VALUE) {
                    size = Math.min(Math.round(((float) size2) / f2), size);
                } else {
                    size2 = Math.min(Math.round(((float) size) * f2), size2);
                }
                cameraLogger.i("onMeasure:", "one dimension was EXACTLY, another AT_MOST.", "We have TRIED to fit the aspect ratio, but it's not guaranteed.", a2.b.a.a.a.S2("(", size, "x", size2, ")"));
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            } else {
                float f3 = (float) size2;
                float f4 = (float) size;
                if (f3 / f4 >= f2) {
                    size2 = Math.round(f4 * f2);
                } else {
                    size = Math.round(f3 / f2);
                }
                cameraLogger.i("onMeasure:", "both dimension were AT_MOST.", "We fit the preview aspect ratio.", a2.b.a.a.a.S2("(", size, "x", size2, ")"));
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            }
        }
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isOpened()) {
            return true;
        }
        CameraOptions cameraOptions = this.n.getCameraOptions();
        if (cameraOptions != null) {
            if (this.u.onTouchEvent(motionEvent)) {
                E.i("onTouchEvent", "pinch!");
                e(this.u, cameraOptions);
            } else if (this.w.onTouchEvent(motionEvent)) {
                E.i("onTouchEvent", "scroll!");
                e(this.w, cameraOptions);
            } else if (this.v.onTouchEvent(motionEvent)) {
                E.i("onTouchEvent", "tap!");
                e(this.v, cameraOptions);
            }
            return true;
        }
        throw new IllegalStateException("Options should not be null here.");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void open() {
        if (!this.B) {
            CameraPreview cameraPreview = this.l;
            if (cameraPreview != null) {
                cameraPreview.onResume();
            }
            if (checkPermissions(getAudio())) {
                this.m.enable();
                this.n.getAngles().setDisplayOffset(this.m.getLastDisplayOffset());
                this.n.start();
            }
        }
    }

    public void removeCameraListener(@NonNull CameraListener cameraListener) {
        this.r.remove(cameraListener);
    }

    public void removeFrameProcessor(@Nullable FrameProcessor frameProcessor) {
        if (frameProcessor != null) {
            this.s.remove(frameProcessor);
            if (this.s.size() == 0) {
                this.n.setHasFrameProcessors(false);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (this.B || layoutParams == null || !this.C.isOverlay(layoutParams)) {
            super.removeView(view);
        } else {
            this.C.removeView(view);
        }
    }

    public void set(@NonNull Control control) {
        if (control instanceof Audio) {
            setAudio((Audio) control);
        } else if (control instanceof Facing) {
            setFacing((Facing) control);
        } else if (control instanceof Flash) {
            setFlash((Flash) control);
        } else if (control instanceof Grid) {
            setGrid((Grid) control);
        } else if (control instanceof Hdr) {
            setHdr((Hdr) control);
        } else if (control instanceof Mode) {
            setMode((Mode) control);
        } else if (control instanceof WhiteBalance) {
            setWhiteBalance((WhiteBalance) control);
        } else if (control instanceof VideoCodec) {
            setVideoCodec((VideoCodec) control);
        } else if (control instanceof AudioCodec) {
            setAudioCodec((AudioCodec) control);
        } else if (control instanceof Preview) {
            setPreview((Preview) control);
        } else if (control instanceof Engine) {
            setEngine((Engine) control);
        } else if (control instanceof PictureFormat) {
            setPictureFormat((PictureFormat) control);
        }
    }

    public void setAudio(@NonNull Audio audio) {
        if (audio == getAudio() || c()) {
            this.n.setAudio(audio);
        } else if (checkPermissions(audio)) {
            this.n.setAudio(audio);
        } else {
            close();
        }
    }

    public void setAudioBitRate(int i2) {
        this.n.setAudioBitRate(i2);
    }

    public void setAudioCodec(@NonNull AudioCodec audioCodec) {
        this.n.setAudioCodec(audioCodec);
    }

    public void setAutoFocusMarker(@Nullable AutoFocusMarker autoFocusMarker) {
        this.q = autoFocusMarker;
        this.y.onMarker(1, autoFocusMarker);
    }

    public void setAutoFocusResetDelay(long j2) {
        this.n.setAutoFocusResetDelay(j2);
    }

    public void setEngine(@NonNull Engine engine) {
        if (c()) {
            this.f = engine;
            CameraEngine cameraEngine = this.n;
            a();
            CameraPreview cameraPreview = this.l;
            if (cameraPreview != null) {
                this.n.setPreview(cameraPreview);
            }
            setFacing(cameraEngine.getFacing());
            setFlash(cameraEngine.getFlash());
            setMode(cameraEngine.getMode());
            setWhiteBalance(cameraEngine.getWhiteBalance());
            setHdr(cameraEngine.getHdr());
            setAudio(cameraEngine.getAudio());
            setAudioBitRate(cameraEngine.getAudioBitRate());
            setAudioCodec(cameraEngine.getAudioCodec());
            setPictureSize(cameraEngine.getPictureSizeSelector());
            setPictureFormat(cameraEngine.getPictureFormat());
            setVideoSize(cameraEngine.getVideoSizeSelector());
            setVideoCodec(cameraEngine.getVideoCodec());
            setVideoMaxSize(cameraEngine.getVideoMaxSize());
            setVideoMaxDuration(cameraEngine.getVideoMaxDuration());
            setVideoBitRate(cameraEngine.getVideoBitRate());
            setAutoFocusResetDelay(cameraEngine.getAutoFocusResetDelay());
            setPreviewFrameRate(cameraEngine.getPreviewFrameRate());
            setPreviewFrameRateExact(cameraEngine.getPreviewFrameRateExact());
            setSnapshotMaxWidth(cameraEngine.getSnapshotMaxWidth());
            setSnapshotMaxHeight(cameraEngine.getSnapshotMaxHeight());
            setFrameProcessingMaxWidth(cameraEngine.getFrameProcessingMaxWidth());
            setFrameProcessingMaxHeight(cameraEngine.getFrameProcessingMaxHeight());
            setFrameProcessingFormat(0);
            setFrameProcessingPoolSize(cameraEngine.getFrameProcessingPoolSize());
            this.n.setHasFrameProcessors(!this.s.isEmpty());
        }
    }

    public void setExperimental(boolean z2) {
        this.A = z2;
    }

    public void setExposureCorrection(float f2) {
        CameraOptions cameraOptions = getCameraOptions();
        if (cameraOptions != null) {
            float exposureCorrectionMinValue = cameraOptions.getExposureCorrectionMinValue();
            float exposureCorrectionMaxValue = cameraOptions.getExposureCorrectionMaxValue();
            if (f2 < exposureCorrectionMinValue) {
                f2 = exposureCorrectionMinValue;
            }
            if (f2 > exposureCorrectionMaxValue) {
                f2 = exposureCorrectionMaxValue;
            }
            this.n.setExposureCorrection(f2, new float[]{exposureCorrectionMinValue, exposureCorrectionMaxValue}, null, false);
        }
    }

    public void setFacing(@NonNull Facing facing) {
        this.n.setFacing(facing);
    }

    public void setFilter(@NonNull Filter filter) {
        CameraPreview cameraPreview = this.l;
        if (cameraPreview == null) {
            this.g = filter;
            return;
        }
        boolean z2 = cameraPreview instanceof FilterCameraPreview;
        if (!(filter instanceof NoFilter) && !z2) {
            StringBuilder L = a2.b.a.a.a.L("Filters are only supported by the GL_SURFACE preview. Current preview:");
            L.append(this.e);
            throw new RuntimeException(L.toString());
        } else if (z2) {
            ((FilterCameraPreview) cameraPreview).setFilter(filter);
        }
    }

    public void setFlash(@NonNull Flash flash) {
        this.n.setFlash(flash);
    }

    public void setFrameProcessingExecutors(int i2) {
        if (i2 >= 1) {
            this.h = i2;
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 4, TimeUnit.SECONDS, new LinkedBlockingQueue(), new e(this));
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            this.j = threadPoolExecutor;
            return;
        }
        throw new IllegalArgumentException(a2.b.a.a.a.M2("Need at least 1 executor, got ", i2));
    }

    public void setFrameProcessingFormat(int i2) {
        this.n.setFrameProcessingFormat(i2);
    }

    public void setFrameProcessingMaxHeight(int i2) {
        this.n.setFrameProcessingMaxHeight(i2);
    }

    public void setFrameProcessingMaxWidth(int i2) {
        this.n.setFrameProcessingMaxWidth(i2);
    }

    public void setFrameProcessingPoolSize(int i2) {
        this.n.setFrameProcessingPoolSize(i2);
    }

    public void setGrid(@NonNull Grid grid) {
        this.x.setGridMode(grid);
    }

    public void setGridColor(@ColorInt int i2) {
        this.x.setGridColor(i2);
    }

    public void setHdr(@NonNull Hdr hdr) {
        this.n.setHdr(hdr);
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner == null) {
            Lifecycle lifecycle = this.t;
            if (lifecycle != null) {
                lifecycle.removeObserver(this);
                this.t = null;
                return;
            }
            return;
        }
        Lifecycle lifecycle2 = this.t;
        if (lifecycle2 != null) {
            lifecycle2.removeObserver(this);
            this.t = null;
        }
        Lifecycle lifecycle3 = lifecycleOwner.getLifecycle();
        this.t = lifecycle3;
        lifecycle3.addObserver(this);
    }

    public void setLocation(double d2, double d3) {
        Location location = new Location(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);
        location.setTime(System.currentTimeMillis());
        location.setAltitude(0.0d);
        location.setLatitude(d2);
        location.setLongitude(d3);
        this.n.setLocation(location);
    }

    public void setMode(@NonNull Mode mode) {
        this.n.setMode(mode);
    }

    public void setPictureFormat(@NonNull PictureFormat pictureFormat) {
        this.n.setPictureFormat(pictureFormat);
    }

    public void setPictureMetering(boolean z2) {
        this.n.setPictureMetering(z2);
    }

    public void setPictureSize(@NonNull SizeSelector sizeSelector) {
        this.n.setPictureSizeSelector(sizeSelector);
    }

    public void setPictureSnapshotMetering(boolean z2) {
        this.n.setPictureSnapshotMetering(z2);
    }

    public void setPlaySounds(boolean z2) {
        this.a = z2;
        this.n.setPlaySounds(z2);
    }

    public void setPreview(@NonNull Preview preview) {
        CameraPreview cameraPreview;
        boolean z2 = true;
        if (preview != this.e) {
            this.e = preview;
            if (getWindowToken() == null) {
                z2 = false;
            }
            if (!z2 && (cameraPreview = this.l) != null) {
                cameraPreview.onDestroy();
                this.l = null;
            }
        }
    }

    public void setPreviewFrameRate(float f2) {
        this.n.setPreviewFrameRate(f2);
    }

    public void setPreviewFrameRateExact(boolean z2) {
        this.n.setPreviewFrameRateExact(z2);
    }

    public void setPreviewStreamSize(@NonNull SizeSelector sizeSelector) {
        this.n.setPreviewStreamSizeSelector(sizeSelector);
    }

    public void setRequestPermissions(boolean z2) {
        this.c = z2;
    }

    public void setSnapshotMaxHeight(int i2) {
        this.n.setSnapshotMaxHeight(i2);
    }

    public void setSnapshotMaxWidth(int i2) {
        this.n.setSnapshotMaxWidth(i2);
    }

    public void setUseDeviceOrientation(boolean z2) {
        this.b = z2;
    }

    public void setVideoBitRate(int i2) {
        this.n.setVideoBitRate(i2);
    }

    public void setVideoCodec(@NonNull VideoCodec videoCodec) {
        this.n.setVideoCodec(videoCodec);
    }

    public void setVideoMaxDuration(int i2) {
        this.n.setVideoMaxDuration(i2);
    }

    public void setVideoMaxSize(long j2) {
        this.n.setVideoMaxSize(j2);
    }

    public void setVideoSize(@NonNull SizeSelector sizeSelector) {
        this.n.setVideoSizeSelector(sizeSelector);
    }

    public void setWhiteBalance(@NonNull WhiteBalance whiteBalance) {
        this.n.setWhiteBalance(whiteBalance);
    }

    public void setZoom(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        this.n.setZoom(f2, null, false);
    }

    public void startAutoFocus(float f2, float f3) {
        if (f2 < 0.0f || f2 > ((float) getWidth())) {
            throw new IllegalArgumentException("x should be >= 0 and <= getWidth()");
        } else if (f3 < 0.0f || f3 > ((float) getHeight())) {
            throw new IllegalArgumentException("y should be >= 0 and <= getHeight()");
        } else {
            Size size = new Size(getWidth(), getHeight());
            PointF pointF = new PointF(f2, f3);
            this.n.startAutoFocus(null, MeteringRegions.fromPoint(size, pointF), pointF);
        }
    }

    public void stopVideo() {
        this.n.stopVideo();
        this.i.post(new d());
    }

    public void takePicture() {
        this.n.takePicture(new PictureResult.Stub());
    }

    public void takePictureSnapshot() {
        this.n.takePictureSnapshot(new PictureResult.Stub());
    }

    public void takeVideo(@NonNull File file) {
        f(file, null);
    }

    public void takeVideoSnapshot(@NonNull File file) {
        this.n.takeVideoSnapshot(new VideoResult.Stub(), file);
        this.i.post(new b());
    }

    public Facing toggleFacing() {
        int ordinal = this.n.getFacing().ordinal();
        if (ordinal == 0) {
            setFacing(Facing.FRONT);
        } else if (ordinal == 1) {
            setFacing(Facing.BACK);
        }
        return this.n.getFacing();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.B || !this.C.isOverlay(attributeSet)) {
            return super.generateLayoutParams(attributeSet);
        }
        return this.C.generateLayoutParams(attributeSet);
    }

    public void takeVideo(@NonNull FileDescriptor fileDescriptor) {
        f(null, fileDescriptor);
    }

    public void takeVideo(@NonNull File file, int i2) {
        addCameraListener(new a2.m.a.a(this, getVideoMaxDuration()));
        setVideoMaxDuration(i2);
        f(file, null);
    }

    public void takeVideoSnapshot(@NonNull File file, int i2) {
        addCameraListener(new c(getVideoMaxDuration()));
        setVideoMaxDuration(i2);
        takeVideoSnapshot(file);
    }

    public CameraView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }

    public void setLocation(@Nullable Location location) {
        this.n.setLocation(location);
    }

    public void takeVideo(@NonNull FileDescriptor fileDescriptor, int i2) {
        addCameraListener(new a2.m.a.a(this, getVideoMaxDuration()));
        setVideoMaxDuration(i2);
        f(null, fileDescriptor);
    }

    public void startAutoFocus(@NonNull RectF rectF) {
        if (new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()).contains(rectF)) {
            this.n.startAutoFocus(null, MeteringRegions.fromArea(new Size(getWidth(), getHeight()), rectF), new PointF(rectF.centerX(), rectF.centerY()));
            return;
        }
        throw new IllegalArgumentException("Region is out of view bounds! " + rectF);
    }
}
