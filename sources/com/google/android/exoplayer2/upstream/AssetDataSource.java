package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
public final class AssetDataSource extends BaseDataSource {
    public final AssetManager e;
    @Nullable
    public Uri f;
    @Nullable
    public InputStream g;
    public long h;
    public boolean i;

    public static final class AssetDataSourceException extends IOException {
        public AssetDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public AssetDataSource(Context context) {
        super(false);
        this.e = context.getAssets();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws AssetDataSourceException {
        this.f = null;
        try {
            InputStream inputStream = this.g;
            if (inputStream != null) {
                inputStream.close();
            }
            this.g = null;
            if (this.i) {
                this.i = false;
                transferEnded();
            }
        } catch (IOException e2) {
            throw new AssetDataSourceException(e2);
        } catch (Throwable th) {
            this.g = null;
            if (this.i) {
                this.i = false;
                transferEnded();
            }
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.f;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws AssetDataSourceException {
        try {
            Uri uri = dataSpec.uri;
            this.f = uri;
            String str = (String) Assertions.checkNotNull(uri.getPath());
            if (str.startsWith("/android_asset/")) {
                str = str.substring(15);
            } else if (str.startsWith("/")) {
                str = str.substring(1);
            }
            transferInitializing(dataSpec);
            InputStream open = this.e.open(str, 1);
            this.g = open;
            if (open.skip(dataSpec.position) >= dataSpec.position) {
                long j = dataSpec.length;
                if (j != -1) {
                    this.h = j;
                } else {
                    long available = (long) this.g.available();
                    this.h = available;
                    if (available == 2147483647L) {
                        this.h = -1;
                    }
                }
                this.i = true;
                transferStarted(dataSpec);
                return this.h;
            }
            throw new EOFException();
        } catch (IOException e2) {
            throw new AssetDataSourceException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i2, int i3) throws AssetDataSourceException {
        if (i3 == 0) {
            return 0;
        }
        long j = this.h;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i3 = (int) Math.min(j, (long) i3);
            } catch (IOException e2) {
                throw new AssetDataSourceException(e2);
            }
        }
        int read = ((InputStream) Util.castNonNull(this.g)).read(bArr, i2, i3);
        if (read != -1) {
            long j2 = this.h;
            if (j2 != -1) {
                this.h = j2 - ((long) read);
            }
            bytesTransferred(read);
            return read;
        } else if (this.h == -1) {
            return -1;
        } else {
            throw new AssetDataSourceException(new EOFException());
        }
    }
}
