package com.otaliastudios.cameraview.engine;

import a2.m.a.b.i;
import android.content.Context;
import android.graphics.PointF;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.CameraOptions;
import com.otaliastudios.cameraview.PictureResult;
import com.otaliastudios.cameraview.VideoResult;
import com.otaliastudios.cameraview.controls.Audio;
import com.otaliastudios.cameraview.controls.AudioCodec;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.Mode;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.controls.VideoCodec;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import com.otaliastudios.cameraview.engine.offset.Angles;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator;
import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator;
import com.otaliastudios.cameraview.frame.Frame;
import com.otaliastudios.cameraview.frame.FrameManager;
import com.otaliastudios.cameraview.gesture.Gesture;
import com.otaliastudios.cameraview.internal.WorkerHandler;
import com.otaliastudios.cameraview.metering.MeteringRegions;
import com.otaliastudios.cameraview.overlay.Overlay;
import com.otaliastudios.cameraview.picture.PictureRecorder;
import com.otaliastudios.cameraview.preview.CameraPreview;
import com.otaliastudios.cameraview.size.Size;
import com.otaliastudios.cameraview.size.SizeSelector;
import com.otaliastudios.cameraview.video.VideoRecorder;
import java.io.File;
import java.io.FileDescriptor;
import java.lang.Thread;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
public abstract class CameraEngine implements CameraPreview.SurfaceCallback, PictureRecorder.PictureResultListener, VideoRecorder.VideoResultListener {
    public static final CameraLogger LOG = CameraLogger.create(CameraEngine.class.getSimpleName());
    public static final String TAG = "CameraEngine";
    public WorkerHandler a;
    @VisibleForTesting
    public Handler b;
    public final Callback c;
    public final CameraStateOrchestrator d = new CameraStateOrchestrator(new c());

    public interface Callback {
        void dispatchError(CameraException cameraException);

        void dispatchFrame(@NonNull Frame frame);

        void dispatchOnCameraClosed();

        void dispatchOnCameraOpened(@NonNull CameraOptions cameraOptions);

        void dispatchOnExposureCorrectionChanged(float f, @NonNull float[] fArr, @Nullable PointF[] pointFArr);

        void dispatchOnFocusEnd(@Nullable Gesture gesture, boolean z, @NonNull PointF pointF);

        void dispatchOnFocusStart(@Nullable Gesture gesture, @NonNull PointF pointF);

        void dispatchOnPictureShutter(boolean z);

        void dispatchOnPictureTaken(@NonNull PictureResult.Stub stub);

        void dispatchOnVideoRecordingEnd();

        void dispatchOnVideoRecordingStart();

        void dispatchOnVideoTaken(@NonNull VideoResult.Stub stub);

        void dispatchOnZoomChanged(float f, @Nullable PointF[] pointFArr);

        @Override // com.otaliastudios.cameraview.gesture.GestureFinder.Controller
        @NonNull
        Context getContext();

        void onCameraPreviewStreamSizeChanged();
    }

    public class a implements Callable<Task<Void>> {
        public a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Task<Void> call() throws Exception {
            return CameraEngine.this.onStartPreview();
        }
    }

    public class b implements Callable<Task<Void>> {
        public b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Task<Void> call() throws Exception {
            return CameraEngine.this.onStopPreview();
        }
    }

    public class c implements CameraOrchestrator.Callback {
        public c() {
        }

        @Override // com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.Callback
        @NonNull
        public WorkerHandler getJobWorker(@NonNull String str) {
            return CameraEngine.this.a;
        }

        @Override // com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.Callback
        public void handleJobException(@NonNull String str, @NonNull Exception exc) {
            CameraEngine.a(CameraEngine.this, exc, false);
        }
    }

    public class d implements OnCompleteListener<Void> {
        public final /* synthetic */ CountDownLatch a;

        public d(CameraEngine cameraEngine, CountDownLatch countDownLatch) {
            this.a = countDownLatch;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(@NonNull Task<Void> task) {
            this.a.countDown();
        }
    }

