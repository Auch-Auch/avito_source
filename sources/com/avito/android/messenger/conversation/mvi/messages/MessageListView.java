package com.avito.android.messenger.conversation.mvi.messages;

import a2.b.a.a.a;
import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.messenger.channels.mvi.common.v2.RendererWithDiff;
import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.context.ChatReplyTime;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0003H&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH&¢\u0006\u0004\b\u000e\u0010\nR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView;", "Lcom/avito/android/messenger/channels/mvi/common/v2/RendererWithDiff;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$State;", "", "padding", "", "setExtraPaddingBottom", "(I)Z", "", "scrollToBottom", "()V", VKApiConst.POSITION, "scrollTo", "(I)V", "destroy", "Lio/reactivex/Observable;", "getUserInteractedWithListStream", "()Lio/reactivex/Observable;", "userInteractedWithListStream", "getStartPaginationStream", "startPaginationStream", "getScrolledToBottomStream", "scrolledToBottomStream", "getRefreshClicksStream", "refreshClicksStream", "getCallUserClicksStream", "callUserClicksStream", "getInitialScrollStream", "initialScrollStream", "ListState", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessageListView extends RendererWithDiff<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void render(@NotNull MessageListView messageListView, @NotNull State state, @Nullable DiffUtil.DiffResult diffResult) {
            Intrinsics.checkNotNullParameter(state, "state");
            RendererWithDiff.DefaultImpls.render(messageListView, state, diffResult);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\t\n\u000b\fR\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u0001\u0004\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$ListState;", "", "", "Lcom/avito/android/messenger/conversation/ChannelItem;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getItems", "()Ljava/util/List;", "items", "Empty", "Error", "Loaded", "LoadingInProgress", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$ListState$Empty;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$ListState$LoadingInProgress;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$ListState$Loaded;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$ListState$Error;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ListState {
        @NotNull
        public final List<ChannelItem> a;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$ListState$Empty;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$ListState;", "<init>", "()V", "NoReplyTime", "WithReplyTime", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$ListState$Empty$NoReplyTime;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$ListState$Empty$WithReplyTime;", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class Empty extends ListState {

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$ListState$Empty$NoReplyTime;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$ListState$Empty;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class NoReplyTime extends Empty {
                @NotNull
                public static final NoReplyTime INSTANCE = new NoReplyTime();

                public NoReplyTime() {
                    super(null);
                }

                @NotNull
                public String toString() {
                    return "ListState.Empty.NoReplyTime";
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$ListState$Empty$WithReplyTime;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$ListState$Empty;", "", "toString", "()Ljava/lang/String;", "", "c", "Z", "getCanCall", "()Z", "canCall", "Lcom/avito/android/remote/model/messenger/context/ChatReplyTime;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/messenger/context/ChatReplyTime;", "getReplyTime", "()Lcom/avito/android/remote/model/messenger/context/ChatReplyTime;", ChannelContext.Item.REPLY_TIME, "<init>", "(Lcom/avito/android/remote/model/messenger/context/ChatReplyTime;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class WithReplyTime extends Empty {
                @NotNull
                public final ChatReplyTime b;
                public final boolean c;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public WithReplyTime(@NotNull ChatReplyTime chatReplyTime, boolean z) {
                    super(null);
                    Intrinsics.checkNotNullParameter(chatReplyTime, ChannelContext.Item.REPLY_TIME);
                    this.b = chatReplyTime;
                    this.c = z;
                }

                public final boolean getCanCall() {
                    return this.c;
                }

                @NotNull
                public final ChatReplyTime getReplyTime() {
                    return this.b;
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("ListState.Empty.WithReplyTime(replyTime = ");
                    L.append(this.b);
                    L.append(", canCall = ");
                    return a.A(L, this.c, ')');
                }
            }

            public Empty() {
                super(CollectionsKt__CollectionsKt.emptyList(), null);
            }

            public Empty(j jVar) {
                super(CollectionsKt__CollectionsKt.emptyList(), null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$ListState$Error;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$ListState;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends ListState {
            @NotNull
            public static final Error INSTANCE = new Error();

            public Error() {
                super(CollectionsKt__CollectionsKt.emptyList(), null);
            }

            @NotNull
            public String toString() {
                return "ListState.Error";
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$ListState$Loaded;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$ListState;", "", "toString", "()Ljava/lang/String;", "", AuthSource.BOOKING_ORDER, "I", "getInitialScrollPosition", "()I", "initialScrollPosition", "", "c", "Z", "getUserInteractedWithList", "()Z", "userInteractedWithList", "", "Lcom/avito/android/messenger/conversation/ChannelItem;", "items", "<init>", "(Ljava/util/List;IZ)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loaded extends ListState {
            public final int b;
            public final boolean c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Loaded(@NotNull List<? extends ChannelItem> list, int i, boolean z) {
                super(list, null);
                Intrinsics.checkNotNullParameter(list, "items");
                this.b = i;
                this.c = z;
            }

            public final int getInitialScrollPosition() {
                return this.b;
            }

            public final boolean getUserInteractedWithList() {
                return this.c;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("ListState.Loaded(items=(");
                L.append(getItems().size());
                L.append(")[add logging to see contents]");
                return L.toString();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$ListState$LoadingInProgress;", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$ListState;", "", "toString", "()Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class LoadingInProgress extends ListState {
            @NotNull
            public static final LoadingInProgress INSTANCE = new LoadingInProgress();

            public LoadingInProgress() {
                super(CollectionsKt__CollectionsKt.emptyList(), null);
            }

            @NotNull
            public String toString() {
                return "ListState.LoadingInProgress";
            }
        }

        public ListState(List list, j jVar) {
            this.a = list;
        }

        @NotNull
        public final List<ChannelItem> getItems() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nR\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$State;", "", "", "getPaginationIsEnabled", "()Z", "paginationIsEnabled", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$ListState;", "getListState", "()Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$ListState;", "listState", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public interface State {
        @NotNull
        public static final Companion Companion = Companion.b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$State$Companion;", "", "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$State;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$State;", "getDEFAULT", "()Lcom/avito/android/messenger/conversation/mvi/messages/MessageListView$State;", MessengerShareContentUtility.PREVIEW_DEFAULT, "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            @NotNull
            public static final State a = new MessageListView$State$Companion$DEFAULT$1();
            public static final /* synthetic */ Companion b = new Companion();

            @NotNull
            public final State getDEFAULT() {
                return a;
            }
        }

        @NotNull
        ListState getListState();

        boolean getPaginationIsEnabled();
    }

    void destroy();

    @NotNull
    Observable<Unit> getCallUserClicksStream();

    @NotNull
    Observable<Unit> getInitialScrollStream();

    @NotNull
    Observable<Unit> getRefreshClicksStream();

    @NotNull
    Observable<Boolean> getScrolledToBottomStream();

    @NotNull
    Observable<Unit> getStartPaginationStream();

    @NotNull
    Observable<Unit> getUserInteractedWithListStream();

    void scrollTo(int i);

    void scrollToBottom();

    boolean setExtraPaddingBottom(int i);
}
