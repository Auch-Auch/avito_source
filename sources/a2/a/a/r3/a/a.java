package a2.a.a.r3.a;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.verification.verification_status.VerificationStatusFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ VerificationStatusFragment a;
    public final /* synthetic */ DeepLink b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(VerificationStatusFragment verificationStatusFragment, DeepLink deepLink) {
        super(0);
        this.a = verificationStatusFragment;
        this.b = deepLink;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.getViewModel$verification_release().onDeepLinkClicked(this.b);
        return Unit.INSTANCE;
    }
}
