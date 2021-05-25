package com.avito.android.conveyor_shared_item.single_text;

import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/avito/android/conveyor_shared_item/single_text/SingleTextItem;", "Lcom/avito/conveyor_item/Item;", "", "getTitle", "()Ljava/lang/String;", "title", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SingleTextItem extends Item {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static long getId(@NotNull SingleTextItem singleTextItem) {
            return Item.DefaultImpls.getId(singleTextItem);
        }
    }

    @NotNull
    String getTitle();
}
