package ru.avito.messenger.internal.jsonrpc;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.RpcRequestEvent;
import com.avito.android.jsonrpc.client.JsonRpcInterceptor;
import com.avito.android.jsonrpc.client.RpcRequest;
import com.avito.android.remote.NetworkRequestEventId;
import com.avito.android.remote.auth.AuthSource;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.RequestIdHolder;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lru/avito/messenger/internal/jsonrpc/JsonRpcCallAnalyticsInterceptor;", "Lcom/avito/android/jsonrpc/client/JsonRpcInterceptor;", "Lcom/avito/android/jsonrpc/client/RpcRequest;", "request", "Ljava/lang/reflect/Method;", "method", "", "intercept", "(Lcom/avito/android/jsonrpc/client/RpcRequest;Ljava/lang/reflect/Method;)V", "Lcom/avito/android/analytics/Analytics;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lru/avito/messenger/RequestIdHolder;", AuthSource.BOOKING_ORDER, "Lru/avito/messenger/RequestIdHolder;", "requestIdHolder", "<init>", "(Lcom/avito/android/analytics/Analytics;Lru/avito/messenger/RequestIdHolder;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class JsonRpcCallAnalyticsInterceptor implements JsonRpcInterceptor {
    public final Analytics a;
    public final RequestIdHolder b;

    public JsonRpcCallAnalyticsInterceptor(@NotNull Analytics analytics, @NotNull RequestIdHolder requestIdHolder) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(requestIdHolder, "requestIdHolder");
        this.a = analytics;
        this.b = requestIdHolder;
    }

    @Override // com.avito.android.jsonrpc.client.JsonRpcInterceptor
    public void intercept(@NotNull RpcRequest rpcRequest, @NotNull Method method) {
        Intrinsics.checkNotNullParameter(rpcRequest, "request");
        Intrinsics.checkNotNullParameter(method, "method");
        NetworkRequestEventId networkRequestEventId = (NetworkRequestEventId) method.getAnnotation(NetworkRequestEventId.class);
        if (networkRequestEventId != null) {
            int eventId = networkRequestEventId.eventId();
            this.a.track(new RpcRequestEvent(eventId, this.b.getRequestId() + '#' + rpcRequest.getId()));
        }
    }
}
