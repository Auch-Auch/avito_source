package com.avito.android.messenger.map.search;

import a2.b.a.a.a;
import android.view.View;
import com.avito.android.messenger.channels.mvi.common.Loading;
import com.avito.android.messenger.connection_indicator.ConnectionErrorIndicatorView;
import com.avito.android.messenger.map.search.GeoSearchPresenter;
import com.avito.android.messenger.map.search.GeoSearchView;
import com.avito.android.messenger.map.search.adapter.GeoSearchSuggestItem;
import com.avito.android.remote.auth.AuthSource;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;
import t6.y.f;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR(\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0016\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001c\u0010\u001c\u001a\u00020\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\"\u001a\u00020\u001d8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010'\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"com/avito/android/messenger/map/search/StateModifierImpl$invoke$1", "Lcom/avito/android/messenger/map/search/GeoSearchPresenter$State;", "", "toString", "()Ljava/lang/String;", "", "c", "Z", "getSearchIsInProgress", "()Z", "searchIsInProgress", "Lcom/avito/android/messenger/channels/mvi/common/Loading;", "", "Lcom/avito/android/messenger/map/search/adapter/GeoSearchSuggestItem;", "e", "Lcom/avito/android/messenger/channels/mvi/common/Loading;", "getSearchSuggests", "()Lcom/avito/android/messenger/channels/mvi/common/Loading;", "searchSuggests", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getQuery", "query", "Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State;", "d", "Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State;", "getConnectionErrorIndicatorState", "()Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State;", "connectionErrorIndicatorState", "Lcom/avito/android/messenger/map/search/GeoSearchView$ListState;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/map/search/GeoSearchView$ListState;", "getListState", "()Lcom/avito/android/messenger/map/search/GeoSearchView$ListState;", "listState", "f", "Ljava/util/List;", "getFavoritePlaces", "()Ljava/util/List;", "favoritePlaces", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class StateModifierImpl$invoke$1 implements GeoSearchPresenter.State {
    @NotNull
    public final String a;
    @NotNull
    public final GeoSearchView.ListState b;
    public final boolean c;
    @NotNull
    public final ConnectionErrorIndicatorView.State d;
    @NotNull
    public final Loading<List<GeoSearchSuggestItem>> e;
    @NotNull
    public final List<GeoSearchSuggestItem> f;
    public final /* synthetic */ StateModifierImpl g;
    public final /* synthetic */ String h;
    public final /* synthetic */ List i;

    public StateModifierImpl$invoke$1(StateModifierImpl stateModifierImpl, String str, Loading loading, Loading loading2, GeoSearchView.ListState listState, List list) {
        ConnectionErrorIndicatorView.State state;
        this.g = stateModifierImpl;
        this.h = str;
        this.i = list;
        this.a = str;
        if (!m.isBlank(str)) {
            if (loading instanceof Loading.Empty) {
                if (loading2 instanceof Loading.InProgress) {
                    listState = GeoSearchView.ListState.Empty.INSTANCE;
                }
            } else if (!(loading instanceof Loading.InProgress)) {
                if (loading instanceof Loading.Success) {
                    if (loading2 instanceof Loading.InProgress) {
                        Loading.Success success = (Loading.Success) loading;
                        if (!((Collection) success.getValue()).isEmpty()) {
                            listState = new GeoSearchView.ListState.NonEmpty((List) success.getValue());
                        } else {
                            listState = GeoSearchView.ListState.EmptyWithPlaceHolder.INSTANCE;
                        }
                    }
                } else if (!(loading instanceof Loading.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
            }
        } else if (!list.isEmpty()) {
            listState = new GeoSearchView.ListState.NonEmpty(list);
        } else {
            listState = GeoSearchView.ListState.Empty.INSTANCE;
        }
        this.b = listState;
        this.c = loading instanceof Loading.InProgress;
        if (loading instanceof Loading.Error) {
            state = new ConnectionErrorIndicatorView.State.Shown.Error(StateModifierImpl.access$getConnectionErrorIndicatorMessage$p(stateModifierImpl), StateModifierImpl.access$getConnectionErrorIndicatorActionName$p(stateModifierImpl), new View.OnClickListener(this) { // from class: com.avito.android.messenger.map.search.StateModifierImpl$invoke$1$connectionErrorIndicatorState$1
                public final /* synthetic */ StateModifierImpl$invoke$1 a;

                {
                    this.a = r1;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.g.a.getSearchSuggests(this.a.h);
                }
            });
        } else {
            state = ConnectionErrorIndicatorView.State.Hidden.INSTANCE;
        }
        this.d = state;
        this.e = loading;
        this.f = list;
    }

    @Override // com.avito.android.messenger.map.search.GeoSearchView.State
    @NotNull
    public ConnectionErrorIndicatorView.State getConnectionErrorIndicatorState() {
        return this.d;
    }

    @Override // com.avito.android.messenger.map.search.GeoSearchPresenter.State
    @NotNull
    public List<GeoSearchSuggestItem> getFavoritePlaces() {
        return this.f;
    }

    @Override // com.avito.android.messenger.map.search.GeoSearchView.State
    @NotNull
    public GeoSearchView.ListState getListState() {
        return this.b;
    }

    @Override // com.avito.android.messenger.map.search.GeoSearchView.State
    @NotNull
    public String getQuery() {
        return this.a;
    }

    @Override // com.avito.android.messenger.map.search.GeoSearchView.State
    public boolean getSearchIsInProgress() {
        return this.c;
    }

    @Override // com.avito.android.messenger.map.search.GeoSearchPresenter.State
    @NotNull
    public Loading<List<GeoSearchSuggestItem>> getSearchSuggests() {
        return this.e;
    }

    @Override // com.avito.android.messenger.map.search.GeoSearchPresenter.State
    @NotNull
    public String toString() {
        StringBuilder L = a.L("GeoSearchPresenter.State(\n        |   query=");
        L.append(getQuery());
        L.append(",\n        |   listState=");
        L.append(getListState());
        L.append(",\n        |   searchIsInProgress=");
        L.append(getSearchIsInProgress());
        L.append(",\n        |   connectionErrorIndicatorState=");
        L.append(getConnectionErrorIndicatorState());
        L.append(",\n        |   searchSuggests=");
        L.append(getSearchSuggests());
        L.append(",\n        |   favoritePlaces=");
        L.append(getFavoritePlaces());
        L.append("\n        |)");
        return f.trimMargin$default(L.toString(), null, 1, null);
    }
}
