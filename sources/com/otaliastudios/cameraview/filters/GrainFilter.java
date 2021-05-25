package com.otaliastudios.cameraview.filters;

import a2.b.a.a.a;
import android.opengl.GLES20;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.filter.BaseFilter;
import com.otaliastudios.cameraview.filter.OneParameterFilter;
import com.otaliastudios.opengl.core.Egloo;
import java.util.Random;
public class GrainFilter extends BaseFilter implements OneParameterFilter {
    public static final Random k;
    public static final String l;
    public float e = 0.5f;
    public int f = 1;
    public int g = 1;
    public int h = -1;
    public int i = -1;
    public int j = -1;

    static {
        Random random = new Random();
        k = random;
        StringBuilder L = a.L("#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvec2 seed;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES tex_sampler_0;\nuniform samplerExternalOES tex_sampler_1;\nuniform float scale;\nuniform float stepX;\nuniform float stepY;\nfloat rand(vec2 loc) {\n  float theta1 = dot(loc, vec2(0.9898, 0.233));\n  float theta2 = dot(loc, vec2(12.0, 78.0));\n  float value = cos(theta1) * sin(theta2) + sin(theta1) * cos(theta2);\n  float temp = mod(197.0 * value, 1.0) + value;\n  float part1 = mod(220.0 * temp, 1.0) + temp;\n  float part2 = value * 0.5453;\n  float part3 = cos(theta1 + theta2) * 0.43758;\n  float sum = (part1 + part2 + part3);\n  return fract(sum)*scale;\n}\nvoid main() {\n  seed[0] = ");
        L.append(random.nextFloat());
        L.append(";\n  seed[1] = ");
        L.append(random.nextFloat());
        L.append(";\n  float noise = texture2D(tex_sampler_1, ");
        L.append(BaseFilter.DEFAULT_FRAGMENT_TEXTURE_COORDINATE_NAME);
        a.n1(L, " + vec2(-stepX, -stepY)).r * 0.224;\n  noise += texture2D(tex_sampler_1, ", BaseFilter.DEFAULT_FRAGMENT_TEXTURE_COORDINATE_NAME, " + vec2(-stepX, stepY)).r * 0.224;\n  noise += texture2D(tex_sampler_1, ", BaseFilter.DEFAULT_FRAGMENT_TEXTURE_COORDINATE_NAME);
        a.n1(L, " + vec2(stepX, -stepY)).r * 0.224;\n  noise += texture2D(tex_sampler_1, ", BaseFilter.DEFAULT_FRAGMENT_TEXTURE_COORDINATE_NAME, " + vec2(stepX, stepY)).r * 0.224;\n  noise += 0.4448;\n  noise *= scale;\n  vec4 color = texture2D(tex_sampler_0, ", BaseFilter.DEFAULT_FRAGMENT_TEXTURE_COORDINATE_NAME);
        a.n1(L, ");\n  float energy = 0.33333 * color.r + 0.33333 * color.g + 0.33333 * color.b;\n  float mask = (1.0 - sqrt(energy));\n  float weight = 1.0 - 1.333 * mask * noise;\n  gl_FragColor = vec4(color.rgb * weight, color.a);\n  gl_FragColor = gl_FragColor+vec4(rand(", BaseFilter.DEFAULT_FRAGMENT_TEXTURE_COORDINATE_NAME, " + seed), rand(", BaseFilter.DEFAULT_FRAGMENT_TEXTURE_COORDINATE_NAME);
        l = a.u(L, " + seed),rand(", BaseFilter.DEFAULT_FRAGMENT_TEXTURE_COORDINATE_NAME, " + seed),1);\n}\n");
    }

    @Override // com.otaliastudios.cameraview.filter.Filter
    @NonNull
    public String getFragmentShader() {
        return l;
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public float getParameter1() {
        return getStrength();
    }

    public float getStrength() {
        return this.e;
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void onCreate(int i2) {
        super.onCreate(i2);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i2, "scale");
        this.h = glGetUniformLocation;
        Egloo.checkGlProgramLocation(glGetUniformLocation, "scale");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(i2, "stepX");
        this.i = glGetUniformLocation2;
        Egloo.checkGlProgramLocation(glGetUniformLocation2, "stepX");
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(i2, "stepY");
        this.j = glGetUniformLocation3;
        Egloo.checkGlProgramLocation(glGetUniformLocation3, "stepY");
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
        GLES20.glUniform1f(this.i, 0.5f / ((float) this.f));
        Egloo.checkGlError("glUniform1f");
        GLES20.glUniform1f(this.j, 0.5f / ((float) this.g));
        Egloo.checkGlError("glUniform1f");
    }

    @Override // com.otaliastudios.cameraview.filter.OneParameterFilter
    public void setParameter1(float f2) {
        setStrength(f2);
    }

    @Override // com.otaliastudios.cameraview.filter.BaseFilter, com.otaliastudios.cameraview.filter.Filter
    public void setSize(int i2, int i3) {
        super.setSize(i2, i3);
        this.f = i2;
        this.g = i3;
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
