package com.avito.android.items;

import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/avito/android/items/ItemWithErrors;", "Lcom/avito/conveyor_item/Item;", "", "clearErrors", "()V", "", "getBubbleError", "()Ljava/lang/String;", "setBubbleError", "(Ljava/lang/String;)V", "bubbleError", "getError", "setError", "error", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public interface ItemWithErrors extends Item {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void clearErrors(@NotNull ItemWithErrors itemWithErrors) {
            itemWithErrors.setError(null);
            itemWithErrors.setBubbleError(null);
        }

        public static long getId(@NotNull ItemWithErrors itemWithErrors) {
            return Item.DefaultImpls.getId(itemWithErrors);
        }
    }

    void clearErrors();

    @Nullable
    String getBubbleError();

    @Nullable
    String getError();

    void setBubbleError(@Nullable String str);

    void setError(@Nullable String str);
}
