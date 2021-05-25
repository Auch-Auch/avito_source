package com.avito.android.shop.awards;

import a2.a.a.s2.a.a;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.SellerVerification;
import com.avito.android.shop.awards.item.action.ActionItem;
import com.avito.android.shop.awards.item.award.AwardItem;
import com.avito.android.shop.awards.item.subtitle.SubtitleItem;
import com.avito.android.shop.awards.item.title.TitleItem;
import com.avito.conveyor_item.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.q;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/shop/awards/ShopAwardsItemsConverterImpl;", "Lcom/avito/android/shop/awards/ShopAwardsItemsConverter;", "Lcom/avito/android/remote/model/SellerVerification$AwardsItem;", "shopAwards", "", "Lcom/avito/conveyor_item/Item;", "convert", "(Lcom/avito/android/remote/model/SellerVerification$AwardsItem;)Ljava/util/List;", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopAwardsItemsConverterImpl implements ShopAwardsItemsConverter {
    @Override // com.avito.android.shop.awards.ShopAwardsItemsConverter
    @NotNull
    public List<Item> convert(@NotNull SellerVerification.AwardsItem awardsItem) {
        Intrinsics.checkNotNullParameter(awardsItem, "shopAwards");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = null;
        if (!m.isBlank(awardsItem.getTitle())) {
            arrayList.add(new TitleItem(null, awardsItem.getTitle(), 1, null));
        }
        Map<String, List<String>> data = awardsItem.getData();
        if (data != null) {
            ArrayList arrayList3 = new ArrayList();
            for (Map.Entry entry : q.toSortedMap(data, a.a).entrySet()) {
                Object key = entry.getKey();
                Intrinsics.checkNotNullExpressionValue(key, "entity.key");
                if (!m.isBlank((CharSequence) key)) {
                    Object key2 = entry.getKey();
                    Intrinsics.checkNotNullExpressionValue(key2, "entity.key");
                    arrayList3.add(new SubtitleItem(null, (String) key2, 1, null));
                }
                Object value = entry.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "entity.value");
                for (String str : (Iterable) value) {
                    arrayList3.add(new AwardItem(null, str, 1, null));
                }
            }
            arrayList2 = arrayList3;
        }
        if (arrayList2 != null) {
            arrayList.addAll(arrayList2);
        }
        Action action = awardsItem.getAction();
        if (action != null) {
            arrayList.add(new ActionItem(null, action.getTitle(), action.getDeepLink(), 1, null));
        }
        return arrayList;
    }
}
