package com.otaliastudios.opengl.core;

import a2.b.a.a.a;
import android.opengl.EGL14;
import android.opengl.GLES20;
import androidx.core.app.NotificationCompat;
import com.otaliastudios.opengl.extensions.MatrixKt;
import com.otaliastudios.opengl.internal.EglContext;
import com.otaliastudios.opengl.internal.EglDisplay;
import com.otaliastudios.opengl.internal.EglKt;
import com.otaliastudios.opengl.internal.EglSurface;
import com.otaliastudios.opengl.internal.GlKt;
import com.otaliastudios.opengl.internal.MiscKt;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0014\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000e\u0010\u0006R\u0016\u0010\u000f\u001a\u00020\b8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\b8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\b8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\b8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00148\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/otaliastudios/opengl/core/Egloo;", "", "", "opName", "", "checkGlError", "(Ljava/lang/String;)V", "checkEglError", "", "location", "label", "checkGlProgramLocation", "(ILjava/lang/String;)V", NotificationCompat.CATEGORY_MESSAGE, "logCurrent", "SIZE_OF_SHORT", "I", "SIZE_OF_BYTE", "SIZE_OF_INT", "SIZE_OF_FLOAT", "", "IDENTITY_MATRIX", "[F", "<init>", "()V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public final class Egloo {
    @JvmField
    @NotNull
    public static final float[] IDENTITY_MATRIX;
    public static final Egloo INSTANCE = new Egloo();
    public static final int SIZE_OF_BYTE = 1;
    public static final int SIZE_OF_FLOAT = 4;
    public static final int SIZE_OF_INT = 4;
    public static final int SIZE_OF_SHORT = 2;

    static {
        float[] fArr = new float[16];
        MatrixKt.makeIdentity(fArr);
        IDENTITY_MATRIX = fArr;
    }

    @JvmStatic
    public static final void checkEglError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "opName");
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != EglKt.getEGL_SUCCESS()) {
            StringBuilder R = a.R("Error during ", str, ": EGL error 0x");
            R.append(MiscKt.intToHexString(eglGetError));
            throw new RuntimeException(R.toString());
        }
    }

    @JvmStatic
    public static final void checkGlError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "opName");
        int r0 = UInt.m277constructorimpl(GLES20.glGetError());
        if (r0 != GlKt.getGL_NO_ERROR()) {
            StringBuilder R = a.R("Error during ", str, ": glError 0x");
            R.append(MiscKt.intToHexString(r0));
            R.append(": ");
            R.append(MiscKt.gluErrorString(r0));
            throw new RuntimeException(R.toString());
        }
    }

    @JvmStatic
    public static final void checkGlProgramLocation(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "label");
        if (i < 0) {
            throw new RuntimeException(a.e3("Unable to locate ", str, " in program"));
        }
    }

    @JvmStatic
    public static final void logCurrent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
        String str2 = "Current EGL (" + str + "): display=" + new EglDisplay(EGL14.eglGetCurrentDisplay()) + ", context=" + new EglContext(EGL14.eglGetCurrentContext()) + ", surface=" + new EglSurface(EGL14.eglGetCurrentSurface(EglKt.getEGL_DRAW()));
    }
}
