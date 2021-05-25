package com.avito.android.photo_gallery.ui;

import androidx.annotation.FloatRange;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/photo_gallery/ui/ParallaxProgressListener;", "", "", "percentage", "", "onChangeParallax", "(F)V", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
public interface ParallaxProgressListener {
    void onChangeParallax(@FloatRange(from = 0.0d, to = 1.0d) float f);
}
