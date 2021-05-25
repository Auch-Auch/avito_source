package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
public final class ObservableFromCompletionStage<T> extends Observable<T> {
    public final CompletionStage<T> a;

    public static final class a<T> extends AtomicReference<BiConsumer<T, Throwable>> implements BiConsumer<T, Throwable> {
        private static final long serialVersionUID = 45838553147237545L;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.function.BiConsumer
        public void accept(Object obj, Throwable th) {
            Throwable th2 = th;
            BiConsumer biConsumer = (BiConsumer) get();
            if (biConsumer != null) {
                biConsumer.accept(obj, th2);
            }
        }
    }

    public static final class b<T> extends DeferredScalarDisposable<T> implements BiConsumer<T, Throwable> {
        private static final long serialVersionUID = 4665335664328839859L;
        public final a<T> a;

        public b(Observer<? super T> observer, a<T> aVar) {
            super(observer);
            this.a = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.function.BiConsumer
        public void accept(Object obj, Throwable th) {
            Throwable th2 = th;
            if (th2 != null) {
                this.downstream.onError(th2);
            } else if (obj != 0) {
                complete(obj);
            } else {
                this.downstream.onError(new NullPointerException("The CompletionStage terminated with null."));
            }
        }

        @Override // io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable, io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            super.dispose();
            this.a.set(null);
        }
    }

    public ObservableFromCompletionStage(CompletionStage<T> completionStage) {
        this.a = completionStage;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        a aVar = new a();
        b bVar = new b(observer, aVar);
        aVar.lazySet(bVar);
        observer.onSubscribe(bVar);
        this.a.whenComplete(aVar);
    }
}
