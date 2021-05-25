package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.reactivestreams.Publisher;
public final class SingleInternalHelper {

    public enum a implements Supplier<NoSuchElementException> {
        INSTANCE;

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // io.reactivex.rxjava3.functions.Supplier
        public NoSuchElementException get() throws Throwable {
            return new NoSuchElementException();
        }
    }

    public enum b implements Function<SingleSource, Publisher> {
        INSTANCE;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Publisher apply(SingleSource singleSource) throws Throwable {
            return new SingleToFlowable(singleSource);
        }
    }

    public static final class c<T> implements Iterable<Flowable<T>> {
        public final Iterable<? extends SingleSource<? extends T>> a;

        public c(Iterable<? extends SingleSource<? extends T>> iterable) {
            this.a = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<Flowable<T>> iterator() {
            return new d(this.a.iterator());
        }
    }

    public static final class d<T> implements Iterator<Flowable<T>> {
        public final Iterator<? extends SingleSource<? extends T>> a;

        public d(Iterator<? extends SingleSource<? extends T>> it) {
            this.a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return new SingleToFlowable((SingleSource) this.a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public SingleInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static Supplier<NoSuchElementException> emptyThrower() {
        return a.INSTANCE;
    }

    public static <T> Iterable<? extends Flowable<T>> iterableToFlowable(Iterable<? extends SingleSource<? extends T>> iterable) {
        return new c(iterable);
    }

    public static <T> Function<SingleSource<? extends T>, Publisher<? extends T>> toFlowable() {
        return b.INSTANCE;
    }
}
