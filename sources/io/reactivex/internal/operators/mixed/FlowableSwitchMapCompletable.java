package io.reactivex.internal.operators.mixed;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
public final class FlowableSwitchMapCompletable<T> extends Completable {
    public final Flowable<T> a;
    public final Function<? super T, ? extends CompletableSource> b;
    public final boolean c;

    public static final class a<T> implements FlowableSubscriber<T>, Disposable {
        public static final C0404a h = new C0404a(null);
        public final CompletableObserver a;
        public final Function<? super T, ? extends CompletableSource> b;
        public final boolean c;
        public final AtomicThrowable d = new AtomicThrowable();
        public final AtomicReference<C0404a> e = new AtomicReference<>();
        public volatile boolean f;
        public Subscription g;

        /* renamed from: io.reactivex.internal.operators.mixed.FlowableSwitchMapCompletable$a$a  reason: collision with other inner class name */
        public static final class C0404a extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -8003404460084760287L;
            public final a<?> a;

            public C0404a(a<?> aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                a<?> aVar = this.a;
                if (aVar.e.compareAndSet(this, null) && aVar.f) {
                    Throwable terminate = aVar.d.terminate();
                    if (terminate == null) {
                        aVar.a.onComplete();
                    } else {
                        aVar.a.onError(terminate);
                    }
                }
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                a<?> aVar = this.a;
                if (!aVar.e.compareAndSet(this, null) || !aVar.d.addThrowable(th)) {
                    RxJavaPlugins.onError(th);
                } else if (!aVar.c) {
                    aVar.dispose();
                    Throwable terminate = aVar.d.terminate();
                    if (terminate != ExceptionHelper.TERMINATED) {
                        aVar.a.onError(terminate);
                    }
                } else if (aVar.f) {
                    aVar.a.onError(aVar.d.terminate());
                }
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public a(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean z) {
            this.a = completableObserver;
            this.b = function;
            this.c = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.g.cancel();
            AtomicReference<C0404a> atomicReference = this.e;
            C0404a aVar = h;
            C0404a andSet = atomicReference.getAndSet(aVar);
            if (andSet != null && andSet != aVar) {
                DisposableHelper.dispose(andSet);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.e.get() == h;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f = true;
            if (this.e.get() == null) {
                Throwable terminate = this.d.terminate();
                if (terminate == null) {
                    this.a.onComplete();
                } else {
                    this.a.onError(terminate);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.d.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else if (this.c) {
                onComplete();
            } else {
                AtomicReference<C0404a> atomicReference = this.e;
                C0404a aVar = h;
                C0404a andSet = atomicReference.getAndSet(aVar);
                if (!(andSet == null || andSet == aVar)) {
                    DisposableHelper.dispose(andSet);
                }
                Throwable terminate = this.d.terminate();
                if (terminate != ExceptionHelper.TERMINATED) {
                    this.a.onError(terminate);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            C0404a aVar;
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.requireNonNull(this.b.apply(t), "The mapper returned a null CompletableSource");
                C0404a aVar2 = new C0404a(this);
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

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
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

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.a.subscribe((FlowableSubscriber) new a(completableObserver, this.b, this.c));
    }
}
