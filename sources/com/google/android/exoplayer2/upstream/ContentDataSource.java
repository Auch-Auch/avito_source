package com.google.android.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
public final class ContentDataSource extends BaseDataSource {
    public final ContentResolver e;
    @Nullable
    public Uri f;
    @Nullable
    public AssetFileDescriptor g;
    @Nullable
    public FileInputStream h;
    public long i;
    public boolean j;

    public static class ContentDataSourceException extends IOException {
        public ContentDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public ContentDataSource(Context context) {
        super(false);
        this.e = context.getContentResolver();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws ContentDataSourceException {
        this.f = null;
        try {
            FileInputStream fileInputStream = this.h;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            this.h = null;
            try {
                AssetFileDescriptor assetFileDescriptor = this.g;
                if (assetFileDescriptor != null) {
                    assetFileDescriptor.close();
                }
                this.g = null;
                if (this.j) {
                    this.j = false;
                    transferEnded();
                }
            } catch (IOException e2) {
                throw new ContentDataSourceException(e2);
            } catch (Throwable th) {
                this.g = null;
                if (this.j) {
                    this.j = false;
                    transferEnded();
                }
                throw th;
            }
        } catch (IOException e3) {
            throw new ContentDataSourceException(e3);
        } catch (Throwable th2) {
            this.h = null;
            try {
                AssetFileDescriptor assetFileDescriptor2 = this.g;
                if (assetFileDescriptor2 != null) {
                    assetFileDescriptor2.close();
                }
                this.g = null;
                if (this.j) {
                    this.j = false;
                    transferEnded();
                }
                throw th2;
            } catch (IOException e4) {
                throw new ContentDataSourceException(e4);
            } catch (Throwable th3) {
                this.g = null;
                if (this.j) {
                    this.j = false;
                    transferEnded();
                }
                throw th3;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.f;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws ContentDataSourceException {
        try {
            Uri uri = dataSpec.uri;
            this.f = uri;
            transferInitializing(dataSpec);
            AssetFileDescriptor openAssetFileDescriptor = this.e.openAssetFileDescriptor(uri, "r");
            this.g = openAssetFileDescriptor;
            if (openAssetFileDescriptor != null) {
                FileInputStream fileInputStream = new FileInputStream(openAssetFileDescriptor.getFileDescriptor());
                this.h = fileInputStream;
                long startOffset = openAssetFileDescriptor.getStartOffset();
                long skip = fileInputStream.skip(dataSpec.position + startOffset) - startOffset;
                if (skip == dataSpec.position) {
                    long j2 = dataSpec.length;
                    if (j2 != -1) {
                        this.i = j2;
                    } else {
                        long length = openAssetFileDescriptor.getLength();
                        if (length == -1) {
                            FileChannel channel = fileInputStream.getChannel();
                            long size = channel.size();
                            if (size == 0) {
                                this.i = -1;
                            } else {
                                long position = size - channel.position();
                                this.i = position;
                                if (position < 0) {
                                    throw new EOFException();
                                }
                            }
                        } else {
                            long j3 = length - skip;
                            this.i = j3;
                            if (j3 < 0) {
                                throw new EOFException();
                            }
                        }
                    }
                    this.j = true;
                    transferStarted(dataSpec);
                    return this.i;
                }
                throw new EOFException();
            }
            throw new FileNotFoundException("Could not open file descriptor for: " + uri);
        } catch (IOException e2) {
            throw new ContentDataSourceException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i2, int i3) throws ContentDataSourceException {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.i;
        if (j2 == 0) {
            return -1;
        }
        if (j2 != -1) {
            try {
                i3 = (int) Math.min(j2, (long) i3);
            } catch (IOException e2) {
                throw new ContentDataSourceException(e2);
            }
        }
        int read = ((FileInputStream) Util.castNonNull(this.h)).read(bArr, i2, i3);
        if (read != -1) {
            long j3 = this.i;
            if (j3 != -1) {
                this.i = j3 - ((long) read);
            }
            bytesTransferred(read);
            return read;
        } else if (this.i == -1) {
            return -1;
        } else {
            throw new ContentDataSourceException(new EOFException());
        }
    }
}
