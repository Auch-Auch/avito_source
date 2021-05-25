package hu.akarnokd.rxjava2.joins;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import r6.a.a.f.x;
public final class PatternN {
    public final List<Observable<? extends Object>> a;

    public PatternN(List<Observable<? extends Object>> list) {
        this.a = list;
    }

    public PatternN and(Observable<? extends Object> observable) {
        Objects.requireNonNull(observable);
        return new PatternN(this.a, observable);
    }

    public <R> Plan<R> then(Function<? super Object[], R> function) {
        Objects.requireNonNull(function);
        return new x(this, function);
    }

    public PatternN(List<Observable<? extends Object>> list, Observable<? extends Object> observable) {
        ArrayList arrayList = new ArrayList(list);
        this.a = arrayList;
        arrayList.add(observable);
    }
}
