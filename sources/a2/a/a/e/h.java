package a2.a.a.e;

import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.functions.Function;
public final class h<T, R> implements Function<Notification<T>, Notification<T>> {
    public static final h a = new h();

    @Override // io.reactivex.rxjava3.functions.Function
    public Object apply(Object obj) {
        return (Notification) obj;
    }
}
