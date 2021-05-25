package r6.a.a.b;

import hu.akarnokd.rxjava2.basetypes.Nono;
import hu.akarnokd.rxjava2.util.CompositeSubscription;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class n0 extends Nono {
    public final Nono[] b;
    public final boolean c;
    public final int d;

    public static final class a extends AtomicReference<Subscription> implements Subscriber<Void>, Subscription {
        private static final long serialVersionUID = -7172670778151490886L;
        public final c a;

        public a(c cVar) {
            this.a = cVar;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.a.b(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.c(this, th);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // org.reactivestreams.Subscriber
        public void onNext(Void r1) {
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
        }
    }

    public static final class b extends BasicIntQueueSubscription<Void> implements c {
        private static final long serialVersionUID = -58058606508277827L;
        public final Subscriber<? super Void> a;
        public final AtomicThrowable b = new AtomicThrowable();
        public final boolean c;
        public final Nono[] d;
        public final CompositeSubscription e;
        public final AtomicInteger f;
        public int g;
        public volatile boolean h;

        /* JADX WARN: Incorrect args count in method signature: (Lorg/reactivestreams/Subscriber<-Ljava/lang/Void;>;ZI[Lhu/akarnokd/rxjava2/basetypes/Nono;)V */
        public b(Subscriber subscriber, boolean z, Nono[] nonoArr) {
            this.a = subscriber;
            this.c = z;
            this.d = nonoArr;
            this.e = new CompositeSubscription();
            this.f = new AtomicInteger();
            lazySet(1);
        }

        @Override // r6.a.a.b.n0.c
        public void b(a aVar) {
            this.e.delete(aVar);
            h(1);
            d();
        }

        @Override // r6.a.a.b.n0.c
        public void c(a aVar, Throwable th) {
            this.e.delete(aVar);
            if (!this.b.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else if (!this.c) {
                this.e.cancel();
                Throwable terminate = this.b.terminate();
                if (terminate != ExceptionHelper.TERMINATED) {
                    this.a.onError(terminate);
                }
            } else {
                h(1);
                d();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.h = true;
            this.e.cancel();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
        }

        public void d() {
            if (decrementAndGet() == 0) {
                Throwable terminate = this.b.terminate();
                if (terminate != null) {
                    this.a.onError(terminate);
                } else {
                    this.a.onComplete();
                }
            }
        }

        public void h(int i) {
            int i2;
            int i3;
            do {
                i2 = this.f.get();
                i3 = Integer.MAX_VALUE;
                if (i2 != Integer.MAX_VALUE) {
                    int i4 = i2 + i;
                    if (i4 >= 0) {
                        i3 = i4;
                    }
                } else {
                    return;
                }
            } while (!this.f.compareAndSet(i2, i3));
            if (i2 == 0) {
                Nono[] nonoArr = this.d;
                int length = nonoArr.length;
                do {
                    int i5 = 0;
                    do {
                        int i6 = this.g;
                        while (true) {
                            if (i5 == i || i6 == length) {
                                break;
                            } else if (!this.h) {
                                Nono nono = nonoArr[i6];
                                if (nono == null) {
                                    this.b.addThrowable(new NullPointerException("A source is null"));
                                    if (this.c) {
                                        i6 = length;
                                    } else {
                                        this.e.cancel();
                                        Throwable terminate = this.b.terminate();
                                        if (terminate != ExceptionHelper.TERMINATED) {
                                            this.a.onError(terminate);
                                            return;
                                        }
                                        return;
                                    }
                                } else {
                                    a aVar = new a(this);
                                    this.e.add(aVar);
                                    getAndIncrement();
                                    nono.subscribe(aVar);
                                    i6++;
                                    i5++;
                                }
                            } else {
                                return;
                            }
                        }
                        if (!this.h) {
                            if (i6 == length) {
                                d();
                                return;
                            } else {
                                this.g = i6;
                                i = get();
                            }
                        } else {
                            return;
                        }
                    } while (i5 != i);
                    i = addAndGet(-i5);
                } while (i != 0);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public /* bridge */ /* synthetic */ Object poll() throws Exception {
            return null;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return i & 2;
        }
    }

    public interface c {
        void b(a aVar);

        void c(a aVar, Throwable th);
    }

    public n0(Nono[] nonoArr, boolean z, int i) {
        this.b = nonoArr;
        this.c = z;
        this.d = i;
    }

    @Override // hu.akarnokd.rxjava2.basetypes.Nono
    public void subscribeActual(Subscriber<? super Void> subscriber) {
        b bVar = new b(subscriber, this.c, this.b);
        subscriber.onSubscribe(bVar);
        bVar.h(this.d);
    }
}
