package com.bumptech.glide.gifdecoder;

import a2.d.a.c.a;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
public class StandardGifDecoder implements GifDecoder {
    @ColorInt
    public int[] a;
    @ColorInt
    public final int[] b;
    public final GifDecoder.BitmapProvider c;
    public ByteBuffer d;
    public byte[] e;
    public GifHeaderParser f;
    public short[] g;
    public byte[] h;
    public byte[] i;
    public byte[] j;
    @ColorInt
    public int[] k;
    public int l;
    public GifHeader m;
    public Bitmap n;
    public boolean o;
    public int p;
    public int q;
    public int r;
    public int s;
    @Nullable
    public Boolean t;
    @NonNull
    public Bitmap.Config u;

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer) {
        this(bitmapProvider, gifHeader, byteBuffer, 1);
    }

    public final Bitmap a() {
        Boolean bool = this.t;
        Bitmap obtain = this.c.obtain(this.s, this.r, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.u);
        obtain.setHasAlpha(true);
        return obtain;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void advance() {
        this.l = (this.l + 1) % this.m.c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0041, code lost:
        if (r3.j == r36.h) goto L_0x0043;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap b(a2.d.a.c.a r36, a2.d.a.c.a r37) {
        /*
        // Method dump skipped, instructions count: 1079
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.StandardGifDecoder.b(a2.d.a.c.a, a2.d.a.c.a):android.graphics.Bitmap");
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void clear() {
        this.m = null;
        byte[] bArr = this.j;
        if (bArr != null) {
            this.c.release(bArr);
        }
        int[] iArr = this.k;
        if (iArr != null) {
            this.c.release(iArr);
        }
        Bitmap bitmap = this.n;
        if (bitmap != null) {
            this.c.release(bitmap);
        }
        this.n = null;
        this.d = null;
        this.t = null;
        byte[] bArr2 = this.e;
        if (bArr2 != null) {
            this.c.release(bArr2);
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getByteSize() {
        return (this.k.length * 4) + this.d.limit() + this.j.length;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getCurrentFrameIndex() {
        return this.l;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @NonNull
    public ByteBuffer getData() {
        return this.d;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getDelay(int i2) {
        if (i2 >= 0) {
            GifHeader gifHeader = this.m;
            if (i2 < gifHeader.c) {
                return gifHeader.e.get(i2).i;
            }
        }
        return -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getFrameCount() {
        return this.m.c;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getHeight() {
        return this.m.g;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @Deprecated
    public int getLoopCount() {
        int i2 = this.m.l;
        if (i2 == -1) {
            return 1;
        }
        return i2;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNetscapeLoopCount() {
        return this.m.l;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNextDelay() {
        int i2;
        if (this.m.c <= 0 || (i2 = this.l) < 0) {
            return 0;
        }
        return getDelay(i2);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @Nullable
    public synchronized Bitmap getNextFrame() {
        if (this.m.c <= 0 || this.l < 0) {
            if (Log.isLoggable("StandardGifDecoder", 3)) {
                int i2 = this.m.c;
            }
            this.p = 1;
        }
        int i3 = this.p;
        if (i3 != 1) {
            if (i3 != 2) {
                this.p = 0;
                if (this.e == null) {
                    this.e = this.c.obtainByteArray(255);
                }
                a aVar = this.m.e.get(this.l);
                int i4 = this.l - 1;
                a aVar2 = i4 >= 0 ? this.m.e.get(i4) : null;
                int[] iArr = aVar.k;
                if (iArr == null) {
                    iArr = this.m.a;
                }
                this.a = iArr;
                if (iArr == null) {
                    Log.isLoggable("StandardGifDecoder", 3);
                    this.p = 1;
                    return null;
                }
                if (aVar.f) {
                    System.arraycopy(iArr, 0, this.b, 0, iArr.length);
                    int[] iArr2 = this.b;
                    this.a = iArr2;
                    iArr2[aVar.h] = 0;
                    if (aVar.g == 2 && this.l == 0) {
                        this.t = Boolean.TRUE;
                    }
                }
                return b(aVar, aVar2);
            }
        }
        Log.isLoggable("StandardGifDecoder", 3);
        return null;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getStatus() {
        return this.p;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getTotalIterationCount() {
        int i2 = this.m.l;
        if (i2 == -1) {
            return 1;
        }
        if (i2 == 0) {
            return 0;
        }
        return i2 + 1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getWidth() {
        return this.m.f;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int read(@Nullable InputStream inputStream, int i2) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2 > 0 ? i2 + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, 16384);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException unused) {
            }
        } else {
            this.p = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused2) {
            }
        }
        return this.p;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void resetFrameIndex() {
        this.l = -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull byte[] bArr) {
        setData(gifHeader, ByteBuffer.wrap(bArr));
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void setDefaultBitmapConfig(@NonNull Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.u = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i2) {
        this(bitmapProvider);
        setData(gifHeader, byteBuffer, i2);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer) {
        setData(gifHeader, byteBuffer, 1);
    }

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider) {
        this.b = new int[256];
        this.u = Bitmap.Config.ARGB_8888;
        this.c = bitmapProvider;
        this.m = new GifHeader();
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer, int i2) {
        if (i2 > 0) {
            int highestOneBit = Integer.highestOneBit(i2);
            this.p = 0;
            this.m = gifHeader;
            this.l = -1;
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.d = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.d.order(ByteOrder.LITTLE_ENDIAN);
            this.o = false;
            Iterator<a> it = gifHeader.e.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().g == 3) {
                        this.o = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.q = highestOneBit;
            int i3 = gifHeader.f;
            this.s = i3 / highestOneBit;
            int i4 = gifHeader.g;
            this.r = i4 / highestOneBit;
            this.j = this.c.obtainByteArray(i3 * i4);
            this.k = this.c.obtainIntArray(this.s * this.r);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized int read(@Nullable byte[] bArr) {
        if (this.f == null) {
            this.f = new GifHeaderParser();
        }
        GifHeader parseHeader = this.f.setData(bArr).parseHeader();
        this.m = parseHeader;
        if (bArr != null) {
            setData(parseHeader, bArr);
        }
        return this.p;
    }
}
