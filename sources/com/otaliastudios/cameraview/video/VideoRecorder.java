package com.otaliastudios.cameraview.video;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.VideoResult;
public abstract class VideoRecorder {
    public static final CameraLogger e = CameraLogger.create(VideoRecorder.class.getSimpleName());
    @VisibleForTesting(otherwise = 4)
    public VideoResult.Stub a;
    public final VideoResultListener b;
    public int c;
    public final Object d = new Object();
    public Exception mError;

    public interface VideoResultListener {
        void onVideoRecordingEnd();

        void onVideoRecordingStart();

        void onVideoResult(@Nullable VideoResult.Stub stub, @Nullable Exception exc);
    }

    public VideoRecorder(@Nullable VideoResultListener videoResultListener) {
        this.b = videoResultListener;
        this.c = 0;
    }

    public final void dispatchResult() {
        CameraLogger cameraLogger;
        synchronized (this.d) {
            if (!isRecording()) {
                e.w("dispatchResult:", "Called, but not recording! Aborting.");
                return;
            }
            cameraLogger = e;
            cameraLogger.i("dispatchResult:", "Changed state to STATE_IDLE.");
            this.c = 0;
        }
        onDispatchResult();
        cameraLogger.i("dispatchResult:", "About to dispatch result:", this.a, this.mError);
        VideoResultListener videoResultListener = this.b;
        if (videoResultListener != null) {
            videoResultListener.onVideoResult(this.a, this.mError);
        }
        this.a = null;
        this.mError = null;
    }

    @CallSuper
    public void dispatchVideoRecordingEnd() {
        e.i("dispatchVideoRecordingEnd:", "About to dispatch.");
        VideoResultListener videoResultListener = this.b;
        if (videoResultListener != null) {
            videoResultListener.onVideoRecordingEnd();
        }
    }

    @CallSuper
    public void dispatchVideoRecordingStart() {
        e.i("dispatchVideoRecordingStart:", "About to dispatch.");
        VideoResultListener videoResultListener = this.b;
        if (videoResultListener != null) {
            videoResultListener.onVideoRecordingStart();
        }
    }

    public boolean isRecording() {
        boolean z;
        synchronized (this.d) {
            z = this.c != 0;
        }
        return z;
    }

    public void onDispatchResult() {
    }

    public abstract void onStart();

    public abstract void onStop(boolean z);

    public final void start(@NonNull VideoResult.Stub stub) {
        synchronized (this.d) {
            int i = this.c;
            if (i != 0) {
                e.e("start:", "called twice, or while stopping! Ignoring. state:", Integer.valueOf(i));
                return;
            }
            e.i("start:", "Changed state to STATE_RECORDING");
            this.c = 1;
            this.a = stub;
            onStart();
        }
    }

    public final void stop(boolean z) {
        synchronized (this.d) {
            if (this.c == 0) {
                e.e("stop:", "called twice, or called before start! Ignoring. isCameraShutdown:", Boolean.valueOf(z));
                return;
            }
            e.i("stop:", "Changed state to STATE_STOPPING");
            this.c = 2;
            onStop(z);
        }
    }
}
