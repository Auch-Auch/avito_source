package ru.avito.component.serp.cyclic_gallery.image_carousel;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0013"}, d2 = {"Lru/avito/component/serp/cyclic_gallery/image_carousel/GalleryRatio;", "", "", AuthSource.BOOKING_ORDER, "F", "getImageWidthRatio", "()F", "imageWidthRatio", "d", "getSellerRatio", "sellerRatio", "c", "getActionRatio", "actionRatio", AuthSource.SEND_ABUSE, "getGalleryHeightRatio", "galleryHeightRatio", "<init>", "(FFFF)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class GalleryRatio {
    public final float a;
    public final float b;
    public final float c;
    public final float d;

    public GalleryRatio(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
    }

    public final float getActionRatio() {
        return this.c;
    }

    public final float getGalleryHeightRatio() {
        return this.a;
    }

    public final float getImageWidthRatio() {
        return this.b;
    }

    public final float getSellerRatio() {
        return this.d;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GalleryRatio(float f, float f2, float f3, float f4, int i, j jVar) {
        this(f, f2, (i & 4) != 0 ? f2 / ((float) 2) : f3, (i & 8) != 0 ? 0.7777778f * f2 : f4);
    }
}
