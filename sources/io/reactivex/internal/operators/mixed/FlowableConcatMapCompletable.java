package io.reactivex.internal.operators.mixed;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
public final class FlowableConcatMapCompletable<T> extends Completable {
    public final Flowable<T> a;
    public final Function<? super T, ? extends CompletableSource> b;
    public final ErrorMode c;
    public final int d;

    public static final class a<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        private static final long serialVersionUID = 3610901111000061034L;
        public final CompletableObserver a;
        public final Function<? super T, ? extends CompletableSource> b;
        public final ErrorMode c;
        public final AtomicThrowable d = new AtomicThrowable();
        public final C0401a e = new C0401a(this);
        public final int f;
        public final SimplePlainQueue<T> g;
        public Subscription h;
        public volatile boolean i;
        public volatile boolean j;
        public volatile boolean k;
        public int l;

        /* renamed from: io.reactivex.internal.operators.mixed.FlowableConcatMapCompletable$a$a  reason: collision with other inner class name */
        public static final class C0401a extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = 5638352172918776687L;
            public final a<?> a;

            public C0401a(a<?> aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                a<?> aVar = this.a;
                aVar.i = false;
                aVar.a();
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                a<?> aVar = this.a;
                if (!aVar.d.addThrowable(th)) {
                    RxJavaPlugins.onError(th);
                } else if (aVar.c == ErrorMode.IMMEDIATE) {
                    aVar.h.cancel();
                    Throwable terminate = aVar.d.terminate();
                    if (terminate != ExceptionHelper.TERMINATED) {
                        aVar.a.onError(terminate);
                    }
                    if (aVar.getAndIncrement() == 0) {
                        aVar.g.clear();
                    }
                } else {
                    aVar.i = false;
                    aVar.a();
                }
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        public a(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int i2) {
            this.a = completableObserver;
            this.b = function;
            this.c = errorMode;
            this.f = i2;
            this.g = new SpscArrayQueue(i2);
        }

        public void a() {
            if (getAndIncrement() == 0) {
                while (!this.k) {
                    if (!this.i) {
                        if (this.c != ErrorMode.BOUNDARY || this.d.get() == null) {
                            boolean z = this.j;
                            T poll = this.g.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                Throwable terminate = this.d.terminate();
                                if (terminate != null) {
                                    this.a.onError(terminate);
                                    return;
                                } else {
                                    this.a.onComplete();
                                    return;
                                }
                            } else if (!z2) {
                                int i2 = this.f;
                                int i3 = i2 - (i2 >> 1);
                                int i4 = this.l + 1;
                                if (i4 == i3) {
                                    this.l = 0;
                                    this.h.request((long) i3);
                                } else {
                                    this.l = i4;
                                }
                                try {
                                    CompletableSource completableSource = (CompletableSource) ObjectHelper.requireNonNull(this.b.apply(poll), "The mapper returned a null CompletableSource");
                                    this.i = true;
                                    completableSource.subscribe(this.e);
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    this.g.clear();
                                    this.h.cancel();
                                    this.d.addThrowable(th);
                                    this.a.onError(this.d.terminate());
                                    return;
                                }
                            }
                        } else {
                            this.g.clear();
                            this.a.onError(this.d.terminate());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.g.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.k = true;
            this.h.cancel();
            C0401a aVar = this.e;
            Objects.requireNonNull(aVar);
            DisposableHelper.dispose(aVar);
            if (getAndIncrement() == 0) {
                this.g.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.k;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.j = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.d.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else if (this.c == ErrorMode.IMMEDIATE) {
                C0401a aVar = this.e;
                Objects.requireNonNull(aVar);
                DisposableHelper.dispose(aVar);
                Throwable terminate = this.d.terminate();
                if (terminate != ExceptionHelper.TERMINATED) {
                    this.a.onError(terminate);
                }
                if (getAndIncrement() == 0) {
                    this.g.clear();
                }
            } else {
                this.j = true;
                a();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.g.offer(t)) {
                a();
                return;
            }
            this.h.cancel();
            onError(new MissingBackpressureException("Queue full?!"));
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.h, subscription)) {
                this.h = subscription;
                this.a.onSubscribe(this);
                subscription.request((long) this.f);
            }
        }
    }

    public FlowableConcatMapCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int i) {
        this.a = flowable;
        this.b = function;
        this.c = errorMode;
        this.d = i;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.a.subscribe((FlowableSubscriber) new a(completableObserver, this.b, this.c, this.d));
    }
}
