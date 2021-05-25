package hu.akarnokd.rxjava2.string;

import io.reactivex.Observable;
import io.reactivex.plugins.RxJavaPlugins;
import r6.a.a.k.c;
public final class StringObservable {
    public StringObservable() {
        throw new IllegalStateException("No instances!");
    }

    public static Observable<Integer> characters(CharSequence charSequence) {
        return RxJavaPlugins.onAssembly(new c(charSequence));
    }
}
