package hu.akarnokd.rxjava2.async;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
public abstract class DisposableFlowable<T> extends Flowable<T> implements Disposable {
}
