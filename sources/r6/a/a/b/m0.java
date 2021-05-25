package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Nono;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class m0 extends Nono {
    public final Publisher<? extends Nono> b;
    public final boolean c;
    public final int d;

    public static final class a extends b implements Subscriber<Nono> {
        private static final long serialVersionUID = 1247749138466245004L;
        public final Subscriber<? super Void> a;
        public final CompositeDisposable b = new CompositeDisposable();
        public final boolean c;
        public final int d;
        public final AtomicThrowable e = new AtomicThrowable();
        public Subscription f;

        /* renamed from: r6.a.a.b.m0$a$a  reason: collision with other inner class name */
        public final class C0562a extends AtomicReference<Subscription> implements Subscriber<Void>, Disposable {
            private static final long serialVersionUID = -2042478764098922486L;

            public C0562a() {
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                SubscriptionHelper.cancel(this);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return SubscriptionHelper.isCancelled((Subscription) get());
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                a aVar = a.this;
                aVar.b.delete(this);
                aVar.d();
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                a aVar = a.this;
                aVar.b.delete(this);
                if (!aVar.e.addThrowable(th)) {
                    RxJavaPlugins.onError(th);
                } else if (!aVar.c) {
                    aVar.b.dispose();
                    Throwable terminate = aVar.e.terminate();
                    if (terminate != ExceptionHelper.TERMINATED) {
                        aVar.a.onError(terminate);
                    }
                } else {
                    aVar.d();
                }
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // org.reactivestreams.Subscriber
            public void onNext(Void r1) {
            }

            @Override // org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                SubscriptionHelper.setOnce(this, subscription);
            }
        }

        public a(Subscriber<? super Void> subscriber, boolean z, int i) {
            this.a = subscriber;
            this.c = z;
            this.d = i;
            lazySet(1);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f.cancel();
            this.b.dispose();
        }

        public void d() {
            if (decrementAndGet() == 0) {
                Throwable terminate = this.e.terminate();
                if (terminate != null) {
                    this.a.onError(terminate);
                } else {
                    this.a.onComplete();
                }
            } else {
                this.f.request(1);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable terminate = this.e.terminate();
                if (terminate != null) {
                    this.a.onError(terminate);
                } else {
                    this.a.onComplete();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.e.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else if (!this.c) {
                this.b.dispose();
                Throwable terminate = this.e.terminate();
                if (terminate != ExceptionHelper.TERMINATED) {
                    this.a.onError(terminate);
                }
            } else {
                onComplete();
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // org.reactivestreams.Subscriber
        public void onNext(Nono nono) {
            getAndIncrement();
            C0562a aVar = new C0562a();
            this.b.add(aVar);
            nono.subscribe(aVar);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f, subscription)) {
                this.f = subscription;
                this.a.onSubscribe(this);
                int i = this.d;
                if (i == Integer.MAX_VALUE) {
                    subscription.request(Long.MAX_VALUE);
                } else {
                    subscription.request((long) i);
                }
            }
        }
    }

    public m0(Publisher<? extends Nono> publisher, boolean z, int i) {
        this.b = publisher;
        this.c = z;
        this.d = i;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        this.b.subscribe(new a(subscriber, this.c, this.d));
    }
}
