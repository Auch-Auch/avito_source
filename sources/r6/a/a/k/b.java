package r6.a.a.k;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class b extends Flowable<String> implements FlowableTransformer<String, String> {
    public final Publisher<String> b;
    public final Pattern c;
    public final int d;

    public static final class a extends AtomicInteger implements ConditionalSubscriber<String>, Subscription {
        private static final long serialVersionUID = -5022617259701794064L;
        public final Subscriber<? super String> a;
        public final Pattern b;
        public final SimplePlainQueue<String[]> c;
        public final AtomicLong d = new AtomicLong();
        public final int e;
        public final int f;
        public Subscription g;
        public volatile boolean h;
        public String i;
        public String[] j;
        public int k;
        public volatile boolean l;
        public Throwable m;
        public int n;

        public a(Subscriber<? super String> subscriber, Pattern pattern, int i2) {
            this.a = subscriber;
            this.b = pattern;
            this.e = i2;
            this.f = i2 - (i2 >> 2);
            this.c = new SpscArrayQueue(i2);
        }

        public void a() {
            int i2;
            if (getAndIncrement() == 0) {
                SimplePlainQueue<String[]> simplePlainQueue = this.c;
                int i3 = this.k;
                String[] strArr = this.j;
                int i4 = this.n;
                Subscriber<? super String> subscriber = this.a;
                int i5 = 1;
                int i6 = 0;
                do {
                    long j2 = this.d.get();
                    long j3 = 0;
                    while (true) {
                        i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        } else if (this.h) {
                            this.j = null;
                            simplePlainQueue.clear();
                            return;
                        } else {
                            boolean z = this.l;
                            if (strArr == null && (strArr = simplePlainQueue.poll()) != null) {
                                this.j = strArr;
                                i3++;
                                int i7 = this.f;
                                if (i3 == i7) {
                                    this.g.request((long) i7);
                                    i3 = 0;
                                }
                            }
                            boolean z2 = strArr == null;
                            if (z && z2) {
                                this.j = null;
                                Throwable th = this.m;
                                if (th != null) {
                                    subscriber.onError(th);
                                    return;
                                } else {
                                    subscriber.onComplete();
                                    return;
                                }
                            } else if (z2) {
                                break;
                            } else {
                                int i8 = i6 + 1;
                                if (strArr.length == i8) {
                                    this.j = null;
                                    strArr = null;
                                    i6 = 0;
                                } else {
                                    String str = strArr[i6];
                                    if (str.isEmpty()) {
                                        i4++;
                                    } else {
                                        while (i4 != 0 && j3 != j2) {
                                            if (this.h) {
                                                this.j = null;
                                                simplePlainQueue.clear();
                                                return;
                                            }
                                            subscriber.onNext("");
                                            j3++;
                                            i4--;
                                        }
                                        if (j3 != j2 && i4 == 0) {
                                            subscriber.onNext(str);
                                            j3++;
                                        }
                                    }
                                    i6 = i8;
                                }
                            }
                        }
                    }
                    if (i2 == 0) {
                        if (this.h) {
                            this.j = null;
                            simplePlainQueue.clear();
                            return;
                        }
                        boolean z3 = this.l;
                        if (strArr == null && (strArr = simplePlainQueue.poll()) != null) {
                            this.j = strArr;
                            i3++;
                            int i9 = this.f;
                            if (i3 == i9) {
                                this.g.request((long) i9);
                                i3 = 0;
                            }
                        }
                        boolean z4 = strArr == null;
                        if (z3 && z4) {
                            this.j = null;
                            Throwable th2 = this.m;
                            if (th2 != null) {
                                subscriber.onError(th2);
                                return;
                            } else {
                                subscriber.onComplete();
                                return;
                            }
                        }
                    }
                    if (j3 != 0) {
                        BackpressureHelper.produced(this.d, j3);
                    }
                    this.n = i4;
                    this.k = i3;
                    i5 = addAndGet(-i5);
                } while (i5 != 0);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean tryOnNext(java.lang.String r6) {
            /*
                r5 = this;
                java.lang.String r0 = r5.i
                r1 = -1
                r2 = 1
                if (r0 == 0) goto L_0x0023
                boolean r3 = r0.isEmpty()     // Catch:{ all -> 0x0048 }
                if (r3 == 0) goto L_0x000d
                goto L_0x0023
            L_0x000d:
                java.util.regex.Pattern r3 = r5.b     // Catch:{ all -> 0x0048 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0048 }
                r4.<init>()     // Catch:{ all -> 0x0048 }
                r4.append(r0)     // Catch:{ all -> 0x0048 }
                r4.append(r6)     // Catch:{ all -> 0x0048 }
                java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x0048 }
                java.lang.String[] r6 = r3.split(r6, r1)     // Catch:{ all -> 0x0048 }
                goto L_0x0029
            L_0x0023:
                java.util.regex.Pattern r0 = r5.b     // Catch:{ all -> 0x0048 }
                java.lang.String[] r6 = r0.split(r6, r1)     // Catch:{ all -> 0x0048 }
            L_0x0029:
                int r0 = r6.length
                r1 = 0
                if (r0 != 0) goto L_0x0031
                r6 = 0
                r5.i = r6
                return r1
            L_0x0031:
                int r0 = r6.length
                if (r0 != r2) goto L_0x0039
                r6 = r6[r1]
                r5.i = r6
                return r1
            L_0x0039:
                int r0 = r6.length
                int r0 = r0 - r2
                r0 = r6[r0]
                r5.i = r0
                io.reactivex.internal.fuseable.SimplePlainQueue<java.lang.String[]> r0 = r5.c
                r0.offer(r6)
                r5.a()
                return r2
            L_0x0048:
                r6 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r6)
                org.reactivestreams.Subscription r0 = r5.g
                r0.cancel()
                r5.onError(r6)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: r6.a.a.k.b.a.tryOnNext(java.lang.String):boolean");
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.h = true;
            this.g.cancel();
            if (getAndIncrement() == 0) {
                this.j = null;
                this.c.clear();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.l) {
                this.l = true;
                String str = this.i;
                if (str != null && !str.isEmpty()) {
                    this.i = null;
                    this.c.offer(new String[]{str, null});
                }
                a();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.l) {
                RxJavaPlugins.onError(th);
                return;
            }
            String str = this.i;
            if (str != null && !str.isEmpty()) {
                this.i = null;
                this.c.offer(new String[]{str, null});
            }
            this.m = th;
            this.l = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            if (!tryOnNext((String) obj)) {
                this.g.request(1);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.g, subscription)) {
                this.g = subscription;
                this.a.onSubscribe(this);
                subscription.request((long) this.e);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.d, j2);
                a();
            }
        }
    }

    public b(Publisher<String> publisher, Pattern pattern, int i) {
        this.b = publisher;
        this.c = pattern;
        this.d = i;
    }

    @Override // io.reactivex.FlowableTransformer
    public Publisher<String> apply(Flowable<String> flowable) {
        return new b(flowable, this.c, this.d);
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super String> subscriber) {
        this.b.subscribe(new a(subscriber, this.c, this.d));
    }
}
