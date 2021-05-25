package com.otaliastudios.cameraview.engine;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.location.Location;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.Task;
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
import com.otaliastudios.cameraview.engine.mappers.Camera1Mapper;
import com.otaliastudios.cameraview.engine.metering.Camera1MeteringTransform;
import com.otaliastudios.cameraview.engine.offset.Angles;
import com.otaliastudios.cameraview.engine.offset.Axis;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.engine.options.Camera1Options;
import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator;
import com.otaliastudios.cameraview.frame.ByteBufferFrameManager;
import com.otaliastudios.cameraview.frame.Frame;
import com.otaliastudios.cameraview.frame.FrameManager;
import com.otaliastudios.cameraview.gesture.Gesture;
import com.otaliastudios.cameraview.internal.CropHelper;
import com.otaliastudios.cameraview.metering.MeteringRegions;
import com.otaliastudios.cameraview.picture.Full1PictureRecorder;
import com.otaliastudios.cameraview.picture.Snapshot1PictureRecorder;
import com.otaliastudios.cameraview.picture.SnapshotGlPictureRecorder;
import com.otaliastudios.cameraview.preview.CameraPreview;
import com.otaliastudios.cameraview.preview.RendererCameraPreview;
import com.otaliastudios.cameraview.size.AspectRatio;
import com.otaliastudios.cameraview.size.Size;
import com.otaliastudios.cameraview.video.Full1VideoRecorder;
import com.otaliastudios.cameraview.video.SnapshotVideoRecorder;
import com.otaliastudios.cameraview.video.VideoRecorder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.coroutines.DebugKt;
public class Camera1Engine extends CameraBaseEngine implements Camera.PreviewCallback, Camera.ErrorCallback, ByteBufferFrameManager.BufferCallback {
    public static final /* synthetic */ int B = 0;
    @VisibleForTesting
    public int A;
    public final Camera1Mapper y = Camera1Mapper.get();
    public Camera z;

    public class a implements Runnable {
        public final /* synthetic */ MeteringRegions a;
        public final /* synthetic */ Gesture b;
        public final /* synthetic */ PointF c;

        /* renamed from: com.otaliastudios.cameraview.engine.Camera1Engine$a$a  reason: collision with other inner class name */
        public class RunnableC0309a implements Runnable {
            public RunnableC0309a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CameraEngine.Callback callback = Camera1Engine.this.getCallback();
                a aVar = a.this;
                callback.dispatchOnFocusEnd(aVar.b, false, aVar.c);
            }
        }

        public class b implements Camera.AutoFocusCallback {

            /* renamed from: com.otaliastudios.cameraview.engine.Camera1Engine$a$b$a  reason: collision with other inner class name */
            public class RunnableC0310a implements Runnable {
                public RunnableC0310a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    Camera1Engine.this.z.cancelAutoFocus();
                    Camera.Parameters parameters = Camera1Engine.this.z.getParameters();
                    int maxNumFocusAreas = parameters.getMaxNumFocusAreas();
                    int maxNumMeteringAreas = parameters.getMaxNumMeteringAreas();
                    if (maxNumFocusAreas > 0) {
                        parameters.setFocusAreas(null);
                    }
                    if (maxNumMeteringAreas > 0) {
                        parameters.setMeteringAreas(null);
                    }
                    Camera1Engine.this.j(parameters);
                    Camera1Engine.this.z.setParameters(parameters);
                }
            }

            public b() {
            }

