package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.jdk8.FlowableFromCompletionStage;
import java.util.concurrent.CompletionStage;
import java.util.function.BiConsumer;
public final class SingleFromCompletionStage<T> extends Single<T> {
    public final CompletionStage<T> a;

    public static final class a<T> implements Disposable, BiConsumer<T, Throwable> {
        public final SingleObserver<? super T> a;
        public final FlowableFromCompletionStage.a<T> b;

        public a(SingleObserver<? super T> singleObserver, FlowableFromCompletionStage.a<T> aVar) {
            this.a = singleObserver;
            this.b = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.function.BiConsumer
        public void accept(Object obj, Throwable th) {
            Throwable th2 = th;
            if (th2 != null) {
                this.a.onError(th2);
            } else if (obj != null) {
                this.a.onSuccess(obj);
            } else {
                this.a.onError(new NullPointerException("The CompletionStage terminated with null."));
            }
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public void dispose() {
            this.b.set(null);
        }

        @Override // io.reactivex.rxjava3.disposables.Disposable
        public boolean isDisposed() {
            return this.b.get() == null;
        }
    }

    public SingleFromCompletionStage(CompletionStage<T> completionStage) {
        this.a = completionStage;
    }

    @Override // io.reactivex.rxjava3.core.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        FlowableFromCompletionStage.a aVar = new FlowableFromCompletionStage.a();
        a aVar2 = new a(singleObserver, aVar);
        aVar.lazySet(aVar2);
        singleObserver.onSubscribe(aVar2);
        this.a.whenComplete(aVar);
    }
}
