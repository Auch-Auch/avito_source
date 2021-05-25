package com.avito.android.photo_gallery.ui;

import com.avito.android.photo_gallery.common.OnScrollChangedListener;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/avito/android/photo_gallery/ui/ParallaxHelper$mOnScrollChangedListener$1", "Lcom/avito/android/photo_gallery/common/OnScrollChangedListener;", "", MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL, "vertical", "", "onScroll", "(II)V", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
public final class ParallaxHelper$mOnScrollChangedListener$1 implements OnScrollChangedListener {
    public final /* synthetic */ ParallaxHelper a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public ParallaxHelper$mOnScrollChangedListener$1(ParallaxHelper parallaxHelper) {
        this.a = parallaxHelper;
    }

    @Override // com.avito.android.photo_gallery.common.OnScrollChangedListener
    public void onScroll(int i, int i2) {
        ParallaxHelper.access$onScrollChanged(this.a, i2);
    }
}
