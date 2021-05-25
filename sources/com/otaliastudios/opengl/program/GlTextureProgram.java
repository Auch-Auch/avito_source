package com.otaliastudios.opengl.program;

import a2.b.a.a.a;
import a2.g.r.g;
import android.graphics.RectF;
import android.opengl.GLES20;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.otaliastudios.cameraview.filter.BaseFilter;
import com.otaliastudios.opengl.core.Egloo;
import com.otaliastudios.opengl.draw.Gl2dDrawable;
import com.otaliastudios.opengl.draw.GlDrawable;
import com.otaliastudios.opengl.internal.GlKt;
import com.otaliastudios.opengl.internal.MiscKt;
import com.otaliastudios.opengl.texture.GlTexture;
import com.otaliastudios.opengl.types.BuffersJvmKt;
import com.otaliastudios.opengl.types.BuffersKt;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\f\b\u0016\u0018\u0000 N2\u00020\u0001:\u0001NB=\b\u0004\u0012\u0006\u0010A\u001a\u00020\t\u0012\u0006\u0010B\u001a\u00020\u0010\u0012\u0006\u0010D\u001a\u00020C\u0012\u0006\u0010E\u001a\u00020C\u0012\b\u0010F\u001a\u0004\u0018\u00010C\u0012\b\u0010G\u001a\u0004\u0018\u00010C¢\u0006\u0004\bH\u0010IBI\b\u0017\u0012\b\b\u0002\u0010J\u001a\u00020C\u0012\b\b\u0002\u0010K\u001a\u00020C\u0012\b\b\u0002\u0010D\u001a\u00020C\u0012\b\b\u0002\u0010E\u001a\u00020C\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010C\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010C¢\u0006\u0004\bH\u0010LB=\b\u0017\u0012\u0006\u0010A\u001a\u00020\t\u0012\b\b\u0002\u0010D\u001a\u00020C\u0012\b\b\u0002\u0010E\u001a\u00020C\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010C\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010C¢\u0006\u0004\bH\u0010MJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ?\u0010\u0012\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010\u001aR\u001a\u0010*\u001a\u00060&j\u0002`'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010\u001aR\u0016\u0010/\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\"\u00106\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u0010;\u001a\u000607j\u0002`88\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010@\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010\u001a¨\u0006O"}, d2 = {"Lcom/otaliastudios/opengl/program/GlTextureProgram;", "Lcom/otaliastudios/opengl/program/GlProgram;", "Lcom/otaliastudios/opengl/draw/GlDrawable;", "drawable", "", "modelViewProjectionMatrix", "", "onPreDraw", "(Lcom/otaliastudios/opengl/draw/GlDrawable;[F)V", "", "vertex", "Lcom/otaliastudios/opengl/draw/Gl2dDrawable;", "", "value", "min", "max", "", MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL, "computeTextureCoordinate", "(ILcom/otaliastudios/opengl/draw/Gl2dDrawable;FFFZ)F", "onPostDraw", "(Lcom/otaliastudios/opengl/draw/GlDrawable;)V", "release", "()V", "Lcom/otaliastudios/opengl/program/GlProgramLocation;", "i", "Lcom/otaliastudios/opengl/program/GlProgramLocation;", "vertexPositionHandle", "Lcom/otaliastudios/opengl/texture/GlTexture;", "n", "Lcom/otaliastudios/opengl/texture/GlTexture;", "getTexture", "()Lcom/otaliastudios/opengl/texture/GlTexture;", "setTexture", "(Lcom/otaliastudios/opengl/texture/GlTexture;)V", "texture", "j", "vertexMvpMatrixHandle", "Landroid/graphics/RectF;", "Lcom/otaliastudios/opengl/geometry/RectF;", "k", "Landroid/graphics/RectF;", "lastDrawableBounds", "f", "textureTransformHandle", "l", "I", "lastDrawableVersion", "e", "[F", "getTextureTransform", "()[F", "setTextureTransform", "([F)V", "textureTransform", "Ljava/nio/FloatBuffer;", "Lcom/otaliastudios/opengl/types/FloatBuffer;", g.a, "Ljava/nio/FloatBuffer;", "textureCoordsBuffer", AuthSource.OPEN_CHANNEL_LIST, "Lcom/otaliastudios/opengl/draw/Gl2dDrawable;", "lastDrawable", "h", "textureCoordsHandle", "handle", "ownsHandle", "", "vertexPositionName", "vertexMvpMatrixName", "textureCoordsName", "textureTransformName", "<init>", "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "vertexShader", "fragmentShader", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public class GlTextureProgram extends GlProgram {
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String SIMPLE_FRAGMENT_SHADER = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    @NotNull
    public static final String SIMPLE_VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";
    @NotNull
    public float[] e;
    public final GlProgramLocation f;
    public FloatBuffer g;
    public final GlProgramLocation h;
    public final GlProgramLocation i;
    public final GlProgramLocation j;
    public final RectF k;
    public int l;
    public Gl2dDrawable m;
    @Nullable
    public GlTexture n;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/otaliastudios/opengl/program/GlTextureProgram$Companion;", "", "", "SIMPLE_FRAGMENT_SHADER", "Ljava/lang/String;", "SIMPLE_VERTEX_SHADER", "<init>", "()V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @JvmOverloads
    public GlTextureProgram() {
        this(null, null, null, null, null, null, 63, null);
    }

    @JvmOverloads
    public GlTextureProgram(int i2) {
        this(i2, null, null, null, null, 30, null);
    }

    @JvmOverloads
    public GlTextureProgram(int i2, @NotNull String str) {
        this(i2, str, null, null, null, 28, null);
    }

    @JvmOverloads
    public GlTextureProgram(int i2, @NotNull String str, @NotNull String str2) {
        this(i2, str, str2, null, null, 24, null);
    }

    @JvmOverloads
    public GlTextureProgram(int i2, @NotNull String str, @NotNull String str2, @Nullable String str3) {
        this(i2, str, str2, str3, null, 16, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlTextureProgram(int i2, boolean z, @NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4) {
        super(i2, z, new GlShader[0]);
        Intrinsics.checkNotNullParameter(str, "vertexPositionName");
        Intrinsics.checkNotNullParameter(str2, "vertexMvpMatrixName");
        this.e = MiscKt.matrixClone(Egloo.IDENTITY_MATRIX);
        GlProgramLocation glProgramLocation = null;
        this.f = str4 != null ? getUniformHandle(str4) : null;
        this.g = BuffersJvmKt.floatBuffer(8);
        this.h = str3 != null ? getAttribHandle(str3) : glProgramLocation;
        this.i = getAttribHandle(str);
        this.j = getUniformHandle(str2);
        this.k = new RectF();
        this.l = -1;
    }

    @JvmOverloads
    public GlTextureProgram(@NotNull String str) {
        this(str, null, null, null, null, null, 62, null);
    }

    @JvmOverloads
    public GlTextureProgram(@NotNull String str, @NotNull String str2) {
        this(str, str2, null, null, null, null, 60, null);
    }

    @JvmOverloads
    public GlTextureProgram(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        this(str, str2, str3, null, null, null, 56, null);
    }

    @JvmOverloads
    public GlTextureProgram(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        this(str, str2, str3, str4, null, null, 48, null);
    }

    @JvmOverloads
    public GlTextureProgram(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable String str5) {
        this(str, str2, str3, str4, str5, null, 32, null);
    }

    public float computeTextureCoordinate(int i2, @NotNull Gl2dDrawable gl2dDrawable, float f2, float f3, float f4, boolean z) {
        Intrinsics.checkNotNullParameter(gl2dDrawable, "drawable");
        return (((f2 - f3) / (f4 - f3)) * 1.0f) + 0.0f;
    }

    @Nullable
    public final GlTexture getTexture() {
        return this.n;
    }

    @NotNull
    public final float[] getTextureTransform() {
        return this.e;
    }

    @Override // com.otaliastudios.opengl.program.GlProgram
    public void onPostDraw(@NotNull GlDrawable glDrawable) {
        Intrinsics.checkNotNullParameter(glDrawable, "drawable");
        super.onPostDraw(glDrawable);
        GLES20.glDisableVertexAttribArray(this.i.m189getUvaluepVg5ArA$egloo_metadata_release());
        GlProgramLocation glProgramLocation = this.h;
        if (glProgramLocation != null) {
            GLES20.glDisableVertexAttribArray(glProgramLocation.m189getUvaluepVg5ArA$egloo_metadata_release());
        }
        GlTexture glTexture = this.n;
        if (glTexture != null) {
            glTexture.unbind();
        }
        Egloo.checkGlError("onPostDraw end");
    }

    @Override // com.otaliastudios.opengl.program.GlProgram
    public void onPreDraw(@NotNull GlDrawable glDrawable, @NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(glDrawable, "drawable");
        Intrinsics.checkNotNullParameter(fArr, "modelViewProjectionMatrix");
        super.onPreDraw(glDrawable, fArr);
        if (glDrawable instanceof Gl2dDrawable) {
            GlTexture glTexture = this.n;
            if (glTexture != null) {
                glTexture.bind();
            }
            GLES20.glUniformMatrix4fv(this.j.getValue(), 1, false, fArr, 0);
            Egloo.checkGlError("glUniformMatrix4fv");
            GlProgramLocation glProgramLocation = this.f;
            if (glProgramLocation != null) {
                GLES20.glUniformMatrix4fv(glProgramLocation.getValue(), 1, false, this.e, 0);
                Egloo.checkGlError("glUniformMatrix4fv");
            }
            GlProgramLocation glProgramLocation2 = this.i;
            GLES20.glEnableVertexAttribArray(glProgramLocation2.m189getUvaluepVg5ArA$egloo_metadata_release());
            Egloo.checkGlError("glEnableVertexAttribArray");
            GLES20.glVertexAttribPointer(glProgramLocation2.m189getUvaluepVg5ArA$egloo_metadata_release(), 2, GlKt.getGL_FLOAT(), false, glDrawable.getVertexStride(), (Buffer) glDrawable.getVertexArray());
            Egloo.checkGlError("glVertexAttribPointer");
            GlProgramLocation glProgramLocation3 = this.h;
            if (glProgramLocation3 != null) {
                if ((!Intrinsics.areEqual(glDrawable, this.m)) || glDrawable.getVertexArrayVersion() != this.l) {
                    Gl2dDrawable gl2dDrawable = (Gl2dDrawable) glDrawable;
                    this.m = gl2dDrawable;
                    this.l = glDrawable.getVertexArrayVersion();
                    gl2dDrawable.getBounds(this.k);
                    int vertexCount = glDrawable.getVertexCount() * 2;
                    if (this.g.capacity() < vertexCount) {
                        BuffersKt.dispose(this.g);
                        this.g = BuffersJvmKt.floatBuffer(vertexCount);
                    }
                    this.g.clear();
                    this.g.limit(vertexCount);
                    for (int i2 = 0; i2 < vertexCount; i2++) {
                        boolean z = i2 % 2 == 0;
                        float f2 = glDrawable.getVertexArray().get(i2);
                        RectF rectF = this.k;
                        float f3 = z ? rectF.left : rectF.bottom;
                        RectF rectF2 = this.k;
                        this.g.put(computeTextureCoordinate(i2 / 2, gl2dDrawable, f2, f3, z ? rectF2.right : rectF2.top, z));
                    }
                }
                this.g.rewind();
                GLES20.glEnableVertexAttribArray(glProgramLocation3.m189getUvaluepVg5ArA$egloo_metadata_release());
                Egloo.checkGlError("glEnableVertexAttribArray");
                GLES20.glVertexAttribPointer(glProgramLocation3.m189getUvaluepVg5ArA$egloo_metadata_release(), 2, GlKt.getGL_FLOAT(), false, glDrawable.getVertexStride(), (Buffer) this.g);
                Egloo.checkGlError("glVertexAttribPointer");
                return;
            }
            return;
        }
        throw new RuntimeException("GlTextureProgram only supports 2D drawables.");
    }

    @Override // com.otaliastudios.opengl.program.GlProgram
    public void release() {
        super.release();
        BuffersKt.dispose(this.g);
        GlTexture glTexture = this.n;
        if (glTexture != null) {
            glTexture.release();
        }
        this.n = null;
    }

    public final void setTexture(@Nullable GlTexture glTexture) {
        this.n = glTexture;
    }

    public final void setTextureTransform(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.e = fArr;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlTextureProgram(String str, String str2, String str3, String str4, String str5, String str6, int i2, j jVar) {
        this((i2 & 1) != 0 ? SIMPLE_VERTEX_SHADER : str, (i2 & 2) != 0 ? SIMPLE_FRAGMENT_SHADER : str2, (i2 & 4) != 0 ? BaseFilter.DEFAULT_VERTEX_POSITION_NAME : str3, (i2 & 8) != 0 ? BaseFilter.DEFAULT_VERTEX_MVP_MATRIX_NAME : str4, (i2 & 16) != 0 ? BaseFilter.DEFAULT_VERTEX_TEXTURE_COORDINATE_NAME : str5, (i2 & 32) != 0 ? BaseFilter.DEFAULT_VERTEX_TRANSFORM_MATRIX_NAME : str6);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GlTextureProgram(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable String str5, @Nullable String str6) {
        this(GlProgram.Companion.create(str, str2), true, str3, str4, str5, str6);
        a.b1(str, "vertexShader", str2, "fragmentShader", str3, "vertexPositionName", str4, "vertexMvpMatrixName");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlTextureProgram(int i2, String str, String str2, String str3, String str4, int i3, j jVar) {
        this(i2, (i3 & 2) != 0 ? BaseFilter.DEFAULT_VERTEX_POSITION_NAME : str, (i3 & 4) != 0 ? BaseFilter.DEFAULT_VERTEX_MVP_MATRIX_NAME : str2, (i3 & 8) != 0 ? BaseFilter.DEFAULT_VERTEX_TEXTURE_COORDINATE_NAME : str3, (i3 & 16) != 0 ? BaseFilter.DEFAULT_VERTEX_TRANSFORM_MATRIX_NAME : str4);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GlTextureProgram(int i2, @NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4) {
        this(i2, false, str, str2, str3, str4);
        Intrinsics.checkNotNullParameter(str, "vertexPositionName");
        Intrinsics.checkNotNullParameter(str2, "vertexMvpMatrixName");
    }
}
