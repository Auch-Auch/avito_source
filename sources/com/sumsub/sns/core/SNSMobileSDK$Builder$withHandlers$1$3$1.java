package com.sumsub.sns.core;

import com.sumsub.sns.core.data.listener.SNSCompleteHandler;
import com.sumsub.sns.core.data.model.SNSCompletionResult;
import com.sumsub.sns.core.data.model.SNSSDKState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/sumsub/sns/core/SNSMobileSDK$Builder$withHandlers$1$3$1", "Lcom/sumsub/sns/core/data/listener/SNSCompleteHandler;", "Lcom/sumsub/sns/core/data/model/SNSCompletionResult;", "result", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "state", "", "onComplete", "(Lcom/sumsub/sns/core/data/model/SNSCompletionResult;Lcom/sumsub/sns/core/data/model/SNSSDKState;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class SNSMobileSDK$Builder$withHandlers$1$3$1 implements SNSCompleteHandler {
    public final /* synthetic */ Function2 a;

    public SNSMobileSDK$Builder$withHandlers$1$3$1(Function2 function2) {
        this.a = function2;
    }

    @Override // com.sumsub.sns.core.data.listener.SNSCompleteHandler
    public void onComplete(@NotNull SNSCompletionResult sNSCompletionResult, @NotNull SNSSDKState sNSSDKState) {
        Intrinsics.checkNotNullParameter(sNSCompletionResult, "result");
        Intrinsics.checkNotNullParameter(sNSSDKState, "state");
        this.a.invoke(sNSCompletionResult, sNSSDKState);
    }
}
