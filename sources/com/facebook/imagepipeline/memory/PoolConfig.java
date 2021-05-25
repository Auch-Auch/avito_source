package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.concurrent.Immutable;
@Immutable
public class PoolConfig {
    public static final int BITMAP_POOL_MAX_BITMAP_SIZE_DEFAULT = 4194304;
    public final PoolParams a;
    public final PoolStatsTracker b;
    public final PoolParams c;
    public final MemoryTrimmableRegistry d;
    public final PoolParams e;
    public final PoolStatsTracker f;
    public final PoolParams g;
    public final PoolStatsTracker h;
    public final String i;
    public final int j;
    public final int k;
    public final boolean l;
    public final boolean m;

    public static class Builder {
        public PoolParams a;
        public PoolStatsTracker b;
        public PoolParams c;
        public MemoryTrimmableRegistry d;
        public PoolParams e;
        public PoolStatsTracker f;
        public PoolParams g;
        public PoolStatsTracker h;
        public String i;
        public int j;
        public int k;
        public boolean l;
        public boolean mIgnoreBitmapPoolHardCap;

        public Builder() {
        }

        public PoolConfig build() {
            return new PoolConfig(this, null);
        }

        public Builder setBitmapPoolMaxBitmapSize(int i2) {
            this.k = i2;
            return this;
        }

        public Builder setBitmapPoolMaxPoolSize(int i2) {
            this.j = i2;
            return this;
        }

        public Builder setBitmapPoolParams(PoolParams poolParams) {
            this.a = (PoolParams) Preconditions.checkNotNull(poolParams);
            return this;
        }

        public Builder setBitmapPoolStatsTracker(PoolStatsTracker poolStatsTracker) {
            this.b = (PoolStatsTracker) Preconditions.checkNotNull(poolStatsTracker);
            return this;
        }

        public Builder setBitmapPoolType(String str) {
            this.i = str;
            return this;
        }

        public Builder setFlexByteArrayPoolParams(PoolParams poolParams) {
            this.c = poolParams;
            return this;
        }

        public Builder setIgnoreBitmapPoolHardCap(boolean z) {
            this.mIgnoreBitmapPoolHardCap = z;
            return this;
        }

        public Builder setMemoryTrimmableRegistry(MemoryTrimmableRegistry memoryTrimmableRegistry) {
            this.d = memoryTrimmableRegistry;
            return this;
        }

        public Builder setNativeMemoryChunkPoolParams(PoolParams poolParams) {
            this.e = (PoolParams) Preconditions.checkNotNull(poolParams);
            return this;
        }

        public Builder setNativeMemoryChunkPoolStatsTracker(PoolStatsTracker poolStatsTracker) {
            this.f = (PoolStatsTracker) Preconditions.checkNotNull(poolStatsTracker);
            return this;
        }

        public Builder setRegisterLruBitmapPoolAsMemoryTrimmable(boolean z) {
            this.l = z;
            return this;
        }

        public Builder setSmallByteArrayPoolParams(PoolParams poolParams) {
            this.g = (PoolParams) Preconditions.checkNotNull(poolParams);
            return this;
        }

        public Builder setSmallByteArrayPoolStatsTracker(PoolStatsTracker poolStatsTracker) {
            this.h = (PoolStatsTracker) Preconditions.checkNotNull(poolStatsTracker);
            return this;
        }

        public Builder(a aVar) {
        }
    }

    public PoolConfig(Builder builder, a aVar) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("PoolConfig()");
        }
        PoolParams poolParams = builder.a;
        this.a = poolParams == null ? DefaultBitmapPoolParams.get() : poolParams;
        PoolStatsTracker poolStatsTracker = builder.b;
        this.b = poolStatsTracker == null ? NoOpPoolStatsTracker.getInstance() : poolStatsTracker;
        PoolParams poolParams2 = builder.c;
        this.c = poolParams2 == null ? DefaultFlexByteArrayPoolParams.get() : poolParams2;
        MemoryTrimmableRegistry memoryTrimmableRegistry = builder.d;
        this.d = memoryTrimmableRegistry == null ? NoOpMemoryTrimmableRegistry.getInstance() : memoryTrimmableRegistry;
        PoolParams poolParams3 = builder.e;
        this.e = poolParams3 == null ? DefaultNativeMemoryChunkPoolParams.get() : poolParams3;
        PoolStatsTracker poolStatsTracker2 = builder.f;
        this.f = poolStatsTracker2 == null ? NoOpPoolStatsTracker.getInstance() : poolStatsTracker2;
        PoolParams poolParams4 = builder.g;
        this.g = poolParams4 == null ? DefaultByteArrayPoolParams.get() : poolParams4;
        PoolStatsTracker poolStatsTracker3 = builder.h;
        this.h = poolStatsTracker3 == null ? NoOpPoolStatsTracker.getInstance() : poolStatsTracker3;
        String str = builder.i;
        this.i = str == null ? "legacy" : str;
        this.j = builder.j;
        int i2 = builder.k;
        this.k = i2 <= 0 ? 4194304 : i2;
        this.l = builder.l;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        this.m = builder.mIgnoreBitmapPoolHardCap;
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public int getBitmapPoolMaxBitmapSize() {
        return this.k;
    }

    public int getBitmapPoolMaxPoolSize() {
        return this.j;
    }

    public PoolParams getBitmapPoolParams() {
        return this.a;
    }

    public PoolStatsTracker getBitmapPoolStatsTracker() {
        return this.b;
    }

    public String getBitmapPoolType() {
        return this.i;
    }

    public PoolParams getFlexByteArrayPoolParams() {
        return this.c;
    }

    public PoolParams getMemoryChunkPoolParams() {
        return this.e;
    }

    public PoolStatsTracker getMemoryChunkPoolStatsTracker() {
        return this.f;
    }

    public MemoryTrimmableRegistry getMemoryTrimmableRegistry() {
        return this.d;
    }

    public PoolParams getSmallByteArrayPoolParams() {
        return this.g;
    }

    public PoolStatsTracker getSmallByteArrayPoolStatsTracker() {
        return this.h;
    }

    public boolean isIgnoreBitmapPoolHardCap() {
        return this.m;
    }

    public boolean isRegisterLruBitmapPoolAsMemoryTrimmable() {
        return this.l;
    }
}
