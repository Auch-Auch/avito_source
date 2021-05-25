package com.otaliastudios.cameraview.preview;

import android.graphics.SurfaceTexture;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.filter.Filter;
public interface RendererFrameCallback {
    @RendererThread
    void onRendererFilterChanged(@NonNull Filter filter);

    @RendererThread
    void onRendererFrame(@NonNull SurfaceTexture surfaceTexture, int i, float f, float f2);

    @RendererThread
    void onRendererTextureCreated(int i);
}
