package com.otaliastudios.opengl.internal;

import android.opengl.GLU;
import android.opengl.Matrix;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0011\u001a \u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0006\u0010\u0005\u001a \u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0007\u0010\u0005\u001a \u0010\b\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\b¢\u0006\u0004\b\b\u0010\u0005\u001a\u0017\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0017\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\r\u0010\f\u001a\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a/\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a/\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0018\u0010\u0017\u001a7\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0017\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a'\u0010!\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000eH\u0000¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"", "tag", "message", "", "logv", "(Ljava/lang/String;Ljava/lang/String;)V", "logi", "logw", "loge", "", "value", "intToHexString", "(I)Ljava/lang/String;", "gluErrorString", "", "matrix", "matrixMakeIdentity", "([F)V", "", "x", "y", "z", "matrixTranslate", "([FFFF)V", "matrixScale", "angle", "matrixRotate", "([FFFFF)V", "matrixClone", "([F)[F", "result", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "right", "matrixMultiply", "([F[F[F)V", "egloo-metadata_release"}, k = 2, mv = {1, 4, 0})
public final class MiscKt {
    @NotNull
    public static final String gluErrorString(int i) {
        String gluErrorString = GLU.gluErrorString(i);
        Intrinsics.checkNotNullExpressionValue(gluErrorString, "GLU.gluErrorString(value)");
        return gluErrorString;
    }

    @NotNull
    public static final String intToHexString(int i) {
        String hexString = Integer.toHexString(i);
        Intrinsics.checkNotNullExpressionValue(hexString, "Integer.toHexString(value)");
        return hexString;
    }

    public static final void loge(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "message");
    }

    public static final void logi(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "message");
    }

    public static final void logv(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "message");
    }

    public static final void logw(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "message");
    }

    @NotNull
    public static final float[] matrixClone(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        return (float[]) fArr.clone();
    }

    public static final void matrixMakeIdentity(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        Matrix.setIdentityM(fArr, 0);
    }

    public static final void matrixMultiply(@NotNull float[] fArr, @NotNull float[] fArr2, @NotNull float[] fArr3) {
        Intrinsics.checkNotNullParameter(fArr, "result");
        Intrinsics.checkNotNullParameter(fArr2, ViewHierarchyConstants.DIMENSION_LEFT_KEY);
        Intrinsics.checkNotNullParameter(fArr3, "right");
        Matrix.multiplyMM(fArr, 0, fArr2, 0, fArr3, 0);
    }

    public static final void matrixRotate(@NotNull float[] fArr, float f, float f2, float f3, float f4) {
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        Matrix.rotateM(fArr, 0, f, f2, f3, f4);
    }

    public static final void matrixScale(@NotNull float[] fArr, float f, float f2, float f3) {
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        Matrix.scaleM(fArr, 0, f, f2, f3);
    }

    public static final void matrixTranslate(@NotNull float[] fArr, float f, float f2, float f3) {
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        Matrix.translateM(fArr, 0, f, f2, f3);
    }
}
