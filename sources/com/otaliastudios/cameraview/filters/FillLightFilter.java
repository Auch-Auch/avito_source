package com.otaliastudios.cameraview.filters;

import android.opengl.GLES20;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.filter.BaseFilter;
import com.otaliastudios.cameraview.filter.OneParameterFilter;
import com.otaliastudios.opengl.core.Egloo;
public class FillLightFilter extends BaseFilter implements OneParameterFilter {
    public float e = 0.5f;
    public int f = -1;
    public int g = -1;

    @Override // com.otaliastudios.cameraview.filter.Filter
    @NonNull
    public String getFragmentShader() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform float mult;\nuniform float igamma;\nvarying vec2 vTextureCoord;\nvoid main() {\n  const vec3 color_weights = vec3(0.25, 0.5, 0.25);\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float lightmask = dot(color.rgb, color_weights);\n  float backmask = (1.0 - lightmask);\n  vec3 ones = vec3(1.0, 1.0, 1.0);\n  vec3 diff = pow(mult * color.rgb, igamma * ones) - color.rgb;\n  diff = min(diff, 1.0);\n  vec3 new_color = min(color.rgb + diff * backmask, 1.0);\n  gl_FragColor = vec4(new_color, color.a);\n}\n";
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public float getParameter1() {
        return getStrength();
    }

    public float getStrength() {
        return this.e;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void onCreate(int i) {
        super.onCreate(i);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i, "mult");
        this.f = glGetUniformLocation;
        Egloo.checkGlProgramLocation(glGetUniformLocation, "mult");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(i, "igamma");
        this.g = glGetUniformLocation2;
        Egloo.checkGlProgramLocation(glGetUniformLocation2, "igamma");
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
        float f2 = 1.0f / (((1.0f - this.e) * 0.7f) + 0.3f);
        GLES20.glUniform1f(this.f, f2);
        Egloo.checkGlError("glUniform1f");
        GLES20.glUniform1f(this.g, 1.0f / ((0.7f * f2) + 0.3f));
        Egloo.checkGlError("glUniform1f");
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public void setParameter1(float f2) {
        setStrength(f2);
    }

    public void setStrength(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        this.e = f2;
    }
}
