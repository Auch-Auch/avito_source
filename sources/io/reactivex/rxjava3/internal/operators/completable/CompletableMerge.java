package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;
public final class CompletableMerge extends Completable {
    public final Publisher<? extends CompletableSource> a;
    public final int b;
    public final boolean c;

    public static final class a extends AtomicInteger implements FlowableSubscriber<CompletableSource>, Disposable {
        private static final long serialVersionUID = -2108443387387077490L;
        public final CompletableObserver a;
        public final int b;
        public final boolean c;
        public final AtomicThrowable d = new AtomicThrowable();
        public final CompositeDisposable e = new CompositeDisposable();
        public Subscription f;

        /* renamed from: io.reactivex.rxjava3.internal.operators.completable.CompletableMerge$a$a  reason: collision with other inner class name */
        public final class C0437a extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            private static final long serialVersionUID = 251330541679988317L;

            public C0437a() {
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.rxjava3.disposables.Disposable
            public boolean isDisposed() {
                return DisposableHelper.isDisposed((Disposable) get());
            }

            @Override // io.reactivex.rxjava3.core.CompletableObserver
            public void onComplete() {
                a aVar = a.this;
                aVar.e.delete(this);
                if (aVar.decrementAndGet() == 0) {
                    aVar.d.tryTerminateConsumer(aVar.a);
                } else if (aVar.b != Integer.MAX_VALUE) {
                    aVar.f.request(1);
                }
            }

            @Override // io.reactivex.rxjava3.core.CompletableObserver
            public void onError(Throwable th) {
                a aVar = a.this;
                aVar.e.delete(this);
                if (!aVar.c) {
                    aVar.f.cancel();
                    aVar.e.dispose();
                    if (aVar.d.tryAddThrowableOrReport(th) && aVar.getAndSet(0) > 0) {
                        aVar.d.tryTerminateConsumer(aVar.a);
                    }
                } else if (!aVar.d.tryAddThrowableOrReport(th)) {
                } else {
                    if (aVar.decrementAndGet() == 0) {
                        aVar.d.tryTerminateConsumer(aVar.a);
                    } else if (aVar.b != Integer.MAX_VALUE) {
                        aVar.f.request(1);
                    }
                }
            }

            @Override // io.reactivex.rxjava3.core.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public a(CompletableObserver completableObserver, int i, boolean z) {
            this.a = completableObserver;
            this.b = i;
            this.c = z;
            lazySet(1);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.f.cancel();
            this.e.dispose();
            this.d.tryTerminateAndReport();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.e.isDisposed();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (decrementAndGet() == 0) {
                this.d.tryTerminateConsumer(this.a);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.c) {
                this.e.dispose();
                if (this.d.tryAddThrowableOrReport(th) && getAndSet(0) > 0) {
                    this.d.tryTerminateConsumer(this.a);
                }
            } else if (this.d.tryAddThrowableOrReport(th) && decrementAndGet() == 0) {
                this.d.tryTerminateConsumer(this.a);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            getAndIncrement();
            C0437a aVar = new C0437a();
            this.e.add(aVar);
            ((CompletableSource) obj).subscribe(aVar);
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f, subscription)) {
                this.f = subscription;
                this.a.onSubscribe(this);
                int i = this.b;
                if (i == Integer.MAX_VALUE) {
                    subscription.request(Long.MAX_VALUE);
                } else {
                    subscription.request((long) i);
                }
            }
        }
    }

    public CompletableMerge(Publisher<? extends CompletableSource> publisher, int i, boolean z) {
        this.a = publisher;
        this.b = i;
        this.c = z;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.a.subscribe(new a(completableObserver, this.b, this.c));
    }
}
