package s6.a.e.d.c.c;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.subjects.Subject;
import java.util.concurrent.atomic.AtomicBoolean;
public final class b<T> extends Observable<T> {
    public final Subject<T> a;
    public final AtomicBoolean b = new AtomicBoolean();

    public b(Subject<T> subject) {
        this.a = subject;
    }

    public boolean e() {
        return !this.b.get() && this.b.compareAndSet(false, true);
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.a.subscribe(observer);
        this.b.set(true);
    }
}
