package com.bumptech.glide.load.resource.bitmap;

import a2.b.a.a.a;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
@Deprecated
public class BitmapDrawableTransformation implements Transformation<BitmapDrawable> {
    public final Transformation<Drawable> a;

    public BitmapDrawableTransformation(Transformation<Bitmap> transformation) {
        this.a = (Transformation) Preconditions.checkNotNull(new DrawableTransformation(transformation, false));
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof BitmapDrawableTransformation) {
            return this.a.equals(((BitmapDrawableTransformation) obj).a);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.bumptech.glide.load.Transformation
    @NonNull
    public Resource<BitmapDrawable> transform(@NonNull Context context, @NonNull Resource<BitmapDrawable> resource, int i, int i2) {
        Resource transform = this.a.transform(context, resource, i, i2);
        if (transform.get() instanceof BitmapDrawable) {
            return transform;
        }
        StringBuilder L = a.L("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: ");
        L.append(transform.get());
        throw new IllegalArgumentException(L.toString());
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.a.updateDiskCacheKey(messageDigest);
    }
}
