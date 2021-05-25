package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
public final class DefaultHttpDataSourceFactory extends HttpDataSource.BaseFactory {
    public final String b;
    @Nullable
    public final TransferListener c;
    public final int d;
    public final int e;
    public final boolean f;

    public DefaultHttpDataSourceFactory() {
        this(ExoPlayerLibraryInfo.DEFAULT_USER_AGENT);
    }

    public DefaultHttpDataSourceFactory(String str) {
        this(str, null);
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource.BaseFactory
    public DefaultHttpDataSource createDataSourceInternal(HttpDataSource.RequestProperties requestProperties) {
        DefaultHttpDataSource defaultHttpDataSource = new DefaultHttpDataSource(this.b, this.d, this.e, this.f, requestProperties);
        TransferListener transferListener = this.c;
        if (transferListener != null) {
            defaultHttpDataSource.addTransferListener(transferListener);
        }
        return defaultHttpDataSource;
    }

    public DefaultHttpDataSourceFactory(String str, @Nullable TransferListener transferListener) {
        this(str, transferListener, 8000, 8000, false);
    }

    public DefaultHttpDataSourceFactory(String str, int i, int i2, boolean z) {
        this(str, null, i, i2, z);
    }

    public DefaultHttpDataSourceFactory(String str, @Nullable TransferListener transferListener, int i, int i2, boolean z) {
        this.b = Assertions.checkNotEmpty(str);
        this.c = transferListener;
        this.d = i;
        this.e = i2;
        this.f = z;
    }
}
