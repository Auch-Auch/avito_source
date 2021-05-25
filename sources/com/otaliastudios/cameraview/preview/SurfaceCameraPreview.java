package com.otaliastudios.cameraview.preview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.R;
public class SurfaceCameraPreview extends CameraPreview<SurfaceView, SurfaceHolder> {
    public static final CameraLogger e = CameraLogger.create(SurfaceCameraPreview.class.getSimpleName());
    public boolean c;
    public View d;

    public class a implements SurfaceHolder.Callback {
        public a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            SurfaceCameraPreview.e.i("callback:", "surfaceChanged", "w:", Integer.valueOf(i2), "h:", Integer.valueOf(i3), "dispatched:", Boolean.valueOf(SurfaceCameraPreview.this.c));
            SurfaceCameraPreview surfaceCameraPreview = SurfaceCameraPreview.this;
            if (!surfaceCameraPreview.c) {
                surfaceCameraPreview.dispatchOnSurfaceAvailable(i2, i3);
                SurfaceCameraPreview.this.c = true;
                return;
            }
            surfaceCameraPreview.dispatchOnSurfaceSizeChanged(i2, i3);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            SurfaceCameraPreview.e.i("callback:", "surfaceDestroyed");
            SurfaceCameraPreview.this.dispatchOnSurfaceDestroyed();
            SurfaceCameraPreview.this.c = false;
        }
    }

    public SurfaceCameraPreview(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    @NonNull
    public Class<SurfaceHolder> getOutputClass() {
        return SurfaceHolder.class;
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    @NonNull
    public View getRootView() {
        return this.d;
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    @NonNull
    public SurfaceHolder getOutput() {
        return ((SurfaceView) getView()).getHolder();
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview
    @NonNull
    public SurfaceView onCreateView(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.cameraview_surface_view, viewGroup, false);
        viewGroup.addView(inflate, 0);
        SurfaceView surfaceView = (SurfaceView) inflate.findViewById(R.id.surface_view);
        SurfaceHolder holder = surfaceView.getHolder();
        holder.setType(3);
        holder.addCallback(new a());
        this.d = inflate;
        return surfaceView;
    }
}
