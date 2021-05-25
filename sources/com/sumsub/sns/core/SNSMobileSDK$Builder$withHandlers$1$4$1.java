package com.sumsub.sns.core;

import com.sumsub.sns.core.data.listener.SNSActionResultHandler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/sumsub/sns/core/SNSMobileSDK$Builder$withHandlers$1$4$1", "Lcom/sumsub/sns/core/data/listener/SNSActionResultHandler;", "", "actionId", "actionType", "answer", "", "allowContinuing", "Lcom/sumsub/sns/core/SNSActionResult;", "onActionResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/sumsub/sns/core/SNSActionResult;", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class SNSMobileSDK$Builder$withHandlers$1$4$1 implements SNSActionResultHandler {
    public final /* synthetic */ Function2 a;

    public SNSMobileSDK$Builder$withHandlers$1$4$1(Function2 function2) {
        this.a = function2;
    }

    @Override // com.sumsub.sns.core.data.listener.SNSActionResultHandler
    @NotNull
    public SNSActionResult onActionResult(@NotNull String str, @NotNull String str2, @Nullable String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "actionId");
        Intrinsics.checkNotNullParameter(str2, "actionType");
        return (SNSActionResult) this.a.invoke(str, str3);
    }
}
