package com.otaliastudios.opengl.core;

import android.opengl.GLES20;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.otaliastudios.opengl.internal.GlKt;
import kotlin.Metadata;
import kotlin.UInt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0011\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\tJ\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0004¢\u0006\u0004\b\n\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR*\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00028\u0006@DX\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00028\u0006@DX\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/otaliastudios/opengl/core/GlViewportAware;", "", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "", "setViewportSize", "(II)V", "onViewportSizeChanged", "()V", "ensureViewportSize", "", AuthSource.SEND_ABUSE, "[I", "viewportArray", "<set-?>", AuthSource.BOOKING_ORDER, "I", "getViewportWidth", "()I", "setViewportWidth", "(I)V", "viewportWidth", "c", "getViewportHeight", "setViewportHeight", "viewportHeight", "<init>", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public abstract class GlViewportAware {
    public final int[] a = new int[4];
    public int b = -1;
    public int c = -1;

    public final void ensureViewportSize() {
        if (this.c == -1 || this.b == -1) {
            GLES20.glGetIntegerv(UInt.m277constructorimpl(GlKt.getGL_VIEWPORT()), this.a, 0);
            int[] iArr = this.a;
            setViewportSize(iArr[2], iArr[3]);
        }
    }

    public final int getViewportHeight() {
        return this.c;
    }

    public final int getViewportWidth() {
        return this.b;
    }

    public void onViewportSizeChanged() {
    }

    public final void setViewportHeight(int i) {
        this.c = i;
    }

    public final void setViewportSize(int i, int i2) {
        if (i != this.b || i2 != this.c) {
            this.b = i;
            this.c = i2;
            onViewportSizeChanged();
        }
    }

    public final void setViewportWidth(int i) {
        this.b = i;
    }
}
