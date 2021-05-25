package com.google.android.exoplayer2.video;

import a2.j.b.b.f1.i;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
public class VideoDecoderGLSurfaceView extends GLSurfaceView {
    public final i a;

    public VideoDecoderGLSurfaceView(Context context) {
        this(context, null);
    }

    public VideoDecoderOutputBufferRenderer getVideoDecoderOutputBufferRenderer() {
        return this.a;
    }

    public VideoDecoderGLSurfaceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        i iVar = new i(this);
        this.a = iVar;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(iVar);
        setRenderMode(0);
    }
}
