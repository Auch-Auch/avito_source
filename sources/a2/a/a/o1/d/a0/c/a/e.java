package a2.a.a.o1.d.a0.c.a;

import com.avito.android.messenger.conversation.mvi.deeplinks.cancel_order.DeliveryOrderCancelLinkProcessorListenerImpl;
import com.avito.android.util.DialogRouter;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
public final class e extends Lambda implements Function0<Unit> {
    public final /* synthetic */ DeliveryOrderCancelLinkProcessorListenerImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ DialogRouter c;
    public final /* synthetic */ Ref.ObjectRef d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(DeliveryOrderCancelLinkProcessorListenerImpl deliveryOrderCancelLinkProcessorListenerImpl, String str, DialogRouter dialogRouter, Ref.ObjectRef objectRef) {
        super(0);
        this.a = deliveryOrderCancelLinkProcessorListenerImpl;
        this.b = str;
        this.c = dialogRouter;
        this.d = objectRef;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        DeliveryOrderCancelLinkProcessorListenerImpl.access$cancelDeliveryOrder(this.a, this.b, this.c, this.d.element);
        T t = this.d.element;
        if (t != null) {
            t.dismiss();
        }
        return Unit.INSTANCE;
    }
}
