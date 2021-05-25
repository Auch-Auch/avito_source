package com.jakewharton.rxbinding3;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0010B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0003H$¢\u0006\u0004\b\b\u0010\u0007J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00028\u00008$@$X¤\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/jakewharton/rxbinding3/InitialValueObservable;", "T", "Lio/reactivex/Observable;", "Lio/reactivex/Observer;", "observer", "", "subscribeActual", "(Lio/reactivex/Observer;)V", "subscribeListener", "skipInitialValue", "()Lio/reactivex/Observable;", "getInitialValue", "()Ljava/lang/Object;", "initialValue", "<init>", "()V", AuthSource.SEND_ABUSE, "rxbinding_release"}, k = 1, mv = {1, 4, 0})
public abstract class InitialValueObservable<T> extends Observable<T> {

    public final class a extends Observable<T> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // io.reactivex.Observable
        public void subscribeActual(@NotNull Observer<? super T> observer) {
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            InitialValueObservable.this.subscribeListener(observer);
        }
    }

    public abstract T getInitialValue();

    @NotNull
    public final Observable<T> skipInitialValue() {
        return new a();
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(@NotNull Observer<? super T> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        subscribeListener(observer);
        observer.onNext(getInitialValue());
    }

    public abstract void subscribeListener(@NotNull Observer<? super T> observer);
}
