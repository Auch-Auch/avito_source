package com.google.android.exoplayer2.upstream;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.upstream.DataSource;
public final class DefaultDataSourceFactory implements DataSource.Factory {
    public final Context a;
    @Nullable
    public final TransferListener b;
    public final DataSource.Factory c;

    public DefaultDataSourceFactory(Context context) {
        this(context, ExoPlayerLibraryInfo.DEFAULT_USER_AGENT, (TransferListener) null);
    }

    public DefaultDataSourceFactory(Context context, String str) {
        this(context, str, (TransferListener) null);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
    public DefaultDataSource createDataSource() {
        DefaultDataSource defaultDataSource = new DefaultDataSource(this.a, this.c.createDataSource());
        TransferListener transferListener = this.b;
        if (transferListener != null) {
            defaultDataSource.addTransferListener(transferListener);
        }
        return defaultDataSource;
    }

    public DefaultDataSourceFactory(Context context, String str, @Nullable TransferListener transferListener) {
        this(context, transferListener, new DefaultHttpDataSourceFactory(str, transferListener));
    }

    public DefaultDataSourceFactory(Context context, DataSource.Factory factory) {
        this(context, (TransferListener) null, factory);
    }

    public DefaultDataSourceFactory(Context context, @Nullable TransferListener transferListener, DataSource.Factory factory) {
        this.a = context.getApplicationContext();
        this.b = transferListener;
        this.c = factory;
    }
}
