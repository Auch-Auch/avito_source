package com.google.android.exoplayer2.upstream;

import a2.b.a.a.a;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.common.util.UriUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
public final class RawResourceDataSource extends BaseDataSource {
    public static final String RAW_RESOURCE_SCHEME = "rawresource";
    public final Resources e;
    public final String f;
    @Nullable
    public Uri g;
    @Nullable
    public AssetFileDescriptor h;
    @Nullable
    public InputStream i;
    public long j;
    public boolean k;

    public static class RawResourceDataSourceException extends IOException {
        public RawResourceDataSourceException(String str) {
            super(str);
        }

        public RawResourceDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public RawResourceDataSource(Context context) {
        super(false);
        this.e = context.getResources();
        this.f = context.getPackageName();
    }

    public static Uri buildRawResourceUri(int i2) {
        return Uri.parse("rawresource:///" + i2);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws RawResourceDataSourceException {
        this.g = null;
        try {
            InputStream inputStream = this.i;
            if (inputStream != null) {
                inputStream.close();
            }
            this.i = null;
            try {
                AssetFileDescriptor assetFileDescriptor = this.h;
                if (assetFileDescriptor != null) {
                    assetFileDescriptor.close();
                }
                this.h = null;
                if (this.k) {
                    this.k = false;
                    transferEnded();
                }
            } catch (IOException e2) {
                throw new RawResourceDataSourceException(e2);
            } catch (Throwable th) {
                this.h = null;
                if (this.k) {
                    this.k = false;
                    transferEnded();
                }
                throw th;
            }
        } catch (IOException e3) {
            throw new RawResourceDataSourceException(e3);
        } catch (Throwable th2) {
            this.i = null;
            try {
                AssetFileDescriptor assetFileDescriptor2 = this.h;
                if (assetFileDescriptor2 != null) {
                    assetFileDescriptor2.close();
                }
                this.h = null;
                if (this.k) {
                    this.k = false;
                    transferEnded();
                }
                throw th2;
            } catch (IOException e4) {
                throw new RawResourceDataSourceException(e4);
            } catch (Throwable th3) {
                this.h = null;
                if (this.k) {
                    this.k = false;
                    transferEnded();
                }
                throw th3;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.g;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws RawResourceDataSourceException {
        int i2;
        Uri uri = dataSpec.uri;
        this.g = uri;
        if (TextUtils.equals(RAW_RESOURCE_SCHEME, uri.getScheme()) || (TextUtils.equals(UriUtil.QUALIFIED_RESOURCE_SCHEME, uri.getScheme()) && uri.getPathSegments().size() == 1 && ((String) Assertions.checkNotNull(uri.getLastPathSegment())).matches("\\d+"))) {
            try {
                i2 = Integer.parseInt((String) Assertions.checkNotNull(uri.getLastPathSegment()));
            } catch (NumberFormatException unused) {
                throw new RawResourceDataSourceException("Resource identifier must be an integer.");
            }
        } else if (TextUtils.equals(UriUtil.QUALIFIED_RESOURCE_SCHEME, uri.getScheme())) {
            String str = (String) Assertions.checkNotNull(uri.getPath());
            if (str.startsWith("/")) {
                str = str.substring(1);
            }
            String host = uri.getHost();
            i2 = this.e.getIdentifier(a.t(new StringBuilder(), TextUtils.isEmpty(host) ? "" : a.c3(host, ":"), str), "raw", this.f);
            if (i2 == 0) {
                throw new RawResourceDataSourceException("Resource not found.");
            }
        } else {
            throw new RawResourceDataSourceException("URI must either use scheme rawresource or android.resource");
        }
        transferInitializing(dataSpec);
        AssetFileDescriptor openRawResourceFd = this.e.openRawResourceFd(i2);
        this.h = openRawResourceFd;
        if (openRawResourceFd != null) {
            FileInputStream fileInputStream = new FileInputStream(openRawResourceFd.getFileDescriptor());
            this.i = fileInputStream;
            try {
                fileInputStream.skip(openRawResourceFd.getStartOffset());
                if (fileInputStream.skip(dataSpec.position) >= dataSpec.position) {
                    long j2 = dataSpec.length;
                    long j3 = -1;
                    if (j2 != -1) {
                        this.j = j2;
                    } else {
                        long length = openRawResourceFd.getLength();
                        if (length != -1) {
                            j3 = length - dataSpec.position;
                        }
                        this.j = j3;
                    }
                    this.k = true;
                    transferStarted(dataSpec);
                    return this.j;
                }
                throw new EOFException();
            } catch (IOException e2) {
                throw new RawResourceDataSourceException(e2);
            }
        } else {
            throw new RawResourceDataSourceException(a.W2("Resource is compressed: ", uri));
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i2, int i3) throws RawResourceDataSourceException {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.j;
        if (j2 == 0) {
            return -1;
        }
        if (j2 != -1) {
            try {
                i3 = (int) Math.min(j2, (long) i3);
            } catch (IOException e2) {
                throw new RawResourceDataSourceException(e2);
            }
        }
        int read = ((InputStream) Util.castNonNull(this.i)).read(bArr, i2, i3);
        if (read != -1) {
            long j3 = this.j;
            if (j3 != -1) {
                this.j = j3 - ((long) read);
            }
            bytesTransferred(read);
            return read;
        } else if (this.j == -1) {
            return -1;
        } else {
            throw new RawResourceDataSourceException(new EOFException());
        }
    }
}
