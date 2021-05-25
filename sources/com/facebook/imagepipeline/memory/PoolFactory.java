package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.imagepipeline.core.NativeCodeSetup;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
public class PoolFactory {
    public final PoolConfig a;
    @Nullable
    public MemoryChunkPool b;
    public BitmapPool c;
    @Nullable
    public MemoryChunkPool d;
    public FlexByteArrayPool e;
    @Nullable
    public MemoryChunkPool f;
    public PooledByteBufferFactory g;
    public PooledByteStreams h;
    public SharedByteArray i;
    public ByteArrayPool j;

    public PoolFactory(PoolConfig poolConfig) {
        this.a = (PoolConfig) Preconditions.checkNotNull(poolConfig);
    }

    @Nullable
    public final MemoryChunkPool a(int i2) {
        if (i2 == 0) {
            return getNativeMemoryChunkPool();
        }
        if (i2 == 1) {
            return getBufferMemoryChunkPool();
        }
        if (i2 == 2) {
            if (this.b == null) {
                try {
                    this.b = (MemoryChunkPool) Class.forName("com.facebook.imagepipeline.memory.AshmemMemoryChunkPool").getConstructor(MemoryTrimmableRegistry.class, PoolParams.class, PoolStatsTracker.class).newInstance(this.a.getMemoryTrimmableRegistry(), this.a.getMemoryChunkPoolParams(), this.a.getMemoryChunkPoolStatsTracker());
                } catch (ClassNotFoundException unused) {
                    this.b = null;
                } catch (IllegalAccessException unused2) {
                    this.b = null;
                } catch (InstantiationException unused3) {
                    this.b = null;
                } catch (NoSuchMethodException unused4) {
                    this.b = null;
                } catch (InvocationTargetException unused5) {
                    this.b = null;
                }
            }
            return this.b;
        }
        throw new IllegalArgumentException("Invalid MemoryChunkType");
    }

    public BitmapPool getBitmapPool() {
        if (this.c == null) {
            String bitmapPoolType = this.a.getBitmapPoolType();
            char c2 = 65535;
            switch (bitmapPoolType.hashCode()) {
                case -1868884870:
                    if (bitmapPoolType.equals(BitmapPoolType.LEGACY_DEFAULT_PARAMS)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1106578487:
                    if (bitmapPoolType.equals("legacy")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -404562712:
                    if (bitmapPoolType.equals(BitmapPoolType.EXPERIMENTAL)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -402149703:
                    if (bitmapPoolType.equals(BitmapPoolType.DUMMY_WITH_TRACKING)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 95945896:
                    if (bitmapPoolType.equals(BitmapPoolType.DUMMY)) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                this.c = new DummyBitmapPool();
            } else if (c2 == 1) {
                this.c = new DummyTrackingInUseBitmapPool();
            } else if (c2 == 2) {
                this.c = new LruBitmapPool(this.a.getBitmapPoolMaxPoolSize(), this.a.getBitmapPoolMaxBitmapSize(), NoOpPoolStatsTracker.getInstance(), this.a.isRegisterLruBitmapPoolAsMemoryTrimmable() ? this.a.getMemoryTrimmableRegistry() : null);
            } else if (c2 != 3) {
                this.c = new BucketsBitmapPool(this.a.getMemoryTrimmableRegistry(), this.a.getBitmapPoolParams(), this.a.getBitmapPoolStatsTracker(), this.a.isIgnoreBitmapPoolHardCap());
            } else {
                this.c = new BucketsBitmapPool(this.a.getMemoryTrimmableRegistry(), DefaultBitmapPoolParams.get(), this.a.getBitmapPoolStatsTracker(), this.a.isIgnoreBitmapPoolHardCap());
            }
        }
        return this.c;
    }

    @Nullable
    public MemoryChunkPool getBufferMemoryChunkPool() {
        if (this.d == null) {
            try {
                this.d = (MemoryChunkPool) Class.forName("com.facebook.imagepipeline.memory.BufferMemoryChunkPool").getConstructor(MemoryTrimmableRegistry.class, PoolParams.class, PoolStatsTracker.class).newInstance(this.a.getMemoryTrimmableRegistry(), this.a.getMemoryChunkPoolParams(), this.a.getMemoryChunkPoolStatsTracker());
            } catch (ClassNotFoundException unused) {
                this.d = null;
            } catch (IllegalAccessException unused2) {
                this.d = null;
            } catch (InstantiationException unused3) {
                this.d = null;
            } catch (NoSuchMethodException unused4) {
                this.d = null;
            } catch (InvocationTargetException unused5) {
                this.d = null;
            }
        }
        return this.d;
    }

    public FlexByteArrayPool getFlexByteArrayPool() {
        if (this.e == null) {
            this.e = new FlexByteArrayPool(this.a.getMemoryTrimmableRegistry(), this.a.getFlexByteArrayPoolParams());
        }
        return this.e;
    }

    public int getFlexByteArrayPoolMaxNumThreads() {
        return this.a.getFlexByteArrayPoolParams().maxNumThreads;
    }

    @Nullable
    public MemoryChunkPool getNativeMemoryChunkPool() {
        if (this.f == null) {
            try {
                this.f = (MemoryChunkPool) Class.forName("com.facebook.imagepipeline.memory.NativeMemoryChunkPool").getConstructor(MemoryTrimmableRegistry.class, PoolParams.class, PoolStatsTracker.class).newInstance(this.a.getMemoryTrimmableRegistry(), this.a.getMemoryChunkPoolParams(), this.a.getMemoryChunkPoolStatsTracker());
            } catch (ClassNotFoundException e2) {
                FLog.e("PoolFactory", "", e2);
                this.f = null;
            } catch (IllegalAccessException e3) {
                FLog.e("PoolFactory", "", e3);
                this.f = null;
            } catch (InstantiationException e4) {
                FLog.e("PoolFactory", "", e4);
                this.f = null;
            } catch (NoSuchMethodException e5) {
                FLog.e("PoolFactory", "", e5);
                this.f = null;
            } catch (InvocationTargetException e6) {
                FLog.e("PoolFactory", "", e6);
                this.f = null;
            }
        }
        return this.f;
    }

    public PooledByteBufferFactory getPooledByteBufferFactory() {
        return getPooledByteBufferFactory(!NativeCodeSetup.getUseNativeCode() ? 1 : 0);
    }

    public PooledByteStreams getPooledByteStreams() {
        if (this.h == null) {
            this.h = new PooledByteStreams(getSmallByteArrayPool());
        }
        return this.h;
    }

    public SharedByteArray getSharedByteArray() {
        if (this.i == null) {
            this.i = new SharedByteArray(this.a.getMemoryTrimmableRegistry(), this.a.getFlexByteArrayPoolParams());
        }
        return this.i;
    }

    public ByteArrayPool getSmallByteArrayPool() {
        if (this.j == null) {
            this.j = new GenericByteArrayPool(this.a.getMemoryTrimmableRegistry(), this.a.getSmallByteArrayPoolParams(), this.a.getSmallByteArrayPoolStatsTracker());
        }
        return this.j;
    }

    public PooledByteBufferFactory getPooledByteBufferFactory(int i2) {
        if (this.g == null) {
            MemoryChunkPool a3 = a(i2);
            Preconditions.checkNotNull(a3, "failed to get pool for chunk type: " + i2);
            this.g = new MemoryPooledByteBufferFactory(a(i2), getPooledByteStreams());
        }
        return this.g;
    }
}
