package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.concurrent.GuardedBy;
public class BitmapCounter {
    @GuardedBy("this")
    public int a;
    @GuardedBy("this")
    public long b;
    public final int c;
    public final int d;
    public final ResourceReleaser<Bitmap> e;

    public class a implements ResourceReleaser<Bitmap> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.facebook.common.references.ResourceReleaser
        public void release(Bitmap bitmap) {
            Bitmap bitmap2 = bitmap;
            try {
                BitmapCounter.this.decrease(bitmap2);
            } finally {
                bitmap2.recycle();
            }
        }
    }

    public BitmapCounter(int i, int i2) {
        boolean z = true;
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i2 <= 0 ? false : z);
        this.c = i;
        this.d = i2;
        this.e = new a();
    }

    public synchronized void decrease(Bitmap bitmap) {
        int sizeInBytes = BitmapUtil.getSizeInBytes(bitmap);
        Preconditions.checkArgument(this.a > 0, "No bitmaps registered.");
        long j = (long) sizeInBytes;
        Preconditions.checkArgument(j <= this.b, "Bitmap size bigger than the total registered size: %d, %d", Integer.valueOf(sizeInBytes), Long.valueOf(this.b));
        this.b -= j;
        this.a--;
    }

    public synchronized int getCount() {
        return this.a;
    }

    public synchronized int getMaxCount() {
        return this.c;
    }

    public synchronized int getMaxSize() {
        return this.d;
    }

    public ResourceReleaser<Bitmap> getReleaser() {
        return this.e;
    }

    public synchronized long getSize() {
        return this.b;
    }

    public synchronized boolean increase(Bitmap bitmap) {
        int sizeInBytes = BitmapUtil.getSizeInBytes(bitmap);
        int i = this.a;
        if (i < this.c) {
            long j = this.b;
            long j2 = (long) sizeInBytes;
            if (j + j2 <= ((long) this.d)) {
                this.a = i + 1;
                this.b = j + j2;
                return true;
            }
        }
        return false;
    }
}
