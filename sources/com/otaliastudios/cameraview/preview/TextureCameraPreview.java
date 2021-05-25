package com.otaliastudios.cameraview.preview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.R;
import com.otaliastudios.cameraview.preview.CameraPreview;
import com.otaliastudios.cameraview.size.AspectRatio;
import java.util.concurrent.ExecutionException;
public class TextureCameraPreview extends CameraPreview<TextureView, SurfaceTexture> {
    public View c;

    public class a implements TextureView.SurfaceTextureListener {
        public a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            TextureCameraPreview.this.dispatchOnSurfaceAvailable(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            TextureCameraPreview.this.dispatchOnSurfaceDestroyed();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            TextureCameraPreview.this.dispatchOnSurfaceSizeChanged(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ CameraPreview.CropCallback a;

        public b(CameraPreview.CropCallback cropCallback) {
            this.a = cropCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            float f;
            TextureCameraPreview textureCameraPreview = TextureCameraPreview.this;
            if (textureCameraPreview.mInputStreamHeight == 0 || textureCameraPreview.mInputStreamWidth == 0 || (i = textureCameraPreview.mOutputSurfaceHeight) == 0 || (i2 = textureCameraPreview.mOutputSurfaceWidth) == 0) {
                CameraPreview.CropCallback cropCallback = this.a;
                if (cropCallback != null) {
                    cropCallback.onCrop();
                    return;
                }
                return;
            }
            AspectRatio of = AspectRatio.of(i2, i);
            TextureCameraPreview textureCameraPreview2 = TextureCameraPreview.this;
            AspectRatio of2 = AspectRatio.of(textureCameraPreview2.mInputStreamWidth, textureCameraPreview2.mInputStreamHeight);
            float f2 = 1.0f;
            if (of.toFloat() >= of2.toFloat()) {
                f = of.toFloat() / of2.toFloat();
            } else {
                f2 = of2.toFloat() / of.toFloat();
                f = 1.0f;
            }
            ((TextureView) TextureCameraPreview.this.getView()).setScaleX(f2);
            ((TextureView) TextureCameraPreview.this.getView()).setScaleY(f);
            TextureCameraPreview.this.mCropping = f2 > 1.02f || f > 1.02f;
            CameraLogger cameraLogger = CameraPreview.LOG;
            cameraLogger.i("crop:", "applied scaleX=", Float.valueOf(f2));
            cameraLogger.i("crop:", "applied scaleY=", Float.valueOf(f));
            CameraPreview.CropCallback cropCallback2 = this.a;
            if (cropCallback2 != null) {
                cropCallback2.onCrop();
            }
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ TaskCompletionSource b;

        public c(int i, TaskCompletionSource taskCompletionSource) {
            this.a = i;
            this.b = taskCompletionSource;
        }

        @Override // java.lang.Runnable
        public void run() {
            Matrix matrix = new Matrix();
            TextureCameraPreview textureCameraPreview = TextureCameraPreview.this;
            int i = textureCameraPreview.mOutputSurfaceWidth;
            float f = ((float) i) / 2.0f;
            int i2 = textureCameraPreview.mOutputSurfaceHeight;
            float f2 = ((float) i2) / 2.0f;
            if (this.a % 180 != 0) {
                float f3 = ((float) i2) / ((float) i);
                matrix.postScale(f3, 1.0f / f3, f, f2);
            }
            matrix.postRotate((float) this.a, f, f2);
            ((TextureView) TextureCameraPreview.this.getView()).setTransform(matrix);
            this.b.setResult(null);
        }
    }

    public TextureCameraPreview(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    public void crop(@Nullable CameraPreview.CropCallback cropCallback) {
        ((TextureView) getView()).post(new b(cropCallback));
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    @NonNull
    public Class<SurfaceTexture> getOutputClass() {
        return SurfaceTexture.class;
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    @NonNull
    public View getRootView() {
        return this.c;
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    public void setDrawRotation(int i) {
        super.setDrawRotation(i);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        ((TextureView) getView()).post(new c(i, taskCompletionSource));
        try {
            Tasks.await(taskCompletionSource.getTask());
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    public boolean supportsCropping() {
        return true;
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    @NonNull
    public SurfaceTexture getOutput() {
        return ((TextureView) getView()).getSurfaceTexture();
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    @NonNull
    public TextureView onCreateView(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.cameraview_texture_view, viewGroup, false);
        viewGroup.addView(inflate, 0);
        TextureView textureView = (TextureView) inflate.findViewById(R.id.texture_view);
        textureView.setSurfaceTextureListener(new a());
        this.c = inflate;
        return textureView;
    }
}
