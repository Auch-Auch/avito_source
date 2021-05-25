package com.avito.android.messenger.map.search;

import a2.b.a.a.a;
import com.avito.android.messenger.channels.mvi.common.Loading;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.geo.GeoSearchSuggest;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.y.f;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/map/search/GeoSearchInteractor;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/map/search/GeoSearchInteractor$State;", "", "query", "", "getSearchSuggests", "(Ljava/lang/String;)V", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface GeoSearchInteractor extends MviEntity<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB)\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\t¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ6\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\tHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R%\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u000bR\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\b¨\u0006 "}, d2 = {"Lcom/avito/android/messenger/map/search/GeoSearchInteractor$State;", "", "", "toString", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/messenger/geo/GeoSearchSuggest;", "component1", "()Ljava/util/List;", "Lcom/avito/android/messenger/channels/mvi/common/Loading;", "component2", "()Lcom/avito/android/messenger/channels/mvi/common/Loading;", "favoritePlaces", "searchSuggests", "copy", "(Ljava/util/List;Lcom/avito/android/messenger/channels/mvi/common/Loading;)Lcom/avito/android/messenger/map/search/GeoSearchInteractor$State;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/channels/mvi/common/Loading;", "getSearchSuggests", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getFavoritePlaces", "<init>", "(Ljava/util/List;Lcom/avito/android/messenger/channels/mvi/common/Loading;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class State {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final State c = new State(CollectionsKt__CollectionsKt.emptyList(), new Loading.Empty());
        @NotNull
        public final List<GeoSearchSuggest> a;
        @NotNull
        public final Loading<List<GeoSearchSuggest>> b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/map/search/GeoSearchInteractor$State$Companion;", "", "Lcom/avito/android/messenger/map/search/GeoSearchInteractor$State;", MessengerShareContentUtility.PREVIEW_DEFAULT, "Lcom/avito/android/messenger/map/search/GeoSearchInteractor$State;", "getDEFAULT", "()Lcom/avito/android/messenger/map/search/GeoSearchInteractor$State;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            @NotNull
            public final State getDEFAULT() {
                return State.c;
            }

            public Companion(j jVar) {
            }
        }

        public State(@NotNull List<GeoSearchSuggest> list, @NotNull Loading<List<GeoSearchSuggest>> loading) {
            Intrinsics.checkNotNullParameter(list, "favoritePlaces");
            Intrinsics.checkNotNullParameter(loading, "searchSuggests");
            this.a = list;
            this.b = loading;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.messenger.map.search.GeoSearchInteractor$State */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, List list, Loading loading, int i, Object obj) {
            if ((i & 1) != 0) {
                list = state.a;
            }
            if ((i & 2) != 0) {
                loading = state.b;
            }
            return state.copy(list, loading);
        }

        @NotNull
        public final List<GeoSearchSuggest> component1() {
            return this.a;
        }

        @NotNull
        public final Loading<List<GeoSearchSuggest>> component2() {
            return this.b;
        }

        @NotNull
        public final State copy(@NotNull List<GeoSearchSuggest> list, @NotNull Loading<List<GeoSearchSuggest>> loading) {
            Intrinsics.checkNotNullParameter(list, "favoritePlaces");
            Intrinsics.checkNotNullParameter(loading, "searchSuggests");
            return new State(list, loading);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof State)) {
                return false;
            }
            State state = (State) obj;
            return Intrinsics.areEqual(this.a, state.a) && Intrinsics.areEqual(this.b, state.b);
        }

        @NotNull
        public final List<GeoSearchSuggest> getFavoritePlaces() {
            return this.a;
        }

        @NotNull
        public final Loading<List<GeoSearchSuggest>> getSearchSuggests() {
            return this.b;
        }

        public int hashCode() {
            List<GeoSearchSuggest> list = this.a;
            int i = 0;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            Loading<List<GeoSearchSuggest>> loading = this.b;
            if (loading != null) {
                i = loading.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("State(\n                |   favoritePlaces=");
            L.append(this.a);
            L.append(",\n                |   searchSuggests=");
            L.append(this.b);
            L.append("\n                |)");
            return f.trimMargin$default(L.toString(), null, 1, null);
        }
    }

    void getSearchSuggests(@NotNull String str);
}
