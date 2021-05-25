package a2.a.a.r3.a;

import com.avito.android.verification.verification_status.VerificationStatusViewImpl;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class i extends Lambda implements Function0<Unit> {
    public final /* synthetic */ VerificationStatusViewImpl a;
    public final /* synthetic */ List b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(VerificationStatusViewImpl verificationStatusViewImpl, List list) {
        super(0);
        this.a = verificationStatusViewImpl;
        this.b = list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        VerificationStatusViewImpl.access$createActionsMenuDialog(this.a, this.b).show();
        return Unit.INSTANCE;
    }
}
