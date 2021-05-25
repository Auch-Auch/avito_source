package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Util;
public final class UnitBitmapDecoder implements ResourceDecoder<Bitmap, Bitmap> {

    public static final class a implements Resource<Bitmap> {
        public final Bitmap a;

        public a(@NonNull Bitmap bitmap) {
            this.a = bitmap;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.bumptech.glide.load.engine.Resource
        @NonNull
        public Bitmap get() {
            return this.a;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        @NonNull
        public Class<Bitmap> getResourceClass() {
            return Bitmap.class;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public int getSize() {
            return Util.getBitmapByteSize(this.a);
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public void recycle() {
        }
    }

    public boolean handles(@NonNull Bitmap bitmap, @NonNull Options options) {
        return true;
    }

    public Resource<Bitmap> decode(@NonNull Bitmap bitmap, int i, int i2, @NonNull Options options) {
        return new a(bitmap);
    }
}
