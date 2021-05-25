package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
public final class ObservableRangeLong extends Observable<Long> {
    public final long a;
    public final long b;

    public static final class a extends BasicIntQueueDisposable<Long> {
        private static final long serialVersionUID = 396518478098735504L;
        public final Observer<? super Long> a;
        public final long b;
        public long c;
        public boolean d;

        public a(Observer<? super Long> observer, long j, long j2) {
            this.a = observer;
            this.c = j;
            this.b = j2;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public void clear() {
            this.c = this.b;
            lazySet(1);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            set(1);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return get() != 0;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.c == this.b;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.SimpleQueue
        @Nullable
        public Object poll() throws Throwable {
            long j = this.c;
            if (j != this.b) {
                this.c = 1 + j;
                return Long.valueOf(j);
            }
            lazySet(1);
            return null;
        }

        @Override // io.reactivex.rxjava3.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            this.d = true;
            return 1;
        }
    }

    public ObservableRangeLong(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Long> observer) {
        long j = this.a;
        a aVar = new a(observer, j, j + this.b);
        observer.onSubscribe(aVar);
        if (!aVar.d) {
            Observer<? super Long> observer2 = aVar.a;
            long j2 = aVar.b;
            for (long j3 = aVar.c; j3 != j2 && aVar.get() == 0; j3++) {
                observer2.onNext(Long.valueOf(j3));
            }
            if (aVar.get() == 0) {
                aVar.lazySet(1);
                observer2.onComplete();
            }
        }
    }
}
