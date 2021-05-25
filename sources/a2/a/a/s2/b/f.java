package a2.a.a.s2.b;

import com.avito.android.remote.shop.detailed.ShopGold;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.android.shop.detailed.ShopDetailedItemsConverterImpl;
import com.avito.android.shop.detailed.item.ShopGoldHeaderItem;
import com.avito.android.shop.detailed.item.ShopGoldItem;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.collections.CollectionsKt__CollectionsKt;
public final class f<V> implements Callable<List<? extends SpannedItem>> {
    public final /* synthetic */ ShopDetailedItemsConverterImpl a;
    public final /* synthetic */ ShopGold b;

    public f(ShopDetailedItemsConverterImpl shopDetailedItemsConverterImpl, ShopGold shopGold) {
        this.a = shopDetailedItemsConverterImpl;
        this.b = shopGold;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public List<? extends SpannedItem> call() {
        ShopGoldHeaderItem shopGoldHeaderItem = new ShopGoldHeaderItem(this.b.getId(), this.a.b(), this.b.getLogo(), this.b.getBackground());
        String id = this.b.getId();
        int i = this.a.b();
        String userKey = this.b.getUserKey();
        String name = this.b.getName();
        String categoryName = this.b.getCategoryName();
        return CollectionsKt__CollectionsKt.listOfNotNull((Object[]) new SpannedItem[]{shopGoldHeaderItem, new ShopGoldItem(id, i, userKey, name, this.b.getSellerVerification(), this.b.getCreationDate(), categoryName, this.b.getDescription(), this.b.getLogo(), this.b.getBackground(), this.b.getPhones(), this.b.getAddress(), this.b.getSite(), this.b.getRating(), this.b.getSubscribeInfo())});
    }
}
