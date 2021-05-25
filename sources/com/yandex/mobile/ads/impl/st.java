package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.yandex.mobile.ads.impl.ry;
import com.yandex.mobile.ads.impl.sa;
public final class st extends ry<Bitmap> {
    private static final Object f = new Object();
    private final sa.b<Bitmap> a;
    private final Bitmap.Config b;
    private final int c;
    private final int d;
    private ImageView.ScaleType e;

    public st(String str, sa.b<Bitmap> bVar, int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config, sa.a aVar) {
        super(0, str, aVar);
        a((sc) new rt(1000, 2, 2.0f));
        this.a = bVar;
        this.b = config;
        this.c = i;
        this.d = i2;
        this.e = scaleType;
    }

    private static int a(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i == 0 ? i3 : i;
        }
        if (i == 0) {
            return (int) (((double) i3) * (((double) i2) / ((double) i4)));
        } else if (i2 == 0) {
            return i;
        } else {
            double d2 = ((double) i4) / ((double) i3);
            if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                double d3 = (double) i2;
                return ((double) i) * d2 < d3 ? (int) (d3 / d2) : i;
            }
            double d4 = (double) i2;
            return ((double) i) * d2 > d4 ? (int) (d4 / d2) : i;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.ry
    public final /* synthetic */ void b(Bitmap bitmap) {
        this.a.a(bitmap);
    }

    @Override // com.yandex.mobile.ads.impl.ry
    public final ry.a o() {
        return ry.a.LOW;
    }

    @Override // com.yandex.mobile.ads.impl.ry
    public final sa<Bitmap> a(rx rxVar) {
        Bitmap bitmap;
        sa<Bitmap> saVar;
        synchronized (f) {
            try {
                byte[] bArr = rxVar.b;
                BitmapFactory.Options options = new BitmapFactory.Options();
                if (this.c == 0 && this.d == 0) {
                    options.inPreferredConfig = this.b;
                    bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                } else {
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                    int i = options.outWidth;
                    int i2 = options.outHeight;
                    int a3 = a(this.c, this.d, i, i2, this.e);
                    int a4 = a(this.d, this.c, i2, i, this.e);
                    options.inJustDecodeBounds = false;
                    options.inSampleSize = a(i, i2, a3, a4);
                    bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                    if (bitmap != null && (bitmap.getWidth() > a3 || bitmap.getHeight() > a4)) {
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, a3, a4, true);
                        bitmap.recycle();
                        bitmap = createScaledBitmap;
                    }
                }
                if (bitmap == null) {
                    saVar = sa.a(new si(rxVar));
                } else {
                    saVar = sa.a(bitmap, sp.a(rxVar));
                }
            } catch (OutOfMemoryError e2) {
                sd.c("Caught OOM for %d byte image, url=%s", Integer.valueOf(rxVar.b.length), b());
                return sa.a(new si(e2));
            } catch (Throwable th) {
                throw th;
            }
        }
        return saVar;
    }

    private static int a(int i, int i2, int i3, int i4) {
        double min = Math.min(((double) i) / ((double) i3), ((double) i2) / ((double) i4));
        float f2 = 1.0f;
        while (true) {
            float f3 = 2.0f * f2;
            if (((double) f3) > min) {
                return (int) f2;
            }
            f2 = f3;
        }
    }
}
