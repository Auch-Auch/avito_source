package com.bumptech.glide.load.resource.bitmap;

import a2.d.a.d.d.a.a;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.facebook.common.util.UriUtil;
public class ResourceBitmapDecoder implements ResourceDecoder<Uri, Bitmap> {
    public final ResourceDrawableDecoder a;
    public final BitmapPool b;

    public ResourceBitmapDecoder(ResourceDrawableDecoder resourceDrawableDecoder, BitmapPool bitmapPool) {
        this.a = resourceDrawableDecoder;
        this.b = bitmapPool;
    }

    @Nullable
    public Resource<Bitmap> decode(@NonNull Uri uri, int i, int i2, @NonNull Options options) {
        Resource<Drawable> decode = this.a.decode(uri, i, i2, options);
        if (decode == null) {
            return null;
        }
        return a.a(this.b, decode.get(), i, i2);
    }

    public boolean handles(@NonNull Uri uri, @NonNull Options options) {
        return UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(uri.getScheme());
    }
}
