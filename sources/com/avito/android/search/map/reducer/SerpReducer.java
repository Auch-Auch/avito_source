package com.avito.android.search.map.reducer;

import com.avito.android.di.PerFragment;
import com.avito.android.redux.Reducer;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.saved_searches.SavedSearchesPresenter;
import com.avito.android.search.map.SearchMapState;
import com.avito.android.search.map.action.MapAction;
import com.avito.android.search.map.interactor.SerpDataSources;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.data_source.IterableDataSource;
import com.avito.konveyor.data_source.ListDataSource;
import com.avito.konveyor.util.DataSources;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@PerFragment
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/search/map/reducer/SerpReducer;", "Lcom/avito/android/redux/Reducer;", "Lcom/avito/android/search/map/SearchMapState;", "Lcom/avito/android/search/map/action/MapAction;", "state", "action", "reduce", "(Lcom/avito/android/search/map/SearchMapState;Lcom/avito/android/search/map/action/MapAction;)Lcom/avito/android/search/map/SearchMapState;", "Lcom/avito/android/search/map/SearchMapState$SerpState;", "", "id", AuthSource.SEND_ABUSE, "(Lcom/avito/android/search/map/SearchMapState$SerpState;Ljava/lang/String;)Lcom/avito/android/search/map/SearchMapState$SerpState;", "Lcom/avito/android/saved_searches/SavedSearchesPresenter;", "Lcom/avito/android/saved_searches/SavedSearchesPresenter;", "savedSearchesPresenter", "<init>", "(Lcom/avito/android/saved_searches/SavedSearchesPresenter;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class SerpReducer implements Reducer<SearchMapState, MapAction> {
    public final SavedSearchesPresenter a;

    @Inject
    public SerpReducer(@NotNull SavedSearchesPresenter savedSearchesPresenter) {
        Intrinsics.checkNotNullParameter(savedSearchesPresenter, "savedSearchesPresenter");
        this.a = savedSearchesPresenter;
    }

    public final SearchMapState.SerpState a(SearchMapState.SerpState serpState, String str) {
        SerpDataSources dataSources = serpState.getDataSources();
        if (dataSources == null) {
            return serpState;
        }
        DataSource<SpannedItem> spans = dataSources.getSpans();
        IterableDataSource iterableDataSource = DataSources.toIterableDataSource(dataSources.getSerpItems());
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterableDataSource) {
            if (!Intrinsics.areEqual(((ViewTypeSerpItem) obj).getStringId(), str)) {
                arrayList.add(obj);
            }
        }
        return SearchMapState.SerpState.copy$default(serpState, null, null, false, null, null, new SerpDataSources(spans, new ListDataSource(arrayList)), null, 0, null, null, false, null, false, 0, 0, false, null, null, null, 524255, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:178:0x080a  */
    /* JADX WARNING: Removed duplicated region for block: B:190:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.avito.android.search.map.SearchMapState reduce(@org.jetbrains.annotations.NotNull com.avito.android.search.map.SearchMapState r40, @org.jetbrains.annotations.NotNull com.avito.android.search.map.action.MapAction r41) {
        /*
        // Method dump skipped, instructions count: 2079
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.search.map.reducer.SerpReducer.reduce(com.avito.android.search.map.SearchMapState, com.avito.android.search.map.action.MapAction):com.avito.android.search.map.SearchMapState");
    }
}
