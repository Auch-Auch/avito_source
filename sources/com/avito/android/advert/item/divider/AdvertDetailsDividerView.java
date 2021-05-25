package com.avito.android.advert.item.divider;

import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/advert/item/divider/AdvertDetailsDividerView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "top", "bottom", "horizontalMargins", "", "setMargins", "(IILjava/lang/Integer;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsDividerView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull AdvertDetailsDividerView advertDetailsDividerView) {
            ItemView.DefaultImpls.onUnbind(advertDetailsDividerView);
        }
    }

    void setMargins(int i, int i2, @Nullable Integer num);
}
