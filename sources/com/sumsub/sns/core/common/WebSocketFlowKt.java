package com.sumsub.sns.core.common;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lokhttp3/OkHttpClient;", "httpClient", "", "url", "Lkotlinx/coroutines/flow/Flow;", "webSocketFlow", "(Lokhttp3/OkHttpClient;Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "sns-core_release"}, k = 2, mv = {1, 4, 2})
public final class WebSocketFlowKt {
    @NotNull
    public static final Flow<String> webSocketFlow(@NotNull OkHttpClient okHttpClient, @NotNull String str) {
        Intrinsics.checkNotNullParameter(okHttpClient, "httpClient");
        Intrinsics.checkNotNullParameter(str, "url");
        return FlowKt.callbackFlow(new WebSocketFlowKt$webSocketFlow$1(str, okHttpClient, null));
    }
}
