package hu.akarnokd.rxjava2.math;

import hu.akarnokd.rxjava2.util.SelfComparator;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Comparator;
import r6.a.a.g.i;
import r6.a.a.g.j;
public final class MathObservable {
    public MathObservable() {
        throw new IllegalStateException("No instances!");
    }

    public static Observable<Double> averageDouble(ObservableSource<? extends Number> observableSource) {
        return RxJavaPlugins.onAssembly(new ObservableAverageDouble(observableSource));
    }

    public static Observable<Float> averageFloat(ObservableSource<? extends Number> observableSource) {
        return RxJavaPlugins.onAssembly(new ObservableAverageFloat(observableSource));
    }

    public static <T extends Comparable<? super T>> Observable<T> max(ObservableSource<T> observableSource) {
        return max(observableSource, SelfComparator.instance());
    }

    public static <T extends Comparable<? super T>> Observable<T> min(ObservableSource<T> observableSource) {
        return min(observableSource, SelfComparator.instance());
    }

    public static Observable<Double> sumDouble(ObservableSource<Double> observableSource) {
        return RxJavaPlugins.onAssembly(new ObservableSumDouble(observableSource));
    }

    public static Observable<Float> sumFloat(ObservableSource<Float> observableSource) {
        return RxJavaPlugins.onAssembly(new ObservableSumFloat(observableSource));
    }

    public static Observable<Integer> sumInt(ObservableSource<Integer> observableSource) {
        return RxJavaPlugins.onAssembly(new j(observableSource));
    }

    public static Observable<Long> sumLong(ObservableSource<Long> observableSource) {
        return RxJavaPlugins.onAssembly(new ObservableSumLong(observableSource));
    }

    public static <T> Observable<T> max(ObservableSource<T> observableSource, Comparator<? super T> comparator) {
        return RxJavaPlugins.onAssembly(new i(observableSource, comparator, -1));
    }

    public static <T> Observable<T> min(ObservableSource<T> observableSource, Comparator<? super T> comparator) {
        return RxJavaPlugins.onAssembly(new i(observableSource, comparator, 1));
    }
}
