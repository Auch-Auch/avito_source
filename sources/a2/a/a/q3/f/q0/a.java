package a2.a.a.q3.f.q0;

import com.avito.android.vas_performance.ui.applied_services.AppliedServicesActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ AppliedServicesActivity a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(AppliedServicesActivity appliedServicesActivity) {
        super(0);
        this.a = appliedServicesActivity;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.finish();
        return Unit.INSTANCE;
    }
}
