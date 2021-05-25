package com.avito.android.messenger.analytics;

import a2.b.a.a.a;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.app.task.MessageSendingFatalException;
import com.avito.android.communications_common.analytics.SimpleErrorTracker;
import com.avito.android.messenger.conversation.mvi.data.MessengerDbException;
import com.facebook.applinks.AppLinkData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.connection.MessengerSocketTerminationException;
import ru.avito.messenger.internal.entity.jsonrpc.MessengerJsonRpcCallException;
import ru.avito.messenger.internal.entity.jsonrpc.MessengerJsonRpcParsingException;
import ru.avito.messenger.internal.entity.jsonrpc.MessengerSocketResponseTimeoutException;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ5\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/analytics/MessengerErrorTracker;", "Lcom/avito/android/communications_common/analytics/SimpleErrorTracker;", "", "cause", "", "message", "", "", AppLinkData.ARGUMENTS_EXTRAS_KEY, "", "track", "(Ljava/lang/Throwable;Ljava/lang/String;Ljava/util/Map;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/analytics/Analytics;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessengerErrorTracker extends SimpleErrorTracker {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessengerErrorTracker(@NotNull Analytics analytics) {
        super(analytics);
        Intrinsics.checkNotNullParameter(analytics, "analytics");
    }

    @Override // com.avito.android.communications_common.analytics.SimpleErrorTracker, com.avito.android.communications_common.analytics.ErrorTracker
    public void track(@NotNull Throwable th, @Nullable String str, @NotNull Map<String, ? extends Object> map) {
        String str2;
        Intrinsics.checkNotNullParameter(th, "cause");
        Intrinsics.checkNotNullParameter(map, AppLinkData.ARGUMENTS_EXTRAS_KEY);
        super.track(th, str, map);
        if (th instanceof MessengerSocketTerminationException) {
            str2 = "socket_connection";
        } else if (th instanceof MessengerSocketResponseTimeoutException) {
            str2 = "socket_response_timeout";
        } else if (th instanceof MessengerJsonRpcCallException) {
            str2 = "api";
        } else if (th instanceof MessengerJsonRpcParsingException) {
            str2 = "response_parsing";
        } else if (th instanceof MessengerDbException) {
            str2 = "storage";
        } else if (th instanceof MessageSendingFatalException) {
            str2 = "message_sending";
        } else {
            return;
        }
        getAnalytics().track(new StatsdEvent.CountEvent(a.c3("messenger.client_error.", str2), 0, 2, null));
        if ((th instanceof MessengerDbException) && ((MessengerDbException) th).getDbFileDeleted()) {
            getAnalytics().track(new StatsdEvent.CountEvent("messenger.client_error.storage_reset", 0, 2, null));
        }
    }
}
