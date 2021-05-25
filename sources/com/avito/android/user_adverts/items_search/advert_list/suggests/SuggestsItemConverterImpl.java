package com.avito.android.user_adverts.items_search.advert_list.suggests;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/user_adverts/items_search/advert_list/suggests/SuggestsItemConverterImpl;", "Lcom/avito/android/user_adverts/items_search/advert_list/suggests/SuggestsItemConverter;", "", "", "suggests", "Lcom/avito/android/user_adverts/items_search/advert_list/suggests/SuggestItem;", "convert", "(Ljava/util/List;)Ljava/util/List;", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestsItemConverterImpl implements SuggestsItemConverter {
    @Override // com.avito.android.user_adverts.items_search.advert_list.suggests.SuggestsItemConverter
    @NotNull
    public List<SuggestItem> convert(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "suggests");
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(new SuggestItem(String.valueOf(i), t));
            i = i2;
        }
        return arrayList;
    }
}
