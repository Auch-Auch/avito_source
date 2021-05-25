package com.avito.android.messenger.conversation.mvi.messages;

import a2.b.a.a.a;
import com.avito.android.messenger.conversation.ChannelItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0004¨\u0006#"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/messages/LinkMenuData;", "", "Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;", "component1", "()Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "component2", "()Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "", "component3", "()Ljava/lang/String;", "bodyOrBubble", "localMessage", "url", "copy", "(Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;Lcom/avito/android/remote/model/messenger/message/LocalMessage;Ljava/lang/String;)Lcom/avito/android/messenger/conversation/mvi/messages/LinkMenuData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/String;", "getUrl", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "getLocalMessage", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;", "getBodyOrBubble", "<init>", "(Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;Lcom/avito/android/remote/model/messenger/message/LocalMessage;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class LinkMenuData {
    @NotNull
    public final ChannelItem.Message.BodyOrBubble a;
    @NotNull
    public final LocalMessage b;
    @NotNull
    public final String c;

    public LinkMenuData(@NotNull ChannelItem.Message.BodyOrBubble bodyOrBubble, @NotNull LocalMessage localMessage, @NotNull String str) {
        Intrinsics.checkNotNullParameter(bodyOrBubble, "bodyOrBubble");
        Intrinsics.checkNotNullParameter(localMessage, "localMessage");
        Intrinsics.checkNotNullParameter(str, "url");
        this.a = bodyOrBubble;
        this.b = localMessage;
        this.c = str;
    }

    public static /* synthetic */ LinkMenuData copy$default(LinkMenuData linkMenuData, ChannelItem.Message.BodyOrBubble bodyOrBubble, LocalMessage localMessage, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            bodyOrBubble = linkMenuData.a;
        }
        if ((i & 2) != 0) {
            localMessage = linkMenuData.b;
        }
        if ((i & 4) != 0) {
            str = linkMenuData.c;
        }
        return linkMenuData.copy(bodyOrBubble, localMessage, str);
    }

    @NotNull
    public final ChannelItem.Message.BodyOrBubble component1() {
        return this.a;
    }

    @NotNull
    public final LocalMessage component2() {
        return this.b;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final LinkMenuData copy(@NotNull ChannelItem.Message.BodyOrBubble bodyOrBubble, @NotNull LocalMessage localMessage, @NotNull String str) {
        Intrinsics.checkNotNullParameter(bodyOrBubble, "bodyOrBubble");
        Intrinsics.checkNotNullParameter(localMessage, "localMessage");
        Intrinsics.checkNotNullParameter(str, "url");
        return new LinkMenuData(bodyOrBubble, localMessage, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LinkMenuData)) {
            return false;
        }
        LinkMenuData linkMenuData = (LinkMenuData) obj;
        return Intrinsics.areEqual(this.a, linkMenuData.a) && Intrinsics.areEqual(this.b, linkMenuData.b) && Intrinsics.areEqual(this.c, linkMenuData.c);
    }

    @NotNull
    public final ChannelItem.Message.BodyOrBubble getBodyOrBubble() {
        return this.a;
    }

    @NotNull
    public final LocalMessage getLocalMessage() {
        return this.b;
    }

    @NotNull
    public final String getUrl() {
        return this.c;
    }

    public int hashCode() {
        ChannelItem.Message.BodyOrBubble bodyOrBubble = this.a;
        int i = 0;
        int hashCode = (bodyOrBubble != null ? bodyOrBubble.hashCode() : 0) * 31;
        LocalMessage localMessage = this.b;
        int hashCode2 = (hashCode + (localMessage != null ? localMessage.hashCode() : 0)) * 31;
        String str = this.c;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("LinkMenuData(bodyOrBubble=");
        L.append(this.a);
        L.append(", localMessage=");
        L.append(this.b);
        L.append(", url=");
        return a.t(L, this.c, ")");
    }
}
