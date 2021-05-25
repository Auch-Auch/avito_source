package com.avito.android.grouping_adverts;

import com.avito.android.grouping_adverts.GroupingAdvertsArguments;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SerpElementResult;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J7\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/grouping_adverts/GroupingAdvertsInteractor;", "", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "", "page", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/SerpElementResult;", "loadGroupedElements", "(Lcom/avito/android/remote/model/SearchParams;Ljava/lang/Integer;Lcom/avito/android/remote/model/SerpDisplayType;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/grouping_adverts/GroupingAdvertsArguments$ItemList;", "args", "", "source", "loadElementsByIds", "(Lcom/avito/android/grouping_adverts/GroupingAdvertsArguments$ItemList;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "grouping-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface GroupingAdvertsInteractor {
    @NotNull
    Observable<LoadingState<SerpElementResult>> loadElementsByIds(@NotNull GroupingAdvertsArguments.ItemList itemList, @Nullable String str);

    @NotNull
    Observable<LoadingState<SerpElementResult>> loadGroupedElements(@NotNull SearchParams searchParams, @Nullable Integer num, @Nullable SerpDisplayType serpDisplayType);
}
