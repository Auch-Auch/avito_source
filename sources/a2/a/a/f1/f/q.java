package a2.a.a.f1.f;

import com.avito.android.in_app_calls.service.CallReconnectHandlerImpl;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import org.reactivestreams.Publisher;
public final class q<T, R> implements Function<Flowable<Throwable>, Publisher<?>> {
    public final /* synthetic */ CallReconnectHandlerImpl a;

    public q(CallReconnectHandlerImpl callReconnectHandlerImpl) {
        this.a = callReconnectHandlerImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Publisher<?> apply(Flowable<Throwable> flowable) {
        Flowable<Throwable> flowable2 = flowable;
        Intrinsics.checkNotNullParameter(flowable2, "errors");
        return flowable2.flatMap(new p(this));
    }
}
