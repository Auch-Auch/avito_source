package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.references.ResourceReleaser;
public class SimpleBitmapReleaser implements ResourceReleaser<Bitmap> {
    public static SimpleBitmapReleaser a;

    public static SimpleBitmapReleaser getInstance() {
        if (a == null) {
            a = new SimpleBitmapReleaser();
        }
        return a;
    }

    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }
}
