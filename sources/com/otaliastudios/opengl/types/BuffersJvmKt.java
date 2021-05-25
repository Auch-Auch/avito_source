package com.otaliastudios.opengl.types;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0019\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\b\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\f\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0019\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0010\u0010\u0011*\n\u0010\u0013\"\u00020\u00122\u00020\u0012*\n\u0010\u0014\"\u00020\u00022\u00020\u0002*\n\u0010\u0015\"\u00020\n2\u00020\n*\n\u0010\u0016\"\u00020\u000e2\u00020\u000e*\n\u0010\u0017\"\u00020\u00062\u00020\u0006¨\u0006\u0018"}, d2 = {"", "size", "Ljava/nio/ByteBuffer;", "Lcom/otaliastudios/opengl/types/ByteBuffer;", "byteBuffer", "(I)Ljava/nio/ByteBuffer;", "Ljava/nio/ShortBuffer;", "Lcom/otaliastudios/opengl/types/ShortBuffer;", "shortBuffer", "(I)Ljava/nio/ShortBuffer;", "Ljava/nio/FloatBuffer;", "Lcom/otaliastudios/opengl/types/FloatBuffer;", "floatBuffer", "(I)Ljava/nio/FloatBuffer;", "Ljava/nio/IntBuffer;", "Lcom/otaliastudios/opengl/types/IntBuffer;", "intBuffer", "(I)Ljava/nio/IntBuffer;", "Ljava/nio/Buffer;", "Buffer", "ByteBuffer", "FloatBuffer", "IntBuffer", "ShortBuffer", "egloo-metadata_release"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "BuffersJvmKt")
public final class BuffersJvmKt {
    @NotNull
    public static final ByteBuffer byteBuffer(int i) {
        ByteBuffer order = ByteBuffer.allocateDirect(i * 1).order(ByteOrder.nativeOrder());
        order.limit(order.capacity());
        Intrinsics.checkNotNullExpressionValue(order, "ByteBuffer\n        .allo…it.limit(it.capacity()) }");
        return order;
    }

    @NotNull
    public static final FloatBuffer floatBuffer(int i) {
        FloatBuffer asFloatBuffer = byteBuffer(i * 4).asFloatBuffer();
        Intrinsics.checkNotNullExpressionValue(asFloatBuffer, "byteBuffer(size * Egloo.…OF_FLOAT).asFloatBuffer()");
        return asFloatBuffer;
    }

    @NotNull
    public static final IntBuffer intBuffer(int i) {
        IntBuffer asIntBuffer = byteBuffer(i * 4).asIntBuffer();
        Intrinsics.checkNotNullExpressionValue(asIntBuffer, "byteBuffer(size * Egloo.SIZE_OF_INT).asIntBuffer()");
        return asIntBuffer;
    }

    @NotNull
    public static final ShortBuffer shortBuffer(int i) {
        ShortBuffer asShortBuffer = byteBuffer(i * 2).asShortBuffer();
        Intrinsics.checkNotNullExpressionValue(asShortBuffer, "byteBuffer(size * Egloo.…OF_SHORT).asShortBuffer()");
        return asShortBuffer;
    }
}
