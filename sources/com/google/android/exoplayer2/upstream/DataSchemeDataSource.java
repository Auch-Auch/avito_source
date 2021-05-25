package com.google.android.exoplayer2.upstream;

import a2.b.a.a.a;
import android.net.Uri;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Charsets;
import java.io.IOException;
import java.net.URLDecoder;
public final class DataSchemeDataSource extends BaseDataSource {
    public static final String SCHEME_DATA = "data";
    @Nullable
    public DataSpec e;
    @Nullable
    public byte[] f;
    public int g;
    public int h;

    public DataSchemeDataSource() {
        super(false);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        if (this.f != null) {
            this.f = null;
            transferEnded();
        }
        this.e = null;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        DataSpec dataSpec = this.e;
        if (dataSpec != null) {
            return dataSpec.uri;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws IOException {
        transferInitializing(dataSpec);
        this.e = dataSpec;
        this.h = (int) dataSpec.position;
        Uri uri = dataSpec.uri;
        String scheme = uri.getScheme();
        if ("data".equals(scheme)) {
            String[] split = Util.split(uri.getSchemeSpecificPart(), ",");
            if (split.length == 2) {
                String str = split[1];
                if (split[0].contains(";base64")) {
                    try {
                        this.f = Base64.decode(str, 0);
                    } catch (IllegalArgumentException e2) {
                        throw new ParserException(a.c3("Error while parsing Base64 encoded string: ", str), e2);
                    }
                } else {
                    this.f = Util.getUtf8Bytes(URLDecoder.decode(str, Charsets.US_ASCII.name()));
                }
                long j = dataSpec.length;
                int length = j != -1 ? ((int) j) + this.h : this.f.length;
                this.g = length;
                if (length > this.f.length || this.h > length) {
                    this.f = null;
                    throw new DataSourceException(0);
                }
                transferStarted(dataSpec);
                return ((long) this.g) - ((long) this.h);
            }
            throw new ParserException(a.W2("Unexpected URI format: ", uri));
        }
        throw new ParserException(a.c3("Unsupported scheme: ", scheme));
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.g - this.h;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(Util.castNonNull(this.f), this.h, bArr, i, min);
        this.h += min;
        bytesTransferred(min);
        return min;
    }
}
