package com.otaliastudios.cameraview.filters;

import android.opengl.GLES20;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.filter.BaseFilter;
import com.otaliastudios.cameraview.filter.OneParameterFilter;
import com.otaliastudios.opengl.core.Egloo;
public class BrightnessFilter extends BaseFilter implements OneParameterFilter {
    public float e = 2.0f;
    public int f = -1;

    public float getBrightness() {
        return this.e;
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    @NonNull
    public String getFragmentShader() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform float brightness;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = brightness * color;\n}\n";
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public float getParameter1() {
        return getBrightness() - 1.0f;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void onCreate(int i) {
        super.onCreate(i);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i, "brightness");
        this.f = glGetUniformLocation;
        Egloo.checkGlProgramLocation(glGetUniformLocation, "brightness");
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void onDestroy() {
        super.onDestroy();
        this.f = -1;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter
    public void onPreDraw(long j, @NonNull float[] fArr) {
        super.onPreDraw(j, fArr);
        GLES20.glUniform1f(this.f, this.e);
        Egloo.checkGlError("glUniform1f");
    }

    public void setBrightness(float f2) {
        if (f2 < 1.0f) {
            f2 = 1.0f;
        }
        if (f2 > 2.0f) {
            f2 = 2.0f;
        }
        this.e = f2;
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public void setParameter1(float f2) {
        setBrightness(f2 + 1.0f);
    }
}
