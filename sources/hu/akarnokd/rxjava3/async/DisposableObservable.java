package hu.akarnokd.rxjava3.async;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
public abstract class DisposableObservable<T> extends Observable<T> implements Disposable {
}
