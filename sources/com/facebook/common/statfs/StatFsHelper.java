package com.facebook.common.statfs;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import com.facebook.common.internal.Throwables;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
public class StatFsHelper {
    public static final long DEFAULT_DISK_OLIVE_LEVEL_IN_BYTES = 1048576000;
    public static final long DEFAULT_DISK_RED_LEVEL_IN_BYTES = 104857600;
    public static final int DEFAULT_DISK_RED_LEVEL_IN_MB = 100;
    public static final long DEFAULT_DISK_YELLOW_LEVEL_IN_BYTES = 419430400;
    public static final int DEFAULT_DISK_YELLOW_LEVEL_IN_MB = 400;
    public static StatFsHelper h;
    public static final long i = TimeUnit.MINUTES.toMillis(2);
    @Nullable
    public volatile StatFs a = null;
    public volatile File b;
    @Nullable
    public volatile StatFs c = null;
    public volatile File d;
    @GuardedBy("lock")
    public long e;
    public final Lock f = new ReentrantLock();
    public volatile boolean g = false;

    public enum StorageType {
        INTERNAL,
        EXTERNAL
    }

    public static StatFs createStatFs(String str) {
        return new StatFs(str);
    }

    public static synchronized StatFsHelper getInstance() {
        StatFsHelper statFsHelper;
        synchronized (StatFsHelper.class) {
            if (h == null) {
                h = new StatFsHelper();
            }
            statFsHelper = h;
        }
        return statFsHelper;
    }

    public final void a() {
        if (!this.g) {
            this.f.lock();
            try {
                if (!this.g) {
                    this.b = Environment.getDataDirectory();
                    this.d = Environment.getExternalStorageDirectory();
                    c();
                    this.g = true;
                }
            } finally {
                this.f.unlock();
            }
        }
    }

    public final void b() {
        if (this.f.tryLock()) {
            try {
                if (SystemClock.uptimeMillis() - this.e > i) {
                    c();
                }
            } finally {
                this.f.unlock();
            }
        }
    }

    @GuardedBy("lock")
    public final void c() {
        this.a = d(this.a, this.b);
        this.c = d(this.c, this.d);
        this.e = SystemClock.uptimeMillis();
    }

    @Nullable
    public final StatFs d(@Nullable StatFs statFs, @Nullable File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        if (statFs == null) {
            try {
                statFs = createStatFs(file.getAbsolutePath());
            } catch (IllegalArgumentException unused) {
                return null;
            } catch (Throwable th) {
                throw Throwables.propagate(th);
            }
        } else {
            statFs.restat(file.getAbsolutePath());
        }
        return statFs;
    }

    @SuppressLint({"DeprecatedMethod"})
    public long getAvailableStorageSpace(StorageType storageType) {
        a();
        b();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.a : this.c;
        if (statFs != null) {
            return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
        }
        return 0;
    }

    @SuppressLint({"DeprecatedMethod"})
    public long getFreeStorageSpace(StorageType storageType) {
        a();
        b();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.a : this.c;
        if (statFs != null) {
            return statFs.getBlockSizeLong() * statFs.getFreeBlocksLong();
        }
        return -1;
    }

    @SuppressLint({"DeprecatedMethod"})
    public long getTotalStorageSpace(StorageType storageType) {
        a();
        b();
        StatFs statFs = storageType == StorageType.INTERNAL ? this.a : this.c;
        if (statFs != null) {
            return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
        }
        return -1;
    }

    public boolean isHighSpaceCondition() {
        return getAvailableStorageSpace(StorageType.INTERNAL) > DEFAULT_DISK_OLIVE_LEVEL_IN_BYTES;
    }

    public boolean isLowSpaceCondition() {
        return getAvailableStorageSpace(StorageType.INTERNAL) < DEFAULT_DISK_YELLOW_LEVEL_IN_BYTES;
    }

    public boolean isVeryLowSpaceCondition() {
        return getAvailableStorageSpace(StorageType.INTERNAL) < DEFAULT_DISK_RED_LEVEL_IN_BYTES;
    }

    public void resetStats() {
        if (this.f.tryLock()) {
            try {
                a();
                c();
            } finally {
                this.f.unlock();
            }
        }
    }

    public boolean testLowDiskSpace(StorageType storageType, long j) {
        a();
        long availableStorageSpace = getAvailableStorageSpace(storageType);
        return availableStorageSpace <= 0 || availableStorageSpace < j;
    }
}
