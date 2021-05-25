package hu.akarnokd.rxjava3.string;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import r6.a.b.m.c;
public final class StringObservable {
    public StringObservable() {
        throw new IllegalStateException("No instances!");
    }

    public static Observable<Integer> characters(CharSequence charSequence) {
        return RxJavaPlugins.onAssembly(new c(charSequence));
    }
}
