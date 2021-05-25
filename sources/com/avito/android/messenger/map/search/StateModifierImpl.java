package com.avito.android.messenger.map.search;

import com.avito.android.messenger.channels.mvi.common.Loading;
import com.avito.android.messenger.map.search.GeoSearchPresenter;
import com.avito.android.messenger.map.search.adapter.GeoSearchSuggestItem;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0016J=\u0010\n\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/avito/android/messenger/map/search/StateModifierImpl;", "Lcom/avito/android/messenger/map/search/StateModifier;", "Lcom/avito/android/messenger/map/search/GeoSearchPresenter$State;", "", "query", "Lcom/avito/android/messenger/channels/mvi/common/Loading;", "", "Lcom/avito/android/messenger/map/search/adapter/GeoSearchSuggestItem;", "searchSuggests", "favoritePlaces", "copy", "(Lcom/avito/android/messenger/map/search/GeoSearchPresenter$State;Ljava/lang/String;Lcom/avito/android/messenger/channels/mvi/common/Loading;Ljava/util/List;)Lcom/avito/android/messenger/map/search/GeoSearchPresenter$State;", "Lcom/avito/android/messenger/map/search/GeoSearchInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/map/search/GeoSearchInteractor;", "interactor", "c", "Ljava/lang/String;", "connectionErrorIndicatorActionName", AuthSource.BOOKING_ORDER, "connectionErrorIndicatorMessage", "<init>", "(Lcom/avito/android/messenger/map/search/GeoSearchInteractor;Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class StateModifierImpl implements StateModifier {
    public final GeoSearchInteractor a;
    public final String b;
    public final String c;

    public StateModifierImpl(@NotNull GeoSearchInteractor geoSearchInteractor, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(geoSearchInteractor, "interactor");
        Intrinsics.checkNotNullParameter(str, "connectionErrorIndicatorMessage");
        Intrinsics.checkNotNullParameter(str2, "connectionErrorIndicatorActionName");
        this.a = geoSearchInteractor;
        this.b = str;
        this.c = str2;
    }

    @Override // com.avito.android.messenger.map.search.StateModifier
    @NotNull
    public GeoSearchPresenter.State copy(@NotNull GeoSearchPresenter.State state, @NotNull String str, @NotNull Loading<List<GeoSearchSuggestItem>> loading, @NotNull List<GeoSearchSuggestItem> list) {
        Intrinsics.checkNotNullParameter(state, "$this$copy");
        Intrinsics.checkNotNullParameter(str, "query");
        Intrinsics.checkNotNullParameter(loading, "searchSuggests");
        Intrinsics.checkNotNullParameter(list, "favoritePlaces");
        GeoSearchPresenter.State.Companion companion = GeoSearchPresenter.State.Companion;
        return new StateModifierImpl$invoke$1(this, str, loading, state.getSearchSuggests(), state.getListState(), list);
    }
}
