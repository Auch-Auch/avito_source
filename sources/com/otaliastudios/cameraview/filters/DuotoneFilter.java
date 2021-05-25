package com.otaliastudios.cameraview.filters;

import android.graphics.Color;
import android.opengl.GLES20;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.otaliastudios.cameraview.filter.BaseFilter;
import com.otaliastudios.cameraview.filter.TwoParameterFilter;
import com.otaliastudios.opengl.core.Egloo;
public class DuotoneFilter extends BaseFilter implements TwoParameterFilter {
    public int e = -65281;
    public int f = InputDeviceCompat.SOURCE_ANY;
    public int g = -1;
    public int h = -1;

    @ColorInt
    public int getFirstColor() {
        return this.e;
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    @NonNull
    public String getFragmentShader() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform vec3 first;\nuniform vec3 second;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float energy = (color.r + color.g + color.b) * 0.3333;\n  vec3 new_color = (1.0 - energy) * first + energy * second;\n  gl_FragColor = vec4(new_color.rgb, color.a);\n}\n";
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public float getParameter1() {
        int firstColor = getFirstColor();
        return ((float) Color.argb(0, Color.red(firstColor), Color.green(firstColor), Color.blue(firstColor))) / 1.6777215E7f;
    }

    @Override // com.otaliastudios.cameraview.filter.TwoParameterFilter
    public float getParameter2() {
        int secondColor = getSecondColor();
        return ((float) Color.argb(0, Color.red(secondColor), Color.green(secondColor), Color.blue(secondColor))) / 1.6777215E7f;
    }

    @ColorInt
    public int getSecondColor() {
        return this.f;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void onCreate(int i) {
        super.onCreate(i);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i, InternalConstsKt.FIRST_IMAGE);
        this.g = glGetUniformLocation;
        Egloo.checkGlProgramLocation(glGetUniformLocation, InternalConstsKt.FIRST_IMAGE);
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(i, "second");
        this.h = glGetUniformLocation2;
        Egloo.checkGlProgramLocation(glGetUniformLocation2, "second");
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void onDestroy() {
        super.onDestroy();
        this.g = -1;
        this.h = -1;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter
    public void onPreDraw(long j, @NonNull float[] fArr) {
        super.onPreDraw(j, fArr);
        float[] fArr2 = {((float) Color.red(this.e)) / 255.0f, ((float) Color.green(this.e)) / 255.0f, ((float) Color.blue(this.e)) / 255.0f};
        float[] fArr3 = {((float) Color.red(this.f)) / 255.0f, ((float) Color.green(this.f)) / 255.0f, ((float) Color.blue(this.f)) / 255.0f};
        GLES20.glUniform3fv(this.g, 1, fArr2, 0);
        Egloo.checkGlError("glUniform3fv");
        GLES20.glUniform3fv(this.h, 1, fArr3, 0);
        Egloo.checkGlError("glUniform3fv");
    }

    public void setColors(@ColorInt int i, @ColorInt int i2) {
        setFirstColor(i);
        setSecondColor(i2);
    }

    public void setFirstColor(@ColorInt int i) {
        this.e = Color.rgb(Color.red(i), Color.green(i), Color.blue(i));
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public void setParameter1(float f2) {
        setFirstColor((int) (f2 * 1.6777215E7f));
    }

    @Override // com.otaliastudios.cameraview.filter.TwoParameterFilter
    public void setParameter2(float f2) {
        setSecondColor((int) (f2 * 1.6777215E7f));
    }

    public void setSecondColor(@ColorInt int i) {
        this.f = Color.rgb(Color.red(i), Color.green(i), Color.blue(i));
    }
}
