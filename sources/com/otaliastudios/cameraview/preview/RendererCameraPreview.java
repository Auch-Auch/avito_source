package com.otaliastudios.cameraview.preview;

import androidx.annotation.NonNull;
public interface RendererCameraPreview {
    void addRendererFrameCallback(@NonNull RendererFrameCallback rendererFrameCallback);

    void removeRendererFrameCallback(@NonNull RendererFrameCallback rendererFrameCallback);
}
