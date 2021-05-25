package r6.a.a.k;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
public final class c extends Observable<Integer> {
    public final CharSequence a;

    public static final class a extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = -4762798297183704664L;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            lazySet(true);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }
    }

    public c(CharSequence charSequence) {
        this.a = charSequence;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Integer> observer) {
        a aVar = new a();
        observer.onSubscribe(aVar);
        CharSequence charSequence = this.a;
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!aVar.get()) {
                observer.onNext(Integer.valueOf(charSequence.charAt(i)));
            } else {
                return;
            }
        }
        if (!aVar.get()) {
            observer.onComplete();
        }
    }
}
