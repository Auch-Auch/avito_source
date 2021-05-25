package com.google.protobuf;

import a2.j.i.h;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.nio.ByteBuffer;
public final class UnsafeByteOperations {
    public static ByteString unsafeWrap(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            return new h(byteBuffer);
        }
        int arrayOffset = byteBuffer.arrayOffset();
        byte[] array = byteBuffer.array();
        int position = byteBuffer.position() + arrayOffset;
        int remaining = byteBuffer.remaining();
        ByteString byteString = ByteString.EMPTY;
        return new ByteString.c(array, position, remaining);
    }

    public static void unsafeWriteTo(ByteString byteString, ByteOutput byteOutput) throws IOException {
        byteString.d(byteOutput);
    }
}
