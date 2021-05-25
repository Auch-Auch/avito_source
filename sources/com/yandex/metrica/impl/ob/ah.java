package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import java.util.UUID;
public class ah {
    @NonNull
    private final Context a;
    @NonNull
    private final b b;

    public static class a {
        public final long a;
        public final long b;

        public a(long j, long j2) {
            this.a = j;
            this.b = j2;
        }
    }

    public static class b {
        @NonNull
        public StatFs a() {
            return new StatFs(Environment.getDataDirectory().getAbsolutePath());
        }
    }

    public ah(@NonNull Context context) {
        this(context, new b());
    }

    @NonNull
    @TargetApi(26)
    private a b() {
        long j;
        StorageStatsManager storageStatsManager = (StorageStatsManager) this.a.getSystemService("storagestats");
        StorageManager storageManager = (StorageManager) this.a.getSystemService("storage");
        long j2 = 0;
        if (storageManager == null || storageStatsManager == null) {
            j = 0;
        } else {
            j = 0;
            for (StorageVolume storageVolume : storageManager.getStorageVolumes()) {
                try {
                    String uuid = storageVolume.getUuid();
                    UUID fromString = uuid == null ? StorageManager.UUID_DEFAULT : UUID.fromString(uuid);
                    j2 += storageStatsManager.getTotalBytes(fromString);
                    j += storageStatsManager.getFreeBytes(fromString);
                } catch (Throwable unused) {
                }
            }
        }
        return new a(j2 / 1024, j / 1024);
    }

    @NonNull
    @TargetApi(18)
    private a c() {
        try {
            StatFs a3 = this.b.a();
            long blockSizeLong = a3.getBlockSizeLong();
            return new a((a3.getBlockCountLong() * blockSizeLong) / 1024, (a3.getAvailableBlocksLong() * blockSizeLong) / 1024);
        } catch (Throwable unused) {
            return new a(0, 0);
        }
    }

    @NonNull
    private a d() {
        try {
            StatFs a3 = this.b.a();
            long blockSize = (long) a3.getBlockSize();
            return new a((((long) a3.getBlockCount()) * blockSize) / 1024, (((long) a3.getAvailableBlocks()) * blockSize) / 1024);
        } catch (Throwable unused) {
            return new a(0, 0);
        }
    }

    @NonNull
    public a a() {
        if (dl.a(26)) {
            return b();
        }
        if (dl.a(18)) {
            return c();
        }
        return d();
    }

    @VisibleForTesting
    public ah(@NonNull Context context, @NonNull b bVar) {
        this.a = context;
        this.b = bVar;
    }
}
