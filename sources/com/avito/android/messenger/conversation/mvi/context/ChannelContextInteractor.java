package com.avito.android.messenger.conversation.mvi.context;

import a2.b.a.a.a;
import com.avito.android.messenger.channels.mvi.common.Loading;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.Channel;
import com.facebook.share.internal.MessengerShareContentUtility;
import io.reactivex.Observable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.y;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u000fJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", "Lcom/avito/android/messenger/conversation/mvi/context/OpenAdvertHandler;", "", "isRetry", "", "initialDataRequest", "(Z)V", "refresh", "()V", "Lio/reactivex/Observable;", "getLoggedOutStream", "()Lio/reactivex/Observable;", "loggedOutStream", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelContextInteractor extends MviEntity<State>, OpenAdvertHandler {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0014\b\b\u0018\u0000 )2\u00020\u0001:\u0001)B3\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJD\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001a\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\bR\u0019\u0010\u0012\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\u0012\u0010\u000eR\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u000b¨\u0006*"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", "", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/messenger/channels/mvi/common/Loading;", "Lcom/avito/android/remote/model/messenger/Channel;", "component2", "()Lcom/avito/android/messenger/channels/mvi/common/Loading;", "", "component3", "()Ljava/util/Set;", "", "component4", "()Z", "currentUserId", "channelState", "typingUserIds", "isConnecting", "copy", "(Ljava/lang/String;Lcom/avito/android/messenger/channels/mvi/common/Loading;Ljava/util/Set;Z)Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getCurrentUserId", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/channels/mvi/common/Loading;", "getChannelState", "d", "Z", "c", "Ljava/util/Set;", "getTypingUserIds", "<init>", "(Ljava/lang/String;Lcom/avito/android/messenger/channels/mvi/common/Loading;Ljava/util/Set;Z)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class State {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final State e = new State("", new Loading.Empty(), y.emptySet(), false);
        @NotNull
        public final String a;
        @NotNull
        public final Loading<Channel> b;
        @NotNull
        public final Set<String> c;
        public final boolean d;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State$Companion;", "", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", MessengerShareContentUtility.PREVIEW_DEFAULT, "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", "getDEFAULT", "()Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            @NotNull
            public final State getDEFAULT() {
                return State.e;
            }

            public Companion(j jVar) {
            }
        }

        public State(@NotNull String str, @NotNull Loading<Channel> loading, @NotNull Set<String> set, boolean z) {
            Intrinsics.checkNotNullParameter(str, "currentUserId");
            Intrinsics.checkNotNullParameter(loading, "channelState");
            Intrinsics.checkNotNullParameter(set, "typingUserIds");
            this.a = str;
            this.b = loading;
            this.c = set;
            this.d = z;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor$State */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, String str, Loading loading, Set set, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = state.a;
            }
            if ((i & 2) != 0) {
                loading = state.b;
            }
            if ((i & 4) != 0) {
                set = state.c;
            }
            if ((i & 8) != 0) {
                z = state.d;
            }
            return state.copy(str, loading, set, z);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final Loading<Channel> component2() {
            return this.b;
        }

        @NotNull
        public final Set<String> component3() {
            return this.c;
        }

        public final boolean component4() {
            return this.d;
        }

        @NotNull
        public final State copy(@NotNull String str, @NotNull Loading<Channel> loading, @NotNull Set<String> set, boolean z) {
            Intrinsics.checkNotNullParameter(str, "currentUserId");
            Intrinsics.checkNotNullParameter(loading, "channelState");
            Intrinsics.checkNotNullParameter(set, "typingUserIds");
            return new State(str, loading, set, z);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof State)) {
                return false;
            }
            State state = (State) obj;
            return Intrinsics.areEqual(this.a, state.a) && Intrinsics.areEqual(this.b, state.b) && Intrinsics.areEqual(this.c, state.c) && this.d == state.d;
        }

        @NotNull
        public final Loading<Channel> getChannelState() {
            return this.b;
        }

        @NotNull
        public final String getCurrentUserId() {
            return this.a;
        }

        @NotNull
        public final Set<String> getTypingUserIds() {
            return this.c;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Loading<Channel> loading = this.b;
            int hashCode2 = (hashCode + (loading != null ? loading.hashCode() : 0)) * 31;
            Set<String> set = this.c;
            if (set != null) {
                i = set.hashCode();
            }
            int i2 = (hashCode2 + i) * 31;
            boolean z = this.d;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            return i2 + i3;
        }

        public final boolean isConnecting() {
            return this.d;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("State(currentUserId=");
            L.append(this.a);
            L.append(", channelState=");
            L.append(this.b);
            L.append(", typingUserIds=");
            L.append(this.c);
            L.append(", isConnecting=");
            return a.B(L, this.d, ")");
        }
    }

    @NotNull
    Observable<Unit> getLoggedOutStream();

    void initialDataRequest(boolean z);

    void refresh();
}
