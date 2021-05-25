package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
public final class ObservableFlatMapStream<T, R> extends Observable<R> {
    public final Observable<T> a;
    public final Function<? super T, ? extends Stream<? extends R>> b;

    public static final class a<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -5127032662980523968L;
        public final Observer<? super R> a;
        public final Function<? super T, ? extends Stream<? extends R>> b;
        public Disposable c;
        public volatile boolean d;
        public boolean e;

        public a(Observer<? super R> observer, Function<? super T, ? extends Stream<? extends R>> function) {
            this.a = observer;
            this.b = function;
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.d = true;
            this.c.dispose();
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.d;
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onComplete() {
            if (!this.e) {
                this.e = true;
                this.a.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onError(@NonNull Throwable th) {
            if (this.e) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.e = true;
            this.a.onError(th);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0045, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            r5.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x004a, code lost:
            r5 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x004b, code lost:
            r0.addSuppressed(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x004e, code lost:
            throw r1;
         */
        @Override // io.reactivex.rxjava3.core.Observer
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(@io.reactivex.rxjava3.annotations.NonNull T r5) {
            /*
                r4 = this;
                boolean r0 = r4.e
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                io.reactivex.rxjava3.functions.Function<? super T, ? extends java.util.stream.Stream<? extends R>> r0 = r4.b     // Catch:{ all -> 0x004f }
                java.lang.Object r5 = r0.apply(r5)     // Catch:{ all -> 0x004f }
                java.lang.String r0 = "The mapper returned a null Stream"
                java.util.Objects.requireNonNull(r5, r0)     // Catch:{ all -> 0x004f }
                java.util.stream.Stream r5 = (java.util.stream.Stream) r5     // Catch:{ all -> 0x004f }
                java.util.Iterator r0 = r5.iterator()     // Catch:{ all -> 0x0043 }
            L_0x0016:
                boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0043 }
                if (r1 == 0) goto L_0x003f
                boolean r1 = r4.d     // Catch:{ all -> 0x0043 }
                r2 = 1
                if (r1 == 0) goto L_0x0024
                r4.e = r2     // Catch:{ all -> 0x0043 }
                goto L_0x003f
            L_0x0024:
                java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0043 }
                java.lang.String r3 = "The Stream's Iterator.next returned a null value"
                java.util.Objects.requireNonNull(r1, r3)     // Catch:{ all -> 0x0043 }
                boolean r3 = r4.d     // Catch:{ all -> 0x0043 }
                if (r3 == 0) goto L_0x0034
                r4.e = r2     // Catch:{ all -> 0x0043 }
                goto L_0x003f
            L_0x0034:
                io.reactivex.rxjava3.core.Observer<? super R> r3 = r4.a     // Catch:{ all -> 0x0043 }
                r3.onNext(r1)     // Catch:{ all -> 0x0043 }
                boolean r1 = r4.d     // Catch:{ all -> 0x0043 }
                if (r1 == 0) goto L_0x0016
                r4.e = r2     // Catch:{ all -> 0x0043 }
            L_0x003f:
                r5.close()
                goto L_0x005b
            L_0x0043:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x0045 }
            L_0x0045:
                r1 = move-exception
                r5.close()     // Catch:{ all -> 0x004a }
                goto L_0x004e
            L_0x004a:
                r5 = move-exception
                r0.addSuppressed(r5)
            L_0x004e:
                throw r1
            L_0x004f:
                r5 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r5)
                io.reactivex.rxjava3.disposables.Disposable r0 = r4.c
                r0.dispose()
                r4.onError(r5)
            L_0x005b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.jdk8.ObservableFlatMapStream.a.onNext(java.lang.Object):void");
        }

        @Override // io.reactivex.rxjava3.core.Observer
        public void onSubscribe(@NonNull Disposable disposable) {
            if (DisposableHelper.validate(this.c, disposable)) {
                this.c = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMapStream(Observable<T> observable, Function<? super T, ? extends Stream<? extends R>> function) {
        this.a = observable;
        this.b = function;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super R> observer) {
        Observable<T> observable = this.a;
        if (observable instanceof Supplier) {
            Stream stream = null;
            try {
                Object obj = ((Supplier) observable).get();
                if (obj != null) {
                    Object apply = this.b.apply(obj);
                    Objects.requireNonNull(apply, "The mapper returned a null Stream");
                    stream = (Stream) apply;
                }
                if (stream != null) {
                    ObservableFromStream.subscribeStream(observer, stream);
                } else {
                    EmptyDisposable.complete(observer);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, observer);
            }
        } else {
            observable.subscribe(new a(observer, this.b));
        }
    }
}
