package com.avito.android.messenger.conversation.mvi.new_messages;

import a2.b.a.a.a;
import com.avito.android.messenger.channels.mvi.common.v2.Renderer;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;", "Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State;", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface NewMessagesView extends Renderer<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void render(@NotNull NewMessagesView newMessagesView, @NotNull State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            Renderer.DefaultImpls.render(newMessagesView, state);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0015\u0016B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00028Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0004R\u0016\u0010\u0012\u001a\u00020\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0001\u0002\u0017\u0018¨\u0006\u0019"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State;", "", "", "getInitialScrollPerformed", "()Z", "initialScrollPerformed", "", "getUnreadMessageCountString", "()Ljava/lang/String;", "unreadMessageCountString", "getUserId", ChannelContext.Item.USER_ID, "isScrolledToBottom", "()Ljava/lang/Boolean;", "isShown", "", "getUnreadMessageCount", "()I", "unreadMessageCount", "<init>", "()V", "Empty", "Loaded", "Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State$Empty;", "Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State$Loaded;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ:\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0014\u0010\fJ\u001a\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\r\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u000e\u0010\u0007R\u001c\u0010\u000f\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\tR\u001c\u0010\u0010\u001a\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\f¨\u0006&"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State$Loaded;", "Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Boolean;", "component3", "()Z", "", "component4", "()I", ChannelContext.Item.USER_ID, "isScrolledToBottom", "initialScrollPerformed", "unreadMessageCount", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;ZI)Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State$Loaded;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getUserId", AuthSource.BOOKING_ORDER, "Ljava/lang/Boolean;", "c", "Z", "getInitialScrollPerformed", "d", "I", "getUnreadMessageCount", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;ZI)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loaded extends State {
            @NotNull
            public final String a;
            @Nullable
            public final Boolean b;
            public final boolean c;
            public final int d;

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Loaded(String str, Boolean bool, boolean z, int i, int i2, j jVar) {
                this(str, bool, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? 0 : i);
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, String str, Boolean bool, boolean z, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = loaded.getUserId();
                }
                if ((i2 & 2) != 0) {
                    bool = loaded.isScrolledToBottom();
                }
                if ((i2 & 4) != 0) {
                    z = loaded.getInitialScrollPerformed();
                }
                if ((i2 & 8) != 0) {
                    i = loaded.getUnreadMessageCount();
                }
                return loaded.copy(str, bool, z, i);
            }

            @NotNull
            public final String component1() {
                return getUserId();
            }

            @Nullable
            public final Boolean component2() {
                return isScrolledToBottom();
            }

            public final boolean component3() {
                return getInitialScrollPerformed();
            }

            public final int component4() {
                return getUnreadMessageCount();
            }

            @NotNull
            public final Loaded copy(@NotNull String str, @Nullable Boolean bool, boolean z, int i) {
                Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
                return new Loaded(str, bool, z, i);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) obj;
                return Intrinsics.areEqual(getUserId(), loaded.getUserId()) && Intrinsics.areEqual(isScrolledToBottom(), loaded.isScrolledToBottom()) && getInitialScrollPerformed() == loaded.getInitialScrollPerformed() && getUnreadMessageCount() == loaded.getUnreadMessageCount();
            }

            @Override // com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesView.State
            public boolean getInitialScrollPerformed() {
                return this.c;
            }

            @Override // com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesView.State
            public int getUnreadMessageCount() {
                return this.d;
            }

            @Override // com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesView.State
            @NotNull
            public String getUserId() {
                return this.a;
            }

            public int hashCode() {
                String userId = getUserId();
                int i = 0;
                int hashCode = (userId != null ? userId.hashCode() : 0) * 31;
                Boolean isScrolledToBottom = isScrolledToBottom();
                if (isScrolledToBottom != null) {
                    i = isScrolledToBottom.hashCode();
                }
                int i2 = (hashCode + i) * 31;
                boolean initialScrollPerformed = getInitialScrollPerformed();
                if (initialScrollPerformed) {
                    initialScrollPerformed = true;
                }
                int i3 = initialScrollPerformed ? 1 : 0;
                int i4 = initialScrollPerformed ? 1 : 0;
                int i5 = initialScrollPerformed ? 1 : 0;
                return getUnreadMessageCount() + ((i2 + i3) * 31);
            }

            @Override // com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesView.State
            @Nullable
            public Boolean isScrolledToBottom() {
                return this.b;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Loaded(userId=");
                L.append(getUserId());
                L.append(", isScrolledToBottom=");
                L.append(isScrolledToBottom());
                L.append(", initialScrollPerformed=");
                L.append(getInitialScrollPerformed());
                L.append(", unreadMessageCount=");
                L.append(getUnreadMessageCount());
                L.append(")");
                return L.toString();
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Loaded(@NotNull String str, @Nullable Boolean bool, boolean z, int i) {
                super(null);
                Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
                this.a = str;
                this.b = bool;
                this.c = z;
                this.d = i;
            }
        }

        public State() {
        }

        public abstract boolean getInitialScrollPerformed();

        public abstract int getUnreadMessageCount();

        @NotNull
        public final String getUnreadMessageCountString() {
            return getUnreadMessageCount() > 99 ? "99+" : String.valueOf(getUnreadMessageCount());
        }

        @NotNull
        public abstract String getUserId();

        @Nullable
        public abstract Boolean isScrolledToBottom();

        public final boolean isShown() {
            return Intrinsics.areEqual(isScrolledToBottom(), Boolean.FALSE) && getUnreadMessageCount() > 0;
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0015\u001a\u00020\b8\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\nR\u001c\u0010\u0016\u001a\u00020\u000b8\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\rR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0005\u0010\u0004R\u001c\u0010\u001b\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State$Empty;", "Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State;", "", "component1", "()Ljava/lang/Boolean;", "isScrolledToBottom", "copy", "(Ljava/lang/Boolean;)Lcom/avito/android/messenger/conversation/mvi/new_messages/NewMessagesView$State$Empty;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getUserId", ChannelContext.Item.USER_ID, "unreadMessageCount", "I", "getUnreadMessageCount", AuthSource.BOOKING_ORDER, "Ljava/lang/Boolean;", "initialScrollPerformed", "Z", "getInitialScrollPerformed", "()Z", "<init>", "(Ljava/lang/Boolean;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends State {
            @NotNull
            public final String a;
            @Nullable
            public final Boolean b;

            public Empty() {
                this(null, 1, null);
            }

            public Empty(@Nullable Boolean bool) {
                super(null);
                this.b = bool;
                this.a = "";
            }

            public static /* synthetic */ Empty copy$default(Empty empty, Boolean bool, int i, Object obj) {
                if ((i & 1) != 0) {
                    bool = empty.isScrolledToBottom();
                }
                return empty.copy(bool);
            }

            @Nullable
            public final Boolean component1() {
                return isScrolledToBottom();
            }

            @NotNull
            public final Empty copy(@Nullable Boolean bool) {
                return new Empty(bool);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Empty) && Intrinsics.areEqual(isScrolledToBottom(), ((Empty) obj).isScrolledToBottom());
                }
                return true;
            }

            @Override // com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesView.State
            public boolean getInitialScrollPerformed() {
                return false;
            }

            @Override // com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesView.State
            public int getUnreadMessageCount() {
                return 0;
            }

            @Override // com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesView.State
            @NotNull
            public String getUserId() {
                return this.a;
            }

            public int hashCode() {
                Boolean isScrolledToBottom = isScrolledToBottom();
                if (isScrolledToBottom != null) {
                    return isScrolledToBottom.hashCode();
                }
                return 0;
            }

            @Override // com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesView.State
            @Nullable
            public Boolean isScrolledToBottom() {
                return this.b;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Empty(isScrolledToBottom=");
                L.append(isScrolledToBottom());
                L.append(")");
                return L.toString();
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Empty(Boolean bool, int i, j jVar) {
                this((i & 1) != 0 ? null : bool);
            }
        }

        public State(j jVar) {
        }
    }
}
