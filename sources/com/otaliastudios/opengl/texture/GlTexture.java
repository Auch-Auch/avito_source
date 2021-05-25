package com.otaliastudios.opengl.texture;

import a2.g.r.g;
import android.opengl.GLES20;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.otaliastudios.opengl.core.Egloo;
import com.otaliastudios.opengl.core.GlBindable;
import com.otaliastudios.opengl.core.GlBindableKt;
import com.otaliastudios.opengl.internal.GlKt;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001f\u0018\u00002\u00020\u0001BU\b\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0007\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\"\u0010#B)\b\u0017\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\"\u0010$BG\b\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010 \u001a\u00020\u0007\u0012\b\b\u0002\u0010!\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\"\u0010%J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0014\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u0019\u0010\u0017\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000bR\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0010R\u001b\u0010 \u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001f\u0010\u0010¨\u0006&"}, d2 = {"Lcom/otaliastudios/opengl/texture/GlTexture;", "Lcom/otaliastudios/opengl/core/GlBindable;", "", "bind", "()V", "unbind", "release", "", "c", "I", "getTarget", "()I", "target", "e", "Ljava/lang/Integer;", "getHeight", "()Ljava/lang/Integer;", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, AuthSource.BOOKING_ORDER, "getUnit", "unit", AuthSource.SEND_ABUSE, "getId", "id", g.a, "getType", "type", "d", "getWidth", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "f", "getFormat", "format", "internalFormat", "<init>", "(IILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "(IILjava/lang/Integer;)V", "(IIIIIII)V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public final class GlTexture implements GlBindable {
    public final int a;
    public final int b;
    public final int c;
    @Nullable
    public final Integer d;
    @Nullable
    public final Integer e;
    @Nullable
    public final Integer f;
    @Nullable
    public final Integer g;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ GlTexture a;
        public final /* synthetic */ Integer b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(GlTexture glTexture, Integer num) {
            super(0);
            this.a = glTexture;
            this.b = num;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            if (!(this.a.getWidth() == null || this.a.getHeight() == null || this.a.getFormat() == null || this.b == null || this.a.getType() == null)) {
                GLES20.glTexImage2D(UInt.m277constructorimpl(this.a.getTarget()), 0, this.b.intValue(), this.a.getWidth().intValue(), this.a.getHeight().intValue(), 0, UInt.m277constructorimpl(this.a.getFormat().intValue()), UInt.m277constructorimpl(this.a.getType().intValue()), null);
            }
            GLES20.glTexParameterf(UInt.m277constructorimpl(this.a.getTarget()), GlKt.getGL_TEXTURE_MIN_FILTER(), GlKt.getGL_NEAREST());
            GLES20.glTexParameterf(UInt.m277constructorimpl(this.a.getTarget()), GlKt.getGL_TEXTURE_MAG_FILTER(), GlKt.getGL_LINEAR());
            GLES20.glTexParameteri(UInt.m277constructorimpl(this.a.getTarget()), GlKt.getGL_TEXTURE_WRAP_S(), GlKt.getGL_CLAMP_TO_EDGE());
            GLES20.glTexParameteri(UInt.m277constructorimpl(this.a.getTarget()), GlKt.getGL_TEXTURE_WRAP_T(), GlKt.getGL_CLAMP_TO_EDGE());
            Egloo.checkGlError("glTexParameter");
            return Unit.INSTANCE;
        }
    }

    @JvmOverloads
    public GlTexture() {
        this(0, 0, (Integer) null, 7, (j) null);
    }

    @JvmOverloads
    public GlTexture(int i) {
        this(i, 0, (Integer) null, 6, (j) null);
    }

    @JvmOverloads
    public GlTexture(int i, int i2) {
        this(i, i2, (Integer) null, 4, (j) null);
    }

    @JvmOverloads
    public GlTexture(int i, int i2, int i3, int i4) {
        this(i, i2, i3, i4, 0, 0, 0, 112, null);
    }

    @JvmOverloads
    public GlTexture(int i, int i2, int i3, int i4, int i5) {
        this(i, i2, i3, i4, i5, 0, 0, 96, null);
    }

    @JvmOverloads
    public GlTexture(int i, int i2, int i3, int i4, int i5, int i6) {
        this(i, i2, i3, i4, i5, i6, 0, 64, null);
    }

    public GlTexture(int i, int i2, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6) {
        int i3;
        this.b = i;
        this.c = i2;
        this.d = num2;
        this.e = num3;
        this.f = num4;
        this.g = num6;
        if (num != null) {
            i3 = num.intValue();
        } else {
            int[] r3 = UIntArray.m284constructorimpl(1);
            int r5 = UIntArray.m291getSizeimpl(r3);
            int[] iArr = new int[r5];
            for (int i4 = 0; i4 < r5; i4++) {
                iArr[i4] = UIntArray.m290getpVg5ArA(r3, i4);
            }
            GLES20.glGenTextures(1, iArr, 0);
            for (int i5 = 0; i5 < 1; i5++) {
                UIntArray.m295setVXSXFK8(r3, i5, UInt.m277constructorimpl(iArr[i5]));
            }
            Egloo.checkGlError("glGenTextures");
            i3 = UIntArray.m290getpVg5ArA(r3, 0);
        }
        this.a = i3;
        if (num == null) {
            GlBindableKt.use(this, new a(this, num5));
        }
    }

    @Override // com.otaliastudios.opengl.core.GlBindable
    public void bind() {
        GLES20.glActiveTexture(UInt.m277constructorimpl(this.b));
        GLES20.glBindTexture(UInt.m277constructorimpl(this.c), UInt.m277constructorimpl(this.a));
        Egloo.checkGlError("bind");
    }

    @Nullable
    public final Integer getFormat() {
        return this.f;
    }

    @Nullable
    public final Integer getHeight() {
        return this.e;
    }

    public final int getId() {
        return this.a;
    }

    public final int getTarget() {
        return this.c;
    }

    @Nullable
    public final Integer getType() {
        return this.g;
    }

    public final int getUnit() {
        return this.b;
    }

    @Nullable
    public final Integer getWidth() {
        return this.d;
    }

    public final void release() {
        int[] iArr = {UInt.m277constructorimpl(this.a)};
        int r2 = UIntArray.m291getSizeimpl(iArr);
        int[] iArr2 = new int[r2];
        for (int i = 0; i < r2; i++) {
            iArr2[i] = UIntArray.m290getpVg5ArA(iArr, i);
        }
        GLES20.glDeleteTextures(1, iArr2, 0);
        for (int i2 = 0; i2 < 1; i2++) {
            UIntArray.m295setVXSXFK8(iArr, i2, UInt.m277constructorimpl(iArr2[i2]));
        }
    }

    @Override // com.otaliastudios.opengl.core.GlBindable
    public void unbind() {
        GLES20.glBindTexture(UInt.m277constructorimpl(this.c), UInt.m277constructorimpl(0));
        GLES20.glActiveTexture(GlKt.getGL_TEXTURE0());
        Egloo.checkGlError("unbind");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlTexture(int i, int i2, Integer num, int i3, j jVar) {
        this((i3 & 1) != 0 ? GlKt.getGL_TEXTURE0() : i, (i3 & 2) != 0 ? GlKt.getGL_TEXTURE_EXTERNAL_OES() : i2, (i3 & 4) != 0 ? null : num);
    }

    @JvmOverloads
    public GlTexture(int i, int i2, @Nullable Integer num) {
        this(i, i2, num, null, null, null, null, null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GlTexture(int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, t6.r.a.j r18) {
        /*
            r9 = this;
            r0 = r17 & 16
            if (r0 == 0) goto L_0x000a
            int r0 = com.otaliastudios.opengl.internal.GlKt.getGL_RGBA()
            r6 = r0
            goto L_0x000b
        L_0x000a:
            r6 = r14
        L_0x000b:
            r0 = r17 & 32
            if (r0 == 0) goto L_0x0011
            r7 = r6
            goto L_0x0012
        L_0x0011:
            r7 = r15
        L_0x0012:
            r0 = r17 & 64
            if (r0 == 0) goto L_0x001c
            int r0 = com.otaliastudios.opengl.internal.GlKt.getGL_UNSIGNED_BYTE()
            r8 = r0
            goto L_0x001e
        L_0x001c:
            r8 = r16
        L_0x001e:
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.opengl.texture.GlTexture.<init>(int, int, int, int, int, int, int, int, t6.r.a.j):void");
    }

    @JvmOverloads
    public GlTexture(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this(i, i2, null, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7));
    }
}
