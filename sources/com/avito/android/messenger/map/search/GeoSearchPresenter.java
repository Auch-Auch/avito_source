package com.avito.android.messenger.map.search;

import androidx.lifecycle.LiveData;
import com.avito.android.messenger.channels.mvi.common.Loading;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.messenger.map.search.GeoSearchView;
import com.avito.android.messenger.map.search.adapter.GeoSearchSuggestItem;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0010J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/messenger/map/search/GeoSearchPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/map/search/GeoSearchPresenter$State;", "Lcom/avito/android/messenger/map/search/GeoSearchSuggestClickListener;", "", "newQuery", "", "queryChanged", "(Ljava/lang/String;)V", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/messenger/map/search/adapter/GeoSearchSuggestItem;", "getSendSuggestStream", "()Landroidx/lifecycle/LiveData;", "sendSuggestStream", "getSetQueryStream", "setQueryStream", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface GeoSearchPresenter extends MviEntity<State>, GeoSearchSuggestClickListener {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/messenger/map/search/GeoSearchPresenter$State;", "Lcom/avito/android/messenger/map/search/GeoSearchView$State;", "", "toString", "()Ljava/lang/String;", "", "Lcom/avito/android/messenger/map/search/adapter/GeoSearchSuggestItem;", "getFavoritePlaces", "()Ljava/util/List;", "favoritePlaces", "Lcom/avito/android/messenger/channels/mvi/common/Loading;", "getSearchSuggests", "()Lcom/avito/android/messenger/channels/mvi/common/Loading;", "searchSuggests", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public interface State extends GeoSearchView.State {
        @NotNull
        public static final Companion Companion = Companion.a;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/map/search/GeoSearchPresenter$State$Companion;", "", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public static final /* synthetic */ Companion a = new Companion();
        }

        @NotNull
        List<GeoSearchSuggestItem> getFavoritePlaces();

        @NotNull
        Loading<List<GeoSearchSuggestItem>> getSearchSuggests();

        @NotNull
        String toString();
    }

    @NotNull
    LiveData<GeoSearchSuggestItem> getSendSuggestStream();

    @NotNull
    LiveData<String> getSetQueryStream();

    void queryChanged(@NotNull String str);
}
