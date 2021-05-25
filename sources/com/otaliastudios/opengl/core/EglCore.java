package com.otaliastudios.opengl.core;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import com.otaliastudios.opengl.internal.EglContext;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u001f\b\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0004¢\u0006\u0004\b\u0006\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/otaliastudios/opengl/core/EglCore;", "Lcom/otaliastudios/opengl/core/EglNativeCore;", "", "release", "()V", "makeCurrent", "finalize", "Landroid/opengl/EGLContext;", "sharedContext", "", "flags", "<init>", "(Landroid/opengl/EGLContext;I)V", "Companion", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public final class EglCore extends EglNativeCore {
    public static final Companion Companion = new Companion(null);
    public static final int FLAG_RECORDABLE = 1;
    public static final int FLAG_TRY_GLES3 = 2;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/otaliastudios/opengl/core/EglCore$Companion;", "", "", "FLAG_RECORDABLE", "I", "FLAG_TRY_GLES3", "<init>", "()V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @JvmOverloads
    public EglCore() {
        this(null, 0, 3, null);
    }

    @JvmOverloads
    public EglCore(@Nullable EGLContext eGLContext) {
        this(eGLContext, 0, 2, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EglCore(EGLContext eGLContext, int i, int i2, j jVar) {
        this((i2 & 1) != 0 ? EGL14.EGL_NO_CONTEXT : eGLContext, (i2 & 2) != 0 ? 0 : i);
    }

    public final void finalize() {
        release$egloo_metadata_release();
    }

    /* renamed from: makeCurrent */
    public void makeCurrent$egloo_metadata_release() {
        super.makeCurrent$egloo_metadata_release();
    }

    /* renamed from: release */
    public void release$egloo_metadata_release() {
        super.release$egloo_metadata_release();
    }

    @JvmOverloads
    public EglCore(@Nullable EGLContext eGLContext, int i) {
        super(new EglContext(eGLContext), i);
    }
}
