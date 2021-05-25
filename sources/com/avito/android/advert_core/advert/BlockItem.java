package com.avito.android.advert_core.advert;

import com.avito.android.serp.adapter.PersistableSpannedItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/PersistableSpannedItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface BlockItem extends PersistableSpannedItem {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static long getId(@NotNull BlockItem blockItem) {
            return PersistableSpannedItem.DefaultImpls.getId(blockItem);
        }
    }

    @NotNull
    BlockItem copyWithSpanCount(int i);
}
