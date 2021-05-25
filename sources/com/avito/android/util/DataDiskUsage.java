package com.avito.android.util;

import android.annotation.TargetApi;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0019\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0004R\u0016\u0010\u0012\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0004R\u0016\u0010\u0014\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0004R\u0016\u0010\u0016\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0004R\u0016\u0010\u0018\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0004R\u0016\u0010\u001a\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/avito/android/util/DataDiskUsage;", "", "", "apkSize", "()J", "getAppWebviewSize", "appWebviewSize", "getNoBackupSize", "noBackupSize", "getCodeCacheSize", "codeCacheSize", "getFreeSpace", "freeSpace", "getTotalSpace", "totalSpace", "getSharedPrefsSize", "sharedPrefsSize", "getFilesSize", "filesSize", "getLibSize", "libSize", "getDataSize", "dataSize", "getDatabasesSize", "databasesSize", "getCacheSize", "cacheSize", "application_release"}, k = 1, mv = {1, 4, 2})
public interface DataDiskUsage {
    @TargetApi(26)
    long apkSize();

    long getAppWebviewSize();

    long getCacheSize();

    long getCodeCacheSize();

    long getDataSize();

    long getDatabasesSize();

    long getFilesSize();

    long getFreeSpace();

    long getLibSize();

    long getNoBackupSize();

    long getSharedPrefsSize();

    long getTotalSpace();
}
