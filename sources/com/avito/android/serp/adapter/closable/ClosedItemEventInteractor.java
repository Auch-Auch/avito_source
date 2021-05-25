package com.avito.android.serp.adapter.closable;

import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/serp/adapter/closable/ClosedItemEventInteractor;", "", "", "id", "", "itemClosed", "(Ljava/lang/String;)V", "Lio/reactivex/rxjava3/core/Observable;", "getClosedItemEvents", "()Lio/reactivex/rxjava3/core/Observable;", "closedItemEvents", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface ClosedItemEventInteractor {
    @NotNull
    Observable<String> getClosedItemEvents();

    void itemClosed(@NotNull String str);
}
