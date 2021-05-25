package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
public class BitmapEncoder implements ResourceEncoder<Bitmap> {
    public static final Option<Bitmap.CompressFormat> COMPRESSION_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    public static final Option<Integer> COMPRESSION_QUALITY = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    @Nullable
    public final ArrayPool a;

    public BitmapEncoder(@NonNull ArrayPool arrayPool) {
        this.a = arrayPool;
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    @NonNull
    public EncodeStrategy getEncodeStrategy(@NonNull Options options) {
        return EncodeStrategy.TRANSFORMED;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006f, code lost:
        if (r6 != null) goto L_0x005f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c1 A[SYNTHETIC, Splitter:B:38:0x00c1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean encode(@androidx.annotation.NonNull com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> r9, @androidx.annotation.NonNull java.io.File r10, @androidx.annotation.NonNull com.bumptech.glide.load.Options r11) {
        /*
            r8 = this;
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r9 = r9.get()
            android.graphics.Bitmap r9 = (android.graphics.Bitmap) r9
            com.bumptech.glide.load.Option<android.graphics.Bitmap$CompressFormat> r1 = com.bumptech.glide.load.resource.bitmap.BitmapEncoder.COMPRESSION_FORMAT
            java.lang.Object r1 = r11.get(r1)
            android.graphics.Bitmap$CompressFormat r1 = (android.graphics.Bitmap.CompressFormat) r1
            if (r1 == 0) goto L_0x0013
            goto L_0x001e
        L_0x0013:
            boolean r1 = r9.hasAlpha()
            if (r1 == 0) goto L_0x001c
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.PNG
            goto L_0x001e
        L_0x001c:
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG
        L_0x001e:
            int r2 = r9.getWidth()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r3 = r9.getHeight()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "encode: [%dx%d] %s"
            com.bumptech.glide.util.pool.GlideTrace.beginSectionFormat(r4, r2, r3, r1)
            long r2 = com.bumptech.glide.util.LogTime.getLogTime()     // Catch:{ all -> 0x00c5 }
            com.bumptech.glide.load.Option<java.lang.Integer> r4 = com.bumptech.glide.load.resource.bitmap.BitmapEncoder.COMPRESSION_QUALITY     // Catch:{ all -> 0x00c5 }
            java.lang.Object r4 = r11.get(r4)     // Catch:{ all -> 0x00c5 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x00c5 }
            int r4 = r4.intValue()     // Catch:{ all -> 0x00c5 }
            r5 = 0
            r6 = 0
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x006a }
            r7.<init>(r10)     // Catch:{ IOException -> 0x006a }
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r10 = r8.a     // Catch:{ IOException -> 0x0066, all -> 0x0063 }
            if (r10 == 0) goto L_0x0057
            com.bumptech.glide.load.data.BufferedOutputStream r10 = new com.bumptech.glide.load.data.BufferedOutputStream     // Catch:{ IOException -> 0x0066, all -> 0x0063 }
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r6 = r8.a     // Catch:{ IOException -> 0x0066, all -> 0x0063 }
            r10.<init>(r7, r6)     // Catch:{ IOException -> 0x0066, all -> 0x0063 }
            r6 = r10
            goto L_0x0058
        L_0x0057:
            r6 = r7
        L_0x0058:
            r9.compress(r1, r4, r6)
            r6.close()
            r5 = 1
        L_0x005f:
            r6.close()     // Catch:{ IOException -> 0x0072 }
            goto L_0x0072
        L_0x0063:
            r9 = move-exception
            r6 = r7
            goto L_0x00bf
        L_0x0066:
            r6 = r7
            goto L_0x006a
        L_0x0068:
            r9 = move-exception
            goto L_0x00bf
        L_0x006a:
            r10 = 3
            boolean r10 = android.util.Log.isLoggable(r0, r10)     // Catch:{ all -> 0x0068 }
            if (r6 == 0) goto L_0x0072
            goto L_0x005f
        L_0x0072:
            r10 = 2
            boolean r10 = android.util.Log.isLoggable(r0, r10)
            if (r10 == 0) goto L_0x00bb
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "Compressed with type: "
            r10.append(r0)
            r10.append(r1)
            java.lang.String r0 = " of size "
            r10.append(r0)
            int r0 = com.bumptech.glide.util.Util.getBitmapByteSize(r9)
            r10.append(r0)
            java.lang.String r0 = " in "
            r10.append(r0)
            double r0 = com.bumptech.glide.util.LogTime.getElapsedMillis(r2)
            r10.append(r0)
            java.lang.String r0 = ", options format: "
            r10.append(r0)
            com.bumptech.glide.load.Option<android.graphics.Bitmap$CompressFormat> r0 = com.bumptech.glide.load.resource.bitmap.BitmapEncoder.COMPRESSION_FORMAT
            java.lang.Object r11 = r11.get(r0)
            r10.append(r11)
            java.lang.String r11 = ", hasAlpha: "
            r10.append(r11)
            boolean r9 = r9.hasAlpha()
            r10.append(r9)
            r10.toString()
        L_0x00bb:
            com.bumptech.glide.util.pool.GlideTrace.endSection()
            return r5
        L_0x00bf:
            if (r6 == 0) goto L_0x00c4
            r6.close()     // Catch:{ IOException -> 0x00c4 }
        L_0x00c4:
            throw r9
        L_0x00c5:
            r9 = move-exception
            com.bumptech.glide.util.pool.GlideTrace.endSection()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.BitmapEncoder.encode(com.bumptech.glide.load.engine.Resource, java.io.File, com.bumptech.glide.load.Options):boolean");
    }

    @Deprecated
    public BitmapEncoder() {
        this.a = null;
    }
}
