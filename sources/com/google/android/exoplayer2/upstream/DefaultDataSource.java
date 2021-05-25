package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.facebook.common.util.UriUtil;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
public final class DefaultDataSource implements DataSource {
    public final Context a;
    public final List<TransferListener> b;
    public final DataSource c;
    @Nullable
    public DataSource d;
    @Nullable
    public DataSource e;
    @Nullable
    public DataSource f;
    @Nullable
    public DataSource g;
    @Nullable
    public DataSource h;
    @Nullable
    public DataSource i;
    @Nullable
    public DataSource j;
    @Nullable
    public DataSource k;

    public DefaultDataSource(Context context, boolean z) {
        this(context, ExoPlayerLibraryInfo.DEFAULT_USER_AGENT, 8000, 8000, z);
    }

    public final void a(DataSource dataSource) {
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            dataSource.addTransferListener(this.b.get(i2));
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.c.addTransferListener(transferListener);
        this.b.add(transferListener);
        DataSource dataSource = this.d;
        if (dataSource != null) {
            dataSource.addTransferListener(transferListener);
        }
        DataSource dataSource2 = this.e;
        if (dataSource2 != null) {
            dataSource2.addTransferListener(transferListener);
        }
        DataSource dataSource3 = this.f;
        if (dataSource3 != null) {
            dataSource3.addTransferListener(transferListener);
        }
        DataSource dataSource4 = this.g;
        if (dataSource4 != null) {
            dataSource4.addTransferListener(transferListener);
        }
        DataSource dataSource5 = this.h;
        if (dataSource5 != null) {
            dataSource5.addTransferListener(transferListener);
        }
        DataSource dataSource6 = this.i;
        if (dataSource6 != null) {
            dataSource6.addTransferListener(transferListener);
        }
        DataSource dataSource7 = this.j;
        if (dataSource7 != null) {
            dataSource7.addTransferListener(transferListener);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws IOException {
        DataSource dataSource = this.k;
        if (dataSource != null) {
            DataSource dataSource2 = null;
            try {
                dataSource.close();
            } finally {
                this.k = dataSource2;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Map<String, List<String>> getResponseHeaders() {
        DataSource dataSource = this.k;
        return dataSource == null ? Collections.emptyMap() : dataSource.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        DataSource dataSource = this.k;
        if (dataSource == null) {
            return null;
        }
        return dataSource.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws IOException {
        Assertions.checkState(this.k == null);
        String scheme = dataSpec.uri.getScheme();
        if (Util.isLocalFileUri(dataSpec.uri)) {
            String path = dataSpec.uri.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                if (this.d == null) {
                    FileDataSource fileDataSource = new FileDataSource();
                    this.d = fileDataSource;
                    a(fileDataSource);
                }
                this.k = this.d;
            } else {
                if (this.e == null) {
                    AssetDataSource assetDataSource = new AssetDataSource(this.a);
                    this.e = assetDataSource;
                    a(assetDataSource);
                }
                this.k = this.e;
            }
        } else if (UriUtil.LOCAL_ASSET_SCHEME.equals(scheme)) {
            if (this.e == null) {
                AssetDataSource assetDataSource2 = new AssetDataSource(this.a);
                this.e = assetDataSource2;
                a(assetDataSource2);
            }
            this.k = this.e;
        } else if ("content".equals(scheme)) {
            if (this.f == null) {
                ContentDataSource contentDataSource = new ContentDataSource(this.a);
                this.f = contentDataSource;
                a(contentDataSource);
            }
            this.k = this.f;
        } else if ("rtmp".equals(scheme)) {
            if (this.g == null) {
                try {
                    DataSource dataSource = (DataSource) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                    this.g = dataSource;
                    a(dataSource);
                } catch (ClassNotFoundException unused) {
                    Log.w("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                } catch (Exception e2) {
                    throw new RuntimeException("Error instantiating RTMP extension", e2);
                }
                if (this.g == null) {
                    this.g = this.c;
                }
            }
            this.k = this.g;
        } else if ("udp".equals(scheme)) {
            if (this.h == null) {
                UdpDataSource udpDataSource = new UdpDataSource();
                this.h = udpDataSource;
                a(udpDataSource);
            }
            this.k = this.h;
        } else if ("data".equals(scheme)) {
            if (this.i == null) {
                DataSchemeDataSource dataSchemeDataSource = new DataSchemeDataSource();
                this.i = dataSchemeDataSource;
                a(dataSchemeDataSource);
            }
            this.k = this.i;
        } else if (RawResourceDataSource.RAW_RESOURCE_SCHEME.equals(scheme) || UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(scheme)) {
            if (this.j == null) {
                RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(this.a);
                this.j = rawResourceDataSource;
                a(rawResourceDataSource);
            }
            this.k = this.j;
        } else {
            this.k = this.c;
        }
        return this.k.open(dataSpec);
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        return ((DataSource) Assertions.checkNotNull(this.k)).read(bArr, i2, i3);
    }

    public DefaultDataSource(Context context, String str, boolean z) {
        this(context, str, 8000, 8000, z);
    }

    public DefaultDataSource(Context context, String str, int i2, int i3, boolean z) {
        this(context, new DefaultHttpDataSource(str, i2, i3, z, null));
    }

    public DefaultDataSource(Context context, DataSource dataSource) {
        this.a = context.getApplicationContext();
        this.c = (DataSource) Assertions.checkNotNull(dataSource);
        this.b = new ArrayList();
    }
}
