package hu.akarnokd.rxjava3.async;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.Disposable;
public abstract class DisposableFlowable<T> extends Flowable<T> implements Disposable {
}
