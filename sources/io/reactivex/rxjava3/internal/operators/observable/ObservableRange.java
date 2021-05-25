package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
public final class ObservableRange extends Observable<Integer> {
    public final int a;
    public final long b;

    public static final class a extends BasicIntQueueDisposable<Integer> {
        private static final long serialVersionUID = 396518478098735504L;
        public final Observer<? super Integer> a;
        public final long b;
        public long c;
        public boolean d;

        public a(Observer<? super Integer> observer, long j, long j2) {
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
                return Integer.valueOf((int) j);
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

    public ObservableRange(int i, int i2) {
        this.a = i;
        this.b = ((long) i) + ((long) i2);
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super Integer> observer) {
        a aVar = new a(observer, (long) this.a, this.b);
        observer.onSubscribe(aVar);
        if (!aVar.d) {
            Observer<? super Integer> observer2 = aVar.a;
            long j = aVar.b;
            for (long j2 = aVar.c; j2 != j && aVar.get() == 0; j2++) {
                observer2.onNext(Integer.valueOf((int) j2));
            }
            if (aVar.get() == 0) {
                aVar.lazySet(1);
                observer2.onComplete();
            }
        }
    }
}
