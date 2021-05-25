package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
public final class FlowableSwitchMapCompletable<T> extends Completable {
    public final Flowable<T> a;
    public final Function<? super T, ? extends CompletableSource> b;
    public final boolean c;

    public static final class a<T> implements FlowableSubscriber<T>, Disposable {
        public static final C0468a h = new C0468a(null);
        public final CompletableObserver a;
        public final Function<? super T, ? extends CompletableSource> b;
        public final boolean c;
        public final AtomicThrowable d = new AtomicThrowable();
        public final AtomicReference<C0468a> e = new AtomicReference<>();
        public volatile boolean f;
        public Subscription g;

        /* renamed from: io.reactivex.rxjava3.internal.operators.mixed.FlowableSwitchMapCompletable$a$a  reason: collision with other inner class name */
        public static final class C0468a extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -8003404460084760287L;
            public final a<?> a;

            public C0468a(a<?> aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.rxjava3.core.CompletableObserver
            public void onComplete() {
                a<?> aVar = this.a;
                if (aVar.e.compareAndSet(this, null) && aVar.f) {
                    aVar.d.tryTerminateConsumer(aVar.a);
                }
            }

            @Override // io.reactivex.rxjava3.core.CompletableObserver
            public void onError(Throwable th) {
                a<?> aVar = this.a;
                if (!aVar.e.compareAndSet(this, null)) {
                    RxJavaPlugins.onError(th);
                } else if (!aVar.d.tryAddThrowableOrReport(th)) {
                } else {
                    if (!aVar.c) {
                        aVar.g.cancel();
                        aVar.a();
                        aVar.d.tryTerminateConsumer(aVar.a);
                    } else if (aVar.f) {
                        aVar.d.tryTerminateConsumer(aVar.a);
                    }
                }
            }

            @Override // io.reactivex.rxjava3.core.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public a(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean z) {
            this.a = completableObserver;
            this.b = function;
            this.c = z;
        }

        public void a() {
            AtomicReference<C0468a> atomicReference = this.e;
            C0468a aVar = h;
            C0468a andSet = atomicReference.getAndSet(aVar);
            if (andSet != null && andSet != aVar) {
                DisposableHelper.dispose(andSet);
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.g.cancel();
            a();
            this.d.tryTerminateAndReport();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.e.get() == h;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f = true;
            if (this.e.get() == null) {
                this.d.tryTerminateConsumer(this.a);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.d.tryAddThrowableOrReport(th)) {
                return;
            }
            if (this.c) {
                onComplete();
                return;
            }
            a();
            this.d.tryTerminateConsumer(this.a);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            C0468a aVar;
            try {
                Object apply = this.b.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                CompletableSource completableSource = (CompletableSource) apply;
                C0468a aVar2 = new C0468a(this);
                do {
                    aVar = this.e.get();
                    if (aVar == h) {
                        return;
                    }
                } while (!this.e.compareAndSet(aVar, aVar2));
                if (aVar != null) {
                    DisposableHelper.dispose(aVar);
                }
                completableSource.subscribe(aVar2);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.g.cancel();
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.g, subscription)) {
                this.g = subscription;
                this.a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableSwitchMapCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, boolean z) {
        this.a = flowable;
        this.b = function;
        this.c = z;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.a.subscribe((FlowableSubscriber) new a(completableObserver, this.b, this.c));
    }
}
