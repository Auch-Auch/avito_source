package hu.akarnokd.rxjava2.async;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
public abstract class DisposableObservable<T> extends Observable<T> implements Disposable {
}
