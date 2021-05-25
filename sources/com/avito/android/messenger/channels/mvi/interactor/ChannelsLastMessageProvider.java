package com.avito.android.messenger.channels.mvi.interactor;

import a2.b.a.a.a;
import arrow.core.Option;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.Observable;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fJ-\u0010\n\u001a\u00020\t2\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\u0010\u0010\b\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00070\u0006H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsLastMessageProvider;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsLastMessageProvider$State;", "", "Lcom/avito/android/messenger/channels/mvi/interactor/UserId;", ChannelContext.Item.USER_ID, "", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelId;", "channelIds", "", "requestLastMessages", "(Ljava/lang/String;Ljava/util/Set;)V", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelsLastMessageProvider extends MviEntity<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001Bk\u0012\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003\u00122\u0010\u0011\u001a.\u0012\b\u0012\u00060\u0002j\u0002`\u0007\u0012 \u0012\u001e\u0012\u001a\u0012\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\b0\u0006\u0012\"\u0010\u0012\u001a\u001e\u0012\u001a\u0012\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00060\b¢\u0006\u0004\b&\u0010'J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J<\u0010\f\u001a.\u0012\b\u0012\u00060\u0002j\u0002`\u0007\u0012 \u0012\u001e\u0012\u001a\u0012\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\b0\u0006HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ,\u0010\u000e\u001a\u001e\u0012\u001a\u0012\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00060\bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJz\u0010\u0013\u001a\u00020\u00002\f\b\u0002\u0010\u0010\u001a\u00060\u0002j\u0002`\u000324\b\u0002\u0010\u0011\u001a.\u0012\b\u0012\u00060\u0002j\u0002`\u0007\u0012 \u0012\u001e\u0012\u001a\u0012\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\b0\u00062$\b\u0002\u0010\u0012\u001a\u001e\u0012\u001a\u0012\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00060\bHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0005J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001d\u0010\u0010\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0005RE\u0010\u0011\u001a.\u0012\b\u0012\u00060\u0002j\u0002`\u0007\u0012 \u0012\u001e\u0012\u001a\u0012\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\b0\u00068\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\rR5\u0010\u0012\u001a\u001e\u0012\u001a\u0012\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00060\b8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u000f¨\u0006("}, d2 = {"Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsLastMessageProvider$State;", "", "", "Lcom/avito/android/messenger/channels/mvi/interactor/UserId;", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/messenger/channels/mvi/interactor/ChannelId;", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "Larrow/core/Option;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "component2", "()Ljava/util/Map;", "component3", "()Lio/reactivex/Observable;", ChannelContext.Item.USER_ID, "requestObservables", "lastMessagesByChannelIdStream", "copy", "(Ljava/lang/String;Ljava/util/Map;Lio/reactivex/Observable;)Lcom/avito/android/messenger/channels/mvi/interactor/ChannelsLastMessageProvider$State;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getUserId", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "getRequestObservables", "c", "Lio/reactivex/Observable;", "getLastMessagesByChannelIdStream", "<init>", "(Ljava/lang/String;Ljava/util/Map;Lio/reactivex/Observable;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class State {
        @NotNull
        public final String a;
        @NotNull
        public final Map<String, Observable<Pair<String, Option<LocalMessage>>>> b;
        @NotNull
        public final Observable<Map<String, Option<LocalMessage>>> c;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Map<java.lang.String, ? extends io.reactivex.Observable<kotlin.Pair<java.lang.String, arrow.core.Option<com.avito.android.remote.model.messenger.message.LocalMessage>>>> */
        /* JADX WARN: Multi-variable type inference failed */
        public State(@NotNull String str, @NotNull Map<String, ? extends Observable<Pair<String, Option<LocalMessage>>>> map, @NotNull Observable<Map<String, Option<LocalMessage>>> observable) {
            Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
            Intrinsics.checkNotNullParameter(map, "requestObservables");
            Intrinsics.checkNotNullParameter(observable, "lastMessagesByChannelIdStream");
            this.a = str;
            this.b = map;
            this.c = observable;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.messenger.channels.mvi.interactor.ChannelsLastMessageProvider$State */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, String str, Map map, Observable observable, int i, Object obj) {
            if ((i & 1) != 0) {
                str = state.a;
            }
            if ((i & 2) != 0) {
                map = state.b;
            }
            if ((i & 4) != 0) {
                observable = state.c;
            }
            return state.copy(str, map, observable);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final Map<String, Observable<Pair<String, Option<LocalMessage>>>> component2() {
            return this.b;
        }

        @NotNull
        public final Observable<Map<String, Option<LocalMessage>>> component3() {
            return this.c;
        }

        @NotNull
        public final State copy(@NotNull String str, @NotNull Map<String, ? extends Observable<Pair<String, Option<LocalMessage>>>> map, @NotNull Observable<Map<String, Option<LocalMessage>>> observable) {
            Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
            Intrinsics.checkNotNullParameter(map, "requestObservables");
            Intrinsics.checkNotNullParameter(observable, "lastMessagesByChannelIdStream");
            return new State(str, map, observable);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof State)) {
                return false;
            }
            State state = (State) obj;
            return Intrinsics.areEqual(this.a, state.a) && Intrinsics.areEqual(this.b, state.b) && Intrinsics.areEqual(this.c, state.c);
        }

        @NotNull
        public final Observable<Map<String, Option<LocalMessage>>> getLastMessagesByChannelIdStream() {
            return this.c;
        }

        @NotNull
        public final Map<String, Observable<Pair<String, Option<LocalMessage>>>> getRequestObservables() {
            return this.b;
        }

        @NotNull
        public final String getUserId() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Map<String, Observable<Pair<String, Option<LocalMessage>>>> map = this.b;
            int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
            Observable<Map<String, Option<LocalMessage>>> observable = this.c;
            if (observable != null) {
                i = observable.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("State(userId=");
            L.append(this.a);
            L.append(", requestObservables=");
            L.append(this.b);
            L.append(", lastMessagesByChannelIdStream=");
            L.append(this.c);
            L.append(")");
            return L.toString();
        }
    }

    void requestLastMessages(@NotNull String str, @NotNull Set<String> set);
}
