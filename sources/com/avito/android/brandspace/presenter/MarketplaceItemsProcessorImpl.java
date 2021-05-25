package com.avito.android.brandspace.presenter;

import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.items.marketplace.snippet.MarketplaceItemSnippetPrice;
import com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetItem;
import com.avito.android.brandspace.remote.model.MarketplaceItemElement;
import com.avito.android.remote.model.badge_bar.SerpBadgeBar;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/brandspace/presenter/MarketplaceItemsProcessorImpl;", "Lcom/avito/android/brandspace/presenter/MarketplaceItemsProcessor;", "", "Lcom/avito/android/brandspace/remote/model/MarketplaceItemElement;", "list", "Lcom/avito/android/brandspace/items/marketplace/snippet/MarketplaceSnippetItem;", "convert", "(Ljava/util/List;)Ljava/util/List;", "<init>", "()V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceItemsProcessorImpl implements MarketplaceItemsProcessor {
    @Override // com.avito.android.brandspace.presenter.MarketplaceItemsProcessor
    @NotNull
    public List<MarketplaceSnippetItem> convert(@NotNull List<MarketplaceItemElement> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            long id = t.getId();
            BlockType blockType = BlockType.MARKETPLACE_SNIPPET;
            String title = t.getTitle();
            SerpBadgeBar badgeBar = t.getBadgeBar();
            arrayList.add(new MarketplaceSnippetItem(id, blockType, title, badgeBar != null ? badgeBar.getBadges() : null, t.getHasDelivery(), t.getImage(), t.getDeeplink(), new MarketplaceItemSnippetPrice(t.getPrice().getCurrent(), t.getPrice().getOld(), t.getPrice().getDiscount())));
        }
        return arrayList;
    }
}
