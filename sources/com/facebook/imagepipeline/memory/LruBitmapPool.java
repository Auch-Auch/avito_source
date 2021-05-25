package com.facebook.imagepipeline.memory;

import a2.g.p.d.c;
import android.graphics.Bitmap;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import javax.annotation.Nullable;
public class LruBitmapPool implements BitmapPool {
    public final int a;
    public int b;
    public final PoolStatsTracker c;
    public int d;
    public final c<Bitmap> mStrategy = new BitmapPoolBackend();

    public LruBitmapPool(int i, int i2, PoolStatsTracker poolStatsTracker, @Nullable MemoryTrimmableRegistry memoryTrimmableRegistry) {
        this.a = i;
        this.b = i2;
        this.c = poolStatsTracker;
        if (memoryTrimmableRegistry != null) {
            memoryTrimmableRegistry.registerMemoryTrimmable(this);
        }
    }

    public final synchronized void a(int i) {
        while (true) {
            if (this.d <= i) {
                break;
            }
            Bitmap pop = this.mStrategy.pop();
            if (pop == null) {
                break;
            }
            int size = this.mStrategy.getSize(pop);
            this.d -= size;
            this.c.onFree(size);
        }
    }

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void trim(MemoryTrimType memoryTrimType) {
        a((int) ((1.0d - memoryTrimType.getSuggestedTrimRatio()) * ((double) this.a)));
    }

    @Override // com.facebook.common.memory.Pool
    public synchronized Bitmap get(int i) {
        int i2 = this.d;
        int i3 = this.a;
        if (i2 > i3) {
            a(i3);
        }
        Bitmap bitmap = this.mStrategy.get(i);
        if (bitmap != null) {
            int size = this.mStrategy.getSize(bitmap);
            this.d -= size;
            this.c.onValueReuse(size);
            return bitmap;
        }
        this.c.onAlloc(i);
        return Bitmap.createBitmap(1, i, Bitmap.Config.ALPHA_8);
    }

    public void release(Bitmap bitmap) {
        int size = this.mStrategy.getSize(bitmap);
        if (size <= this.b) {
            this.c.onValueRelease(size);
            this.mStrategy.put(bitmap);
            synchronized (this) {
                this.d += size;
            }
        }
    }
}
