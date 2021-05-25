package com.otaliastudios.cameraview.internal;

import android.opengl.GLES20;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.filter.Filter;
import com.otaliastudios.cameraview.filter.NoFilter;
import com.otaliastudios.opengl.core.Egloo;
import com.otaliastudios.opengl.program.GlProgram;
import com.otaliastudios.opengl.texture.GlTexture;
public class GlTextureDrawer {
    public final GlTexture a;
    public float[] b;
    @NonNull
    public Filter c;
    public Filter d;
    public int e;

    static {
        CameraLogger.create(GlTextureDrawer.class.getSimpleName());
    }

    public GlTextureDrawer() {
        this(new GlTexture(33984, 36197));
    }

    public void draw(long j) {
        if (this.d != null) {
            release();
            this.c = this.d;
            this.d = null;
        }
        if (this.e == -1) {
            int create = GlProgram.create(this.c.getVertexShader(), this.c.getFragmentShader());
            this.e = create;
            this.c.onCreate(create);
            Egloo.checkGlError("program creation");
        }
        GLES20.glUseProgram(this.e);
        Egloo.checkGlError("glUseProgram(handle)");
        this.a.bind();
        this.c.draw(j, this.b);
        this.a.unbind();
        GLES20.glUseProgram(0);
        Egloo.checkGlError("glUseProgram(0)");
    }

    @NonNull
    public GlTexture getTexture() {
        return this.a;
    }

    @NonNull
    public float[] getTextureTransform() {
        return this.b;
    }

    public void release() {
        if (this.e != -1) {
            this.c.onDestroy();
            GLES20.glDeleteProgram(this.e);
            this.e = -1;
        }
    }

    public void setFilter(@NonNull Filter filter) {
        this.d = filter;
    }

    public void setTextureTransform(@NonNull float[] fArr) {
        this.b = fArr;
    }

    public GlTextureDrawer(int i) {
        this(new GlTexture(33984, 36197, Integer.valueOf(i)));
    }

    public GlTextureDrawer(@NonNull GlTexture glTexture) {
        this.b = (float[]) Egloo.IDENTITY_MATRIX.clone();
        this.c = new NoFilter();
        this.d = null;
        this.e = -1;
        this.a = glTexture;
    }
}
