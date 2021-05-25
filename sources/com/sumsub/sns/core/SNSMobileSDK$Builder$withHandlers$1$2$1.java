package com.sumsub.sns.core;

import com.sumsub.sns.core.data.listener.SNSStateChangedHandler;
import com.sumsub.sns.core.data.model.SNSSDKState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/sumsub/sns/core/SNSMobileSDK$Builder$withHandlers$1$2$1", "Lcom/sumsub/sns/core/data/listener/SNSStateChangedHandler;", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "previousState", "currentState", "", "onStateChanged", "(Lcom/sumsub/sns/core/data/model/SNSSDKState;Lcom/sumsub/sns/core/data/model/SNSSDKState;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class SNSMobileSDK$Builder$withHandlers$1$2$1 implements SNSStateChangedHandler {
    public final /* synthetic */ Function2 a;

    public SNSMobileSDK$Builder$withHandlers$1$2$1(Function2 function2) {
        this.a = function2;
    }

    @Override // com.sumsub.sns.core.data.listener.SNSStateChangedHandler
    public void onStateChanged(@NotNull SNSSDKState sNSSDKState, @NotNull SNSSDKState sNSSDKState2) {
        Intrinsics.checkNotNullParameter(sNSSDKState, "previousState");
        Intrinsics.checkNotNullParameter(sNSSDKState2, "currentState");
        this.a.invoke(sNSSDKState2, sNSSDKState);
    }
}
