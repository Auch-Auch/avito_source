package s6.a.d;

import io.reactivex.annotations.Nullable;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.FlowableProcessor;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class a<T> extends FlowableProcessor<T> {
    public final FlowableProcessor<T> b;
    public boolean c;
    public AppendOnlyLinkedArrayList<Object> d;
    public volatile boolean e;

    public a(FlowableProcessor<T> flowableProcessor) {
        this.b = flowableProcessor;
    }

    public void f() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        while (true) {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.d;
                if (appendOnlyLinkedArrayList == null) {
                    this.c = false;
                    return;
                }
                this.d = null;
            }
            appendOnlyLinkedArrayList.accept(this.b);
        }
    }

    @Override // io.reactivex.processors.FlowableProcessor
    @Nullable
    public Throwable getThrowable() {
        return this.b.getThrowable();
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        return this.b.hasComplete();
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        return this.b.hasSubscribers();
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        return this.b.hasThrowable();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (!this.e) {
            synchronized (this) {
                if (!this.e) {
                    this.e = true;
                    if (this.c) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.d;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.d = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.complete());
                        return;
                    }
                    this.c = true;
                    this.b.onComplete();
                }
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        boolean z;
        if (this.e) {
            RxJavaPlugins.onError(th);
            return;
        }
        synchronized (this) {
            z = true;
            if (!this.e) {
                this.e = true;
                if (this.c) {
                    AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.d;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                        this.d = appendOnlyLinkedArrayList;
                    }
                    appendOnlyLinkedArrayList.setFirst(NotificationLite.error(th));
                    return;
                }
                this.c = true;
                z = false;
            }
        }
        if (z) {
            RxJavaPlugins.onError(th);
        } else {
            this.b.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (!this.e) {
            synchronized (this) {
                if (!this.e) {
                    if (this.c) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.d;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.d = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.next(t));
                        return;
                    }
                    this.c = true;
                    this.b.onNext(t);
                    f();
                }
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        boolean z = true;
        if (!this.e) {
            synchronized (this) {
                if (!this.e) {
                    if (this.c) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.d;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.d = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.subscription(subscription));
                        return;
                    }
                    this.c = true;
                    z = false;
                }
            }
        }
        if (z) {
            subscription.cancel();
            return;
        }
        this.b.onSubscribe(subscription);
        f();
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(subscriber);
    }
}
