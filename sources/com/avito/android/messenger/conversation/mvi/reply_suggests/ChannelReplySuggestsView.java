package com.avito.android.messenger.conversation.mvi.reply_suggests;

import com.avito.android.messenger.channels.mvi.common.v2.Renderer;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsView;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;", "Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsView$State;", "Lio/reactivex/Observable;", "", "getCloseButtonClickedObservable", "()Lio/reactivex/Observable;", "closeButtonClickedObservable", "", "getReplySuggestClickedObservable", "replySuggestClickedObservable", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelReplySuggestsView extends Renderer<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void render(@NotNull ChannelReplySuggestsView channelReplySuggestsView, @NotNull State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            Renderer.DefaultImpls.render(channelReplySuggestsView, state);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0012\u0013\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u0001\u0003\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsView$State;", "", "", "toString", "()Ljava/lang/String;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getSuggests", "()Ljava/util/List;", "suggests", "Closed", "Empty", "Visible", "Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsView$State$Empty;", "Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsView$State$Visible;", "Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsView$State$Closed;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {
        @NotNull
        public final List<String> a;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsView$State$Closed;", "Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsView$State;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Closed extends State {
            @NotNull
            public static final Closed INSTANCE = new Closed();

            public Closed() {
                super(CollectionsKt__CollectionsKt.emptyList(), null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsView$State$Empty;", "Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsView$State;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends State {
            @NotNull
            public static final Empty INSTANCE = new Empty();

            public Empty() {
                super(CollectionsKt__CollectionsKt.emptyList(), null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsView$State$Visible;", "Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsView$State;", "", "", "suggests", "<init>", "(Ljava/util/List;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Visible extends State {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Visible(@NotNull List<String> list) {
                super(list, null);
                Intrinsics.checkNotNullParameter(list, "suggests");
            }
        }

        public State(List list, j jVar) {
            this.a = list;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof State)) {
                return false;
            }
            State state = (State) obj;
            return !(Intrinsics.areEqual(getClass(), state.getClass()) ^ true) && !(Intrinsics.areEqual(this.a, state.a) ^ true);
        }

        @NotNull
        public final List<String> getSuggests() {
            return this.a;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        @NotNull
        public String toString() {
            return getClass().getSimpleName() + "(suggests=" + this.a + ')';
        }
    }

    @NotNull
    Observable<Unit> getCloseButtonClickedObservable();

    @NotNull
    Observable<String> getReplySuggestClickedObservable();
}
