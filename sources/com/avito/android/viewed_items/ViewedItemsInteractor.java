package com.avito.android.viewed_items;

import com.avito.android.util.LoadingState;
import com.avito.android.viewed_items.model.ViewedItemsModel;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/viewed_items/ViewedItemsInteractor;", "", "", "nextPage", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/viewed_items/model/ViewedItemsModel;", "getViewedItems", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "favorites_release"}, k = 1, mv = {1, 4, 2})
public interface ViewedItemsInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable getViewedItems$default(ViewedItemsInteractor viewedItemsInteractor, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                return viewedItemsInteractor.getViewedItems(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getViewedItems");
        }
    }

    @NotNull
    Observable<LoadingState<ViewedItemsModel>> getViewedItems(@Nullable String str);
}
