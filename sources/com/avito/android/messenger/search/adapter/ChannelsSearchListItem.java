package com.avito.android.messenger.search.adapter;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.messenger.channels.mvi.presenter.MessagePreview;
import com.avito.android.messenger.widget.chat_list_element.ChatListElement;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem;", "Lcom/avito/conveyor_item/Item;", "<init>", "()V", ScreenPublicConstsKt.CHANNEL_NAME, "Pagination", "SupportChannel", "Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$Pagination;", "Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$Channel;", "Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$SupportChannel;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class ChannelsSearchListItem implements Item {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b*\b\b\u0018\u00002\u00020\u0001:\u0001WBe\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0006\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\n\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\b\u0010#\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010$\u001a\u00020\u0011\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010&\u001a\u00020\u0017\u0012\u0006\u0010'\u001a\u00020\u001a¢\u0006\u0004\bU\u0010VJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0001\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\n2\b\b\u0002\u0010\"\u001a\u00020\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010$\u001a\u00020\u00112\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010&\u001a\u00020\u00172\b\b\u0002\u0010'\u001a\u00020\u001aHÆ\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b*\u0010\u0004J\u0010\u0010,\u001a\u00020+HÖ\u0001¢\u0006\u0004\b,\u0010-J\u001a\u00100\u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u00010.HÖ\u0003¢\u0006\u0004\b0\u00101R\u0019\u0010'\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u0010\u001cR\u0019\u0010 \u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u0010\u0004R\u001b\u0010#\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010\u0010R\u0019\u0010$\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010\u0013R\u0019\u0010&\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010\u0019R\u001c\u0010C\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bA\u00106\u001a\u0004\bB\u0010\u0004R\u0019\u0010\u001d\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bD\u00106\u001a\u0004\bE\u0010\u0004R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bF\u00106\u001a\u0004\bG\u0010\u0004R\u0019\u0010!\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\b!\u0010\fR\u001c\u0010M\u001a\u00020\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010\bR\u0019\u0010\u001f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\bN\u0010K\u001a\u0004\bO\u0010\bR\u0019\u0010\"\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bP\u00106\u001a\u0004\bQ\u0010\u0004R\u001b\u0010%\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010\u0016¨\u0006X"}, d2 = {"Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$Channel;", "Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()J", "component4", "", "component5", "()Z", "component6", "Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$Channel$ItemInfo;", "component7", "()Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$Channel$ItemInfo;", "Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$FeatureImage;", "component8", "()Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$FeatureImage;", "Lcom/avito/android/remote/model/Image;", "component9", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$LastMessageType;", "component10", "()Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$LastMessageType;", "Lcom/avito/android/messenger/channels/mvi/presenter/MessagePreview;", "component11", "()Lcom/avito/android/messenger/channels/mvi/presenter/MessagePreview;", "channelId", "messageId", "timestamp", "dateString", "isActive", "chatTitle", "itemInfo", "featureImage", "avatar", "lastMessageType", "lastMessage", "copy", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ZLjava/lang/String;Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$Channel$ItemInfo;Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$FeatureImage;Lcom/avito/android/remote/model/Image;Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$LastMessageType;Lcom/avito/android/messenger/channels/mvi/presenter/MessagePreview;)Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$Channel;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/messenger/channels/mvi/presenter/MessagePreview;", "getLastMessage", "f", "Ljava/lang/String;", "getDateString", "i", "Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$Channel$ItemInfo;", "getItemInfo", "j", "Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$FeatureImage;", "getFeatureImage", "l", "Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$LastMessageType;", "getLastMessageType", AuthSource.BOOKING_ORDER, "getStringId", "stringId", "c", "getChannelId", "d", "getMessageId", g.a, "Z", AuthSource.SEND_ABUSE, "J", "getId", "id", "e", "getTimestamp", "h", "getChatTitle", "k", "Lcom/avito/android/remote/model/Image;", "getAvatar", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ZLjava/lang/String;Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$Channel$ItemInfo;Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$FeatureImage;Lcom/avito/android/remote/model/Image;Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$LastMessageType;Lcom/avito/android/messenger/channels/mvi/presenter/MessagePreview;)V", "ItemInfo", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Channel extends ChannelsSearchListItem {
        public final long a;
        @NotNull
        public final String b;
        @NotNull
        public final String c;
        @Nullable
        public final String d;
        public final long e;
        @NotNull
        public final String f;
        public final boolean g;
        @NotNull
        public final String h;
        @Nullable
        public final ItemInfo i;
        @NotNull
        public final ChatListElement.FeatureImage j;
        @Nullable
        public final Image k;
        @NotNull
        public final ChatListElement.LastMessageType l;
        @NotNull
        public final MessagePreview m;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J&\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$Channel$ItemInfo;", "", "", "component1", "()Ljava/lang/String;", "component2", "title", "price", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$Channel$ItemInfo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getPrice", AuthSource.SEND_ABUSE, "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class ItemInfo {
            @NotNull
            public final String a;
            @Nullable
            public final String b;

            public ItemInfo(@NotNull String str, @Nullable String str2) {
                Intrinsics.checkNotNullParameter(str, "title");
                this.a = str;
                this.b = str2;
            }

            public static /* synthetic */ ItemInfo copy$default(ItemInfo itemInfo, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = itemInfo.a;
                }
                if ((i & 2) != 0) {
                    str2 = itemInfo.b;
                }
                return itemInfo.copy(str, str2);
            }

            @NotNull
            public final String component1() {
                return this.a;
            }

            @Nullable
            public final String component2() {
                return this.b;
            }

            @NotNull
            public final ItemInfo copy(@NotNull String str, @Nullable String str2) {
                Intrinsics.checkNotNullParameter(str, "title");
                return new ItemInfo(str, str2);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ItemInfo)) {
                    return false;
                }
                ItemInfo itemInfo = (ItemInfo) obj;
                return Intrinsics.areEqual(this.a, itemInfo.a) && Intrinsics.areEqual(this.b, itemInfo.b);
            }

            @Nullable
            public final String getPrice() {
                return this.b;
            }

            @NotNull
            public final String getTitle() {
                return this.a;
            }

            public int hashCode() {
                String str = this.a;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.b;
                if (str2 != null) {
                    i = str2.hashCode();
                }
                return hashCode + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("ItemInfo(title=");
                L.append(this.a);
                L.append(", price=");
                return a.t(L, this.b, ")");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Channel(@NotNull String str, @Nullable String str2, long j2, @NotNull String str3, boolean z, @NotNull String str4, @Nullable ItemInfo itemInfo, @NotNull ChatListElement.FeatureImage featureImage, @Nullable Image image, @NotNull ChatListElement.LastMessageType lastMessageType, @NotNull MessagePreview messagePreview) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "channelId");
            Intrinsics.checkNotNullParameter(str3, "dateString");
            Intrinsics.checkNotNullParameter(str4, "chatTitle");
            Intrinsics.checkNotNullParameter(featureImage, "featureImage");
            Intrinsics.checkNotNullParameter(lastMessageType, "lastMessageType");
            Intrinsics.checkNotNullParameter(messagePreview, "lastMessage");
            this.c = str;
            this.d = str2;
            this.e = j2;
            this.f = str3;
            this.g = z;
            this.h = str4;
            this.i = itemInfo;
            this.j = featureImage;
            this.k = image;
            this.l = lastMessageType;
            this.m = messagePreview;
            this.a = (Math.abs((long) str.hashCode()) << 31) + ((long) Math.abs(str2 != null ? str2.hashCode() : 0));
            this.b = a.L2(str, ':', str2);
        }

        public static /* synthetic */ Channel copy$default(Channel channel, String str, String str2, long j2, String str3, boolean z, String str4, ItemInfo itemInfo, ChatListElement.FeatureImage featureImage, Image image, ChatListElement.LastMessageType lastMessageType, MessagePreview messagePreview, int i2, Object obj) {
            return channel.copy((i2 & 1) != 0 ? channel.c : str, (i2 & 2) != 0 ? channel.d : str2, (i2 & 4) != 0 ? channel.e : j2, (i2 & 8) != 0 ? channel.f : str3, (i2 & 16) != 0 ? channel.g : z, (i2 & 32) != 0 ? channel.h : str4, (i2 & 64) != 0 ? channel.i : itemInfo, (i2 & 128) != 0 ? channel.j : featureImage, (i2 & 256) != 0 ? channel.k : image, (i2 & 512) != 0 ? channel.l : lastMessageType, (i2 & 1024) != 0 ? channel.m : messagePreview);
        }

        @NotNull
        public final String component1() {
            return this.c;
        }

        @NotNull
        public final ChatListElement.LastMessageType component10() {
            return this.l;
        }

        @NotNull
        public final MessagePreview component11() {
            return this.m;
        }

        @Nullable
        public final String component2() {
            return this.d;
        }

        public final long component3() {
            return this.e;
        }

        @NotNull
        public final String component4() {
            return this.f;
        }

        public final boolean component5() {
            return this.g;
        }

        @NotNull
        public final String component6() {
            return this.h;
        }

        @Nullable
        public final ItemInfo component7() {
            return this.i;
        }

        @NotNull
        public final ChatListElement.FeatureImage component8() {
            return this.j;
        }

        @Nullable
        public final Image component9() {
            return this.k;
        }

        @NotNull
        public final Channel copy(@NotNull String str, @Nullable String str2, long j2, @NotNull String str3, boolean z, @NotNull String str4, @Nullable ItemInfo itemInfo, @NotNull ChatListElement.FeatureImage featureImage, @Nullable Image image, @NotNull ChatListElement.LastMessageType lastMessageType, @NotNull MessagePreview messagePreview) {
            Intrinsics.checkNotNullParameter(str, "channelId");
            Intrinsics.checkNotNullParameter(str3, "dateString");
            Intrinsics.checkNotNullParameter(str4, "chatTitle");
            Intrinsics.checkNotNullParameter(featureImage, "featureImage");
            Intrinsics.checkNotNullParameter(lastMessageType, "lastMessageType");
            Intrinsics.checkNotNullParameter(messagePreview, "lastMessage");
            return new Channel(str, str2, j2, str3, z, str4, itemInfo, featureImage, image, lastMessageType, messagePreview);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Channel)) {
                return false;
            }
            Channel channel = (Channel) obj;
            return Intrinsics.areEqual(this.c, channel.c) && Intrinsics.areEqual(this.d, channel.d) && this.e == channel.e && Intrinsics.areEqual(this.f, channel.f) && this.g == channel.g && Intrinsics.areEqual(this.h, channel.h) && Intrinsics.areEqual(this.i, channel.i) && Intrinsics.areEqual(this.j, channel.j) && Intrinsics.areEqual(this.k, channel.k) && Intrinsics.areEqual(this.l, channel.l) && Intrinsics.areEqual(this.m, channel.m);
        }

        @Nullable
        public final Image getAvatar() {
            return this.k;
        }

        @NotNull
        public final String getChannelId() {
            return this.c;
        }

        @NotNull
        public final String getChatTitle() {
            return this.h;
        }

        @NotNull
        public final String getDateString() {
            return this.f;
        }

        @NotNull
        public final ChatListElement.FeatureImage getFeatureImage() {
            return this.j;
        }

        @Override // com.avito.android.messenger.search.adapter.ChannelsSearchListItem, com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
        public long getId() {
            return this.a;
        }

        @Nullable
        public final ItemInfo getItemInfo() {
            return this.i;
        }

        @NotNull
        public final MessagePreview getLastMessage() {
            return this.m;
        }

        @NotNull
        public final ChatListElement.LastMessageType getLastMessageType() {
            return this.l;
        }

        @Nullable
        public final String getMessageId() {
            return this.d;
        }

        @Override // com.avito.conveyor_item.Item
        @NotNull
        public String getStringId() {
            return this.b;
        }

        public final long getTimestamp() {
            return this.e;
        }

        public int hashCode() {
            String str = this.c;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.d;
            int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + c.a(this.e)) * 31;
            String str3 = this.f;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            boolean z = this.g;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = (hashCode3 + i3) * 31;
            String str4 = this.h;
            int hashCode4 = (i6 + (str4 != null ? str4.hashCode() : 0)) * 31;
            ItemInfo itemInfo = this.i;
            int hashCode5 = (hashCode4 + (itemInfo != null ? itemInfo.hashCode() : 0)) * 31;
            ChatListElement.FeatureImage featureImage = this.j;
            int hashCode6 = (hashCode5 + (featureImage != null ? featureImage.hashCode() : 0)) * 31;
            Image image = this.k;
            int hashCode7 = (hashCode6 + (image != null ? image.hashCode() : 0)) * 31;
            ChatListElement.LastMessageType lastMessageType = this.l;
            int hashCode8 = (hashCode7 + (lastMessageType != null ? lastMessageType.hashCode() : 0)) * 31;
            MessagePreview messagePreview = this.m;
            if (messagePreview != null) {
                i2 = messagePreview.hashCode();
            }
            return hashCode8 + i2;
        }

        public final boolean isActive() {
            return this.g;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Channel(channelId=");
            L.append(this.c);
            L.append(", messageId=");
            L.append(this.d);
            L.append(", timestamp=");
            L.append(this.e);
            L.append(", dateString=");
            L.append(this.f);
            L.append(", isActive=");
            L.append(this.g);
            L.append(", chatTitle=");
            L.append(this.h);
            L.append(", itemInfo=");
            L.append(this.i);
            L.append(", featureImage=");
            L.append(this.j);
            L.append(", avatar=");
            L.append(this.k);
            L.append(", lastMessageType=");
            L.append(this.l);
            L.append(", lastMessage=");
            L.append(this.m);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016XD¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$Pagination;", "Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem;", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Pagination extends ChannelsSearchListItem {
        @NotNull
        public static final Pagination INSTANCE = new Pagination();
        public static final long a = -1;
        @NotNull
        public static final String b = "10b88126-6529-4eab-a254-a796cc8e0ed7";

        public Pagination() {
            super(null);
        }

        @Override // com.avito.android.messenger.search.adapter.ChannelsSearchListItem, com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
        public long getId() {
            return a;
        }

        @Override // com.avito.conveyor_item.Item
        @NotNull
        public String getStringId() {
            return b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0018\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b2\u00103J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJF\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010!\u001a\u00020\u001c8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\u000f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\bR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0004R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010&\u001a\u0004\b)\u0010\u0004R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\fR\u001c\u0010/\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b-\u0010&\u001a\u0004\b.\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010&\u001a\u0004\b1\u0010\u0004¨\u00064"}, d2 = {"Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$SupportChannel;", "Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "component4", "Lcom/avito/android/remote/model/Image;", "component5", "()Lcom/avito/android/remote/model/Image;", "channelId", "messageId", "hasNewIncomingUnreadMessages", "supportChatTitle", "supportChatIcon", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/avito/android/remote/model/Image;)Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$SupportChannel;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "e", "Z", "getHasNewIncomingUnreadMessages", "f", "Ljava/lang/String;", "getSupportChatTitle", "d", "getMessageId", g.a, "Lcom/avito/android/remote/model/Image;", "getSupportChatIcon", AuthSource.BOOKING_ORDER, "getStringId", "stringId", "c", "getChannelId", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/avito/android/remote/model/Image;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class SupportChannel extends ChannelsSearchListItem {
        public final long a;
        @NotNull
        public final String b;
        @NotNull
        public final String c;
        @Nullable
        public final String d;
        public final boolean e;
        @NotNull
        public final String f;
        @Nullable
        public final Image g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SupportChannel(@NotNull String str, @Nullable String str2, boolean z, @NotNull String str3, @Nullable Image image) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "channelId");
            Intrinsics.checkNotNullParameter(str3, "supportChatTitle");
            this.c = str;
            this.d = str2;
            this.e = z;
            this.f = str3;
            this.g = image;
            this.a = (Math.abs((long) str.hashCode()) << 31) + ((long) Math.abs(str2 != null ? str2.hashCode() : 0));
            this.b = a.L2(str, ':', str2);
        }

        public static /* synthetic */ SupportChannel copy$default(SupportChannel supportChannel, String str, String str2, boolean z, String str3, Image image, int i, Object obj) {
            if ((i & 1) != 0) {
                str = supportChannel.c;
            }
            if ((i & 2) != 0) {
                str2 = supportChannel.d;
            }
            if ((i & 4) != 0) {
                z = supportChannel.e;
            }
            if ((i & 8) != 0) {
                str3 = supportChannel.f;
            }
            if ((i & 16) != 0) {
                image = supportChannel.g;
            }
            return supportChannel.copy(str, str2, z, str3, image);
        }

        @NotNull
        public final String component1() {
            return this.c;
        }

        @Nullable
        public final String component2() {
            return this.d;
        }

        public final boolean component3() {
            return this.e;
        }

        @NotNull
        public final String component4() {
            return this.f;
        }

        @Nullable
        public final Image component5() {
            return this.g;
        }

        @NotNull
        public final SupportChannel copy(@NotNull String str, @Nullable String str2, boolean z, @NotNull String str3, @Nullable Image image) {
            Intrinsics.checkNotNullParameter(str, "channelId");
            Intrinsics.checkNotNullParameter(str3, "supportChatTitle");
            return new SupportChannel(str, str2, z, str3, image);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SupportChannel)) {
                return false;
            }
            SupportChannel supportChannel = (SupportChannel) obj;
            return Intrinsics.areEqual(this.c, supportChannel.c) && Intrinsics.areEqual(this.d, supportChannel.d) && this.e == supportChannel.e && Intrinsics.areEqual(this.f, supportChannel.f) && Intrinsics.areEqual(this.g, supportChannel.g);
        }

        @NotNull
        public final String getChannelId() {
            return this.c;
        }

        public final boolean getHasNewIncomingUnreadMessages() {
            return this.e;
        }

        @Override // com.avito.android.messenger.search.adapter.ChannelsSearchListItem, com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
        public long getId() {
            return this.a;
        }

        @Nullable
        public final String getMessageId() {
            return this.d;
        }

        @Override // com.avito.conveyor_item.Item
        @NotNull
        public String getStringId() {
            return this.b;
        }

        @Nullable
        public final Image getSupportChatIcon() {
            return this.g;
        }

        @NotNull
        public final String getSupportChatTitle() {
            return this.f;
        }

        public int hashCode() {
            String str = this.c;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.d;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z = this.e;
            if (z) {
                z = true;
            }
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = (hashCode2 + i2) * 31;
            String str3 = this.f;
            int hashCode3 = (i5 + (str3 != null ? str3.hashCode() : 0)) * 31;
            Image image = this.g;
            if (image != null) {
                i = image.hashCode();
            }
            return hashCode3 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("SupportChannel(channelId=");
            L.append(this.c);
            L.append(", messageId=");
            L.append(this.d);
            L.append(", hasNewIncomingUnreadMessages=");
            L.append(this.e);
            L.append(", supportChatTitle=");
            L.append(this.f);
            L.append(", supportChatIcon=");
            L.append(this.g);
            L.append(")");
            return L.toString();
        }
    }

    public ChannelsSearchListItem() {
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    public ChannelsSearchListItem(j jVar) {
    }
}
