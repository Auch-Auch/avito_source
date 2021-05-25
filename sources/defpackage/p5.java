package defpackage;

import com.avito.android.payment.webview.WebPaymentViewImpl;
import com.jakewharton.rxrelay2.PublishRelay;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: p5  reason: default package */
public final class p5 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p5(int i, Object obj) {
        super(0);
        this.a = i;
        this.b = obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        int i = this.a;
        if (i == 0) {
            PublishRelay publishRelay = ((WebPaymentViewImpl) this.b).f;
            Unit unit = Unit.INSTANCE;
            publishRelay.accept(unit);
            return unit;
        } else if (i == 1) {
            PublishRelay publishRelay2 = ((WebPaymentViewImpl) this.b).g;
            Unit unit2 = Unit.INSTANCE;
            publishRelay2.accept(unit2);
            return unit2;
        } else {
            throw null;
        }
    }
}
