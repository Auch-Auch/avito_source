package com.otaliastudios.cameraview.preview;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.size.Size;
public abstract class CameraPreview<T extends View, Output> {
    public static final CameraLogger LOG = CameraLogger.create(CameraPreview.class.getSimpleName());
    public SurfaceCallback a;
    public T b;
    public boolean mCropping;
    public int mDrawRotation;
    public int mInputStreamHeight;
    public int mInputStreamWidth;
    public int mOutputSurfaceHeight;
    public int mOutputSurfaceWidth;

    public interface CropCallback {
        void onCrop();
    }

    public interface SurfaceCallback {
        void onSurfaceAvailable();

        void onSurfaceChanged();

        void onSurfaceDestroyed();
    }

    public class a implements Runnable {
        public final /* synthetic */ TaskCompletionSource a;

        public a(TaskCompletionSource taskCompletionSource) {
            this.a = taskCompletionSource;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraPreview.this.onDestroyView();
            this.a.setResult(null);
        }
    }

    public CameraPreview(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        this.b = onCreateView(context, viewGroup);
    }

    public void crop(@Nullable CropCallback cropCallback) {
        if (cropCallback != null) {
            cropCallback.onCrop();
        }
    }

    public final void dispatchOnSurfaceAvailable(int i, int i2) {
        LOG.i("dispatchOnSurfaceAvailable:", "w=", Integer.valueOf(i), "h=", Integer.valueOf(i2));
        this.mOutputSurfaceWidth = i;
        this.mOutputSurfaceHeight = i2;
        if (i > 0 && i2 > 0) {
            crop(null);
        }
        SurfaceCallback surfaceCallback = this.a;
        if (surfaceCallback != null) {
            surfaceCallback.onSurfaceAvailable();
        }
    }

    public final void dispatchOnSurfaceDestroyed() {
        this.mOutputSurfaceWidth = 0;
        this.mOutputSurfaceHeight = 0;
        SurfaceCallback surfaceCallback = this.a;
        if (surfaceCallback != null) {
            surfaceCallback.onSurfaceDestroyed();
        }
    }

    public final void dispatchOnSurfaceSizeChanged(int i, int i2) {
        LOG.i("dispatchOnSurfaceSizeChanged:", "w=", Integer.valueOf(i), "h=", Integer.valueOf(i2));
        if (i != this.mOutputSurfaceWidth || i2 != this.mOutputSurfaceHeight) {
            this.mOutputSurfaceWidth = i;
            this.mOutputSurfaceHeight = i2;
            if (i > 0 && i2 > 0) {
                crop(null);
            }
            SurfaceCallback surfaceCallback = this.a;
            if (surfaceCallback != null) {
                surfaceCallback.onSurfaceChanged();
            }
        }
    }

    @NonNull
    public abstract Output getOutput();

    @NonNull
    public abstract Class<Output> getOutputClass();

    @NonNull
    public abstract View getRootView();

    @NonNull
    public final Size getSurfaceSize() {
        return new Size(this.mOutputSurfaceWidth, this.mOutputSurfaceHeight);
    }

    @NonNull
    public final T getView() {
        return this.b;
    }

    public final boolean hasSurface() {
        return this.mOutputSurfaceWidth > 0 && this.mOutputSurfaceHeight > 0;
    }

    public boolean isCropping() {
        return this.mCropping;
    }

    @NonNull
    public abstract T onCreateView(@NonNull Context context, @NonNull ViewGroup viewGroup);

    @CallSuper
    public void onDestroy() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            onDestroyView();
            return;
        }
        Handler handler = new Handler(Looper.getMainLooper());
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        handler.post(new a(taskCompletionSource));
        try {
            Tasks.await(taskCompletionSource.getTask());
        } catch (Exception unused) {
        }
    }

    @UiThread
    public void onDestroyView() {
        View rootView = getRootView();
        ViewParent parent = rootView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(rootView);
        }
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void setDrawRotation(int i) {
        this.mDrawRotation = i;
    }

    public void setStreamSize(int i, int i2) {
        LOG.i("setStreamSize:", "desiredW=", Integer.valueOf(i), "desiredH=", Integer.valueOf(i2));
        this.mInputStreamWidth = i;
        this.mInputStreamHeight = i2;
        if (i > 0 && i2 > 0) {
            crop(null);
        }
    }

    public void setSurfaceCallback(@Nullable SurfaceCallback surfaceCallback) {
        SurfaceCallback surfaceCallback2;
        SurfaceCallback surfaceCallback3;
        if (hasSurface() && (surfaceCallback3 = this.a) != null) {
            surfaceCallback3.onSurfaceDestroyed();
        }
        this.a = surfaceCallback;
        if (hasSurface() && (surfaceCallback2 = this.a) != null) {
            surfaceCallback2.onSurfaceAvailable();
        }
    }

    public boolean supportsCropping() {
        return false;
    }
}
