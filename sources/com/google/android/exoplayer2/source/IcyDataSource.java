package com.google.android.exoplayer2.source;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.List;
import java.util.Map;
public final class IcyDataSource implements DataSource {
    public final DataSource a;
    public final int b;
    public final Listener c;
    public final byte[] d;
    public int e;

    public interface Listener {
        void onIcyMetadata(ParsableByteArray parsableByteArray);
    }

    public IcyDataSource(DataSource dataSource, int i, Listener listener) {
        Assertions.checkArgument(i > 0);
        this.a = dataSource;
        this.b = i;
        this.c = listener;
        this.d = new byte[1];
        this.e = i;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.a.addTransferListener(transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        throw new UnsupportedOperationException();
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
    public long open(DataSpec dataSpec) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004d A[RETURN] */
    @Override // com.google.android.exoplayer2.upstream.DataReader
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read(byte[] r9, int r10, int r11) throws java.io.IOException {
        /*
            r8 = this;
            int r0 = r8.e
            r1 = -1
            if (r0 != 0) goto L_0x004e
            com.google.android.exoplayer2.upstream.DataSource r0 = r8.a
            byte[] r2 = r8.d
            r3 = 1
            r4 = 0
            int r0 = r0.read(r2, r4, r3)
            if (r0 != r1) goto L_0x0013
        L_0x0011:
            r3 = 0
            goto L_0x0046
        L_0x0013:
            byte[] r0 = r8.d
            byte r0 = r0[r4]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r0 = r0 << 4
            if (r0 != 0) goto L_0x001e
            goto L_0x0046
        L_0x001e:
            byte[] r2 = new byte[r0]
            r5 = r0
            r6 = 0
        L_0x0022:
            if (r5 <= 0) goto L_0x0030
            com.google.android.exoplayer2.upstream.DataSource r7 = r8.a
            int r7 = r7.read(r2, r6, r5)
            if (r7 != r1) goto L_0x002d
            goto L_0x0011
        L_0x002d:
            int r6 = r6 + r7
            int r5 = r5 - r7
            goto L_0x0022
        L_0x0030:
            if (r0 <= 0) goto L_0x003a
            int r4 = r0 + -1
            byte r5 = r2[r4]
            if (r5 != 0) goto L_0x003a
            r0 = r4
            goto L_0x0030
        L_0x003a:
            if (r0 <= 0) goto L_0x0046
            com.google.android.exoplayer2.source.IcyDataSource$Listener r4 = r8.c
            com.google.android.exoplayer2.util.ParsableByteArray r5 = new com.google.android.exoplayer2.util.ParsableByteArray
            r5.<init>(r2, r0)
            r4.onIcyMetadata(r5)
        L_0x0046:
            if (r3 == 0) goto L_0x004d
            int r0 = r8.b
            r8.e = r0
            goto L_0x004e
        L_0x004d:
            return r1
        L_0x004e:
            com.google.android.exoplayer2.upstream.DataSource r0 = r8.a
            int r2 = r8.e
            int r11 = java.lang.Math.min(r2, r11)
            int r9 = r0.read(r9, r10, r11)
            if (r9 == r1) goto L_0x0061
            int r10 = r8.e
            int r10 = r10 - r9
            r8.e = r10
        L_0x0061:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.IcyDataSource.read(byte[], int, int):int");
    }
}
