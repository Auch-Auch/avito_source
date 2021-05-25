package com.otaliastudios.opengl.extensions;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.otaliastudios.opengl.types.BuffersJvmKt;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0005\u001a\u0015\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0003\u001a\u00060\u0006j\u0002`\u0007*\u00020\u0005¢\u0006\u0004\b\u0003\u0010\b\u001a\u0015\u0010\u0003\u001a\u00060\nj\u0002`\u000b*\u00020\t¢\u0006\u0004\b\u0003\u0010\f\u001a\u0015\u0010\u0003\u001a\u00060\u000ej\u0002`\u000f*\u00020\r¢\u0006\u0004\b\u0003\u0010\u0010\u001a\u001d\u0010\u0013\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u0012\u001a\u00020\u0000\"\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0004\u001a\u001d\u0010\u0015\u001a\u00060\u0006j\u0002`\u00072\n\u0010\u0012\u001a\u00020\u0005\"\u00020\u0014¢\u0006\u0004\b\u0015\u0010\b\u001a\u001d\u0010\u0017\u001a\u00060\nj\u0002`\u000b2\n\u0010\u0012\u001a\u00020\t\"\u00020\u0016¢\u0006\u0004\b\u0017\u0010\f\u001a\u001d\u0010\u0019\u001a\u00060\u000ej\u0002`\u000f2\n\u0010\u0012\u001a\u00020\r\"\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u0010\u001a\u001b\u0010\u0013\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u001a\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u0013\u0010\u001b\u001a\u001b\u0010\u0019\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u001a\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u0019\u0010\u001c¨\u0006\u001d"}, d2 = {"", "Ljava/nio/FloatBuffer;", "Lcom/otaliastudios/opengl/types/FloatBuffer;", "toBuffer", "([F)Ljava/nio/FloatBuffer;", "", "Ljava/nio/ShortBuffer;", "Lcom/otaliastudios/opengl/types/ShortBuffer;", "([S)Ljava/nio/ShortBuffer;", "", "Ljava/nio/IntBuffer;", "Lcom/otaliastudios/opengl/types/IntBuffer;", "([I)Ljava/nio/IntBuffer;", "", "Ljava/nio/ByteBuffer;", "Lcom/otaliastudios/opengl/types/ByteBuffer;", "([B)Ljava/nio/ByteBuffer;", "", MessengerShareContentUtility.ELEMENTS, "floatBufferOf", "", "shortBufferOf", "", "intBufferOf", "", "byteBufferOf", "size", "(I)Ljava/nio/FloatBuffer;", "(I)Ljava/nio/ByteBuffer;", "egloo-metadata_release"}, k = 2, mv = {1, 4, 0})
public final class BuffersKt {
    @NotNull
    public static final ByteBuffer byteBufferOf(@NotNull byte... bArr) {
        Intrinsics.checkNotNullParameter(bArr, MessengerShareContentUtility.ELEMENTS);
        return toBuffer(Arrays.copyOf(bArr, bArr.length));
    }

    @NotNull
    public static final FloatBuffer floatBufferOf(@NotNull float... fArr) {
        Intrinsics.checkNotNullParameter(fArr, MessengerShareContentUtility.ELEMENTS);
        return toBuffer(Arrays.copyOf(fArr, fArr.length));
    }

    @NotNull
    public static final IntBuffer intBufferOf(@NotNull int... iArr) {
        Intrinsics.checkNotNullParameter(iArr, MessengerShareContentUtility.ELEMENTS);
        return toBuffer(Arrays.copyOf(iArr, iArr.length));
    }

    @NotNull
    public static final ShortBuffer shortBufferOf(@NotNull short... sArr) {
        Intrinsics.checkNotNullParameter(sArr, MessengerShareContentUtility.ELEMENTS);
        return toBuffer(Arrays.copyOf(sArr, sArr.length));
    }

    @NotNull
    public static final FloatBuffer toBuffer(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$toBuffer");
        FloatBuffer floatBuffer = BuffersJvmKt.floatBuffer(fArr.length);
        floatBuffer.put(fArr);
        floatBuffer.flip();
        return floatBuffer;
    }

    @Deprecated(message = "Do not use this.", replaceWith = @ReplaceWith(expression = "ByteBuffer(size)", imports = {}))
    @NotNull
    public static final ByteBuffer byteBufferOf(int i) {
        return BuffersJvmKt.byteBuffer(i);
    }

    @Deprecated(message = "Do not use this.", replaceWith = @ReplaceWith(expression = "FloatBuffer(size)", imports = {}))
    @NotNull
    public static final FloatBuffer floatBufferOf(int i) {
        return BuffersJvmKt.floatBuffer(i);
    }

    @NotNull
    public static final ShortBuffer toBuffer(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$toBuffer");
        ShortBuffer shortBuffer = BuffersJvmKt.shortBuffer(sArr.length);
        shortBuffer.put(sArr);
        shortBuffer.flip();
        return shortBuffer;
    }

    @NotNull
    public static final IntBuffer toBuffer(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$toBuffer");
        IntBuffer intBuffer = BuffersJvmKt.intBuffer(iArr.length);
        intBuffer.put(iArr);
        intBuffer.flip();
        return intBuffer;
    }

    @NotNull
    public static final ByteBuffer toBuffer(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$toBuffer");
        ByteBuffer byteBuffer = BuffersJvmKt.byteBuffer(bArr.length);
        byteBuffer.put(bArr);
        byteBuffer.flip();
        return byteBuffer;
    }
}
