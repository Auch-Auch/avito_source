package s6.a.e.d.a;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
public abstract class a<T> extends CompletableFuture<T> implements FlowableSubscriber<T> {
    public final AtomicReference<Subscription> a = new AtomicReference<>();
    public T b;

    public abstract void afterSubscribe(Subscription subscription);

    @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        cancelUpstream();
        return super.cancel(z);
    }

    public final void cancelUpstream() {
        SubscriptionHelper.cancel(this.a);
    }

    public final void clear() {
        this.b = null;
        this.a.lazySet(SubscriptionHelper.CANCELLED);
    }

    @Override // java.util.concurrent.CompletableFuture
    public final boolean complete(T t) {
        cancelUpstream();
        return super.complete(t);
    }

    @Override // java.util.concurrent.CompletableFuture
    public final boolean completeExceptionally(Throwable th) {
        cancelUpstream();
        return super.completeExceptionally(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        clear();
        if (!completeExceptionally(th)) {
            RxJavaPlugins.onError(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(@NonNull Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.a, subscription)) {
            afterSubscribe(subscription);
        }
    }
}
