package a2.a.a.s1;

import com.avito.android.passport_verification.SumsubVerificationActivity;
import com.sumsub.sns.core.data.model.SNSCompletionResult;
import com.sumsub.sns.core.data.model.SNSSDKState;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class e extends Lambda implements Function2<SNSCompletionResult, SNSSDKState, Unit> {
    public final /* synthetic */ SumsubVerificationActivity a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(SumsubVerificationActivity sumsubVerificationActivity) {
        super(2);
        this.a = sumsubVerificationActivity;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(SNSCompletionResult sNSCompletionResult, SNSSDKState sNSSDKState) {
        SNSCompletionResult sNSCompletionResult2 = sNSCompletionResult;
        SNSSDKState sNSSDKState2 = sNSSDKState;
        Intrinsics.checkNotNullParameter(sNSCompletionResult2, "result");
        Intrinsics.checkNotNullParameter(sNSSDKState2, "state");
        if (sNSCompletionResult2 instanceof SNSCompletionResult.AbnormalTermination) {
            this.a.getModel().onSdkError(((SNSCompletionResult.AbnormalTermination) sNSCompletionResult2).getException(), sNSSDKState2);
        } else if (sNSCompletionResult2 instanceof SNSCompletionResult.SuccessTermination) {
            this.a.getModel().onSdkSuccess(sNSSDKState2);
        }
        return Unit.INSTANCE;
    }
}
