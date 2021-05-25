package com.otaliastudios.cameraview.video.encoding;

import android.opengl.EGLContext;
import com.otaliastudios.cameraview.overlay.Overlay;
import com.otaliastudios.cameraview.overlay.OverlayDrawer;
public class TextureConfig extends VideoConfig {
    public EGLContext eglContext;
    public OverlayDrawer overlayDrawer;
    public int overlayRotation;
    public Overlay.Target overlayTarget;
    public float scaleX;
    public float scaleY;
    public int textureId;
}
