package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.List;
import java.util.Map;
public final class TeeDataSource implements DataSource {
    public final DataSource a;
    public final DataSink b;
    public boolean c;
    public long d;

    public TeeDataSource(DataSource dataSource, DataSink dataSink) {
        this.a = (DataSource) Assertions.checkNotNull(dataSource);
        this.b = (DataSink) Assertions.checkNotNull(dataSink);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.a.addTransferListener(transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws IOException {
        boolean z = false;
        try {
            this.a.close();
        } finally {
            if (this.c) {
                this.c = z;
                this.b.close();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Map<String, List<String>> getResponseHeaders() {
        return this.a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.a.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws IOException {
        long open = this.a.open(dataSpec);
        this.d = open;
        if (open == 0) {
            return 0;
        }
        if (dataSpec.length == -1 && open != -1) {
            dataSpec = dataSpec.subrange(0, open);
        }
        this.c = true;
        this.b.open(dataSpec);
        return this.d;
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.d == 0) {
            return -1;
        }
        int read = this.a.read(bArr, i, i2);
        if (read > 0) {
            this.b.write(bArr, i, read);
            long j = this.d;
            if (j != -1) {
                this.d = j - ((long) read);
            }
        }
        return read;
    }
}
