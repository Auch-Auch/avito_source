package com.avito.android.util;

import com.avito.android.remote.auth.AuthSource;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010#\u001a\u00020 ¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0004R\u0016\u0010\u0013\u001a\u00020\u00118B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0004R\u0016\u0010\u0017\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0004R\u0016\u0010\u0019\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0004R\u0016\u0010\u001b\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0004R\u0016\u0010\u001d\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0004R\u0016\u0010\u001f\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0004R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0004¨\u0006("}, d2 = {"Lcom/avito/android/util/DataDiskUsageImpl;", "Lcom/avito/android/util/DataDiskUsage;", "", "apkSize", "()J", "getDatabasesSize", "databasesSize", "getTotalSpace", "totalSpace", "getFreeSpace", "freeSpace", "Lcom/avito/android/util/DataDirectoryProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/DataDirectoryProvider;", "dataDirectoryProvider", "getDataSize", "dataSize", "Ljava/io/File;", "()Ljava/io/File;", "dataDir", "getAppWebviewSize", "appWebviewSize", "getFilesSize", "filesSize", "getCodeCacheSize", "codeCacheSize", "getCacheSize", "cacheSize", "getSharedPrefsSize", "sharedPrefsSize", "getLibSize", "libSize", "Lcom/avito/android/util/DataDiskUsageDelegate;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/DataDiskUsageDelegate;", "delegate", "getNoBackupSize", "noBackupSize", "<init>", "(Lcom/avito/android/util/DataDirectoryProvider;Lcom/avito/android/util/DataDiskUsageDelegate;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class DataDiskUsageImpl implements DataDiskUsage {
    public final DataDirectoryProvider a;
    public final DataDiskUsageDelegate b;

    public DataDiskUsageImpl(@NotNull DataDirectoryProvider dataDirectoryProvider, @NotNull DataDiskUsageDelegate dataDiskUsageDelegate) {
        Intrinsics.checkNotNullParameter(dataDirectoryProvider, "dataDirectoryProvider");
        Intrinsics.checkNotNullParameter(dataDiskUsageDelegate, "delegate");
        this.a = dataDirectoryProvider;
        this.b = dataDiskUsageDelegate;
    }

    public final File a() {
        return this.a.getDataDir();
    }

    @Override // com.avito.android.util.DataDiskUsage
    public long apkSize() {
        return this.b.getAppSize();
    }

    @Override // com.avito.android.util.DataDiskUsage
    public long getAppWebviewSize() {
        return Files.size(Files.get(a(), "app_webview"));
    }

    @Override // com.avito.android.util.DataDiskUsage
    public long getCacheSize() {
        return this.b.getCacheSize();
    }

    @Override // com.avito.android.util.DataDiskUsage
    public long getCodeCacheSize() {
        return Files.size(Files.get(a(), "code_cache"));
    }

    @Override // com.avito.android.util.DataDiskUsage
    public long getDataSize() {
        return this.b.getDataSize();
    }

    @Override // com.avito.android.util.DataDiskUsage
    public long getDatabasesSize() {
        return Files.size(Files.get(a(), "databases"));
    }

    @Override // com.avito.android.util.DataDiskUsage
    public long getFilesSize() {
        return Files.size(Files.get(a(), "files"));
    }

    @Override // com.avito.android.util.DataDiskUsage
    public long getFreeSpace() {
        return a().getFreeSpace();
    }

    @Override // com.avito.android.util.DataDiskUsage
    public long getLibSize() {
        return Files.size(Files.get(a(), "lib"));
    }

    @Override // com.avito.android.util.DataDiskUsage
    public long getNoBackupSize() {
        return Files.size(Files.get(a(), "no_backup"));
    }

    @Override // com.avito.android.util.DataDiskUsage
    public long getSharedPrefsSize() {
        return Files.size(Files.get(a(), "shared_prefs"));
    }

    @Override // com.avito.android.util.DataDiskUsage
    public long getTotalSpace() {
        return a().getTotalSpace();
    }
}
