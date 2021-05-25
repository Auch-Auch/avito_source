package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import java.util.Map;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
public class FlexByteArrayPool {
    public final ResourceReleaser<byte[]> a;
    @VisibleForTesting
    public final b b;

    public class a implements ResourceReleaser<byte[]> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.facebook.common.references.ResourceReleaser
        public void release(byte[] bArr) {
            FlexByteArrayPool.this.release(bArr);
        }
    }

    @VisibleForTesting
    public static class b extends GenericByteArrayPool {
        public b(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
            super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        public a2.g.p.d.a<byte[]> f(int i) {
            return new a2.g.p.d.b(getSizeInBytes(i), this.c.maxNumThreads, 0);
        }
    }

    public FlexByteArrayPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams) {
        Preconditions.checkArgument(poolParams.maxNumThreads > 0);
        this.b = new b(memoryTrimmableRegistry, poolParams, NoOpPoolStatsTracker.getInstance());
        this.a = new a();
    }

    public CloseableReference<byte[]> get(int i) {
        return CloseableReference.of(this.b.get(i), this.a);
    }

    public int getMinBufferSize() {
        return this.b.getMinBufferSize();
    }

    public Map<String, Integer> getStats() {
        return this.b.getStats();
    }

    public void release(byte[] bArr) {
        this.b.release(bArr);
    }
}
