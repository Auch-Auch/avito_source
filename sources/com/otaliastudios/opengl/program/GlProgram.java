package com.otaliastudios.opengl.program;

import android.opengl.GLES20;
import com.avito.android.remote.auth.AuthSource;
import com.otaliastudios.opengl.core.Egloo;
import com.otaliastudios.opengl.core.GlBindable;
import com.otaliastudios.opengl.core.GlBindableKt;
import com.otaliastudios.opengl.draw.GlDrawable;
import com.otaliastudios.opengl.internal.GlKt;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 /2\u00020\u0001:\u0001/B-\b\u0004\u0012\u0006\u0010\"\u001a\u00020\u001d\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020$0#\"\u00020$¢\u0006\u0004\b(\u0010)B\u0011\b\u0016\u0012\u0006\u0010\"\u001a\u00020\u001d¢\u0006\u0004\b(\u0010*B\u0019\b\u0016\u0012\u0006\u0010+\u001a\u00020\u0011\u0012\u0006\u0010,\u001a\u00020\u0011¢\u0006\u0004\b(\u0010-B\u001d\b\u0016\u0012\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020$0#\"\u00020$¢\u0006\u0004\b(\u0010.J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J!\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0004¢\u0006\u0004\b\u0016\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0019\u0010\"\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001e\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020$0#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u00060"}, d2 = {"Lcom/otaliastudios/opengl/program/GlProgram;", "Lcom/otaliastudios/opengl/core/GlBindable;", "", "release", "()V", "bind", "unbind", "Lcom/otaliastudios/opengl/draw/GlDrawable;", "drawable", "", "modelViewProjectionMatrix", "draw", "(Lcom/otaliastudios/opengl/draw/GlDrawable;[F)V", "onPreDraw", "onDraw", "(Lcom/otaliastudios/opengl/draw/GlDrawable;)V", "onPostDraw", "", "name", "Lcom/otaliastudios/opengl/program/GlProgramLocation;", "getAttribHandle", "(Ljava/lang/String;)Lcom/otaliastudios/opengl/program/GlProgramLocation;", "getUniformHandle", "", AuthSource.SEND_ABUSE, "Z", "isReleased", "c", "ownsHandle", "", AuthSource.BOOKING_ORDER, "I", "getHandle", "()I", "handle", "", "Lcom/otaliastudios/opengl/program/GlShader;", "d", "[Lcom/otaliastudios/opengl/program/GlShader;", "shaders", "<init>", "(IZ[Lcom/otaliastudios/opengl/program/GlShader;)V", "(I)V", "vertexShader", "fragmentShader", "(Ljava/lang/String;Ljava/lang/String;)V", "([Lcom/otaliastudios/opengl/program/GlShader;)V", "Companion", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public class GlProgram implements GlBindable {
    public static final Companion Companion = new Companion(null);
    public boolean a;
    public final int b;
    public final boolean c;
    public final GlShader[] d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u0006\u001a\u00020\u00052\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0007¢\u0006\u0004\b\u0006\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/otaliastudios/opengl/program/GlProgram$Companion;", "", "", "vertexShaderSource", "fragmentShaderSource", "", "create", "(Ljava/lang/String;Ljava/lang/String;)I", "", "Lcom/otaliastudios/opengl/program/GlShader;", "shaders", "([Lcom/otaliastudios/opengl/program/GlShader;)I", "<init>", "()V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        @Deprecated(message = "Use create(GlShader) signature.")
        @JvmStatic
        public final int create(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "vertexShaderSource");
            Intrinsics.checkNotNullParameter(str2, "fragmentShaderSource");
            return create(new GlShader(GlKt.getGL_VERTEX_SHADER(), str), new GlShader(GlKt.getGL_FRAGMENT_SHADER(), str2));
        }

        public Companion(j jVar) {
        }

        @JvmStatic
        public final int create(@NotNull GlShader... glShaderArr) {
            Intrinsics.checkNotNullParameter(glShaderArr, "shaders");
            int r0 = UInt.m277constructorimpl(GLES20.glCreateProgram());
            Egloo.checkGlError("glCreateProgram");
            if (r0 != 0) {
                for (GlShader glShader : glShaderArr) {
                    GLES20.glAttachShader(r0, UInt.m277constructorimpl(glShader.getId()));
                    Egloo.checkGlError("glAttachShader");
                }
                GLES20.glLinkProgram(r0);
                int[] iArr = new int[1];
                GLES20.glGetProgramiv(r0, GlKt.getGL_LINK_STATUS(), iArr, 0);
                if (iArr[0] == GlKt.getGL_TRUE()) {
                    return r0;
                }
                StringBuilder L = a2.b.a.a.a.L("Could not link program: ");
                L.append(GLES20.glGetProgramInfoLog(r0));
                String sb = L.toString();
                GLES20.glDeleteProgram(r0);
                throw new RuntimeException(sb);
            }
            throw new RuntimeException("Could not create program");
        }
    }

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ GlProgram a;
        public final /* synthetic */ GlDrawable b;
        public final /* synthetic */ float[] c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(GlProgram glProgram, GlDrawable glDrawable, float[] fArr) {
            super(0);
            this.a = glProgram;
            this.b = glDrawable;
            this.c = fArr;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.onPreDraw(this.b, this.c);
            this.a.onDraw(this.b);
            this.a.onPostDraw(this.b);
            return Unit.INSTANCE;
        }
    }

    public GlProgram(int i, boolean z, @NotNull GlShader... glShaderArr) {
        Intrinsics.checkNotNullParameter(glShaderArr, "shaders");
        this.b = i;
        this.c = z;
        this.d = glShaderArr;
    }

    @Deprecated(message = "Use create(GlShader) signature.")
    @JvmStatic
    public static final int create(@NotNull String str, @NotNull String str2) {
        return Companion.create(str, str2);
    }

    @JvmStatic
    public static final int create(@NotNull GlShader... glShaderArr) {
        return Companion.create(glShaderArr);
    }

    public static /* synthetic */ void draw$default(GlProgram glProgram, GlDrawable glDrawable, float[] fArr, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                fArr = glDrawable.getModelMatrix();
            }
            glProgram.draw(glDrawable, fArr);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: draw");
    }

    @Override // com.otaliastudios.opengl.core.GlBindable
    public void bind() {
        GLES20.glUseProgram(UInt.m277constructorimpl(this.b));
        Egloo.checkGlError("glUseProgram");
    }

    @JvmOverloads
    public final void draw(@NotNull GlDrawable glDrawable) {
        draw$default(this, glDrawable, null, 2, null);
    }

    @JvmOverloads
    public final void draw(@NotNull GlDrawable glDrawable, @NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(glDrawable, "drawable");
        Intrinsics.checkNotNullParameter(fArr, "modelViewProjectionMatrix");
        Egloo.checkGlError("draw start");
        GlBindableKt.use(this, new a(this, glDrawable, fArr));
        Egloo.checkGlError("draw end");
    }

    @NotNull
    public final GlProgramLocation getAttribHandle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return GlProgramLocation.Companion.getAttrib(this.b, str);
    }

    public final int getHandle() {
        return this.b;
    }

    @NotNull
    public final GlProgramLocation getUniformHandle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return GlProgramLocation.Companion.getUniform(this.b, str);
    }

    public void onDraw(@NotNull GlDrawable glDrawable) {
        Intrinsics.checkNotNullParameter(glDrawable, "drawable");
        glDrawable.draw();
    }

    public void onPostDraw(@NotNull GlDrawable glDrawable) {
        Intrinsics.checkNotNullParameter(glDrawable, "drawable");
    }

    public void onPreDraw(@NotNull GlDrawable glDrawable, @NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(glDrawable, "drawable");
        Intrinsics.checkNotNullParameter(fArr, "modelViewProjectionMatrix");
    }

    public void release() {
        if (!this.a) {
            if (this.c) {
                GLES20.glDeleteProgram(UInt.m277constructorimpl(this.b));
            }
            for (GlShader glShader : this.d) {
                glShader.release();
            }
            this.a = true;
        }
    }

    @Override // com.otaliastudios.opengl.core.GlBindable
    public void unbind() {
        GLES20.glUseProgram(0);
    }

    public GlProgram(int i) {
        this(i, false, new GlShader[0]);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GlProgram(@NotNull String str, @NotNull String str2) {
        this(new GlShader(GlKt.getGL_VERTEX_SHADER(), str), new GlShader(GlKt.getGL_FRAGMENT_SHADER(), str2));
        Intrinsics.checkNotNullParameter(str, "vertexShader");
        Intrinsics.checkNotNullParameter(str2, "fragmentShader");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GlProgram(@NotNull GlShader... glShaderArr) {
        this(Companion.create((GlShader[]) Arrays.copyOf(glShaderArr, glShaderArr.length)), true, (GlShader[]) Arrays.copyOf(glShaderArr, glShaderArr.length));
        Intrinsics.checkNotNullParameter(glShaderArr, "shaders");
    }
}
