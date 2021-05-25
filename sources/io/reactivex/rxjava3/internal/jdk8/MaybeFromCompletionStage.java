package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.jdk8.FlowableFromCompletionStage;
import java.util.concurrent.CompletionStage;
import java.util.function.BiConsumer;
public final class MaybeFromCompletionStage<T> extends Maybe<T> {
    public final CompletionStage<T> a;

    public static final class a<T> implements Disposable, BiConsumer<T, Throwable> {
        public final MaybeObserver<? super T> a;
        public final FlowableFromCompletionStage.a<T> b;

        public a(MaybeObserver<? super T> maybeObserver, FlowableFromCompletionStage.a<T> aVar) {
            this.a = maybeObserver;
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

    public MaybeFromCompletionStage(CompletionStage<T> completionStage) {
        this.a = completionStage;
    }

    @Override // io.reactivex.rxjava3.core.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        FlowableFromCompletionStage.a aVar = new FlowableFromCompletionStage.a();
        a aVar2 = new a(maybeObserver, aVar);
        aVar.lazySet(aVar2);
        maybeObserver.onSubscribe(aVar2);
        this.a.whenComplete(aVar);
    }
}
