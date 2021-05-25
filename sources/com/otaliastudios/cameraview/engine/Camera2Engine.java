package com.otaliastudios.cameraview.engine;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.location.Location;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.util.Pair;
import android.util.Range;
import android.util.Rational;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.CameraOptions;
import com.otaliastudios.cameraview.PictureResult;
import com.otaliastudios.cameraview.VideoResult;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.Mode;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import com.otaliastudios.cameraview.engine.CameraEngine;
import com.otaliastudios.cameraview.engine.action.Action;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import com.otaliastudios.cameraview.engine.action.Actions;
import com.otaliastudios.cameraview.engine.action.BaseAction;
import com.otaliastudios.cameraview.engine.action.CompletionCallback;
import com.otaliastudios.cameraview.engine.action.LogAction;
import com.otaliastudios.cameraview.engine.mappers.Camera2Mapper;
import com.otaliastudios.cameraview.engine.meter.MeterAction;
import com.otaliastudios.cameraview.engine.meter.MeterResetAction;
import com.otaliastudios.cameraview.engine.offset.Angles;
import com.otaliastudios.cameraview.engine.offset.Axis;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.engine.options.Camera2Options;
import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator;
import com.otaliastudios.cameraview.frame.Frame;
import com.otaliastudios.cameraview.frame.FrameManager;
import com.otaliastudios.cameraview.frame.ImageFrameManager;
import com.otaliastudios.cameraview.gesture.Gesture;
import com.otaliastudios.cameraview.internal.CropHelper;
import com.otaliastudios.cameraview.internal.FpsRangeValidator;
import com.otaliastudios.cameraview.metering.MeteringRegions;
import com.otaliastudios.cameraview.picture.Full2PictureRecorder;
import com.otaliastudios.cameraview.picture.Snapshot2PictureRecorder;
import com.otaliastudios.cameraview.preview.CameraPreview;
import com.otaliastudios.cameraview.preview.RendererCameraPreview;
import com.otaliastudios.cameraview.size.AspectRatio;
import com.otaliastudios.cameraview.size.Size;
import com.otaliastudios.cameraview.video.Full2VideoRecorder;
import com.otaliastudios.cameraview.video.SnapshotVideoRecorder;
import com.otaliastudios.cameraview.video.VideoRecorder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
@RequiresApi(21)
public class Camera2Engine extends CameraBaseEngine implements ImageReader.OnImageAvailableListener, ActionHolder {
    public static final /* synthetic */ int O = 0;
    public CameraDevice A;
    public CameraCharacteristics B;
    public CameraCaptureSession C;
    public CaptureRequest.Builder D;
    public TotalCaptureResult E;
    public final Camera2Mapper F = Camera2Mapper.get();
    public ImageReader G;
    public Surface H;
    public Surface I;
    public VideoResult.Stub J;
    public ImageReader K;
    public final List<Action> L = new CopyOnWriteArrayList();
    public MeterAction M;
    public final CameraCaptureSession.CaptureCallback N = new j();
    public final CameraManager y = ((CameraManager) getCallback().getContext().getSystemService("camera"));
    public String z;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine camera2Engine = Camera2Engine.this;
            int i = Camera2Engine.O;
            camera2Engine.p();
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ Flash a;
        public final /* synthetic */ Flash b;

