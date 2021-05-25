package com.avito.android.shop.detailed;

import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/shop/detailed/ShopItemVisibilityRecorder;", "", "", VKApiConst.POSITION, "", "onItemBecomeVisible", "(I)V", "onItemBecomeInvisible", "shop_release"}, k = 1, mv = {1, 4, 2})
public interface ShopItemVisibilityRecorder {
    void onItemBecomeInvisible(int i);

    void onItemBecomeVisible(int i);
}
