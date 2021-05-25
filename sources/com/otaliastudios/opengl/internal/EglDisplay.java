package com.otaliastudios.opengl.internal;

import a2.b.a.a.a;
import android.opengl.EGLDisplay;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/otaliastudios/opengl/internal/EglDisplay;", "", "Landroid/opengl/EGLDisplay;", "component1", "()Landroid/opengl/EGLDisplay;", AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, "copy", "(Landroid/opengl/EGLDisplay;)Lcom/otaliastudios/opengl/internal/EglDisplay;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Landroid/opengl/EGLDisplay;", "getNative", "<init>", "(Landroid/opengl/EGLDisplay;)V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public final class EglDisplay {
    @Nullable
    public final EGLDisplay a;

    public EglDisplay(@Nullable EGLDisplay eGLDisplay) {
        this.a = eGLDisplay;
    }

    public static /* synthetic */ EglDisplay copy$default(EglDisplay eglDisplay, EGLDisplay eGLDisplay, int i, Object obj) {
        if ((i & 1) != 0) {
            eGLDisplay = eglDisplay.a;
        }
        return eglDisplay.copy(eGLDisplay);
    }

    @Nullable
    public final EGLDisplay component1() {
        return this.a;
    }

    @NotNull
    public final EglDisplay copy(@Nullable EGLDisplay eGLDisplay) {
        return new EglDisplay(eGLDisplay);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof EglDisplay) && Intrinsics.areEqual(this.a, ((EglDisplay) obj).a);
        }
        return true;
    }

    @Nullable
    public final EGLDisplay getNative() {
        return this.a;
    }

    public int hashCode() {
        EGLDisplay eGLDisplay = this.a;
        if (eGLDisplay != null) {
            return eGLDisplay.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("EglDisplay(native=");
        L.append(this.a);
        L.append(")");
        return L.toString();
    }
}
