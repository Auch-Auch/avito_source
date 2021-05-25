package com.avito.android.advert.item.price_discount;

import com.avito.android.advert_core.discount.AdvertDiscountDetailsDialog;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\nJ\u001d\u0010\u000e\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\nJ\u000f\u0010\u0012\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\nJ\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/advert/item/price_discount/PriceWithDiscountView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "price", "", "showPrice", "(Ljava/lang/String;)V", "priceWithoutDiscount", "showPriceWithoutDiscount", "hidePriceWithoutDiscount", "()V", "applyClosedAdvert", "Lkotlin/Function0;", "onClick", "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "removeOnClickListener", "showRightIcon", "hideRightIcon", "Lcom/avito/android/advert_core/discount/AdvertDiscountDetailsDialog;", "dialog", "showDialog", "(Lcom/avito/android/advert_core/discount/AdvertDiscountDetailsDialog;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface PriceWithDiscountView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull PriceWithDiscountView priceWithDiscountView) {
            ItemView.DefaultImpls.onUnbind(priceWithDiscountView);
        }
    }

    void applyClosedAdvert();

    void hidePriceWithoutDiscount();

    void hideRightIcon();

    void removeOnClickListener();

    void setOnClickListener(@NotNull Function0<Unit> function0);

    void showDialog(@NotNull AdvertDiscountDetailsDialog advertDiscountDetailsDialog);

    void showPrice(@NotNull String str);

    void showPriceWithoutDiscount(@NotNull String str);

    void showRightIcon();
}
