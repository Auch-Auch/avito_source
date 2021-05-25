package com.avito.android.messenger.map.search;

import a2.b.a.a.a;
import com.avito.android.messenger.channels.mvi.common.v2.Renderer;
import com.avito.android.messenger.connection_indicator.ConnectionErrorIndicatorView;
import com.avito.android.messenger.map.search.adapter.GeoSearchSuggestItem;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\r\u000eJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/messenger/map/search/GeoSearchView;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;", "Lcom/avito/android/messenger/map/search/GeoSearchView$State;", "", "text", "", "setQuery", "(Ljava/lang/CharSequence;)V", "Lio/reactivex/Observable;", "", "getQueryStream", "()Lio/reactivex/Observable;", "queryStream", "ListState", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface GeoSearchView extends Renderer<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void render(@NotNull GeoSearchView geoSearchView, @NotNull State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            Renderer.DefaultImpls.render(geoSearchView, state);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/map/search/GeoSearchView$ListState;", "", "<init>", "()V", "Empty", "EmptyWithPlaceHolder", "NonEmpty", "Lcom/avito/android/messenger/map/search/GeoSearchView$ListState$Empty;", "Lcom/avito/android/messenger/map/search/GeoSearchView$ListState$EmptyWithPlaceHolder;", "Lcom/avito/android/messenger/map/search/GeoSearchView$ListState$NonEmpty;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ListState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/map/search/GeoSearchView$ListState$Empty;", "Lcom/avito/android/messenger/map/search/GeoSearchView$ListState;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends ListState {
            @NotNull
            public static final Empty INSTANCE = new Empty();

            public Empty() {
                super(null);
            }

            @NotNull
            public String toString() {
                return "ListState.Empty";
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/map/search/GeoSearchView$ListState$EmptyWithPlaceHolder;", "Lcom/avito/android/messenger/map/search/GeoSearchView$ListState;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class EmptyWithPlaceHolder extends ListState {
            @NotNull
            public static final EmptyWithPlaceHolder INSTANCE = new EmptyWithPlaceHolder();

            public EmptyWithPlaceHolder() {
                super(null);
            }

            @NotNull
            public String toString() {
                return "ListState.EmptyWithPlaceHolder";
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/map/search/GeoSearchView$ListState$NonEmpty;", "Lcom/avito/android/messenger/map/search/GeoSearchView$ListState;", "", "toString", "()Ljava/lang/String;", "", "Lcom/avito/android/messenger/map/search/adapter/GeoSearchSuggestItem;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getItems", "()Ljava/util/List;", "items", "<init>", "(Ljava/util/List;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class NonEmpty extends ListState {
            @NotNull
            public final List<GeoSearchSuggestItem> a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public NonEmpty(@NotNull List<GeoSearchSuggestItem> list) {
                super(null);
                Intrinsics.checkNotNullParameter(list, "items");
                this.a = list;
            }

            @NotNull
            public final List<GeoSearchSuggestItem> getItems() {
                return this.a;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("ListState.NonEmpty(items = ");
                L.append(this.a);
                L.append(')');
                return L.toString();
            }
        }

        public ListState() {
        }

        public ListState(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/map/search/GeoSearchView$State;", "", "", "getQuery", "()Ljava/lang/String;", "query", "Lcom/avito/android/messenger/map/search/GeoSearchView$ListState;", "getListState", "()Lcom/avito/android/messenger/map/search/GeoSearchView$ListState;", "listState", "Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State;", "getConnectionErrorIndicatorState", "()Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State;", "connectionErrorIndicatorState", "", "getSearchIsInProgress", "()Z", "searchIsInProgress", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public interface State {
        @NotNull
        ConnectionErrorIndicatorView.State getConnectionErrorIndicatorState();

        @NotNull
        ListState getListState();

        @NotNull
        String getQuery();

        boolean getSearchIsInProgress();
    }

    @NotNull
    Observable<String> getQueryStream();

    void setQuery(@NotNull CharSequence charSequence);
}
