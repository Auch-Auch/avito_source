package com.my.target.common.models;

import android.graphics.Bitmap;
import android.util.LruCache;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ae;
import com.my.target.bt;
public final class ImageData extends bt<Bitmap> {
    @NonNull
    public static volatile LruCache<ImageData, Bitmap> c = new a(31457280);
    public volatile boolean b;

    public static class a extends LruCache<ImageData, Bitmap> {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.LruCache
        public int sizeOf(ImageData imageData, Bitmap bitmap) {
            return bitmap.getAllocationByteCount();
        }
    }

    public ImageData(@NonNull String str) {
        super(str);
    }

    public ImageData(@NonNull String str, int i, int i2) {
        super(str);
        this.width = i;
        this.height = i2;
    }

    @AnyThread
    public static void clearCache() {
        c.evictAll();
    }

    @NonNull
    public static ImageData newImageData(@NonNull String str) {
        return new ImageData(str);
    }

    @NonNull
    public static ImageData newImageData(@NonNull String str, int i, int i2) {
        return new ImageData(str, i, i2);
    }

    @AnyThread
    public static void setCacheSize(int i) {
        if (i < 5242880) {
            ae.a("setting cache size ignored: size should be >=5242880");
        } else {
            c.resize(i);
        }
    }

    @Nullable
    public Bitmap getBitmap() {
        return getData();
    }

    @Override // com.my.target.bt
    @Nullable
    public Bitmap getData() {
        return (Bitmap) (this.b ? c.get(this) : super.getData());
    }

    public boolean isUseCache() {
        return this.b;
    }

    public void setBitmap(@Nullable Bitmap bitmap) {
        setData(bitmap);
    }

    public void setData(@Nullable Bitmap bitmap) {
        if (!this.b) {
            super.setData((ImageData) bitmap);
        } else if (bitmap == null) {
            c.remove(this);
        } else {
            c.put(this, bitmap);
        }
    }

    @NonNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("ImageData{url='");
        a2.b.a.a.a.k1(L, this.url, '\'', ", width=");
        L.append(this.width);
        L.append(", height=");
        L.append(this.height);
        L.append(", bitmap=");
        L.append(getData());
        L.append('}');
        return L.toString();
    }

    public void useCache(boolean z) {
        if (z != this.b) {
            this.b = z;
            if (z) {
                Bitmap bitmap = (Bitmap) super.getData();
                if (bitmap != null) {
                    super.setData((ImageData) null);
                    c.put(this, bitmap);
                    return;
                }
                return;
            }
            super.setData((ImageData) c.remove(this));
        }
    }
}