    public class e implements Callable<Task<Void>> {
        public e() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Task<Void> call() throws Exception {
            if (CameraEngine.this.getPreview() == null || !CameraEngine.this.getPreview().hasSurface()) {
                return Tasks.forCanceled();
            }
            return CameraEngine.this.onStartBind();
        }
    }

    public class f implements Callable<Task<Void>> {
        public f() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Task<Void> call() throws Exception {
            return CameraEngine.this.onStopBind();
        }
    }

    public class g implements Thread.UncaughtExceptionHandler {
        public g(c cVar) {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th) {
            CameraEngine.a(CameraEngine.this, th, true);
        }
    }

    public static class h implements Thread.UncaughtExceptionHandler {
        public h(c cVar) {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th) {
            CameraEngine.LOG.w("EXCEPTION:", "In the NoOpExceptionHandler, probably while destroying.", "Thread:", thread, "Error:", th);
        }
    }

    public CameraEngine(@NonNull Callback callback) {
        this.c = callback;
        this.b = new Handler(Looper.getMainLooper());
        c(false);
    }

    public static void a(CameraEngine cameraEngine, Throwable th, boolean z) {
        Objects.requireNonNull(cameraEngine);
        if (z) {
            LOG.e("EXCEPTION:", "Handler thread is gone. Replacing.");
            cameraEngine.c(false);
        }
        LOG.e("EXCEPTION:", "Scheduling on the crash handler...");
        cameraEngine.b.post(new a2.m.a.b.e(cameraEngine, th));
    }

