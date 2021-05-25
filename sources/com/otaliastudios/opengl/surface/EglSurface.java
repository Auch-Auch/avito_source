package com.otaliastudios.opengl.surface;

import android.graphics.Bitmap;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import com.otaliastudios.opengl.core.EglCore;
import com.otaliastudios.opengl.core.Egloo;
import com.sumsub.sns.R2;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0019\b\u0000\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015B\u0019\b\u0014\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0016¢\u0006\u0004\b\u0014\u0010\u0017J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/otaliastudios/opengl/surface/EglSurface;", "Lcom/otaliastudios/opengl/surface/EglNativeSurface;", "Ljava/io/OutputStream;", "stream", "Landroid/graphics/Bitmap$CompressFormat;", "format", "", "toOutputStream", "(Ljava/io/OutputStream;Landroid/graphics/Bitmap$CompressFormat;)V", "Ljava/io/File;", "file", "toFile", "(Ljava/io/File;Landroid/graphics/Bitmap$CompressFormat;)V", "", "toByteArray", "(Landroid/graphics/Bitmap$CompressFormat;)[B", "Lcom/otaliastudios/opengl/core/EglCore;", "eglCore", "Lcom/otaliastudios/opengl/internal/EglSurface;", "eglSurface", "<init>", "(Lcom/otaliastudios/opengl/core/EglCore;Lcom/otaliastudios/opengl/internal/EglSurface;)V", "Landroid/opengl/EGLSurface;", "(Lcom/otaliastudios/opengl/core/EglCore;Landroid/opengl/EGLSurface;)V", "Companion", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
public abstract class EglSurface extends EglNativeSurface {
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\bR\"\u0010\u0003\u001a\u00020\u00028\u0004@\u0004X\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/otaliastudios/opengl/surface/EglSurface$Companion;", "", "", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "getTAG$annotations", "()V", "<init>", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public static /* synthetic */ void getTAG$annotations() {
        }

        @NotNull
        public final String getTAG() {
            return EglSurface.e;
        }

        public Companion(j jVar) {
        }
    }

    static {
        String simpleName = com.otaliastudios.opengl.internal.EglSurface.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "EglSurface::class.java.simpleName");
        e = simpleName;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EglSurface(@NotNull EglCore eglCore, @NotNull com.otaliastudios.opengl.internal.EglSurface eglSurface) {
        super(eglCore, eglSurface);
        Intrinsics.checkNotNullParameter(eglCore, "eglCore");
        Intrinsics.checkNotNullParameter(eglSurface, "eglSurface");
    }

    public static /* synthetic */ byte[] toByteArray$default(EglSurface eglSurface, Bitmap.CompressFormat compressFormat, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                compressFormat = Bitmap.CompressFormat.PNG;
            }
            return eglSurface.toByteArray(compressFormat);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toByteArray");
    }

    public static /* synthetic */ void toFile$default(EglSurface eglSurface, File file, Bitmap.CompressFormat compressFormat, int i, Object obj) throws IOException {
        if (obj == null) {
            if ((i & 2) != 0) {
                compressFormat = Bitmap.CompressFormat.PNG;
            }
            eglSurface.toFile(file, compressFormat);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toFile");
    }

    public static /* synthetic */ void toOutputStream$default(EglSurface eglSurface, OutputStream outputStream, Bitmap.CompressFormat compressFormat, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                compressFormat = Bitmap.CompressFormat.PNG;
            }
            eglSurface.toOutputStream(outputStream, compressFormat);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toOutputStream");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r3);
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] toByteArray(@org.jetbrains.annotations.NotNull android.graphics.Bitmap.CompressFormat r3) {
        /*
            r2 = this;
            java.lang.String r0 = "format"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r2.toOutputStream(r0, r3)     // Catch:{ all -> 0x001b }
            byte[] r3 = r0.toByteArray()     // Catch:{ all -> 0x001b }
            java.lang.String r1 = "it.toByteArray()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)     // Catch:{ all -> 0x001b }
            r1 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            return r3
        L_0x001b:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x001d }
        L_0x001d:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.opengl.surface.EglSurface.toByteArray(android.graphics.Bitmap$CompressFormat):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void toFile(@org.jetbrains.annotations.NotNull java.io.File r4, @org.jetbrains.annotations.NotNull android.graphics.Bitmap.CompressFormat r5) throws java.io.IOException {
        /*
            r3 = this;
            java.lang.String r0 = "file"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "format"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 0
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0023 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x0023 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0023 }
            r2.<init>(r4)     // Catch:{ all -> 0x0023 }
            r1.<init>(r2)     // Catch:{ all -> 0x0023 }
            r3.toOutputStream(r1, r5)     // Catch:{ all -> 0x0020 }
            r1.close()
            return
        L_0x0020:
            r4 = move-exception
            r0 = r1
            goto L_0x0024
        L_0x0023:
            r4 = move-exception
        L_0x0024:
            if (r0 == 0) goto L_0x0029
            r0.close()
        L_0x0029:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.opengl.surface.EglSurface.toFile(java.io.File, android.graphics.Bitmap$CompressFormat):void");
    }

    public final void toOutputStream(@NotNull OutputStream outputStream, @NotNull Bitmap.CompressFormat compressFormat) {
        Intrinsics.checkNotNullParameter(outputStream, "stream");
        Intrinsics.checkNotNullParameter(compressFormat, "format");
        if (isCurrent()) {
            int width = getWidth();
            int height = getHeight();
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(width * height * 4);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            GLES20.glReadPixels(0, 0, width, height, 6408, R2.styleable.MockView_mock_labelColor, allocateDirect);
            Egloo.checkGlError("glReadPixels");
            allocateDirect.rewind();
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(allocateDirect);
            createBitmap.compress(compressFormat, 90, outputStream);
            createBitmap.recycle();
            return;
        }
        throw new RuntimeException("Expected EGL context/surface is not current");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EglSurface(@NotNull EglCore eglCore, @NotNull EGLSurface eGLSurface) {
        this(eglCore, new com.otaliastudios.opengl.internal.EglSurface(eGLSurface));
        Intrinsics.checkNotNullParameter(eglCore, "eglCore");
        Intrinsics.checkNotNullParameter(eGLSurface, "eglSurface");
    }
}