            @Override // android.hardware.Camera.AutoFocusCallback
            public void onAutoFocus(boolean z, Camera camera) {
                Camera1Engine.this.getOrchestrator().remove("focus end");
                Camera1Engine.this.getOrchestrator().remove("focus reset");
                CameraEngine.Callback callback = Camera1Engine.this.getCallback();
                a aVar = a.this;
                callback.dispatchOnFocusEnd(aVar.b, z, aVar.c);
                if (Camera1Engine.this.shouldResetAutoFocus()) {
                    Camera1Engine.this.getOrchestrator().scheduleStatefulDelayed("focus reset", CameraState.ENGINE, Camera1Engine.this.getAutoFocusResetDelay(), new RunnableC0310a());
                }
            }
        }

        public a(MeteringRegions meteringRegions, Gesture gesture, PointF pointF) {
            this.a = meteringRegions;
            this.b = gesture;
            this.c = pointF;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Camera1Engine.this.mCameraOptions.isAutoFocusSupported()) {
                Camera1MeteringTransform camera1MeteringTransform = new Camera1MeteringTransform(Camera1Engine.this.getAngles(), Camera1Engine.this.getPreview().getSurfaceSize());
                MeteringRegions transform = this.a.transform(camera1MeteringTransform);
                Camera.Parameters parameters = Camera1Engine.this.z.getParameters();
                int maxNumFocusAreas = parameters.getMaxNumFocusAreas();
                int maxNumMeteringAreas = parameters.getMaxNumMeteringAreas();
                if (maxNumFocusAreas > 0) {
                    parameters.setFocusAreas(transform.get(maxNumFocusAreas, camera1MeteringTransform));
                }
                if (maxNumMeteringAreas > 0) {
                    parameters.setMeteringAreas(transform.get(maxNumMeteringAreas, camera1MeteringTransform));
                }
                parameters.setFocusMode(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
                Camera1Engine.this.z.setParameters(parameters);
                Camera1Engine.this.getCallback().dispatchOnFocusStart(this.b, this.c);
                Camera1Engine.this.getOrchestrator().remove("focus end");
                Camera1Engine.this.getOrchestrator().scheduleDelayed("focus end", true, 2500, new RunnableC0309a());
                try {
                    Camera1Engine.this.z.autoFocus(new b());
                } catch (RuntimeException e) {
                    CameraEngine.LOG.e("startAutoFocus:", "Error calling autoFocus", e);
                }
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ Flash a;

        public b(Flash flash) {
            this.a = flash;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = Camera1Engine.this.z.getParameters();
            if (Camera1Engine.this.l(parameters, this.a)) {
                Camera1Engine.this.z.setParameters(parameters);
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
            Camera.Parameters parameters = Camera1Engine.this.z.getParameters();
            if (Camera1Engine.this.n(parameters)) {
                Camera1Engine.this.z.setParameters(parameters);
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
            Camera.Parameters parameters = Camera1Engine.this.z.getParameters();
            if (Camera1Engine.this.q(parameters, this.a)) {
                Camera1Engine.this.z.setParameters(parameters);
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
            Camera.Parameters parameters = Camera1Engine.this.z.getParameters();
            if (Camera1Engine.this.m(parameters, this.a)) {
                Camera1Engine.this.z.setParameters(parameters);
            }
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ float a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ PointF[] c;

        public f(float f, boolean z, PointF[] pointFArr) {
            this.a = f;
            this.b = z;
            this.c = pointFArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = Camera1Engine.this.z.getParameters();
            if (Camera1Engine.this.r(parameters, this.a)) {
                Camera1Engine.this.z.setParameters(parameters);
                if (this.b) {
                    Camera1Engine.this.getCallback().dispatchOnZoomChanged(Camera1Engine.this.mZoomValue, this.c);
                }
            }
        }
    }

    public class g implements Runnable {
        public final /* synthetic */ float a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ float[] c;
        public final /* synthetic */ PointF[] d;

        public g(float f, boolean z, float[] fArr, PointF[] pointFArr) {
            this.a = f;
            this.b = z;
            this.c = fArr;
            this.d = pointFArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = Camera1Engine.this.z.getParameters();
            if (Camera1Engine.this.k(parameters, this.a)) {
                Camera1Engine.this.z.setParameters(parameters);
                if (this.b) {
                    Camera1Engine.this.getCallback().dispatchOnExposureCorrectionChanged(Camera1Engine.this.mExposureCorrectionValue, this.c, this.d);
                }
            }
        }
    }

    public class h implements Runnable {
        public final /* synthetic */ boolean a;

        public h(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera1Engine camera1Engine = Camera1Engine.this;
            boolean z = this.a;
            int i = Camera1Engine.B;
            camera1Engine.o(z);
        }
    }

    public class i implements Runnable {
        public final /* synthetic */ float a;

        public i(float f) {
            this.a = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = Camera1Engine.this.z.getParameters();
            if (Camera1Engine.this.p(parameters, this.a)) {
                Camera1Engine.this.z.setParameters(parameters);
            }
        }
    }

    public Camera1Engine(@NonNull CameraEngine.Callback callback) {
        super(callback);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @EngineThread
    public boolean collectCameraInfo(@NonNull Facing facing) {
        int mapFacing = this.y.mapFacing(facing);
        CameraEngine.LOG.i("collectCameraInfo", "Facing:", facing, "Internal:", Integer.valueOf(mapFacing), "Cameras:", Integer.valueOf(Camera.getNumberOfCameras()));
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == mapFacing) {
                getAngles().setSensorOffset(facing, cameraInfo.orientation);
                this.A = i2;
                return true;
            }
        }
        return false;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @NonNull
    @EngineThread
    public List<Size> getFrameProcessingAvailableSizes() {
        return Collections.singletonList(this.mPreviewStreamSize);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @NonNull
    @EngineThread
    public List<Size> getPreviewStreamAvailableSizes() {
        try {
            List<Camera.Size> supportedPreviewSizes = this.z.getParameters().getSupportedPreviewSizes();
            ArrayList arrayList = new ArrayList(supportedPreviewSizes.size());
            for (Camera.Size size : supportedPreviewSizes) {
                Size size2 = new Size(size.width, size.height);
                if (!arrayList.contains(size2)) {
                    arrayList.add(size2);
                }
            }
            CameraEngine.LOG.i("getPreviewStreamAvailableSizes:", arrayList);
            return arrayList;
        } catch (Exception e2) {
            CameraEngine.LOG.e("getPreviewStreamAvailableSizes:", "Failed to compute preview size. Camera params is empty");
            throw new CameraException(e2, 2);
        }
    }

    public final void i(@NonNull Camera.Parameters parameters) {
        parameters.setRecordingHint(getMode() == Mode.VIDEO);
        j(parameters);
        l(parameters, Flash.OFF);
        n(parameters);
        q(parameters, WhiteBalance.AUTO);
        m(parameters, Hdr.OFF);
        r(parameters, 0.0f);
        k(parameters, 0.0f);
        o(this.mPlaySounds);
        p(parameters, 0.0f);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @NonNull
    public FrameManager instantiateFrameManager(int i2) {
        return new ByteBufferFrameManager(i2, this);
    }

    public final void j(@NonNull Camera.Parameters parameters) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (getMode() == Mode.VIDEO && supportedFocusModes.contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
        } else if (supportedFocusModes.contains("continuous-picture")) {
            parameters.setFocusMode("continuous-picture");
        } else if (supportedFocusModes.contains("infinity")) {
            parameters.setFocusMode("infinity");
        } else if (supportedFocusModes.contains("fixed")) {
            parameters.setFocusMode("fixed");
        }
    }

    public final boolean k(@NonNull Camera.Parameters parameters, float f2) {
        if (this.mCameraOptions.isExposureCorrectionSupported()) {
            float exposureCorrectionMaxValue = this.mCameraOptions.getExposureCorrectionMaxValue();
            float exposureCorrectionMinValue = this.mCameraOptions.getExposureCorrectionMinValue();
            float f3 = this.mExposureCorrectionValue;
            if (f3 < exposureCorrectionMinValue) {
                exposureCorrectionMaxValue = exposureCorrectionMinValue;
            } else if (f3 <= exposureCorrectionMaxValue) {
                exposureCorrectionMaxValue = f3;
            }
            this.mExposureCorrectionValue = exposureCorrectionMaxValue;
            parameters.setExposureCompensation((int) (exposureCorrectionMaxValue / parameters.getExposureCompensationStep()));
            return true;
        }
        this.mExposureCorrectionValue = f2;
        return false;
    }

    public final boolean l(@NonNull Camera.Parameters parameters, @NonNull Flash flash) {
        if (this.mCameraOptions.supports(this.mFlash)) {
            parameters.setFlashMode(this.y.mapFlash(this.mFlash));
            return true;
        }
        this.mFlash = flash;
        return false;
    }

    public final boolean m(@NonNull Camera.Parameters parameters, @NonNull Hdr hdr) {
        if (this.mCameraOptions.supports(this.mHdr)) {
            parameters.setSceneMode(this.y.mapHdr(this.mHdr));
            return true;
        }
        this.mHdr = hdr;
        return false;
    }

    public final boolean n(@NonNull Camera.Parameters parameters) {
        Location location = this.mLocation;
        if (location == null) {
            return true;
        }
        parameters.setGpsLatitude(location.getLatitude());
        parameters.setGpsLongitude(this.mLocation.getLongitude());
        parameters.setGpsAltitude(this.mLocation.getAltitude());
        parameters.setGpsTimestamp(this.mLocation.getTime());
        parameters.setGpsProcessingMethod(this.mLocation.getProvider());
        return true;
    }

    @TargetApi(17)
    public final boolean o(boolean z2) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(this.A, cameraInfo);
        if (cameraInfo.canDisableShutterSound) {
            try {
                return this.z.enableShutterSound(this.mPlaySounds);
            } catch (RuntimeException unused) {
                return false;
            }
        } else if (this.mPlaySounds) {
            return true;
        } else {
            this.mPlaySounds = z2;
            return false;
        }
    }

    @Override // com.otaliastudios.cameraview.frame.ByteBufferFrameManager.BufferCallback
    public void onBufferAvailable(@NonNull byte[] bArr) {
        CameraState state = getState();
        CameraState cameraState = CameraState.ENGINE;
        if (state.isAtLeast(cameraState) && getTargetState().isAtLeast(cameraState)) {
            this.z.addCallbackBuffer(bArr);
        }
    }

    @Override // android.hardware.Camera.ErrorCallback
    public void onError(int i2, Camera camera) {
        int i3 = 0;
        RuntimeException runtimeException = new RuntimeException(CameraEngine.LOG.e("Internal Camera1 error.", Integer.valueOf(i2)));
        if (i2 == 1 || i2 == 2 || i2 == 100) {
            i3 = 3;
        }
        throw new CameraException(runtimeException, i3);
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Frame frame;
        if (bArr != null && (frame = getFrameManager().getFrame(bArr, System.currentTimeMillis())) != null) {
            getCallback().dispatchFrame(frame);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @EngineThread
    public void onPreviewStreamSizeChanged() {
        restartPreview();
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @NonNull
    @EngineThread
    public Task<Void> onStartBind() {
        CameraLogger cameraLogger = CameraEngine.LOG;
        cameraLogger.i("onStartBind:", "Started");
        try {
            if (this.mPreview.getOutputClass() == SurfaceHolder.class) {
                this.z.setPreviewDisplay((SurfaceHolder) this.mPreview.getOutput());
            } else if (this.mPreview.getOutputClass() == SurfaceTexture.class) {
                this.z.setPreviewTexture((SurfaceTexture) this.mPreview.getOutput());
            } else {
                throw new RuntimeException("Unknown CameraPreview output class.");
            }
            this.mCaptureSize = computeCaptureSize();
            this.mPreviewStreamSize = computePreviewStreamSize();
            cameraLogger.i("onStartBind:", "Returning");
            return Tasks.forResult(null);
        } catch (IOException e2) {
            CameraEngine.LOG.e("onStartBind:", "Failed to bind.", e2);
            throw new CameraException(e2, 2);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @NonNull
    @EngineThread
    public Task<CameraOptions> onStartEngine() {
        try {
            Camera open = Camera.open(this.A);
            this.z = open;
            if (open != null) {
                open.setErrorCallback(this);
                CameraLogger cameraLogger = CameraEngine.LOG;
                cameraLogger.i("onStartEngine:", "Applying default parameters.");
                try {
                    Camera.Parameters parameters = this.z.getParameters();
                    int i2 = this.A;
                    Angles angles = getAngles();
                    Reference reference = Reference.SENSOR;
                    Reference reference2 = Reference.VIEW;
                    this.mCameraOptions = new Camera1Options(parameters, i2, angles.flip(reference, reference2));
                    i(parameters);
                    this.z.setParameters(parameters);
                    try {
                        this.z.setDisplayOrientation(getAngles().offset(reference, reference2, Axis.ABSOLUTE));
                        cameraLogger.i("onStartEngine:", "Ended");
                        return Tasks.forResult(this.mCameraOptions);
                    } catch (Exception unused) {
                        CameraEngine.LOG.e("onStartEngine:", "Failed to connect. Can't set display orientation, maybe preview already exists?");
                        throw new CameraException(1);
                    }
                } catch (Exception e2) {
                    CameraEngine.LOG.e("onStartEngine:", "Failed to connect. Problem with camera params");
                    throw new CameraException(e2, 1);
                }
            } else {
                CameraEngine.LOG.e("onStartEngine:", "Failed to connect. Camera is null, maybe in use by another app or already released?");
                throw new CameraException(1);
            }
        } catch (Exception e3) {
            CameraEngine.LOG.e("onStartEngine:", "Failed to connect. Maybe in use by another app?");
            throw new CameraException(e3, 1);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @NonNull
    @EngineThread
    public Task<Void> onStartPreview() {
        CameraLogger cameraLogger = CameraEngine.LOG;
        cameraLogger.i("onStartPreview", "Dispatching onCameraPreviewStreamSizeChanged.");
        getCallback().onCameraPreviewStreamSizeChanged();
        Size previewStreamSize = getPreviewStreamSize(Reference.VIEW);
        if (previewStreamSize != null) {
            this.mPreview.setStreamSize(previewStreamSize.getWidth(), previewStreamSize.getHeight());
            this.mPreview.setDrawRotation(0);
            try {
                Camera.Parameters parameters = this.z.getParameters();
                parameters.setPreviewFormat(17);
                parameters.setPreviewSize(this.mPreviewStreamSize.getWidth(), this.mPreviewStreamSize.getHeight());
                Mode mode = getMode();
                Mode mode2 = Mode.PICTURE;
                if (mode == mode2) {
                    parameters.setPictureSize(this.mCaptureSize.getWidth(), this.mCaptureSize.getHeight());
                } else {
                    Size computeCaptureSize = computeCaptureSize(mode2);
                    parameters.setPictureSize(computeCaptureSize.getWidth(), computeCaptureSize.getHeight());
                }
                try {
                    this.z.setParameters(parameters);
                    this.z.setPreviewCallbackWithBuffer(null);
                    this.z.setPreviewCallbackWithBuffer(this);
                    getFrameManager().setUp(17, this.mPreviewStreamSize, getAngles());
                    cameraLogger.i("onStartPreview", "Starting preview with startPreview().");
                    try {
                        this.z.startPreview();
                        cameraLogger.i("onStartPreview", "Started preview.");
                        return Tasks.forResult(null);
                    } catch (Exception e2) {
                        CameraEngine.LOG.e("onStartPreview", "Failed to start preview.", e2);
                        throw new CameraException(e2, 2);
                    }
                } catch (Exception e3) {
                    CameraEngine.LOG.e("onStartPreview:", "Failed to set params for camera. Maybe incorrect parameter put in params?");
                    throw new CameraException(e3, 2);
                }
            } catch (Exception e4) {
                CameraEngine.LOG.e("onStartPreview:", "Failed to get params from camera. Maybe low level problem with camera or camera has already released?");
                throw new CameraException(e4, 2);
            }
        } else {
            throw new IllegalStateException("previewStreamSize should not be null at this point.");
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @NonNull
    @EngineThread
    public Task<Void> onStopBind() {
        this.mPreviewStreamSize = null;
        this.mCaptureSize = null;
        try {
            if (this.mPreview.getOutputClass() == SurfaceHolder.class) {
                this.z.setPreviewDisplay(null);
            } else if (this.mPreview.getOutputClass() == SurfaceTexture.class) {
                this.z.setPreviewTexture(null);
            } else {
                throw new RuntimeException("Unknown CameraPreview output class.");
            }
        } catch (IOException e2) {
            CameraEngine.LOG.e("onStopBind", "Could not release surface", e2);
        }
        return Tasks.forResult(null);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @NonNull
    @EngineThread
    public Task<Void> onStopEngine() {
        CameraLogger cameraLogger = CameraEngine.LOG;
        cameraLogger.i("onStopEngine:", "About to clean up.");
        getOrchestrator().remove("focus reset");
        getOrchestrator().remove("focus end");
        if (this.z != null) {
            try {
                cameraLogger.i("onStopEngine:", "Clean up.", "Releasing camera.");
                this.z.release();
                cameraLogger.i("onStopEngine:", "Clean up.", "Released camera.");
            } catch (Exception e2) {
                CameraEngine.LOG.w("onStopEngine:", "Clean up.", "Exception while releasing camera.", e2);
            }
            this.z = null;
            this.mCameraOptions = null;
        }
        this.mVideoRecorder = null;
        this.mCameraOptions = null;
        this.z = null;
        CameraEngine.LOG.w("onStopEngine:", "Clean up.", "Returning.");
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
        getFrameManager().release();
        cameraLogger.i("onStopPreview:", "Releasing preview buffers.");
        this.z.setPreviewCallbackWithBuffer(null);
        try {
            cameraLogger.i("onStopPreview:", "Stopping preview.");
            this.z.stopPreview();
            cameraLogger.i("onStopPreview:", "Stopped preview.");
        } catch (Exception e2) {
            CameraEngine.LOG.e("stopPreview", "Could not stop preview", e2);
        }
        return Tasks.forResult(null);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @EngineThread
    public void onTakePicture(@NonNull PictureResult.Stub stub, boolean z2) {
        CameraLogger cameraLogger = CameraEngine.LOG;
        cameraLogger.i("onTakePicture:", "executing.");
        Angles angles = getAngles();
        Reference reference = Reference.SENSOR;
        Reference reference2 = Reference.OUTPUT;
        stub.rotation = angles.offset(reference, reference2, Axis.RELATIVE_TO_SENSOR);
        stub.size = getPictureSize(reference2);
        Full1PictureRecorder full1PictureRecorder = new Full1PictureRecorder(stub, this, this.z);
        this.mPictureRecorder = full1PictureRecorder;
        full1PictureRecorder.take();
        cameraLogger.i("onTakePicture:", "executed.");
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @EngineThread
    public void onTakePictureSnapshot(@NonNull PictureResult.Stub stub, @NonNull AspectRatio aspectRatio, boolean z2) {
        CameraLogger cameraLogger = CameraEngine.LOG;
        cameraLogger.i("onTakePictureSnapshot:", "executing.");
        Reference reference = Reference.OUTPUT;
        stub.size = getUncroppedSnapshotSize(reference);
        if (this.mPreview instanceof RendererCameraPreview) {
            stub.rotation = getAngles().offset(Reference.VIEW, reference, Axis.ABSOLUTE);
            this.mPictureRecorder = new SnapshotGlPictureRecorder(stub, this, (RendererCameraPreview) this.mPreview, aspectRatio, getOverlay());
        } else {
            stub.rotation = getAngles().offset(Reference.SENSOR, reference, Axis.RELATIVE_TO_SENSOR);
            this.mPictureRecorder = new Snapshot1PictureRecorder(stub, this, this.z, aspectRatio);
        }
        this.mPictureRecorder.take();
        cameraLogger.i("onTakePictureSnapshot:", "executed.");
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @EngineThread
    public void onTakeVideo(@NonNull VideoResult.Stub stub) {
        Angles angles = getAngles();
        Reference reference = Reference.SENSOR;
        Reference reference2 = Reference.OUTPUT;
        stub.rotation = angles.offset(reference, reference2, Axis.RELATIVE_TO_SENSOR);
        stub.size = getAngles().flip(reference, reference2) ? this.mCaptureSize.flip() : this.mCaptureSize;
        try {
            this.z.unlock();
            Full1VideoRecorder full1VideoRecorder = new Full1VideoRecorder(this, this.z, this.A);
            this.mVideoRecorder = full1VideoRecorder;
            full1VideoRecorder.start(stub);
        } catch (Exception e2) {
            onVideoResult(null, e2);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @EngineThread
    @SuppressLint({"NewApi"})
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
    public void onVideoResult(@Nullable VideoResult.Stub stub, @Nullable Exception exc) {
        super.onVideoResult(stub, exc);
        if (stub == null) {
            this.z.lock();
        }
    }

    public final boolean p(@NonNull Camera.Parameters parameters, float f2) {
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        if (!getPreviewFrameRateExact() || this.mPreviewFrameRate == 0.0f) {
            Collections.sort(supportedPreviewFpsRange, new a2.m.a.b.a(this));
        } else {
            Collections.sort(supportedPreviewFpsRange, new a2.m.a.b.b(this));
        }
        float f3 = this.mPreviewFrameRate;
        if (f3 == 0.0f) {
            for (int[] iArr : supportedPreviewFpsRange) {
                float f4 = ((float) iArr[0]) / 1000.0f;
                float f5 = ((float) iArr[1]) / 1000.0f;
                if ((f4 <= 30.0f && 30.0f <= f5) || (f4 <= 24.0f && 24.0f <= f5)) {
                    parameters.setPreviewFpsRange(iArr[0], iArr[1]);
                    return true;
                }
            }
        } else {
            float min = Math.min(f3, this.mCameraOptions.getPreviewFrameRateMaxValue());
            this.mPreviewFrameRate = min;
            this.mPreviewFrameRate = Math.max(min, this.mCameraOptions.getPreviewFrameRateMinValue());
            for (int[] iArr2 : supportedPreviewFpsRange) {
                float f6 = ((float) iArr2[1]) / 1000.0f;
                float round = (float) Math.round(this.mPreviewFrameRate);
                if (((float) iArr2[0]) / 1000.0f <= round && round <= f6) {
                    parameters.setPreviewFpsRange(iArr2[0], iArr2[1]);
                    return true;
                }
            }
        }
        this.mPreviewFrameRate = f2;
        return false;
    }

    public final boolean q(@NonNull Camera.Parameters parameters, @NonNull WhiteBalance whiteBalance) {
        if (this.mCameraOptions.supports(this.mWhiteBalance)) {
            parameters.setWhiteBalance(this.y.mapWhiteBalance(this.mWhiteBalance));
            parameters.remove("auto-whitebalance-lock");
            return true;
        }
        this.mWhiteBalance = whiteBalance;
        return false;
    }

    public final boolean r(@NonNull Camera.Parameters parameters, float f2) {
        if (this.mCameraOptions.isZoomSupported()) {
            parameters.setZoom((int) (this.mZoomValue * ((float) parameters.getMaxZoom())));
            this.z.setParameters(parameters);
            return true;
        }
        this.mZoomValue = f2;
        return false;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setExposureCorrection(float f2, @NonNull float[] fArr, @Nullable PointF[] pointFArr, boolean z2) {
        float f3 = this.mExposureCorrectionValue;
        this.mExposureCorrectionValue = f2;
        getOrchestrator().trim("exposure correction", 20);
        getOrchestrator().scheduleStateful("exposure correction", CameraState.ENGINE, new g(f3, z2, fArr, pointFArr));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setFlash(@NonNull Flash flash) {
        Flash flash2 = this.mFlash;
        this.mFlash = flash;
        CameraStateOrchestrator orchestrator = getOrchestrator();
        orchestrator.scheduleStateful("flash (" + flash + ")", CameraState.ENGINE, new b(flash2));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setFrameProcessingFormat(int i2) {
        this.mFrameProcessingFormat = 17;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setHasFrameProcessors(boolean z2) {
        this.mHasFrameProcessors = z2;
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
        if (pictureFormat == PictureFormat.JPEG) {
            this.mPictureFormat = pictureFormat;
            return;
        }
        throw new UnsupportedOperationException("Unsupported picture format: " + pictureFormat);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setPlaySounds(boolean z2) {
        boolean z3 = this.mPlaySounds;
        this.mPlaySounds = z2;
        CameraStateOrchestrator orchestrator = getOrchestrator();
        orchestrator.scheduleStateful("play sounds (" + z2 + ")", CameraState.ENGINE, new h(z3));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setPreviewFrameRate(float f2) {
        this.mPreviewFrameRate = f2;
        CameraStateOrchestrator orchestrator = getOrchestrator();
        orchestrator.scheduleStateful("preview fps (" + f2 + ")", CameraState.ENGINE, new i(f2));
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
        getOrchestrator().scheduleStateful("zoom", CameraState.ENGINE, new f(f3, z2, pointFArr));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void startAutoFocus(@Nullable Gesture gesture, @NonNull MeteringRegions meteringRegions, @NonNull PointF pointF) {
        getOrchestrator().scheduleStateful("auto focus", CameraState.BIND, new a(meteringRegions, gesture, pointF));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine, com.otaliastudios.cameraview.engine.CameraEngine
    @NonNull
    public ByteBufferFrameManager getFrameManager() {
        return (ByteBufferFrameManager) super.getFrameManager();
    }
}
