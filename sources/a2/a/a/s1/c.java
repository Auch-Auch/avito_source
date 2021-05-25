package a2.a.a.s1;

import com.avito.android.passport_verification.SumsubVerificationActivity;
import com.sumsub.sns.core.data.model.SNSSDKState;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function2<SNSSDKState, SNSSDKState, Unit> {
    public final /* synthetic */ SumsubVerificationActivity a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(SumsubVerificationActivity sumsubVerificationActivity) {
        super(2);
        this.a = sumsubVerificationActivity;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(SNSSDKState sNSSDKState, SNSSDKState sNSSDKState2) {
        SNSSDKState sNSSDKState3 = sNSSDKState;
        Intrinsics.checkNotNullParameter(sNSSDKState3, "newState");
        Intrinsics.checkNotNullParameter(sNSSDKState2, "<anonymous parameter 1>");
        this.a.getModel().onSdkStateChange(sNSSDKState3);
        return Unit.INSTANCE;
    }
}
