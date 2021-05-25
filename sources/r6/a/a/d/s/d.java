package r6.a.a.d.s;

import hu.akarnokd.rxjava2.debug.validator.MultipleOnSubscribeCallsException;
import hu.akarnokd.rxjava2.debug.validator.MultipleTerminationsException;
import hu.akarnokd.rxjava2.debug.validator.NullOnErrorParameterException;
import hu.akarnokd.rxjava2.debug.validator.NullOnNextParameterException;
import hu.akarnokd.rxjava2.debug.validator.NullOnSubscribeParameterException;
import hu.akarnokd.rxjava2.debug.validator.OnNextAfterTerminationException;
import hu.akarnokd.rxjava2.debug.validator.OnSubscribeNotCalledException;
import hu.akarnokd.rxjava2.debug.validator.ProtocolNonConformanceException;
import hu.akarnokd.rxjava2.functions.PlainConsumer;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
public final class d<T> extends Flowable<T> {
    public final Flowable<T> b;
    public final PlainConsumer<ProtocolNonConformanceException> c;

    public static final class a<T> implements FlowableSubscriber<T>, Subscription {
        public final Subscriber<? super T> a;
        public final PlainConsumer<ProtocolNonConformanceException> b;
        public Subscription c;
        public boolean d;

        public a(Subscriber<? super T> subscriber, PlainConsumer<ProtocolNonConformanceException> plainConsumer) {
            this.a = subscriber;
            this.b = plainConsumer;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.c.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.c == null) {
                this.b.accept(new OnSubscribeNotCalledException());
            }
            if (this.d) {
                this.b.accept(new MultipleTerminationsException());
                return;
            }
            this.d = true;
            this.a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (th == null) {
                this.b.accept(new NullOnErrorParameterException());
            }
            if (this.c == null) {
                this.b.accept(new OnSubscribeNotCalledException(th));
            }
            if (this.d) {
                this.b.accept(new MultipleTerminationsException(th));
                return;
            }
            this.d = true;
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (t == null) {
                this.b.accept(new NullOnNextParameterException());
            }
            if (this.c == null) {
                this.b.accept(new OnSubscribeNotCalledException());
            }
            if (this.d) {
                this.b.accept(new OnNextAfterTerminationException());
            } else {
                this.a.onNext(t);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (subscription == null) {
                this.b.accept(new NullOnSubscribeParameterException());
            }
            if (this.c != null) {
                this.b.accept(new MultipleOnSubscribeCallsException());
            }
            this.c = subscription;
            this.a.onSubscribe(this);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.c.request(j);
        }
    }

    public d(Flowable<T> flowable, PlainConsumer<ProtocolNonConformanceException> plainConsumer) {
        this.b = flowable;
        this.c = plainConsumer;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe((FlowableSubscriber) new a(subscriber, this.c));
    }
}
