package com.sumsub.sns.core.data.listener;

import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u0017\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSEvent;", "", "getPayloadAsJson", "(Lcom/sumsub/sns/core/data/listener/SNSEvent;)Ljava/lang/String;", "payloadAsJson", "sns-core_release"}, k = 2, mv = {1, 4, 2})
public final class SNSEventHandlerKt {
    @NotNull
    public static final String getPayloadAsJson(@NotNull SNSEvent sNSEvent) {
        Intrinsics.checkNotNullParameter(sNSEvent, "$this$payloadAsJson");
        String json = new Gson().toJson(sNSEvent.getPayload());
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(this.payload)");
        return json;
    }
}
