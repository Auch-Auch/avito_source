package r6.a.a.g;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import java.util.Comparator;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
public final class c<T> extends d<T, T> {
    public final Comparator<? super T> c;
    public final int d;

    public static final class a<T> extends DeferredScalarSubscriber<T, T> {
        private static final long serialVersionUID = 600979972678601618L;
        public final Comparator<? super T> a;
        public final int b;

        public a(Subscriber<? super T> subscriber, Comparator<? super T> comparator, int i) {
            super(subscriber);
            this.a = comparator;
            this.b = i;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            try {
                if (!this.hasValue) {
                    this.value = t;
                    this.hasValue = true;
                } else if (this.a.compare(this.value, t) * this.b > 0) {
                    this.value = t;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.s.cancel();
                this.actual.onError(th);
            }
        }
    }

    public c(Publisher<T> publisher, Comparator<? super T> comparator, int i) {
        super(publisher);
        this.c = comparator;
        this.d = i;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe(new a(subscriber, this.c, this.d));
    }
}
