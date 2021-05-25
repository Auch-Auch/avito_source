package com.avito.android.messenger.blacklist.mvi;

import a2.b.a.a.a;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.facebook.share.internal.MessengerShareContentUtility;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.entity.BlockedUser;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H&¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;", "", "initialDataRequest", "()V", "refresh", "requestNextPage", "", ChannelContext.Item.USER_ID, "unblockUser", "(Ljava/lang/String;)V", "Lio/reactivex/Observable;", "", "getErrorStream", "()Lio/reactivex/Observable;", "errorStream", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface BlacklistInteractor extends MviEntity<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u001a\b\b\u0018\u0000 52\u00020\u0001:\u000256BI\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0004\b3\u00104J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J^\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eHÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010!\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0004R\u0019\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\rR\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\nR\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010$\u001a\u0004\b-\u0010\u0004R%\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\u0012R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010$\u001a\u0004\b2\u0010\u0004¨\u00067"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;", "", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State$Loading;", "component1", "()Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State$Loading;", "component2", "component3", "", "Lru/avito/messenger/api/entity/BlockedUser;", "component4", "()Ljava/util/List;", "", "component5", "()Z", "", "", "", "component6", "()Ljava/util/Map;", "initialLoadingState", "refreshState", "nextPageLoadingState", "blockedUsers", "hasMoreItems", "unblockingUsers", "copy", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State$Loading;Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State$Loading;Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State$Loading;Ljava/util/List;ZLjava/util/Map;)Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "c", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State$Loading;", "getNextPageLoadingState", "e", "Z", "getHasMoreItems", "d", "Ljava/util/List;", "getBlockedUsers", AuthSource.BOOKING_ORDER, "getRefreshState", "f", "Ljava/util/Map;", "getUnblockingUsers", AuthSource.SEND_ABUSE, "getInitialLoadingState", "<init>", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State$Loading;Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State$Loading;Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State$Loading;Ljava/util/List;ZLjava/util/Map;)V", "Companion", "Loading", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class State {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final State g;
        @NotNull
        public final Loading a;
        @NotNull
        public final Loading b;
        @NotNull
        public final Loading c;
        @NotNull
        public final List<BlockedUser> d;
        public final boolean e;
        @NotNull
        public final Map<String, Long> f;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State$Companion;", "", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;", MessengerShareContentUtility.PREVIEW_DEFAULT, "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;", "getDEFAULT", "()Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            @NotNull
            public final State getDEFAULT() {
                return State.g;
            }

            public Companion(j jVar) {
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State$Loading;", "", "<init>", "()V", "Error", "Finished", "InProgress", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State$Loading$Error;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State$Loading$InProgress;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State$Loading$Finished;", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class Loading {

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State$Loading$Error;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State$Loading;", "", "toString", "()Ljava/lang/String;", "", AuthSource.SEND_ABUSE, "Ljava/lang/Throwable;", "getThrowable", "()Ljava/lang/Throwable;", "throwable", "<init>", "(Ljava/lang/Throwable;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Error extends Loading {
                @NotNull
                public final Throwable a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Error(@NotNull Throwable th) {
                    super(null);
                    Intrinsics.checkNotNullParameter(th, "throwable");
                    this.a = th;
                }

                @NotNull
                public final Throwable getThrowable() {
                    return this.a;
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Loading.Error(");
                    L.append(this.a);
                    L.append(')');
                    return L.toString();
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State$Loading$Finished;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State$Loading;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Finished extends Loading {
                @NotNull
                public static final Finished INSTANCE = new Finished();

                public Finished() {
                    super(null);
                }

                @NotNull
                public String toString() {
                    return "Loading.Finished";
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State$Loading$InProgress;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor$State$Loading;", "", "toString", "()Ljava/lang/String;", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "<init>", "(J)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class InProgress extends Loading {
                public final long a;

                public InProgress(long j) {
                    super(null);
                    this.a = j;
                }

                public final long getId() {
                    return this.a;
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Loading.InProgress#");
                    L.append(this.a);
                    return L.toString();
                }
            }

            public Loading() {
            }

            public Loading(j jVar) {
            }
        }

        static {
            Loading.InProgress inProgress = new Loading.InProgress(-1);
            Loading.Finished finished = Loading.Finished.INSTANCE;
            g = new State(inProgress, finished, finished, CollectionsKt__CollectionsKt.emptyList(), false, r.emptyMap());
        }

        public State(@NotNull Loading loading, @NotNull Loading loading2, @NotNull Loading loading3, @NotNull List<BlockedUser> list, boolean z, @NotNull Map<String, Long> map) {
            Intrinsics.checkNotNullParameter(loading, "initialLoadingState");
            Intrinsics.checkNotNullParameter(loading2, "refreshState");
            Intrinsics.checkNotNullParameter(loading3, "nextPageLoadingState");
            Intrinsics.checkNotNullParameter(list, "blockedUsers");
            Intrinsics.checkNotNullParameter(map, "unblockingUsers");
            this.a = loading;
            this.b = loading2;
            this.c = loading3;
            this.d = list;
            this.e = z;
            this.f = map;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.avito.android.messenger.blacklist.mvi.BlacklistInteractor$State */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, Loading loading, Loading loading2, Loading loading3, List list, boolean z, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                loading = state.a;
            }
            if ((i & 2) != 0) {
                loading2 = state.b;
            }
            if ((i & 4) != 0) {
                loading3 = state.c;
            }
            if ((i & 8) != 0) {
                list = state.d;
            }
            if ((i & 16) != 0) {
                z = state.e;
            }
            if ((i & 32) != 0) {
                map = state.f;
            }
            return state.copy(loading, loading2, loading3, list, z, map);
        }

        @NotNull
        public final Loading component1() {
            return this.a;
        }

        @NotNull
        public final Loading component2() {
            return this.b;
        }

        @NotNull
        public final Loading component3() {
            return this.c;
        }

        @NotNull
        public final List<BlockedUser> component4() {
            return this.d;
        }

        public final boolean component5() {
            return this.e;
        }

        @NotNull
        public final Map<String, Long> component6() {
            return this.f;
        }

        @NotNull
        public final State copy(@NotNull Loading loading, @NotNull Loading loading2, @NotNull Loading loading3, @NotNull List<BlockedUser> list, boolean z, @NotNull Map<String, Long> map) {
            Intrinsics.checkNotNullParameter(loading, "initialLoadingState");
            Intrinsics.checkNotNullParameter(loading2, "refreshState");
            Intrinsics.checkNotNullParameter(loading3, "nextPageLoadingState");
            Intrinsics.checkNotNullParameter(list, "blockedUsers");
            Intrinsics.checkNotNullParameter(map, "unblockingUsers");
            return new State(loading, loading2, loading3, list, z, map);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof State)) {
                return false;
            }
            State state = (State) obj;
            return Intrinsics.areEqual(this.a, state.a) && Intrinsics.areEqual(this.b, state.b) && Intrinsics.areEqual(this.c, state.c) && Intrinsics.areEqual(this.d, state.d) && this.e == state.e && Intrinsics.areEqual(this.f, state.f);
        }

        @NotNull
        public final List<BlockedUser> getBlockedUsers() {
            return this.d;
        }

        public final boolean getHasMoreItems() {
            return this.e;
        }

        @NotNull
        public final Loading getInitialLoadingState() {
            return this.a;
        }

        @NotNull
        public final Loading getNextPageLoadingState() {
            return this.c;
        }

        @NotNull
        public final Loading getRefreshState() {
            return this.b;
        }

        @NotNull
        public final Map<String, Long> getUnblockingUsers() {
            return this.f;
        }

        public int hashCode() {
            Loading loading = this.a;
            int i = 0;
            int hashCode = (loading != null ? loading.hashCode() : 0) * 31;
            Loading loading2 = this.b;
            int hashCode2 = (hashCode + (loading2 != null ? loading2.hashCode() : 0)) * 31;
            Loading loading3 = this.c;
            int hashCode3 = (hashCode2 + (loading3 != null ? loading3.hashCode() : 0)) * 31;
            List<BlockedUser> list = this.d;
            int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
            boolean z = this.e;
            if (z) {
                z = true;
            }
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = (hashCode4 + i2) * 31;
            Map<String, Long> map = this.f;
            if (map != null) {
                i = map.hashCode();
            }
            return i5 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("State(initialLoadingState=");
            L.append(this.a);
            L.append(", refreshState=");
            L.append(this.b);
            L.append(", nextPageLoadingState=");
            L.append(this.c);
            L.append(", blockedUsers=");
            L.append(this.d);
            L.append(", hasMoreItems=");
            L.append(this.e);
            L.append(", unblockingUsers=");
            return a.x(L, this.f, ")");
        }
    }

    @NotNull
    Observable<Throwable> getErrorStream();

    void initialDataRequest();

    void refresh();

    void requestNextPage();

    void unblockUser(@NotNull String str);
}
