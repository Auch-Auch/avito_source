package hu.akarnokd.rxjava2.operators;

import a2.b.a.a.a;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class BasicMergeSubscription<T> extends AtomicInteger implements Subscription, InnerQueuedSubscriberSupport<T> {
    private static final long serialVersionUID = -8467324377226330554L;
    public final Subscriber<? super T> a;
    public final Comparator<? super T> b;
    public final InnerQueuedSubscriber<T>[] c;
    public final boolean d;
    public final AtomicThrowable e;
    public final AtomicLong f;
    public final Object[] g;
    public volatile boolean h;

    public BasicMergeSubscription(Subscriber<? super T> subscriber, Comparator<? super T> comparator, int i, int i2, boolean z) {
        this.a = subscriber;
        this.b = comparator;
        this.d = z;
        InnerQueuedSubscriber<T>[] innerQueuedSubscriberArr = new InnerQueuedSubscriber[i];
        for (int i3 = 0; i3 < i; i3++) {
            innerQueuedSubscriberArr[i3] = new InnerQueuedSubscriber<>(this, i2);
        }
        this.c = innerQueuedSubscriberArr;
        this.f = new AtomicLong();
        this.e = new AtomicThrowable();
        this.g = new Object[i];
    }

    public void a() {
        Arrays.fill(this.g, this);
        InnerQueuedSubscriber<T>[] innerQueuedSubscriberArr = this.c;
        for (InnerQueuedSubscriber<T> innerQueuedSubscriber : innerQueuedSubscriberArr) {
            innerQueuedSubscriber.cancel();
            SimpleQueue<T> queue = innerQueuedSubscriber.queue();
            if (queue != null) {
                queue.clear();
            }
        }
    }

    public void b() {
        Arrays.fill(this.g, this);
        for (InnerQueuedSubscriber<T> innerQueuedSubscriber : this.c) {
            SimpleQueue<T> queue = innerQueuedSubscriber.queue();
            if (queue != null) {
                queue.clear();
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (!this.h) {
            this.h = true;
            for (InnerQueuedSubscriber<T> innerQueuedSubscriber : this.c) {
                innerQueuedSubscriber.cancel();
            }
            if (getAndIncrement() == 0) {
                b();
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:131:0x00cf */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a4, code lost:
        if (r0 != r26) goto L_0x00a6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x00cf A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ad A[SYNTHETIC, Splitter:B:47:0x00ad] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00cc  */
    @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void drain() {
        /*
        // Method dump skipped, instructions count: 402
        */
        throw new UnsupportedOperationException("Method not decompiled: hu.akarnokd.rxjava2.operators.BasicMergeSubscription.drain():void");
    }

    @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
    public void innerComplete(InnerQueuedSubscriber<T> innerQueuedSubscriber) {
        innerQueuedSubscriber.setDone();
        drain();
    }

    @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
    public void innerError(InnerQueuedSubscriber<T> innerQueuedSubscriber, Throwable th) {
        if (this.e.addThrowable(th)) {
            if (!this.d) {
                for (InnerQueuedSubscriber<T> innerQueuedSubscriber2 : this.c) {
                    innerQueuedSubscriber2.cancel();
                }
            } else {
                innerQueuedSubscriber.setDone();
            }
            drain();
            return;
        }
        RxJavaPlugins.onError(th);
    }

    @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
    public void innerNext(InnerQueuedSubscriber<T> innerQueuedSubscriber, T t) {
        innerQueuedSubscriber.queue().offer(t);
        drain();
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            BackpressureHelper.add(this.f, j);
            drain();
        }
    }

    public void subscribe(Publisher<T>[] publisherArr, int i) {
        InnerQueuedSubscriber<T>[] innerQueuedSubscriberArr = this.c;
        for (int i2 = 0; i2 < i && !this.h; i2++) {
            Publisher<T> publisher = publisherArr[i2];
            if (publisher != null) {
                publisher.subscribe(innerQueuedSubscriberArr[i2]);
            } else {
                EmptySubscription.error(new NullPointerException(a.Q2("The ", i2, "th source is null")), innerQueuedSubscriberArr[i2]);
                if (!this.d) {
                    return;
                }
            }
        }
    }

    public void subscribe(ParallelFlowable<T> parallelFlowable) {
        parallelFlowable.subscribe(this.c);
    }
}
