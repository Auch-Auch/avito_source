package ru.avito.messenger.api.entity;

import a2.b.a.a.a;
import com.avito.android.remote.model.messenger.PlatformSupport;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.ChannelEntity;
import ru.avito.messenger.api.entity.body.MessageBody;
import ru.avito.messenger.api.entity.event.UserChatEvent;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u001a\b\b\u0018\u00002\u00020\u0001:\u0002EFBg\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0007\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u000b\u0012\u0006\u0010\"\u001a\u00020\u000e\u0012\b\u0010#\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\bC\u0010DJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0001\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020\u000e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0019HÆ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b)\u0010\u0004J\u0010\u0010+\u001a\u00020*HÖ\u0001¢\u0006\u0004\b+\u0010,J\u001a\u0010/\u001a\u00020\u000e2\b\u0010.\u001a\u0004\u0018\u00010-HÖ\u0003¢\u0006\u0004\b/\u00100R\u001b\u0010%\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b%\u00101\u001a\u0004\b2\u0010\u0018R\u001b\u0010#\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b#\u00103\u001a\u0004\b4\u0010\u0012R\u0019\u0010\u001d\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00105\u001a\u0004\b6\u0010\u0004R\u001c\u0010 \u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u00105\u001a\u0004\b7\u0010\u0004R\u0019\u0010!\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b!\u00108\u001a\u0004\b9\u0010\rR\u0019\u0010\u001f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010:\u001a\u0004\b;\u0010\tR\u001c\u0010\u001e\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u00105\u001a\u0004\b<\u0010\u0004R\u0019\u0010\"\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010=\u001a\u0004\b\"\u0010\u0010R\u001b\u0010&\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010>\u001a\u0004\b?\u0010\u001bR\u0019\u0010\u001c\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00105\u001a\u0004\b@\u0010\u0004R\u001b\u0010$\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010A\u001a\u0004\bB\u0010\u0015¨\u0006G"}, d2 = {"Lru/avito/messenger/api/entity/ChatMessage;", "Lru/avito/messenger/api/entity/event/UserChatEvent;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Lru/avito/messenger/api/entity/body/MessageBody;", "component4", "()Lru/avito/messenger/api/entity/body/MessageBody;", "component5", "", "component6", "()J", "", "component7", "()Z", "component8", "()Ljava/lang/Long;", "Lru/avito/messenger/api/entity/ChatMessage$PartialChannel;", "component9", "()Lru/avito/messenger/api/entity/ChatMessage$PartialChannel;", "Lru/avito/messenger/api/entity/ChatMessage$Preview;", "component10", "()Lru/avito/messenger/api/entity/ChatMessage$Preview;", "Lcom/avito/android/remote/model/messenger/PlatformSupport;", "component11", "()Lcom/avito/android/remote/model/messenger/PlatformSupport;", "id", "uid", "channelId", SDKConstants.PARAM_A2U_BODY, "fromId", "created", "isRead", "readTimeStamp", "channel", "preview", PlatformActions.PLATFORM_SUPPORT, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/avito/messenger/api/entity/body/MessageBody;Ljava/lang/String;JZLjava/lang/Long;Lru/avito/messenger/api/entity/ChatMessage$PartialChannel;Lru/avito/messenger/api/entity/ChatMessage$Preview;Lcom/avito/android/remote/model/messenger/PlatformSupport;)Lru/avito/messenger/api/entity/ChatMessage;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lru/avito/messenger/api/entity/ChatMessage$Preview;", "getPreview", "Ljava/lang/Long;", "getReadTimeStamp", "Ljava/lang/String;", "getUid", "getFromId", "J", "getCreated", "Lru/avito/messenger/api/entity/body/MessageBody;", "getBody", "getChannelId", "Z", "Lcom/avito/android/remote/model/messenger/PlatformSupport;", "getPlatformSupport", "getId", "Lru/avito/messenger/api/entity/ChatMessage$PartialChannel;", "getChannel", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/avito/messenger/api/entity/body/MessageBody;Ljava/lang/String;JZLjava/lang/Long;Lru/avito/messenger/api/entity/ChatMessage$PartialChannel;Lru/avito/messenger/api/entity/ChatMessage$Preview;Lcom/avito/android/remote/model/messenger/PlatformSupport;)V", "PartialChannel", "Preview", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChatMessage implements UserChatEvent {
    @NotNull
    public final MessageBody body;
    @Nullable
    public final PartialChannel channel;
    @NotNull
    public final String channelId;
    public final long created;
    @NotNull
    public final String fromId;
    @NotNull
    public final String id;
    public final boolean isRead;
    @Nullable
    public final PlatformSupport platformSupport;
    @Nullable
    public final Preview preview;
    @Nullable
    public final Long readTimeStamp;
    @NotNull
    public final String uid;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R$\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\bR\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lru/avito/messenger/api/entity/ChatMessage$PartialChannel;", "", "", "component1", "()J", "", "", "component2", "()Ljava/util/List;", ChannelEntity.COLUMN_UPDATED, "tags", "copy", "(JLjava/util/List;)Lru/avito/messenger/api/entity/ChatMessage$PartialChannel;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getTags", "J", "getUpdated", "<init>", "(JLjava/util/List;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class PartialChannel {
        @SerializedName("tags")
        @Nullable
        private final List<String> tags;
        @SerializedName(ChannelEntity.COLUMN_UPDATED)
        private final long updated;

        public PartialChannel(long j, @Nullable List<String> list) {
            this.updated = j;
            this.tags = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.avito.messenger.api.entity.ChatMessage$PartialChannel */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PartialChannel copy$default(PartialChannel partialChannel, long j, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                j = partialChannel.updated;
            }
            if ((i & 2) != 0) {
                list = partialChannel.tags;
            }
            return partialChannel.copy(j, list);
        }

        public final long component1() {
            return this.updated;
        }

        @Nullable
        public final List<String> component2() {
            return this.tags;
        }

        @NotNull
        public final PartialChannel copy(long j, @Nullable List<String> list) {
            return new PartialChannel(j, list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PartialChannel)) {
                return false;
            }
            PartialChannel partialChannel = (PartialChannel) obj;
            return this.updated == partialChannel.updated && Intrinsics.areEqual(this.tags, partialChannel.tags);
        }

        @Nullable
        public final List<String> getTags() {
            return this.tags;
        }

        public final long getUpdated() {
            return this.updated;
        }

        public int hashCode() {
            int a = c.a(this.updated) * 31;
            List<String> list = this.tags;
            return a + (list != null ? list.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("PartialChannel(updated=");
            L.append(this.updated);
            L.append(", tags=");
            return a.w(L, this.tags, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004¨\u0006\u0014"}, d2 = {"Lru/avito/messenger/api/entity/ChatMessage$Preview;", "", "", "component1", "()Ljava/lang/String;", "text", "copy", "(Ljava/lang/String;)Lru/avito/messenger/api/entity/ChatMessage$Preview;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getText", "<init>", "(Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Preview {
        @SerializedName("text")
        @NotNull
        private final String text;

        public Preview(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            this.text = str;
        }

        public static /* synthetic */ Preview copy$default(Preview preview, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = preview.text;
            }
            return preview.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.text;
        }

        @NotNull
        public final Preview copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            return new Preview(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Preview) && Intrinsics.areEqual(this.text, ((Preview) obj).text);
            }
            return true;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            String str = this.text;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return a.t(a.L("Preview(text="), this.text, ")");
        }
    }

    public ChatMessage(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull MessageBody messageBody, @NotNull String str4, long j, boolean z, @Nullable Long l, @Nullable PartialChannel partialChannel, @Nullable Preview preview2, @Nullable PlatformSupport platformSupport2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "uid");
        Intrinsics.checkNotNullParameter(str3, "channelId");
        Intrinsics.checkNotNullParameter(messageBody, SDKConstants.PARAM_A2U_BODY);
        Intrinsics.checkNotNullParameter(str4, "fromId");
        this.id = str;
        this.uid = str2;
        this.channelId = str3;
        this.body = messageBody;
        this.fromId = str4;
        this.created = j;
        this.isRead = z;
        this.readTimeStamp = l;
        this.channel = partialChannel;
        this.preview = preview2;
        this.platformSupport = platformSupport2;
    }

    public static /* synthetic */ ChatMessage copy$default(ChatMessage chatMessage, String str, String str2, String str3, MessageBody messageBody, String str4, long j, boolean z, Long l, PartialChannel partialChannel, Preview preview2, PlatformSupport platformSupport2, int i, Object obj) {
        return chatMessage.copy((i & 1) != 0 ? chatMessage.id : str, (i & 2) != 0 ? chatMessage.uid : str2, (i & 4) != 0 ? chatMessage.getChannelId() : str3, (i & 8) != 0 ? chatMessage.body : messageBody, (i & 16) != 0 ? chatMessage.getFromId() : str4, (i & 32) != 0 ? chatMessage.created : j, (i & 64) != 0 ? chatMessage.isRead : z, (i & 128) != 0 ? chatMessage.readTimeStamp : l, (i & 256) != 0 ? chatMessage.channel : partialChannel, (i & 512) != 0 ? chatMessage.preview : preview2, (i & 1024) != 0 ? chatMessage.platformSupport : platformSupport2);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @Nullable
    public final Preview component10() {
        return this.preview;
    }

    @Nullable
    public final PlatformSupport component11() {
        return this.platformSupport;
    }

    @NotNull
    public final String component2() {
        return this.uid;
    }

    @NotNull
    public final String component3() {
        return getChannelId();
    }

    @NotNull
    public final MessageBody component4() {
        return this.body;
    }

    @NotNull
    public final String component5() {
        return getFromId();
    }

    public final long component6() {
        return this.created;
    }

    public final boolean component7() {
        return this.isRead;
    }

    @Nullable
    public final Long component8() {
        return this.readTimeStamp;
    }

    @Nullable
    public final PartialChannel component9() {
        return this.channel;
    }

    @NotNull
    public final ChatMessage copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull MessageBody messageBody, @NotNull String str4, long j, boolean z, @Nullable Long l, @Nullable PartialChannel partialChannel, @Nullable Preview preview2, @Nullable PlatformSupport platformSupport2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "uid");
        Intrinsics.checkNotNullParameter(str3, "channelId");
        Intrinsics.checkNotNullParameter(messageBody, SDKConstants.PARAM_A2U_BODY);
        Intrinsics.checkNotNullParameter(str4, "fromId");
        return new ChatMessage(str, str2, str3, messageBody, str4, j, z, l, partialChannel, preview2, platformSupport2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatMessage)) {
            return false;
        }
        ChatMessage chatMessage = (ChatMessage) obj;
        return Intrinsics.areEqual(this.id, chatMessage.id) && Intrinsics.areEqual(this.uid, chatMessage.uid) && Intrinsics.areEqual(getChannelId(), chatMessage.getChannelId()) && Intrinsics.areEqual(this.body, chatMessage.body) && Intrinsics.areEqual(getFromId(), chatMessage.getFromId()) && this.created == chatMessage.created && this.isRead == chatMessage.isRead && Intrinsics.areEqual(this.readTimeStamp, chatMessage.readTimeStamp) && Intrinsics.areEqual(this.channel, chatMessage.channel) && Intrinsics.areEqual(this.preview, chatMessage.preview) && Intrinsics.areEqual(this.platformSupport, chatMessage.platformSupport);
    }

    @NotNull
    public final MessageBody getBody() {
        return this.body;
    }

    @Nullable
    public final PartialChannel getChannel() {
        return this.channel;
    }

    @Override // ru.avito.messenger.api.entity.event.UserChatEvent, ru.avito.messenger.api.entity.event.ChatEvent
    @NotNull
    public String getChannelId() {
        return this.channelId;
    }

    public final long getCreated() {
        return this.created;
    }

    @Override // ru.avito.messenger.api.entity.event.UserChatEvent
    @NotNull
    public String getFromId() {
        return this.fromId;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final PlatformSupport getPlatformSupport() {
        return this.platformSupport;
    }

    @Nullable
    public final Preview getPreview() {
        return this.preview;
    }

    @Nullable
    public final Long getReadTimeStamp() {
        return this.readTimeStamp;
    }

    @NotNull
    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.uid;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String channelId2 = getChannelId();
        int hashCode3 = (hashCode2 + (channelId2 != null ? channelId2.hashCode() : 0)) * 31;
        MessageBody messageBody = this.body;
        int hashCode4 = (hashCode3 + (messageBody != null ? messageBody.hashCode() : 0)) * 31;
        String fromId2 = getFromId();
        int hashCode5 = (((hashCode4 + (fromId2 != null ? fromId2.hashCode() : 0)) * 31) + c.a(this.created)) * 31;
        boolean z = this.isRead;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode5 + i2) * 31;
        Long l = this.readTimeStamp;
        int hashCode6 = (i5 + (l != null ? l.hashCode() : 0)) * 31;
        PartialChannel partialChannel = this.channel;
        int hashCode7 = (hashCode6 + (partialChannel != null ? partialChannel.hashCode() : 0)) * 31;
        Preview preview2 = this.preview;
        int hashCode8 = (hashCode7 + (preview2 != null ? preview2.hashCode() : 0)) * 31;
        PlatformSupport platformSupport2 = this.platformSupport;
        if (platformSupport2 != null) {
            i = platformSupport2.hashCode();
        }
        return hashCode8 + i;
    }

    public final boolean isRead() {
        return this.isRead;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ChatMessage(id=");
        L.append(this.id);
        L.append(", uid=");
        L.append(this.uid);
        L.append(", channelId=");
        L.append(getChannelId());
        L.append(", body=");
        L.append(this.body);
        L.append(", fromId=");
        L.append(getFromId());
        L.append(", created=");
        L.append(this.created);
        L.append(", isRead=");
        L.append(this.isRead);
        L.append(", readTimeStamp=");
        L.append(this.readTimeStamp);
        L.append(", channel=");
        L.append(this.channel);
        L.append(", preview=");
        L.append(this.preview);
        L.append(", platformSupport=");
        L.append(this.platformSupport);
        L.append(")");
        return L.toString();
    }
}
