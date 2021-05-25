package com.avito.android.messenger.conversation.mvi.context;

import a2.b.a.a.a;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.image_loader.Picture;
import com.avito.android.messenger.channels.mvi.common.v2.Renderer;
import io.reactivex.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.y.f;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H&¢\u0006\u0004\b\u0007\u0010\u0005R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State;", "", "clearSubscriptions", "()V", "destroyView", "attachView", "Lio/reactivex/Observable;", "getItemBlockClicks", "()Lio/reactivex/Observable;", "itemBlockClicks", "getItemImageClicks", "itemImageClicks", "getBackClicks", "backClicks", "getTitleClicks", "titleClicks", "ItemBlock", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelContextView extends Renderer<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void render(@NotNull ChannelContextView channelContextView, @NotNull State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            Renderer.DefaultImpls.render(channelContextView, state);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$ItemBlock;", "", "<init>", "()V", "Empty", "Hidden", "Loaded", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$ItemBlock$Empty;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$ItemBlock$Hidden;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$ItemBlock$Loaded;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ItemBlock {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$ItemBlock$Empty;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$ItemBlock;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends ItemBlock {
            @NotNull
            public static final Empty INSTANCE = new Empty();

            public Empty() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$ItemBlock$Hidden;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$ItemBlock;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Hidden extends ItemBlock {
            @NotNull
            public static final Hidden INSTANCE = new Hidden();

            public Hidden() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0011\u0010\u0012JF\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000eR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$ItemBlock$Loaded;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$ItemBlock;", "", "title", "price", "Lcom/avito/android/image_loader/Picture;", "image", "dealActionTitle", "Lcom/avito/android/deep_linking/links/DeepLink;", "dealActionDeepLink", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/image_loader/Picture;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$ItemBlock$Loaded;", "toString", "()Ljava/lang/String;", "Lcom/avito/android/deep_linking/links/DeepLink;", "Ljava/lang/String;", "Lcom/avito/android/image_loader/Picture;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/image_loader/Picture;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loaded extends ItemBlock {
            @JvmField
            @Nullable
            public final DeepLink dealActionDeepLink;
            @JvmField
            @Nullable
            public final String dealActionTitle;
            @JvmField
            @NotNull
            public final Picture image;
            @JvmField
            @NotNull
            public final String price;
            @JvmField
            @NotNull
            public final String title;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Loaded(@NotNull String str, @NotNull String str2, @NotNull Picture picture, @Nullable String str3, @Nullable DeepLink deepLink) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "title");
                Intrinsics.checkNotNullParameter(str2, "price");
                Intrinsics.checkNotNullParameter(picture, "image");
                this.title = str;
                this.price = str2;
                this.image = picture;
                this.dealActionTitle = str3;
                this.dealActionDeepLink = deepLink;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, String str, String str2, Picture picture, String str3, DeepLink deepLink, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = loaded.title;
                }
                if ((i & 2) != 0) {
                    str2 = loaded.price;
                }
                if ((i & 4) != 0) {
                    picture = loaded.image;
                }
                if ((i & 8) != 0) {
                    str3 = loaded.dealActionTitle;
                }
                if ((i & 16) != 0) {
                    deepLink = loaded.dealActionDeepLink;
                }
                Intrinsics.checkNotNullParameter(str, "title");
                Intrinsics.checkNotNullParameter(str2, "price");
                Intrinsics.checkNotNullParameter(picture, "image");
                return new Loaded(str, str2, picture, str3, deepLink);
            }

            @NotNull
            public final Loaded copy(@NotNull String str, @NotNull String str2, @NotNull Picture picture, @Nullable String str3, @Nullable DeepLink deepLink) {
                Intrinsics.checkNotNullParameter(str, "title");
                Intrinsics.checkNotNullParameter(str2, "price");
                Intrinsics.checkNotNullParameter(picture, "image");
                return new Loaded(str, str2, picture, str3, deepLink);
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("ItemBlock.Loaded(title='");
                L.append(this.title);
                L.append("', price='");
                L.append(this.price);
                L.append("', image=");
                L.append(this.image);
                L.append(')');
                return L.toString();
            }
        }

        public ItemBlock() {
        }

        public ItemBlock(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0017\u0018\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015\u0001\u0003\u001a\u001b\u001c¨\u0006\u001d"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State;", "", "", "toString", "()Ljava/lang/String;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$ItemBlock;", "itemBlock", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$ItemBlock;", "isConnecting", "Z", "Lcom/avito/android/image_loader/Picture;", "avatar", "Lcom/avito/android/image_loader/Picture;", "chatTitle", "Ljava/lang/String;", "onlineStatus", "Empty", "Error", "Loaded", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State$Empty;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State$Error;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State$Loaded;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {
        @JvmField
        @Nullable
        public final Picture avatar;
        @JvmField
        @NotNull
        public final String chatTitle;
        @JvmField
        public final boolean isConnecting;
        @JvmField
        @NotNull
        public final ItemBlock itemBlock;
        @JvmField
        @NotNull
        public final String onlineStatus;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State$Empty;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends State {
            @NotNull
            public static final Empty INSTANCE = new Empty();

            public Empty() {
                super("", null, "", ItemBlock.Empty.INSTANCE, false, null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State$Error;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends State {
            @NotNull
            public static final Error INSTANCE = new Error();

            public Error() {
                super("", null, "", ItemBlock.Empty.INSTANCE, false, null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State$Loaded;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State;", "Item", "NoItem", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State$Loaded$Item;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State$Loaded$NoItem;", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class Loaded extends State {

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State$Loaded$Item;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State$Loaded;", "", "chatTitle", "Lcom/avito/android/image_loader/Picture;", "avatar", "onlineStatus", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$ItemBlock$Loaded;", "itemBlock", "", "isConnecting", "<init>", "(Ljava/lang/String;Lcom/avito/android/image_loader/Picture;Ljava/lang/String;Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$ItemBlock$Loaded;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Item extends Loaded {
                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Item(@NotNull String str, @Nullable Picture picture, @NotNull String str2, @NotNull ItemBlock.Loaded loaded, boolean z) {
                    super(str, picture, str2, loaded, z, null);
                    Intrinsics.checkNotNullParameter(str, "chatTitle");
                    Intrinsics.checkNotNullParameter(str2, "onlineStatus");
                    Intrinsics.checkNotNullParameter(loaded, "itemBlock");
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State$Loaded$NoItem;", "Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextView$State$Loaded;", "", "chatTitle", "Lcom/avito/android/image_loader/Picture;", "avatar", "onlineStatus", "", "isConnecting", "<init>", "(Ljava/lang/String;Lcom/avito/android/image_loader/Picture;Ljava/lang/String;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class NoItem extends Loaded {
                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public NoItem(@NotNull String str, @Nullable Picture picture, @NotNull String str2, boolean z) {
                    super(str, picture, str2, ItemBlock.Hidden.INSTANCE, z, null);
                    Intrinsics.checkNotNullParameter(str, "chatTitle");
                    Intrinsics.checkNotNullParameter(str2, "onlineStatus");
                }
            }

            public Loaded(String str, Picture picture, String str2, ItemBlock itemBlock, boolean z, j jVar) {
                super(str, picture, str2, itemBlock, z, null);
            }
        }

        public State(String str, Picture picture, String str2, ItemBlock itemBlock2, boolean z, j jVar) {
            this.chatTitle = str;
            this.avatar = picture;
            this.onlineStatus = str2;
            this.itemBlock = itemBlock2;
            this.isConnecting = z;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!Intrinsics.areEqual(getClass(), obj != null ? obj.getClass() : null)) {
                return false;
            }
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.avito.android.messenger.conversation.mvi.context.ChannelContextView.State");
            State state = (State) obj;
            return !(Intrinsics.areEqual(this.chatTitle, state.chatTitle) ^ true) && !(Intrinsics.areEqual(this.avatar, state.avatar) ^ true) && !(Intrinsics.areEqual(this.onlineStatus, state.onlineStatus) ^ true) && !(Intrinsics.areEqual(this.itemBlock, state.itemBlock) ^ true);
        }

        public int hashCode() {
            int hashCode = this.chatTitle.hashCode() * 31;
            Picture picture = this.avatar;
            return this.itemBlock.hashCode() + a.B0(this.onlineStatus, (hashCode + (picture != null ? picture.hashCode() : 0)) * 31, 31);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("ChannelContextView.State.Loaded(\n                |   chatTitle='");
            L.append(this.chatTitle);
            L.append("',\n                |   avatar=");
            L.append(this.avatar);
            L.append(",\n                |   onlineStatus='");
            L.append(this.onlineStatus);
            L.append("',\n                |   itemBlock=");
            L.append(this.itemBlock);
            L.append(",\n                |   isConnecting=");
            return f.trimMargin$default(a.B(L, this.isConnecting, "\n                |)"), null, 1, null);
        }
    }

    void attachView();

    void clearSubscriptions();

    void destroyView();

    @NotNull
    Observable<Unit> getBackClicks();

    @NotNull
    Observable<Unit> getItemBlockClicks();

    @NotNull
    Observable<Unit> getItemImageClicks();

    @NotNull
    Observable<Unit> getTitleClicks();
}
