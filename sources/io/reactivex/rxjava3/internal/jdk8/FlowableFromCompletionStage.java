package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import org.reactivestreams.Subscriber;
public final class FlowableFromCompletionStage<T> extends Flowable<T> {
    public final CompletionStage<T> b;

    public static final class a<T> extends AtomicReference<BiConsumer<T, Throwable>> implements BiConsumer<T, Throwable> {
        private static final long serialVersionUID = 45838553147237545L;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.function.BiConsumer
        public void accept(Object obj, Throwable th) {
            Throwable th2 = th;
            BiConsumer biConsumer = (BiConsumer) get();
            if (biConsumer != null) {
                biConsumer.accept(obj, th2);
            }
        }
    }

    public static final class b<T> extends DeferredScalarSubscription<T> implements BiConsumer<T, Throwable> {
        private static final long serialVersionUID = 4665335664328839859L;
        public final a<T> a;

        public b(Subscriber<? super T> subscriber, a<T> aVar) {
            super(subscriber);
            this.a = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.function.BiConsumer
        public void accept(Object obj, Throwable th) {
            Throwable th2 = th;
            if (th2 != null) {
                this.downstream.onError(th2);
            } else if (obj != 0) {
                complete(obj);
            } else {
                this.downstream.onError(new NullPointerException("The CompletionStage terminated with null."));
            }
        }

        @Override // io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.a.set(null);
        }
    }

    public FlowableFromCompletionStage(CompletionStage<T> completionStage) {
        this.b = completionStage;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        a aVar = new a();
        b bVar = new b(subscriber, aVar);
        aVar.lazySet(bVar);
        subscriber.onSubscribe(bVar);
        this.b.whenComplete(aVar);
    }
}