    public final void b(boolean z, int i) {
        CameraLogger cameraLogger = LOG;
        cameraLogger.i("DESTROY:", "state:", getState(), "thread:", Thread.currentThread(), "depth:", Integer.valueOf(i), "unrecoverably:", Boolean.valueOf(z));
        if (z) {
            this.a.getThread().setUncaughtExceptionHandler(new h(null));
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        stop(true).addOnCompleteListener(this.a.getExecutor(), new d(this, countDownLatch));
        try {
            if (!countDownLatch.await(6, TimeUnit.SECONDS)) {
                cameraLogger.e("DESTROY: Could not destroy synchronously after 6 seconds.", "Current thread:", Thread.currentThread(), "Handler thread:", this.a.getThread());
                int i2 = i + 1;
                if (i2 < 2) {
                    c(true);
                    cameraLogger.e("DESTROY: Trying again on thread:", this.a.getThread());
                    b(z, i2);
                    return;
                }
                cameraLogger.w("DESTROY: Giving up because DESTROY_RETRIES was reached.");
            }
        } catch (InterruptedException unused) {
        }
    }

    public final void c(boolean z) {
        WorkerHandler workerHandler = this.a;
        if (workerHandler != null) {
            workerHandler.destroy();
        }
        WorkerHandler workerHandler2 = WorkerHandler.get("CameraViewEngine");
        this.a = workerHandler2;
        workerHandler2.getThread().setUncaughtExceptionHandler(new g(null));
        if (z) {
            this.d.reset();
        }
    }

    @EngineThread
    public abstract boolean collectCameraInfo(@NonNull Facing facing);

    @NonNull
    @EngineThread
    public final Task<Void> d() {
        return this.d.scheduleStateChange(CameraState.ENGINE, CameraState.BIND, true, new e());
    }

    public void destroy(boolean z) {
        b(z, 0);
    }

    @NonNull
    @EngineThread
    public final Task<Void> e() {
        return this.d.scheduleStateChange(CameraState.BIND, CameraState.PREVIEW, true, new a());
    }

    @NonNull
    @EngineThread
    public final Task<Void> f(boolean z) {
        return this.d.scheduleStateChange(CameraState.BIND, CameraState.ENGINE, !z, new f());
    }

    @NonNull
    @EngineThread
    public final Task<Void> g(boolean z) {
        return this.d.scheduleStateChange(CameraState.PREVIEW, CameraState.BIND, !z, new b());
    }

    @NonNull
    public abstract Angles getAngles();

    @NonNull
    public abstract Audio getAudio();

    public abstract int getAudioBitRate();

    @NonNull
    public abstract AudioCodec getAudioCodec();

    public abstract long getAutoFocusResetDelay();

    @NonNull
    public final Callback getCallback() {
        return this.c;
    }

    @Nullable
    public abstract CameraOptions getCameraOptions();

    public abstract float getExposureCorrectionValue();

    @NonNull
    public abstract Facing getFacing();

    @NonNull
    public abstract Flash getFlash();

    @NonNull
    public abstract FrameManager getFrameManager();

    public abstract int getFrameProcessingFormat();

    public abstract int getFrameProcessingMaxHeight();

    public abstract int getFrameProcessingMaxWidth();

    public abstract int getFrameProcessingPoolSize();

    @NonNull
    public abstract Hdr getHdr();

    @Nullable
    public abstract Location getLocation();

    @NonNull
    public abstract Mode getMode();

    @NonNull
    public final CameraStateOrchestrator getOrchestrator() {
        return this.d;
    }

    @Nullable
    public abstract Overlay getOverlay();

    @NonNull
    public abstract PictureFormat getPictureFormat();

    public abstract boolean getPictureMetering();

    @Nullable
    public abstract Size getPictureSize(@NonNull Reference reference);

    @NonNull
    public abstract SizeSelector getPictureSizeSelector();

    public abstract boolean getPictureSnapshotMetering();

    @Nullable
    public abstract CameraPreview getPreview();

    public abstract float getPreviewFrameRate();

    public abstract boolean getPreviewFrameRateExact();

    @Nullable
    public abstract Size getPreviewStreamSize(@NonNull Reference reference);

    @Nullable
    public abstract SizeSelector getPreviewStreamSizeSelector();

    public abstract int getSnapshotMaxHeight();

    public abstract int getSnapshotMaxWidth();

    @NonNull
    public final CameraState getState() {
        return this.d.getCurrentState();
    }

    @NonNull
    public final CameraState getTargetState() {
        return this.d.getTargetState();
    }

    @Nullable
    public abstract Size getUncroppedSnapshotSize(@NonNull Reference reference);

    public abstract int getVideoBitRate();

    @NonNull
    public abstract VideoCodec getVideoCodec();

    public abstract int getVideoMaxDuration();

    public abstract long getVideoMaxSize();

    @Nullable
    public abstract Size getVideoSize(@NonNull Reference reference);

    @NonNull
    public abstract SizeSelector getVideoSizeSelector();

    @NonNull
    public abstract WhiteBalance getWhiteBalance();

    public abstract float getZoomValue();

    public abstract boolean hasFrameProcessors();

    public final boolean isChangingState() {
        return this.d.hasPendingStateChange();
    }

    public abstract boolean isTakingPicture();

    public abstract boolean isTakingVideo();

    @NonNull
    @EngineThread
    public abstract Task<Void> onStartBind();

    @NonNull
    @EngineThread
    public abstract Task<CameraOptions> onStartEngine();

    @NonNull
    @EngineThread
    public abstract Task<Void> onStartPreview();

    @NonNull
    @EngineThread
    public abstract Task<Void> onStopBind();

    @NonNull
    @EngineThread
    public abstract Task<Void> onStopEngine();

    @NonNull
    @EngineThread
    public abstract Task<Void> onStopPreview();

    @Override // com.otaliastudios.cameraview.preview.CameraPreview.SurfaceCallback
    public final void onSurfaceAvailable() {
        LOG.i("onSurfaceAvailable:", "Size is", getPreview().getSurfaceSize());
        d();
        e();
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview.SurfaceCallback
    public final void onSurfaceDestroyed() {
        LOG.i("onSurfaceDestroyed");
        g(false);
        f(false);
    }

    public void restart() {
        LOG.i("RESTART:", "scheduled. State:", getState());
        stop(false);
        start();
    }

    @NonNull
    public Task<Void> restartBind() {
        LOG.i("RESTART BIND:", "scheduled. State:", getState());
        g(false);
        f(false);
        d();
        return e();
    }

    @NonNull
    public Task<Void> restartPreview() {
        LOG.i("RESTART PREVIEW:", "scheduled. State:", getState());
        g(false);
        return e();
    }

    public abstract void setAudio(@NonNull Audio audio);

    public abstract void setAudioBitRate(int i);

    public abstract void setAudioCodec(@NonNull AudioCodec audioCodec);

    public abstract void setAutoFocusResetDelay(long j);

    public abstract void setExposureCorrection(float f2, @NonNull float[] fArr, @Nullable PointF[] pointFArr, boolean z);

    public abstract void setFacing(@NonNull Facing facing);

    public abstract void setFlash(@NonNull Flash flash);

    public abstract void setFrameProcessingFormat(int i);

    public abstract void setFrameProcessingMaxHeight(int i);

    public abstract void setFrameProcessingMaxWidth(int i);

    public abstract void setFrameProcessingPoolSize(int i);

    public abstract void setHasFrameProcessors(boolean z);

    public abstract void setHdr(@NonNull Hdr hdr);

    public abstract void setLocation(@Nullable Location location);

    public abstract void setMode(@NonNull Mode mode);

    public abstract void setOverlay(@Nullable Overlay overlay);

    public abstract void setPictureFormat(@NonNull PictureFormat pictureFormat);

    public abstract void setPictureMetering(boolean z);

    public abstract void setPictureSizeSelector(@NonNull SizeSelector sizeSelector);

    public abstract void setPictureSnapshotMetering(boolean z);

    public abstract void setPlaySounds(boolean z);

    public abstract void setPreview(@NonNull CameraPreview cameraPreview);

    public abstract void setPreviewFrameRate(float f2);

    public abstract void setPreviewFrameRateExact(boolean z);

    public abstract void setPreviewStreamSizeSelector(@Nullable SizeSelector sizeSelector);

    public abstract void setSnapshotMaxHeight(int i);

    public abstract void setSnapshotMaxWidth(int i);

    public abstract void setVideoBitRate(int i);

    public abstract void setVideoCodec(@NonNull VideoCodec videoCodec);

    public abstract void setVideoMaxDuration(int i);

    public abstract void setVideoMaxSize(long j);

    public abstract void setVideoSizeSelector(@NonNull SizeSelector sizeSelector);

    public abstract void setWhiteBalance(@NonNull WhiteBalance whiteBalance);

    public abstract void setZoom(float f2, @Nullable PointF[] pointFArr, boolean z);

    @NonNull
    public Task<Void> start() {
        LOG.i("START:", "scheduled. State:", getState());
        Task<Void> onSuccessTask = this.d.scheduleStateChange(CameraState.OFF, CameraState.ENGINE, true, new a2.m.a.b.g(this)).onSuccessTask(new a2.m.a.b.f(this));
        d();
        e();
        return onSuccessTask;
    }

    public abstract void startAutoFocus(@Nullable Gesture gesture, @NonNull MeteringRegions meteringRegions, @NonNull PointF pointF);

    @NonNull
    public Task<Void> stop(boolean z) {
        LOG.i("STOP:", "scheduled. State:", getState());
        g(z);
        f(z);
        return this.d.scheduleStateChange(CameraState.ENGINE, CameraState.OFF, !z, new i(this)).addOnSuccessListener(new a2.m.a.b.h(this));
    }

    public abstract void stopVideo();

    public abstract void takePicture(@NonNull PictureResult.Stub stub);

    public abstract void takePictureSnapshot(@NonNull PictureResult.Stub stub);

    public abstract void takeVideo(@NonNull VideoResult.Stub stub, @Nullable File file, @Nullable FileDescriptor fileDescriptor);

    public abstract void takeVideoSnapshot(@NonNull VideoResult.Stub stub, @NonNull File file);
}
