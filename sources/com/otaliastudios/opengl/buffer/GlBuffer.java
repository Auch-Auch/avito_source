package com.otaliastudios.opengl.buffer;

import android.opengl.GLES20;
import com.avito.android.remote.auth.AuthSource;
import com.otaliastudios.opengl.core.Egloo;
import com.otaliastudios.opengl.core.GlBindable;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UIntArray;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u000f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/otaliastudios/opengl/buffer/GlBuffer;", "Lcom/otaliastudios/opengl/core/GlBindable;", "", "bind", "()V", "unbind", "release", "", AuthSource.BOOKING_ORDER, "I", "getTarget", "()I", "target", AuthSource.SEND_ABUSE, "getId", "id", "<init>", "(ILjava/lang/Integer;)V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public class GlBuffer implements GlBindable {
    public final int a;
    public final int b;

    public GlBuffer(int i, @Nullable Integer num) {
        int i2;
        this.b = i;
        if (num != null) {
            i2 = num.intValue();
        } else {
            int[] r7 = UIntArray.m284constructorimpl(1);
            int r0 = UIntArray.m291getSizeimpl(r7);
            int[] iArr = new int[r0];
            for (int i3 = 0; i3 < r0; i3++) {
                iArr[i3] = UIntArray.m290getpVg5ArA(r7, i3);
            }
            GLES20.glGenBuffers(1, iArr, 0);
            for (int i4 = 0; i4 < 1; i4++) {
                UIntArray.m295setVXSXFK8(r7, i4, UInt.m277constructorimpl(iArr[i4]));
            }
            Egloo.checkGlError("glGenBuffers");
            i2 = UIntArray.m290getpVg5ArA(r7, 0);
        }
        this.a = i2;
    }

    @Override // com.otaliastudios.opengl.core.GlBindable
    public void bind() {
        GLES20.glBindBuffer(UInt.m277constructorimpl(this.b), UInt.m277constructorimpl(this.a));
    }

    public final int getId() {
        return this.a;
    }

    public final int getTarget() {
        return this.b;
    }

    public final void release() {
        int[] iArr = {UInt.m277constructorimpl(this.a)};
        int r2 = UIntArray.m291getSizeimpl(iArr);
        int[] iArr2 = new int[r2];
        for (int i = 0; i < r2; i++) {
            iArr2[i] = UIntArray.m290getpVg5ArA(iArr, i);
        }
        GLES20.glDeleteBuffers(1, iArr2, 0);
        for (int i2 = 0; i2 < 1; i2++) {
            UIntArray.m295setVXSXFK8(iArr, i2, UInt.m277constructorimpl(iArr2[i2]));
        }
    }

    @Override // com.otaliastudios.opengl.core.GlBindable
    public void unbind() {
        GLES20.glBindBuffer(UInt.m277constructorimpl(this.b), 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlBuffer(int i, Integer num, int i2, j jVar) {
        this(i, (i2 & 2) != 0 ? null : num);
    }
}
