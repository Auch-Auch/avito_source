package com.bumptech.glide.load.engine.bitmap_recycle;

import a2.d.a.d.b.u.d;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
public class LruBitmapPool implements BitmapPool {
    public static final Bitmap.Config k = Bitmap.Config.ARGB_8888;
    public final d a;
    public final Set<Bitmap.Config> b;
    public final long c;
    public final a d;
    public long e;
    public long f;
    public int g;
    public int h;
    public int i;
    public int j;

    public interface a {
    }

    public static final class b implements a {
    }

    public LruBitmapPool(long j2) {
        SizeConfigStrategy sizeConfigStrategy = new SizeConfigStrategy();
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i2 = Build.VERSION.SDK_INT;
        hashSet.add(null);
        if (i2 >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        Set<Bitmap.Config> unmodifiableSet = Collections.unmodifiableSet(hashSet);
        this.c = j2;
        this.e = j2;
        this.a = sizeConfigStrategy;
        this.b = unmodifiableSet;
        this.d = new b();
    }

    public final void a() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            b();
        }
    }

    public final void b() {
        StringBuilder L = a2.b.a.a.a.L("Hits=");
        L.append(this.g);
        L.append(", misses=");
        L.append(this.h);
        L.append(", puts=");
        L.append(this.i);
        L.append(", evictions=");
        L.append(this.j);
        L.append(", currentSize=");
        L.append(this.f);
        L.append(", maxSize=");
        L.append(this.e);
        L.append("\nStrategy=");
        L.append(this.a);
        L.toString();
    }

    @Nullable
    public final synchronized Bitmap c(int i2, int i3, @Nullable Bitmap.Config config) {
        Bitmap bitmap;
        if (Build.VERSION.SDK_INT >= 26) {
            if (config == Bitmap.Config.HARDWARE) {
                throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
            }
        }
        bitmap = this.a.get(i2, i3, config != null ? config : k);
        if (bitmap == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                this.a.logBitmap(i2, i3, config);
            }
            this.h++;
        } else {
            this.g++;
            this.f -= (long) this.a.getSize(bitmap);
            Objects.requireNonNull((b) this.d);
            bitmap.setHasAlpha(true);
            bitmap.setPremultiplied(true);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            this.a.logBitmap(i2, i3, config);
        }
        a();
        return bitmap;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void clearMemory() {
        Log.isLoggable("LruBitmapPool", 3);
        d(0);
    }

    public final synchronized void d(long j2) {
        while (this.f > j2) {
            Bitmap removeLast = this.a.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    b();
                }
                this.f = 0;
                return;
            }
            Objects.requireNonNull((b) this.d);
            this.f -= (long) this.a.getSize(removeLast);
            this.j++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                this.a.logBitmap(removeLast);
            }
            a();
            removeLast.recycle();
        }
    }

    public long evictionCount() {
        return (long) this.j;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @NonNull
    public Bitmap get(int i2, int i3, Bitmap.Config config) {
        Bitmap c2 = c(i2, i3, config);
        if (c2 != null) {
            c2.eraseColor(0);
            return c2;
        }
        if (config == null) {
            config = k;
        }
        return Bitmap.createBitmap(i2, i3, config);
    }

    public long getCurrentSize() {
        return this.f;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @NonNull
    public Bitmap getDirty(int i2, int i3, Bitmap.Config config) {
        Bitmap c2 = c(i2, i3, config);
        if (c2 != null) {
            return c2;
        }
        if (config == null) {
            config = k;
        }
        return Bitmap.createBitmap(i2, i3, config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public long getMaxSize() {
        return this.e;
    }

    public long hitCount() {
        return (long) this.g;
    }

    public long missCount() {
        return (long) this.h;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized void put(Bitmap bitmap) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        } else if (!bitmap.isRecycled()) {
            if (bitmap.isMutable() && ((long) this.a.getSize(bitmap)) <= this.e) {
                if (this.b.contains(bitmap.getConfig())) {
                    int size = this.a.getSize(bitmap);
                    this.a.put(bitmap);
                    Objects.requireNonNull((b) this.d);
                    this.i++;
                    this.f += (long) size;
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        this.a.logBitmap(bitmap);
                    }
                    a();
                    d(this.e);
                    return;
                }
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                this.a.logBitmap(bitmap);
                bitmap.isMutable();
                this.b.contains(bitmap.getConfig());
            }
            bitmap.recycle();
        } else {
            throw new IllegalStateException("Cannot pool recycled bitmap");
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized void setSizeMultiplier(float f2) {
        long round = (long) Math.round(((float) this.c) * f2);
        this.e = round;
        d(round);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @SuppressLint({"InlinedApi"})
    public void trimMemory(int i2) {
        Log.isLoggable("LruBitmapPool", 3);
        if (i2 >= 40 || (Build.VERSION.SDK_INT >= 23 && i2 >= 20)) {
            clearMemory();
        } else if (i2 >= 20 || i2 == 15) {
            d(getMaxSize() / 2);
        }
    }

    public LruBitmapPool(long j2, Set<Bitmap.Config> set) {
        SizeConfigStrategy sizeConfigStrategy = new SizeConfigStrategy();
        this.c = j2;
        this.e = j2;
        this.a = sizeConfigStrategy;
        this.b = set;
        this.d = new b();
    }
}
