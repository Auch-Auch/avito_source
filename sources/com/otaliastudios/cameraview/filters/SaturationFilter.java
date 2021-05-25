package com.otaliastudios.cameraview.filters;

import android.opengl.GLES20;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.filter.BaseFilter;
import com.otaliastudios.cameraview.filter.OneParameterFilter;
import com.otaliastudios.opengl.core.Egloo;
public class SaturationFilter extends BaseFilter implements OneParameterFilter {
    public float e = 1.0f;
    public int f = -1;
    public int g = -1;

    @Override // com.otaliastudios.cameraview.filter.Filter
    @NonNull
    public String getFragmentShader() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform float scale;\nuniform vec3 exponents;\nfloat shift;\nvec3 weights;\nvarying vec2 vTextureCoord;\nvoid main() {\n  weights[0] = 0.25;\n  weights[1] = 0.625;\n  weights[2] = 0.125;\n  shift = 0.003921569;\n  vec4 oldcolor = texture2D(sTexture, vTextureCoord);\n  float kv = dot(oldcolor.rgb, weights) + shift;\n  vec3 new_color = scale * oldcolor.rgb + (1.0 - scale) * kv;\n  gl_FragColor = vec4(new_color, oldcolor.a);\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float de = dot(color.rgb, weights);\n  float inv_de = 1.0 / de;\n  vec3 verynew_color = de * pow(color.rgb * inv_de, exponents);\n  float max_color = max(max(max(verynew_color.r, verynew_color.g), verynew_color.b), 1.0);\n  gl_FragColor = gl_FragColor+vec4(verynew_color / max_color, color.a);\n}\n";
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public float getParameter1() {
        return (getSaturation() + 1.0f) / 2.0f;
    }

    public float getSaturation() {
        return this.e;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void onCreate(int i) {
        super.onCreate(i);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i, "scale");
        this.f = glGetUniformLocation;
        Egloo.checkGlProgramLocation(glGetUniformLocation, "scale");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(i, "exponents");
        this.g = glGetUniformLocation2;
        Egloo.checkGlProgramLocation(glGetUniformLocation2, "exponents");
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void onDestroy() {
        super.onDestroy();
        this.f = -1;
        this.g = -1;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter
    public void onPreDraw(long j, @NonNull float[] fArr) {
        super.onPreDraw(j, fArr);
        float f2 = this.e;
        if (f2 > 0.0f) {
            GLES20.glUniform1f(this.f, 0.0f);
            Egloo.checkGlError("glUniform1f");
            int i = this.g;
            float f3 = this.e;
            GLES20.glUniform3f(i, (0.9f * f3) + 1.0f, (2.1f * f3) + 1.0f, (f3 * 2.7f) + 1.0f);
            Egloo.checkGlError("glUniform3f");
            return;
        }
        GLES20.glUniform1f(this.f, f2 + 1.0f);
        Egloo.checkGlError("glUniform1f");
        GLES20.glUniform3f(this.g, 0.0f, 0.0f, 0.0f);
        Egloo.checkGlError("glUniform3f");
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public void setParameter1(float f2) {
        setSaturation((f2 * 2.0f) - 1.0f);
    }

    public void setSaturation(float f2) {
        if (f2 < -1.0f) {
            f2 = -1.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        this.e = f2;
    }
}
