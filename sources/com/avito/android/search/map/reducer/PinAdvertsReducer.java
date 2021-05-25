package com.avito.android.search.map.reducer;

import com.avito.android.di.PerFragment;
import com.avito.android.redux.Reducer;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.map.SearchMapState;
import com.avito.android.search.map.action.MapAction;
import com.avito.android.search.map.view.adapter.AppendingState;
import java.util.List;
import kotlin.Metadata;
@PerFragment
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/search/map/reducer/PinAdvertsReducer;", "Lcom/avito/android/redux/Reducer;", "Lcom/avito/android/search/map/SearchMapState;", "Lcom/avito/android/search/map/action/MapAction;", "state", "action", "reduce", "(Lcom/avito/android/search/map/SearchMapState;Lcom/avito/android/search/map/action/MapAction;)Lcom/avito/android/search/map/SearchMapState;", "", "count", "", "", "ids", "Lcom/avito/android/search/map/view/adapter/AppendingState;", AuthSource.SEND_ABUSE, "(ILjava/util/List;)Lcom/avito/android/search/map/view/adapter/AppendingState;", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class PinAdvertsReducer implements Reducer<SearchMapState, MapAction> {
    public final AppendingState a(int i, List<String> list) {
        if (i < list.size()) {
            return AppendingState.CAN_LOAD;
        }
        return AppendingState.NONE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:87:0x03c0  */
    /* JADX WARNING: Removed duplicated region for block: B:96:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.avito.android.search.map.SearchMapState reduce(@org.jetbrains.annotations.NotNull com.avito.android.search.map.SearchMapState r32, @org.jetbrains.annotations.NotNull com.avito.android.search.map.action.MapAction r33) {
        /*
        // Method dump skipped, instructions count: 981
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.search.map.reducer.PinAdvertsReducer.reduce(com.avito.android.search.map.SearchMapState, com.avito.android.search.map.action.MapAction):com.avito.android.search.map.SearchMapState");
    }
}
