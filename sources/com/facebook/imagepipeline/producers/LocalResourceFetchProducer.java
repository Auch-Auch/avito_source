package com.facebook.imagepipeline.producers;

import android.content.res.Resources;
import com.facebook.common.memory.PooledByteBufferFactory;
import java.util.concurrent.Executor;
public class LocalResourceFetchProducer extends LocalFetchProducer {
    public static final String PRODUCER_NAME = "LocalResourceFetchProducer";
    public final Resources c;

    public LocalResourceFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, Resources resources) {
        super(executor, pooledByteBufferFactory);
        this.c = resources;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003c, code lost:
        if (r1 == null) goto L_0x0041;
     */
    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.imagepipeline.image.EncodedImage getEncodedImage(com.facebook.imagepipeline.request.ImageRequest r5) throws java.io.IOException {
        /*
            r4 = this;
            android.content.res.Resources r0 = r4.c
            android.net.Uri r1 = r5.getSourceUri()
            java.lang.String r1 = r1.getPath()
            r2 = 1
            java.lang.String r1 = r1.substring(r2)
            int r1 = java.lang.Integer.parseInt(r1)
            java.io.InputStream r0 = r0.openRawResource(r1)
            r1 = 0
            android.content.res.Resources r3 = r4.c     // Catch:{ NotFoundException -> 0x003b, all -> 0x0034 }
            android.net.Uri r5 = r5.getSourceUri()     // Catch:{ NotFoundException -> 0x003b, all -> 0x0034 }
            java.lang.String r5 = r5.getPath()     // Catch:{ NotFoundException -> 0x003b, all -> 0x0034 }
            java.lang.String r5 = r5.substring(r2)     // Catch:{ NotFoundException -> 0x003b, all -> 0x0034 }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ NotFoundException -> 0x003b, all -> 0x0034 }
            android.content.res.AssetFileDescriptor r1 = r3.openRawResourceFd(r5)     // Catch:{ NotFoundException -> 0x003b, all -> 0x0034 }
            long r2 = r1.getLength()     // Catch:{ NotFoundException -> 0x003b, all -> 0x0034 }
            int r5 = (int) r2
            goto L_0x003e
        L_0x0034:
            r5 = move-exception
            if (r1 == 0) goto L_0x003a
            r1.close()     // Catch:{ IOException -> 0x003a }
        L_0x003a:
            throw r5
        L_0x003b:
            r5 = -1
            if (r1 == 0) goto L_0x0041
        L_0x003e:
            r1.close()     // Catch:{ IOException -> 0x0041 }
        L_0x0041:
            com.facebook.imagepipeline.image.EncodedImage r5 = r4.getEncodedImage(r0, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.LocalResourceFetchProducer.getEncodedImage(com.facebook.imagepipeline.request.ImageRequest):com.facebook.imagepipeline.image.EncodedImage");
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public String getProducerName() {
        return PRODUCER_NAME;
    }
}
