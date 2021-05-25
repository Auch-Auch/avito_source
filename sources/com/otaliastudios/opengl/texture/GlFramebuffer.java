package com.otaliastudios.opengl.texture;

import android.opengl.GLES20;
import com.avito.android.remote.auth.AuthSource;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\r\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\nR\u0019\u0010\u0011\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/otaliastudios/opengl/texture/GlFramebuffer;", "Lcom/otaliastudios/opengl/core/GlBindable;", "Lcom/otaliastudios/opengl/texture/GlTexture;", "texture", "", "attachment", "", "attach", "(Lcom/otaliastudios/opengl/texture/GlTexture;I)V", "bind", "()V", "unbind", "release", AuthSource.SEND_ABUSE, "I", "getId", "()I", "id", "<init>", "(Ljava/lang/Integer;)V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public final class GlFramebuffer implements GlBindable {
    public final int a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ GlTexture b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, GlTexture glTexture) {
            super(0);
            this.a = i;
            this.b = glTexture;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            GLES20.glFramebufferTexture2D(GlKt.getGL_FRAMEBUFFER(), UInt.m277constructorimpl(this.a), UInt.m277constructorimpl(this.b.getTarget()), UInt.m277constructorimpl(this.b.getId()), 0);
            int r0 = UInt.m277constructorimpl(GLES20.glCheckFramebufferStatus(GlKt.getGL_FRAMEBUFFER()));
            if (r0 == GlKt.getGL_FRAMEBUFFER_COMPLETE()) {
                return Unit.INSTANCE;
            }
            StringBuilder L = a2.b.a.a.a.L("Invalid framebuffer generation. Error:");
            L.append(UInt.m281toStringimpl(r0));
            throw new RuntimeException(L.toString());
        }
    }

    public GlFramebuffer() {
        this(null, 1, null);
    }

    public GlFramebuffer(@Nullable Integer num) {
        int i;
        if (num != null) {
            i = num.intValue();
        } else {
            int[] r0 = UIntArray.m284constructorimpl(1);
            int r1 = UIntArray.m291getSizeimpl(r0);
            int[] iArr = new int[r1];
            for (int i2 = 0; i2 < r1; i2++) {
                iArr[i2] = UIntArray.m290getpVg5ArA(r0, i2);
            }
            GLES20.glGenFramebuffers(1, iArr, 0);
            for (int i3 = 0; i3 < 1; i3++) {
                UIntArray.m295setVXSXFK8(r0, i3, UInt.m277constructorimpl(iArr[i3]));
            }
            Egloo.checkGlError("glGenFramebuffers");
            i = UIntArray.m290getpVg5ArA(r0, 0);
        }
        this.a = i;
    }

    public static /* synthetic */ void attach$default(GlFramebuffer glFramebuffer, GlTexture glTexture, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = GlKt.getGL_COLOR_ATTACHMENT0();
        }
        glFramebuffer.attach(glTexture, i);
    }

    @JvmOverloads
    public final void attach(@NotNull GlTexture glTexture) {
        attach$default(this, glTexture, 0, 2, null);
    }

    @JvmOverloads
    public final void attach(@NotNull GlTexture glTexture, int i) {
        Intrinsics.checkNotNullParameter(glTexture, "texture");
        GlBindableKt.use(this, new a(i, glTexture));
    }

    @Override // com.otaliastudios.opengl.core.GlBindable
    public void bind() {
        GLES20.glBindFramebuffer(GlKt.getGL_FRAMEBUFFER(), UInt.m277constructorimpl(this.a));
    }

    public final int getId() {
        return this.a;
    }

    public final void release() {
        int[] iArr = {UInt.m277constructorimpl(this.a)};
        int r2 = UIntArray.m291getSizeimpl(iArr);
        int[] iArr2 = new int[r2];
        for (int i = 0; i < r2; i++) {
            iArr2[i] = UIntArray.m290getpVg5ArA(iArr, i);
        }
        GLES20.glDeleteFramebuffers(1, iArr2, 0);
        for (int i2 = 0; i2 < 1; i2++) {
            UIntArray.m295setVXSXFK8(iArr, i2, UInt.m277constructorimpl(iArr2[i2]));
        }
    }

    @Override // com.otaliastudios.opengl.core.GlBindable
    public void unbind() {
        GLES20.glBindFramebuffer(GlKt.getGL_FRAMEBUFFER(), 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlFramebuffer(Integer num, int i, j jVar) {
        this((i & 1) != 0 ? null : num);
    }
}
