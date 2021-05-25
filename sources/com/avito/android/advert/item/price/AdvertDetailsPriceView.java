package com.avito.android.advert.item.price;

import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert/item/price/AdvertDetailsPriceView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "price", "oldPrice", "", "showPrice", "(Ljava/lang/String;Ljava/lang/String;)V", "hidePrice", "()V", "applyClosedAdvert", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsPriceView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull AdvertDetailsPriceView advertDetailsPriceView) {
            ItemView.DefaultImpls.onUnbind(advertDetailsPriceView);
        }
    }

    void applyClosedAdvert();

    void hidePrice();

    void showPrice(@Nullable String str, @Nullable String str2);
}
