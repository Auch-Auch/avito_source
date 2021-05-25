package com.avito.android.util;

import android.annotation.TargetApi;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/avito/android/util/DataDiskUsageDelegate;", "", "", "getAppSize", "()J", "getCacheSize", "cacheSize", "getDataSize", "dataSize", "application_release"}, k = 1, mv = {1, 4, 2})
public interface DataDiskUsageDelegate {
    @TargetApi(26)
    long getAppSize();

    long getCacheSize();

    long getDataSize();
}
