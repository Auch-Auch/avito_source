package com.otaliastudios.cameraview.filters;

import android.opengl.GLES20;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.filter.BaseFilter;
import com.otaliastudios.cameraview.filter.TwoParameterFilter;
import com.otaliastudios.opengl.core.Egloo;
public class VignetteFilter extends BaseFilter implements TwoParameterFilter {
    public float e = 0.85f;
    public float f = 0.5f;
    public int g = 1;
    public int h = 1;
    public int i = -1;
    public int j = -1;
    public int k = -1;
    public int l = -1;

    @Override // com.otaliastudios.cameraview.filter.Filter
    @NonNull
    public String getFragmentShader() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform float range;\nuniform float inv_max_dist;\nuniform float shade;\nuniform vec2 scale;\nvarying vec2 vTextureCoord;\nvoid main() {\n  const float slope = 20.0;\n  vec2 coord = vTextureCoord - vec2(0.5, 0.5);\n  float dist = length(coord * scale);\n  float lumen = shade / (1.0 + exp((dist * inv_max_dist - range) * slope)) + (1.0 - shade);\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = vec4(color.rgb * lumen, color.a);\n}\n";
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public float getParameter1() {
        return getVignetteScale();
    }

    @Override // com.otaliastudios.cameraview.filter.TwoParameterFilter
    public float getParameter2() {
        return getVignetteShade();
    }

    public float getVignetteScale() {
        return this.e;
    }

    public float getVignetteShade() {
        return this.f;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void onCreate(int i2) {
        super.onCreate(i2);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i2, "range");
        this.i = glGetUniformLocation;
        Egloo.checkGlProgramLocation(glGetUniformLocation, "range");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(i2, "inv_max_dist");
        this.j = glGetUniformLocation2;
        Egloo.checkGlProgramLocation(glGetUniformLocation2, "inv_max_dist");
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(i2, "shade");
        this.k = glGetUniformLocation3;
        Egloo.checkGlProgramLocation(glGetUniformLocation3, "shade");
        int glGetUniformLocation4 = GLES20.glGetUniformLocation(i2, "scale");
        this.l = glGetUniformLocation4;
        Egloo.checkGlProgramLocation(glGetUniformLocation4, "scale");
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void onDestroy() {
        super.onDestroy();
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.l = -1;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter
    public void onPreDraw(long j2, @NonNull float[] fArr) {
        super.onPreDraw(j2, fArr);
        float[] fArr2 = new float[2];
        int i2 = this.g;
        int i3 = this.h;
        if (i2 > i3) {
            fArr2[0] = 1.0f;
            fArr2[1] = ((float) i3) / ((float) i2);
        } else {
            fArr2[0] = ((float) i2) / ((float) i3);
            fArr2[1] = 1.0f;
        }
        GLES20.glUniform2fv(this.l, 1, fArr2, 0);
        Egloo.checkGlError("glUniform2fv");
        GLES20.glUniform1f(this.j, 1.0f / (((float) Math.sqrt((double) ((fArr2[1] * fArr2[1]) + (fArr2[0] * fArr2[0])))) * 0.5f));
        Egloo.checkGlError("glUniform1f");
        GLES20.glUniform1f(this.k, this.f);
        Egloo.checkGlError("glUniform1f");
        GLES20.glUniform1f(this.i, 1.3f - (((float) Math.sqrt((double) this.e)) * 0.7f));
        Egloo.checkGlError("glUniform1f");
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public void setParameter1(float f2) {
        setVignetteScale(f2);
    }

    @Override // com.otaliastudios.cameraview.filter.TwoParameterFilter
    public void setParameter2(float f2) {
        setVignetteShade(f2);
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void setSize(int i2, int i3) {
        super.setSize(i2, i3);
        this.g = i2;
        this.h = i3;
    }

    public void setVignetteScale(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        this.e = f2;
    }

    public void setVignetteShade(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        this.f = f2;
    }
}
