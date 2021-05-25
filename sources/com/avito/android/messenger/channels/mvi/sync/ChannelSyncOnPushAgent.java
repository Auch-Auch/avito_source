package com.avito.android.messenger.channels.mvi.sync;

import a2.b.a.a.a;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.y;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgent;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgent$State;", "", "channelId", "", "sync", "(Ljava/lang/String;)V", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelSyncOnPushAgent extends MviEntity<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u0000 !2\u00020\u0001:\u0001!B\u001d\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010 J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005R\u0014\u0010\u001b\u001a\u00020\u00138Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\b¨\u0006\""}, d2 = {"Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgent$State;", "", "", "", "component1", "()Ljava/util/Set;", "", "component2", "()J", "downloadedChannelIds", "unprocessedRequestsCount", "copy", "(Ljava/util/Set;J)Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgent$State;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/util/Set;", "getDownloadedChannelIds", "getHasUnprocessedRequests", "()Z", "hasUnprocessedRequests", AuthSource.BOOKING_ORDER, "J", "getUnprocessedRequestsCount", "<init>", "(Ljava/util/Set;J)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class State {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final State c = new State(y.emptySet(), 0);
        @NotNull
        public final Set<String> a;
        public final long b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgent$State$Companion;", "", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgent$State;", MessengerShareContentUtility.PREVIEW_DEFAULT, "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgent$State;", "getDEFAULT", "()Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncOnPushAgent$State;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
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

        public State(@NotNull Set<String> set, long j) {
            Intrinsics.checkNotNullParameter(set, "downloadedChannelIds");
            this.a = set;
            this.b = j;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.messenger.channels.mvi.sync.ChannelSyncOnPushAgent$State */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, Set set, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                set = state.a;
            }
            if ((i & 2) != 0) {
                j = state.b;
            }
            return state.copy(set, j);
        }

        @NotNull
        public final Set<String> component1() {
            return this.a;
        }

        public final long component2() {
            return this.b;
        }

        @NotNull
        public final State copy(@NotNull Set<String> set, long j) {
            Intrinsics.checkNotNullParameter(set, "downloadedChannelIds");
            return new State(set, j);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof State)) {
                return false;
            }
            State state = (State) obj;
            return Intrinsics.areEqual(this.a, state.a) && this.b == state.b;
        }

        @NotNull
        public final Set<String> getDownloadedChannelIds() {
            return this.a;
        }

        public final boolean getHasUnprocessedRequests() {
            return getUnprocessedRequestsCount() > 0;
        }

        public final long getUnprocessedRequestsCount() {
            return this.b;
        }

        public int hashCode() {
            Set<String> set = this.a;
            return ((set != null ? set.hashCode() : 0) * 31) + c.a(this.b);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("State(downloadedChannelIds=");
            L.append(this.a);
            L.append(", unprocessedRequestsCount=");
            return a.l(L, this.b, ")");
        }
    }

    void sync(@NotNull String str);
}
