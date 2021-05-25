package com.avito.android.adapter;

import com.avito.android.remote.model.AdvertItemActions;
import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J7\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000b\u001a\u00020\n\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/adapter/MoreActionsItemProcessor;", "", "Lcom/avito/conveyor_item/Item;", "T", "", "items", "Lcom/avito/android/remote/model/AdvertItemActions;", "moreActions", "fillItems", "(Ljava/util/List;Lcom/avito/android/remote/model/AdvertItemActions;)Ljava/util/List;", "", "resolveStatus", "(Ljava/util/List;)V", "advert-item-actions_release"}, k = 1, mv = {1, 4, 2})
public interface MoreActionsItemProcessor {
    @NotNull
    <T extends Item> List<T> fillItems(@NotNull List<? extends T> list, @Nullable AdvertItemActions advertItemActions);

    <T extends Item> void resolveStatus(@NotNull List<? extends T> list);
}
