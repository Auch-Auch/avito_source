package com.avito.android.messenger.search;

import a2.b.a.a.a;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.Channel;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u000fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchInteractor;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State;", "Lcom/avito/android/messenger/search/SearchQuery;", "query", "", "startSearch", "(Lcom/avito/android/messenger/search/SearchQuery;)V", "requestNextPage", "()V", "Lio/reactivex/Observable;", "getReconnectsStream", "()Lio/reactivex/Observable;", "reconnectsStream", ScreenPublicConstsKt.SERP_SCREEN_NAME, "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelsSearchInteractor extends MviEntity<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001:\u0001\u001eB!\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchInteractor$SearchResults;", "", "", "Lcom/avito/android/messenger/search/ChannelsSearchInteractor$SearchResults$Result;", "component1", "()Ljava/util/List;", "", "component2", "()Z", "items", "hasMore", "copy", "(Ljava/util/List;Z)Lcom/avito/android/messenger/search/ChannelsSearchInteractor$SearchResults;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getItems", AuthSource.BOOKING_ORDER, "Z", "getHasMore", "<init>", "(Ljava/util/List;Z)V", "Result", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class SearchResults {
        @NotNull
        public final List<Result> a;
        public final boolean b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchInteractor$SearchResults$Result;", "", "Lcom/avito/android/remote/model/messenger/Channel;", "component1", "()Lcom/avito/android/remote/model/messenger/Channel;", "", "component2", "()Ljava/lang/String;", "channel", "messageId", "copy", "(Lcom/avito/android/remote/model/messenger/Channel;Ljava/lang/String;)Lcom/avito/android/messenger/search/ChannelsSearchInteractor$SearchResults$Result;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/messenger/Channel;", "getChannel", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getMessageId", "<init>", "(Lcom/avito/android/remote/model/messenger/Channel;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Result {
            @NotNull
            public final Channel a;
            @Nullable
            public final String b;

            public Result(@NotNull Channel channel, @Nullable String str) {
                Intrinsics.checkNotNullParameter(channel, "channel");
                this.a = channel;
                this.b = str;
            }

            public static /* synthetic */ Result copy$default(Result result, Channel channel, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = result.a;
                }
                if ((i & 2) != 0) {
                    str = result.b;
                }
                return result.copy(channel, str);
            }

            @NotNull
            public final Channel component1() {
                return this.a;
            }

            @Nullable
            public final String component2() {
                return this.b;
            }

            @NotNull
            public final Result copy(@NotNull Channel channel, @Nullable String str) {
                Intrinsics.checkNotNullParameter(channel, "channel");
                return new Result(channel, str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Result)) {
                    return false;
                }
                Result result = (Result) obj;
                return Intrinsics.areEqual(this.a, result.a) && Intrinsics.areEqual(this.b, result.b);
            }

            @NotNull
            public final Channel getChannel() {
                return this.a;
            }

            @Nullable
            public final String getMessageId() {
                return this.b;
            }

            public int hashCode() {
                Channel channel = this.a;
                int i = 0;
                int hashCode = (channel != null ? channel.hashCode() : 0) * 31;
                String str = this.b;
                if (str != null) {
                    i = str.hashCode();
                }
                return hashCode + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Result(channel=");
                L.append(this.a);
                L.append(", messageId=");
                return a.t(L, this.b, ")");
            }
        }

        public SearchResults() {
            this(null, false, 3, null);
        }

        public SearchResults(@NotNull List<Result> list, boolean z) {
            Intrinsics.checkNotNullParameter(list, "items");
            this.a = list;
            this.b = z;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.messenger.search.ChannelsSearchInteractor$SearchResults */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SearchResults copy$default(SearchResults searchResults, List list, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                list = searchResults.a;
            }
            if ((i & 2) != 0) {
                z = searchResults.b;
            }
            return searchResults.copy(list, z);
        }

        @NotNull
        public final List<Result> component1() {
            return this.a;
        }

        public final boolean component2() {
            return this.b;
        }

        @NotNull
        public final SearchResults copy(@NotNull List<Result> list, boolean z) {
            Intrinsics.checkNotNullParameter(list, "items");
            return new SearchResults(list, z);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SearchResults)) {
                return false;
            }
            SearchResults searchResults = (SearchResults) obj;
            return Intrinsics.areEqual(this.a, searchResults.a) && this.b == searchResults.b;
        }

        public final boolean getHasMore() {
            return this.b;
        }

        @NotNull
        public final List<Result> getItems() {
            return this.a;
        }

        public int hashCode() {
            List<Result> list = this.a;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            boolean z = this.b;
            if (z) {
                z = true;
            }
            int i = z ? 1 : 0;
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("SearchResults(items=");
            L.append(this.a);
            L.append(", hasMore=");
            return a.B(L, this.b, ")");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SearchResults(List list, boolean z, int i, j jVar) {
            this((i & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i & 2) != 0 ? false : z);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0010\u0011\u0012\u0013B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0001\u0003\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State;", "", "Lcom/avito/android/messenger/search/SearchQuery;", "getQuery", "()Lcom/avito/android/messenger/search/SearchQuery;", "query", "Lcom/avito/android/messenger/search/ChannelsSearchInteractor$SearchResults;", "getResults", "()Lcom/avito/android/messenger/search/ChannelsSearchInteractor$SearchResults;", "results", "", "getCurrentUserId", "()Ljava/lang/String;", "currentUserId", "<init>", "()V", "Empty", "Error", "Loaded", "PaginationState", "Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State$Empty;", "Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State$Loaded;", "Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State$Error;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ0\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001e\u001a\u00020\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u000bR\u001c\u0010\r\u001a\u00020\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\bR\u001c\u0010\f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0004¨\u0006*"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State$Error;", "Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State;", "", "toString", "()Ljava/lang/String;", "component1", "Lcom/avito/android/messenger/search/SearchQuery;", "component2", "()Lcom/avito/android/messenger/search/SearchQuery;", "", "component3", "()Ljava/lang/Throwable;", "currentUserId", "query", "error", "copy", "(Ljava/lang/String;Lcom/avito/android/messenger/search/SearchQuery;Ljava/lang/Throwable;)Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State$Error;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/messenger/search/ChannelsSearchInteractor$SearchResults;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/search/ChannelsSearchInteractor$SearchResults;", "getResults", "()Lcom/avito/android/messenger/search/ChannelsSearchInteractor$SearchResults;", "results", "d", "Ljava/lang/Throwable;", "getError", "c", "Lcom/avito/android/messenger/search/SearchQuery;", "getQuery", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getCurrentUserId", "<init>", "(Ljava/lang/String;Lcom/avito/android/messenger/search/SearchQuery;Ljava/lang/Throwable;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends State {
            @NotNull
            public final SearchResults a = new SearchResults(null, false, 3, null);
            @NotNull
            public final String b;
            @NotNull
            public final SearchQuery c;
            @Nullable
            public final Throwable d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(@NotNull String str, @NotNull SearchQuery searchQuery, @Nullable Throwable th) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "currentUserId");
                Intrinsics.checkNotNullParameter(searchQuery, "query");
                this.b = str;
                this.c = searchQuery;
                this.d = th;
            }

            public static /* synthetic */ Error copy$default(Error error, String str, SearchQuery searchQuery, Throwable th, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = error.getCurrentUserId();
                }
                if ((i & 2) != 0) {
                    searchQuery = error.getQuery();
                }
                if ((i & 4) != 0) {
                    th = error.d;
                }
                return error.copy(str, searchQuery, th);
            }

            @NotNull
            public final String component1() {
                return getCurrentUserId();
            }

            @NotNull
            public final SearchQuery component2() {
                return getQuery();
            }

            @Nullable
            public final Throwable component3() {
                return this.d;
            }

            @NotNull
            public final Error copy(@NotNull String str, @NotNull SearchQuery searchQuery, @Nullable Throwable th) {
                Intrinsics.checkNotNullParameter(str, "currentUserId");
                Intrinsics.checkNotNullParameter(searchQuery, "query");
                return new Error(str, searchQuery, th);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Error)) {
                    return false;
                }
                Error error = (Error) obj;
                return Intrinsics.areEqual(getCurrentUserId(), error.getCurrentUserId()) && Intrinsics.areEqual(getQuery(), error.getQuery()) && Intrinsics.areEqual(this.d, error.d);
            }

            @Override // com.avito.android.messenger.search.ChannelsSearchInteractor.State
            @NotNull
            public String getCurrentUserId() {
                return this.b;
            }

            @Nullable
            public final Throwable getError() {
                return this.d;
            }

            @Override // com.avito.android.messenger.search.ChannelsSearchInteractor.State
            @NotNull
            public SearchQuery getQuery() {
                return this.c;
            }

            @Override // com.avito.android.messenger.search.ChannelsSearchInteractor.State
            @NotNull
            public SearchResults getResults() {
                return this.a;
            }

            public int hashCode() {
                String currentUserId = getCurrentUserId();
                int i = 0;
                int hashCode = (currentUserId != null ? currentUserId.hashCode() : 0) * 31;
                SearchQuery query = getQuery();
                int hashCode2 = (hashCode + (query != null ? query.hashCode() : 0)) * 31;
                Throwable th = this.d;
                if (th != null) {
                    i = th.hashCode();
                }
                return hashCode2 + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Loaded.Error(query=");
                L.append(getQuery());
                L.append(", error=");
                L.append(this.d);
                L.append(')');
                return L.toString();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b)\u0010*J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ8\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0012\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u000eR\u001c\u0010\u0011\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u000bR\u001c\u0010\u0010\u001a\u00020\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\bR\u001c\u0010\u000f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0004¨\u0006+"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State$Loaded;", "Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State;", "", "toString", "()Ljava/lang/String;", "component1", "Lcom/avito/android/messenger/search/SearchQuery;", "component2", "()Lcom/avito/android/messenger/search/SearchQuery;", "Lcom/avito/android/messenger/search/ChannelsSearchInteractor$SearchResults;", "component3", "()Lcom/avito/android/messenger/search/ChannelsSearchInteractor$SearchResults;", "Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State$PaginationState;", "component4", "()Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State$PaginationState;", "currentUserId", "query", "results", "paginationState", "copy", "(Ljava/lang/String;Lcom/avito/android/messenger/search/SearchQuery;Lcom/avito/android/messenger/search/ChannelsSearchInteractor$SearchResults;Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State$PaginationState;)Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State$Loaded;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "d", "Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State$PaginationState;", "getPaginationState", "c", "Lcom/avito/android/messenger/search/ChannelsSearchInteractor$SearchResults;", "getResults", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/search/SearchQuery;", "getQuery", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getCurrentUserId", "<init>", "(Ljava/lang/String;Lcom/avito/android/messenger/search/SearchQuery;Lcom/avito/android/messenger/search/ChannelsSearchInteractor$SearchResults;Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State$PaginationState;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loaded extends State {
            @NotNull
            public final String a;
            @NotNull
            public final SearchQuery b;
            @NotNull
            public final SearchResults c;
            @NotNull
            public final PaginationState d;

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Loaded(String str, SearchQuery searchQuery, SearchResults searchResults, PaginationState paginationState, int i, j jVar) {
                this(str, searchQuery, searchResults, (i & 8) != 0 ? PaginationState.Idle.INSTANCE : paginationState);
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, String str, SearchQuery searchQuery, SearchResults searchResults, PaginationState paginationState, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = loaded.getCurrentUserId();
                }
                if ((i & 2) != 0) {
                    searchQuery = loaded.getQuery();
                }
                if ((i & 4) != 0) {
                    searchResults = loaded.getResults();
                }
                if ((i & 8) != 0) {
                    paginationState = loaded.d;
                }
                return loaded.copy(str, searchQuery, searchResults, paginationState);
            }

            @NotNull
            public final String component1() {
                return getCurrentUserId();
            }

            @NotNull
            public final SearchQuery component2() {
                return getQuery();
            }

            @NotNull
            public final SearchResults component3() {
                return getResults();
            }

            @NotNull
            public final PaginationState component4() {
                return this.d;
            }

            @NotNull
            public final Loaded copy(@NotNull String str, @NotNull SearchQuery searchQuery, @NotNull SearchResults searchResults, @NotNull PaginationState paginationState) {
                Intrinsics.checkNotNullParameter(str, "currentUserId");
                Intrinsics.checkNotNullParameter(searchQuery, "query");
                Intrinsics.checkNotNullParameter(searchResults, "results");
                Intrinsics.checkNotNullParameter(paginationState, "paginationState");
                return new Loaded(str, searchQuery, searchResults, paginationState);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) obj;
                return Intrinsics.areEqual(getCurrentUserId(), loaded.getCurrentUserId()) && Intrinsics.areEqual(getQuery(), loaded.getQuery()) && Intrinsics.areEqual(getResults(), loaded.getResults()) && Intrinsics.areEqual(this.d, loaded.d);
            }

            @Override // com.avito.android.messenger.search.ChannelsSearchInteractor.State
            @NotNull
            public String getCurrentUserId() {
                return this.a;
            }

            @NotNull
            public final PaginationState getPaginationState() {
                return this.d;
            }

            @Override // com.avito.android.messenger.search.ChannelsSearchInteractor.State
            @NotNull
            public SearchQuery getQuery() {
                return this.b;
            }

            @Override // com.avito.android.messenger.search.ChannelsSearchInteractor.State
            @NotNull
            public SearchResults getResults() {
                return this.c;
            }

            public int hashCode() {
                String currentUserId = getCurrentUserId();
                int i = 0;
                int hashCode = (currentUserId != null ? currentUserId.hashCode() : 0) * 31;
                SearchQuery query = getQuery();
                int hashCode2 = (hashCode + (query != null ? query.hashCode() : 0)) * 31;
                SearchResults results = getResults();
                int hashCode3 = (hashCode2 + (results != null ? results.hashCode() : 0)) * 31;
                PaginationState paginationState = this.d;
                if (paginationState != null) {
                    i = paginationState.hashCode();
                }
                return hashCode3 + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Loaded.Results(query=");
                L.append(getQuery());
                L.append(", paginationState=");
                L.append(this.d);
                L.append(", results=");
                L.append(getResults());
                L.append(')');
                return L.toString();
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Loaded(@NotNull String str, @NotNull SearchQuery searchQuery, @NotNull SearchResults searchResults, @NotNull PaginationState paginationState) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "currentUserId");
                Intrinsics.checkNotNullParameter(searchQuery, "query");
                Intrinsics.checkNotNullParameter(searchResults, "results");
                Intrinsics.checkNotNullParameter(paginationState, "paginationState");
                this.a = str;
                this.b = searchQuery;
                this.c = searchResults;
                this.d = paginationState;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State$PaginationState;", "", "<init>", "()V", "Error", "Idle", "Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State$PaginationState$Idle;", "Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State$PaginationState$Error;", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class PaginationState {

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State$PaginationState$Error;", "Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State$PaginationState;", "", "toString", "()Ljava/lang/String;", "", "component1", "()Ljava/lang/Throwable;", "error", "copy", "(Ljava/lang/Throwable;)Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State$PaginationState$Error;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/Throwable;", "getError", "<init>", "(Ljava/lang/Throwable;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Error extends PaginationState {
                @Nullable
                public final Throwable a;

                public Error(@Nullable Throwable th) {
                    super(null);
                    this.a = th;
                }

                public static /* synthetic */ Error copy$default(Error error, Throwable th, int i, Object obj) {
                    if ((i & 1) != 0) {
                        th = error.a;
                    }
                    return error.copy(th);
                }

                @Nullable
                public final Throwable component1() {
                    return this.a;
                }

                @NotNull
                public final Error copy(@Nullable Throwable th) {
                    return new Error(th);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this != obj) {
                        return (obj instanceof Error) && Intrinsics.areEqual(this.a, ((Error) obj).a);
                    }
                    return true;
                }

                @Nullable
                public final Throwable getError() {
                    return this.a;
                }

                public int hashCode() {
                    Throwable th = this.a;
                    if (th != null) {
                        return th.hashCode();
                    }
                    return 0;
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Error(error = ");
                    L.append(this.a);
                    L.append(')');
                    return L.toString();
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State$PaginationState$Idle;", "Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State$PaginationState;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Idle extends PaginationState {
                @NotNull
                public static final Idle INSTANCE = new Idle();

                public Idle() {
                    super(null);
                }

                @NotNull
                public String toString() {
                    return "Idle";
                }
            }

            public PaginationState() {
            }

            public PaginationState(j jVar) {
            }
        }

        public State() {
        }

        @NotNull
        public abstract String getCurrentUserId();

        @NotNull
        public abstract SearchQuery getQuery();

        @NotNull
        public abstract SearchResults getResults();

        public State(j jVar) {
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0016\u001a\u00020\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001c\u001a\u00020\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0006\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004¨\u0006\""}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State$Empty;", "Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State;", "", "toString", "()Ljava/lang/String;", "component1", "currentUserId", "copy", "(Ljava/lang/String;)Lcom/avito/android/messenger/search/ChannelsSearchInteractor$State$Empty;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/messenger/search/ChannelsSearchInteractor$SearchResults;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/search/ChannelsSearchInteractor$SearchResults;", "getResults", "()Lcom/avito/android/messenger/search/ChannelsSearchInteractor$SearchResults;", "results", "Lcom/avito/android/messenger/search/SearchQuery;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/search/SearchQuery;", "getQuery", "()Lcom/avito/android/messenger/search/SearchQuery;", "query", "c", "Ljava/lang/String;", "getCurrentUserId", "<init>", "(Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends State {
            @NotNull
            public final SearchQuery a;
            @NotNull
            public final SearchResults b;
            @NotNull
            public final String c;

            public Empty() {
                this(null, 1, null);
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Empty(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "currentUserId");
                this.c = str;
                this.a = new SearchQuery(0, null, 3, null);
                this.b = new SearchResults(null, false, 3, null);
            }

            public static /* synthetic */ Empty copy$default(Empty empty, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = empty.getCurrentUserId();
                }
                return empty.copy(str);
            }

            @NotNull
            public final String component1() {
                return getCurrentUserId();
            }

            @NotNull
            public final Empty copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "currentUserId");
                return new Empty(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Empty) && Intrinsics.areEqual(getCurrentUserId(), ((Empty) obj).getCurrentUserId());
                }
                return true;
            }

            @Override // com.avito.android.messenger.search.ChannelsSearchInteractor.State
            @NotNull
            public String getCurrentUserId() {
                return this.c;
            }

            @Override // com.avito.android.messenger.search.ChannelsSearchInteractor.State
            @NotNull
            public SearchQuery getQuery() {
                return this.a;
            }

            @Override // com.avito.android.messenger.search.ChannelsSearchInteractor.State
            @NotNull
            public SearchResults getResults() {
                return this.b;
            }

            public int hashCode() {
                String currentUserId = getCurrentUserId();
                if (currentUserId != null) {
                    return currentUserId.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Empty(currentUserId=");
                L.append(getCurrentUserId());
                L.append(')');
                return L.toString();
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Empty(String str, int i, j jVar) {
                this((i & 1) != 0 ? "" : str);
            }
        }
    }

    @NotNull
    Observable<Unit> getReconnectsStream();

    void requestNextPage();

    void startSearch(@NotNull SearchQuery searchQuery);
}
