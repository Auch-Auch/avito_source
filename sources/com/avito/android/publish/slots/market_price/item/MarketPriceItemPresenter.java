package com.avito.android.publish.slots.market_price.item;

import com.avito.android.items.MarketPriceItem;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/publish/slots/market_price/item/MarketPriceItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/publish/slots/market_price/item/MarketPriceView;", "Lcom/avito/android/items/MarketPriceItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/publish/slots/market_price/item/MarketPriceView;Lcom/avito/android/items/MarketPriceItem;I)V", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class MarketPriceItemPresenter implements ItemPresenter<MarketPriceView, MarketPriceItem> {
    public void bindView(@NotNull MarketPriceView marketPriceView, @NotNull MarketPriceItem marketPriceItem, int i) {
        Intrinsics.checkNotNullParameter(marketPriceView, "view");
        Intrinsics.checkNotNullParameter(marketPriceItem, "item");
        marketPriceView.setMarketPrice(marketPriceItem.getMarketPrice());
        boolean z = false;
        if (marketPriceItem.getMessage() == null) {
            marketPriceView.setMessageVisibility(false);
        } else {
            CharSequence message = marketPriceItem.getMessage();
            Intrinsics.checkNotNull(message);
            marketPriceView.setMessage(message);
            marketPriceView.setMessageVisibility(true);
        }
        MarketPriceItem.DealTypeBlock dealTypeBlock = marketPriceItem.getDealTypeBlock();
        if (dealTypeBlock != null) {
            marketPriceView.setDealTypeTitle(dealTypeBlock.getTitle(), dealTypeBlock.getColor());
            String subtitle = dealTypeBlock.getSubtitle();
            if (subtitle == null) {
                subtitle = "";
            }
            marketPriceView.setDealTypeSubtitle(subtitle);
            marketPriceView.setDealTypeImage(dealTypeBlock.getImage());
        }
        if (marketPriceItem.getDealTypeBlock() != null) {
            z = true;
        }
        marketPriceView.setDealTypeVisibility(z);
        marketPriceView.setEmptyDealTypeBlock(marketPriceItem.getEmptyDealType());
    }
}
