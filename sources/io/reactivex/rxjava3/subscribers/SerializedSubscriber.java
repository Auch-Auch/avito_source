package io.reactivex.rxjava3.subscribers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class SerializedSubscriber<T> implements FlowableSubscriber<T>, Subscription {
    public final Subscriber<? super T> a;
    public final boolean b;
    public Subscription c;
    public boolean d;
    public AppendOnlyLinkedArrayList<Object> e;
    public volatile boolean f;

    public SerializedSubscriber(Subscriber<? super T> subscriber) {
        this(subscriber, false);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.c.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (!this.f) {
            synchronized (this) {
                if (!this.f) {
                    if (this.d) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.e;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.e = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.complete());
                        return;
                    }
                    this.f = true;
                    this.d = true;
                    this.a.onComplete();
                }
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        boolean z;
        if (this.f) {
            RxJavaPlugins.onError(th);
            return;
        }
        synchronized (this) {
            z = true;
            if (!this.f) {
                if (this.d) {
                    this.f = true;
                    AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.e;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                        this.e = appendOnlyLinkedArrayList;
                    }
                    Object error = NotificationLite.error(th);
                    if (this.b) {
                        appendOnlyLinkedArrayList.add(error);
                    } else {
                        appendOnlyLinkedArrayList.setFirst(error);
                    }
                    return;
                }
                this.f = true;
                this.d = true;
                z = false;
            }
        }
        if (z) {
            RxJavaPlugins.onError(th);
        } else {
            this.a.onError(th);
        }
    }

    /* JADX DEBUG: Type inference failed for r0v6. Raw type applied. Possible types: org.reactivestreams.Subscriber<? super T>, org.reactivestreams.Subscriber<? super U> */
    @Override // org.reactivestreams.Subscriber
    public void onNext(@NonNull T t) {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        if (!this.f) {
            if (t == null) {
                this.c.cancel();
                onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
                return;
            }
            synchronized (this) {
                if (!this.f) {
                    if (this.d) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList2 = this.e;
                        if (appendOnlyLinkedArrayList2 == null) {
                            appendOnlyLinkedArrayList2 = new AppendOnlyLinkedArrayList<>(4);
                            this.e = appendOnlyLinkedArrayList2;
                        }
                        appendOnlyLinkedArrayList2.add(NotificationLite.next(t));
                        return;
                    }
                    this.d = true;
                } else {
                    return;
                }
            }
            this.a.onNext(t);
            do {
                synchronized (this) {
                    appendOnlyLinkedArrayList = this.e;
                    if (appendOnlyLinkedArrayList == null) {
                        this.d = false;
                        return;
                    }
                    this.e = null;
                }
            } while (!appendOnlyLinkedArrayList.accept((Subscriber<? super T>) this.a));
        }
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(@NonNull Subscription subscription) {
        if (SubscriptionHelper.validate(this.c, subscription)) {
            this.c = subscription;
            this.a.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        this.c.request(j);
    }

    public SerializedSubscriber(@NonNull Subscriber<? super T> subscriber, boolean z) {
        this.a = subscriber;
        this.b = z;
    }
}
