package com.bumptech.glide.load.resource.bitmap;

import a2.d.a.d.d.a.a;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;
public class DrawableTransformation implements Transformation<Drawable> {
    public final Transformation<Bitmap> a;
    public final boolean b;

    public DrawableTransformation(Transformation<Bitmap> transformation, boolean z) {
        this.a = transformation;
        this.b = z;
    }

    public Transformation<BitmapDrawable> asBitmapDrawable() {
        return this;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof DrawableTransformation) {
            return this.a.equals(((DrawableTransformation) obj).a);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.bumptech.glide.load.Transformation
    @NonNull
    public Resource<Drawable> transform(@NonNull Context context, @NonNull Resource<Drawable> resource, int i, int i2) {
        BitmapPool bitmapPool = Glide.get(context).getBitmapPool();
        Drawable drawable = resource.get();
        Resource<Bitmap> a3 = a.a(bitmapPool, drawable, i, i2);
        if (a3 != null) {
            Resource<Bitmap> transform = this.a.transform(context, a3, i, i2);
            if (!transform.equals(a3)) {
                return LazyBitmapDrawableResource.obtain(context.getResources(), transform);
            }
            transform.recycle();
            return resource;
        } else if (!this.b) {
            return resource;
        } else {
            throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
        }
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.a.updateDiskCacheKey(messageDigest);
    }
}
