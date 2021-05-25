package ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0019B)\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/SellerInfoParams;", "", "", AuthSource.SEND_ABUSE, "I", "getSideOffset", "()I", "sideOffset", "", AuthSource.BOOKING_ORDER, "Z", "getPhotoEnabled", "()Z", "photoEnabled", "c", "getTitleMaxLines", "titleMaxLines", "Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/SellerInfoParams$SellerInfoBlockPosition;", "d", "Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/SellerInfoParams$SellerInfoBlockPosition;", "getBlockPosition", "()Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/SellerInfoParams$SellerInfoBlockPosition;", "blockPosition", "<init>", "(IZILru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/SellerInfoParams$SellerInfoBlockPosition;)V", "SellerInfoBlockPosition", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class SellerInfoParams {
    public final int a;
    public final boolean b;
    public final int c;
    @NotNull
    public final SellerInfoBlockPosition d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/SellerInfoParams$SellerInfoBlockPosition;", "", "<init>", "(Ljava/lang/String;I)V", "BEFORE_ACTIONS", "AFTER_ACTIONS", "NONE", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public enum SellerInfoBlockPosition {
        BEFORE_ACTIONS,
        AFTER_ACTIONS,
        NONE
    }

    public SellerInfoParams(int i, boolean z, int i2, @NotNull SellerInfoBlockPosition sellerInfoBlockPosition) {
        Intrinsics.checkNotNullParameter(sellerInfoBlockPosition, "blockPosition");
        this.a = i;
        this.b = z;
        this.c = i2;
        this.d = sellerInfoBlockPosition;
    }

    @NotNull
    public final SellerInfoBlockPosition getBlockPosition() {
        return this.d;
    }

    public final boolean getPhotoEnabled() {
        return this.b;
    }

    public final int getSideOffset() {
        return this.a;
    }

    public final int getTitleMaxLines() {
        return this.c;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SellerInfoParams(int i, boolean z, int i2, SellerInfoBlockPosition sellerInfoBlockPosition, int i3, j jVar) {
        this(i, z, i2, (i3 & 8) != 0 ? SellerInfoBlockPosition.BEFORE_ACTIONS : sellerInfoBlockPosition);
    }
}
