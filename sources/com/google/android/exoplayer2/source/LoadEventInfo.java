package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
public final class LoadEventInfo {
    public static final AtomicLong a = new AtomicLong();
    public final long bytesLoaded;
    public final DataSpec dataSpec;
    public final long elapsedRealtimeMs;
    public final long loadDurationMs;
    public final long loadTaskId;
    public final Map<String, List<String>> responseHeaders;
    public final Uri uri;

    public LoadEventInfo(long j, DataSpec dataSpec2, long j2) {
        this(j, dataSpec2, dataSpec2.uri, Collections.emptyMap(), j2, 0, 0);
    }

    public static long getNewId() {
        return a.getAndIncrement();
    }

    public LoadEventInfo(long j, DataSpec dataSpec2, Uri uri2, Map<String, List<String>> map, long j2, long j3, long j4) {
        this.loadTaskId = j;
        this.dataSpec = dataSpec2;
        this.uri = uri2;
        this.responseHeaders = map;
        this.elapsedRealtimeMs = j2;
        this.loadDurationMs = j3;
        this.bytesLoaded = j4;
    }
}
