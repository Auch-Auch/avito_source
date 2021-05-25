package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.MemoryFile;
import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import javax.annotation.Nullable;
@DoNotStrip
public class GingerbreadPurgeableDecoder extends DalvikPurgeableDecoder {
    public static Method c;
    @Nullable
    public final WebpBitmapFactory b = WebpSupportStatus.loadWebpBitmapFactoryIfExists();

    public static MemoryFile a(CloseableReference<PooledByteBuffer> closeableReference, int i, @Nullable byte[] bArr) throws IOException {
        Closeable closeable;
        Throwable th;
        LimitedInputStream limitedInputStream;
        PooledByteBufferInputStream pooledByteBufferInputStream = null;
        MemoryFile memoryFile = new MemoryFile(null, (bArr == null ? 0 : bArr.length) + i);
        memoryFile.allowPurging(false);
        try {
            PooledByteBufferInputStream pooledByteBufferInputStream2 = new PooledByteBufferInputStream(closeableReference.get());
            try {
                limitedInputStream = new LimitedInputStream(pooledByteBufferInputStream2, i);
                try {
                    OutputStream outputStream = memoryFile.getOutputStream();
                    ByteStreams.copy(limitedInputStream, outputStream);
                    if (bArr != null) {
                        memoryFile.writeBytes(bArr, 0, i, bArr.length);
                    }
                    CloseableReference.closeSafely(closeableReference);
                    Closeables.closeQuietly(pooledByteBufferInputStream2);
                    Closeables.closeQuietly(limitedInputStream);
                    Closeables.close(outputStream, true);
                    return memoryFile;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = null;
                    pooledByteBufferInputStream = pooledByteBufferInputStream2;
                    CloseableReference.closeSafely(closeableReference);
                    Closeables.closeQuietly(pooledByteBufferInputStream);
                    Closeables.closeQuietly(limitedInputStream);
                    Closeables.close(closeable, true);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                closeable = null;
                limitedInputStream = null;
                pooledByteBufferInputStream = pooledByteBufferInputStream2;
                CloseableReference.closeSafely(closeableReference);
                Closeables.closeQuietly(pooledByteBufferInputStream);
                Closeables.closeQuietly(limitedInputStream);
                Closeables.close(closeable, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            closeable = null;
            limitedInputStream = null;
            CloseableReference.closeSafely(closeableReference);
            Closeables.closeQuietly(pooledByteBufferInputStream);
            Closeables.closeQuietly(limitedInputStream);
            Closeables.close(closeable, true);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0035  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap b(com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> r2, int r3, byte[] r4, android.graphics.BitmapFactory.Options r5) {
        /*
            r1 = this;
            r0 = 0
            android.os.MemoryFile r2 = a(r2, r3, r4)     // Catch:{ IOException -> 0x002d }
            java.io.FileDescriptor r3 = r1.c(r2)     // Catch:{ IOException -> 0x0028, all -> 0x0025 }
            com.facebook.common.webp.WebpBitmapFactory r4 = r1.b     // Catch:{ IOException -> 0x0028, all -> 0x0025 }
            if (r4 == 0) goto L_0x001d
            android.graphics.Bitmap r3 = r4.decodeFileDescriptor(r3, r0, r5)     // Catch:{ IOException -> 0x0028, all -> 0x0025 }
            java.lang.String r4 = "BitmapFactory returned null"
            java.lang.Object r3 = com.facebook.common.internal.Preconditions.checkNotNull(r3, r4)     // Catch:{ IOException -> 0x0028, all -> 0x0025 }
            android.graphics.Bitmap r3 = (android.graphics.Bitmap) r3     // Catch:{ IOException -> 0x0028, all -> 0x0025 }
            r2.close()
            return r3
        L_0x001d:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "WebpBitmapFactory is null"
            r3.<init>(r4)
            throw r3
        L_0x0025:
            r3 = move-exception
            r0 = r2
            goto L_0x0033
        L_0x0028:
            r3 = move-exception
            r0 = r2
            goto L_0x002e
        L_0x002b:
            r3 = move-exception
            goto L_0x0033
        L_0x002d:
            r3 = move-exception
        L_0x002e:
            java.lang.RuntimeException r2 = com.facebook.common.internal.Throwables.propagate(r3)     // Catch:{ all -> 0x002b }
            throw r2     // Catch:{ all -> 0x002b }
        L_0x0033:
            if (r0 == 0) goto L_0x0038
            r0.close()
        L_0x0038:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.platform.GingerbreadPurgeableDecoder.b(com.facebook.common.references.CloseableReference, int, byte[], android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    public final FileDescriptor c(MemoryFile memoryFile) {
        Method method;
        try {
            synchronized (this) {
                if (c == null) {
                    try {
                        c = MemoryFile.class.getDeclaredMethod("getFileDescriptor", new Class[0]);
                    } catch (Exception e) {
                        throw Throwables.propagate(e);
                    }
                }
                method = c;
            }
            return (FileDescriptor) method.invoke(memoryFile, new Object[0]);
        } catch (Exception e2) {
            throw Throwables.propagate(e2);
        }
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    public Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, BitmapFactory.Options options) {
        return b(closeableReference, closeableReference.get().size(), null, options);
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    public Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, int i, BitmapFactory.Options options) {
        return b(closeableReference, i, DalvikPurgeableDecoder.endsWithEOI(closeableReference, i) ? null : DalvikPurgeableDecoder.EOI, options);
    }
}
