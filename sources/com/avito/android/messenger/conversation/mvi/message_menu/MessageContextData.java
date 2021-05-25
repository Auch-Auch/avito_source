package com.avito.android.messenger.conversation.mvi.message_menu;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.config.MessengerConfig;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\f\r\u000e\u000f\u0010\u0011\u0012\u0013B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0001\b\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b¨\u0006\u001c"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;", "getMessageData", "()Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;", "messageData", "Lru/avito/messenger/config/MessengerConfig;", "getConfig", "()Lru/avito/messenger/config/MessengerConfig;", Navigation.CONFIG, "<init>", "()V", "File", "Image", "Item", HttpHeaders.LINK, "LinkInText", "LocalImage", HttpHeaders.LOCATION, "Text", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData$Item;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData$Text;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData$Link;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData$LinkInText;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData$Location;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData$File;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData$Image;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData$LocalImage;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class MessageContextData {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007¨\u0006\u001f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData$File;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "Lru/avito/messenger/config/MessengerConfig;", "component1", "()Lru/avito/messenger/config/MessengerConfig;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;", "component2", "()Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;", Navigation.CONFIG, "messageData", "copy", "(Lru/avito/messenger/config/MessengerConfig;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;)Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData$File;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lru/avito/messenger/config/MessengerConfig;", "getConfig", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;", "getMessageData", "<init>", "(Lru/avito/messenger/config/MessengerConfig;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class File extends MessageContextData {
        @NotNull
        public final MessengerConfig a;
        @NotNull
        public final MessageData b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public File(@NotNull MessengerConfig messengerConfig, @NotNull MessageData messageData) {
            super(null);
            Intrinsics.checkNotNullParameter(messengerConfig, Navigation.CONFIG);
            Intrinsics.checkNotNullParameter(messageData, "messageData");
            this.a = messengerConfig;
            this.b = messageData;
        }

        public static /* synthetic */ File copy$default(File file, MessengerConfig messengerConfig, MessageData messageData, int i, Object obj) {
            if ((i & 1) != 0) {
                messengerConfig = file.getConfig();
            }
            if ((i & 2) != 0) {
                messageData = file.getMessageData();
            }
            return file.copy(messengerConfig, messageData);
        }

        @NotNull
        public final MessengerConfig component1() {
            return getConfig();
        }

        @NotNull
        public final MessageData component2() {
            return getMessageData();
        }

        @NotNull
        public final File copy(@NotNull MessengerConfig messengerConfig, @NotNull MessageData messageData) {
            Intrinsics.checkNotNullParameter(messengerConfig, Navigation.CONFIG);
            Intrinsics.checkNotNullParameter(messageData, "messageData");
            return new File(messengerConfig, messageData);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof File)) {
                return false;
            }
            File file = (File) obj;
            return Intrinsics.areEqual(getConfig(), file.getConfig()) && Intrinsics.areEqual(getMessageData(), file.getMessageData());
        }

        @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageContextData
        @NotNull
        public MessengerConfig getConfig() {
            return this.a;
        }

        @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageContextData
        @NotNull
        public MessageData getMessageData() {
            return this.b;
        }

        public int hashCode() {
            MessengerConfig config = getConfig();
            int i = 0;
            int hashCode = (config != null ? config.hashCode() : 0) * 31;
            MessageData messageData = getMessageData();
            if (messageData != null) {
                i = messageData.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("File(config=");
            L.append(getConfig());
            L.append(", messageData=");
            L.append(getMessageData());
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001c\u0010\f\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\n¨\u0006$"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData$Image;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "Lru/avito/messenger/config/MessengerConfig;", "component1", "()Lru/avito/messenger/config/MessengerConfig;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;", "component2", "()Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;", "", "component3", "()Ljava/lang/String;", Navigation.CONFIG, "messageData", "url", "copy", "(Lru/avito/messenger/config/MessengerConfig;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;Ljava/lang/String;)Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData$Image;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lru/avito/messenger/config/MessengerConfig;", "getConfig", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;", "getMessageData", "c", "Ljava/lang/String;", "getUrl", "<init>", "(Lru/avito/messenger/config/MessengerConfig;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Image extends MessageContextData {
        @NotNull
        public final MessengerConfig a;
        @NotNull
        public final MessageData b;
        @NotNull
        public final String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Image(@NotNull MessengerConfig messengerConfig, @NotNull MessageData messageData, @NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(messengerConfig, Navigation.CONFIG);
            Intrinsics.checkNotNullParameter(messageData, "messageData");
            Intrinsics.checkNotNullParameter(str, "url");
            this.a = messengerConfig;
            this.b = messageData;
            this.c = str;
        }

        public static /* synthetic */ Image copy$default(Image image, MessengerConfig messengerConfig, MessageData messageData, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                messengerConfig = image.getConfig();
            }
            if ((i & 2) != 0) {
                messageData = image.getMessageData();
            }
            if ((i & 4) != 0) {
                str = image.c;
            }
            return image.copy(messengerConfig, messageData, str);
        }

        @NotNull
        public final MessengerConfig component1() {
            return getConfig();
        }

        @NotNull
        public final MessageData component2() {
            return getMessageData();
        }

        @NotNull
        public final String component3() {
            return this.c;
        }

        @NotNull
        public final Image copy(@NotNull MessengerConfig messengerConfig, @NotNull MessageData messageData, @NotNull String str) {
            Intrinsics.checkNotNullParameter(messengerConfig, Navigation.CONFIG);
            Intrinsics.checkNotNullParameter(messageData, "messageData");
            Intrinsics.checkNotNullParameter(str, "url");
            return new Image(messengerConfig, messageData, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Image)) {
                return false;
            }
            Image image = (Image) obj;
            return Intrinsics.areEqual(getConfig(), image.getConfig()) && Intrinsics.areEqual(getMessageData(), image.getMessageData()) && Intrinsics.areEqual(this.c, image.c);
        }

        @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageContextData
        @NotNull
        public MessengerConfig getConfig() {
            return this.a;
        }

        @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageContextData
        @NotNull
        public MessageData getMessageData() {
            return this.b;
        }

        @NotNull
        public final String getUrl() {
            return this.c;
        }

        public int hashCode() {
            MessengerConfig config = getConfig();
            int i = 0;
            int hashCode = (config != null ? config.hashCode() : 0) * 31;
            MessageData messageData = getMessageData();
            int hashCode2 = (hashCode + (messageData != null ? messageData.hashCode() : 0)) * 31;
            String str = this.c;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Image(config=");
            L.append(getConfig());
            L.append(", messageData=");
            L.append(getMessageData());
            L.append(", url=");
            return a.t(L, this.c, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0012\u0010\nJ\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u000e\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\nR\u001c\u0010\f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001c\u0010\r\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0007R\u0019\u0010\u000f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010\n¨\u0006("}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData$Item;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "Lru/avito/messenger/config/MessengerConfig;", "component1", "()Lru/avito/messenger/config/MessengerConfig;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;", "component2", "()Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;", "", "component3", "()Ljava/lang/String;", "component4", Navigation.CONFIG, "messageData", "itemId", "url", "copy", "(Lru/avito/messenger/config/MessengerConfig;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData$Item;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/String;", "getItemId", AuthSource.SEND_ABUSE, "Lru/avito/messenger/config/MessengerConfig;", "getConfig", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;", "getMessageData", "d", "getUrl", "<init>", "(Lru/avito/messenger/config/MessengerConfig;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Item extends MessageContextData {
        @NotNull
        public final MessengerConfig a;
        @NotNull
        public final MessageData b;
        @NotNull
        public final String c;
        @NotNull
        public final String d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Item(@NotNull MessengerConfig messengerConfig, @NotNull MessageData messageData, @NotNull String str, @NotNull String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(messengerConfig, Navigation.CONFIG);
            Intrinsics.checkNotNullParameter(messageData, "messageData");
            Intrinsics.checkNotNullParameter(str, "itemId");
            Intrinsics.checkNotNullParameter(str2, "url");
            this.a = messengerConfig;
            this.b = messageData;
            this.c = str;
            this.d = str2;
        }

        public static /* synthetic */ Item copy$default(Item item, MessengerConfig messengerConfig, MessageData messageData, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                messengerConfig = item.getConfig();
            }
            if ((i & 2) != 0) {
                messageData = item.getMessageData();
            }
            if ((i & 4) != 0) {
                str = item.c;
            }
            if ((i & 8) != 0) {
                str2 = item.d;
            }
            return item.copy(messengerConfig, messageData, str, str2);
        }

        @NotNull
        public final MessengerConfig component1() {
            return getConfig();
        }

        @NotNull
        public final MessageData component2() {
            return getMessageData();
        }

        @NotNull
        public final String component3() {
            return this.c;
        }

        @NotNull
        public final String component4() {
            return this.d;
        }

        @NotNull
        public final Item copy(@NotNull MessengerConfig messengerConfig, @NotNull MessageData messageData, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(messengerConfig, Navigation.CONFIG);
            Intrinsics.checkNotNullParameter(messageData, "messageData");
            Intrinsics.checkNotNullParameter(str, "itemId");
            Intrinsics.checkNotNullParameter(str2, "url");
            return new Item(messengerConfig, messageData, str, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Item)) {
                return false;
            }
            Item item = (Item) obj;
            return Intrinsics.areEqual(getConfig(), item.getConfig()) && Intrinsics.areEqual(getMessageData(), item.getMessageData()) && Intrinsics.areEqual(this.c, item.c) && Intrinsics.areEqual(this.d, item.d);
        }

        @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageContextData
        @NotNull
        public MessengerConfig getConfig() {
            return this.a;
        }

        @NotNull
        public final String getItemId() {
            return this.c;
        }

        @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageContextData
        @NotNull
        public MessageData getMessageData() {
            return this.b;
        }

        @NotNull
        public final String getUrl() {
            return this.d;
        }

        public int hashCode() {
            MessengerConfig config = getConfig();
            int i = 0;
            int hashCode = (config != null ? config.hashCode() : 0) * 31;
            MessageData messageData = getMessageData();
            int hashCode2 = (hashCode + (messageData != null ? messageData.hashCode() : 0)) * 31;
            String str = this.c;
            int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.d;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode3 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Item(config=");
            L.append(getConfig());
            L.append(", messageData=");
            L.append(getMessageData());
            L.append(", itemId=");
            L.append(this.c);
            L.append(", url=");
            return a.t(L, this.d, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\f\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0004¨\u0006$"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData$Link;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "Lru/avito/messenger/config/MessengerConfig;", "component1", "()Lru/avito/messenger/config/MessengerConfig;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;", "component2", "()Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;", "", "component3", "()Ljava/lang/String;", Navigation.CONFIG, "messageData", "url", "copy", "(Lru/avito/messenger/config/MessengerConfig;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;Ljava/lang/String;)Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData$Link;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;", "getMessageData", "c", "Ljava/lang/String;", "getUrl", AuthSource.SEND_ABUSE, "Lru/avito/messenger/config/MessengerConfig;", "getConfig", "<init>", "(Lru/avito/messenger/config/MessengerConfig;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Link extends MessageContextData {
        @NotNull
        public final MessengerConfig a;
        @NotNull
        public final MessageData b;
        @NotNull
        public final String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Link(@NotNull MessengerConfig messengerConfig, @NotNull MessageData messageData, @NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(messengerConfig, Navigation.CONFIG);
            Intrinsics.checkNotNullParameter(messageData, "messageData");
            Intrinsics.checkNotNullParameter(str, "url");
            this.a = messengerConfig;
            this.b = messageData;
            this.c = str;
        }

        public static /* synthetic */ Link copy$default(Link link, MessengerConfig messengerConfig, MessageData messageData, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                messengerConfig = link.getConfig();
            }
            if ((i & 2) != 0) {
                messageData = link.getMessageData();
            }
            if ((i & 4) != 0) {
                str = link.c;
            }
            return link.copy(messengerConfig, messageData, str);
        }

        @NotNull
        public final MessengerConfig component1() {
            return getConfig();
        }

        @NotNull
        public final MessageData component2() {
            return getMessageData();
        }

        @NotNull
        public final String component3() {
            return this.c;
        }

        @NotNull
        public final Link copy(@NotNull MessengerConfig messengerConfig, @NotNull MessageData messageData, @NotNull String str) {
            Intrinsics.checkNotNullParameter(messengerConfig, Navigation.CONFIG);
            Intrinsics.checkNotNullParameter(messageData, "messageData");
            Intrinsics.checkNotNullParameter(str, "url");
            return new Link(messengerConfig, messageData, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Link)) {
                return false;
            }
            Link link = (Link) obj;
            return Intrinsics.areEqual(getConfig(), link.getConfig()) && Intrinsics.areEqual(getMessageData(), link.getMessageData()) && Intrinsics.areEqual(this.c, link.c);
        }

        @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageContextData
        @NotNull
        public MessengerConfig getConfig() {
            return this.a;
        }

        @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageContextData
        @NotNull
        public MessageData getMessageData() {
            return this.b;
        }

        @NotNull
        public final String getUrl() {
            return this.c;
        }

        public int hashCode() {
            MessengerConfig config = getConfig();
            int i = 0;
            int hashCode = (config != null ? config.hashCode() : 0) * 31;
            MessageData messageData = getMessageData();
            int hashCode2 = (hashCode + (messageData != null ? messageData.hashCode() : 0)) * 31;
            String str = this.c;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Link(config=");
            L.append(getConfig());
            L.append(", messageData=");
            L.append(getMessageData());
            L.append(", url=");
            return a.t(L, this.c, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\f\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\n¨\u0006$"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData$LinkInText;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "Lru/avito/messenger/config/MessengerConfig;", "component1", "()Lru/avito/messenger/config/MessengerConfig;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;", "component2", "()Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;", "", "component3", "()Ljava/lang/String;", Navigation.CONFIG, "messageData", "url", "copy", "(Lru/avito/messenger/config/MessengerConfig;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;Ljava/lang/String;)Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData$LinkInText;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;", "getMessageData", AuthSource.SEND_ABUSE, "Lru/avito/messenger/config/MessengerConfig;", "getConfig", "c", "Ljava/lang/String;", "getUrl", "<init>", "(Lru/avito/messenger/config/MessengerConfig;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class LinkInText extends MessageContextData {
        @NotNull
        public final MessengerConfig a;
        @NotNull
        public final MessageData b;
        @NotNull
        public final String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LinkInText(@NotNull MessengerConfig messengerConfig, @NotNull MessageData messageData, @NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(messengerConfig, Navigation.CONFIG);
            Intrinsics.checkNotNullParameter(messageData, "messageData");
            Intrinsics.checkNotNullParameter(str, "url");
            this.a = messengerConfig;
            this.b = messageData;
            this.c = str;
        }

        public static /* synthetic */ LinkInText copy$default(LinkInText linkInText, MessengerConfig messengerConfig, MessageData messageData, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                messengerConfig = linkInText.getConfig();
            }
            if ((i & 2) != 0) {
                messageData = linkInText.getMessageData();
            }
            if ((i & 4) != 0) {
                str = linkInText.c;
            }
            return linkInText.copy(messengerConfig, messageData, str);
        }

        @NotNull
        public final MessengerConfig component1() {
            return getConfig();
        }

        @NotNull
        public final MessageData component2() {
            return getMessageData();
        }

        @NotNull
        public final String component3() {
            return this.c;
        }

        @NotNull
        public final LinkInText copy(@NotNull MessengerConfig messengerConfig, @NotNull MessageData messageData, @NotNull String str) {
            Intrinsics.checkNotNullParameter(messengerConfig, Navigation.CONFIG);
            Intrinsics.checkNotNullParameter(messageData, "messageData");
            Intrinsics.checkNotNullParameter(str, "url");
            return new LinkInText(messengerConfig, messageData, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LinkInText)) {
                return false;
            }
            LinkInText linkInText = (LinkInText) obj;
            return Intrinsics.areEqual(getConfig(), linkInText.getConfig()) && Intrinsics.areEqual(getMessageData(), linkInText.getMessageData()) && Intrinsics.areEqual(this.c, linkInText.c);
        }

        @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageContextData
        @NotNull
        public MessengerConfig getConfig() {
            return this.a;
        }

        @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageContextData
        @NotNull
        public MessageData getMessageData() {
            return this.b;
        }

        @NotNull
        public final String getUrl() {
            return this.c;
        }

        public int hashCode() {
            MessengerConfig config = getConfig();
            int i = 0;
            int hashCode = (config != null ? config.hashCode() : 0) * 31;
            MessageData messageData = getMessageData();
            int hashCode2 = (hashCode + (messageData != null ? messageData.hashCode() : 0)) * 31;
            String str = this.c;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("LinkInText(config=");
            L.append(getConfig());
            L.append(", messageData=");
            L.append(getMessageData());
            L.append(", url=");
            return a.t(L, this.c, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\t\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData$LocalImage;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "Lru/avito/messenger/config/MessengerConfig;", "component1", "()Lru/avito/messenger/config/MessengerConfig;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;", "component2", "()Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;", Navigation.CONFIG, "messageData", "copy", "(Lru/avito/messenger/config/MessengerConfig;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;)Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData$LocalImage;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;", "getMessageData", AuthSource.SEND_ABUSE, "Lru/avito/messenger/config/MessengerConfig;", "getConfig", "<init>", "(Lru/avito/messenger/config/MessengerConfig;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class LocalImage extends MessageContextData {
        @NotNull
        public final MessengerConfig a;
        @NotNull
        public final MessageData b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LocalImage(@NotNull MessengerConfig messengerConfig, @NotNull MessageData messageData) {
            super(null);
            Intrinsics.checkNotNullParameter(messengerConfig, Navigation.CONFIG);
            Intrinsics.checkNotNullParameter(messageData, "messageData");
            this.a = messengerConfig;
            this.b = messageData;
        }

        public static /* synthetic */ LocalImage copy$default(LocalImage localImage, MessengerConfig messengerConfig, MessageData messageData, int i, Object obj) {
            if ((i & 1) != 0) {
                messengerConfig = localImage.getConfig();
            }
            if ((i & 2) != 0) {
                messageData = localImage.getMessageData();
            }
            return localImage.copy(messengerConfig, messageData);
        }

        @NotNull
        public final MessengerConfig component1() {
            return getConfig();
        }

        @NotNull
        public final MessageData component2() {
            return getMessageData();
        }

        @NotNull
        public final LocalImage copy(@NotNull MessengerConfig messengerConfig, @NotNull MessageData messageData) {
            Intrinsics.checkNotNullParameter(messengerConfig, Navigation.CONFIG);
            Intrinsics.checkNotNullParameter(messageData, "messageData");
            return new LocalImage(messengerConfig, messageData);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LocalImage)) {
                return false;
            }
            LocalImage localImage = (LocalImage) obj;
            return Intrinsics.areEqual(getConfig(), localImage.getConfig()) && Intrinsics.areEqual(getMessageData(), localImage.getMessageData());
        }

        @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageContextData
        @NotNull
        public MessengerConfig getConfig() {
            return this.a;
        }

        @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageContextData
        @NotNull
        public MessageData getMessageData() {
            return this.b;
        }

        public int hashCode() {
            MessengerConfig config = getConfig();
            int i = 0;
            int hashCode = (config != null ? config.hashCode() : 0) * 31;
            MessageData messageData = getMessageData();
            if (messageData != null) {
                i = messageData.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("LocalImage(config=");
            L.append(getConfig());
            L.append(", messageData=");
            L.append(getMessageData());
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\f\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\n¨\u0006$"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData$Location;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "Lru/avito/messenger/config/MessengerConfig;", "component1", "()Lru/avito/messenger/config/MessengerConfig;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;", "component2", "()Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;", "", "component3", "()Ljava/lang/String;", Navigation.CONFIG, "messageData", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "copy", "(Lru/avito/messenger/config/MessengerConfig;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;Ljava/lang/String;)Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData$Location;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;", "getMessageData", AuthSource.SEND_ABUSE, "Lru/avito/messenger/config/MessengerConfig;", "getConfig", "c", "Ljava/lang/String;", "getAddress", "<init>", "(Lru/avito/messenger/config/MessengerConfig;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Location extends MessageContextData {
        @NotNull
        public final MessengerConfig a;
        @NotNull
        public final MessageData b;
        @NotNull
        public final String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Location(@NotNull MessengerConfig messengerConfig, @NotNull MessageData messageData, @NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(messengerConfig, Navigation.CONFIG);
            Intrinsics.checkNotNullParameter(messageData, "messageData");
            Intrinsics.checkNotNullParameter(str, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
            this.a = messengerConfig;
            this.b = messageData;
            this.c = str;
        }

        public static /* synthetic */ Location copy$default(Location location, MessengerConfig messengerConfig, MessageData messageData, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                messengerConfig = location.getConfig();
            }
            if ((i & 2) != 0) {
                messageData = location.getMessageData();
            }
            if ((i & 4) != 0) {
                str = location.c;
            }
            return location.copy(messengerConfig, messageData, str);
        }

        @NotNull
        public final MessengerConfig component1() {
            return getConfig();
        }

        @NotNull
        public final MessageData component2() {
            return getMessageData();
        }

        @NotNull
        public final String component3() {
            return this.c;
        }

        @NotNull
        public final Location copy(@NotNull MessengerConfig messengerConfig, @NotNull MessageData messageData, @NotNull String str) {
            Intrinsics.checkNotNullParameter(messengerConfig, Navigation.CONFIG);
            Intrinsics.checkNotNullParameter(messageData, "messageData");
            Intrinsics.checkNotNullParameter(str, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
            return new Location(messengerConfig, messageData, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Location)) {
                return false;
            }
            Location location = (Location) obj;
            return Intrinsics.areEqual(getConfig(), location.getConfig()) && Intrinsics.areEqual(getMessageData(), location.getMessageData()) && Intrinsics.areEqual(this.c, location.c);
        }

        @NotNull
        public final String getAddress() {
            return this.c;
        }

        @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageContextData
        @NotNull
        public MessengerConfig getConfig() {
            return this.a;
        }

        @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageContextData
        @NotNull
        public MessageData getMessageData() {
            return this.b;
        }

        public int hashCode() {
            MessengerConfig config = getConfig();
            int i = 0;
            int hashCode = (config != null ? config.hashCode() : 0) * 31;
            MessageData messageData = getMessageData();
            int hashCode2 = (hashCode + (messageData != null ? messageData.hashCode() : 0)) * 31;
            String str = this.c;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Location(config=");
            L.append(getConfig());
            L.append(", messageData=");
            L.append(getMessageData());
            L.append(", address=");
            return a.t(L, this.c, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ8\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0014\u0010\nJ\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u000e\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\rR\u001c\u0010\u000f\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0007R\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\n¨\u0006*"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData$Text;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData;", "Lru/avito/messenger/config/MessengerConfig;", "component1", "()Lru/avito/messenger/config/MessengerConfig;", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;", "component2", "()Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;", "", "component3", "()Ljava/lang/String;", "", "component4", "()Z", Navigation.CONFIG, "messageData", "text", "urlsAreTrusted", "copy", "(Lru/avito/messenger/config/MessengerConfig;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;Ljava/lang/String;Z)Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageContextData$Text;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lru/avito/messenger/config/MessengerConfig;", "getConfig", "d", "Z", "getUrlsAreTrusted", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;", "getMessageData", "c", "Ljava/lang/String;", "getText", "<init>", "(Lru/avito/messenger/config/MessengerConfig;Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;Ljava/lang/String;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Text extends MessageContextData {
        @NotNull
        public final MessengerConfig a;
        @NotNull
        public final MessageData b;
        @NotNull
        public final String c;
        public final boolean d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Text(@NotNull MessengerConfig messengerConfig, @NotNull MessageData messageData, @NotNull String str, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(messengerConfig, Navigation.CONFIG);
            Intrinsics.checkNotNullParameter(messageData, "messageData");
            Intrinsics.checkNotNullParameter(str, "text");
            this.a = messengerConfig;
            this.b = messageData;
            this.c = str;
            this.d = z;
        }

        public static /* synthetic */ Text copy$default(Text text, MessengerConfig messengerConfig, MessageData messageData, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                messengerConfig = text.getConfig();
            }
            if ((i & 2) != 0) {
                messageData = text.getMessageData();
            }
            if ((i & 4) != 0) {
                str = text.c;
            }
            if ((i & 8) != 0) {
                z = text.d;
            }
            return text.copy(messengerConfig, messageData, str, z);
        }

        @NotNull
        public final MessengerConfig component1() {
            return getConfig();
        }

        @NotNull
        public final MessageData component2() {
            return getMessageData();
        }

        @NotNull
        public final String component3() {
            return this.c;
        }

        public final boolean component4() {
            return this.d;
        }

        @NotNull
        public final Text copy(@NotNull MessengerConfig messengerConfig, @NotNull MessageData messageData, @NotNull String str, boolean z) {
            Intrinsics.checkNotNullParameter(messengerConfig, Navigation.CONFIG);
            Intrinsics.checkNotNullParameter(messageData, "messageData");
            Intrinsics.checkNotNullParameter(str, "text");
            return new Text(messengerConfig, messageData, str, z);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Text)) {
                return false;
            }
            Text text = (Text) obj;
            return Intrinsics.areEqual(getConfig(), text.getConfig()) && Intrinsics.areEqual(getMessageData(), text.getMessageData()) && Intrinsics.areEqual(this.c, text.c) && this.d == text.d;
        }

        @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageContextData
        @NotNull
        public MessengerConfig getConfig() {
            return this.a;
        }

        @Override // com.avito.android.messenger.conversation.mvi.message_menu.MessageContextData
        @NotNull
        public MessageData getMessageData() {
            return this.b;
        }

        @NotNull
        public final String getText() {
            return this.c;
        }

        public final boolean getUrlsAreTrusted() {
            return this.d;
        }

        public int hashCode() {
            MessengerConfig config = getConfig();
            int i = 0;
            int hashCode = (config != null ? config.hashCode() : 0) * 31;
            MessageData messageData = getMessageData();
            int hashCode2 = (hashCode + (messageData != null ? messageData.hashCode() : 0)) * 31;
            String str = this.c;
            if (str != null) {
                i = str.hashCode();
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

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Text(config=");
            L.append(getConfig());
            L.append(", messageData=");
            L.append(getMessageData());
            L.append(", text=");
            L.append(this.c);
            L.append(", urlsAreTrusted=");
            return a.B(L, this.d, ")");
        }
    }

    public MessageContextData() {
    }

    @NotNull
    public abstract MessengerConfig getConfig();

    @NotNull
    public abstract MessageData getMessageData();

    public MessageContextData(j jVar) {
    }
}
