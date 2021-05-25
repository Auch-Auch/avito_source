package com.facebook.common.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
public class PooledByteStreams {
    public final int a;
    public final ByteArrayPool b;

    public PooledByteStreams(ByteArrayPool byteArrayPool) {
        this(byteArrayPool, 16384);
    }

    public long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = (byte[]) this.b.get(this.a);
        long j = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, this.a);
                if (read == -1) {
                    return j;
                }
                outputStream.write(bArr, 0, read);
                j += (long) read;
            } finally {
                this.b.release(bArr);
            }
        }
    }

    @VisibleForTesting
    public PooledByteStreams(ByteArrayPool byteArrayPool, int i) {
        Preconditions.checkArgument(i > 0);
        this.a = i;
        this.b = byteArrayPool;
    }

    public long copy(InputStream inputStream, OutputStream outputStream, long j) throws IOException {
        long j2 = 0;
        Preconditions.checkState(j > 0);
        byte[] bArr = (byte[]) this.b.get(this.a);
        while (j2 < j) {
            try {
                int read = inputStream.read(bArr, 0, (int) Math.min((long) this.a, j - j2));
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
                j2 += (long) read;
            } catch (Throwable th) {
                this.b.release(bArr);
                throw th;
            }
        }
        this.b.release(bArr);
        return j2;
    }
}
