package com.avito.android.messenger.analytics;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.google.firebase.messaging.Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/avito/android/messenger/analytics/SendMessageAttemptEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "", "getParams", "()Ljava/util/Map;", "params", "", "getVersion", "()I", "version", "getEventId", "eventId", "channelId", "Lcom/avito/android/messenger/analytics/MessageType;", Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE, MessageBody.RANDOM_ID, "", "internetConnection", "networkType", "Lcom/avito/android/messenger/analytics/ServerConnectionType;", "serverConnectionType", "<init>", "(Ljava/lang/String;Lcom/avito/android/messenger/analytics/MessageType;Ljava/lang/String;ZLjava/lang/String;Lcom/avito/android/messenger/analytics/ServerConnectionType;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class SendMessageAttemptEvent implements ClickStreamEvent {
    public final /* synthetic */ ParametrizedClickStreamEvent a;

    public SendMessageAttemptEvent(@NotNull String str, @NotNull MessageType messageType, @NotNull String str2, boolean z, @NotNull String str3, @NotNull ServerConnectionType serverConnectionType) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(messageType, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        Intrinsics.checkNotNullParameter(str2, MessageBody.RANDOM_ID);
        Intrinsics.checkNotNullParameter(str3, "networkType");
        Intrinsics.checkNotNullParameter(serverConnectionType, "serverConnectionType");
        this.a = new ParametrizedClickStreamEvent(3477, 0, r.mapOf(TuplesKt.to("chatid", str), TuplesKt.to(Constants.MessagePayloadKeys.MESSAGE_TYPE, messageType.getStr()), TuplesKt.to("msg_random_id", str2), TuplesKt.to("msg_internet_connection", Boolean.valueOf(z)), TuplesKt.to("network_type", str3), TuplesKt.to("msg_socket_type", Integer.valueOf(serverConnectionType.getId()))), null, 8, null);
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return this.a.description();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getEventId() {
        return this.a.getEventId();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public Map<String, Object> getParams() {
        return this.a.getParams();
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    public int getVersion() {
        return this.a.getVersion();
    }
}
