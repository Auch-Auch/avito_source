package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class FlowablePublish<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T>, FlowablePublishClassic<T> {
    public final Flowable<T> b;
    public final AtomicReference<c<T>> c;
    public final int d;
    public final Publisher<T> e;

    public static final class a<T> implements Publisher<T> {
        public final AtomicReference<c<T>> a;
        public final int b;

        public a(AtomicReference<c<T>> atomicReference, int i) {
            this.a = atomicReference;
            this.b = i;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x004e A[EDGE_INSN: B:22:0x004e->B:14:0x004e ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0008 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x004c A[EDGE_INSN: B:26:0x004c->B:13:0x004c ?: BREAK  , SYNTHETIC] */
        @Override // org.reactivestreams.Publisher
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void subscribe(org.reactivestreams.Subscriber<? super T> r7) {
            /*
                r6 = this;
                io.reactivex.internal.operators.flowable.FlowablePublish$b r0 = new io.reactivex.internal.operators.flowable.FlowablePublish$b
                r0.<init>(r7)
                r7.onSubscribe(r0)
            L_0x0008:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublish$c<T>> r7 = r6.a
                java.lang.Object r7 = r7.get()
                io.reactivex.internal.operators.flowable.FlowablePublish$c r7 = (io.reactivex.internal.operators.flowable.FlowablePublish.c) r7
                if (r7 == 0) goto L_0x0018
                boolean r1 = r7.isDisposed()
                if (r1 == 0) goto L_0x002b
            L_0x0018:
                io.reactivex.internal.operators.flowable.FlowablePublish$c r1 = new io.reactivex.internal.operators.flowable.FlowablePublish$c
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublish$c<T>> r2 = r6.a
                int r3 = r6.b
                r1.<init>(r2, r3)
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublish$c<T>> r2 = r6.a
                boolean r7 = r2.compareAndSet(r7, r1)
                if (r7 != 0) goto L_0x002a
                goto L_0x0008
            L_0x002a:
                r7 = r1
            L_0x002b:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublish$b<T>[]> r1 = r7.c
                java.lang.Object r1 = r1.get()
                io.reactivex.internal.operators.flowable.FlowablePublish$b[] r1 = (io.reactivex.internal.operators.flowable.FlowablePublish.b[]) r1
                io.reactivex.internal.operators.flowable.FlowablePublish$b[] r2 = io.reactivex.internal.operators.flowable.FlowablePublish.c.j
                r3 = 0
                if (r1 != r2) goto L_0x0039
                goto L_0x004c
            L_0x0039:
                int r2 = r1.length
                int r4 = r2 + 1
                io.reactivex.internal.operators.flowable.FlowablePublish$b[] r4 = new io.reactivex.internal.operators.flowable.FlowablePublish.b[r4]
                java.lang.System.arraycopy(r1, r3, r4, r3, r2)
                r4[r2] = r0
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublish$b<T>[]> r2 = r7.c
                boolean r1 = r2.compareAndSet(r1, r4)
                if (r1 == 0) goto L_0x002b
                r3 = 1
            L_0x004c:
                if (r3 == 0) goto L_0x0008
                long r1 = r0.get()
                r3 = -9223372036854775808
                int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r5 != 0) goto L_0x005c
                r7.c(r0)
                goto L_0x005e
            L_0x005c:
                r0.b = r7
            L_0x005e:
                r7.b()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowablePublish.a.subscribe(org.reactivestreams.Subscriber):void");
        }
    }

    public static final class b<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = -4453897557930727610L;
        public final Subscriber<? super T> a;
        public volatile c<T> b;
        public long c;

        public b(Subscriber<? super T> subscriber) {
            this.a = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            c<T> cVar;
            if (get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE && (cVar = this.b) != null) {
                cVar.c(this);
                cVar.b();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.addCancel(this, j);
                c<T> cVar = this.b;
                if (cVar != null) {
                    cVar.b();
                }
            }
        }
    }

    public static final class c<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        public static final b[] i = new b[0];
        public static final b[] j = new b[0];
        private static final long serialVersionUID = -202316842419149694L;
        public final AtomicReference<c<T>> a;
        public final int b;
        public final AtomicReference<b<T>[]> c = new AtomicReference<>(i);
        public final AtomicBoolean d;
        public final AtomicReference<Subscription> e = new AtomicReference<>();
        public volatile Object f;
        public int g;
        public volatile SimpleQueue<T> h;

        public c(AtomicReference<c<T>> atomicReference, int i2) {
            this.a = atomicReference;
            this.d = new AtomicBoolean();
            this.b = i2;
        }

        public boolean a(Object obj, boolean z) {
            int i2 = 0;
            if (obj != null) {
                if (!NotificationLite.isComplete(obj)) {
                    Throwable error = NotificationLite.getError(obj);
                    this.a.compareAndSet(this, null);
                    b<T>[] andSet = this.c.getAndSet(j);
                    if (andSet.length != 0) {
                        int length = andSet.length;
                        while (i2 < length) {
                            andSet[i2].a.onError(error);
                            i2++;
                        }
                    } else {
                        RxJavaPlugins.onError(error);
                    }
                    return true;
                } else if (z) {
                    this.a.compareAndSet(this, null);
                    b<T>[] andSet2 = this.c.getAndSet(j);
                    int length2 = andSet2.length;
                    while (i2 < length2) {
                        andSet2[i2].a.onComplete();
                        i2++;
                    }
                    return true;
                }
            }
            return false;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:103:0x0014, code lost:
            continue;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x0136, code lost:
            if (r11 == 0) goto L_0x0149;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x0138, code lost:
            r3 = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x013b, code lost:
            if (r25.g == 1) goto L_0x014a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x013d, code lost:
            r25.e.get().request(r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x0149, code lost:
            r3 = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x014e, code lost:
            if (r14 == 0) goto L_0x0154;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x0150, code lost:
            if (r8 != false) goto L_0x0154;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b() {
            /*
            // Method dump skipped, instructions count: 357
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowablePublish.c.b():void");
        }

        public void c(b<T> bVar) {
            b<T>[] bVarArr;
            b<T>[] bVarArr2;
            do {
                bVarArr = this.c.get();
                int length = bVarArr.length;
                if (length != 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            i2 = -1;
                            break;
                        } else if (bVarArr[i2].equals(bVar)) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i2 >= 0) {
                        if (length == 1) {
                            bVarArr2 = i;
                        } else {
                            b<T>[] bVarArr3 = new b[(length - 1)];
                            System.arraycopy(bVarArr, 0, bVarArr3, 0, i2);
                            System.arraycopy(bVarArr, i2 + 1, bVarArr3, i2, (length - i2) - 1);
                            bVarArr2 = bVarArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.c.compareAndSet(bVarArr, bVarArr2));
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            b<T>[] bVarArr = this.c.get();
            b<T>[] bVarArr2 = j;
            if (bVarArr != bVarArr2 && this.c.getAndSet(bVarArr2) != bVarArr2) {
                this.a.compareAndSet(this, null);
                SubscriptionHelper.cancel(this.e);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.c.get() == j;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f == null) {
                this.f = NotificationLite.complete();
                b();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f == null) {
                this.f = NotificationLite.error(th);
                b();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.g != 0 || this.h.offer(t)) {
                b();
            } else {
                onError(new MissingBackpressureException("Prefetch queue is full?!"));
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.e, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.g = requestFusion;
                        this.h = queueSubscription;
                        this.f = NotificationLite.complete();
                        b();
                        return;
                    } else if (requestFusion == 2) {
                        this.g = requestFusion;
                        this.h = queueSubscription;
                        subscription.request((long) this.b);
                        return;
                    }
                }
                this.h = new SpscArrayQueue(this.b);
                subscription.request((long) this.b);
            }
        }
    }

    public FlowablePublish(Publisher<T> publisher, Flowable<T> flowable, AtomicReference<c<T>> atomicReference, int i) {
        this.e = publisher;
        this.b = flowable;
        this.c = atomicReference;
        this.d = i;
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, int i) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.onAssembly((ConnectableFlowable) new FlowablePublish(new a(atomicReference, i), flowable, atomicReference, i));
    }

    @Override // io.reactivex.flowables.ConnectableFlowable
    public void connect(Consumer<? super Disposable> consumer) {
        c<T> cVar;
        while (true) {
            cVar = this.c.get();
            if (cVar != null && !cVar.isDisposed()) {
                break;
            }
            c<T> cVar2 = new c<>(this.c, this.d);
            if (this.c.compareAndSet(cVar, cVar2)) {
                cVar = cVar2;
                break;
            }
        }
        boolean z = true;
        if (cVar.d.get() || !cVar.d.compareAndSet(false, true)) {
            z = false;
        }
        try {
            consumer.accept(cVar);
            if (z) {
                this.b.subscribe((FlowableSubscriber) cVar);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // io.reactivex.internal.operators.flowable.FlowablePublishClassic
    public int publishBufferSize() {
        return this.d;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowablePublishClassic
    public Publisher<T> publishSource() {
        return this.b;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamPublisher
    public Publisher<T> source() {
        return this.b;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.e.subscribe(subscriber);
    }
}
