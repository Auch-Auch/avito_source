package hu.akarnokd.rxjava2.operators;

import io.reactivex.Emitter;
import io.reactivex.annotations.Experimental;
import io.reactivex.functions.Cancellable;
@Experimental
public interface FlowableAsyncEmitter<T> extends Emitter<T> {
    boolean isCancelled();

    void onNothing();

    boolean replaceCancellable(Cancellable cancellable);

    boolean setCancellable(Cancellable cancellable);
}
