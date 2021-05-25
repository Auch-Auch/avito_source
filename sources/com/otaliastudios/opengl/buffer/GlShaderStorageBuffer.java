package com.otaliastudios.opengl.buffer;

import android.opengl.GLES20;
import android.opengl.GLES30;
import androidx.annotation.RequiresApi;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.otaliastudios.opengl.core.Egloo;
import com.otaliastudios.opengl.core.GlBindableKt;
import com.otaliastudios.opengl.internal.GlKt;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@RequiresApi(api = 21, value = 21)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/otaliastudios/opengl/buffer/GlShaderStorageBuffer;", "Lcom/otaliastudios/opengl/buffer/GlBuffer;", "", FirebaseAnalytics.Param.INDEX, "", "bind", "(I)V", "Lkotlin/Function0;", "block", "use", "(ILkotlin/jvm/functions/Function0;)V", "c", "I", "getSize", "()I", "size", "d", "getUsage", "usage", "<init>", "(II)V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public final class GlShaderStorageBuffer extends GlBuffer {
    public final int c;
    public final int d;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ GlShaderStorageBuffer a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(GlShaderStorageBuffer glShaderStorageBuffer) {
            super(0);
            this.a = glShaderStorageBuffer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            GLES20.glBufferData(UInt.m277constructorimpl(this.a.getTarget()), this.a.getSize(), null, UInt.m277constructorimpl(this.a.getUsage()));
            Egloo.checkGlError("glBufferData");
            return Unit.INSTANCE;
        }
    }

    public GlShaderStorageBuffer(int i, int i2) {
        super(GlKt.getGL_SHADER_STORAGE_BUFFER(), null, 2, null);
        this.c = i;
        this.d = i2;
        GlBindableKt.use(this, new a(this));
    }

    public final void bind(int i) {
        GLES30.glBindBufferBase(UInt.m277constructorimpl(getTarget()), UInt.m277constructorimpl(i), UInt.m277constructorimpl(getId()));
        Egloo.checkGlError("glBindBufferBase");
    }

    public final int getSize() {
        return this.c;
    }

    public final int getUsage() {
        return this.d;
    }

    public final void use(int i, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        bind(i);
        function0.invoke();
        unbind();
    }
}
