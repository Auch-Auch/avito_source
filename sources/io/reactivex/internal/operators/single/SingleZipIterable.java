package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.internal.operators.single.SingleZipArray;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
public final class SingleZipIterable<T, R> extends Single<R> {
    public final Iterable<? extends SingleSource<? extends T>> a;
    public final Function<? super Object[], ? extends R> b;

    public final class a implements Function<T, R> {
        public a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // io.reactivex.functions.Function
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public R apply(T r4) throws java.lang.Exception {
            /*
                r3 = this;
                io.reactivex.internal.operators.single.SingleZipIterable r0 = io.reactivex.internal.operators.single.SingleZipIterable.this
                io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> r0 = r0.b
                r1 = 1
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r2 = 0
                r1[r2] = r4
                java.lang.Object r4 = r0.apply(r1)
                java.lang.String r0 = "The zipper returned a null value"
                java.lang.Object r4 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r4, r0)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.single.SingleZipIterable.a.apply(java.lang.Object):java.lang.Object");
        }
    }

    public SingleZipIterable(Iterable<? extends SingleSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        this.a = iterable;
        this.b = function;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        SingleSource[] singleSourceArr = new SingleSource[8];
        try {
            Iterator<? extends SingleSource<? extends T>> it = this.a.iterator();
            int i = 0;
            while (it.hasNext()) {
                SingleSource singleSource = (SingleSource) it.next();
                if (singleSource == null) {
                    EmptyDisposable.error(new NullPointerException("One of the sources is null"), singleObserver);
                    return;
                }
                if (i == singleSourceArr.length) {
                    singleSourceArr = (SingleSource[]) Arrays.copyOf(singleSourceArr, (i >> 2) + i);
                }
                int i2 = i + 1;
                singleSourceArr[i] = singleSource;
                i = i2;
            }
            if (i == 0) {
                EmptyDisposable.error(new NoSuchElementException(), singleObserver);
            } else if (i == 1) {
                singleSourceArr[0].subscribe(new SingleMap.a(singleObserver, new a()));
            } else {
                SingleZipArray.b bVar = new SingleZipArray.b(singleObserver, i, this.b);
                singleObserver.onSubscribe(bVar);
                for (int i3 = 0; i3 < i && !bVar.isDisposed(); i3++) {
                    singleSourceArr[i3].subscribe(bVar.c[i3]);
                }
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, singleObserver);
        }
    }
}
