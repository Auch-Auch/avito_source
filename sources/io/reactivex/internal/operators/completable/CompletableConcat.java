package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;
public final class CompletableConcat extends Completable {
    public final Publisher<? extends CompletableSource> a;
    public final int b;

    public static final class a extends AtomicInteger implements FlowableSubscriber<CompletableSource>, Disposable {
        private static final long serialVersionUID = 9032184911934499404L;
        public final CompletableObserver a;
        public final int b;
        public final int c;
        public final C0372a d = new C0372a(this);
        public final AtomicBoolean e = new AtomicBoolean();
        public int f;
        public int g;
        public SimpleQueue<CompletableSource> h;
        public Subscription i;
        public volatile boolean j;
        public volatile boolean k;

        /* renamed from: io.reactivex.internal.operators.completable.CompletableConcat$a$a  reason: collision with other inner class name */
        public static final class C0372a extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -5454794857847146511L;
            public final a a;

            public C0372a(a aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                a aVar = this.a;
                aVar.k = false;
                aVar.a();
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                this.a.b(th);
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        public a(CompletableObserver completableObserver, int i2) {
            this.a = completableObserver;
            this.b = i2;
            this.c = i2 - (i2 >> 2);
        }

        public void a() {
            if (getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.k) {
                        boolean z = this.j;
                        try {
                            CompletableSource poll = this.h.poll();
                            boolean z2 = poll == null;
                            if (!z || !z2) {
                                if (!z2) {
                                    this.k = true;
                                    poll.subscribe(this.d);
                                    if (this.f != 1) {
                                        int i2 = this.g + 1;
                                        if (i2 == this.c) {
                                            this.g = 0;
                                            this.i.request((long) i2);
                                        } else {
                                            this.g = i2;
                                        }
                                    }
                                }
                            } else if (this.e.compareAndSet(false, true)) {
                                this.a.onComplete();
                                return;
                            } else {
                                return;
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            b(th);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public void b(Throwable th) {
            if (this.e.compareAndSet(false, true)) {
                this.i.cancel();
                this.a.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.i.cancel();
            DisposableHelper.dispose(this.d);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.d.get());
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.j = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.e.compareAndSet(false, true)) {
                DisposableHelper.dispose(this.d);
                this.a.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            CompletableSource completableSource = (CompletableSource) obj;
            if (this.f != 0 || this.h.offer(completableSource)) {
                a();
            } else {
                onError(new MissingBackpressureException());
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.i, subscription)) {
                this.i = subscription;
                int i2 = this.b;
                long j2 = i2 == Integer.MAX_VALUE ? Long.MAX_VALUE : (long) i2;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.f = requestFusion;
                        this.h = queueSubscription;
                        this.j = true;
                        this.a.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.f = requestFusion;
                        this.h = queueSubscription;
                        this.a.onSubscribe(this);
                        subscription.request(j2);
                        return;
                    }
                }
                if (this.b == Integer.MAX_VALUE) {
                    this.h = new SpscLinkedArrayQueue(Flowable.bufferSize());
                } else {
                    this.h = new SpscArrayQueue(this.b);
                }
                this.a.onSubscribe(this);
                subscription.request(j2);
            }
        }
    }

    public CompletableConcat(Publisher<? extends CompletableSource> publisher, int i) {
        this.a = publisher;
        this.b = i;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.a.subscribe(new a(completableObserver, this.b));
    }
}
