package com.avito.android.messenger.conversation.chat_header;

import a2.b.a.a.a;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\bf\u0018\u0000 \u001d2\u00020\u0001:\u0003\u001d\u001e\u001fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000eR\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000eR\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000eR\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000eR\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000e¨\u0006 "}, d2 = {"Lcom/avito/android/messenger/conversation/chat_header/ChatHeader;", "", "Lcom/avito/android/messenger/conversation/chat_header/ChatHeader$State;", "state", "", "render", "(Lcom/avito/android/messenger/conversation/chat_header/ChatHeader$State;)V", "", "animated", Tracker.Events.CREATIVE_COLLAPSE, "(Z)V", Tracker.Events.CREATIVE_EXPAND, "Lio/reactivex/Observable;", "getItemImageClicks", "()Lio/reactivex/Observable;", "itemImageClicks", "Landroid/view/View;", "getExpansions", "expansions", "getTitleLongClicks", "titleLongClicks", "getCollapses", "collapses", "getTitleClicks", "titleClicks", "getBackNavigationClicks", "backNavigationClicks", "getItemTitleClicks", "itemTitleClicks", "Companion", "Context", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChatHeader {
    @NotNull
    public static final Companion Companion = Companion.a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/conversation/chat_header/ChatHeader$Companion;", "", "Landroidx/constraintlayout/widget/ConstraintLayout;", "view", "Lcom/avito/android/messenger/conversation/chat_header/ChatHeader;", "create", "(Landroidx/constraintlayout/widget/ConstraintLayout;)Lcom/avito/android/messenger/conversation/chat_header/ChatHeader;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public static final /* synthetic */ Companion a = new Companion();

        @NotNull
        public final ChatHeader create(@NotNull ConstraintLayout constraintLayout) {
            Intrinsics.checkNotNullParameter(constraintLayout, "view");
            return new ChatHeaderImpl(constraintLayout);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/chat_header/ChatHeader$Context;", "", "<init>", "()V", "Hidden", "Item", "Lcom/avito/android/messenger/conversation/chat_header/ChatHeader$Context$Hidden;", "Lcom/avito/android/messenger/conversation/chat_header/ChatHeader$Context$Item;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Context {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/chat_header/ChatHeader$Context$Hidden;", "Lcom/avito/android/messenger/conversation/chat_header/ChatHeader$Context;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Hidden extends Context {
            @NotNull
            public static final Hidden INSTANCE = new Hidden();

            public Hidden() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J>\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\bR\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u0004R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010\u0004¨\u0006%"}, d2 = {"Lcom/avito/android/messenger/conversation/chat_header/ChatHeader$Context$Item;", "Lcom/avito/android/messenger/conversation/chat_header/ChatHeader$Context;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/image_loader/Picture;", "component3", "()Lcom/avito/android/image_loader/Picture;", "component4", "itemTitle", "itemPrice", "itemImage", "dealActionTitle", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/image_loader/Picture;Ljava/lang/String;)Lcom/avito/android/messenger/conversation/chat_header/ChatHeader$Context$Item;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getItemTitle", "c", "Lcom/avito/android/image_loader/Picture;", "getItemImage", "d", "getDealActionTitle", AuthSource.BOOKING_ORDER, "getItemPrice", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/image_loader/Picture;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Item extends Context {
            @NotNull
            public final String a;
            @Nullable
            public final String b;
            @Nullable
            public final Picture c;
            @Nullable
            public final String d;

            public Item() {
                this(null, null, null, null, 15, null);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Item(String str, String str2, Picture picture, String str3, int i, j jVar) {
                this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : picture, (i & 8) != 0 ? null : str3);
            }

            public static /* synthetic */ Item copy$default(Item item, String str, String str2, Picture picture, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = item.a;
                }
                if ((i & 2) != 0) {
                    str2 = item.b;
                }
                if ((i & 4) != 0) {
                    picture = item.c;
                }
                if ((i & 8) != 0) {
                    str3 = item.d;
                }
                return item.copy(str, str2, picture, str3);
            }

            @NotNull
            public final String component1() {
                return this.a;
            }

            @Nullable
            public final String component2() {
                return this.b;
            }

            @Nullable
            public final Picture component3() {
                return this.c;
            }

            @Nullable
            public final String component4() {
                return this.d;
            }

            @NotNull
            public final Item copy(@NotNull String str, @Nullable String str2, @Nullable Picture picture, @Nullable String str3) {
                Intrinsics.checkNotNullParameter(str, "itemTitle");
                return new Item(str, str2, picture, str3);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Item)) {
                    return false;
                }
                Item item = (Item) obj;
                return Intrinsics.areEqual(this.a, item.a) && Intrinsics.areEqual(this.b, item.b) && Intrinsics.areEqual(this.c, item.c) && Intrinsics.areEqual(this.d, item.d);
            }

            @Nullable
            public final String getDealActionTitle() {
                return this.d;
            }

            @Nullable
            public final Picture getItemImage() {
                return this.c;
            }

            @Nullable
            public final String getItemPrice() {
                return this.b;
            }

            @NotNull
            public final String getItemTitle() {
                return this.a;
            }

            public int hashCode() {
                String str = this.a;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.b;
                int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                Picture picture = this.c;
                int hashCode3 = (hashCode2 + (picture != null ? picture.hashCode() : 0)) * 31;
                String str3 = this.d;
                if (str3 != null) {
                    i = str3.hashCode();
                }
                return hashCode3 + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Item(itemTitle=");
                L.append(this.a);
                L.append(", itemPrice=");
                L.append(this.b);
                L.append(", itemImage=");
                L.append(this.c);
                L.append(", dealActionTitle=");
                return a.t(L, this.d, ")");
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Item(@NotNull String str, @Nullable String str2, @Nullable Picture picture, @Nullable String str3) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "itemTitle");
                this.a = str;
                this.b = str2;
                this.c = picture;
                this.d = str3;
            }
        }

        public Context() {
        }

        public Context(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void collapse$default(ChatHeader chatHeader, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = true;
                }
                chatHeader.collapse(z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: collapse");
        }

        public static /* synthetic */ void expand$default(ChatHeader chatHeader, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = true;
                }
                chatHeader.expand(z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expand");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u000e\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\bR\u0019\u0010\u000f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u000f\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u001f\u001a\u0004\b\"\u0010\u0004¨\u0006%"}, d2 = {"Lcom/avito/android/messenger/conversation/chat_header/ChatHeader$State;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/messenger/conversation/chat_header/ChatHeader$Context;", "component3", "()Lcom/avito/android/messenger/conversation/chat_header/ChatHeader$Context;", "", "component4", "()Z", "chatTitle", "chatSubtitle", "context", "isConnecting", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/messenger/conversation/chat_header/ChatHeader$Context;Z)Lcom/avito/android/messenger/conversation/chat_header/ChatHeader$State;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "c", "Lcom/avito/android/messenger/conversation/chat_header/ChatHeader$Context;", "getContext", "d", "Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getChatTitle", AuthSource.BOOKING_ORDER, "getChatSubtitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/messenger/conversation/chat_header/ChatHeader$Context;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class State {
        @NotNull
        public final String a;
        @NotNull
        public final String b;
        @NotNull
        public final Context c;
        public final boolean d;

        public State(@NotNull String str, @NotNull String str2, @NotNull Context context, boolean z) {
            Intrinsics.checkNotNullParameter(str, "chatTitle");
            Intrinsics.checkNotNullParameter(str2, "chatSubtitle");
            Intrinsics.checkNotNullParameter(context, "context");
            this.a = str;
            this.b = str2;
            this.c = context;
            this.d = z;
        }

        public static /* synthetic */ State copy$default(State state, String str, String str2, Context context, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = state.a;
            }
            if ((i & 2) != 0) {
                str2 = state.b;
            }
            if ((i & 4) != 0) {
                context = state.c;
            }
            if ((i & 8) != 0) {
                z = state.d;
            }
            return state.copy(str, str2, context, z);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final Context component3() {
            return this.c;
        }

        public final boolean component4() {
            return this.d;
        }

        @NotNull
        public final State copy(@NotNull String str, @NotNull String str2, @NotNull Context context, boolean z) {
            Intrinsics.checkNotNullParameter(str, "chatTitle");
            Intrinsics.checkNotNullParameter(str2, "chatSubtitle");
            Intrinsics.checkNotNullParameter(context, "context");
            return new State(str, str2, context, z);
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
        public final String getChatSubtitle() {
            return this.b;
        }

        @NotNull
        public final String getChatTitle() {
            return this.a;
        }

        @NotNull
        public final Context getContext() {
            return this.c;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Context context = this.c;
            if (context != null) {
                i = context.hashCode();
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
            StringBuilder L = a.L("State(chatTitle=");
            L.append(this.a);
            L.append(", chatSubtitle=");
            L.append(this.b);
            L.append(", context=");
            L.append(this.c);
            L.append(", isConnecting=");
            return a.B(L, this.d, ")");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ State(String str, String str2, Context context, boolean z, int i, j jVar) {
            this(str, str2, context, (i & 8) != 0 ? false : z);
        }
    }

    void collapse(boolean z);

    void expand(boolean z);

    @NotNull
    Observable<Unit> getBackNavigationClicks();

    @NotNull
    Observable<View> getCollapses();

    @NotNull
    Observable<View> getExpansions();

    @NotNull
    Observable<Unit> getItemImageClicks();

    @NotNull
    Observable<Unit> getItemTitleClicks();

    @NotNull
    Observable<Unit> getTitleClicks();

    @NotNull
    Observable<Unit> getTitleLongClicks();

    void render(@NotNull State state);
}
