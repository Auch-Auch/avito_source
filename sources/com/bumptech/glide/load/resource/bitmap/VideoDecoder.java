package com.bumptech.glide.load.resource.bitmap;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Objects;
public class VideoDecoder<T> implements ResourceDecoder<T, Bitmap> {
    public static final long DEFAULT_FRAME = -1;
    public static final Option<Integer> FRAME_OPTION = Option.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());
    public static final Option<Long> TARGET_FRAME = Option.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());
    public static final e d = new e();
    public final f<T> a;
    public final BitmapPool b;
    public final e c;

    public class a implements Option.CacheKeyUpdater<Long> {
        public final ByteBuffer a = ByteBuffer.allocate(8);

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [byte[], java.lang.Object, java.security.MessageDigest] */
        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        public void update(@NonNull byte[] bArr, @NonNull Long l, @NonNull MessageDigest messageDigest) {
            Long l2 = l;
            messageDigest.update(bArr);
            synchronized (this.a) {
                this.a.position(0);
                messageDigest.update(this.a.putLong(l2.longValue()).array());
            }
        }
    }

    public class b implements Option.CacheKeyUpdater<Integer> {
        public final ByteBuffer a = ByteBuffer.allocate(4);

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [byte[], java.lang.Object, java.security.MessageDigest] */
        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        public void update(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
            Integer num2 = num;
            if (num2 != null) {
                messageDigest.update(bArr);
                synchronized (this.a) {
                    this.a.position(0);
                    messageDigest.update(this.a.putInt(num2.intValue()).array());
                }
            }
        }
    }

    public static final class c implements f<AssetFileDescriptor> {
        public c(a aVar) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.media.MediaMetadataRetriever, java.lang.Object] */
        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.f
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            AssetFileDescriptor assetFileDescriptor2 = assetFileDescriptor;
            mediaMetadataRetriever.setDataSource(assetFileDescriptor2.getFileDescriptor(), assetFileDescriptor2.getStartOffset(), assetFileDescriptor2.getLength());
        }
    }

    @RequiresApi(23)
    public static final class d implements f<ByteBuffer> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.media.MediaMetadataRetriever, java.lang.Object] */
        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.f
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(new a2.d.a.d.d.a.b(this, byteBuffer));
        }
    }

    @VisibleForTesting
    public static class e {
    }

    @VisibleForTesting
    public interface f<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    public static final class g implements f<ParcelFileDescriptor> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.media.MediaMetadataRetriever, java.lang.Object] */
        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.f
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    public VideoDecoder(BitmapPool bitmapPool, f<T> fVar) {
        e eVar = d;
        this.b = bitmapPool;
        this.a = fVar;
        this.c = eVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap a(android.media.MediaMetadataRetriever r9, long r10, int r12, int r13, int r14, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r15) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 27
            if (r0 < r1) goto L_0x0059
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r13 == r0) goto L_0x0059
            if (r14 == r0) goto L_0x0059
            com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r0 = com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.NONE
            if (r15 == r0) goto L_0x0059
            r0 = 18
            java.lang.String r0 = r9.extractMetadata(r0)     // Catch:{ all -> 0x0053 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x0053 }
            r1 = 19
            java.lang.String r1 = r9.extractMetadata(r1)     // Catch:{ all -> 0x0053 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ all -> 0x0053 }
            r2 = 24
            java.lang.String r2 = r9.extractMetadata(r2)     // Catch:{ all -> 0x0053 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ all -> 0x0053 }
            r3 = 90
            if (r2 == r3) goto L_0x0036
            r3 = 270(0x10e, float:3.78E-43)
            if (r2 != r3) goto L_0x0039
        L_0x0036:
            r8 = r1
            r1 = r0
            r0 = r8
        L_0x0039:
            float r13 = r15.getScaleFactor(r0, r1, r13, r14)     // Catch:{ all -> 0x0053 }
            float r14 = (float) r0     // Catch:{ all -> 0x0053 }
            float r14 = r14 * r13
            int r6 = java.lang.Math.round(r14)     // Catch:{ all -> 0x0053 }
            float r14 = (float) r1     // Catch:{ all -> 0x0053 }
            float r13 = r13 * r14
            int r7 = java.lang.Math.round(r13)     // Catch:{ all -> 0x0053 }
            r2 = r9
            r3 = r10
            r5 = r12
            android.graphics.Bitmap r13 = r2.getScaledFrameAtTime(r3, r5, r6, r7)     // Catch:{ all -> 0x0053 }
            goto L_0x005a
        L_0x0053:
            r13 = 3
            java.lang.String r14 = "VideoDecoder"
            android.util.Log.isLoggable(r14, r13)
        L_0x0059:
            r13 = 0
        L_0x005a:
            if (r13 != 0) goto L_0x0060
            android.graphics.Bitmap r13 = r9.getFrameAtTime(r10, r12)
        L_0x0060:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.VideoDecoder.a(android.media.MediaMetadataRetriever, long, int, int, int, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy):android.graphics.Bitmap");
    }

    public static ResourceDecoder<AssetFileDescriptor, Bitmap> asset(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new c(null));
    }

    @RequiresApi(api = 23)
    public static ResourceDecoder<ByteBuffer, Bitmap> byteBuffer(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new d());
    }

    public static ResourceDecoder<ParcelFileDescriptor, Bitmap> parcel(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new g());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: com.bumptech.glide.load.Options */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Bitmap> decode(@NonNull T t, int i, int i2, @NonNull Options options) throws IOException {
        long longValue = ((Long) options.get(TARGET_FRAME)).longValue();
        if (longValue >= 0 || longValue == -1) {
            Integer num = (Integer) options.get(FRAME_OPTION);
            if (num == null) {
                num = 2;
            }
            DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.get(DownsampleStrategy.OPTION);
            if (downsampleStrategy == null) {
                downsampleStrategy = DownsampleStrategy.DEFAULT;
            }
            Objects.requireNonNull(this.c);
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                this.a.a(mediaMetadataRetriever, t);
                Bitmap a3 = a(mediaMetadataRetriever, longValue, num.intValue(), i, i2, downsampleStrategy);
                mediaMetadataRetriever.release();
                return BitmapResource.obtain(a3, this.b);
            } catch (RuntimeException e2) {
                throw new IOException(e2);
            } catch (Throwable th) {
                mediaMetadataRetriever.release();
                throw th;
            }
        } else {
            throw new IllegalArgumentException(a2.b.a.a.a.T2("Requested frame must be non-negative, or DEFAULT_FRAME, given: ", longValue));
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@NonNull T t, @NonNull Options options) {
        return true;
    }
}
