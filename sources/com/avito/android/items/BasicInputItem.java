package com.avito.android.items;

import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/items/BasicInputItem;", "Lcom/avito/conveyor_item/Item;", "", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "value", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public interface BasicInputItem extends Item {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static long getId(@NotNull BasicInputItem basicInputItem) {
            return Item.DefaultImpls.getId(basicInputItem);
        }
    }

    @Nullable
    String getValue();

    void setValue(@Nullable String str);
}
