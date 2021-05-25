package a2.a.a.t1.g;

import com.avito.android.payment.webview.WebPaymentViewImpl;
import com.jakewharton.rxrelay2.PublishRelay;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class i extends Lambda implements Function0<Unit> {
    public final /* synthetic */ WebPaymentViewImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(WebPaymentViewImpl webPaymentViewImpl) {
        super(0);
        this.a = webPaymentViewImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        PublishRelay publishRelay = this.a.f;
        Unit unit = Unit.INSTANCE;
        publishRelay.accept(unit);
        return unit;
    }
}
