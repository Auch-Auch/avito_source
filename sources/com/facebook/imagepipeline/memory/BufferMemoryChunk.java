package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import java.io.Closeable;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
public class BufferMemoryChunk implements MemoryChunk, Closeable {
    public ByteBuffer a;
    public final int b;
    public final long c = ((long) System.identityHashCode(this));

    public BufferMemoryChunk(int i) {
        this.a = ByteBuffer.allocateDirect(i);
        this.b = i;
    }

    public final void a(int i, MemoryChunk memoryChunk, int i2, int i3) {
        if (memoryChunk instanceof BufferMemoryChunk) {
            Preconditions.checkState(!isClosed());
            Preconditions.checkState(!memoryChunk.isClosed());
            MemoryChunkUtil.b(i, memoryChunk.getSize(), i2, i3, this.b);
            this.a.position(i);
            memoryChunk.getByteBuffer().position(i2);
            byte[] bArr = new byte[i3];
            this.a.get(bArr, 0, i3);
            memoryChunk.getByteBuffer().put(bArr, 0, i3);
            return;
        }
        throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.a = null;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public void copy(int i, MemoryChunk memoryChunk, int i2, int i3) {
        Preconditions.checkNotNull(memoryChunk);
        if (memoryChunk.getUniqueId() == getUniqueId()) {
            Long.toHexString(getUniqueId());
            Long.toHexString(memoryChunk.getUniqueId());
            Preconditions.checkArgument(false);
        }
        if (memoryChunk.getUniqueId() < getUniqueId()) {
            synchronized (memoryChunk) {
                synchronized (this) {
                    a(i, memoryChunk, i2, i3);
                }
            }
            return;
        }
        synchronized (this) {
            synchronized (memoryChunk) {
                a(i, memoryChunk, i2, i3);
            }
        }
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    @Nullable
    public synchronized ByteBuffer getByteBuffer() {
        return this.a;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public long getNativePtr() {
        throw new UnsupportedOperationException("Cannot get the pointer of a BufferMemoryChunk");
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public int getSize() {
        return this.b;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public long getUniqueId() {
        return this.c;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized boolean isClosed() {
        return this.a == null;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized int read(int i, byte[] bArr, int i2, int i3) {
        int a3;
        Preconditions.checkNotNull(bArr);
        Preconditions.checkState(!isClosed());
        a3 = MemoryChunkUtil.a(i, i3, this.b);
        MemoryChunkUtil.b(i, bArr.length, i2, a3, this.b);
        this.a.position(i);
        this.a.get(bArr, i2, a3);
        return a3;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized int write(int i, byte[] bArr, int i2, int i3) {
        int a3;
        Preconditions.checkNotNull(bArr);
        Preconditions.checkState(!isClosed());
        a3 = MemoryChunkUtil.a(i, i3, this.b);
        MemoryChunkUtil.b(i, bArr.length, i2, a3, this.b);
        this.a.position(i);
        this.a.put(bArr, i2, a3);
        return a3;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized byte read(int i) {
        boolean z = true;
        Preconditions.checkState(!isClosed());
        Preconditions.checkArgument(i >= 0);
        if (i >= this.b) {
            z = false;
        }
        Preconditions.checkArgument(z);
        return this.a.get(i);
    }
}
