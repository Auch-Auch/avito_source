package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteArrayBufferedInputStream;
import com.facebook.common.util.StreamUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.IOException;
public class ProgressiveJpegParser {
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public boolean g;
    public final ByteArrayPool h;

    public ProgressiveJpegParser(ByteArrayPool byteArrayPool) {
        this.h = (ByteArrayPool) Preconditions.checkNotNull(byteArrayPool);
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x0099 A[Catch:{ IOException -> 0x00b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009c A[Catch:{ IOException -> 0x00b7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.io.InputStream r13) {
        /*
        // Method dump skipped, instructions count: 197
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.decoder.ProgressiveJpegParser.a(java.io.InputStream):boolean");
    }

    public int getBestScanEndOffset() {
        return this.f;
    }

    public int getBestScanNumber() {
        return this.e;
    }

    public boolean isEndMarkerRead() {
        return this.g;
    }

    public boolean isJpeg() {
        return this.c > 1 && this.a != 6;
    }

    public boolean parseMoreData(EncodedImage encodedImage) {
        if (this.a == 6 || encodedImage.getSize() <= this.c) {
            return false;
        }
        PooledByteArrayBufferedInputStream pooledByteArrayBufferedInputStream = new PooledByteArrayBufferedInputStream(encodedImage.getInputStream(), (byte[]) this.h.get(16384), this.h);
        try {
            StreamUtil.skip(pooledByteArrayBufferedInputStream, (long) this.c);
            return a(pooledByteArrayBufferedInputStream);
        } catch (IOException e2) {
            Throwables.propagate(e2);
            return false;
        } finally {
            Closeables.closeQuietly(pooledByteArrayBufferedInputStream);
        }
    }
}
