package a2.a.a.o1.d.a0.c.a;

import android.app.Dialog;
import com.avito.android.messenger.conversation.mvi.deeplinks.cancel_order.DeliveryOrderCancelLinkProcessorListenerImpl;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class c<T> implements Consumer<LoadingState<? super Unit>> {
    public final /* synthetic */ DeliveryOrderCancelLinkProcessorListenerImpl a;
    public final /* synthetic */ Dialog b;
    public final /* synthetic */ DialogRouter c;

    public c(DeliveryOrderCancelLinkProcessorListenerImpl deliveryOrderCancelLinkProcessorListenerImpl, Dialog dialog, DialogRouter dialogRouter) {
        this.a = deliveryOrderCancelLinkProcessorListenerImpl;
        this.b = dialog;
        this.c = dialogRouter;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(LoadingState<? super Unit> loadingState) {
        LoadingState<? super Unit> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            DeliveryOrderCancelLinkProcessorListenerImpl.access$onOrderCancelled(this.a, this.b);
        } else if (loadingState2 instanceof LoadingState.Loading) {
            DeliveryOrderCancelLinkProcessorListenerImpl.access$onOrderCancelling(this.a);
        } else if (loadingState2 instanceof LoadingState.Error) {
            DeliveryOrderCancelLinkProcessorListenerImpl.access$onOrderCancelError(this.a, this.c);
        }
    }
}
