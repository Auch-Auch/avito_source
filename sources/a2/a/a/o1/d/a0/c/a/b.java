package a2.a.a.o1.d.a0.c.a;

import com.avito.android.messenger.conversation.mvi.deeplinks.cancel_order.DeliveryOrderCancelLinkProcessorListenerImpl;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class b<T, R> implements Function<Throwable, LoadingState<? super Unit>> {
    public final /* synthetic */ DeliveryOrderCancelLinkProcessorListenerImpl a;

    public b(DeliveryOrderCancelLinkProcessorListenerImpl deliveryOrderCancelLinkProcessorListenerImpl) {
        this.a = deliveryOrderCancelLinkProcessorListenerImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public LoadingState<? super Unit> apply(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, "it");
        return new LoadingState.Error(this.a.g.convert(th2));
    }
}
