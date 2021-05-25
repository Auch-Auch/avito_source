package com.avito.android.passport_verification;

import com.sumsub.sns.core.data.listener.TokenExpirationHandler;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/avito/android/passport_verification/SumsubVerificationActivity$tokenExpirationHandler$1", "Lcom/sumsub/sns/core/data/listener/TokenExpirationHandler;", "", "onTokenExpired", "()Ljava/lang/String;", "passport-verification_release"}, k = 1, mv = {1, 4, 2})
public final class SumsubVerificationActivity$tokenExpirationHandler$1 implements TokenExpirationHandler {
    public final /* synthetic */ SumsubVerificationActivity a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public SumsubVerificationActivity$tokenExpirationHandler$1(SumsubVerificationActivity sumsubVerificationActivity) {
        this.a = sumsubVerificationActivity;
    }

    @Override // com.sumsub.sns.core.data.listener.TokenExpirationHandler
    @Nullable
    public String onTokenExpired() {
        return this.a.getModel().onTokenExpired();
    }
}
