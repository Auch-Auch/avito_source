package com.avito.android.serp.adapter;

import com.avito.conveyor_item.Item;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J3\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0006\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\n\u001a\u00020\t\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/serp/adapter/ViewedStatusResolver;", "", "Lcom/avito/conveyor_item/Item;", "T", "", "items", "Lio/reactivex/rxjava3/core/Observable;", "resolve", "(Ljava/util/List;)Lio/reactivex/rxjava3/core/Observable;", "", "resolveSync", "(Ljava/util/List;)V", "viewed-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface ViewedStatusResolver {
    @NotNull
    <T extends Item> Observable<List<T>> resolve(@NotNull List<? extends T> list);

    <T extends Item> void resolveSync(@NotNull List<? extends T> list);
}
