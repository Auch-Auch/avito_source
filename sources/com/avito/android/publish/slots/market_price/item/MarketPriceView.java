package com.avito.android.publish.slots.market_price.item;

import com.avito.android.items.MarketPriceItem;
import com.avito.konveyor.blueprint.ItemView;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\rH&¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0018\u0010\fJ\u001f\u0010\u001b\u001a\u00020\u00042\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0019H&¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/avito/android/publish/slots/market_price/item/MarketPriceView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "formattedPrice", "", "setMarketPrice", "(Ljava/lang/CharSequence;)V", "text", "setMessage", "", "isVisible", "setMessageVisibility", "(Z)V", "", "", "color", "setDealTypeTitle", "(Ljava/lang/String;I)V", "setDealTypeSubtitle", "(Ljava/lang/String;)V", "Lcom/avito/android/items/MarketPriceItem$DealTypeImageName;", "imageName", "setDealTypeImage", "(Lcom/avito/android/items/MarketPriceItem$DealTypeImageName;)V", "setDealTypeVisibility", "", "emptyDealTypeData", "setEmptyDealTypeBlock", "(Ljava/util/List;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface MarketPriceView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull MarketPriceView marketPriceView) {
            ItemView.DefaultImpls.onUnbind(marketPriceView);
        }
    }

    void setDealTypeImage(@Nullable MarketPriceItem.DealTypeImageName dealTypeImageName);

    void setDealTypeSubtitle(@NotNull String str);

    void setDealTypeTitle(@NotNull String str, int i);

    void setDealTypeVisibility(boolean z);

    void setEmptyDealTypeBlock(@Nullable List<String> list);

    void setMarketPrice(@NotNull CharSequence charSequence);

    void setMessage(@NotNull CharSequence charSequence);

    void setMessageVisibility(boolean z);
}
