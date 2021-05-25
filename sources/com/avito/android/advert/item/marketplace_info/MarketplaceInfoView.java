package com.avito.android.advert.item.marketplace_info;

import android.view.View;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/advert/item/marketplace_info/MarketplaceInfoView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/advert/item/marketplace_info/MarketplaceInfoItem;", "item", "Landroid/view/View$OnClickListener;", "clickListener", "", "showInfo", "(Lcom/avito/android/advert/item/marketplace_info/MarketplaceInfoItem;Landroid/view/View$OnClickListener;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface MarketplaceInfoView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull MarketplaceInfoView marketplaceInfoView) {
            ItemView.DefaultImpls.onUnbind(marketplaceInfoView);
        }

        public static /* synthetic */ void showInfo$default(MarketplaceInfoView marketplaceInfoView, MarketplaceInfoItem marketplaceInfoItem, View.OnClickListener onClickListener, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    onClickListener = null;
                }
                marketplaceInfoView.showInfo(marketplaceInfoItem, onClickListener);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showInfo");
        }
    }

    void showInfo(@NotNull MarketplaceInfoItem marketplaceInfoItem, @Nullable View.OnClickListener onClickListener);
}
