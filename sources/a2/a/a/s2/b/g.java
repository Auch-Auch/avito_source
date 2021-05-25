package a2.a.a.s2.b;

import com.avito.android.remote.shop.detailed.ShopElement;
import com.avito.android.remote.shop.detailed.ShopGold;
import com.avito.android.serp.adapter.SerpItem;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.android.shop.detailed.ShopDetailedItemsConverterImpl;
import com.avito.android.shop.detailed.item.ShowcaseItem;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.funktionale.option.Option;
import org.funktionale.option.OptionKt;
public final class g<T, R> implements Function<List<? extends SerpItem>, Option<? extends SpannedItem>> {
    public final /* synthetic */ ShopDetailedItemsConverterImpl a;
    public final /* synthetic */ ShopElement b;

    public g(ShopDetailedItemsConverterImpl shopDetailedItemsConverterImpl, ShopElement shopElement) {
        this.a = shopDetailedItemsConverterImpl;
        this.b = shopElement;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Option<? extends SpannedItem> apply(List<? extends SerpItem> list) {
        List<? extends SerpItem> list2 = list;
        int i = this.a.b();
        ShopGold.Showcase showcase = ((ShopGold) this.b).getShowcase();
        String title = showcase != null ? showcase.getTitle() : null;
        Intrinsics.checkNotNullExpressionValue(list2, "it");
        return OptionKt.toOption(new ShowcaseItem("showcase_id", i, title, list2));
    }
}
