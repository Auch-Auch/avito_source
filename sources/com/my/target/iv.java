package com.my.target;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.hls.DefaultHlsDataSourceFactory;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
public class iv {
    @NonNull
    public static MediaSource b(@NonNull Uri uri, @NonNull Context context) {
        DefaultDataSourceFactory defaultDataSourceFactory = new DefaultDataSourceFactory(context, Util.getUserAgent(context, "myTarget"));
        return Util.inferContentType(uri) == 2 ? new HlsMediaSource.Factory(new DefaultHlsDataSourceFactory(defaultDataSourceFactory)).createMediaSource(uri) : new ExtractorMediaSource.Factory(defaultDataSourceFactory).createMediaSource(uri);
    }
}
