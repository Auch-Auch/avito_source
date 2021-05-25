package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.OrientedDrawable;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;
public class DefaultDrawableFactory implements DrawableFactory {
    public final Resources a;
    @Nullable
    public final DrawableFactory b;

    public DefaultDrawableFactory(Resources resources, @Nullable DrawableFactory drawableFactory) {
        this.a = resources;
        this.b = drawableFactory;
    }

    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    @Nullable
    public Drawable createDrawable(CloseableImage closeableImage) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("DefaultDrawableFactory#createDrawable");
            }
            if (closeableImage instanceof CloseableStaticBitmap) {
                CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableImage;
                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.a, closeableStaticBitmap.getUnderlyingBitmap());
                boolean z = true;
                if (!((closeableStaticBitmap.getRotationAngle() == 0 || closeableStaticBitmap.getRotationAngle() == -1) ? false : true)) {
                    if (closeableStaticBitmap.getExifOrientation() == 1 || closeableStaticBitmap.getExifOrientation() == 0) {
                        z = false;
                    }
                    if (!z) {
                        return bitmapDrawable;
                    }
                }
                OrientedDrawable orientedDrawable = new OrientedDrawable(bitmapDrawable, closeableStaticBitmap.getRotationAngle(), closeableStaticBitmap.getExifOrientation());
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return orientedDrawable;
            }
            DrawableFactory drawableFactory = this.b;
            if (drawableFactory == null || !drawableFactory.supportsImageType(closeableImage)) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return null;
            }
            Drawable createDrawable = this.b.createDrawable(closeableImage);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return createDrawable;
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    public boolean supportsImageType(CloseableImage closeableImage) {
        return true;
    }
}
