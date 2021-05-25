package a2.a.a.j.a;

import com.avito.android.app.task.PendingMessageHandlerImpl;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import org.reactivestreams.Publisher;
public final class r<T, R> implements Function<Flowable<Throwable>, Publisher<?>> {
    public final /* synthetic */ PendingMessageHandlerImpl a;
    public final /* synthetic */ AtomicInteger b;
    public final /* synthetic */ LocalMessage c;

    public r(PendingMessageHandlerImpl pendingMessageHandlerImpl, AtomicInteger atomicInteger, LocalMessage localMessage) {
        this.a = pendingMessageHandlerImpl;
        this.b = atomicInteger;
        this.c = localMessage;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Publisher<?> apply(Flowable<Throwable> flowable) {
        Flowable<Throwable> flowable2 = flowable;
        Intrinsics.checkNotNullParameter(flowable2, "errors");
        return flowable2.delay(new q(this));
    }
}
