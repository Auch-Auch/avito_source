package com.google.android.exoplayer2.source;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import java.util.List;
public interface MediaSourceFactory {
    @Deprecated
    MediaSource createMediaSource(Uri uri);

    MediaSource createMediaSource(MediaItem mediaItem);

    int[] getSupportedTypes();

    MediaSourceFactory setDrmHttpDataSourceFactory(@Nullable HttpDataSource.Factory factory);

    MediaSourceFactory setDrmSessionManager(@Nullable DrmSessionManager drmSessionManager);

    MediaSourceFactory setDrmUserAgent(@Nullable String str);

    MediaSourceFactory setLoadErrorHandlingPolicy(@Nullable LoadErrorHandlingPolicy loadErrorHandlingPolicy);

    @Deprecated
    MediaSourceFactory setStreamKeys(@Nullable List<StreamKey> list);
}
