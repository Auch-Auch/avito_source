package r6.a.a.k;

import io.reactivex.Flowable;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;
public final class a extends Flowable<Integer> {
    public final CharSequence b;

    /* renamed from: r6.a.a.k.a$a  reason: collision with other inner class name */
    public static final class C0599a extends BasicQueueSubscription<Integer> {
        private static final long serialVersionUID = -4593793201463047197L;
        public final Subscriber<? super Integer> a;
        public final CharSequence b;
        public final int c;
        public int d;
        public volatile boolean e;

        public C0599a(Subscriber<? super Integer> subscriber, CharSequence charSequence) {
            this.a = subscriber;
            this.b = charSequence;
            this.c = charSequence.length();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.e = true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.d = this.c;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.d == this.c;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() throws Exception {
            int i = this.d;
            if (i == this.c) {
                return null;
            }
            this.d = i + 1;
            return Integer.valueOf(this.b.charAt(i));
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j) && BackpressureHelper.add(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    int i = this.c;
                    CharSequence charSequence = this.b;
                    Subscriber<? super Integer> subscriber = this.a;
                    for (int i2 = this.d; i2 != i; i2++) {
                        if (!this.e) {
                            subscriber.onNext(Integer.valueOf(charSequence.charAt(i2)));
                        } else {
                            return;
                        }
                    }
                    if (!this.e) {
                        subscriber.onComplete();
                        return;
                    }
                    return;
                }
                int i3 = this.d;
                int i4 = this.c;
                CharSequence charSequence2 = this.b;
                Subscriber<? super Integer> subscriber2 = this.a;
                do {
                    long j2 = 0;
                    while (true) {
                        if (j2 == j || i3 == i4) {
                            if (i3 != i4) {
                                j = get();
                                if (j2 == j) {
                                    this.d = i3;
                                    j = addAndGet(-j2);
                                }
                            } else if (!this.e) {
                                subscriber2.onComplete();
                                return;
                            } else {
                                return;
                            }
                        } else if (!this.e) {
                            subscriber2.onNext(Integer.valueOf(charSequence2.charAt(i3)));
                            i3++;
                            j2++;
                        } else {
                            return;
                        }
                    }
                } while (j != 0);
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return i & 1;
        }
    }

    public a(CharSequence charSequence) {
        this.b = charSequence;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Integer> subscriber) {
        subscriber.onSubscribe(new C0599a(subscriber, this.b));
    }
}