        public b(Flash flash, Flash flash2) {
            this.a = flash;
            this.b = flash2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine camera2Engine = Camera2Engine.this;
            boolean applyFlash = camera2Engine.applyFlash(camera2Engine.D, this.a);
            if (Camera2Engine.this.getState() == CameraState.PREVIEW) {
                Camera2Engine camera2Engine2 = Camera2Engine.this;
                camera2Engine2.mFlash = Flash.OFF;
                camera2Engine2.applyFlash(camera2Engine2.D, this.a);
                try {
                    Camera2Engine camera2Engine3 = Camera2Engine.this;
                    camera2Engine3.C.capture(camera2Engine3.D.build(), null, null);
                    Camera2Engine camera2Engine4 = Camera2Engine.this;
                    camera2Engine4.mFlash = this.b;
                    camera2Engine4.applyFlash(camera2Engine4.D, this.a);
                    Camera2Engine.this.applyRepeatingRequestBuilder();
                } catch (CameraAccessException e) {
                    throw Camera2Engine.this.m(e);
                }
            } else if (applyFlash) {
                Camera2Engine.this.applyRepeatingRequestBuilder();
            }
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ Location a;

        public c(Location location) {
            this.a = location;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine camera2Engine = Camera2Engine.this;
            if (camera2Engine.applyLocation(camera2Engine.D, this.a)) {
                Camera2Engine.this.applyRepeatingRequestBuilder();
            }
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ WhiteBalance a;

        public d(WhiteBalance whiteBalance) {
            this.a = whiteBalance;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine camera2Engine = Camera2Engine.this;
            if (camera2Engine.applyWhiteBalance(camera2Engine.D, this.a)) {
                Camera2Engine.this.applyRepeatingRequestBuilder();
            }
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ Hdr a;

        public e(Hdr hdr) {
            this.a = hdr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine camera2Engine = Camera2Engine.this;
            if (camera2Engine.applyHdr(camera2Engine.D, this.a)) {
                Camera2Engine.this.applyRepeatingRequestBuilder();
            }
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ float a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ float c;
        public final /* synthetic */ PointF[] d;

        public f(float f, boolean z, float f2, PointF[] pointFArr) {
            this.a = f;
            this.b = z;
            this.c = f2;
            this.d = pointFArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine camera2Engine = Camera2Engine.this;
            if (camera2Engine.applyZoom(camera2Engine.D, this.a)) {
                Camera2Engine.this.applyRepeatingRequestBuilder();
                if (this.b) {
                    Camera2Engine.this.getCallback().dispatchOnZoomChanged(this.c, this.d);
                }
            }
        }
    }

    public class g implements Runnable {
        public final /* synthetic */ float a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ float c;
        public final /* synthetic */ float[] d;
        public final /* synthetic */ PointF[] e;

        public g(float f2, boolean z, float f3, float[] fArr, PointF[] pointFArr) {
            this.a = f2;
            this.b = z;
            this.c = f3;
            this.d = fArr;
            this.e = pointFArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine camera2Engine = Camera2Engine.this;
            if (camera2Engine.applyExposureCorrection(camera2Engine.D, this.a)) {
                Camera2Engine.this.applyRepeatingRequestBuilder();
                if (this.b) {
                    Camera2Engine.this.getCallback().dispatchOnExposureCorrectionChanged(this.c, this.d, this.e);
                }
            }
        }
    }

    public class h implements Runnable {
        public final /* synthetic */ float a;

        public h(float f) {
            this.a = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine camera2Engine = Camera2Engine.this;
            if (camera2Engine.applyPreviewFrameRate(camera2Engine.D, this.a)) {
                Camera2Engine.this.applyRepeatingRequestBuilder();
            }
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine.this.restart();
        }
    }

    public class j extends CameraCaptureSession.CaptureCallback {
        public j() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            Camera2Engine camera2Engine = Camera2Engine.this;
            camera2Engine.E = totalCaptureResult;
            for (Action action : camera2Engine.L) {
                action.onCaptureCompleted(Camera2Engine.this, captureRequest, totalCaptureResult);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
            for (Action action : Camera2Engine.this.L) {
                action.onCaptureProgressed(Camera2Engine.this, captureRequest, captureResult);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, long j, long j2) {
            for (Action action : Camera2Engine.this.L) {
                action.onCaptureStarted(Camera2Engine.this, captureRequest);
            }
        }
    }

    public class k implements Runnable {
        public final /* synthetic */ boolean a;

        public k(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraState state = Camera2Engine.this.getState();
            CameraState cameraState = CameraState.BIND;
            if (!state.isAtLeast(cameraState) || !Camera2Engine.this.isChangingState()) {
                Camera2Engine camera2Engine = Camera2Engine.this;
                camera2Engine.mHasFrameProcessors = this.a;
                if (camera2Engine.getState().isAtLeast(cameraState)) {
                    Camera2Engine.this.restartBind();
                    return;
                }
                return;
            }
            Camera2Engine.this.setHasFrameProcessors(this.a);
        }
    }

    public class l implements Runnable {
        public final /* synthetic */ int a;

        public l(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraState state = Camera2Engine.this.getState();
            CameraState cameraState = CameraState.BIND;
            if (!state.isAtLeast(cameraState) || !Camera2Engine.this.isChangingState()) {
                Camera2Engine camera2Engine = Camera2Engine.this;
                int i = this.a;
                if (i <= 0) {
                    i = 35;
                }
                camera2Engine.mFrameProcessingFormat = i;
                if (camera2Engine.getState().isAtLeast(cameraState)) {
                    Camera2Engine.this.restartBind();
                    return;
                }
                return;
            }
            Camera2Engine.this.setFrameProcessingFormat(this.a);
        }
    }

    public class m implements Runnable {
        public final /* synthetic */ Gesture a;
        public final /* synthetic */ PointF b;
        public final /* synthetic */ MeteringRegions c;

        public class a extends CompletionCallback {
            public final /* synthetic */ MeterAction a;

            /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$m$a$a  reason: collision with other inner class name */
            public class RunnableC0311a implements Runnable {
                public RunnableC0311a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    Camera2Engine.i(Camera2Engine.this);
                }
            }

            public a(MeterAction meterAction) {
                this.a = meterAction;
            }

            @Override // com.otaliastudios.cameraview.engine.action.CompletionCallback
            public void onActionCompleted(@NonNull Action action) {
                Camera2Engine.this.getCallback().dispatchOnFocusEnd(m.this.a, this.a.isSuccessful(), m.this.b);
                Camera2Engine.this.getOrchestrator().remove("reset metering");
                if (Camera2Engine.this.shouldResetAutoFocus()) {
                    Camera2Engine.this.getOrchestrator().scheduleStatefulDelayed("reset metering", CameraState.PREVIEW, Camera2Engine.this.getAutoFocusResetDelay(), new RunnableC0311a());
                }
            }
        }

        public m(Gesture gesture, PointF pointF, MeteringRegions meteringRegions) {
            this.a = gesture;
            this.b = pointF;
            this.c = meteringRegions;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Camera2Engine.this.mCameraOptions.isAutoFocusSupported()) {
                Camera2Engine.this.getCallback().dispatchOnFocusStart(this.a, this.b);
                Camera2Engine camera2Engine = Camera2Engine.this;
                MeteringRegions meteringRegions = this.c;
                int i = Camera2Engine.O;
                MeterAction n = camera2Engine.n(meteringRegions);
                BaseAction timeout = Actions.timeout(5000, n);
                timeout.start(Camera2Engine.this);
                timeout.addCallback(new a(n));
            }
        }
    }

    public class n extends CameraDevice.StateCallback {
        public final /* synthetic */ TaskCompletionSource a;

        public n(TaskCompletionSource taskCompletionSource) {
            this.a = taskCompletionSource;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            CameraException cameraException = new CameraException(3);
            if (!this.a.getTask().isComplete()) {
                this.a.trySetException(cameraException);
            } else {
                CameraEngine.LOG.i("CameraDevice.StateCallback reported disconnection.");
                throw cameraException;
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(@NonNull CameraDevice cameraDevice, int i) {
            int i2 = 1;
            if (!this.a.getTask().isComplete()) {
                TaskCompletionSource taskCompletionSource = this.a;
                Camera2Engine camera2Engine = Camera2Engine.this;
                int i3 = Camera2Engine.O;
                Objects.requireNonNull(camera2Engine);
                if (!(i == 1 || i == 2 || i == 3 || i == 4 || i == 5)) {
                    i2 = 0;
                }
                taskCompletionSource.trySetException(new CameraException(i2));
                return;
            }
            CameraEngine.LOG.e("CameraDevice.StateCallback reported an error:", Integer.valueOf(i));
            throw new CameraException(3);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(@NonNull CameraDevice cameraDevice) {
            int i;
            Camera2Engine.this.A = cameraDevice;
            try {
                CameraEngine.LOG.i("onStartEngine:", "Opened camera device.");
                Camera2Engine camera2Engine = Camera2Engine.this;
                camera2Engine.B = camera2Engine.y.getCameraCharacteristics(camera2Engine.z);
                boolean flip = Camera2Engine.this.getAngles().flip(Reference.SENSOR, Reference.VIEW);
                int ordinal = Camera2Engine.this.mPictureFormat.ordinal();
                if (ordinal == 0) {
                    i = 256;
                } else if (ordinal == 1) {
                    i = 32;
                } else {
                    throw new IllegalArgumentException("Unknown format:" + Camera2Engine.this.mPictureFormat);
                }
                Camera2Engine camera2Engine2 = Camera2Engine.this;
                camera2Engine2.mCameraOptions = new Camera2Options(camera2Engine2.y, camera2Engine2.z, flip, i);
                Camera2Engine camera2Engine3 = Camera2Engine.this;
                camera2Engine3.o(camera2Engine3.getRepeatingRequestDefaultTemplate());
                this.a.trySetResult(Camera2Engine.this.mCameraOptions);
            } catch (CameraAccessException e) {
                this.a.trySetException(Camera2Engine.this.m(e));
            }
        }
    }

    public class o implements Callable<Void> {
        public final /* synthetic */ Object a;

        public o(Object obj) {
            this.a = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            ((SurfaceHolder) this.a).setFixedSize(Camera2Engine.this.mPreviewStreamSize.getWidth(), Camera2Engine.this.mPreviewStreamSize.getHeight());
            return null;
        }
    }

    public class p extends CameraCaptureSession.StateCallback {
        public final /* synthetic */ TaskCompletionSource a;

        public p(TaskCompletionSource taskCompletionSource) {
            this.a = taskCompletionSource;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
            throw new RuntimeException(CameraEngine.LOG.e("onConfigureFailed! Session", cameraCaptureSession));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
            Camera2Engine.this.C = cameraCaptureSession;
            CameraEngine.LOG.i("onStartBind:", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED);
            this.a.trySetResult(null);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onReady(@NonNull CameraCaptureSession cameraCaptureSession) {
            super.onReady(cameraCaptureSession);
            CameraEngine.LOG.i("CameraCaptureSession.StateCallback reported onReady.");
        }
    }

    public class q implements Runnable {
        public final /* synthetic */ VideoResult.Stub a;

        public q(VideoResult.Stub stub) {
            this.a = stub;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine camera2Engine = Camera2Engine.this;
            VideoResult.Stub stub = this.a;
            int i = Camera2Engine.O;
            VideoRecorder videoRecorder = camera2Engine.mVideoRecorder;
            if (videoRecorder instanceof Full2VideoRecorder) {
                Full2VideoRecorder full2VideoRecorder = (Full2VideoRecorder) videoRecorder;
                try {
                    camera2Engine.o(3);
                    camera2Engine.j(full2VideoRecorder.getInputSurface());
                    camera2Engine.l(true, 3);
                    camera2Engine.mVideoRecorder.start(stub);
                } catch (CameraAccessException e) {
                    camera2Engine.onVideoResult(null, e);
                    throw camera2Engine.m(e);
                } catch (CameraException e2) {
                    camera2Engine.onVideoResult(null, e2);
                    throw e2;
                }
            } else {
                StringBuilder L = a2.b.a.a.a.L("doTakeVideo called, but video recorder is not a Full2VideoRecorder! ");
                L.append(camera2Engine.mVideoRecorder);
                throw new IllegalStateException(L.toString());
            }
        }
    }

    public class r extends BaseAction {
        public final /* synthetic */ TaskCompletionSource e;

        public r(Camera2Engine camera2Engine, TaskCompletionSource taskCompletionSource) {
            this.e = taskCompletionSource;
        }

        @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
        public void onCaptureCompleted(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            super.onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
            setState(Integer.MAX_VALUE);
            this.e.trySetResult(null);
        }
    }

    public class s extends CompletionCallback {
        public final /* synthetic */ PictureResult.Stub a;

        public s(PictureResult.Stub stub) {
            this.a = stub;
        }

        @Override // com.otaliastudios.cameraview.engine.action.CompletionCallback
        public void onActionCompleted(@NonNull Action action) {
            Camera2Engine.this.setPictureSnapshotMetering(false);
            Camera2Engine.this.takePictureSnapshot(this.a);
            Camera2Engine.this.setPictureSnapshotMetering(true);
        }
    }

    public class t extends CompletionCallback {
        public final /* synthetic */ PictureResult.Stub a;

        public t(PictureResult.Stub stub) {
            this.a = stub;
        }

        @Override // com.otaliastudios.cameraview.engine.action.CompletionCallback
        public void onActionCompleted(@NonNull Action action) {
            Camera2Engine.this.setPictureMetering(false);
            Camera2Engine.this.takePicture(this.a);
            Camera2Engine.this.setPictureMetering(true);
        }
    }

    public class u implements Runnable {
        public u() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine.i(Camera2Engine.this);
        }
    }

    public Camera2Engine(CameraEngine.Callback callback) {
        super(callback);
        new LogAction().start(this);
    }

    public static void i(Camera2Engine camera2Engine) {
        Objects.requireNonNull(camera2Engine);
        Actions.sequence(new a2.m.a.b.d(camera2Engine), new MeterResetAction()).start(camera2Engine);
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionHolder
    public void addAction(@NonNull Action action) {
        if (!this.L.contains(action)) {
            this.L.add(action);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionHolder
    @EngineThread
    public void applyBuilder(@NonNull Action action) {
        applyRepeatingRequestBuilder();
    }

    public void applyDefaultFocus(@NonNull CaptureRequest.Builder builder) {
        int[] iArr = (int[]) q(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES, new int[0]);
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            arrayList.add(Integer.valueOf(i2));
        }
        if (getMode() == Mode.VIDEO && arrayList.contains(3)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 3);
        } else if (arrayList.contains(4)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 4);
        } else if (arrayList.contains(1)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 1);
        } else if (arrayList.contains(0)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 0);
            builder.set(CaptureRequest.LENS_FOCUS_DISTANCE, Float.valueOf(0.0f));
        }
    }

    public boolean applyExposureCorrection(@NonNull CaptureRequest.Builder builder, float f2) {
        if (this.mCameraOptions.isExposureCorrectionSupported()) {
            builder.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(Math.round(((Rational) q(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP, new Rational(1, 1))).floatValue() * this.mExposureCorrectionValue)));
            return true;
        }
        this.mExposureCorrectionValue = f2;
        return false;
    }

    public boolean applyFlash(@NonNull CaptureRequest.Builder builder, @NonNull Flash flash) {
        if (this.mCameraOptions.supports(this.mFlash)) {
            int[] iArr = (int[]) q(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES, new int[0]);
            ArrayList arrayList = new ArrayList();
            for (int i2 : iArr) {
                arrayList.add(Integer.valueOf(i2));
            }
            for (Pair<Integer, Integer> pair : this.F.mapFlash(this.mFlash)) {
                if (arrayList.contains(pair.first)) {
                    CameraLogger cameraLogger = CameraEngine.LOG;
                    cameraLogger.i("applyFlash: setting CONTROL_AE_MODE to", pair.first);
                    cameraLogger.i("applyFlash: setting FLASH_MODE to", pair.second);
                    builder.set(CaptureRequest.CONTROL_AE_MODE, pair.first);
                    builder.set(CaptureRequest.FLASH_MODE, pair.second);
                    return true;
                }
            }
        }
        this.mFlash = flash;
        return false;
    }

    public void applyFocusForMetering(@NonNull CaptureRequest.Builder builder) {
        int[] iArr = (int[]) q(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES, new int[0]);
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            arrayList.add(Integer.valueOf(i2));
        }
        if (arrayList.contains(1)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 1);
        } else if (getMode() == Mode.VIDEO && arrayList.contains(3)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 3);
        } else if (arrayList.contains(4)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 4);
        }
    }

    public boolean applyHdr(@NonNull CaptureRequest.Builder builder, @NonNull Hdr hdr) {
        if (this.mCameraOptions.supports(this.mHdr)) {
            builder.set(CaptureRequest.CONTROL_SCENE_MODE, Integer.valueOf(this.F.mapHdr(this.mHdr)));
            return true;
        }
        this.mHdr = hdr;
        return false;
    }

    public boolean applyLocation(@NonNull CaptureRequest.Builder builder, @Nullable Location location) {
        Location location2 = this.mLocation;
        if (location2 == null) {
            return true;
        }
        builder.set(CaptureRequest.JPEG_GPS_LOCATION, location2);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean applyPreviewFrameRate(@androidx.annotation.NonNull android.hardware.camera2.CaptureRequest.Builder r7, float r8) {
        /*
            r6 = this;
            android.hardware.camera2.CameraCharacteristics$Key r0 = android.hardware.camera2.CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES
            r1 = 0
            android.util.Range[] r2 = new android.util.Range[r1]
            java.lang.Object r0 = r6.q(r0, r2)
            android.util.Range[] r0 = (android.util.Range[]) r0
            boolean r2 = r6.getPreviewFrameRateExact()
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x001b
            float r2 = r6.mPreviewFrameRate
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x001b
            r2 = 1
            goto L_0x001c
        L_0x001b:
            r2 = 0
        L_0x001c:
            a2.m.a.b.c r5 = new a2.m.a.b.c
            r5.<init>(r6, r2)
            java.util.Arrays.sort(r0, r5)
            float r2 = r6.mPreviewFrameRate
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x005c
            java.util.List r0 = r6.filterFrameRateRanges(r0)
            java.util.Iterator r0 = r0.iterator()
        L_0x0032:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x009e
            java.lang.Object r2 = r0.next()
            android.util.Range r2 = (android.util.Range) r2
            r3 = 30
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            boolean r3 = r2.contains(r3)
            if (r3 != 0) goto L_0x0056
            r3 = 24
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            boolean r3 = r2.contains(r3)
            if (r3 == 0) goto L_0x0032
        L_0x0056:
            android.hardware.camera2.CaptureRequest$Key r8 = android.hardware.camera2.CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE
            r7.set(r8, r2)
            return r4
        L_0x005c:
            com.otaliastudios.cameraview.CameraOptions r3 = r6.mCameraOptions
            float r3 = r3.getPreviewFrameRateMaxValue()
            float r2 = java.lang.Math.min(r2, r3)
            r6.mPreviewFrameRate = r2
            com.otaliastudios.cameraview.CameraOptions r3 = r6.mCameraOptions
            float r3 = r3.getPreviewFrameRateMinValue()
            float r2 = java.lang.Math.max(r2, r3)
            r6.mPreviewFrameRate = r2
            java.util.List r0 = r6.filterFrameRateRanges(r0)
            java.util.Iterator r0 = r0.iterator()
        L_0x007c:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x009e
            java.lang.Object r2 = r0.next()
            android.util.Range r2 = (android.util.Range) r2
            float r3 = r6.mPreviewFrameRate
            int r3 = java.lang.Math.round(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            boolean r3 = r2.contains(r3)
            if (r3 == 0) goto L_0x007c
            android.hardware.camera2.CaptureRequest$Key r8 = android.hardware.camera2.CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE
            r7.set(r8, r2)
            return r4
        L_0x009e:
            r6.mPreviewFrameRate = r8
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.engine.Camera2Engine.applyPreviewFrameRate(android.hardware.camera2.CaptureRequest$Builder, float):boolean");
    }

    @EngineThread
    public void applyRepeatingRequestBuilder() {
        l(true, 3);
    }

    public boolean applyWhiteBalance(@NonNull CaptureRequest.Builder builder, @NonNull WhiteBalance whiteBalance) {
        if (this.mCameraOptions.supports(this.mWhiteBalance)) {
            builder.set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(this.F.mapWhiteBalance(this.mWhiteBalance)));
            return true;
        }
        this.mWhiteBalance = whiteBalance;
        return false;
    }

    public boolean applyZoom(@NonNull CaptureRequest.Builder builder, float f2) {
        if (this.mCameraOptions.isZoomSupported()) {
            float floatValue = ((Float) q(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM, Float.valueOf(1.0f))).floatValue();
            float f3 = floatValue - 1.0f;
            Rect rect = (Rect) q(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE, new Rect());
            int height = (int) (((float) rect.height()) / floatValue);
            int width = rect.width() - ((int) (((float) rect.width()) / floatValue));
            int height2 = rect.height() - height;
            float f4 = ((this.mZoomValue * f3) + 1.0f) - 1.0f;
            int i2 = (int) (((((float) width) * f4) / f3) / 2.0f);
            int i3 = (int) (((((float) height2) * f4) / f3) / 2.0f);
            builder.set(CaptureRequest.SCALER_CROP_REGION, new Rect(i2, i3, rect.width() - i2, rect.height() - i3));
            return true;
        }
        this.mZoomValue = f2;
        return false;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @EngineThread
    public final boolean collectCameraInfo(@NonNull Facing facing) {
        int mapFacing = this.F.mapFacing(facing);
        try {
            String[] cameraIdList = this.y.getCameraIdList();
            CameraEngine.LOG.i("collectCameraInfo", "Facing:", facing, "Internal:", Integer.valueOf(mapFacing), "Cameras:", Integer.valueOf(cameraIdList.length));
            for (String str : cameraIdList) {
                try {
                    CameraCharacteristics cameraCharacteristics = this.y.getCameraCharacteristics(str);
                    if (mapFacing == ((Integer) r(cameraCharacteristics, CameraCharacteristics.LENS_FACING, -99)).intValue()) {
                        this.z = str;
                        getAngles().setSensorOffset(facing, ((Integer) r(cameraCharacteristics, CameraCharacteristics.SENSOR_ORIENTATION, 0)).intValue());
                        return true;
                    }
                } catch (CameraAccessException unused) {
                }
            }
            return false;
        } catch (CameraAccessException e2) {
            throw m(e2);
        }
    }

    @NonNull
    public List<Range<Integer>> filterFrameRateRanges(@NonNull Range<Integer>[] rangeArr) {
        ArrayList arrayList = new ArrayList();
        int round = Math.round(this.mCameraOptions.getPreviewFrameRateMinValue());
        int round2 = Math.round(this.mCameraOptions.getPreviewFrameRateMaxValue());
        for (Range<Integer> range : rangeArr) {
            if (range.contains((Range<Integer>) Integer.valueOf(round)) && range.contains((Range<Integer>) Integer.valueOf(round2)) && FpsRangeValidator.validate(range)) {
                arrayList.add(range);
            }
        }
        return arrayList;
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionHolder
    @NonNull
    public CaptureRequest.Builder getBuilder(@NonNull Action action) {
        return this.D;
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionHolder
    @NonNull
    public CameraCharacteristics getCharacteristics(@NonNull Action action) {
        return this.B;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @NonNull
    @EngineThread
    public List<Size> getFrameProcessingAvailableSizes() {
        try {
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.y.getCameraCharacteristics(this.z).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap != null) {
                android.util.Size[] outputSizes = streamConfigurationMap.getOutputSizes(this.mFrameProcessingFormat);
                ArrayList arrayList = new ArrayList(outputSizes.length);
                for (android.util.Size size : outputSizes) {
                    Size size2 = new Size(size.getWidth(), size.getHeight());
                    if (!arrayList.contains(size2)) {
                        arrayList.add(size2);
                    }
                }
                return arrayList;
            }
            throw new RuntimeException("StreamConfigurationMap is null. Should not happen.");
        } catch (CameraAccessException e2) {
            throw m(e2);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionHolder
    @Nullable
    public TotalCaptureResult getLastResult(@NonNull Action action) {
        return this.E;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @NonNull
    @EngineThread
    public List<Size> getPreviewStreamAvailableSizes() {
        try {
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.y.getCameraCharacteristics(this.z).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap != null) {
                android.util.Size[] outputSizes = streamConfigurationMap.getOutputSizes(this.mPreview.getOutputClass());
                ArrayList arrayList = new ArrayList(outputSizes.length);
                for (android.util.Size size : outputSizes) {
                    Size size2 = new Size(size.getWidth(), size.getHeight());
                    if (!arrayList.contains(size2)) {
                        arrayList.add(size2);
                    }
                }
                return arrayList;
            }
            throw new RuntimeException("StreamConfigurationMap is null. Should not happen.");
        } catch (CameraAccessException e2) {
            throw m(e2);
        }
    }

    public int getRepeatingRequestDefaultTemplate() {
        return 1;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @NonNull
    public FrameManager instantiateFrameManager(int i2) {
        return new ImageFrameManager(i2);
    }

    public final void j(@NonNull Surface... surfaceArr) {
        this.D.addTarget(this.I);
        Surface surface = this.H;
        if (surface != null) {
            this.D.addTarget(surface);
        }
        for (Surface surface2 : surfaceArr) {
            if (surface2 != null) {
                this.D.addTarget(surface2);
            } else {
                throw new IllegalArgumentException("Should not add a null surface.");
            }
        }
    }

    public final void k(@NonNull CaptureRequest.Builder builder, @Nullable CaptureRequest.Builder builder2) {
        CameraEngine.LOG.i("applyAllParameters:", "called for tag", builder.build().getTag());
        builder.set(CaptureRequest.CONTROL_MODE, 1);
        applyDefaultFocus(builder);
        applyFlash(builder, Flash.OFF);
        applyLocation(builder, null);
        applyWhiteBalance(builder, WhiteBalance.AUTO);
        applyHdr(builder, Hdr.OFF);
        applyZoom(builder, 0.0f);
        applyExposureCorrection(builder, 0.0f);
        applyPreviewFrameRate(builder, 0.0f);
        if (builder2 != null) {
            CaptureRequest.Key key = CaptureRequest.CONTROL_AF_REGIONS;
            builder.set(key, builder2.get(key));
            CaptureRequest.Key key2 = CaptureRequest.CONTROL_AE_REGIONS;
            builder.set(key2, builder2.get(key2));
            CaptureRequest.Key key3 = CaptureRequest.CONTROL_AWB_REGIONS;
            builder.set(key3, builder2.get(key3));
            CaptureRequest.Key key4 = CaptureRequest.CONTROL_AF_MODE;
            builder.set(key4, builder2.get(key4));
        }
    }

    @EngineThread
    public final void l(boolean z2, int i2) {
        if ((getState() == CameraState.PREVIEW && !isChangingState()) || !z2) {
            try {
                this.C.setRepeatingRequest(this.D.build(), this.N, null);
            } catch (CameraAccessException e2) {
                throw new CameraException(e2, i2);
            } catch (IllegalStateException e3) {
                CameraEngine.LOG.e("applyRepeatingRequestBuilder: session is invalid!", e3, "checkStarted:", Boolean.valueOf(z2), "currentThread:", Thread.currentThread().getName(), "state:", getState(), "targetState:", getTargetState());
                throw new CameraException(3);
            }
        }
    }

    @NonNull
    public final CameraException m(@NonNull CameraAccessException cameraAccessException) {
        int reason = cameraAccessException.getReason();
        int i2 = 3;
        if (reason != 1) {
            if (!(reason == 2 || reason == 3)) {
                if (!(reason == 4 || reason == 5)) {
                    i2 = 0;
                }
            }
            return new CameraException(cameraAccessException, i2);
        }
        i2 = 1;
        return new CameraException(cameraAccessException, i2);
    }

    @NonNull
    public final MeterAction n(@Nullable MeteringRegions meteringRegions) {
        MeterAction meterAction = this.M;
        if (meterAction != null) {
            meterAction.abort(this);
        }
        applyFocusForMetering(this.D);
        MeterAction meterAction2 = new MeterAction(this, meteringRegions, meteringRegions == null);
        this.M = meterAction2;
        return meterAction2;
    }

    @NonNull
    public final CaptureRequest.Builder o(int i2) throws CameraAccessException {
        CaptureRequest.Builder builder = this.D;
        CaptureRequest.Builder createCaptureRequest = this.A.createCaptureRequest(i2);
        this.D = createCaptureRequest;
        createCaptureRequest.setTag(Integer.valueOf(i2));
        k(this.D, builder);
        return this.D;
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    @EngineThread
    public void onImageAvailable(ImageReader imageReader) {
        Image image;
        CameraEngine.LOG.v("onImageAvailable:", "trying to acquire Image.");
        try {
            image = imageReader.acquireLatestImage();
        } catch (Exception unused) {
            image = null;
        }
        if (image == null) {
            CameraEngine.LOG.w("onImageAvailable:", "failed to acquire Image!");
        } else if (getState() != CameraState.PREVIEW || isChangingState()) {
            CameraEngine.LOG.i("onImageAvailable:", "Image acquired in wrong state. Closing it now.");
            image.close();
        } else {
            Frame frame = getFrameManager().getFrame(image, System.currentTimeMillis());
            if (frame != null) {
                CameraEngine.LOG.v("onImageAvailable:", "Image acquired, dispatching.");
                getCallback().dispatchFrame(frame);
                return;
            }
            CameraEngine.LOG.i("onImageAvailable:", "Image acquired, but no free frames. DROPPING.");
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine, com.otaliastudios.cameraview.picture.PictureRecorder.PictureResultListener
    public void onPictureResult(@Nullable PictureResult.Stub stub, @Nullable Exception exc) {
        boolean z2 = this.mPictureRecorder instanceof Full2PictureRecorder;
        super.onPictureResult(stub, exc);
        if ((z2 && getPictureMetering()) || (!z2 && getPictureSnapshotMetering())) {
            getOrchestrator().scheduleStateful("reset metering after picture", CameraState.PREVIEW, new u());
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @EngineThread
    public void onPreviewStreamSizeChanged() {
        CameraEngine.LOG.i("onPreviewStreamSizeChanged:", "Calling restartBind().");
        restartBind();
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @NonNull
    @EngineThread
    public Task<Void> onStartBind() {
        int i2;
        CameraLogger cameraLogger = CameraEngine.LOG;
        cameraLogger.i("onStartBind:", "Started");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.mCaptureSize = computeCaptureSize();
        this.mPreviewStreamSize = computePreviewStreamSize();
        ArrayList arrayList = new ArrayList();
        Class outputClass = this.mPreview.getOutputClass();
        Object output = this.mPreview.getOutput();
        if (outputClass == SurfaceHolder.class) {
            try {
                cameraLogger.i("onStartBind:", "Waiting on UI thread...");
                Tasks.await(Tasks.call(new o(output)));
                this.I = ((SurfaceHolder) output).getSurface();
            } catch (InterruptedException | ExecutionException e2) {
                throw new CameraException(e2, 1);
            }
        } else if (outputClass == SurfaceTexture.class) {
            SurfaceTexture surfaceTexture = (SurfaceTexture) output;
            surfaceTexture.setDefaultBufferSize(this.mPreviewStreamSize.getWidth(), this.mPreviewStreamSize.getHeight());
            this.I = new Surface(surfaceTexture);
        } else {
            throw new RuntimeException("Unknown CameraPreview output class.");
        }
        arrayList.add(this.I);
        if (getMode() == Mode.VIDEO && this.J != null) {
            Full2VideoRecorder full2VideoRecorder = new Full2VideoRecorder(this, this.z);
            try {
                arrayList.add(full2VideoRecorder.createInputSurface(this.J));
                this.mVideoRecorder = full2VideoRecorder;
            } catch (Full2VideoRecorder.PrepareException e3) {
                throw new CameraException(e3, 1);
            }
        }
        if (getMode() == Mode.PICTURE) {
            int ordinal = this.mPictureFormat.ordinal();
            if (ordinal == 0) {
                i2 = 256;
            } else if (ordinal == 1) {
                i2 = 32;
            } else {
                StringBuilder L2 = a2.b.a.a.a.L("Unknown format:");
                L2.append(this.mPictureFormat);
                throw new IllegalArgumentException(L2.toString());
            }
            ImageReader newInstance = ImageReader.newInstance(this.mCaptureSize.getWidth(), this.mCaptureSize.getHeight(), i2, 2);
            this.K = newInstance;
            arrayList.add(newInstance.getSurface());
        }
        if (hasFrameProcessors()) {
            Size computeFrameProcessingSize = computeFrameProcessingSize();
            this.mFrameProcessingSize = computeFrameProcessingSize;
            ImageReader newInstance2 = ImageReader.newInstance(computeFrameProcessingSize.getWidth(), this.mFrameProcessingSize.getHeight(), this.mFrameProcessingFormat, getFrameProcessingPoolSize() + 1);
            this.G = newInstance2;
            newInstance2.setOnImageAvailableListener(this, null);
            Surface surface = this.G.getSurface();
            this.H = surface;
            arrayList.add(surface);
        } else {
            this.G = null;
            this.mFrameProcessingSize = null;
            this.H = null;
        }
        try {
            this.A.createCaptureSession(arrayList, new p(taskCompletionSource), null);
            return taskCompletionSource.getTask();
        } catch (CameraAccessException e4) {
            throw m(e4);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @NonNull
    @EngineThread
    @SuppressLint({"MissingPermission"})
    public Task<CameraOptions> onStartEngine() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            this.y.openCamera(this.z, new n(taskCompletionSource), (Handler) null);
            return taskCompletionSource.getTask();
        } catch (CameraAccessException e2) {
            throw m(e2);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @NonNull
    @EngineThread
    public Task<Void> onStartPreview() {
        CameraLogger cameraLogger = CameraEngine.LOG;
        cameraLogger.i("onStartPreview:", "Dispatching onCameraPreviewStreamSizeChanged.");
        getCallback().onCameraPreviewStreamSizeChanged();
        Reference reference = Reference.VIEW;
        Size previewStreamSize = getPreviewStreamSize(reference);
        if (previewStreamSize != null) {
            this.mPreview.setStreamSize(previewStreamSize.getWidth(), previewStreamSize.getHeight());
            this.mPreview.setDrawRotation(getAngles().offset(Reference.BASE, reference, Axis.ABSOLUTE));
            if (hasFrameProcessors()) {
                getFrameManager().setUp(this.mFrameProcessingFormat, this.mFrameProcessingSize, getAngles());
            }
            cameraLogger.i("onStartPreview:", "Starting preview.");
            j(new Surface[0]);
            l(false, 2);
            cameraLogger.i("onStartPreview:", "Started preview.");
            VideoResult.Stub stub = this.J;
            if (stub != null) {
                this.J = null;
                getOrchestrator().scheduleStateful("do take video", CameraState.PREVIEW, new q(stub));
            }
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            new r(this, taskCompletionSource).start(this);
            return taskCompletionSource.getTask();
        }
        throw new IllegalStateException("previewStreamSize should not be null at this point.");
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @NonNull
    @EngineThread
    public Task<Void> onStopBind() {
        CameraLogger cameraLogger = CameraEngine.LOG;
        cameraLogger.i("onStopBind:", "About to clean up.");
        this.H = null;
        this.I = null;
        this.mPreviewStreamSize = null;
        this.mCaptureSize = null;
        this.mFrameProcessingSize = null;
        ImageReader imageReader = this.G;
        if (imageReader != null) {
            imageReader.close();
            this.G = null;
        }
        ImageReader imageReader2 = this.K;
        if (imageReader2 != null) {
            imageReader2.close();
            this.K = null;
        }
        this.C.close();
        this.C = null;
        cameraLogger.i("onStopBind:", "Returning.");
        return Tasks.forResult(null);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @NonNull
    @EngineThread
    public Task<Void> onStopEngine() {
        try {
            CameraLogger cameraLogger = CameraEngine.LOG;
            cameraLogger.i("onStopEngine:", "Clean up.", "Releasing camera.");
            this.A.close();
            cameraLogger.i("onStopEngine:", "Clean up.", "Released camera.");
        } catch (Exception e2) {
            CameraEngine.LOG.w("onStopEngine:", "Clean up.", "Exception while releasing camera.", e2);
        }
        this.A = null;
        CameraEngine.LOG.i("onStopEngine:", "Aborting actions.");
        for (Action action : this.L) {
            action.abort(this);
        }
        this.B = null;
        this.mCameraOptions = null;
        this.mVideoRecorder = null;
        this.D = null;
        CameraEngine.LOG.w("onStopEngine:", "Returning.");
        return Tasks.forResult(null);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @NonNull
    @EngineThread
    public Task<Void> onStopPreview() {
        CameraLogger cameraLogger = CameraEngine.LOG;
        cameraLogger.i("onStopPreview:", "Started.");
        VideoRecorder videoRecorder = this.mVideoRecorder;
        if (videoRecorder != null) {
            videoRecorder.stop(true);
            this.mVideoRecorder = null;
        }
        this.mPictureRecorder = null;
        if (hasFrameProcessors()) {
            getFrameManager().release();
        }
        this.D.removeTarget(this.I);
        Surface surface = this.H;
        if (surface != null) {
            this.D.removeTarget(surface);
        }
        this.E = null;
        cameraLogger.i("onStopPreview:", "Returning.");
        return Tasks.forResult(null);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @EngineThread
    public void onTakePicture(@NonNull PictureResult.Stub stub, boolean z2) {
        if (z2) {
            CameraEngine.LOG.i("onTakePicture:", "doMetering is true. Delaying.");
            BaseAction timeout = Actions.timeout(2500, n(null));
            timeout.addCallback(new t(stub));
            timeout.start(this);
            return;
        }
        CameraEngine.LOG.i("onTakePicture:", "doMetering is false. Performing.");
        Angles angles = getAngles();
        Reference reference = Reference.SENSOR;
        Reference reference2 = Reference.OUTPUT;
        stub.rotation = angles.offset(reference, reference2, Axis.RELATIVE_TO_SENSOR);
        stub.size = getPictureSize(reference2);
        try {
            CaptureRequest.Builder createCaptureRequest = this.A.createCaptureRequest(2);
            k(createCaptureRequest, this.D);
            Full2PictureRecorder full2PictureRecorder = new Full2PictureRecorder(stub, this, createCaptureRequest, this.K);
            this.mPictureRecorder = full2PictureRecorder;
            full2PictureRecorder.take();
        } catch (CameraAccessException e2) {
            throw m(e2);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @EngineThread
    public void onTakePictureSnapshot(@NonNull PictureResult.Stub stub, @NonNull AspectRatio aspectRatio, boolean z2) {
        if (z2) {
            CameraEngine.LOG.i("onTakePictureSnapshot:", "doMetering is true. Delaying.");
            BaseAction timeout = Actions.timeout(2500, n(null));
            timeout.addCallback(new s(stub));
            timeout.start(this);
            return;
        }
        CameraEngine.LOG.i("onTakePictureSnapshot:", "doMetering is false. Performing.");
        if (this.mPreview instanceof RendererCameraPreview) {
            Reference reference = Reference.OUTPUT;
            stub.size = getUncroppedSnapshotSize(reference);
            stub.rotation = getAngles().offset(Reference.VIEW, reference, Axis.ABSOLUTE);
            Snapshot2PictureRecorder snapshot2PictureRecorder = new Snapshot2PictureRecorder(stub, this, (RendererCameraPreview) this.mPreview, aspectRatio);
            this.mPictureRecorder = snapshot2PictureRecorder;
            snapshot2PictureRecorder.take();
            return;
        }
        throw new RuntimeException("takePictureSnapshot with Camera2 is only supported with Preview.GL_SURFACE");
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @EngineThread
    public void onTakeVideo(@NonNull VideoResult.Stub stub) {
        CameraLogger cameraLogger = CameraEngine.LOG;
        cameraLogger.i("onTakeVideo", "called.");
        Angles angles = getAngles();
        Reference reference = Reference.SENSOR;
        Reference reference2 = Reference.OUTPUT;
        stub.rotation = angles.offset(reference, reference2, Axis.RELATIVE_TO_SENSOR);
        stub.size = getAngles().flip(reference, reference2) ? this.mCaptureSize.flip() : this.mCaptureSize;
        cameraLogger.w("onTakeVideo", "calling restartBind.");
        this.J = stub;
        restartBind();
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @EngineThread
    public void onTakeVideoSnapshot(@NonNull VideoResult.Stub stub, @NonNull AspectRatio aspectRatio) {
        CameraPreview cameraPreview = this.mPreview;
        if (cameraPreview instanceof RendererCameraPreview) {
            RendererCameraPreview rendererCameraPreview = (RendererCameraPreview) cameraPreview;
            Reference reference = Reference.OUTPUT;
            Size uncroppedSnapshotSize = getUncroppedSnapshotSize(reference);
            if (uncroppedSnapshotSize != null) {
                Rect computeCrop = CropHelper.computeCrop(uncroppedSnapshotSize, aspectRatio);
                stub.size = new Size(computeCrop.width(), computeCrop.height());
                stub.rotation = getAngles().offset(Reference.VIEW, reference, Axis.ABSOLUTE);
                stub.videoFrameRate = Math.round(this.mPreviewFrameRate);
                CameraEngine.LOG.i("onTakeVideoSnapshot", "rotation:", Integer.valueOf(stub.rotation), "size:", stub.size);
                SnapshotVideoRecorder snapshotVideoRecorder = new SnapshotVideoRecorder(this, rendererCameraPreview, getOverlay());
                this.mVideoRecorder = snapshotVideoRecorder;
                snapshotVideoRecorder.start(stub);
                return;
            }
            throw new IllegalStateException("outputSize should not be null.");
        }
        throw new IllegalStateException("Video snapshots are only supported with GL_SURFACE.");
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine, com.otaliastudios.cameraview.video.VideoRecorder.VideoResultListener
    public void onVideoRecordingEnd() {
        super.onVideoRecordingEnd();
        if ((this.mVideoRecorder instanceof Full2VideoRecorder) && ((Integer) q(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, -1)).intValue() == 2) {
            CameraLogger cameraLogger = CameraEngine.LOG;
            cameraLogger.w("Applying the Issue549 workaround.", Thread.currentThread());
            p();
            cameraLogger.w("Applied the Issue549 workaround. Sleeping...");
            try {
                Thread.sleep(600);
            } catch (InterruptedException unused) {
            }
            CameraEngine.LOG.w("Applied the Issue549 workaround. Slept!");
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine, com.otaliastudios.cameraview.video.VideoRecorder.VideoResultListener
    public void onVideoResult(@Nullable VideoResult.Stub stub, @Nullable Exception exc) {
        super.onVideoResult(stub, exc);
        getOrchestrator().scheduleStateful("restore preview template", CameraState.BIND, new a());
    }

    @EngineThread
    public final void p() {
        if (((Integer) this.D.build().getTag()).intValue() != getRepeatingRequestDefaultTemplate()) {
            try {
                o(getRepeatingRequestDefaultTemplate());
                j(new Surface[0]);
                applyRepeatingRequestBuilder();
            } catch (CameraAccessException e2) {
                throw m(e2);
            }
        }
    }

    @NonNull
    @VisibleForTesting
    public <T> T q(@NonNull CameraCharacteristics.Key<T> key, @NonNull T t2) {
        T t3 = (T) this.B.get(key);
        return t3 == null ? t2 : t3;
    }

    @NonNull
    public final <T> T r(@NonNull CameraCharacteristics cameraCharacteristics, @NonNull CameraCharacteristics.Key<T> key, @NonNull T t2) {
        T t3 = (T) cameraCharacteristics.get(key);
        return t3 == null ? t2 : t3;
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionHolder
    public void removeAction(@NonNull Action action) {
        this.L.remove(action);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setExposureCorrection(float f2, @NonNull float[] fArr, @Nullable PointF[] pointFArr, boolean z2) {
        float f3 = this.mExposureCorrectionValue;
        this.mExposureCorrectionValue = f2;
        getOrchestrator().trim("exposure correction", 20);
        getOrchestrator().scheduleStateful("exposure correction", CameraState.ENGINE, new g(f3, z2, f2, fArr, pointFArr));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setFlash(@NonNull Flash flash) {
        Flash flash2 = this.mFlash;
        this.mFlash = flash;
        CameraStateOrchestrator orchestrator = getOrchestrator();
        orchestrator.scheduleStateful("flash (" + flash + ")", CameraState.ENGINE, new b(flash2, flash));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setFrameProcessingFormat(int i2) {
        if (this.mFrameProcessingFormat == 0) {
            this.mFrameProcessingFormat = 35;
        }
        getOrchestrator().schedule(a2.b.a.a.a.Q2("frame processing format (", i2, ")"), true, (Runnable) new l(i2));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setHasFrameProcessors(boolean z2) {
        CameraStateOrchestrator orchestrator = getOrchestrator();
        orchestrator.schedule("has frame processors (" + z2 + ")", true, (Runnable) new k(z2));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setHdr(@NonNull Hdr hdr) {
        Hdr hdr2 = this.mHdr;
        this.mHdr = hdr;
        CameraStateOrchestrator orchestrator = getOrchestrator();
        orchestrator.scheduleStateful("hdr (" + hdr + ")", CameraState.ENGINE, new e(hdr2));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setLocation(@Nullable Location location) {
        Location location2 = this.mLocation;
        this.mLocation = location;
        getOrchestrator().scheduleStateful("location", CameraState.ENGINE, new c(location2));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setPictureFormat(@NonNull PictureFormat pictureFormat) {
        if (pictureFormat != this.mPictureFormat) {
            this.mPictureFormat = pictureFormat;
            CameraStateOrchestrator orchestrator = getOrchestrator();
            orchestrator.scheduleStateful("picture format (" + pictureFormat + ")", CameraState.ENGINE, new i());
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setPlaySounds(boolean z2) {
        this.mPlaySounds = z2;
        Tasks.forResult(null);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setPreviewFrameRate(float f2) {
        float f3 = this.mPreviewFrameRate;
        this.mPreviewFrameRate = f2;
        CameraStateOrchestrator orchestrator = getOrchestrator();
        orchestrator.scheduleStateful("preview fps (" + f2 + ")", CameraState.ENGINE, new h(f3));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setWhiteBalance(@NonNull WhiteBalance whiteBalance) {
        WhiteBalance whiteBalance2 = this.mWhiteBalance;
        this.mWhiteBalance = whiteBalance;
        CameraStateOrchestrator orchestrator = getOrchestrator();
        orchestrator.scheduleStateful("white balance (" + whiteBalance + ")", CameraState.ENGINE, new d(whiteBalance2));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setZoom(float f2, @Nullable PointF[] pointFArr, boolean z2) {
        float f3 = this.mZoomValue;
        this.mZoomValue = f2;
        getOrchestrator().trim("zoom", 20);
        getOrchestrator().scheduleStateful("zoom", CameraState.ENGINE, new f(f3, z2, f2, pointFArr));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void startAutoFocus(@Nullable Gesture gesture, @NonNull MeteringRegions meteringRegions, @NonNull PointF pointF) {
        CameraStateOrchestrator orchestrator = getOrchestrator();
        orchestrator.scheduleStateful("autofocus (" + gesture + ")", CameraState.PREVIEW, new m(gesture, pointF, meteringRegions));
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionHolder
    public void applyBuilder(@NonNull Action action, @NonNull CaptureRequest.Builder builder) throws CameraAccessException {
        if (getState() == CameraState.PREVIEW && !isChangingState()) {
            this.C.capture(builder.build(), this.N, null);
        }
    }
}
