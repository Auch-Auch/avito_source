package com.avito.android.messenger.analytics;

import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0017B'\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/analytics/MessengerMoveToFolderEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "getEventId", "()I", "eventId", "getVersion", "version", "", "", "getParams", "()Ljava/util/Map;", "params", "channelId", "folderName", "tagName", "Lcom/avito/android/messenger/analytics/MessengerMoveToFolderEvent$MovedFrom;", "movedFrom", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/messenger/analytics/MessengerMoveToFolderEvent$MovedFrom;)V", "MovedFrom", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessengerMoveToFolderEvent implements ClickStreamEvent {
    public final /* synthetic */ ParametrizedClickStreamEvent a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/analytics/MessengerMoveToFolderEvent$MovedFrom;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getCode", "()Ljava/lang/String;", "code", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "CHANNEL_LIST", "CHAT", "BULK", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public enum MovedFrom {
        CHANNEL_LIST("chl"),
        CHAT("c"),
        BULK("gt");
        
        @NotNull
        public final String a;

        /* access modifiers changed from: public */
        MovedFrom(String str) {
            this.a = str;
        }

        @NotNull
        public final String getCode() {
            return this.a;
        }
    }

    public MessengerMoveToFolderEvent(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull MovedFrom movedFrom) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str2, "folderName");
        Intrinsics.checkNotNullParameter(str3, "tagName");
        Intrinsics.checkNotNullParameter(movedFrom, "movedFrom");
        this.a = new ParametrizedClickStreamEvent(4285, 1, r.mapOf(TuplesKt.to("chatid", str), TuplesKt.to("folder_name", str2), TuplesKt.to("tag_name", str3), TuplesKt.to("msg_move_to_folder_from", movedFrom.getCode())), null, 8, null);
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
