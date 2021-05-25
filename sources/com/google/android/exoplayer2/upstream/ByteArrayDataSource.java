package com.google.android.exoplayer2.upstream;

import a2.b.a.a.a;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
public final class ByteArrayDataSource extends BaseDataSource {
    public final byte[] e;
    @Nullable
    public Uri f;
    public int g;
    public int h;
    public boolean i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ByteArrayDataSource(byte[] bArr) {
        super(false);
        boolean z = false;
        Assertions.checkNotNull(bArr);
        Assertions.checkArgument(bArr.length > 0 ? true : z);
        this.e = bArr;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        if (this.i) {
            this.i = false;
            transferEnded();
        }
        this.f = null;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        return this.f;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws IOException {
        this.f = dataSpec.uri;
        transferInitializing(dataSpec);
        long j = dataSpec.position;
        int i2 = (int) j;
        this.g = i2;
        long j2 = dataSpec.length;
        if (j2 == -1) {
            j2 = ((long) this.e.length) - j;
        }
        int i3 = (int) j2;
        this.h = i3;
        if (i3 <= 0 || i2 + i3 > this.e.length) {
            StringBuilder L = a.L("Unsatisfiable range: [");
            L.append(this.g);
            L.append(", ");
            L.append(dataSpec.length);
            L.append("], length: ");
            L.append(this.e.length);
            throw new IOException(L.toString());
        }
        this.i = true;
        transferStarted(dataSpec);
        return (long) this.h;
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        int i4 = this.h;
        if (i4 == 0) {
            return -1;
        }
        int min = Math.min(i3, i4);
        System.arraycopy(this.e, this.g, bArr, i2, min);
        this.g += min;
        this.h -= min;
        bytesTransferred(min);
        return min;
    }
}
