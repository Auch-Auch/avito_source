package com.otaliastudios.opengl.program;

import android.opengl.GLES20;
import com.avito.android.remote.auth.AuthSource;
import com.otaliastudios.opengl.core.Egloo;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\b8\u0000@\u0000X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0013"}, d2 = {"Lcom/otaliastudios/opengl/program/GlProgramLocation;", "", "", "c", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "Lkotlin/UInt;", AuthSource.BOOKING_ORDER, "I", "getUvalue-pVg5ArA$egloo_metadata_release", "()I", "uvalue", "", AuthSource.SEND_ABUSE, "getValue", "value", "Companion", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public final class GlProgramLocation {
    public static final Companion Companion = new Companion(null);
    public final int a;
    public final int b;
    @NotNull
    public final String c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\b¨\u0006\f"}, d2 = {"Lcom/otaliastudios/opengl/program/GlProgramLocation$Companion;", "", "", "program", "", "name", "Lcom/otaliastudios/opengl/program/GlProgramLocation;", "getAttrib", "(ILjava/lang/String;)Lcom/otaliastudios/opengl/program/GlProgramLocation;", "getUniform", "<init>", "()V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final GlProgramLocation getAttrib(int i, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            return new GlProgramLocation(i, a.ATTRIB, str, null);
        }

        @NotNull
        public final GlProgramLocation getUniform(int i, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            return new GlProgramLocation(i, a.UNIFORM, str, null);
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            a.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    public enum a {
        ATTRIB,
        UNIFORM
    }

    public GlProgramLocation(int i, a aVar, String str, j jVar) {
        int i2;
        this.c = str;
        int ordinal = aVar.ordinal();
        if (ordinal == 0) {
            i2 = GLES20.glGetAttribLocation(UInt.m277constructorimpl(i), str);
        } else if (ordinal == 1) {
            i2 = GLES20.glGetUniformLocation(UInt.m277constructorimpl(i), str);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.a = i2;
        Egloo.checkGlProgramLocation(i2, str);
        this.b = UInt.m277constructorimpl(i2);
    }

    @NotNull
    public final String getName() {
        return this.c;
    }

    /* renamed from: getUvalue-pVg5ArA$egloo_metadata_release  reason: not valid java name */
    public final int m189getUvaluepVg5ArA$egloo_metadata_release() {
        return this.b;
    }

    public final int getValue() {
        return this.a;
    }
}
