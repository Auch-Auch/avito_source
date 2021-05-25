package com.otaliastudios.opengl.program;

import a2.g.r.g;
import android.opengl.GLES20;
import com.otaliastudios.cameraview.filter.BaseFilter;
import com.otaliastudios.opengl.core.Egloo;
import com.otaliastudios.opengl.draw.GlDrawable;
import com.otaliastudios.opengl.internal.GlKt;
import java.nio.Buffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u001c\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR(\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\u000b\u0010\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/otaliastudios/opengl/program/GlNativeFlatProgram;", "Lcom/otaliastudios/opengl/program/GlProgram;", "Lcom/otaliastudios/opengl/draw/GlDrawable;", "drawable", "", "modelViewProjectionMatrix", "", "onPreDraw", "(Lcom/otaliastudios/opengl/draw/GlDrawable;[F)V", "onPostDraw", "(Lcom/otaliastudios/opengl/draw/GlDrawable;)V", "h", "[F", "getColor", "()[F", "setColor", "([F)V", "getColor$annotations", "()V", "color", "Lcom/otaliastudios/opengl/program/GlProgramLocation;", "f", "Lcom/otaliastudios/opengl/program/GlProgramLocation;", "vertexMvpMatrixHandle", "e", "vertexPositionHandle", g.a, "fragmentColorHandle", "<init>", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public class GlNativeFlatProgram extends GlProgram {
    public final GlProgramLocation e = getAttribHandle(BaseFilter.DEFAULT_VERTEX_POSITION_NAME);
    public final GlProgramLocation f = getUniformHandle(BaseFilter.DEFAULT_VERTEX_MVP_MATRIX_NAME);
    public final GlProgramLocation g = getUniformHandle("uColor");
    @NotNull
    public float[] h = {1.0f, 1.0f, 1.0f, 1.0f};

    public GlNativeFlatProgram() {
        super("uniform mat4 uMVPMatrix;\nattribute vec4 aPosition;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n}\n", "precision mediump float;\nuniform vec4 uColor;\nvoid main() {\n    gl_FragColor = uColor;\n}\n");
    }

    public static /* synthetic */ void getColor$annotations() {
    }

    @NotNull
    public final float[] getColor() {
        return this.h;
    }

    @Override // com.otaliastudios.opengl.program.GlProgram
    public void onPostDraw(@NotNull GlDrawable glDrawable) {
        Intrinsics.checkNotNullParameter(glDrawable, "drawable");
        super.onPostDraw(glDrawable);
        GLES20.glDisableVertexAttribArray(this.e.m189getUvaluepVg5ArA$egloo_metadata_release());
    }

    @Override // com.otaliastudios.opengl.program.GlProgram
    public void onPreDraw(@NotNull GlDrawable glDrawable, @NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(glDrawable, "drawable");
        Intrinsics.checkNotNullParameter(fArr, "modelViewProjectionMatrix");
        super.onPreDraw(glDrawable, fArr);
        GLES20.glUniformMatrix4fv(this.f.getValue(), 1, false, fArr, 0);
        Egloo.checkGlError("glUniformMatrix4fv");
        GLES20.glUniform4fv(this.g.getValue(), 1, this.h, 0);
        Egloo.checkGlError("glUniform4fv");
        GLES20.glEnableVertexAttribArray(this.e.m189getUvaluepVg5ArA$egloo_metadata_release());
        Egloo.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.e.m189getUvaluepVg5ArA$egloo_metadata_release(), glDrawable.getCoordsPerVertex(), GlKt.getGL_FLOAT(), false, glDrawable.getVertexStride(), (Buffer) glDrawable.getVertexArray());
        Egloo.checkGlError("glVertexAttribPointer");
    }

    public final void setColor(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.h = fArr;
    }
}
