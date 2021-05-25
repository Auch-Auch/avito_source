package com.yandex.runtime.image;

import a2.b.a.a.a;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
public abstract class ImageProvider {
    private final boolean cacheable;

    public static abstract class ImageProviderImpl extends ImageProvider {
        private Bitmap bitmap;
        private final String id;

        public ImageProviderImpl(String str, boolean z) {
            super(z);
            this.id = str;
        }

        @Override // com.yandex.runtime.image.ImageProvider
        public String getId() {
            return this.id;
        }

        @Override // com.yandex.runtime.image.ImageProvider
        public Bitmap getImage() {
            if (this.bitmap == null) {
                this.bitmap = loadBitmap();
            }
            return this.bitmap;
        }

        public abstract Bitmap loadBitmap();
    }

    public ImageProvider() {
        this(true);
    }

    public static ImageProvider fromAsset(Context context, String str) {
        return fromAsset(context, str, true);
    }

    public static ImageProvider fromBitmap(Bitmap bitmap) {
        StringBuilder L = a.L("bitmap:");
        L.append(UUID.randomUUID().toString());
        return fromBitmap(bitmap, true, L.toString());
    }

    public static ImageProvider fromFile(String str) {
        return fromFile(str, true);
    }

    public static ImageProvider fromResource(Context context, int i) {
        return fromResource(context, i, true);
    }

    public abstract String getId();

    public abstract Bitmap getImage();

    public boolean isCacheable() {
        return this.cacheable;
    }

    public ImageProvider(boolean z) {
        this.cacheable = z;
    }

    public static ImageProvider fromAsset(Context context, final String str, boolean z) {
        final AssetManager assets = context.getAssets();
        return new ImageProviderImpl(a.c3("asset:", str), z) { // from class: com.yandex.runtime.image.ImageProvider.2
            @Override // com.yandex.runtime.image.ImageProvider.ImageProviderImpl
            public Bitmap loadBitmap() {
                Bitmap bitmap = null;
                try {
                    InputStream open = assets.open(str);
                    try {
                        bitmap = BitmapFactory.decodeStream(open);
                        return bitmap;
                    } finally {
                        open.close();
                    }
                } catch (IOException unused) {
                }
            }
        };
    }

    public static ImageProvider fromBitmap(final Bitmap bitmap, boolean z, final String str) {
        if (bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
            return new ImageProvider(z) { // from class: com.yandex.runtime.image.ImageProvider.1
                @Override // com.yandex.runtime.image.ImageProvider
                public String getId() {
                    return str;
                }

                @Override // com.yandex.runtime.image.ImageProvider
                public Bitmap getImage() {
                    return bitmap;
                }
            };
        }
        throw new IllegalArgumentException("Bitmap config value should be ARGB_8888");
    }

    public static ImageProvider fromFile(final String str, boolean z) {
        return new ImageProviderImpl(a.c3("file:", str), z) { // from class: com.yandex.runtime.image.ImageProvider.4
            @Override // com.yandex.runtime.image.ImageProvider.ImageProviderImpl
            public Bitmap loadBitmap() {
                return BitmapFactory.decodeFile(str);
            }
        };
    }

    public static ImageProvider fromResource(Context context, final int i, boolean z) {
        final Resources resources = context.getResources();
        return new ImageProviderImpl(a.M2("resource:", i), z) { // from class: com.yandex.runtime.image.ImageProvider.3
            @Override // com.yandex.runtime.image.ImageProvider.ImageProviderImpl
            public Bitmap loadBitmap() {
                return BitmapFactory.decodeResource(resources, i);
            }
        };
    }
}
