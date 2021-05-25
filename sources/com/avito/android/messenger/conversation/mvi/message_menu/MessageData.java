package com.avito.android.messenger.conversation.mvi.message_menu;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.messenger.analytics.MessageType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.MessageBody;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u001d\b\b\u0018\u0000 ;2\u00020\u0001:\u0001;BQ\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\f\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u0012\u0006\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b9\u0010:J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000bJl\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004J\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010#\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0019\u0010\u001a\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0011R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u0004R\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010)\u001a\u0004\b,\u0010\u0004R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010)\u001a\u0004\b.\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010)\u001a\u0004\b0\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010)\u001a\u0004\b2\u0010\u0004R\u0019\u0010\u001b\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b\u001b\u0010\u000bR\u0019\u0010\u0018\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b5\u00104\u001a\u0004\b\u0018\u0010\u000bR\u0019\u0010\u0019\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u0010\u000e¨\u0006<"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "", "component6", "()Z", "", "component7", "()J", "Lcom/avito/android/messenger/analytics/MessageType;", "component8", "()Lcom/avito/android/messenger/analytics/MessageType;", "component9", ChannelContext.Item.USER_ID, "channelId", "localId", "fromId", "remoteId", "isFailed", "created", "type", "isSentByUserDirectly", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJLcom/avito/android/messenger/analytics/MessageType;Z)Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "h", "Lcom/avito/android/messenger/analytics/MessageType;", "getType", "e", "Ljava/lang/String;", "getRemoteId", "c", "getLocalId", "d", "getFromId", AuthSource.SEND_ABUSE, "getUserId", AuthSource.BOOKING_ORDER, "getChannelId", "i", "Z", "f", g.a, "J", "getCreated", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJLcom/avito/android/messenger/analytics/MessageType;Z)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessageData {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @Nullable
    public final String e;
    public final boolean f;
    public final long g;
    @NotNull
    public final MessageType h;
    public final boolean i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData$Companion;", "", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "message", "Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;", "from", "(Lcom/avito/android/remote/model/messenger/message/LocalMessage;)Lcom/avito/android/messenger/conversation/mvi/message_menu/MessageData;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final MessageData from(@NotNull LocalMessage localMessage) {
            MessageType messageType;
            Intrinsics.checkNotNullParameter(localMessage, "message");
            String str = localMessage.userId;
            String str2 = localMessage.channelId;
            String str3 = localMessage.localId;
            String str4 = localMessage.fromId;
            String str5 = localMessage.remoteId;
            boolean z = localMessage.isFailed;
            long j = localMessage.created;
            MessageBody messageBody = localMessage.body;
            if ((messageBody instanceof MessageBody.ItemReference) || (messageBody instanceof MessageBody.Item)) {
                messageType = MessageType.ITEM;
            } else if ((messageBody instanceof MessageBody.LocalImage) || (messageBody instanceof MessageBody.ImageReference) || (messageBody instanceof MessageBody.ImageBody)) {
                messageType = MessageType.IMAGE;
            } else if (messageBody instanceof MessageBody.Link) {
                messageType = MessageType.LINK;
            } else if (messageBody instanceof MessageBody.Location) {
                messageType = MessageType.GEO;
            } else if (messageBody instanceof MessageBody.Text.Regular) {
                Objects.requireNonNull(messageBody, "null cannot be cast to non-null type com.avito.android.remote.model.messenger.message.MessageBody.Text.Regular");
                if (((MessageBody.Text.Regular) messageBody).getSuggestedTemplates() != null) {
                    messageType = MessageType.SUGGEST;
                } else {
                    messageType = MessageType.TEXT;
                }
            } else if (messageBody instanceof MessageBody.File) {
                messageType = MessageType.FILE;
            } else if (!(messageBody instanceof MessageBody.Text.Reaction) && !(messageBody instanceof MessageBody.Call) && !(messageBody instanceof MessageBody.AppCall) && !(messageBody instanceof MessageBody.Deleted) && !(messageBody instanceof MessageBody.Unknown) && !(messageBody instanceof MessageBody.SystemMessageBody.Platform) && !(messageBody instanceof MessageBody.SystemMessageBody.Text) && !(messageBody instanceof MessageBody.SystemMessageBody.Unknown)) {
                throw new NoWhenBranchMatchedException();
            } else {
                messageType = MessageType.TEXT;
            }
            MessageBody messageBody2 = localMessage.body;
            return new MessageData(str, str2, str3, str4, str5, z, j, messageType, !(messageBody2 instanceof MessageBody.SystemMessageBody.Platform) && !(messageBody2 instanceof MessageBody.Text.Reaction));
        }

        public Companion(j jVar) {
        }
    }

    public MessageData(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable String str5, boolean z, long j, @NotNull MessageType messageType, boolean z2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, "localId");
        Intrinsics.checkNotNullParameter(str4, "fromId");
        Intrinsics.checkNotNullParameter(messageType, "type");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = z;
        this.g = j;
        this.h = messageType;
        this.i = z2;
    }

    public static /* synthetic */ MessageData copy$default(MessageData messageData, String str, String str2, String str3, String str4, String str5, boolean z, long j, MessageType messageType, boolean z2, int i2, Object obj) {
        return messageData.copy((i2 & 1) != 0 ? messageData.a : str, (i2 & 2) != 0 ? messageData.b : str2, (i2 & 4) != 0 ? messageData.c : str3, (i2 & 8) != 0 ? messageData.d : str4, (i2 & 16) != 0 ? messageData.e : str5, (i2 & 32) != 0 ? messageData.f : z, (i2 & 64) != 0 ? messageData.g : j, (i2 & 128) != 0 ? messageData.h : messageType, (i2 & 256) != 0 ? messageData.i : z2);
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
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final String component4() {
        return this.d;
    }

    @Nullable
    public final String component5() {
        return this.e;
    }

    public final boolean component6() {
        return this.f;
    }

    public final long component7() {
        return this.g;
    }

    @NotNull
    public final MessageType component8() {
        return this.h;
    }

    public final boolean component9() {
        return this.i;
    }

    @NotNull
    public final MessageData copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable String str5, boolean z, long j, @NotNull MessageType messageType, boolean z2) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(str3, "localId");
        Intrinsics.checkNotNullParameter(str4, "fromId");
        Intrinsics.checkNotNullParameter(messageType, "type");
        return new MessageData(str, str2, str3, str4, str5, z, j, messageType, z2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageData)) {
            return false;
        }
        MessageData messageData = (MessageData) obj;
        return Intrinsics.areEqual(this.a, messageData.a) && Intrinsics.areEqual(this.b, messageData.b) && Intrinsics.areEqual(this.c, messageData.c) && Intrinsics.areEqual(this.d, messageData.d) && Intrinsics.areEqual(this.e, messageData.e) && this.f == messageData.f && this.g == messageData.g && Intrinsics.areEqual(this.h, messageData.h) && this.i == messageData.i;
    }

    @NotNull
    public final String getChannelId() {
        return this.b;
    }

    public final long getCreated() {
        return this.g;
    }

    @NotNull
    public final String getFromId() {
        return this.d;
    }

    @NotNull
    public final String getLocalId() {
        return this.c;
    }

    @Nullable
    public final String getRemoteId() {
        return this.e;
    }

    @NotNull
    public final MessageType getType() {
        return this.h;
    }

    @NotNull
    public final String getUserId() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.e;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        boolean z = this.f;
        int i3 = 1;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int a3 = (((hashCode5 + i4) * 31) + c.a(this.g)) * 31;
        MessageType messageType = this.h;
        if (messageType != null) {
            i2 = messageType.hashCode();
        }
        int i7 = (a3 + i2) * 31;
        boolean z2 = this.i;
        if (!z2) {
            i3 = z2 ? 1 : 0;
        }
        return i7 + i3;
    }

    public final boolean isFailed() {
        return this.f;
    }

    public final boolean isSentByUserDirectly() {
        return this.i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("MessageData(userId=");
        L.append(this.a);
        L.append(", channelId=");
        L.append(this.b);
        L.append(", localId=");
        L.append(this.c);
        L.append(", fromId=");
        L.append(this.d);
        L.append(", remoteId=");
        L.append(this.e);
        L.append(", isFailed=");
        L.append(this.f);
        L.append(", created=");
        L.append(this.g);
        L.append(", type=");
        L.append(this.h);
        L.append(", isSentByUserDirectly=");
        return a.B(L, this.i, ")");
    }
}
