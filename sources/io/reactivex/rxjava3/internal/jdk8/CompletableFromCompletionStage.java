package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.jdk8.FlowableFromCompletionStage;
import java.util.concurrent.CompletionStage;
import java.util.function.BiConsumer;
public final class CompletableFromCompletionStage<T> extends Completable {
    public final CompletionStage<T> a;

    public static final class a<T> implements Disposable, BiConsumer<T, Throwable> {
        public final CompletableObserver a;
        public final FlowableFromCompletionStage.a<T> b;

        public a(CompletableObserver completableObserver, FlowableFromCompletionStage.a<T> aVar) {
            this.a = completableObserver;
            this.b = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.function.BiConsumer
        public void accept(Object obj, Throwable th) {
            Throwable th2 = th;
            if (th2 != null) {
                this.a.onError(th2);
            } else {
                this.a.onComplete();
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

    public CompletableFromCompletionStage(CompletionStage<T> completionStage) {
        this.a = completionStage;
    }

    @Override // io.reactivex.rxjava3.core.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        FlowableFromCompletionStage.a aVar = new FlowableFromCompletionStage.a();
        a aVar2 = new a(completableObserver, aVar);
        aVar.lazySet(aVar2);
        completableObserver.onSubscribe(aVar2);
        this.a.whenComplete(aVar);
    }
}
