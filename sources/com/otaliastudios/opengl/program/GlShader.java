package com.otaliastudios.opengl.program;

import android.opengl.GLES20;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.UInt;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0006B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fB\u0019\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u000e\u0010\u0012J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/otaliastudios/opengl/program/GlShader;", "", "", "release", "()V", "", AuthSource.SEND_ABUSE, "I", "getType", "()I", "type", AuthSource.BOOKING_ORDER, "getId", "id", "<init>", "(II)V", "", "source", "(ILjava/lang/String;)V", "c", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public final class GlShader {
    public static final a c = new a(null);
    public final int a;
    public final int b;

    public static final class a {
        public a(j jVar) {
        }
    }

    public GlShader(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public final int getId() {
        return this.b;
    }

    public final int getType() {
        return this.a;
    }

    public final void release() {
        GLES20.glDeleteShader(UInt.m277constructorimpl(this.b));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GlShader(int r5, @org.jetbrains.annotations.NotNull java.lang.String r6) {
        /*
            r4 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            int r0 = kotlin.UInt.m277constructorimpl(r5)
            int r0 = android.opengl.GLES20.glCreateShader(r0)
            int r0 = kotlin.UInt.m277constructorimpl(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "glCreateShader type="
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            com.otaliastudios.opengl.core.Egloo.checkGlError(r1)
            android.opengl.GLES20.glShaderSource(r0, r6)
            android.opengl.GLES20.glCompileShader(r0)
            r1 = 1
            int[] r1 = new int[r1]
            int r2 = com.otaliastudios.opengl.internal.GlKt.getGL_COMPILE_STATUS()
            r3 = 0
            android.opengl.GLES20.glGetShaderiv(r0, r2, r1, r3)
            r1 = r1[r3]
            if (r1 == 0) goto L_0x003e
            r4.<init>(r5, r0)
            return
        L_0x003e:
            java.lang.String r1 = "Could not compile shader "
            java.lang.String r2 = ": '"
            java.lang.StringBuilder r5 = a2.b.a.a.a.M(r1, r5, r2)
            java.lang.String r1 = android.opengl.GLES20.glGetShaderInfoLog(r0)
            r5.append(r1)
            java.lang.String r1 = "' source: "
            r5.append(r1)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            android.opengl.GLES20.glDeleteShader(r0)
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            r6.<init>(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.opengl.program.GlShader.<init>(int, java.lang.String):void");
    }
}
