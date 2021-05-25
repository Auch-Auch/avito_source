package com.avito.android.auto_catalog;

import com.avito.android.auto_catalog.remote.model.AutoCatalogResponse;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.serp.adapter.PersistableSerpItem;
import com.avito.android.util.LoadingState;
import com.avito.android.util.UrlParams;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006JW\u0010\u0014\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00110\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/auto_catalog/AutoCatalogInteractor;", "", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/auto_catalog/remote/model/AutoCatalogResponse;", "loadAutoCatalog", "()Lio/reactivex/Observable;", "", "page", "", UrlParams.LAST_STAMP, "", "context", "", "areNotificationsEnabled", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "Lkotlin/Pair;", "", "Lcom/avito/android/serp/adapter/PersistableSerpItem;", "getSerpItems", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Lcom/avito/android/remote/model/SearchParams;)Lio/reactivex/Observable;", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
public interface AutoCatalogInteractor {
    @NotNull
    Observable<Pair<Long, List<PersistableSerpItem>>> getSerpItems(@Nullable Integer num, @Nullable Long l, @Nullable String str, @Nullable Boolean bool, @NotNull SearchParams searchParams);

    @NotNull
    Observable<LoadingState<AutoCatalogResponse>> loadAutoCatalog();
}
