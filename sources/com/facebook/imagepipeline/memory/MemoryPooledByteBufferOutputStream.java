package com.facebook.imagepipeline.memory;

import a2.b.a.a.a;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
public class MemoryPooledByteBufferOutputStream extends PooledByteBufferOutputStream {
    public final MemoryChunkPool a;
    public CloseableReference<MemoryChunk> b;
    public int c;

    public static class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }

    public MemoryPooledByteBufferOutputStream(MemoryChunkPool memoryChunkPool) {
        this(memoryChunkPool, memoryChunkPool.k[0]);
    }

    public final void a() {
        if (!CloseableReference.isValid(this.b)) {
            throw new InvalidStreamException();
        }
    }

    @Override // com.facebook.common.memory.PooledByteBufferOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        CloseableReference.closeSafely(this.b);
        this.b = null;
        this.c = -1;
        super.close();
    }

    @Override // com.facebook.common.memory.PooledByteBufferOutputStream
    public int size() {
        return this.c;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    @Override // com.facebook.common.memory.PooledByteBufferOutputStream
    public MemoryPooledByteBuffer toByteBuffer() {
        a();
        return new MemoryPooledByteBuffer(this.b, this.c);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            StringBuilder L = a.L("length=");
            L.append(bArr.length);
            L.append("; regionStart=");
            L.append(i);
            L.append("; regionLength=");
            L.append(i2);
            throw new ArrayIndexOutOfBoundsException(L.toString());
        }
        a();
        int i3 = this.c + i2;
        a();
        if (i3 > this.b.get().getSize()) {
            MemoryChunk memoryChunk = (MemoryChunk) this.a.get(i3);
            this.b.get().copy(0, memoryChunk, 0, this.c);
            this.b.close();
            this.b = CloseableReference.of(memoryChunk, this.a);
        }
        this.b.get().write(this.c, bArr, i, i2);
        this.c += i2;
    }

    public MemoryPooledByteBufferOutputStream(MemoryChunkPool memoryChunkPool, int i) {
        Preconditions.checkArgument(i > 0);
        MemoryChunkPool memoryChunkPool2 = (MemoryChunkPool) Preconditions.checkNotNull(memoryChunkPool);
        this.a = memoryChunkPool2;
        this.c = 0;
        this.b = CloseableReference.of(memoryChunkPool2.get(i), memoryChunkPool2);
    }
}
