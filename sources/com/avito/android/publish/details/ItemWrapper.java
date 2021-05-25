package com.avito.android.publish.details;

import com.avito.conveyor_item.Item;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\n\b\u0000\u0010\u0002 \u0000*\u00020\u00012\u00020\u0003J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/avito/android/publish/details/ItemWrapper;", "Lcom/avito/conveyor_item/Item;", "T", "", "item", "", "update", "(Lcom/avito/conveyor_item/Item;)V", "transform", "(Lcom/avito/conveyor_item/Item;)Lcom/avito/conveyor_item/Item;", "clear", "()V", "Lio/reactivex/Observable;", "getDataChanged", "()Lio/reactivex/Observable;", "dataChanged", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface ItemWrapper<T extends Item> {
    void clear();

    @NotNull
    Observable<Unit> getDataChanged();

    @NotNull
    Item transform(@NotNull T t);

    void update(@NotNull T t);
}
