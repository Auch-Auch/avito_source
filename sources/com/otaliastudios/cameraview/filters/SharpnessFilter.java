package com.otaliastudios.cameraview.filters;

import android.opengl.GLES20;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.filter.BaseFilter;
import com.otaliastudios.cameraview.filter.OneParameterFilter;
import com.otaliastudios.opengl.core.Egloo;
public class SharpnessFilter extends BaseFilter implements OneParameterFilter {
    public float e = 0.5f;
    public int f = 1;
    public int g = 1;
    public int h = -1;
    public int i = -1;
    public int j = -1;

    @Override // com.otaliastudios.cameraview.filter.Filter
    @NonNull
    public String getFragmentShader() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform float scale;\nuniform float stepsizeX;\nuniform float stepsizeY;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 nbr_color = vec3(0.0, 0.0, 0.0);\n  vec2 coord;\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  coord.x = vTextureCoord.x - 0.5 * stepsizeX;\n  coord.y = vTextureCoord.y - stepsizeY;\n  nbr_color += texture2D(sTexture, coord).rgb - color.rgb;\n  coord.x = vTextureCoord.x - stepsizeX;\n  coord.y = vTextureCoord.y + 0.5 * stepsizeY;\n  nbr_color += texture2D(sTexture, coord).rgb - color.rgb;\n  coord.x = vTextureCoord.x + stepsizeX;\n  coord.y = vTextureCoord.y - 0.5 * stepsizeY;\n  nbr_color += texture2D(sTexture, coord).rgb - color.rgb;\n  coord.x = vTextureCoord.x + stepsizeX;\n  coord.y = vTextureCoord.y + 0.5 * stepsizeY;\n  nbr_color += texture2D(sTexture, coord).rgb - color.rgb;\n  gl_FragColor = vec4(color.rgb - 2.0 * scale * nbr_color, color.a);\n}\n";
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public float getParameter1() {
        return getSharpness();
    }

    public float getSharpness() {
        return this.e;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void onCreate(int i2) {
        super.onCreate(i2);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i2, "scale");
        this.h = glGetUniformLocation;
        Egloo.checkGlProgramLocation(glGetUniformLocation, "scale");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(i2, "stepsizeX");
        this.i = glGetUniformLocation2;
        Egloo.checkGlProgramLocation(glGetUniformLocation2, "stepsizeX");
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(i2, "stepsizeY");
        this.j = glGetUniformLocation3;
        Egloo.checkGlProgramLocation(glGetUniformLocation3, "stepsizeY");
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void onDestroy() {
        super.onDestroy();
        this.h = -1;
        this.i = -1;
        this.j = -1;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter
    public void onPreDraw(long j2, @NonNull float[] fArr) {
        super.onPreDraw(j2, fArr);
        GLES20.glUniform1f(this.h, this.e);
        Egloo.checkGlError("glUniform1f");
        GLES20.glUniform1f(this.i, 1.0f / ((float) this.f));
        Egloo.checkGlError("glUniform1f");
        GLES20.glUniform1f(this.j, 1.0f / ((float) this.g));
        Egloo.checkGlError("glUniform1f");
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public void setParameter1(float f2) {
        setSharpness(f2);
    }

    public void setSharpness(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        this.e = f2;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void setSize(int i2, int i3) {
        super.setSize(i2, i3);
        this.f = i2;
        this.g = i3;
    }
}
