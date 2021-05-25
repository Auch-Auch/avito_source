package com.sumsub.sns.core;

import com.sumsub.sns.core.data.listener.SNSEvent;
import com.sumsub.sns.core.data.listener.SNSEventHandler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/sumsub/sns/core/SNSMobileSDK$Builder$withHandlers$1$5$1", "Lcom/sumsub/sns/core/data/listener/SNSEventHandler;", "Lcom/sumsub/sns/core/data/listener/SNSEvent;", "event", "", "onEvent", "(Lcom/sumsub/sns/core/data/listener/SNSEvent;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class SNSMobileSDK$Builder$withHandlers$1$5$1 implements SNSEventHandler {
    public final /* synthetic */ Function1 a;

    public SNSMobileSDK$Builder$withHandlers$1$5$1(Function1 function1) {
        this.a = function1;
    }

    @Override // com.sumsub.sns.core.data.listener.SNSEventHandler
    public void onEvent(@NotNull SNSEvent sNSEvent) {
        Intrinsics.checkNotNullParameter(sNSEvent, "event");
        this.a.invoke(sNSEvent);
    }
}
