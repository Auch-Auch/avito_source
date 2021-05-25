package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.nativecode.ImagePipelineNativeLoader;
import com.facebook.soloader.nativeloader.NativeLoader;
import java.io.Closeable;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
@DoNotStrip
public class NativeMemoryChunk implements MemoryChunk, Closeable {
    public final long a;
    public final int b;
    public boolean c;

    static {
        NativeLoader.loadLibrary(ImagePipelineNativeLoader.DSO_NAME);
    }

    public NativeMemoryChunk(int i) {
        Preconditions.checkArgument(i > 0);
        this.b = i;
        this.a = nativeAllocate(i);
        this.c = false;
    }

    @DoNotStrip
    private static native long nativeAllocate(int i);

    @DoNotStrip
    private static native void nativeCopyFromByteArray(long j, byte[] bArr, int i, int i2);

    @DoNotStrip
    private static native void nativeCopyToByteArray(long j, byte[] bArr, int i, int i2);

    @DoNotStrip
    private static native void nativeFree(long j);

    @DoNotStrip
    private static native void nativeMemcpy(long j, long j2, int i);

    @DoNotStrip
    private static native byte nativeReadByte(long j);

    public final void a(int i, MemoryChunk memoryChunk, int i2, int i3) {
        if (memoryChunk instanceof NativeMemoryChunk) {
            Preconditions.checkState(!isClosed());
            Preconditions.checkState(!memoryChunk.isClosed());
            MemoryChunkUtil.b(i, memoryChunk.getSize(), i2, i3, this.b);
            nativeMemcpy(memoryChunk.getNativePtr() + ((long) i2), this.a + ((long) i), i3);
            return;
        }
        throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (!this.c) {
            this.c = true;
            nativeFree(this.a);
        }
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public void copy(int i, MemoryChunk memoryChunk, int i2, int i3) {
        Preconditions.checkNotNull(memoryChunk);
        if (memoryChunk.getUniqueId() == getUniqueId()) {
            Integer.toHexString(System.identityHashCode(this));
            Integer.toHexString(System.identityHashCode(memoryChunk));
            Long.toHexString(this.a);
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

    @Override // java.lang.Object
    public void finalize() throws Throwable {
        if (!isClosed()) {
            Integer.toHexString(System.identityHashCode(this));
            try {
                close();
            } finally {
                super.finalize();
            }
        }
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    @Nullable
    public ByteBuffer getByteBuffer() {
        return null;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public long getNativePtr() {
        return this.a;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public int getSize() {
        return this.b;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public long getUniqueId() {
        return this.a;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized boolean isClosed() {
        return this.c;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized int read(int i, byte[] bArr, int i2, int i3) {
        int a3;
        Preconditions.checkNotNull(bArr);
        Preconditions.checkState(!isClosed());
        a3 = MemoryChunkUtil.a(i, i3, this.b);
        MemoryChunkUtil.b(i, bArr.length, i2, a3, this.b);
        nativeCopyToByteArray(this.a + ((long) i), bArr, i2, a3);
        return a3;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized int write(int i, byte[] bArr, int i2, int i3) {
        int a3;
        Preconditions.checkNotNull(bArr);
        Preconditions.checkState(!isClosed());
        a3 = MemoryChunkUtil.a(i, i3, this.b);
        MemoryChunkUtil.b(i, bArr.length, i2, a3, this.b);
        nativeCopyFromByteArray(this.a + ((long) i), bArr, i2, a3);
        return a3;
    }

    @VisibleForTesting
    public NativeMemoryChunk() {
        this.b = 0;
        this.a = 0;
        this.c = true;
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
        return nativeReadByte(this.a + ((long) i));
    }
}
