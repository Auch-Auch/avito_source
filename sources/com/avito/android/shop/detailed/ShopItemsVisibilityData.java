package com.avito.android.shop.detailed;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/shop/detailed/ShopItemsVisibilityData;", "", "", AuthSource.BOOKING_ORDER, "I", "getLongTimeVisibleCount", "()I", "longTimeVisibleCount", AuthSource.SEND_ABUSE, "getShortTimeVisibleCount", "shortTimeVisibleCount", "<init>", "(II)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopItemsVisibilityData {
    public final int a;
    public final int b;

    public ShopItemsVisibilityData(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public final int getLongTimeVisibleCount() {
        return this.b;
    }

    public final int getShortTimeVisibleCount() {
        return this.a;
    }
}
