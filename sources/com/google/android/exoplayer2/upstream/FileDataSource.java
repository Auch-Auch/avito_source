package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
public final class FileDataSource extends BaseDataSource {
    @Nullable
    public RandomAccessFile e;
    @Nullable
    public Uri f;
    public long g;
    public boolean h;

    public static final class Factory implements DataSource.Factory {
        @Nullable
        public TransferListener a;

        public Factory setListener(@Nullable TransferListener transferListener) {
            this.a = transferListener;
            return this;
        }

        @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
        public FileDataSource createDataSource() {
            FileDataSource fileDataSource = new FileDataSource();
            TransferListener transferListener = this.a;
            if (transferListener != null) {
                fileDataSource.addTransferListener(transferListener);
            }
            return fileDataSource;
        }
    }

    public static class FileDataSourceException extends IOException {
        public FileDataSourceException(IOException iOException) {
            super(iOException);
        }

        public FileDataSourceException(String str, IOException iOException) {
            super(str, iOException);
        }
    }

    public FileDataSource() {
        super(false);
    }

    public static RandomAccessFile a(Uri uri) throws FileDataSourceException {
        try {
            return new RandomAccessFile((String) Assertions.checkNotNull(uri.getPath()), "r");
        } catch (FileNotFoundException e2) {
            if (!TextUtils.isEmpty(uri.getQuery()) || !TextUtils.isEmpty(uri.getFragment())) {
                throw new FileDataSourceException(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), e2);
            }
            throw new FileDataSourceException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws FileDataSourceException {
        this.f = null;
        try {
            RandomAccessFile randomAccessFile = this.e;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            this.e = null;
            if (this.h) {
                this.h = false;
                transferEnded();
            }
        } catch (IOException e2) {
            throw new FileDataSourceException(e2);
        } catch (Throwable th) {
            this.e = null;
            if (this.h) {
                this.h = false;
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
    public long open(DataSpec dataSpec) throws FileDataSourceException {
        try {
            Uri uri = dataSpec.uri;
            this.f = uri;
            transferInitializing(dataSpec);
            RandomAccessFile a = a(uri);
            this.e = a;
            a.seek(dataSpec.position);
            long j = dataSpec.length;
            if (j == -1) {
                j = this.e.length() - dataSpec.position;
            }
            this.g = j;
            if (j >= 0) {
                this.h = true;
                transferStarted(dataSpec);
                return this.g;
            }
            throw new EOFException();
        } catch (IOException e2) {
            throw new FileDataSourceException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws FileDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        if (this.g == 0) {
            return -1;
        }
        try {
            int read = ((RandomAccessFile) Util.castNonNull(this.e)).read(bArr, i, (int) Math.min(this.g, (long) i2));
            if (read > 0) {
                this.g -= (long) read;
                bytesTransferred(read);
            }
            return read;
        } catch (IOException e2) {
            throw new FileDataSourceException(e2);
        }
    }
}
