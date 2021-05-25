package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.OOMSoftReference;
import com.facebook.common.references.ResourceReleaser;
import java.util.concurrent.Semaphore;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
public class SharedByteArray implements MemoryTrimmable {
    @VisibleForTesting
    public final int a;
    @VisibleForTesting
    public final int b;
    @VisibleForTesting
    public final OOMSoftReference<byte[]> c;
    @VisibleForTesting
    public final Semaphore d;
    public final ResourceReleaser<byte[]> e;

    public class a implements ResourceReleaser<byte[]> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.facebook.common.references.ResourceReleaser
        public void release(byte[] bArr) {
            SharedByteArray.this.d.release();
        }
    }

    public SharedByteArray(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams) {
        Preconditions.checkNotNull(memoryTrimmableRegistry);
        boolean z = false;
        Preconditions.checkArgument(poolParams.minBucketSize > 0);
        Preconditions.checkArgument(poolParams.maxBucketSize >= poolParams.minBucketSize ? true : z);
        this.b = poolParams.maxBucketSize;
        this.a = poolParams.minBucketSize;
        this.c = new OOMSoftReference<>();
        this.d = new Semaphore(1);
        this.e = new a();
        memoryTrimmableRegistry.registerMemoryTrimmable(this);
    }

    public final byte[] a(int i) {
        int highestOneBit = Integer.highestOneBit(Math.max(i, this.a) - 1) * 2;
        byte[] bArr = this.c.get();
        if (bArr == null || bArr.length < highestOneBit) {
            synchronized (this) {
                this.c.clear();
                bArr = new byte[highestOneBit];
                this.c.set(bArr);
            }
        }
        return bArr;
    }

    public CloseableReference<byte[]> get(int i) {
        boolean z = true;
        Preconditions.checkArgument(i > 0, "Size must be greater than zero");
        if (i > this.b) {
            z = false;
        }
        Preconditions.checkArgument(z, "Requested size is too big");
        this.d.acquireUninterruptibly();
        try {
            return CloseableReference.of(a(i), this.e);
        } catch (Throwable th) {
            this.d.release();
            throw Throwables.propagate(th);
        }
    }

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void trim(MemoryTrimType memoryTrimType) {
        if (this.d.tryAcquire()) {
            try {
                this.c.clear();
            } finally {
                this.d.release();
            }
        }
    }
}
