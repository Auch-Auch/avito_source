package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.ImageReader;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
public final class Downsampler {
    public static final Option<Boolean> ALLOW_HARDWARE_CONFIG;
    public static final Option<DecodeFormat> DECODE_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
    @Deprecated
    public static final Option<DownsampleStrategy> DOWNSAMPLE_STRATEGY = DownsampleStrategy.OPTION;
    public static final Option<Boolean> FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS;
    public static final Option<PreferredColorSpace> PREFERRED_COLOR_SPACE = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", PreferredColorSpace.SRGB);
    public static final Set<String> f = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
    public static final DecodeCallbacks g = new a();
    public static final Set<ImageHeaderParser.ImageType> h = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
    public static final Queue<BitmapFactory.Options> i = Util.createQueue(0);
    public final BitmapPool a;
    public final DisplayMetrics b;
    public final ArrayPool c;
    public final List<ImageHeaderParser> d;
    public final HardwareConfigState e = HardwareConfigState.getInstance();

    public interface DecodeCallbacks {
        void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) throws IOException;

        void onObtainBounds();
    }

    public class a implements DecodeCallbacks {
        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void onObtainBounds() {
        }
    }

    static {
        Boolean bool = Boolean.FALSE;
        FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        ALLOW_HARDWARE_CONFIG = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
    }

    public Downsampler(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.d = list;
        this.b = (DisplayMetrics) Preconditions.checkNotNull(displayMetrics);
        this.a = (BitmapPool) Preconditions.checkNotNull(bitmapPool);
        this.c = (ArrayPool) Preconditions.checkNotNull(arrayPool);
    }

    public static Bitmap c(ImageReader imageReader, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool) throws IOException {
        Bitmap c2;
        if (!options.inJustDecodeBounds) {
            decodeCallbacks.onObtainBounds();
            imageReader.stopGrowingBuffers();
        }
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        String str = options.outMimeType;
        TransformationUtils.getBitmapDrawableLock().lock();
        try {
            c2 = imageReader.decodeBitmap(options);
        } catch (IllegalArgumentException e2) {
            IOException h2 = h(e2, i2, i3, str, options);
            Log.isLoggable("Downsampler", 3);
            Bitmap bitmap = options.inBitmap;
            if (bitmap != null) {
                try {
                    bitmapPool.put(bitmap);
                    options.inBitmap = null;
                    c2 = c(imageReader, options, decodeCallbacks, bitmapPool);
                } catch (IOException unused) {
                    throw h2;
                }
            } else {
                throw h2;
            }
        } catch (Throwable th) {
            TransformationUtils.getBitmapDrawableLock().unlock();
            throw th;
        }
        TransformationUtils.getBitmapDrawableLock().unlock();
        return c2;
    }

    @Nullable
    @TargetApi(19)
    public static String d(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        StringBuilder L = a2.b.a.a.a.L(" (");
        L.append(bitmap.getAllocationByteCount());
        L.append(")");
        String sb = L.toString();
        StringBuilder L2 = a2.b.a.a.a.L("[");
        L2.append(bitmap.getWidth());
        L2.append("x");
        L2.append(bitmap.getHeight());
        L2.append("] ");
        L2.append(bitmap.getConfig());
        L2.append(sb);
        return L2.toString();
    }

    public static int e(double d2) {
        if (d2 > 1.0d) {
            d2 = 1.0d / d2;
        }
        return (int) Math.round(d2 * 2.147483647E9d);
    }

    public static int[] f(ImageReader imageReader, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool) throws IOException {
        options.inJustDecodeBounds = true;
        c(imageReader, options, decodeCallbacks, bitmapPool);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public static boolean g(int i2) {
        return i2 == 90 || i2 == 270;
    }

    public static IOException h(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        StringBuilder N = a2.b.a.a.a.N("Exception decoding bitmap, outWidth: ", i2, ", outHeight: ", i3, ", outMimeType: ");
        N.append(str);
        N.append(", inBitmap: ");
        N.append(d(options.inBitmap));
        return new IOException(N.toString(), illegalArgumentException);
    }

    public static void i(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public static int j(double d2) {
        return (int) (d2 + 0.5d);
    }

    public final Resource<Bitmap> a(ImageReader imageReader, int i2, int i3, Options options, DecodeCallbacks decodeCallbacks) throws IOException {
        Queue<BitmapFactory.Options> queue;
        BitmapFactory.Options poll;
        byte[] bArr = (byte[]) this.c.get(65536, byte[].class);
        synchronized (Downsampler.class) {
            queue = i;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                i(poll);
            }
        }
        poll.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) options.get(DECODE_FORMAT);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) options.get(PREFERRED_COLOR_SPACE);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.get(DownsampleStrategy.OPTION);
        boolean booleanValue = ((Boolean) options.get(FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS)).booleanValue();
        Option<Boolean> option = ALLOW_HARDWARE_CONFIG;
        try {
            BitmapResource obtain = BitmapResource.obtain(b(imageReader, poll, downsampleStrategy, decodeFormat, preferredColorSpace, options.get(option) != null && ((Boolean) options.get(option)).booleanValue(), i2, i3, booleanValue, decodeCallbacks), this.a);
            i(poll);
            synchronized (queue) {
                queue.offer(poll);
            }
            this.c.put(bArr);
            return obtain;
        } catch (Throwable th) {
            i(poll);
            Queue<BitmapFactory.Options> queue2 = i;
            synchronized (queue2) {
                queue2.offer(poll);
                this.c.put(bArr);
                throw th;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:123:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02cf  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x02d9  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x02dc  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02e8  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0307  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0323  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0337  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x018a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0197  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap b(com.bumptech.glide.load.resource.bitmap.ImageReader r27, android.graphics.BitmapFactory.Options r28, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r29, com.bumptech.glide.load.DecodeFormat r30, com.bumptech.glide.load.PreferredColorSpace r31, boolean r32, int r33, int r34, boolean r35, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks r36) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 850
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.b(com.bumptech.glide.load.resource.bitmap.ImageReader, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, com.bumptech.glide.load.DecodeFormat, com.bumptech.glide.load.PreferredColorSpace, boolean, int, int, boolean, com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks):android.graphics.Bitmap");
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i2, int i3, Options options) throws IOException {
        return decode(inputStream, i2, i3, options, g);
    }

    public boolean handles(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.isSupported();
    }

    public boolean handles(InputStream inputStream) {
        return true;
    }

    public boolean handles(ByteBuffer byteBuffer) {
        return true;
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i2, int i3, Options options, DecodeCallbacks decodeCallbacks) throws IOException {
        return a(new ImageReader.InputStreamImageReader(inputStream, this.d, this.c), i2, i3, options, decodeCallbacks);
    }

    @RequiresApi(21)
    public Resource<Bitmap> decode(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, Options options) throws IOException {
        return a(new ImageReader.ParcelFileDescriptorImageReader(parcelFileDescriptor, this.d, this.c), i2, i3, options, g);
    }
}
