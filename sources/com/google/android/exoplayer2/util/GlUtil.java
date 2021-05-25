package com.google.android.exoplayer2.util;

import a2.b.a.a.a;
import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.work.Data;
import com.sumsub.sns.R2;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
public final class GlUtil {

    public static final class Attribute {
        public final int a;
        public final int b;
        @Nullable
        public Buffer c;
        public int d;
        public final String name;

        public Attribute(int i, int i2) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i, 35722, iArr, 0);
            int i3 = iArr[0];
            byte[] bArr = new byte[i3];
            int[] iArr2 = new int[1];
            int i4 = iArr[0];
            GLES20.glGetActiveAttrib(i, i2, i4, iArr2, 0, new int[1], 0, new int[1], 0, bArr, 0);
            int i5 = 0;
            while (true) {
                if (i5 >= i3) {
                    break;
                } else if (bArr[i5] == 0) {
                    i3 = i5;
                    break;
                } else {
                    i5++;
                }
            }
            String str = new String(bArr, 0, i3);
            this.name = str;
            this.b = GLES20.glGetAttribLocation(i, str);
            this.a = i2;
        }

        public void bind() {
            GLES20.glBindBuffer(34962, 0);
            GLES20.glVertexAttribPointer(this.b, this.d, (int) R2.styleable.Motion_motionPathRotate, false, 0, (Buffer) Assertions.checkNotNull(this.c, "call setBuffer before bind"));
            GLES20.glEnableVertexAttribArray(this.a);
            GlUtil.checkGlError();
        }

        public void setBuffer(float[] fArr, int i) {
            this.c = GlUtil.createBuffer(fArr);
            this.d = i;
        }
    }

    public static final class Uniform {
        public final int a;
        public final int b;
        public final float[] c;
        public int d;
        public int e;
        public final String name;

        public Uniform(int i, int i2) {
            byte[] bArr;
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i, 35719, iArr, 0);
            int[] iArr2 = new int[1];
            int i3 = iArr[0];
            byte[] bArr2 = new byte[i3];
            int i4 = iArr[0];
            byte[] bArr3 = bArr2;
            GLES20.glGetActiveUniform(i, i2, i4, new int[1], 0, new int[1], 0, iArr2, 0, bArr2, 0);
            int i5 = 0;
            while (true) {
                if (i5 >= i3) {
                    bArr = bArr3;
                    i5 = i3;
                    break;
                }
                bArr = bArr3;
                if (bArr[i5] == 0) {
                    break;
                }
                i5++;
                bArr3 = bArr;
            }
            String str = new String(bArr, 0, i5);
            this.name = str;
            this.a = GLES20.glGetUniformLocation(i, str);
            this.b = iArr2[0];
            this.c = new float[1];
        }

        public void bind() {
            if (this.b == 5126) {
                GLES20.glUniform1fv(this.a, 1, this.c, 0);
                GlUtil.checkGlError();
            } else if (this.d != 0) {
                GLES20.glActiveTexture(this.e + 33984);
                int i = this.b;
                if (i == 36198) {
                    GLES20.glBindTexture(36197, this.d);
                } else if (i == 35678) {
                    GLES20.glBindTexture(3553, this.d);
                } else {
                    StringBuilder L = a.L("unexpected uniform type: ");
                    L.append(this.b);
                    throw new IllegalStateException(L.toString());
                }
                GLES20.glUniform1i(this.a, this.e);
                GLES20.glTexParameteri(3553, Data.MAX_DATA_BYTES, 9729);
                GLES20.glTexParameteri(3553, 10241, 9729);
                GLES20.glTexParameteri(3553, 10242, 33071);
                GLES20.glTexParameteri(3553, 10243, 33071);
                GlUtil.checkGlError();
            } else {
                throw new IllegalStateException("call setSamplerTexId before bind");
            }
        }

        public void setFloat(float f) {
            this.c[0] = f;
        }

        public void setSamplerTexId(int i, int i2) {
            this.d = i;
            this.e = i2;
        }
    }

    public static void a(int i, String str, int i2) {
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 1) {
            Log.e("GlUtil", GLES20.glGetShaderInfoLog(glCreateShader) + ", source: " + str);
        }
        GLES20.glAttachShader(i2, glCreateShader);
        GLES20.glDeleteShader(glCreateShader);
        checkGlError();
    }

    public static void checkGlError() {
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                StringBuilder L = a.L("glError ");
                L.append(GLU.gluErrorString(glGetError));
                Log.e("GlUtil", L.toString());
            } else {
                return;
            }
        }
    }

    public static int compileProgram(String[] strArr, String[] strArr2) {
        return compileProgram(TextUtils.join("\n", strArr), TextUtils.join("\n", strArr2));
    }

    public static FloatBuffer createBuffer(float[] fArr) {
        return (FloatBuffer) createBuffer(fArr.length).put(fArr).flip();
    }

    public static int createExternalTexture() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, IntBuffer.wrap(iArr));
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameteri(36197, 10241, 9729);
        GLES20.glTexParameteri(36197, Data.MAX_DATA_BYTES, 9729);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        checkGlError();
        return iArr[0];
    }

    public static Attribute[] getAttributes(int i) {
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(i, 35721, iArr, 0);
        if (iArr[0] == 2) {
            Attribute[] attributeArr = new Attribute[iArr[0]];
            for (int i2 = 0; i2 < iArr[0]; i2++) {
                attributeArr[i2] = new Attribute(i, i2);
            }
            return attributeArr;
        }
        throw new IllegalStateException("expected two attributes");
    }

    public static Uniform[] getUniforms(int i) {
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(i, 35718, iArr, 0);
        Uniform[] uniformArr = new Uniform[iArr[0]];
        for (int i2 = 0; i2 < iArr[0]; i2++) {
            uniformArr[i2] = new Uniform(i, i2);
        }
        return uniformArr;
    }

    public static boolean isProtectedContentExtensionSupported(Context context) {
        String eglQueryString;
        int i = Util.SDK_INT;
        if (i < 24) {
            return false;
        }
        if (i < 26 && ("samsung".equals(Util.MANUFACTURER) || "XT1650".equals(Util.MODEL))) {
            return false;
        }
        if ((i >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains("EGL_EXT_protected_content")) {
            return true;
        }
        return false;
    }

    public static boolean isSurfacelessContextExtensionSupported() {
        String eglQueryString;
        if (Util.SDK_INT >= 17 && (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains("EGL_KHR_surfaceless_context")) {
            return true;
        }
        return false;
    }

    public static int compileProgram(String str, String str2) {
        int glCreateProgram = GLES20.glCreateProgram();
        checkGlError();
        a(35633, str, glCreateProgram);
        a(35632, str2, glCreateProgram);
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = {0};
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            StringBuilder L = a.L("Unable to link shader program: \n");
            L.append(GLES20.glGetProgramInfoLog(glCreateProgram));
            Log.e("GlUtil", L.toString());
        }
        checkGlError();
        return glCreateProgram;
    }

    public static FloatBuffer createBuffer(int i) {
        return ByteBuffer.allocateDirect(i * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }
}
