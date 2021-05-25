package com.avito.android.messenger.search;

import a2.b.a.a.a;
import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.messenger.channels.mvi.common.v2.RendererWithDiff;
import com.avito.android.messenger.search.adapter.ChannelsSearchListItem;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0005R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchView;", "Lcom/avito/android/messenger/channels/mvi/common/v2/RendererWithDiff;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State;", "", "clearQuery", "()V", "destroy", "Lio/reactivex/Observable;", "getSearchRequestStream", "()Lio/reactivex/Observable;", "searchRequestStream", "getRetryStream", "retryStream", "getNextPageRequestStream", "nextPageRequestStream", "", "getQueryChangeStream", "queryChangeStream", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelsSearchView extends RendererWithDiff<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void render(@NotNull ChannelsSearchView channelsSearchView, @NotNull State state, @Nullable DiffUtil.DiffResult diffResult) {
            Intrinsics.checkNotNullParameter(state, "state");
            RendererWithDiff.DefaultImpls.render(channelsSearchView, state, diffResult);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\f\r\u000e\u000f\u0010\u0011\u0012B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0001\u0005\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchView$State;", "", "Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;", "getResults", "()Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;", "results", "Lcom/avito/android/messenger/search/SearchQuery;", "getQuery", "()Lcom/avito/android/messenger/search/SearchQuery;", "query", "<init>", "()V", "Empty", "Error", "Loaded", "Loading", "PaginationState", ScreenPublicConstsKt.SERP_SCREEN_NAME, "ShortQuery", "Lcom/avito/android/messenger/search/ChannelsSearchView$State$Empty;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State$ShortQuery;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State$Loading;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State$Loaded;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State$Error;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchView$State$Empty;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State;", "Lcom/avito/android/messenger/search/SearchQuery;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/search/SearchQuery;", "getQuery", "()Lcom/avito/android/messenger/search/SearchQuery;", "query", "Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;", "getResults", "()Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;", "results", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends State {
            @NotNull
            public static final Empty INSTANCE;
            @NotNull
            public static final SearchQuery a = SearchQuery.Companion.getEMPTY();
            @NotNull
            public static final SearchResults b;

            static {
                Empty empty = new Empty();
                INSTANCE = empty;
                b = new SearchResults(empty.getQuery(), null, false, 6, null);
            }

            public Empty() {
                super(null);
            }

            @Override // com.avito.android.messenger.search.ChannelsSearchView.State
            @NotNull
            public SearchQuery getQuery() {
                return a;
            }

            @Override // com.avito.android.messenger.search.ChannelsSearchView.State
            @NotNull
            public SearchResults getResults() {
                return b;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b)\u0010*J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ:\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0010\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\nR\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0004R\u001c\u0010\u000f\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0007R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u000e¨\u0006+"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchView$State$Error;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State;", "", "toString", "()Ljava/lang/String;", "Lcom/avito/android/messenger/search/SearchQuery;", "component1", "()Lcom/avito/android/messenger/search/SearchQuery;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;", "component2", "()Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;", "component3", "", "component4", "()Ljava/lang/Throwable;", "query", "results", "message", "error", "copy", "(Lcom/avito/android/messenger/search/SearchQuery;Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;Ljava/lang/String;Ljava/lang/Throwable;)Lcom/avito/android/messenger/search/ChannelsSearchView$State$Error;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;", "getResults", "c", "Ljava/lang/String;", "getMessage", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/search/SearchQuery;", "getQuery", "d", "Ljava/lang/Throwable;", "getError", "<init>", "(Lcom/avito/android/messenger/search/SearchQuery;Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;Ljava/lang/String;Ljava/lang/Throwable;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends State {
            @NotNull
            public final SearchQuery a;
            @NotNull
            public final SearchResults b;
            @NotNull
            public final String c;
            @Nullable
            public final Throwable d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(@NotNull SearchQuery searchQuery, @NotNull SearchResults searchResults, @NotNull String str, @Nullable Throwable th) {
                super(null);
                Intrinsics.checkNotNullParameter(searchQuery, "query");
                Intrinsics.checkNotNullParameter(searchResults, "results");
                Intrinsics.checkNotNullParameter(str, "message");
                this.a = searchQuery;
                this.b = searchResults;
                this.c = str;
                this.d = th;
            }

            public static /* synthetic */ Error copy$default(Error error, SearchQuery searchQuery, SearchResults searchResults, String str, Throwable th, int i, Object obj) {
                if ((i & 1) != 0) {
                    searchQuery = error.getQuery();
                }
                if ((i & 2) != 0) {
                    searchResults = error.getResults();
                }
                if ((i & 4) != 0) {
                    str = error.c;
                }
                if ((i & 8) != 0) {
                    th = error.d;
                }
                return error.copy(searchQuery, searchResults, str, th);
            }

            @NotNull
            public final SearchQuery component1() {
                return getQuery();
            }

            @NotNull
            public final SearchResults component2() {
                return getResults();
            }

            @NotNull
            public final String component3() {
                return this.c;
            }

            @Nullable
            public final Throwable component4() {
                return this.d;
            }

            @NotNull
            public final Error copy(@NotNull SearchQuery searchQuery, @NotNull SearchResults searchResults, @NotNull String str, @Nullable Throwable th) {
                Intrinsics.checkNotNullParameter(searchQuery, "query");
                Intrinsics.checkNotNullParameter(searchResults, "results");
                Intrinsics.checkNotNullParameter(str, "message");
                return new Error(searchQuery, searchResults, str, th);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Error)) {
                    return false;
                }
                Error error = (Error) obj;
                return Intrinsics.areEqual(getQuery(), error.getQuery()) && Intrinsics.areEqual(getResults(), error.getResults()) && Intrinsics.areEqual(this.c, error.c) && Intrinsics.areEqual(this.d, error.d);
            }

            @Nullable
            public final Throwable getError() {
                return this.d;
            }

            @NotNull
            public final String getMessage() {
                return this.c;
            }

            @Override // com.avito.android.messenger.search.ChannelsSearchView.State
            @NotNull
            public SearchQuery getQuery() {
                return this.a;
            }

            @Override // com.avito.android.messenger.search.ChannelsSearchView.State
            @NotNull
            public SearchResults getResults() {
                return this.b;
            }

            public int hashCode() {
                SearchQuery query = getQuery();
                int i = 0;
                int hashCode = (query != null ? query.hashCode() : 0) * 31;
                SearchResults results = getResults();
                int hashCode2 = (hashCode + (results != null ? results.hashCode() : 0)) * 31;
                String str = this.c;
                int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
                Throwable th = this.d;
                if (th != null) {
                    i = th.hashCode();
                }
                return hashCode3 + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Loaded.Error(query=");
                L.append(getQuery());
                L.append(", results=");
                L.append(getResults());
                L.append(", message=");
                L.append(this.c);
                L.append(", error=");
                L.append(this.d);
                L.append(')');
                return L.toString();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tB\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchView$State$Loaded;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State$PaginationState;", "getPaginationState", "()Lcom/avito/android/messenger/search/ChannelsSearchView$State$PaginationState;", "paginationState", "<init>", "()V", "Empty", "Results", "Lcom/avito/android/messenger/search/ChannelsSearchView$State$Loaded$Empty;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State$Loaded$Results;", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class Loaded extends State {

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u001c\u0010\u001b\u001a\u00020\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010!\u001a\u00020\u001c8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchView$State$Loaded$Empty;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State$Loaded;", "", "toString", "()Ljava/lang/String;", "Lcom/avito/android/messenger/search/SearchQuery;", "component1", "()Lcom/avito/android/messenger/search/SearchQuery;", "query", "copy", "(Lcom/avito/android/messenger/search/SearchQuery;)Lcom/avito/android/messenger/search/ChannelsSearchView$State$Loaded$Empty;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Lcom/avito/android/messenger/search/SearchQuery;", "getQuery", "Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;", "getResults", "()Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;", "results", "Lcom/avito/android/messenger/search/ChannelsSearchView$State$PaginationState$Idle;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/search/ChannelsSearchView$State$PaginationState$Idle;", "getPaginationState", "()Lcom/avito/android/messenger/search/ChannelsSearchView$State$PaginationState$Idle;", "paginationState", "<init>", "(Lcom/avito/android/messenger/search/SearchQuery;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Empty extends Loaded {
                @NotNull
                public final SearchResults a = SearchResults.Companion.getEMPTY();
                @NotNull
                public final PaginationState.Idle b = PaginationState.Idle.INSTANCE;
                @NotNull
                public final SearchQuery c;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Empty(@NotNull SearchQuery searchQuery) {
                    super(null);
                    Intrinsics.checkNotNullParameter(searchQuery, "query");
                    this.c = searchQuery;
                }

                public static /* synthetic */ Empty copy$default(Empty empty, SearchQuery searchQuery, int i, Object obj) {
                    if ((i & 1) != 0) {
                        searchQuery = empty.getQuery();
                    }
                    return empty.copy(searchQuery);
                }

                @NotNull
                public final SearchQuery component1() {
                    return getQuery();
                }

                @NotNull
                public final Empty copy(@NotNull SearchQuery searchQuery) {
                    Intrinsics.checkNotNullParameter(searchQuery, "query");
                    return new Empty(searchQuery);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this != obj) {
                        return (obj instanceof Empty) && Intrinsics.areEqual(getQuery(), ((Empty) obj).getQuery());
                    }
                    return true;
                }

                @Override // com.avito.android.messenger.search.ChannelsSearchView.State
                @NotNull
                public SearchQuery getQuery() {
                    return this.c;
                }

                @Override // com.avito.android.messenger.search.ChannelsSearchView.State
                @NotNull
                public SearchResults getResults() {
                    return this.a;
                }

                public int hashCode() {
                    SearchQuery query = getQuery();
                    if (query != null) {
                        return query.hashCode();
                    }
                    return 0;
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Loaded.Empty(query=");
                    L.append(getQuery());
                    L.append(')');
                    return L.toString();
                }

                @Override // com.avito.android.messenger.search.ChannelsSearchView.State.Loaded
                @NotNull
                public PaginationState.Idle getPaginationState() {
                    return this.b;
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\b¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ$\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\f\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u0016\u0010 \u001a\u00020\u001d8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchView$State$Loaded$Results;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State$Loaded;", "", "toString", "()Ljava/lang/String;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;", "component1", "()Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State$PaginationState;", "component2", "()Lcom/avito/android/messenger/search/ChannelsSearchView$State$PaginationState;", "results", "paginationState", "copy", "(Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;Lcom/avito/android/messenger/search/ChannelsSearchView$State$PaginationState;)Lcom/avito/android/messenger/search/ChannelsSearchView$State$Loaded$Results;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/search/ChannelsSearchView$State$PaginationState;", "getPaginationState", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;", "getResults", "Lcom/avito/android/messenger/search/SearchQuery;", "getQuery", "()Lcom/avito/android/messenger/search/SearchQuery;", "query", "<init>", "(Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;Lcom/avito/android/messenger/search/ChannelsSearchView$State$PaginationState;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Results extends Loaded {
                @NotNull
                public final SearchResults a;
                @NotNull
                public final PaginationState b;

                /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                public /* synthetic */ Results(SearchResults searchResults, PaginationState paginationState, int i, j jVar) {
                    this(searchResults, (i & 2) != 0 ? PaginationState.Idle.INSTANCE : paginationState);
                }

                public static /* synthetic */ Results copy$default(Results results, SearchResults searchResults, PaginationState paginationState, int i, Object obj) {
                    if ((i & 1) != 0) {
                        searchResults = results.getResults();
                    }
                    if ((i & 2) != 0) {
                        paginationState = results.getPaginationState();
                    }
                    return results.copy(searchResults, paginationState);
                }

                @NotNull
                public final SearchResults component1() {
                    return getResults();
                }

                @NotNull
                public final PaginationState component2() {
                    return getPaginationState();
                }

                @NotNull
                public final Results copy(@NotNull SearchResults searchResults, @NotNull PaginationState paginationState) {
                    Intrinsics.checkNotNullParameter(searchResults, "results");
                    Intrinsics.checkNotNullParameter(paginationState, "paginationState");
                    return new Results(searchResults, paginationState);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof Results)) {
                        return false;
                    }
                    Results results = (Results) obj;
                    return Intrinsics.areEqual(getResults(), results.getResults()) && Intrinsics.areEqual(getPaginationState(), results.getPaginationState());
                }

                @Override // com.avito.android.messenger.search.ChannelsSearchView.State.Loaded
                @NotNull
                public PaginationState getPaginationState() {
                    return this.b;
                }

                @Override // com.avito.android.messenger.search.ChannelsSearchView.State
                @NotNull
                public SearchQuery getQuery() {
                    return getResults().getQuery();
                }

                @Override // com.avito.android.messenger.search.ChannelsSearchView.State
                @NotNull
                public SearchResults getResults() {
                    return this.a;
                }

                public int hashCode() {
                    SearchResults results = getResults();
                    int i = 0;
                    int hashCode = (results != null ? results.hashCode() : 0) * 31;
                    PaginationState paginationState = getPaginationState();
                    if (paginationState != null) {
                        i = paginationState.hashCode();
                    }
                    return hashCode + i;
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Loaded.Results(query=");
                    L.append(getQuery());
                    L.append(", paginationState=");
                    L.append(getPaginationState());
                    L.append(", results=");
                    L.append(getResults());
                    L.append(')');
                    return L.toString();
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Results(@NotNull SearchResults searchResults, @NotNull PaginationState paginationState) {
                    super(null);
                    Intrinsics.checkNotNullParameter(searchResults, "results");
                    Intrinsics.checkNotNullParameter(paginationState, "paginationState");
                    this.a = searchResults;
                    this.b = paginationState;
                }
            }

            public Loaded() {
                super(null);
            }

            @NotNull
            public abstract PaginationState getPaginationState();

            public Loaded(j jVar) {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\t\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchView$State$Loading;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State;", "Lcom/avito/android/messenger/search/SearchQuery;", "component1", "()Lcom/avito/android/messenger/search/SearchQuery;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;", "component2", "()Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;", "query", "results", "copy", "(Lcom/avito/android/messenger/search/SearchQuery;Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;)Lcom/avito/android/messenger/search/ChannelsSearchView$State$Loading;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;", "getResults", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/search/SearchQuery;", "getQuery", "<init>", "(Lcom/avito/android/messenger/search/SearchQuery;Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends State {
            @NotNull
            public final SearchQuery a;
            @NotNull
            public final SearchResults b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Loading(@NotNull SearchQuery searchQuery, @NotNull SearchResults searchResults) {
                super(null);
                Intrinsics.checkNotNullParameter(searchQuery, "query");
                Intrinsics.checkNotNullParameter(searchResults, "results");
                this.a = searchQuery;
                this.b = searchResults;
            }

            public static /* synthetic */ Loading copy$default(Loading loading, SearchQuery searchQuery, SearchResults searchResults, int i, Object obj) {
                if ((i & 1) != 0) {
                    searchQuery = loading.getQuery();
                }
                if ((i & 2) != 0) {
                    searchResults = loading.getResults();
                }
                return loading.copy(searchQuery, searchResults);
            }

            @NotNull
            public final SearchQuery component1() {
                return getQuery();
            }

            @NotNull
            public final SearchResults component2() {
                return getResults();
            }

            @NotNull
            public final Loading copy(@NotNull SearchQuery searchQuery, @NotNull SearchResults searchResults) {
                Intrinsics.checkNotNullParameter(searchQuery, "query");
                Intrinsics.checkNotNullParameter(searchResults, "results");
                return new Loading(searchQuery, searchResults);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Loading)) {
                    return false;
                }
                Loading loading = (Loading) obj;
                return Intrinsics.areEqual(getQuery(), loading.getQuery()) && Intrinsics.areEqual(getResults(), loading.getResults());
            }

            @Override // com.avito.android.messenger.search.ChannelsSearchView.State
            @NotNull
            public SearchQuery getQuery() {
                return this.a;
            }

            @Override // com.avito.android.messenger.search.ChannelsSearchView.State
            @NotNull
            public SearchResults getResults() {
                return this.b;
            }

            public int hashCode() {
                SearchQuery query = getQuery();
                int i = 0;
                int hashCode = (query != null ? query.hashCode() : 0) * 31;
                SearchResults results = getResults();
                if (results != null) {
                    i = results.hashCode();
                }
                return hashCode + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Loading(query=");
                L.append(getQuery());
                L.append(", results=");
                L.append(getResults());
                L.append(")");
                return L.toString();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchView$State$PaginationState;", "", "<init>", "()V", "Error", "Idle", "InProgress", "Lcom/avito/android/messenger/search/ChannelsSearchView$State$PaginationState$Idle;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State$PaginationState$InProgress;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State$PaginationState$Error;", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class PaginationState {

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchView$State$PaginationState$Error;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State$PaginationState;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Throwable;", "message", "error", "copy", "(Ljava/lang/String;Ljava/lang/Throwable;)Lcom/avito/android/messenger/search/ChannelsSearchView$State$PaginationState$Error;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/Throwable;", "getError", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Error extends PaginationState {
                @NotNull
                public final String a;
                @Nullable
                public final Throwable b;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Error(@NotNull String str, @Nullable Throwable th) {
                    super(null);
                    Intrinsics.checkNotNullParameter(str, "message");
                    this.a = str;
                    this.b = th;
                }

                public static /* synthetic */ Error copy$default(Error error, String str, Throwable th, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = error.a;
                    }
                    if ((i & 2) != 0) {
                        th = error.b;
                    }
                    return error.copy(str, th);
                }

                @NotNull
                public final String component1() {
                    return this.a;
                }

                @Nullable
                public final Throwable component2() {
                    return this.b;
                }

                @NotNull
                public final Error copy(@NotNull String str, @Nullable Throwable th) {
                    Intrinsics.checkNotNullParameter(str, "message");
                    return new Error(str, th);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof Error)) {
                        return false;
                    }
                    Error error = (Error) obj;
                    return Intrinsics.areEqual(this.a, error.a) && Intrinsics.areEqual(this.b, error.b);
                }

                @Nullable
                public final Throwable getError() {
                    return this.b;
                }

                @NotNull
                public final String getMessage() {
                    return this.a;
                }

                public int hashCode() {
                    String str = this.a;
                    int i = 0;
                    int hashCode = (str != null ? str.hashCode() : 0) * 31;
                    Throwable th = this.b;
                    if (th != null) {
                        i = th.hashCode();
                    }
                    return hashCode + i;
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Error(message=");
                    L.append(this.a);
                    L.append(", error=");
                    L.append(this.b);
                    L.append(")");
                    return L.toString();
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchView$State$PaginationState$Idle;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State$PaginationState;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Idle extends PaginationState {
                @NotNull
                public static final Idle INSTANCE = new Idle();

                public Idle() {
                    super(null);
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchView$State$PaginationState$InProgress;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State$PaginationState;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class InProgress extends PaginationState {
                @NotNull
                public static final InProgress INSTANCE = new InProgress();

                public InProgress() {
                    super(null);
                }
            }

            public PaginationState() {
            }

            public PaginationState(j jVar) {
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\b\b\u0018\u0000 %2\u00020\u0001:\u0001%B)\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0004¨\u0006&"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;", "", "Lcom/avito/android/messenger/search/SearchQuery;", "component1", "()Lcom/avito/android/messenger/search/SearchQuery;", "", "Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem;", "component2", "()Ljava/util/List;", "", "component3", "()Z", "query", "items", "hasMorePages", "copy", "(Lcom/avito/android/messenger/search/SearchQuery;Ljava/util/List;Z)Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getItems", "c", "Z", "getHasMorePages", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/search/SearchQuery;", "getQuery", "<init>", "(Lcom/avito/android/messenger/search/SearchQuery;Ljava/util/List;Z)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class SearchResults {
            @NotNull
            public static final Companion Companion = new Companion(null);
            @NotNull
            public static final SearchResults d = new SearchResults(SearchQuery.Companion.getEMPTY(), null, false, 6, null);
            @NotNull
            public final SearchQuery a;
            @NotNull
            public final List<ChannelsSearchListItem> b;
            public final boolean c;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults$Companion;", "", "Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;", "EMPTY", "Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;", "getEMPTY", "()Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Companion {
                public Companion() {
                }

                @NotNull
                public final SearchResults getEMPTY() {
                    return SearchResults.d;
                }

                public Companion(j jVar) {
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.messenger.search.adapter.ChannelsSearchListItem> */
            /* JADX WARN: Multi-variable type inference failed */
            public SearchResults(@NotNull SearchQuery searchQuery, @NotNull List<? extends ChannelsSearchListItem> list, boolean z) {
                Intrinsics.checkNotNullParameter(searchQuery, "query");
                Intrinsics.checkNotNullParameter(list, "items");
                this.a = searchQuery;
                this.b = list;
                this.c = z;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.messenger.search.ChannelsSearchView$State$SearchResults */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SearchResults copy$default(SearchResults searchResults, SearchQuery searchQuery, List list, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    searchQuery = searchResults.a;
                }
                if ((i & 2) != 0) {
                    list = searchResults.b;
                }
                if ((i & 4) != 0) {
                    z = searchResults.c;
                }
                return searchResults.copy(searchQuery, list, z);
            }

            @NotNull
            public final SearchQuery component1() {
                return this.a;
            }

            @NotNull
            public final List<ChannelsSearchListItem> component2() {
                return this.b;
            }

            public final boolean component3() {
                return this.c;
            }

            @NotNull
            public final SearchResults copy(@NotNull SearchQuery searchQuery, @NotNull List<? extends ChannelsSearchListItem> list, boolean z) {
                Intrinsics.checkNotNullParameter(searchQuery, "query");
                Intrinsics.checkNotNullParameter(list, "items");
                return new SearchResults(searchQuery, list, z);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof SearchResults)) {
                    return false;
                }
                SearchResults searchResults = (SearchResults) obj;
                return Intrinsics.areEqual(this.a, searchResults.a) && Intrinsics.areEqual(this.b, searchResults.b) && this.c == searchResults.c;
            }

            public final boolean getHasMorePages() {
                return this.c;
            }

            @NotNull
            public final List<ChannelsSearchListItem> getItems() {
                return this.b;
            }

            @NotNull
            public final SearchQuery getQuery() {
                return this.a;
            }

            public int hashCode() {
                SearchQuery searchQuery = this.a;
                int i = 0;
                int hashCode = (searchQuery != null ? searchQuery.hashCode() : 0) * 31;
                List<ChannelsSearchListItem> list = this.b;
                if (list != null) {
                    i = list.hashCode();
                }
                int i2 = (hashCode + i) * 31;
                boolean z = this.c;
                if (z) {
                    z = true;
                }
                int i3 = z ? 1 : 0;
                int i4 = z ? 1 : 0;
                int i5 = z ? 1 : 0;
                return i2 + i3;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("SearchResults(query=");
                L.append(this.a);
                L.append(", items=");
                L.append(this.b);
                L.append(", hasMorePages=");
                return a.B(L, this.c, ")");
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ SearchResults(SearchQuery searchQuery, List list, boolean z, int i, j jVar) {
                this(searchQuery, (i & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i & 4) != 0 ? false : z);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001c\u0010\u001b\u001a\u00020\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchView$State$ShortQuery;", "Lcom/avito/android/messenger/search/ChannelsSearchView$State;", "Lcom/avito/android/messenger/search/SearchQuery;", "component1", "()Lcom/avito/android/messenger/search/SearchQuery;", "query", "copy", "(Lcom/avito/android/messenger/search/SearchQuery;)Lcom/avito/android/messenger/search/ChannelsSearchView$State$ShortQuery;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/search/SearchQuery;", "getQuery", "Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;", "getResults", "()Lcom/avito/android/messenger/search/ChannelsSearchView$State$SearchResults;", "results", "<init>", "(Lcom/avito/android/messenger/search/SearchQuery;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class ShortQuery extends State {
            @NotNull
            public final SearchResults a = new SearchResults(getQuery(), null, false, 6, null);
            @NotNull
            public final SearchQuery b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ShortQuery(@NotNull SearchQuery searchQuery) {
                super(null);
                Intrinsics.checkNotNullParameter(searchQuery, "query");
                this.b = searchQuery;
            }

            public static /* synthetic */ ShortQuery copy$default(ShortQuery shortQuery, SearchQuery searchQuery, int i, Object obj) {
                if ((i & 1) != 0) {
                    searchQuery = shortQuery.getQuery();
                }
                return shortQuery.copy(searchQuery);
            }

            @NotNull
            public final SearchQuery component1() {
                return getQuery();
            }

            @NotNull
            public final ShortQuery copy(@NotNull SearchQuery searchQuery) {
                Intrinsics.checkNotNullParameter(searchQuery, "query");
                return new ShortQuery(searchQuery);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof ShortQuery) && Intrinsics.areEqual(getQuery(), ((ShortQuery) obj).getQuery());
                }
                return true;
            }

            @Override // com.avito.android.messenger.search.ChannelsSearchView.State
            @NotNull
            public SearchQuery getQuery() {
                return this.b;
            }

            @Override // com.avito.android.messenger.search.ChannelsSearchView.State
            @NotNull
            public SearchResults getResults() {
                return this.a;
            }

            public int hashCode() {
                SearchQuery query = getQuery();
                if (query != null) {
                    return query.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("ShortQuery(query=");
                L.append(getQuery());
                L.append(")");
                return L.toString();
            }
        }

        public State() {
        }

        @NotNull
        public abstract SearchQuery getQuery();

        @NotNull
        public abstract SearchResults getResults();

        public State(j jVar) {
        }
    }

    void clearQuery();

    void destroy();

    @NotNull
    Observable<Unit> getNextPageRequestStream();

    @NotNull
    Observable<String> getQueryChangeStream();

    @NotNull
    Observable<Unit> getRetryStream();

    @NotNull
    Observable<Unit> getSearchRequestStream();
}
