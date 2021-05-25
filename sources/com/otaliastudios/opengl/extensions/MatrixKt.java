package com.otaliastudios.opengl.extensions;

import com.avito.android.remote.auth.AuthSource;
import com.otaliastudios.opengl.internal.MiscKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u0014\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0015\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0006\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0005\u001a/\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u0019\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0019\u0010\u0010\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u000f\u001a\u0019\u0010\u0011\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u000f\u001a/\u0010\u0012\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\f\u001a\u0019\u0010\u0013\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u000f\u001a\u0019\u0010\u0014\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u000f\u001a\u0019\u0010\u0015\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u000f\u001a1\u0010\u0017\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0019\u0010\u0019\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b\u0019\u0010\u000f\u001a\u0019\u0010\u001a\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u000f\u001a\u0019\u0010\u001b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u000f¨\u0006\u001c"}, d2 = {"", "", AuthSource.SEND_ABUSE, "([F)V", "makeIdentity", "([F)[F", "clear", "", "x", "y", "z", "translate", "([FFFF)[F", "translation", "translateX", "([FF)[F", "translateY", "translateZ", "scale", "scaleX", "scaleY", "scaleZ", "angle", "rotate", "([FFFFF)[F", "rotateX", "rotateY", "rotateZ", "egloo-metadata_release"}, k = 2, mv = {1, 4, 0})
public final class MatrixKt {
    public static final void a(float[] fArr) {
        if (fArr.length != 16) {
            throw new RuntimeException("Need a 16 values matrix.");
        }
    }

    @NotNull
    public static final float[] clear(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$clear");
        return makeIdentity(fArr);
    }

    @NotNull
    public static final float[] makeIdentity(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$makeIdentity");
        a(fArr);
        MiscKt.matrixMakeIdentity(fArr);
        return fArr;
    }

    @NotNull
    public static final float[] rotate(@NotNull float[] fArr, float f, float f2, float f3, float f4) {
        Intrinsics.checkNotNullParameter(fArr, "$this$rotate");
        a(fArr);
        MiscKt.matrixRotate(fArr, f, f2, f3, f4);
        return fArr;
    }

    @NotNull
    public static final float[] rotateX(@NotNull float[] fArr, float f) {
        Intrinsics.checkNotNullParameter(fArr, "$this$rotateX");
        return rotate(fArr, f, 1.0f, 0.0f, 0.0f);
    }

    @NotNull
    public static final float[] rotateY(@NotNull float[] fArr, float f) {
        Intrinsics.checkNotNullParameter(fArr, "$this$rotateY");
        return rotate(fArr, f, 0.0f, 1.0f, 0.0f);
    }

    @NotNull
    public static final float[] rotateZ(@NotNull float[] fArr, float f) {
        Intrinsics.checkNotNullParameter(fArr, "$this$rotateZ");
        return rotate(fArr, f, 0.0f, 0.0f, 1.0f);
    }

    @NotNull
    public static final float[] scale(@NotNull float[] fArr, float f, float f2, float f3) {
        Intrinsics.checkNotNullParameter(fArr, "$this$scale");
        a(fArr);
        MiscKt.matrixScale(fArr, f, f2, f3);
        return fArr;
    }

    public static /* synthetic */ float[] scale$default(float[] fArr, float f, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f2 = 1.0f;
        }
        if ((i & 4) != 0) {
            f3 = 1.0f;
        }
        return scale(fArr, f, f2, f3);
    }

    @NotNull
    public static final float[] scaleX(@NotNull float[] fArr, float f) {
        Intrinsics.checkNotNullParameter(fArr, "$this$scaleX");
        return scale$default(fArr, f, 0.0f, 0.0f, 6, null);
    }

    @NotNull
    public static final float[] scaleY(@NotNull float[] fArr, float f) {
        Intrinsics.checkNotNullParameter(fArr, "$this$scaleY");
        return scale$default(fArr, 0.0f, f, 0.0f, 5, null);
    }

    @NotNull
    public static final float[] scaleZ(@NotNull float[] fArr, float f) {
        Intrinsics.checkNotNullParameter(fArr, "$this$scaleZ");
        return scale$default(fArr, 0.0f, 0.0f, f, 3, null);
    }

    @NotNull
    public static final float[] translate(@NotNull float[] fArr, float f, float f2, float f3) {
        Intrinsics.checkNotNullParameter(fArr, "$this$translate");
        a(fArr);
        MiscKt.matrixTranslate(fArr, f, f2, f3);
        return fArr;
    }

    public static /* synthetic */ float[] translate$default(float[] fArr, float f, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        return translate(fArr, f, f2, f3);
    }

    @NotNull
    public static final float[] translateX(@NotNull float[] fArr, float f) {
        Intrinsics.checkNotNullParameter(fArr, "$this$translateX");
        return translate$default(fArr, f, 0.0f, 0.0f, 6, null);
    }

    @NotNull
    public static final float[] translateY(@NotNull float[] fArr, float f) {
        Intrinsics.checkNotNullParameter(fArr, "$this$translateY");
        return translate$default(fArr, 0.0f, f, 0.0f, 5, null);
    }

    @NotNull
    public static final float[] translateZ(@NotNull float[] fArr, float f) {
        Intrinsics.checkNotNullParameter(fArr, "$this$translateZ");
        return translate$default(fArr, 0.0f, 0.0f, f, 3, null);
    }
}
