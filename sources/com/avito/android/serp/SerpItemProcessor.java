package com.avito.android.serp;

import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.conveyor_item.Item;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J9\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\u000eJ;\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\t\"\b\b\u0000\u0010\u000f*\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0010\u0010\u0011J5\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u000f*\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0017\u001a\u00020\u0016\"\b\b\u0000\u0010\u000f*\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H&¢\u0006\u0004\b\u0017\u0010\u0018J5\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u000f*\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0019\u0010\u0013R\u001c\u0010\u001f\u001a\u00020\u001a8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/avito/android/serp/SerpItemProcessor;", "", "", "Lcom/avito/android/remote/model/SerpElement;", "list", "", "columns", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "convert", "(Ljava/util/List;ILcom/avito/android/remote/model/SerpDisplayType;)Lio/reactivex/rxjava3/core/Observable;", "convertSync", "(Ljava/util/List;Lcom/avito/android/remote/model/SerpDisplayType;)Ljava/util/List;", "T", "sortAndAdjust", "(Ljava/util/List;I)Lio/reactivex/rxjava3/core/Observable;", "sortAndAdjustSync", "(Ljava/util/List;I)Ljava/util/List;", "Lcom/avito/conveyor_item/Item;", "serpElements", "", "resolveItemsSync", "(Ljava/util/List;)V", "sort", "", "getHideSeenBadge", "()Z", "setHideSeenBadge", "(Z)V", "hideSeenBadge", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SerpItemProcessor {
    @NotNull
    Observable<List<ViewTypeSerpItem>> convert(@NotNull List<? extends SerpElement> list, int i, @NotNull SerpDisplayType serpDisplayType);

    @NotNull
    List<ViewTypeSerpItem> convertSync(@NotNull List<? extends SerpElement> list, @NotNull SerpDisplayType serpDisplayType);

    boolean getHideSeenBadge();

    <T extends Item> void resolveItemsSync(@NotNull List<? extends T> list);

    void setHideSeenBadge(boolean z);

    @NotNull
    <T extends ViewTypeSerpItem> List<T> sort(@NotNull List<? extends T> list, int i);

    @NotNull
    <T extends ViewTypeSerpItem> Observable<List<T>> sortAndAdjust(@NotNull List<? extends T> list, int i);

    @NotNull
    <T extends ViewTypeSerpItem> List<T> sortAndAdjustSync(@NotNull List<? extends T> list, int i);
}
