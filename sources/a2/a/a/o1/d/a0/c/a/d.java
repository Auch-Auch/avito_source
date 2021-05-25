package a2.a.a.o1.d.a0.c.a;

import com.avito.android.messenger.conversation.mvi.deeplinks.cancel_order.DeliveryOrderCancelLinkProcessorListenerImpl;
import com.avito.android.util.DialogRouter;
import io.reactivex.functions.Consumer;
public final class d<T> implements Consumer<Throwable> {
    public final /* synthetic */ DeliveryOrderCancelLinkProcessorListenerImpl a;
    public final /* synthetic */ DialogRouter b;

    public d(DeliveryOrderCancelLinkProcessorListenerImpl deliveryOrderCancelLinkProcessorListenerImpl, DialogRouter dialogRouter) {
        this.a = deliveryOrderCancelLinkProcessorListenerImpl;
        this.b = dialogRouter;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        DeliveryOrderCancelLinkProcessorListenerImpl.access$onOrderCancelError(this.a, this.b);
    }
}
