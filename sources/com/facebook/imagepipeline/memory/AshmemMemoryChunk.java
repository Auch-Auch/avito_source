package com.facebook.imagepipeline.memory;

import android.annotation.TargetApi;
import android.os.SharedMemory;
import android.system.ErrnoException;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.io.Closeable;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
@TargetApi(27)
public class AshmemMemoryChunk implements MemoryChunk, Closeable {
    @Nullable
    public SharedMemory a;
    @Nullable
    public ByteBuffer b;
    public final long c;

    public AshmemMemoryChunk(int i) {
        Preconditions.checkArgument(i > 0);
        try {
            SharedMemory create = SharedMemory.create("AshmemMemoryChunk", i);
            this.a = create;
            this.b = create.mapReadWrite();
            this.c = (long) System.identityHashCode(this);
        } catch (ErrnoException e) {
            throw new RuntimeException("Fail to create AshmemMemory", e);
        }
    }

    public final void a(int i, MemoryChunk memoryChunk, int i2, int i3) {
        if (memoryChunk instanceof AshmemMemoryChunk) {
            Preconditions.checkState(!isClosed());
            Preconditions.checkState(!memoryChunk.isClosed());
            MemoryChunkUtil.b(i, memoryChunk.getSize(), i2, i3, getSize());
            this.b.position(i);
            memoryChunk.getByteBuffer().position(i2);
            byte[] bArr = new byte[i3];
            this.b.get(bArr, 0, i3);
            memoryChunk.getByteBuffer().put(bArr, 0, i3);
            return;
        }
        throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (!isClosed()) {
            SharedMemory.unmap(this.b);
            this.a.close();
            this.b = null;
            this.a = null;
        }
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
    public ByteBuffer getByteBuffer() {
        return this.b;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public long getNativePtr() {
        throw new UnsupportedOperationException("Cannot get the pointer of an  AshmemMemoryChunk");
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public int getSize() {
        Preconditions.checkState(!isClosed());
        return this.a.getSize();
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public long getUniqueId() {
        return this.c;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized boolean isClosed() {
        return this.b == null || this.a == null;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized int read(int i, byte[] bArr, int i2, int i3) {
        int a3;
        Preconditions.checkNotNull(bArr);
        Preconditions.checkState(!isClosed());
        a3 = MemoryChunkUtil.a(i, i3, getSize());
        MemoryChunkUtil.b(i, bArr.length, i2, a3, getSize());
        this.b.position(i);
        this.b.get(bArr, i2, a3);
        return a3;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized int write(int i, byte[] bArr, int i2, int i3) {
        int a3;
        Preconditions.checkNotNull(bArr);
        Preconditions.checkState(!isClosed());
        a3 = MemoryChunkUtil.a(i, i3, getSize());
        MemoryChunkUtil.b(i, bArr.length, i2, a3, getSize());
        this.b.position(i);
        this.b.put(bArr, i2, a3);
        return a3;
    }

    @VisibleForTesting
    public AshmemMemoryChunk() {
        this.a = null;
        this.b = null;
        this.c = (long) System.identityHashCode(this);
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized byte read(int i) {
        boolean z = true;
        Preconditions.checkState(!isClosed());
        Preconditions.checkArgument(i >= 0);
        if (i >= getSize()) {
            z = false;
        }
        Preconditions.checkArgument(z);
        return this.b.get(i);
    }
}
