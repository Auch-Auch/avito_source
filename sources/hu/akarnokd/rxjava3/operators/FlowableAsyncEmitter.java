package hu.akarnokd.rxjava3.operators;

import io.reactivex.rxjava3.annotations.Experimental;
import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.functions.Cancellable;
@Experimental
public interface FlowableAsyncEmitter<T> extends Emitter<T> {
    boolean isCancelled();

    void onNothing();

    boolean replaceCancellable(Cancellable cancellable);

    boolean setCancellable(Cancellable cancellable);
}
