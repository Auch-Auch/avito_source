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
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/analytics/SendMessageEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "<init>", "()V", "Retry", BaseAnalyticKt.ANALYTIC_ACTION_SEND, "Lcom/avito/android/messenger/analytics/SendMessageEvent$Send;", "Lcom/avito/android/messenger/analytics/SendMessageEvent$Retry;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class SendMessageEvent implements ClickStreamEvent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/avito/android/messenger/analytics/SendMessageEvent$Retry;", "Lcom/avito/android/messenger/analytics/SendMessageEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "getVersion", "()I", "version", "getEventId", "eventId", "", "", "getParams", "()Ljava/util/Map;", "params", "channelId", "Lcom/avito/android/messenger/analytics/MessageType;", Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE, MessageBody.RANDOM_ID, "", "isFromPush", "<init>", "(Ljava/lang/String;Lcom/avito/android/messenger/analytics/MessageType;Ljava/lang/String;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Retry extends SendMessageEvent implements ClickStreamEvent {
        public final /* synthetic */ ParametrizedClickStreamEvent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Retry(@NotNull String str, @NotNull MessageType messageType, @NotNull String str2, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "channelId");
            Intrinsics.checkNotNullParameter(messageType, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
            Intrinsics.checkNotNullParameter(str2, MessageBody.RANDOM_ID);
            this.a = new ParametrizedClickStreamEvent(3177, 1, r.mapOf(TuplesKt.to("chatid", str), TuplesKt.to(Constants.MessagePayloadKeys.MESSAGE_TYPE, messageType.getStr()), TuplesKt.to("msg_random_id", str2), TuplesKt.to("msg_is_push", Boolean.valueOf(z))), null, 8, null);
        }

        @Override // com.avito.android.messenger.analytics.SendMessageEvent, com.avito.android.analytics.provider.clickstream.ClickStreamEvent
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/analytics/SendMessageEvent$Send;", "Lcom/avito/android/messenger/analytics/SendMessageEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "", "getParams", "()Ljava/util/Map;", "params", "", "getEventId", "()I", "eventId", "getVersion", "version", "channelId", "Lcom/avito/android/messenger/analytics/MessageType;", Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE, "", "isFromPush", "<init>", "(Ljava/lang/String;Lcom/avito/android/messenger/analytics/MessageType;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Send extends SendMessageEvent implements ClickStreamEvent {
        public final /* synthetic */ ParametrizedClickStreamEvent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Send(@NotNull String str, @NotNull MessageType messageType, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "channelId");
            Intrinsics.checkNotNullParameter(messageType, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
            this.a = new ParametrizedClickStreamEvent(3176, 3, r.mapOf(TuplesKt.to("chatid", str), TuplesKt.to(Constants.MessagePayloadKeys.MESSAGE_TYPE, messageType.getStr()), TuplesKt.to("msg_is_push", Boolean.valueOf(z))), null, 8, null);
        }

        @Override // com.avito.android.messenger.analytics.SendMessageEvent, com.avito.android.analytics.provider.clickstream.ClickStreamEvent
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

    public SendMessageEvent() {
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return ClickStreamEvent.DefaultImpls.description(this);
    }

    public SendMessageEvent(j jVar) {
    }
}
