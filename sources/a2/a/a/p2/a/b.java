package a2.a.a.p2.a;

import com.avito.android.service_subscription.subscription_new.ServiceSubscriptionPresenterImpl;
import com.avito.android.ui.fragments.OnBackPressedListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function1<Unit, Unit> {
    public final /* synthetic */ ServiceSubscriptionPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(ServiceSubscriptionPresenterImpl serviceSubscriptionPresenterImpl) {
        super(1);
        this.a = serviceSubscriptionPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        OnBackPressedListener onBackPressedListener = this.a.f;
        if (onBackPressedListener != null) {
            onBackPressedListener.onBackPressed();
        }
        return Unit.INSTANCE;
    }
}
