package com.avito.android.util;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/avito/android/util/DataDiskUsagePreOreoDelegate;", "Lcom/avito/android/util/DataDiskUsageDelegate;", "", "getAppSize", "()Ljava/lang/Void;", "", "getCacheSize", "()J", "cacheSize", "Lcom/avito/android/util/DataDirectoryProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/DataDirectoryProvider;", "getDataDirectoryProvider", "()Lcom/avito/android/util/DataDirectoryProvider;", "dataDirectoryProvider", "getDataSize", "dataSize", "<init>", "(Lcom/avito/android/util/DataDirectoryProvider;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class DataDiskUsagePreOreoDelegate implements DataDiskUsageDelegate {
    @NotNull
    public final DataDirectoryProvider a;

    public DataDiskUsagePreOreoDelegate(@NotNull DataDirectoryProvider dataDirectoryProvider) {
        Intrinsics.checkNotNullParameter(dataDirectoryProvider, "dataDirectoryProvider");
        this.a = dataDirectoryProvider;
    }

    @Override // com.avito.android.util.DataDiskUsageDelegate
    public long getCacheSize() {
        return Files.size(Files.get(this.a.getDataDir(), "cache"));
    }

    @NotNull
    public final DataDirectoryProvider getDataDirectoryProvider() {
        return this.a;
    }

    @Override // com.avito.android.util.DataDiskUsageDelegate
    public long getDataSize() {
        return Files.size(this.a.getDataDir());
    }

    @Override // com.avito.android.util.DataDiskUsageDelegate
    @NotNull
    public Void getAppSize() {
        throw new Exception("App size is unavailable prior to Android Oreo.");
    }
}
