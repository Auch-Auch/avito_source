package com.avito.android.advert.item;

import com.avito.conveyor_item.Item;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J5\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJE\u0010\u0011\u001a\u00020\b\"\b\b\u0000\u0010\u000e*\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/advert/item/AdvertDetailsViewScroller;", "", "", VKApiConst.POSITION, "offset", "verticalSnap", "", "isFast", "", "smoothScrollToPosition", "(IIIZ)V", "smoothScrollToStart", "()V", "Lcom/avito/conveyor_item/Item;", "T", "Ljava/lang/Class;", "type", "smoothScrollToItem", "(Ljava/lang/Class;IIZ)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsViewScroller {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void smoothScrollToItem$default(AdvertDetailsViewScroller advertDetailsViewScroller, Class cls, int i, int i2, boolean z, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    i = 0;
                }
                if ((i3 & 4) != 0) {
                    i2 = -1;
                }
                if ((i3 & 8) != 0) {
                    z = false;
                }
                advertDetailsViewScroller.smoothScrollToItem(cls, i, i2, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: smoothScrollToItem");
        }

        public static /* synthetic */ void smoothScrollToPosition$default(AdvertDetailsViewScroller advertDetailsViewScroller, int i, int i2, int i3, boolean z, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 2) != 0) {
                    i2 = 0;
                }
                if ((i4 & 4) != 0) {
                    i3 = -1;
                }
                if ((i4 & 8) != 0) {
                    z = false;
                }
                advertDetailsViewScroller.smoothScrollToPosition(i, i2, i3, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: smoothScrollToPosition");
        }
    }

    <T extends Item> void smoothScrollToItem(@NotNull Class<T> cls, int i, int i2, boolean z);

    void smoothScrollToPosition(int i, int i2, int i3, boolean z);

    void smoothScrollToStart();
}
