package defpackage;

import com.avito.android.delivery.analytics.summary.ChangeType;
import com.avito.android.delivery.summary.DeliveryRdsSummaryViewImpl;
import com.avito.android.lib.expected.stepper.Stepper;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: h4  reason: default package */
public final class h4 extends Lambda implements Function0<Boolean> {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h4(int i, int i2, Object obj, Object obj2, Object obj3) {
        super(0);
        this.a = i;
        this.b = i2;
        this.c = obj;
        this.d = obj2;
        this.e = obj3;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        int i = this.a;
        if (i == 0) {
            ((DeliveryRdsSummaryViewImpl.d) this.d).b.onStepperClicked(((Stepper) this.c).getValue(), ChangeType.MINUS);
            return Boolean.FALSE;
        } else if (i == 1) {
            ((DeliveryRdsSummaryViewImpl.d) this.d).b.onStepperClicked(((Stepper) this.c).getValue(), ChangeType.PLUS);
            return Boolean.FALSE;
        } else {
            throw null;
        }
    }
}
