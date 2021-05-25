package com.otaliastudios.opengl.scene;

import a2.g.r.g;
import com.otaliastudios.opengl.core.Egloo;
import com.otaliastudios.opengl.core.GlViewportAware;
import com.otaliastudios.opengl.draw.GlDrawable;
import com.otaliastudios.opengl.internal.MiscKt;
import com.otaliastudios.opengl.program.GlProgram;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0011\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u0013J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u001f\u0010\u0014\u001a\u00020\t8\u0006@\u0006¢\u0006\u0012\n\u0004\b\u000f\u0010\u000b\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0018\u001a\u00020\t8\u0006@\u0006¢\u0006\u0012\n\u0004\b\u0015\u0010\u000b\u0012\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0016\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/otaliastudios/opengl/scene/GlScene;", "Lcom/otaliastudios/opengl/core/GlViewportAware;", "Lcom/otaliastudios/opengl/program/GlProgram;", "program", "Lcom/otaliastudios/opengl/draw/GlDrawable;", "drawable", "", "draw", "(Lcom/otaliastudios/opengl/program/GlProgram;Lcom/otaliastudios/opengl/draw/GlDrawable;)V", "", "f", "[F", "modelViewMatrix", g.a, "modelViewProjectionMatrix", "d", "getProjectionMatrix", "()[F", "getProjectionMatrix$annotations", "()V", "projectionMatrix", "e", "getViewMatrix", "getViewMatrix$annotations", "viewMatrix", "<init>", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public class GlScene extends GlViewportAware {
    @NotNull
    public final float[] d;
    @NotNull
    public final float[] e;
    public final float[] f = new float[16];
    public final float[] g = new float[16];

    public GlScene() {
        float[] fArr = Egloo.IDENTITY_MATRIX;
        this.d = MiscKt.matrixClone(fArr);
        this.e = MiscKt.matrixClone(fArr);
    }

    public static /* synthetic */ void getProjectionMatrix$annotations() {
    }

    public static /* synthetic */ void getViewMatrix$annotations() {
    }

    public final void draw(@NotNull GlProgram glProgram, @NotNull GlDrawable glDrawable) {
        Intrinsics.checkNotNullParameter(glProgram, "program");
        Intrinsics.checkNotNullParameter(glDrawable, "drawable");
        ensureViewportSize();
        glDrawable.setViewportSize(getViewportWidth(), getViewportHeight());
        MiscKt.matrixMultiply(this.f, this.e, glDrawable.getModelMatrix());
        MiscKt.matrixMultiply(this.g, this.d, this.f);
        glProgram.draw(glDrawable, this.g);
    }

    @NotNull
    public final float[] getProjectionMatrix() {
        return this.d;
    }

    @NotNull
    public final float[] getViewMatrix() {
        return this.e;
    }
}
